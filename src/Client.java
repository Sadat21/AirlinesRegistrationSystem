import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;


/**
 * @author brain
 * @version 1.0
 * @since 4/1/2017
 */
public class Client implements ConnectionConstants {

    protected Socket mySocket;
    protected ObjectInputStream socketIn;
    protected PrintWriter socketOut;

    protected ArrayList<Flight> flights;
    protected ArrayList<Ticket> tickets;
    protected Ticket myTicket;
    protected String data;
    protected LoginGUI login;

    public Client(){
        try {
            flights = new ArrayList<>();
            tickets = new ArrayList<>();
            //login = new LoginGUI();
            data = DEFAULT;
            mySocket = new Socket(HOST, PORT);
            socketIn = new ObjectInputStream(mySocket.getInputStream());
            socketOut = new PrintWriter(mySocket.getOutputStream(), true);
            System.out.println("Connection Made");

        } catch (IOException e) {
            System.err.println("Error initializing Client Socket");
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void communicate(){

        System.out.println("Ready for use...");
        String line = "";
        boolean running = true;
        while(running){
            //Communicate with server
            System.out.print("");
            if (!Global.toGo.equals(DEFAULT)) {
                String [] temp = Global.toGo.split("\t");
                System.out.println(temp);
                socketOut.println(Global.toGo);

                if(temp[0].equals("GETFLIGHTS")) {
                    try {
                        flights = (ArrayList<Flight>) socketIn.readObject();
                        System.out.println(flights.toString());
                    } catch (IOException e) {
                        System.err.println("Error reading serialized Flight array");
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        System.err.println("Error reading serialized Flight array (determining class)");
                        e.printStackTrace();
                    }
                }
                else if(temp[0].equals("SEARCHTICKET")){
                    try {
                        tickets = (ArrayList<Ticket>) socketIn.readObject();
                        System.out.println(tickets.toString());
                    } catch (IOException e) {
                        System.err.println("Error reading serialized Ticket array");
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        System.err.println("Error reading serialized Ticket array (determining class)");
                        e.printStackTrace();
                    }
                }
                else if(temp[0].equals("BOOKFLIGHT")){
                    try {
                        Ticket worked = (Ticket)socketIn.readObject();
                        if(worked == null){
                            JOptionPane.showMessageDialog(null, "Sorry the Flight is full.",
                                    "Max Capacity", JOptionPane.PLAIN_MESSAGE);

                        }else {
                            JOptionPane.showMessageDialog(null, "Ticket Booked!",
                                    "Success", JOptionPane.PLAIN_MESSAGE);
                            myTicket = worked;
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                        System.exit(1);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }

                Global.toGo = DEFAULT;
                System.out.println("Got it");
                System.out.println("");
            }
        }
        try {
            socketIn.close();
            socketOut.close();
        } catch (IOException e) {
            System.out.println("closing error: " + e.getMessage());
        }
    }

    public String getData()
    {
        return data;
    }

    public static void main(String[] args)
    {
        Client test = new Client();
        //test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //test.setVisible(true);
    }


    private class LoginGUI extends JFrame
    {
        private JPanel MainPanel;
        private JButton Sign_InButton;
        private JLabel TitleLabel;
        private JTextField TFR1;
        private JPasswordField TFR2;
        private JPanel PanelTwo;
        private JPanel PasswordPanel;
        private JPanel SignInButtonPanel;
        private JPanel TitlePanel;
        private JPanel PanelOne;
        private JPanel SignUpButtonPanel;
        private JComboBox comboBox;
        private JLabel LabelL1;
        private JLabel LabelL2;
        private JLabel LabelL3;
        private JTextField TFL1;
        private JPasswordField TFL2;
        private JPasswordField TFL3;
        private JLabel LabelR1;
        private JLabel LabelR2;
        private JButton Sign_UpButton;
        private JSeparator JSep1;
        private JSeparator JSep2;
        private Container c;

        public LoginGUI() {
            setTitle("Client Manager");
            setSize(616, 370);
            c = getContentPane();
            //listener = new PassengerGUI.Listener();
            MainPanel = new JPanel();
            MainPanel.setLayout(new GridBagLayout());
            c.add(MainPanel);
            PanelOne = new JPanel();
            PanelOne.setLayout(new GridBagLayout());
            GridBagConstraints gbc;
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.insets = new Insets(10, 10, 10, 10);
            MainPanel.add(PanelOne, gbc);
            SignUpButtonPanel = new JPanel();
            SignUpButtonPanel.setLayout(new GridBagLayout());
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.fill = GridBagConstraints.BOTH;
            PanelOne.add(SignUpButtonPanel, gbc);
            LabelL2 = new JLabel();
            LabelL2.setText("Password");
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(10, 0, 10, 10);
            SignUpButtonPanel.add(LabelL2, gbc);
            LabelL1 = new JLabel();
            LabelL1.setText("Username");
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(10, 0, 10, 10);
            PanelOne.add(LabelL1, gbc);
            TFL1 = new JTextField();
            TFL1.setColumns(20);
            gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 0;
            PanelOne.add(TFL1, gbc);
            TFL2 = new JPasswordField();
            TFL2.setColumns(20);
            gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 1;
            PanelOne.add(TFL2, gbc);
            LabelL3 = new JLabel();
            LabelL3.setText("Reenter Password");
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.insets = new Insets(10, 0, 10, 10);
            PanelOne.add(LabelL3, gbc);
            TFL3 = new JPasswordField();
            TFL3.setColumns(20);
            gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 2;
            PanelOne.add(TFL3, gbc);
            Sign_UpButton = new JButton();
            Sign_UpButton.setText("Sign Up");
            gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 4;
            gbc.insets = new Insets(10, 10, 10, 10);
            PanelOne.add(Sign_UpButton, gbc);
            comboBox = new JComboBox();
            gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 3;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            PanelOne.add(comboBox, gbc);
            TitlePanel = new JPanel();
            TitlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 3;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.insets = new Insets(10, 10, 10, 10);
            MainPanel.add(TitlePanel, gbc);
            TitleLabel = new JLabel();
            TitleLabel.setEnabled(true);
            TitleLabel.setFont(new Font(TitleLabel.getFont().getName(), Font.BOLD, 36));
            TitleLabel.setText("Sign In/Up Panel");
            TitlePanel.add(TitleLabel);
            PanelTwo = new JPanel();
            PanelTwo.setLayout(new GridBagLayout());
            gbc = new GridBagConstraints();
            gbc.gridx = 2;
            gbc.gridy = 2;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.insets = new Insets(10, 10, 10, 10);
            MainPanel.add(PanelTwo, gbc);
            PasswordPanel = new JPanel();
            PasswordPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
            gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.fill = GridBagConstraints.BOTH;
            PanelTwo.add(PasswordPanel, gbc);
            SignInButtonPanel = new JPanel();
            SignInButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
            gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 2;
            gbc.fill = GridBagConstraints.BOTH;
            PanelTwo.add(SignInButtonPanel, gbc);
            LabelR1 = new JLabel();
            LabelR1.setText("Username");
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(10, 0, 10, 10);
            PanelTwo.add(LabelR1, gbc);
            TFR1 = new JTextField();
            TFR1.setColumns(20);
            gbc = new GridBagConstraints();
            gbc.gridx = 2;
            gbc.gridy = 0;
            PanelTwo.add(TFR1, gbc);
            LabelR2 = new JLabel();
            LabelR2.setText("Password");
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.insets = new Insets(10, 0, 10, 10);
            PanelTwo.add(LabelR2, gbc);
            TFR2 = new JPasswordField();
            TFR2.setColumns(20);
            gbc = new GridBagConstraints();
            gbc.gridx = 2;
            gbc.gridy = 1;
            PanelTwo.add(TFR2, gbc);
            Sign_InButton = new JButton();
            Sign_InButton.setText("Sign In");
            gbc = new GridBagConstraints();
            gbc.gridx = 2;
            gbc.gridy = 2;
            gbc.insets = new Insets(10, 10, 10, 10);
            PanelTwo.add(Sign_InButton, gbc);
            JSep1 = new JSeparator();
            JSep1.setOrientation(1);
            gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 2;
            gbc.fill = GridBagConstraints.BOTH;
            MainPanel.add(JSep1, gbc);
            JSep2 = new JSeparator();
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 3;
            gbc.fill = GridBagConstraints.BOTH;
            MainPanel.add(JSep2, gbc);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }
    }

}
