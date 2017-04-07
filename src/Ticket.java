import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Serializable;

/**
 * Created by Sadat Msi on 4/1/2017.
 */
public class Ticket implements Serializable {

    private int id;
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

    public void writeToFile(String file) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(file);
        writer.write(String.format("FlightID: %s\n First Name: %s\n Last Name: %s\n Date of Birth: %s\n Source: %s\n " +
                        "Destionation: %s\n Date: %s\n Time: %s\n " +
                        "Duration of Flight: %s\n Price: $%.2f\n",
                flightID, firstName, lastName, dateOfBirth, source, destination, date, time, duration, price) );
        writer.close();
    }

    @Override
    public String toString(){
        // OLD toString
        /*
        String rv = String.format("FlightID: %s\n First Name: %s\n Last Name: %s\n Date of Birth: %s\n  Ticket ID: %d\n Source: %s\n " +
                        "Destionation: %s\n Date: %s\n Time: %s\n " +
                        "Duration of Flight: %s\n Price: $%.2f\n",
                        flightID, firstName, lastName, dateOfBirth, source, destination, date, time, duration, price);
                        */
        String rv = String.valueOf(id);
        return rv;
    }


}
