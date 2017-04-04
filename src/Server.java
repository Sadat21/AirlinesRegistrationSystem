import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Sadat Msi on 4/1/2017.
 */
public class Server {

    ServerSocket serverSocket;
    Socket aSocket;
    PrintWriter out;
    BufferedReader in;

    /**
     * Intialize Server
     * @throws IOException
     */
    public Server() throws IOException {
        serverSocket = new ServerSocket(10);
        System.out.println("Server is running...");
        in = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
        out = new PrintWriter((aSocket.getOutputStream()), true);
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
