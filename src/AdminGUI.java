import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Brian on 2017-04-04.
 */
public class AdminGUI extends PassengerGUI implements ListSelectionListener
{
    private JButton addFlightButton, addFlightsFromFileButton, searchButton, cancelTicket;
    private JPanel MainPanel, PanelTwo_Three, PanelFour, PanelFour_One, PanelFour_Two;
    private JLabel FlightID, FlightSource, FlightDest, ViewTickets, SearchResults;
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

    class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == addFlightButton)
            {
                System.out.println("Yeet");
            }

            else if (e.getSource() == addFlightsFromFileButton)
            {

                String fileName = JOptionPane.showInputDialog("Enter the file name: ");

                if(!fileName.endsWith(".txt"))
                {
                    fileName += ".txt";
                }

                File f = new File(fileName);

                //Read from file and store it into the array list in teh following style
                //  ADDFLIGHT src  dest  date  time  dur  totalSeats  leftSeats  price
                // If a flight does not meet standards, don't add and print out a JOptionPane or something
                //                                       (Your choice, either break or just don't add it but add the rest)
                ArrayList<String> toBeSent = new ArrayList<String>();
                try {
                    Scanner scan = new Scanner(f);
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



                //Send the instruction for all the good entries
                for(int i = 0; i < toBeSent.size(); i++){
                    Global.toGo = toBeSent.get(i);
                }
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
            }

            else if (e.getSource() == cancelTicket) {
                // I'm assuming that the ID is the first value in the ticket info
                String temp = "CANCELTICKET\t";
                if (searchResultsTickets.getSelectedIndex() != -1) {
                    String info = searchResultsTickets.getSelectedValue();
                    String[] data = info.split(" ");
                    temp += data[1] + "\t";
                    temp += data[3];
                    Global.toGo = temp;
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please select a ticket.");
                }
            }
        }
    }

    public void valueChanged(ListSelectionEvent e)
    {
        if (!e.getValueIsAdjusting())
        {
            JList list = (JList) e.getSource();
            if (searchResultsTickets.getSelectedIndex() == -1)
            {
            } else if (list.getName().equals("Flights")){
                /*
                int index = searchResultsTickets.getSelectedIndex();
                JList list = (JList) e.getSource();
                Object objSelectedDatabase = list.getModel().getElementAt(index);
                JList list = (JList) e.getSource();

                int iSelectedDatabase = list.getSelectedIndex();
                Object objSelectedDatabase = list.getModel().getElementAt(iSelectedDatabase);
                String sSelectedDatabase = objSelectedDatabase.toString();
                System.out.println(sSelectedDatabase);
                //System.out.println(list.getModel());
                System.out.println(list.getName());
                */
                super.valueChanged(e);
            } else if (list.getName().equals("Tickets"))
            {
                // Do nothing if they click on a ticket
                System.out.println("Ticket " + String.valueOf(list.getSelectedIndex()));
            }
        }
    }

    private void setTickets(ArrayList<Ticket> tickets)
    {
        for (int i = 0; i < tickets.size(); i++)
        {
            listModel.clear();
            listModel.addElement(tickets.get(i));
        }
    }

    void setTicketReference(ArrayList<Ticket> tickets)
    {
        this.tickets = tickets;
        this.setTickets(tickets);
    }

    public AdminGUI()
    {
        super();
        for (int i = 0; i < 500; i++)
        {
            listModel.insertElementAt(new Ticket(i, i, "FN", "LN", "DOB", "SRC", "DEST", "asdf", "TIME", "DUR", 0.0), i);
        }
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
        FlightSource = new JLabel();
        FlightSource.setText("Flight Source");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 0, 10, 10);
        PanelFour_One.add(FlightSource, gbc);
        FlightDest = new JLabel();
        FlightDest.setText("Flight Destination");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 0, 10, 10);
        PanelFour_One.add(FlightDest, gbc);
        TFRR2 = new JTextField();
        TFRR2.setColumns(15);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        PanelFour_One.add(TFRR2, gbc);
        TFRR3 = new JTextField();
        TFRR3.setColumns(15);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
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
        gbc.gridy = 5;
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
        gbc.ipady = 265;
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
        addFlightButton.addActionListener(listener);
        addFlightsFromFileButton.addActionListener(listener);
        searchButton.addActionListener(listener);
        cancelTicket.addActionListener(listener);
        searchResultsTickets.setName("Tickets");
    }
}
