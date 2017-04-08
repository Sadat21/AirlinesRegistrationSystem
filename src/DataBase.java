import java.io.*;
import java.sql.*;
import java.util.Scanner;

/**
 * Database Used. Contains code to connect, create tables, and execute queries to the database.
 * @author Brian Pho, Harjee Johal, Sadat Islam
 */
public class DataBase implements Serializable, ConnectionConstants {
    /**
     * Connection to the local database
     */
    protected Connection myConn;
    /**
     * Statement used to send queries to the database
     */
    protected Statement myStmt;
    /**
     * Variable states whether or not we need to populate the database with initial flight data if it is empty
     */
    boolean populateNeeded = false;

    /**
     * Connects the server to the database and creates the tables needed
     */
    public void initializeConnection()
    {
        try{
            //open a connection
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+ SCHEMA + "?autoReconnect=true&useSSL=false",
                    USER, PASS);
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
                    "Date VARCHAR(10) NOT NULL, " +
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
                    "FlightID int NOT NULL, " +
                    "FirstName VARCHAR(20) NOT NULL, " +
                    "LastName VARCHAR(20) NOT NULL, " +
                    "DateOfBirth VARCHAR(10) NOT NULL, " +
                    "Source VARCHAR(20) NOT NULL, " +
                    "Destination VARCHAR(20) NOT NULL, " +
                    "Date VARCHAR(10) NOT NULL, " +
                    "Time VARCHAR(8) NOT NULL, " +
                    "Duration CHAR(8) NOT NULL, " +
                    "Price Double NOT NULL, " +
                    "PRIMARY KEY(id))");
            create.executeUpdate();
            System.out.println("Created table 'Tickets' in the database");

