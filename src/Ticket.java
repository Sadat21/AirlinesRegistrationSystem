import java.io.Serializable;

/**
 * Created by Sadat Msi on 4/1/2017.
 */
public class Ticket implements Serializable {

    private int flightID;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String source;
    private String destination;
    private String date;
    private String time;
    private String duration;
    private Double price;

    public Ticket(int ID, String fN, String lN, String dOB, String src, String dst, String d, String t, String dur, Double pr)
    {
        flightID = ID;
        firstName = fN;
        lastName = lN;
        dateOfBirth = dOB;
        source = src;
        destination = dst;
        date = d;
        time = t;
        duration = dur;
        price = pr;
    }

    @Override
    public String toString(){
        String rv = String.format("FlightID: %s\n First Name: %s\n Last Name: %s\n Date of Birth: %s\n  Ticket ID: %d\n Source: %s\n " +
                        "Destionation: %s\n Date: %s\n Time: %s\n " +
                        "Duration of Flight: %s\n Price: $%.2f\n",
                        flightID, firstName, lastName, dateOfBirth, source, destination, date, time, duration, price);
        return rv;
    }


}
