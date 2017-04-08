import javax.swing.*;

/**
 * @author Brian Pho, Harjee Johal, Sadat Islam
 * @version 1.0
 * @since 4/1/2017
 */
public class PassengerTEMP extends Client {

    private PassengerGUI myGUI;

    public PassengerTEMP()
    {
        super();
        myGUI = new PassengerGUI();
    }

    public static void main(String [] args){
        try {
            UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        PassengerTEMP me = new PassengerTEMP();
        me.myGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        me.myGUI.flights = me.flights;
        me.myGUI.setVisible(true);
        me.communicate();
    }
}