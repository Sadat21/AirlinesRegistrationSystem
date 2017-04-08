import java.io.Serializable;

/**
 * This class stores information about a flight.
 * @author Brian Pho, Harjee Johal, Sadat Islam
 */

public class Flight implements Serializable {

    /**
     * Data fields of Flight.
     */
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

    /**
     * Constructor of class Flight
     * @param fn Flight Number
     * @param src Source
     * @param dest Destination
     * @param date Date
     * @param time Time
     * @param dur Flight Duration
     * @param tS Total Seats
     * @param sL Seats Left
     * @param price Price
     */
    public Flight(int fn, String src, String dest, String date, String time, String dur, int tS, int sL, Double price)
    {
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

    /**
     * Default constructor of class Flight.
     */
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

    /**
     * toString method to turn a Flight object into a String
     * @return A flight converted into a String
     */
    @Override
    public String toString()
    {
        String rv = String.format("Flight number: %d       Source: %s       Destination: %s       Date: %s",
                flightNumber, source, destination, date);
        return rv;
    }

    /**
     * Return the number of seats left
     * @return Number of seats left in a flight
     */
    public int getSeatsLeft() {
        return seatsLeft;
    }

    /**
     * Set the number of seats in a flight
     * @param seatsLeft Number of seats in a flight
     */
    public void setSeatsLeft(int seatsLeft) {
        this.seatsLeft = seatsLeft;
    }
}
