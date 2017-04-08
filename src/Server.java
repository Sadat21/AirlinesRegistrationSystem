import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Program that is run on the Server which creates new Threads for each new Connection
 * @author Brian Pho, Harjee Johal, Sadat Islam
 */
public class Server implements ConnectionConstants {
    /**
     * ServerSocket object for the Server
     */
    ServerSocket serverSocket;
    /**
     * Socket used to connect to a Client
     */
    Socket aSocket;
    /**
     * Database class to use database queries
     */
    DataBase db;

    /**
     * Initial setup
     * @param args Not used
     */
    public static void main(String [] args)
    {
        //Initialize Server
        Server s = null;
        try {
            s = new Server();
        } catch (IOException e) {
            System.err.println("Error turning on server");
            e.printStackTrace();
        }
    }

    /**
     * Waits for any new Client that joins and creates a new Socket Connection and ServerThread
     */
    public void waitForThread()
    {
        while(true){
            try {
                aSocket = serverSocket.accept();
                new ServerThread(aSocket, db).start();
            } catch (IOException e) {
                System.err.println("Error occurred while trying to Connect");
                e.printStackTrace();
            }
        }
    }

    /**
     * Constructor of Server
     * @throws IOException
     */
    public Server() throws IOException
    {
        serverSocket = new ServerSocket(PORT);
        //Initialize Database
        db = new DataBase();
        System.out.println("Server is running...");
        waitForThread();
    }
}
