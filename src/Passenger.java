import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author brain
 * @version 1.0
 * @since 4/1/2017
 */
public class Passenger extends Client {

    private PassengerGUI myGUI;
    protected ArrayList<Flight> flights;

    public Passenger()
    {
        super();
        myGUI = new PassengerGUI();
        this.flights = super.flights;
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
        me.communicate();
    }
}



