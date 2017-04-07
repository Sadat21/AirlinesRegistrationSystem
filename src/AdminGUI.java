import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Created by Brian on 2017-04-04.
 */
public class AdminGUI extends PassengerGUI implements ListSelectionListener
{
    private JButton addFlightButton, addFlightsFromFileButton, searchButton, cancelTicket;
    private JPanel MainPanel, PanelTwo_Three, PanelFour, PanelFour_One, PanelFour_Two;
    private JLabel FlightID, FlightSource, FlightDest, ViewTickets, SearchResults, OR;
    private JTextField TFRR1, TFRR2, TFRR3;
    private JSeparator Sep12, Sep13;
    private GridBagConstraints gbc;
    private JList<String> searchResultsTickets;
    private DefaultListModel<Ticket> listModel = new DefaultListModel<>();
    protected ArrayList<Ticket> tickets;
    private JScrollPane ScrollPane;
    private Listener listener;

    public static void main(String[] args)
    {
        try {
            UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        AdminGUI test = new AdminGUI();
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setVisible(true);
    }

    class Listener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == addFlightButton)
            {
                //JFrame temp = new JFrame();
                AddFlightPanel temp = new AddFlightPanel();
                //temp.add(getPanelThree());
                //temp.setSize(270, 470);
                temp.setVisible(true);
            }

            else if(e.getSource() == clearButton)
            {
                TFL1.setText("");
                TFL2.setText("");
                TFL3.setText("");
                TFL4.setText("");
                monthCB.setSelectedItem("-");
                dayCB.setSelectedItem("-");
                yearCB.setSelectedItem("-");
                monthDDCB.setSelectedItem("-");
                dayDDCB.setSelectedItem("-");
                yearDDCB.setSelectedItem("-");
                listModel.clear();
                TFR1.setText("");
                TFR2.setText("");
                TFR3.setText("");
                TFR4.setText("");
                TFR5.setText("");
                TFR6.setText("");
                TFR7.setText("");
                TFR8.setText("");
                TFR9.setText("");
                TFR10.setText("");
                TFRR1.setText("");
                TFRR2.setText("");
                TFRR3.setText("");
            }

            else if (e.getSource() == addFlightsFromFileButton)
            {

                String fileName = JOptionPane.showInputDialog("Enter the file name: ");

                if(!fileName.endsWith(".txt"))
                {
                    fileName += ".txt";
                }

                File f = new File(fileName);
                PrintWriter out = null;
                Scanner scan = null;
                try {
                    out = new PrintWriter(new File("errors.txt"));
                }
                catch (FileNotFoundException ex)
                {
                    JOptionPane.showMessageDialog(null, "Error occured while creating output file");
                    out.close();
                    return;
                }
                //Read from file and store it into the array list in teh following style
                //  ADDFLIGHT src  dest  date  time  dur  totalSeats  leftSeats  price
                // If a flight does not meet standards, don't add and print out a JOptionPane or something
                //                                       (Your choice, either break or just don't add it but add the rest)
                ArrayList<String> toBeSent = new ArrayList<String>();

                try {
                    scan = new Scanner(f);
                    while(scan.hasNext())
                    {
                        toBeSent.add(scan.nextLine());
                    }
                }
                catch(FileNotFoundException ex)
                {
                    JOptionPane.showMessageDialog(null, "File cannot be found in this directory!");
                    return;
                }
                finally
                {
                    scan.close();
                }

                int size = toBeSent.size();
                for(int i = 0; i < toBeSent.size(); i++)
                {
                    boolean error = flightErrorCheck(toBeSent.get(i), out, true);

                    if(error)
                    {
                        String faulty = toBeSent.remove(i);
                        out.println(faulty);
                        out.println();
                        i--;
                    }
                }

                //Send the instruction for all the good entries
                for(int i = 0; i < toBeSent.size(); i++)
                {
                    for( int j = 0; j < 10000; j++){
                        System.out.print("");
                    }
                    String query = "ADDFLIGHT" + "\t" + toBeSent.get(i);
                    Global.toGo = query;
                    System.out.println(query);
                }

                if(toBeSent.size() != size)
                {
                    JOptionPane.showMessageDialog(null, "Errors occured while taking inputs," +
                            " see the 'errors.txt' file in the directory to see the faulty flight inputs");
                }

                else
                {
                    out.println("No errors found");
                    JOptionPane.showMessageDialog(null, "All flights added successfully!");
                }
                out.close();
            }

