import java.io.*;
import java.net.Socket;
import java.sql.Connection;
import java.sql.SQLException;

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
        run();
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
                result.split("\t");

            } catch (IOException e) {
                System.err.println("Error reading input coming from Client");
                //e.printStackTrace();
                break;
            }

            //Action Performed
            //Does Nothing
            if (result.equals(DEFAULT)) {

            }
            //Does the following if result is not empty/garbage
            else if(temp[0].equals("ADDFLIGHT")){
                myDb.insertFlight(temp[1],temp[2],temp[3],temp[4],temp[5],
                        Integer.parseInt(temp[6]),Integer.parseInt(temp[7]),Double.parseDouble(temp[8]));
            }
            else if(temp[0].equals("ADDFLIGHTFROMFILE")){

            }
            else if(temp[0].equals("BOOKFLIGHT")){
                myDb.bookTicket(temp[1],temp[2],temp[3],temp[4],temp[5],
                        temp[6],temp[7], temp[8], Double.parseDouble(temp[9]));;
            }
            else if(temp[0].equals("GETFLIGHTS")){

            }
            else if(temp[0].equals("SEARCHTICKET")){

            }
            else if(temp[0].equals("CANCELTICKET")){
                myDb.cancelTicket(Integer.parseInt(temp[1]));

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
