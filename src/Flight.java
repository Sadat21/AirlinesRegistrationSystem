import java.io.Serializable;

/**
 * Created by Sadat Msi on 4/1/2017.
 */
public class Flight implements Serializable {

    protected int flightNumber;
    protected String source;
    protected String destination;
    protected String date;
    protected String time;
    protected String duration;
    protected int totalSeats;
    protected int seatsLeft;
    protected Double price;

    public Flight(int fn, String src, String dest, String date, String time, String dur, int tS, int sL, Double price){
        this.flightNumber = fn;
        this.source = src;
        this.destination = dest;
        this.date = date;
        this.time = time;
        this.duration = dur;
        this.totalSeats = tS;
        this.seatsLeft = sL;
        this.price = price;
    }

    @Override
    public String toString(){
        /*
        String rv = String.format("Flight number: %d\n Source: %s\n Destionation: %s\n Date: %s\n Time: %s\n " +
                "Duration of Flight: %s\n Total Seats: %d\n Seats Remaining: %d\n Price: $%.2f\n",
                flightNumber, source, destination, date, time, duration, totalSeats, seatsLeft, price);
        */
        String rv = String.format("Flight number: %d       Source: %s       Destination: %s       Date: %s",
                flightNumber, source, destination, date);
        return rv;
    }

    public static void main(String [] args){
        System.out.println("Hello");
    }
}
