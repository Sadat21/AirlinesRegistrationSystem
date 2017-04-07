/**
 * @author brain
 * @version 1.0
 * @since 4/1/2017
 */
public class Admin extends Client
{
	private AdminGUI myGUI;

	public Admin(AdminGUI x){
		super();
		myGUI = x;
		// TODO: REMOVE REMOVE REMOVE
		//myGUI.main(null);
	}

	public static void main(String [] args){
		AdminGUI myGUI = new AdminGUI();
		Admin me = new Admin(myGUI);
		me.setRef();
		me.communicate();
	}

	private void setRef()
	{
		myGUI.setTicketReference(tickets);
	}
}
