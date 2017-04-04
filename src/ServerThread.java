import java.io.*;
import java.net.Socket;
import java.sql.Connection;

/**
 * Created by Sadat Msi on 4/3/2017.
 */
public class ServerThread extends Thread implements ConnectionConstants {

    protected Socket mySocket;
    protected ObjectOutputStream out;
    protected BufferedReader in;



    public ServerThread(Socket aSocket, DataBase db){
        mySocket = aSocket;
        try {
            out = new ObjectOutputStream( mySocket.getOutputStream() );
            in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));

            run();


        }
        catch (IOException e){
            System.err.println("Error Opening database.ser to insert databse object");
            e.printStackTrace();
        }
        System.out.println("Thread created");
    }

    @Override
    public void run(){
        String line;
        String result = "";

        while (true){
            try {
                result = in.readLine();

            } catch (IOException e) {
                System.err.println("Error reading input coming from Client");
                e.printStackTrace();
                System.exit(1);
            }
            if(result.equals(DEFAULT)){

            }
            else {
                System.out.println(result);
            }


        }

    }



}