            else if (e.getSource() == searchButton) {
                String ID = TFRR1.getText();
                String src = TFRR2.getText();
                String dst = TFRR3.getText();

                for (int i = 0; i < ID.length(); i++) {
                    if ((ID.charAt(i) < 48) || (ID.charAt(i) > 57)) {
                        JOptionPane.showMessageDialog(null, "Flight ID must be a number");
                        return;
                    }
                }

                int counter = 0;
                if (ID.equals("")) {
                    ID = "-1";
                    counter++;
                }

                if (src.equals("")) {
                    src = "-1";
                    counter++;
                }

                if (dst.equals("")) {
                    dst = "-1";
                    counter++;
                }

                if (counter == 3) {
                    JOptionPane.showMessageDialog(null, "Please enter the required information into the 'View Ticket' text fields");
                    return;
                }

                String temp = "SEARCHTICKET\t" + ID + "\t" + src + "\t" + dst;
                System.out.println(temp);
                Global.toGo = temp;
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (Exception exp) {
                    exp.getStackTrace();
                }
                displayTickets();
            }

            else if (e.getSource() == cancelTicket) {
                // I'm assuming that the ID is the first value in the ticket info
                String temp = "CANCELTICKET\t";
                int index = searchResultsTickets.getSelectedIndex();
                if (index != -1) {
                    int dialogButton = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this ticket?");
                    if(dialogButton == JOptionPane.YES_OPTION) {
                        Ticket t = listModel.elementAt(index);
                        temp += t.getId();
                        temp += "\t";
                        temp += t.getFlightID();
                        System.out.println(temp);
                        Global.toGo = temp;
                        listModel.remove(index);
                        searchResultsTickets.ensureIndexIsVisible(0);
                        searchResultsTickets.setSelectedIndex(0);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "No ticket to delete.");
                }
            }
        }
    }

    private class AddFlightPanel extends JFrame
    {
        private JPanel FIPanel;
        private JLabel FlightInfo;
        private JSeparator Sep3;
        private JLabel LabelR2, LabelR3, LabelR4, LabelR5, LabelR6, LabelR7, LabelR8, LabelR9;
        private JTextField TFR2, TFR3, TFR4, TFR5, TFR6, TFR7, TFR8, TFR9;
        private GridBagConstraints gbc;
        private Container c;
        private JButton addFlight, clear;
        private innerlistener listen;

        public AddFlightPanel()
        {
            setTitle("Add Flight Panel");
            setSize(300, 520);
            c = getContentPane();
            listen = new innerlistener();
            FIPanel = new JPanel();
            FIPanel.setLayout(new GridBagLayout());
            c.add(FIPanel);
            FlightInfo = new JLabel();
            FlightInfo.setFont(new Font(FlightInfo.getFont().getName(), Font.BOLD, 24));
            FlightInfo.setText("Add Flight Information");
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 3;
            FIPanel.add(FlightInfo, gbc);
            LabelR2 = new JLabel();
            LabelR2.setText("From");
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.insets = new Insets(10, 0, 10, 10);
            FIPanel.add(LabelR2, gbc);
            TFR2 = new JTextField();
            TFR2.setColumns(10);
            gbc = new GridBagConstraints();
            gbc.gridx = 2;
            gbc.gridy = 3;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            FIPanel.add(TFR2, gbc);
            LabelR3 = new JLabel();
            LabelR3.setText("To");
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 4;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.insets = new Insets(10, 0, 10, 10);
            FIPanel.add(LabelR3, gbc);
            TFR3 = new JTextField();
            TFR3.setColumns(10);
            gbc = new GridBagConstraints();
            gbc.gridx = 2;
            gbc.gridy = 4;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            FIPanel.add(TFR3, gbc);
            LabelR4 = new JLabel();
            LabelR4.setText("Date");
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 5;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.insets = new Insets(10, 0, 10, 10);
            FIPanel.add(LabelR4, gbc);
            LabelR5 = new JLabel();
            LabelR5.setText("Time");
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 6;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.insets = new Insets(10, 0, 10, 10);
            FIPanel.add(LabelR5, gbc);
            LabelR6 = new JLabel();
            LabelR6.setText("Duration");
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 7;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.insets = new Insets(10, 0, 10, 10);
            FIPanel.add(LabelR6, gbc);
            LabelR7 = new JLabel();
            LabelR7.setText("Total Seats");
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 8;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.insets = new Insets(10, 0, 10, 10);
            FIPanel.add(LabelR7, gbc);
            LabelR8 = new JLabel();
            LabelR8.setText("Remaining Seats");
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 9;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.insets = new Insets(10, 0, 10, 10);
            FIPanel.add(LabelR8, gbc);
            LabelR9 = new JLabel();
            LabelR9.setText("Price");
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 10;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.insets = new Insets(10, 0, 10, 10);
            FIPanel.add(LabelR9, gbc);
            TFR4 = new JTextField();
            TFR4.setColumns(10);
            gbc = new GridBagConstraints();
            gbc.gridx = 2;
            gbc.gridy = 5;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            FIPanel.add(TFR4, gbc);
            TFR5 = new JTextField();
            TFR5.setColumns(10);
            gbc = new GridBagConstraints();
            gbc.gridx = 2;
            gbc.gridy = 6;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            FIPanel.add(TFR5, gbc);
            TFR6 = new JTextField();
            TFR6.setColumns(10);
            gbc = new GridBagConstraints();
            gbc.gridx = 2;
            gbc.gridy = 7;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            FIPanel.add(TFR6, gbc);
            TFR7 = new JTextField();
            TFR7.setColumns(10);
            gbc = new GridBagConstraints();
            gbc.gridx = 2;
            gbc.gridy = 8;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            FIPanel.add(TFR7, gbc);
            TFR8 = new JTextField();
            TFR8.setColumns(10);
            gbc = new GridBagConstraints();
            gbc.gridx = 2;
            gbc.gridy = 9;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            FIPanel.add(TFR8, gbc);
            TFR9 = new JTextField();
            TFR9.setColumns(10);
            gbc = new GridBagConstraints();
            gbc.gridx = 2;
            gbc.gridy = 10;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            FIPanel.add(TFR9, gbc);
            Sep3 = new JSeparator();
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 3;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.insets = new Insets(10, 0, 10, 0);
            FIPanel.add(Sep3, gbc);
            addFlight = new JButton("Add Flight");
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 12;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.insets = new Insets(10, 0, 10, 10);
            FIPanel.add(addFlight, gbc);
            clear = new JButton("Clear");
            gbc = new GridBagConstraints();
            gbc.gridx = 2;
            gbc.gridy = 12;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.insets = new Insets(10, 0, 10, 10);
            FIPanel.add(clear, gbc);
            addFlight.addActionListener(listen);
            clear.addActionListener(listen);
        }

        class innerlistener implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (e.getSource() == clear)
                {
                    TFR2.setText("");
                    TFR3.setText("");
                    TFR4.setText("");
                    TFR5.setText("");
                    TFR6.setText("");
                    TFR7.setText("");
                    TFR8.setText("");
                    TFR9.setText("");
                }

                else if (e.getSource() == addFlight) {
                    String inputs = TFR2.getText();
                    inputs += "\t";
                    inputs += TFR3.getText();
                    inputs += "\t";
                    inputs += TFR4.getText();
                    inputs += "\t";
                    inputs += TFR5.getText();
                    inputs += "\t";
                    inputs += TFR6.getText();
                    inputs += "\t";
                    inputs += TFR7.getText();
                    inputs += "\t";
                    inputs += TFR8.getText();
                    inputs += "\t";
                    inputs += TFR9.getText();

                    boolean error = flightErrorCheck(inputs, null, false);
                    if (!error) {
                        String temp = "ADDFLIGHT" + "\t" + inputs;
                        System.out.println(temp);
                        Global.toGo = temp;
                        JOptionPane.showMessageDialog(null, "Flight successfully added.");
                        // TODO: Close the panel after adding a flight.
                    }
                }
            }
        }
    }

    public void valueChanged(ListSelectionEvent e)
    {
        if (!e.getValueIsAdjusting())
        {
            //System.out.println("Point 1");
            JList list = (JList) e.getSource();
            //System.out.println(list.getName());
            if (list.getName().equals("Flights")){
                //System.out.println("Point 2");
                super.valueChanged(e);
            } else if (list.getName().equals("Tickets"))
            {
                //System.out.println("Point 3");
                //System.out.println("Ticket " + String.valueOf(list.getSelectedIndex()));
            }
        }
    }

    public boolean flightErrorCheck(String input, PrintWriter out, boolean enable)
    {
        String[] temp = input.split("\t");

        if (temp.length != 8) {
            if(enable) {
                out.println("Not enough inputs provided");
            }
            else {
                JOptionPane.showMessageDialog(null, "Not enough inputs provided");
            }
            return true;
        }

        for (int j = 0; j < temp.length; j++) {
            if (temp[j].equals("")) {
                if (enable) {
                    out.println("There is an issue with the formatting of the data");
                } else {
                    JOptionPane.showMessageDialog(null, "There is an issue with the formatting of the data");
                    return true;
                }
            }
        }

        if ((temp[0].length() > 20) || (temp[1].length() > 20)) {
            if(enable) {
                out.println("Source and/or destination strings are too long");
            }
            else {
                JOptionPane.showMessageDialog(null, "Source and/or destination strings are too long");
            }
            return true;
        }

        if (temp[2].length() > 10) {
            if(enable) {
                out.println("Date is formatted incorrectly. Should be MM/dd/yyyy");
            }
            else {
                JOptionPane.showMessageDialog(null, "Date is formatted incorrectly. Should be MM/dd/yyyy");
            }
            return true;
        }

        if ((temp[3].length() > 5) || (temp[4].length() > 8)) {
            if(enable) {
                out.println("Time and/or duration are too long");
            }
            else {
                JOptionPane.showMessageDialog(null, "Time and/or date are too long");
            }
            return true;
        }

        if (!temp[3].matches("([01]?[0-9]|2[0-3]):([0-5][0-9])")) {
            if(enable) {
                out.println("Time is formatted incorrectly. Should be HH:mm");
            }
            else {
                JOptionPane.showMessageDialog(null, "Time is formatted incorrectly. Should be HH:mm");
            }
            return true;
        }

        if (!temp[4].matches("([0-9]{2}):([01]?[0-9]|2[0-3]):([0-5][0-9])")) {
            if(enable) {
                out.println("Duration is formatted incorrectly. Should be dd:HH:mm");
            }
            else {
                JOptionPane.showMessageDialog(null, "Duration is formatted incorrectly. Should be dd:HH:mm");
            }
            return true;
        }

        try {
            int seats = Integer.parseInt(temp[5]);
            int seatsLeft = Integer.parseInt(temp[6]);
            if (seats < seatsLeft) {
                if (enable) {
                    out.println("There are more 'seats left' than total seats");
                } else {
                    JOptionPane.showMessageDialog(null, "There are more 'seats left' than total seats");
                }
                return true;
            }
            if (seats <= 0 || seatsLeft < 0) {
                if (enable) {
                    out.println("The total number of seats and/or the remaining seats isn't a positive integer");
                } else {
                    JOptionPane.showMessageDialog(null, "The total number of seats and/or the remaining seats isn't a positive integer");
                }
                return true;
            }
        }
        catch (NumberFormatException ex) {
            if(enable) {
                out.println("Either total seats or seats remaining is not an integer");
            }
            else {
                JOptionPane.showMessageDialog(null, "Either total seats or seats remaining is not an integer");
            }
            return true;
        }

        try
        {
            Double price = Double.parseDouble(temp[7]);
            if (price < 0) {
                if(enable) {
                    out.println("The price is a negative value");
                }
                else {
                    JOptionPane.showMessageDialog(null, "The price is a negative value");
                }
                return true;
            }
        }
        catch (NumberFormatException ex) {
            if(enable) {
                out.println("Price is not a double");
            }
            else {
                JOptionPane.showMessageDialog(null, "Price is not a double");
            }
            return true;
        }

        if (temp[7].charAt(temp[7].length() - 3) != '.') {
            if(enable) {
                out.println("The price must have two digits after the decimal");
            }
            else {
                JOptionPane.showMessageDialog(null, "The price must have two digits after the decimal");
            }
            return true;
        }

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date depart;
        try {
            depart = df.parse(temp[2]);
            if (!temp[2].equals(df.format(depart))) {
                if(enable) {
                    out.println("There is an issue with the formatting of the date. Should be MM/dd/yyyy");
                }
                else {
                    JOptionPane.showMessageDialog(null, "There is an issue with the formatting of the date. Should be MM/dd/yyyy");
                }
                return true;
            }
            Date curr = new Date();
            if (curr.compareTo(depart) > 0) {
                if(enable) {
                    out.println("The inputted departure date has already passed");
                }
                else {
                    JOptionPane.showMessageDialog(null, "The inputted departure date has already passed");
                }
                return true;
            }
        }
        catch (ParseException ex) {
            if(enable) {
                out.println("Unknown error occured while parsing the 'Date' text field");
            }
            else {
                JOptionPane.showMessageDialog(null, "Unknown error occured while parsing the 'Date' text field");
            }
            return true;
        }

        return false;
    }

    private void displayTickets()
    {
        //System.out.println("Point 2");
        //System.out.println(flights.size());
        listModel.clear();
        for (int i = 0; i < tickets.size(); i++)
        {
            listModel.addElement(tickets.get(i));
        }
        if(listModel.size() == 0)
        {
            JOptionPane.showMessageDialog(null, "No tickets found");
        }
        searchResultsTickets.ensureIndexIsVisible(0);
        //System.out.println(listModel.size());
        //System.out.println("Point 3");

    }

    public AdminGUI()
    {
        super();
        listener = new Listener();
        setTitle("Admin Client Program");
        setSize(1400, 680);
        MainPanel = getMainPanel();
        PanelTwo_Three = getPanelTwo_Three();
        addFlightButton = new JButton();
        addFlightButton.setText("Add Flight");
        PanelTwo_Three.add(addFlightButton);
        addFlightsFromFileButton = new JButton();
        addFlightsFromFileButton.setText("Add Flights from File");
        PanelTwo_Three.add(addFlightsFromFileButton);
        Sep12 = new JSeparator();
        Sep12.setOrientation(1);
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.ipady = 500;
        gbc.insets = new Insets(0, 10, 0, 10);
        MainPanel.add(Sep12, gbc);
        PanelFour = new JPanel();
        PanelFour.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        MainPanel.add(PanelFour, gbc);
        PanelFour_One = new JPanel();
        PanelFour_One.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);
        PanelFour.add(PanelFour_One, gbc);
        FlightID = new JLabel();
        FlightID.setText("Flight ID");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 0, 10, 10);
        PanelFour_One.add(FlightID, gbc);
        OR = new JLabel();
        OR.setFont(new Font(OR.getFont().getName(), Font.BOLD, 16));
        OR.setText("OR");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        PanelFour_One.add(OR, gbc);
        FlightSource = new JLabel();
        FlightSource.setText("Flight Source");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 0, 10, 10);
        PanelFour_One.add(FlightSource, gbc);
        FlightDest = new JLabel();
        FlightDest.setText("Flight Destination");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 0, 10, 10);
        PanelFour_One.add(FlightDest, gbc);
        TFRR2 = new JTextField();
        TFRR2.setColumns(15);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
        PanelFour_One.add(TFRR2, gbc);
        TFRR3 = new JTextField();
        TFRR3.setColumns(15);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 5;
        PanelFour_One.add(TFRR3, gbc);
        TFRR1 = new JTextField();
        TFRR1.setColumns(15);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        PanelFour_One.add(TFRR1, gbc);
        ViewTickets = new JLabel();
        ViewTickets.setFont(new Font(ViewTickets.getFont().getName(), Font.BOLD, 24));
        ViewTickets.setText("View Tickets");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        PanelFour_One.add(ViewTickets, gbc);
        Sep13 = new JSeparator();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 0, 10, 0);
        PanelFour_One.add(Sep13, gbc);
        searchButton = new JButton();
        searchButton.setText("Search");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.insets = new Insets(10, 0, 0, 0);
        PanelFour_One.add(searchButton, gbc);
        PanelFour_Two = new JPanel();
        PanelFour_Two.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 10, 10, 10);
        PanelFour.add(PanelFour_Two, gbc);
        searchResultsTickets = new JList(listModel);
        searchResultsTickets.setSelectedIndex(0);
        searchResultsTickets.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        searchResultsTickets.setLayoutOrientation(JList.VERTICAL);
        ScrollPane = new JScrollPane(searchResultsTickets);
        ScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 7;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.ipadx = 300;
        gbc.ipady = 245;
        gbc.insets = new Insets(0, 0, 10, 0);
        PanelFour_Two.add(ScrollPane, gbc);
        SearchResults = new JLabel();
        SearchResults.setFont(new Font(SearchResults.getFont().getName(), Font.BOLD, 12));
        SearchResults.setText("Search Results");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 7;
        gbc.anchor = GridBagConstraints.WEST;
        PanelFour_Two.add(SearchResults, gbc);
        cancelTicket = new JButton();
        cancelTicket.setText("Cancel Selected Ticket");
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 2;
        PanelFour_Two.add(cancelTicket, gbc);
        getPassFlightProg().setText("Administrator Flight Program");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        MainPanel.add(getPassFlightProg(), gbc);
        JSeparator TopSep = new JSeparator();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 6;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 0, 10, 0);
        MainPanel.add(TopSep, gbc);
        searchResultsTickets.addListSelectionListener(this);
        clearButton.addActionListener(listener);
        addFlightButton.addActionListener(listener);
        addFlightsFromFileButton.addActionListener(listener);
        searchButton.addActionListener(listener);
        cancelTicket.addActionListener(listener);
        searchResultsTickets.setName("Tickets");
    }
}