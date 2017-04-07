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
    static final long serialVersionUID = -3970074266959511204L;

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

    public Flight()
    {
        this.flightNumber = 1;
        this.source = "src";
        this.destination = "dest";
        this.date = "date";
        this.time = "time";
        this.duration = "dur";
        this.totalSeats = 1;
        this.seatsLeft = 1;
        this.price = 1.1;
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

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getSeatsLeft() {
        return seatsLeft;
    }

    public void setSeatsLeft(int seatsLeft) {
        this.seatsLeft = seatsLeft;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public static void main(String [] args){
        System.out.println("Hello");
    }
}
