import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Sadat Msi on 4/3/2017.
 */
public class ServerThread {

    protected Socket mySocket;
    protected PrintWriter out;
    protected BufferedReader in;



    public ServerThread(Socket aSocket){
        mySocket = aSocket;
        try {
            in = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
            out = new PrintWriter((aSocket.getOutputStream()), true);
        }
        catch (IOException e){
            System.err.println("Error Intitalizing Server Thread");
            e.printStackTrace();
        }
    }



}
