/**
 * @author brain
 * @version 1.0
 * @since 4/1/2017
 */
public class Admin extends Client
{
	AdminGUI myGUI;

	public Admin(AdminGUI x){
		super();
		myGUI = x;
		myGUI.main(null);
	}


	public static void main(String [] args){
		AdminGUI myGUI = new AdminGUI();
		Admin me = new Admin(myGUI);
		me.communicate();
	}
}
