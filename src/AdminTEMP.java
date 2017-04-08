import javax.swing.*;

/**
 * @author Brian Pho, Harjee Johal, Sadat Islam
 * @version 1.0
 * @since 4/1/2017
 */
public class AdminTEMP extends Client {

	private AdminGUI myGUI;

	public AdminTEMP()
	{
		super();
		myGUI = new AdminGUI();
	}

	public static void main(String [] args){
		try {
			UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		AdminTEMP me = new AdminTEMP();
		me.myGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		me.myGUI.flights = me.flights;
		me.myGUI.tickets = me.tickets;
		me.myGUI.setVisible(true);
		me.communicate();
	}
}
