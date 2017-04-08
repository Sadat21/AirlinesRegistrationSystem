import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Serializable;

/**
 * Created by Sadat Msi on 4/1/2017.
 */
public class Ticket implements Serializable {

    protected int id;
    protected int flightID;
    protected String firstName;
    protected String lastName;
    protected String dateOfBirth;
    protected String source;
    protected String destination;
    protected String date;
    protected String time;
    protected String duration;
    protected Double price;
    static final long serialVersionUID = 1L;

    public Ticket(int id, int FlightID, String fN, String lN, String dOB, String src, String dst, String d, String t, String dur, Double pr)
    {
        this.id = id;
        flightID = FlightID;
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

    public int getId() {
        return id;
    }

    public int getFlightID() {
        return flightID;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getDuration() {
        return duration;
    }

    public Double getPrice() {
        return price;
    }

    public void writeToFile(String file) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(file);
        writer.write(String.format("FlightID: %s\n First Name: %s\n Last Name: %s\n Date of Birth: %s\n Source: %s\n " +
                        "Destination: %s\n Date: %s\n Time: %s\n " +
                        "Duration of Flight: %s\n Price: $%.2f\n",
                flightID, firstName, lastName, dateOfBirth, source, destination, date, time, duration, price) );
        writer.close();
    }

    @Override
    public String toString(){
        String rv = String.format("FlightID: %d First Name: %s Last Name: %s Date of Birth: %s Ticket ID: %d Source: %s " +
                        "Destination: %s Date: %s Time: %s " +
                        "Duration of Flight: %s Price: $%.2f",
                        flightID, firstName, lastName, dateOfBirth, id, source, destination, date, time, duration, price);
        return rv;
    }
}
