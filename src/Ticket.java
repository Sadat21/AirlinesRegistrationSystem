import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Serializable;

/**
 * This class is used to store data about a ticket.
 * @author Brian Pho, Harjee Johal, Sadat Islam
 */
public class Ticket implements Serializable {

    /**
     * Data fields of Ticket.
     */
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

    /**
     * The constructor of Ticket
     * @param id Ticket ID
     * @param FlightID Flight ID
     * @param fN First name
     * @param lN Last name
     * @param dOB Date of birth
     * @param src Source
     * @param dst Destination
     * @param d Date
     * @param t Time
     * @param dur Duration
     * @param pr Price
     */
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

    /**
     * Return the ticket ID
     * @return Ticket ID
     */
    public int getId() {
        return id;
    }

    /**
     * Return the flight ID
     * @return Flight ID
     */
    public int getFlightID() {
        return flightID;
    }

    /**
     * Return the date
     * @return Date
     */
    public String getDate() {
        return date;
    }

    /**
     * Print ticket to a text file.
     * @param file Name of text file
     * @throws FileNotFoundException If cannot create a file
     */
    public void writeToFile(String file) throws FileNotFoundException
    {
        PrintWriter writer = new PrintWriter(file);
        writer.write(String.format("FlightID: %s\n First Name: %s\n Last Name: %s\n Date of Birth: %s\n Source: %s\n " +
                        "Destination: %s\n Date: %s\n Time: %s\n " +
                        "Duration of Flight: %s\n Price: $%.2f\n",
                flightID, firstName, lastName, dateOfBirth, source, destination, date, time, duration, price) );
        writer.close();
    }

    /**
     * toString method to turn a Ticket object into a String
     * @return A ticket converted into a String
     */
    @Override
    public String toString()
    {
        String rv = String.format("FlightID: %d First Name: %s Last Name: %s Date of Birth: %s Ticket ID: %d Source: %s " +
                        "Destination: %s Date: %s Time: %s " +
                        "Duration of Flight: %s Price: $%.2f",
                        flightID, firstName, lastName, dateOfBirth, id, source, destination, date, time, duration, price);
        return rv;
    }
}