            //create table 'users' if table doesn't already exist
            create = myConn.prepareStatement("CREATE TABLE IF NOT EXISTS Users" +
                    "(Status VARCHAR(5) NOT NULL, " +
                    "Username VARCHAR(20) NOT NULL, " +
                    "Password VARCHAR(20) NOT NULL, " +
                    "PRIMARY KEY(Username))");
            create.executeUpdate();
            System.out.println("Created table 'Users' in the database");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Checks if the user is already in the database
     * @param username
     * @param pass
     * @return Returns the ResultSet containing all users that match the user and pass description, used to determine
     * whether they are an admin or a passenger
     */
    public ResultSet checkUser(String username, String pass)
    {
        ResultSet temp = null;
        try {
            PreparedStatement create = myConn.prepareStatement("SELECT * FROM Users WHERE Username=? AND Password=?");
            create.setString(1, username );
            create.setString(2, pass );
            temp = create.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return temp;
    }

    /**
     * Creates a user in the database and initializes them with the arguments given
     * @param username
     * @param pass
     * @param status
     * @return Returns true if it was successful, false if an account already exists with the given username
     */
    public Boolean createUser(String username, String pass, String status)
    {
        ResultSet temp = null;
        //Check if username exists
        PreparedStatement create = null;
        try {
            create = myConn.prepareStatement("SELECT * FROM Users WHERE Username=?");
            create.setString(1, username );
            temp = create.executeQuery();
            while(temp.next()){
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Since it doesn't, add it to the database
        try {
            create = myConn.prepareStatement("INSERT INTO Users (Username, Password, Status)"
                    + "VALUES(?, ?, ?)");
            create.setString(1, username);
            create.setString(2,pass);
            create.setString(3,status);
            create.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * Insert flights from a local file to populate the database initially
     * @param fileName name of the file
     */
    public void insertFlightFromFile(String fileName)
    {
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
     * Inserts a flight into the database and initializes it with the given arguments
     * @param src Source
     * @param dest Destination
     * @param date Departure Date
     * @param time Departure Time
     * @param dur Duration of FLight
     * @param tot Total Seats on the aircraft
     * @param left Seats Remaining
     * @param price Price of the ticket before tax
     */
    protected void insertFlight(String src, String dest, String date, String time, String dur, int tot, int left, double price )
    {
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
     * Books a ticket for the given FlightID. Synchronized so two people can't book simultaneously the last flight. Returns
     * the Ticket to the Flight
     * @param id Flight ID
     * @param fn First Name
     * @param ln Last Name
     * @param dob Date of Birth
     * @param src Source
     * @param dest Destination
     * @param date Date
     * @param time Time
     * @param dur Duration
     * @param price Price
     * @return Returns the ticket if successful, returns a null ticket if Flight is full
     */
    protected synchronized Ticket bookTicket(int id, String fn, String ln, String dob, String src, String dest,
                                             String date, String time, String dur, double price )
    {
        //Find Flight
        ResultSet temp = null;
        int blah;
        try {
            PreparedStatement create = myConn.prepareStatement("SELECT * FROM Flights WHERE id=?");
            create.setInt(1, id);
            temp = create.executeQuery();
            temp.next();
            blah = temp.getInt("SeatsLeft");
            if( blah > 0 ){
                //Subtract one
                create = myConn.prepareStatement("UPDATE Flights SET SeatsLeft=? WHERE id=?");
                create.setInt(1,--blah);
                create.setInt(2,id);
                create.execute();

            }
            else{
                System.out.println("No more tickets");
                return null;
            }
        }catch (SQLException e){
            System.err.println("Error searching for flight in bookTicket");
            e.printStackTrace();
            return null;

        }

        //Book Ticket if there is still tickets left
        try {
            String query = "INSERT INTO Tickets (FirstName, LastName, DateOfBirth, Source, Destination, Date, Time, Duration, Price, FlightID)"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            insert.setInt(10, id);
            insert.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Ticket(0, id, fn, ln, dob, src, dest, date, time, dur, price);
    }

    /**
     * Cancels a Ticket in the database
     * @param id ID of the Ticket to be deleted
     * @param FID FlightID of the Flight that the ticket corresponds to
     */
    protected synchronized void cancelTicket(int id, int FID)
    {
        //Delete Ticket
        String sql = "DELETE FROM Tickets WHERE id=" + id;
        try {
            myStmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Find Flight
        ResultSet temp = null;
        int blah;
        try {
            PreparedStatement create = myConn.prepareStatement("SELECT * FROM Flights WHERE id=?");
            create.setInt(1, FID);
            temp = create.executeQuery();
            temp.next();
            blah = temp.getInt("SeatsLeft");
            //Add one
            create = myConn.prepareStatement("UPDATE Flights SET SeatsLeft=? WHERE id=?");
            create.setInt(1,++blah);
            create.setInt(2,FID);
            create.execute();

        }catch (SQLException e){
            System.err.println("Error searching for flight in cancelTicket");
            e.printStackTrace();
        }
    }

    /**
     * Searches for a Flight based on the arguments given.
     * @param whichCase Based on how many arguments that are not garbage, selects which search to do
     * @param src Source
     * @param dest Destination
     * @param date Date of Departure
     * @return Returns the ResultSet of all Flights that match the search
     */
    public ResultSet searchFlight(int whichCase, String src, String dest, String date)
    {
        // 1- Src       2- Src Dest         3- Src Date         4- All
        ResultSet myRs = null;
        PreparedStatement create = null;
        try {
            if (whichCase == 1) {
                create = myConn.prepareStatement("SELECT * FROM Flights WHERE Source=?");
                create.setString(1, src);
            } else if (whichCase == 2) {
                create = myConn.prepareStatement("SELECT * FROM Flights WHERE Source=? and Destination=?");
                create.setString(1, src);
                create.setString(2, dest);

            } else if (whichCase == 3) {
                create = myConn.prepareStatement("SELECT * FROM Flights WHERE Source=? and Date=?");
                create.setString(1, src);
                create.setString(2, date);

            } else if (whichCase == 4) {
                create = myConn.prepareStatement("SELECT * FROM Flights WHERE Source=? and Destination=? and Date=?");
                create.setString(1, src);
                create.setString(2, dest);
                create.setString(3, date);

            } else {
                System.err.println("Invalide parameter for Case");
                System.exit(1);
            }

            //Execute Statement
            myRs = create.executeQuery();
        }
        catch (SQLException e){
            System.err.println("Error Executing searchFlight method");
            e.printStackTrace();
            System.exit(1);
        }
        return myRs;
    }

    /**
     * Search's for a ticket given the arguments
     * @param whichCase Based on how many arguments are not garbage, selects the case
     * @param id Flight ID
     * @param src Source
     * @param dest Destination
     * @return Returns the ResultSet of all Tickets that match the search
     */
    public ResultSet searchTicket(int whichCase, int id, String src, String dest)
    {
        //Cases     1- id   2- src  3-dest  4-src and dest
        ResultSet myRs = null;
        PreparedStatement create = null;
        try {
            if (whichCase == 1) {
                create = myConn.prepareStatement("SELECT * FROM Tickets WHERE FlightID=?");
                create.setInt(1, id);
            } else if (whichCase == 2) {
                create = myConn.prepareStatement("SELECT * FROM Tickets WHERE Source=?");
                create.setString(1, src);

            } else if (whichCase == 3) {
                create = myConn.prepareStatement("SELECT * FROM Tickets WHERE Destination=?");
                create.setString(1, dest);

            } else if (whichCase == 4) {
                create = myConn.prepareStatement("SELECT * FROM Tickets WHERE Source=? AND Destination=?");
                create.setString(1, src);
                create.setString(2, dest);

            } else {
                System.err.println("Invalide parameter for Case in serachTickets");
                System.exit(1);
            }

            //Execute Statement
            myRs = create.executeQuery();

        }catch (SQLException e){
            System.err.println("Error Executing searchTicket method");
            e.printStackTrace();
            System.exit(1);
        }
        return myRs;
    }

    /**
     * Constructs a new DataBase class
     */
    public DataBase()
    {
        System.out.println("Start");
        initializeConnection();
        if(populateNeeded) {
            insertFlightFromFile("input.txt");
        }
        System.out.println("Done");
    }
}
