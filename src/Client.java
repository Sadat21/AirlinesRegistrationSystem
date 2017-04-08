import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @author Brian Pho, Harjee Johal, Sadat Islam
 * @version 1.0
 * @since 4/1/2017
 */
public class Client implements ConnectionConstants
{
    /**
     * Data fields of Client.
     */
    protected Socket mySocket;
    protected ObjectInputStream socketIn;
    protected PrintWriter socketOut;
    protected ArrayList<Flight> flights;
    protected ArrayList<Ticket> tickets;
    protected Ticket myTicket;
    protected LoginGUI login;

    /**
     * Main function for Client. Initializes an object of type Client.
     * @param args Not used
     */
    public static void main(String[] args)
    {
        try {
            UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Client test = new Client();
    }

    /**
     * The constructor of Client
     */
    public Client()
    {
        try {
            flights = new ArrayList<>();
            tickets = new ArrayList<>();
            login = new LoginGUI();
            login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            login.setVisible(true);
            mySocket = new Socket(HOST, PORT);
            socketIn = new ObjectInputStream(mySocket.getInputStream());
            socketOut = new PrintWriter(mySocket.getOutputStream(), true);
            System.out.println("Connection Made");
            while (true) {
                //System.out.println(Global.toGo);
                System.out.println("");
                if (!Global.toGo.equals(DEFAULT)) {
                    String[] temp = Global.toGo.split("\t");
                    socketOut.println(Global.toGo);
                    System.out.println("Test 1");
                    if (temp[0].equals("LOGIN")) {
                        String check = (String) socketIn.readObject();
                        if (check.equals("Admin"))
                        {
                            login.dispose();
                            AdminGUI myGUI = new AdminGUI();
                            myGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            myGUI.flights = this.flights;
                            myGUI.tickets = this.tickets;
                            myGUI.setVisible(true);
                            Global.toGo = DEFAULT;
                            communicate();
                            break;
                        }
                        else if (check.equals("Pass"))
                        {
                            login.dispose();
                            PassengerGUI myGUI = new PassengerGUI();
                            myGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            myGUI.flights = this.flights;
                            myGUI.setVisible(true);
                            Global.toGo = DEFAULT;
                            communicate();
                            break;
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Incorrect username/password.");
                        }

                    } else if (temp[0].equals("SIGNUP")) {
                        boolean check = (boolean) socketIn.readObject();
                        if (check)
                        {
                            JOptionPane.showMessageDialog(null, "Successfully created user.");
                            Global.toGo = DEFAULT;
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "User already exists.");
                            Global.toGo = DEFAULT;
                        }
                    }
                }
                Global.toGo = DEFAULT;
            }
        } catch (Exception e) {
            System.err.println("Error initializing Client Socket");
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * The method that communicates between the Client and Server
     */
    public synchronized void communicate()
    {

        System.out.println("Ready for use...");
        boolean running = true;
        while(running){
            //Communicate with server
            System.out.print("");
            if (!Global.toGo.equals(DEFAULT)) {
                String [] temp = Global.toGo.split("\t");
                socketOut.println(Global.toGo);

                if(temp[0].equals("GETFLIGHTS")) {
                    try {
						flights.clear();
                        ArrayList<Flight> atemp = new ArrayList<>((ArrayList<Flight>) socketIn.readObject());
                        for (int i = 0; i < atemp.size(); i++)
                        {
                            flights.add(atemp.get(i));
                        }
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
                        tickets.clear();
                        ArrayList<Ticket> atemp = new ArrayList<>((ArrayList<Ticket>) socketIn.readObject());
                        for (int i = 0; i < atemp.size(); i++)
                        {
                            tickets.add(atemp.get(i));
                        }
                        System.out.println(tickets.size());
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
                            JOptionPane.showMessageDialog(null, "Ticket Booked! Ticket is printed on the file" +
                                            "Ticket.txt  . Enjoy our flight and thank you for choosing ENSF409 Airways!!",
                                    "Success", JOptionPane.PLAIN_MESSAGE);
                            myTicket = worked;
                            worked.writeToFile("ticket.txt");
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
}
