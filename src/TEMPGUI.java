import javax.swing.*;
import java.awt.*;

/**
 * Created by Brian on 2017-04-04.
 */
public class TEMPGUI extends PassengerGUI {
    public static void main(String[] args)
    {
        try {
            UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        TEMPGUI test = new TEMPGUI();
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setVisible(true);
    }

    public TEMPGUI()
    {
        super();
        setTitle("Admin Client Program");
        setSize(1295, 680);
    }
}
