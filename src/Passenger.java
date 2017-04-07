import javax.swing.*;

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
        //myGUI = new PassengerGUI(super.flights);
        //myGUI = new PassengerGUI();
        //myGUI.flights = this.flights;
    }

    public static void main(String [] args){
        try {
            //UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Passenger me = new Passenger();
        me.myGUI = new PassengerGUI();
        me.myGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        me.myGUI.flights = me.flights;
        me.myGUI.setVisible(true);
        me.communicate();
    }
}