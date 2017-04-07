/**
 * @author brain
 * @version 1.0
 * @since 4/1/2017
 */
public class Passenger extends Client {

    private PassengerGUI myGUI;

    public Passenger(PassengerGUI x)
    {
        super();
        System.out.println("Point 2.1");
        myGUI = x;
        System.out.println("Point 2.2");
        myGUI.main(null);
        System.out.println("Point 2.3");
    }


    public static void main(String [] args){
        System.out.println("Point 1");
        PassengerGUI myGUI = new PassengerGUI();
        System.out.println("Point 2");
        Passenger me = new Passenger(myGUI);
        System.out.println("Point 3");
        me.setRef();
        System.out.println("Point 4");
        me.communicate();
        System.out.println("Point 5");
    }

    private void setRef()
    {
        myGUI.setFlightReference(flights);
    }
}



