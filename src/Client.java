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

            login = new LoginGUI();
            //login.getDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            login.setVisible(true);
            data = DEFAULT;
            mySocket = new Socket(HOST, PORT);
            socketIn = new ObjectInputStream(mySocket.getInputStream());
            socketOut = new PrintWriter(mySocket.getOutputStream(), true);
            System.out.println("Connection Made");
            while (true) {
                //System.out.println(Global.toGo);
                if (!Global.toGo.equals(DEFAULT)) {
                    String[] temp = Global.toGo.split("\t");
                    socketOut.println(Global.toGo);
                    //System.out.println("Inside loop" + Global.toGo);
                    if (temp[0].equals("LOGIN")) {
                        if (socketIn.readObject().equals("Admin"))
                        {
                            AdminGUI myGUI = new AdminGUI();
                            myGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            myGUI.flights = this.flights;
                            myGUI.setVisible(true);
                            communicate();
                            break;
                        }
                        else if (socketIn.readObject().equals("Passenger"))
                        {
                            PassengerGUI myGUI = new PassengerGUI();
                            myGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            myGUI.flights = this.flights;
                            myGUI.setVisible(true);
                            communicate();
                            break;
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Incorrect username/password.");
                        }

                    } else if (temp[0].equals("SIGNUP")) {

                    }
                }
                Global.toGo = DEFAULT;
                System.out.println("Got it");
                System.out.println("");
            }

        } catch (Exception e) {
            System.err.println("Error initializing Client Socket");
            e.printStackTrace();
            System.exit(1);
        }
    }

    public synchronized void communicate(){

        System.out.println("Ready for use...");
        String line = "";
        boolean running = true;
        while(running){
            //Communicate with server
            System.out.print("");
            if (!Global.toGo.equals(DEFAULT)) {
                String [] temp = Global.toGo.split("\t");
                //System.out.println(temp);
                socketOut.println(Global.toGo);

                if(temp[0].equals("GETFLIGHTS")) {
                    try {
                        //flights = (ArrayList<Flight>) socketIn.readObject();
						flights.clear();
                        ArrayList<Flight> atemp = new ArrayList<>((ArrayList<Flight>) socketIn.readObject());
                        for (int i = 0; i < atemp.size(); i++)
                        {
                            flights.add(atemp.get(i));
                        }
                        //flights = (ArrayList<Flight>) socketIn.readObject();
                        //System.out.println("Client flight size " + flights.size());
                        //System.out.println(flights.toString());
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
                        //tickets = (ArrayList<Ticket>) socketIn.readObject();
                        tickets.clear();
                        ArrayList<Ticket> atemp = new ArrayList<>((ArrayList<Ticket>) socketIn.readObject());
                        for (int i = 0; i < atemp.size(); i++)
                        {
                            tickets.add(atemp.get(i));
                        }
                        System.out.println(tickets.size());
                        //System.out.println(tickets.toString());
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

    public String getData()
    {
        return data;
    }

    public static void main(String[] args)
    {
        Client test = new Client();



    }
}
