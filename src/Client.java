import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author brain
 * @version 1.0
 * @since 4/1/2017
 */
public abstract class  Client implements ConnectionConstants {



    protected Socket mySocket;
    protected BufferedReader socketIn;
    protected PrintWriter socketOut;





    public Client(){
        try {
            mySocket = new Socket(HOST, PORT);
            socketIn = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
            socketOut = new PrintWriter(mySocket.getOutputStream(), true);

        } catch (IOException e) {
            System.err.println("Error intializing Client Socket");
            e.printStackTrace();
        }

    }

    public void communicate(){

        String line = "";
        while(true){
            //Communicate with server
            

        }


    }


}
