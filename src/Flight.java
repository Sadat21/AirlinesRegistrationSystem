import java.io.Serializable;

/**
 * Created by Sadat Msi on 4/1/2017.
 */
public class Flight implements Serializable {

    private int flightNumber;
    private String source;
    private String destination;
    private String date;
    private String time;
    private String duration;
    private int totalSeats;
    private int seatsLeft;
    private Double price;

    public Flight(int fn, String src, String dest, String date ,String time, String dur, int tS, int sL, Double price){
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
        String rv = String.format("Flight number: %d\n Source: %s\n Destionation: %s\n Date: %s\n Time: %s\n " +
                "Duration of Flight: %s\n Total Seats: %d\n Seats Remaining: %d\n Price: $%.2f\n",
                flightNumber, source, destination, date, time, duration, totalSeats, seatsLeft, price);
        return rv;
    }


    public static void main(String [] args){
        System.out.println("Hello");
    }
}
