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
        myGUI = x;
        myGUI.main(null);
    }


    public static void main(String [] args){
        PassengerGUI myGUI = new PassengerGUI();
        Passenger me = new Passenger(myGUI);
        me.setRef();
        me.communicate();
    }

    private void setRef()
    {
        myGUI.setFlightReference(flights);
    }
}



