import javax.swing.*;
import java.util.ArrayList;

/**
 * @author brain
 * @version 1.0
 * @since 4/1/2017
 */
public class Passenger extends Client {

    private PassengerGUI myGUI;

    public Passenger()
    {
        super();
        myGUI = new PassengerGUI(super.flights);
    }

    public static void main(String [] args){
        try {
            UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Passenger me = new Passenger();
        me.myGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        me.myGUI.setVisible(true);
        //me.myGUI.flights = me.flights;
        //myGUI.flights = flights;
        me.communicate();
    }
}