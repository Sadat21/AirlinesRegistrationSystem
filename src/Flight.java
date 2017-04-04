/**
 * Created by Sadat Msi on 4/1/2017.
 */
public class Flight {

    private int flightNumber;
    private String source;
    private String destination;
    private String date;
    private String time;
    private String duration;
    private int totalSeats;
    private int seatsLeft;
    private Double price;
    private Ticket [] tickets;



    @Override
    public String toString(){
        String rv = String.format("Flight number: %d\n Source: %s\n Destionation: %s\n Date: %s\n Time: %s\n " +
                "Duration of Flight: %s\n Total Seats: %d\n Seats Remaining: %d\n Price: $%.2f\n",
                flightNumber, source, destination, date, time, duration, totalSeats, seatsLeft, price);
        return rv;
    }
}
