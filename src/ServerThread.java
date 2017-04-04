import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Sadat Msi on 4/3/2017.
 */
public class ServerThread extends Thread {

    protected Socket mySocket;
    protected PrintWriter out;
    protected BufferedReader in;



    public ServerThread(Socket aSocket){
        mySocket = aSocket;
        try {
            in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
            out = new PrintWriter((mySocket.getOutputStream()), true);
        }
        catch (IOException e){
            System.err.println("Error Intitalizing Server Thread");
            e.printStackTrace();
        }
        System.out.println("Thread created");
    }

    @Override
    public void run(){
        String line;

        while (true){
            //Code to be continoually done
        }

    }



}
