/**
 * Created by Sadat Msi on 4/1/2017.
 */
public class Ticket {

    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private int ID;
    private String source;
    private String destination;
    private String date;
    private String time;
    private String duration;
    private Double price;

    @Override
    public String toString(){
        String rv = String.format("First Name: %s\n Last Name: %s\n Date of Birth:  Ticket ID: %d\n Source: %s\n " +
                        "Destionation: %s\n Date: %s\n Time: %s\n " +
                        "Duration of Flight: %s\n Price: $%.2f\n",
                        firstName, lastName, ID, source, destination, date, time, duration, price);
        return rv;
    }


}
