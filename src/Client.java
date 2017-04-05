import java.io.*;
import java.net.Socket;
import java.util.ArrayList;


/**
 * @author brain
 * @version 1.0
 * @since 4/1/2017
 */
public abstract class Client implements ConnectionConstants {

    protected Socket mySocket;
    protected ObjectInputStream socketIn;
    protected PrintWriter socketOut;

    protected ArrayList<Flight> flights;
    protected ArrayList<Ticket> tickets;


    public  Client(){
        try {
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
