import javafx.scene.SceneAntialiasing;

import java.io.*;
import java.sql.*;
import java.util.Scanner;

/**
 * Database Used. Connection is static so should be able to use from any class after it's been instantiated by running
 * the main method in this class.
 * Created by Sadat Msi on 4/1/2017.
 */
public class DataBase {

    protected static Connection myConn;
    protected static Statement myStmt;


    public static void initializeConnection(){
        boolean tableCreated = true;
        try{
            //open a connection
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinedata?autoReconnect=true&useSSL=false",
                    "root", "297080004");
            //create a statement
            myStmt = myConn.createStatement();

            //create table 'flights' if table doesn't already exist
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

    public static void populate(){
        String INPUT_FILE = "input.txt";
        FileReader fr = null;
        try {
            fr = new FileReader(INPUT_FILE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("Error reading from input text file");
        }

        Scanner scan = new Scanner(fr);
        while(scan.hasNextLine()){
            String src = scan.next();
            String dest = scan.next();
            String date = scan.next();
            String time = scan.next();
            String dur = scan.next();
            int tot = Integer.parseInt(scan.next());
            int left = Integer.parseInt(scan.next());
            double price = Double.parseDouble(scan.next());

            //Create Prepared Statement and Execute
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

        System.out.println("Added records from input.txt to table 'Flights'");
    }






    public static void main(String [] args){
        System.out.println("Start");
        initializeConnection();
        populate();
        System.out.println("Done");
    }
}
