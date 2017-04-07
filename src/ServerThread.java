import java.io.*;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Sadat Msi on 4/3/2017.
 */
public class ServerThread extends Thread implements ConnectionConstants {

    protected Socket mySocket;
    protected ObjectOutputStream out;
    protected BufferedReader in;
    protected DataBase myDb;

    public ServerThread(Socket aSocket, DataBase db){
        mySocket = aSocket;
        try {
            out = new ObjectOutputStream( mySocket.getOutputStream() );
            in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
            myDb = db;
        }
        catch (IOException e){
            System.err.println("Error creating in/out streams in the ServerThread");
            e.printStackTrace();
        }
        System.out.println("Thread created");
        //run();
    }

    @Override
    public void run(){
        String line;
        String result = DEFAULT;
        String [] temp = null;

        while (true){
            try {
                System.out.println("Waiting for command...");
                result = in.readLine();
                temp = result.split("\t");

            } catch (IOException e) {
                System.err.println("Error reading input coming from Client");
                //e.printStackTrace();
                break;
            }

            //Action Performed
            //Does Nothing
            if (result.equals(DEFAULT)) {

                //Do Nothing

            }
            //Does the following if result is not empty/garbage
            else if(temp[0].equals("ADDFLIGHT")){
                myDb.insertFlight(temp[1],temp[2],temp[3],temp[4],temp[5],
                        Integer.parseInt(temp[6]),Integer.parseInt(temp[7]),Double.parseDouble(temp[8]));
            }
            else if(temp[0].equals("ADDFLIGHTFROMFILE")){






            }
            else if(temp[0].equals("BOOKFLIGHT")){
                Ticket worked = myDb.bookTicket(Integer.parseInt(temp[1]),temp[2],temp[3],temp[4],temp[5],
                        temp[6],temp[7], temp[8],temp[9],Double.parseDouble(temp[10]));
                try {
                    out.writeObject(worked);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            else if(temp[0].equals("GETFLIGHTS")){
                ResultSet myRs = null;
                //Format should be "GETFLIGHTS Src Dest Date"
                //Src is mandatory, remaining can be -1 if not specified
                if(temp[2].equals("-1") && temp[3].equals("-1") ){
                    //Search for src
                    myRs = myDb.searchFlight(1,temp[1],temp[2],temp[3]);
                }
                else if(temp[3].equals("-1")){
                    //Search for src and dest
                    myRs = myDb.searchFlight(2,temp[1],temp[2],temp[3]);
                }
                else if(temp[2].equals("-1") ){
                    //Search for src and date
                    myRs = myDb.searchFlight(3,temp[1],temp[2],temp[3]);
                }
                else{
                    //Search for src dest and date
                    myRs = myDb.searchFlight(4,temp[1],temp[2],temp[3]);
                }

                //Create an array of Flights to be returned
                ArrayList <Flight> toBeSent = new ArrayList<Flight>();
                Flight insert;
                try {
                    while(myRs.next()){
                        insert = new Flight( myRs.getInt("id"),
                                myRs.getString("Source"),
                                myRs.getString("Destination"),
                                myRs.getString("Date"),
                                myRs.getString("Time"),
                                myRs.getString("Duration"),
                                myRs.getInt("TotalSeats"),
                                myRs.getInt("SeatsLeft"),
                                myRs.getDouble("Price"));

                        toBeSent.add(insert) ;
                    }
                } catch (SQLException e) {
                    System.err.println("Error getting data from ResultSet");
                    e.printStackTrace();
                    System.exit(1);
                }

                //Write to socket output stream
                try {
                    out.writeObject(toBeSent);
                } catch (IOException e) {
                    System.err.println("Error serializing object in serverThread");
                    e.printStackTrace();
                }

            }
            else if(temp[0].equals("SEARCHTICKET")){
                ResultSet myRs = null;
                //Format should be "SEARCHTICKET id src dest"
                if(!temp[1].equals("-1")){
                    //Search id
                    myRs = myDb.searchTicket(1,Integer.parseInt(temp[1]), temp[2], temp[3]);

                }
                else if(temp[3].equals("-1")){
                    //Search src
                    myRs = myDb.searchTicket(2,Integer.parseInt(temp[1]), temp[2], temp[3]);
                }
                else if(temp[2].equals("-1")){
                    //Search dest
                    myRs = myDb.searchTicket(3,Integer.parseInt(temp[1]), temp[2], temp[3]);
                }
                else{
                    //Search src and dest
                    myRs = myDb.searchTicket(4,Integer.parseInt(temp[1]), temp[2], temp[3]);
                }

                //Create an array of Tickets to be returned
                ArrayList <Ticket> toBeSent = new ArrayList<Ticket>();
                Ticket insert;
                try {
                    while(myRs.next()){
                        insert = new Ticket( myRs.getInt("id"),
                                myRs.getInt("FlightId"),
                                myRs.getString("FirstName"),
                                myRs.getString("LastName"),
                                myRs.getString("DateOfBirth"),
                                myRs.getString("Source"),
                                myRs.getString("Destination"),
                                myRs.getString("Date"),
                                myRs.getString("Time"),
                                myRs.getString("Duration"),
                                myRs.getDouble("Price"));

                        toBeSent.add(insert) ;
                    }
                } catch (SQLException e) {
                    System.err.println("Error getting data from ResultSet for search ticket");
                    e.printStackTrace();
                    System.exit(1);
                }

                //Write to socket output stream
                try {
                    out.writeObject(toBeSent);
                } catch (IOException e) {
                    System.err.println("Error serializing object in serverThread from seraching for ticket");
                    e.printStackTrace();
                }


            }
            else if(temp[0].equals("CANCELTICKET")){
                myDb.cancelTicket(Integer.parseInt(temp[1]), Integer.parseInt(temp[2]) );

            }
            else{
                System.err.println("Invalid Operation Read");
                System.out.println(result);
                System.exit(1);
            }
        }
        try {
            mySocket.close();
            in.close();
            out.close();
            System.out.println("Thread Disconnected");
        } catch (IOException e) {
            System.err.println("Error disconecting thread");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
