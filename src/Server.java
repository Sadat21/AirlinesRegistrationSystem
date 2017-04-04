import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Sadat Msi on 4/1/2017.
 */
public class Server implements ConnectionConstants {

    ServerSocket serverSocket;
    Socket aSocket;


    /**
     * Intialize Server
     * @throws IOException
     */
    public Server() throws IOException {
        serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running...");
        waitForThread();
    }

    public void waitForThread(){
        while(true){
            try {
                aSocket = serverSocket.accept();
                new ServerThread(aSocket).start();
            } catch (IOException e) {
                System.err.println("Error occured while trying to Connect");
                e.printStackTrace();
            }

        }
    }







    public static void main(String [] args){
        //Intialize Database
        DataBase db = new DataBase();
        //Intialize Server
        Server s;
        try {
            s = new Server();
        } catch (IOException e) {
            System.err.println("Error turning on server");
            e.printStackTrace();
        }


    }




}
