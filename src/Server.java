import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Sadat Msi on 4/1/2017.
 */
public class Server implements ConnectionConstants {

    ServerSocket serverSocket;
    Socket aSocket;
    DataBase db;

    /**
     * Initialize Server
     * @throws IOException
     */
    public Server() throws IOException {
        serverSocket = new ServerSocket(PORT);
        //Initialize Database
        db = new DataBase();
        System.out.println("Server is running...");
        waitForThread();
    }

    public void waitForThread(){
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

    public static void main(String [] args){
        //Initialize Server
        Server s = null;
        try {
            s = new Server();
        } catch (IOException e) {
            System.err.println("Error turning on server");
            e.printStackTrace();
        }
    }
}
