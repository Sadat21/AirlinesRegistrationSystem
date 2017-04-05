import java.io.*;
import java.sql.*;
import java.util.Scanner;

/**
 * Database Used. Connection is static so should be able to use from any class after it's been instantiated by running
 * the main method in this class.
 * Created by Sadat Msi on 4/1/2017.
 */
public class DataBase implements Serializable {

    protected Connection myConn;
    protected Statement myStmt;
    boolean populateNeeded = false;


    public void initializeConnection(){

        try{
            //open a connection
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinedata?autoReconnect=true&useSSL=false",
                    "root", "297080004");
            //create a statement
            myStmt = myConn.createStatement();

            //create table 'flights' if table doesn't already exist
            try{
                myStmt.execute("SELECT 1 FROM Flights LIMIT 1");
            }catch (Exception e){
                populateNeeded = true;
            }
            PreparedStatement create = myConn.prepareStatement("CREATE TABLE IF NOT EXISTS Flights" +
                    "(id int NOT NULL AUTO_INCREMENT, " +
                    "Source VARCHAR(20) NOT NULL, " +
                    "Destination VARCHAR(20) NOT NULL, " +
                    "Date VARCHAR(8) NOT NULL, " +
                    "Time VARCHAR(8) NOT NULL, " +
                    "Duration CHAR(8) NOT NULL, " +
                    "TotalSeats int NOT NULL, " +
                    "SeatsLeft int NOT NULL, " +
                    "Price Double NOT NULL, " +
                    "PRIMARY KEY(id))");
            create.executeUpdate();
            System.out.println("Created table 'Flights' in the database");


            //create table 'tickets' if table doesn't already exist
            create = myConn.prepareStatement("CREATE TABLE IF NOT EXISTS Tickets" +
                    "(id int NOT NULL AUTO_INCREMENT, " +
                    "FirstName VARCHAR(20) NOT NULL, " +
                    "LastName VARCHAR(20) NOT NULL, " +
                    "DateOfBirth VARCHAR(8) NOT NULL, " +
                    "Source VARCHAR(20) NOT NULL, " +
                    "Destination VARCHAR(20) NOT NULL, " +
                    "Date VARCHAR(8) NOT NULL, " +
                    "Time VARCHAR(8) NOT NULL, " +
                    "Duration CHAR(8) NOT NULL, " +
                    "Price Double NOT NULL, " +
                    "PRIMARY KEY(id))");
            create.executeUpdate();
            System.out.println("Created table 'Tickets' in the database");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Admin only: Add a bunch of Flights from a txt file
     * @param fileName
     */
    public void insertFlightFromFile(String fileName){
        String INPUT_FILE = fileName;
        FileReader fr = null;
        try {
            fr = new FileReader(INPUT_FILE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("Error reading from input text file");
        }

        Scanner scan = new Scanner(fr);
        while(scan.hasNextLine()){

            String temp [] = scan.nextLine().split("\t");
            String src = temp[0];
            String dest = temp[1];
            String date = temp[2];
            String time = temp[3];
            String dur = temp[4];
            int tot = Integer.parseInt(temp[5]);
            int left = Integer.parseInt(temp[6]);
            double price = Double.parseDouble(temp[7]);

            //Insert into flights database
            insertFlight(src, dest, date, time, dur, tot, left, price);
        }

        System.out.println("Added records from " + fileName + " to table 'Flights'");
    }

    /**
     * Call to put a new Flight into the database
     * @param src
     * @param dest
     * @param date
     * @param time
     * @param dur
     * @param tot
     * @param left
     * @param price
     */
    protected void insertFlight(String src, String dest, String date, String time, String dur, int tot, int left, double price ){
        try {
            String query = "INSERT INTO flights (Source, Destination, Date, Time, Duration, TotalSeats, SeatsLeft, Price)"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement insert;
            insert = myConn.prepareStatement(query);
            insert.setString(1, src);
            insert.setString(2, dest);
            insert.setString(3, date);
            insert.setString(4, time);
            insert.setString(5, dur);
            insert.setInt(6, tot);
            insert.setInt(7, left);
            insert.setDouble(8, price);
            insert.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Insert a new Ticket into the Database
     * @param fn
     * @param ln
     * @param dob
     * @param src
     * @param dest
     * @param date
     * @param time
     * @param dur
     * @param price
     */
    protected synchronized void bookTicket(String fn, String ln, String dob, String src, String dest, String date, String time, String dur, double price ){
        try {
            String query = "INSERT INTO Tickets (FirstName, LastName, DateOfBirth, Source, Destination, Date, Time, Duration, Price)"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement insert;
            insert = myConn.prepareStatement(query);
            insert.setString(1, fn);
            insert.setString(2, ln);
            insert.setString(3, dob);
            insert.setString(4, src);
            insert.setString(5, dest);
            insert.setString(6, date);
            insert.setString(7, time);
            insert.setString(8, dur);
            insert.setDouble(9, price);
            insert.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Admin Only: Remove a ticket from the database based on the unique ticket id
     * @param id
     */
    protected void cancelTicket(int id){
        String sql = "DELETE FROM Tickets WHERE id=" + id;
        try {
            myStmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void search(){

    }






    public DataBase(){
        System.out.println("Start");
        initializeConnection();
        if(populateNeeded) {
            insertFlightFromFile("input.txt");
        }
        System.out.println("Done");
    }
}
