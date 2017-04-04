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
            System.err.println("Error Opening database.ser to insert databse object");
            e.printStackTrace();
        }
        System.out.println("Thread created");
        run();
    }

    @Override
    public void run(){
        String line;
        String result = DEFAULT;

        while (true){
            try {
                result = in.readLine();
                myDb.myStmt.executeUpdate(result);

            } catch (IOException e) {
                System.err.println("Error reading input coming from Client");
                //e.printStackTrace();
                break;
            }
            catch (SQLException e){
                System.err.println("Error executing Querry from ServerThread");
                e.printStackTrace();
            }
            if (!result.equals(DEFAULT)) {
                System.out.println(result);
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
