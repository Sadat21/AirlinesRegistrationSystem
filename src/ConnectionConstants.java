/**
 * This interface stores constants that are used throughout our program.
 * @author Brian Pho, Harjee Johal, Sadat Islam
 */
public interface ConnectionConstants {

    /**
     * This is the IP of the server
     */
	String HOST = "localhost";
    /**
     * This is the port being used on the Server
     */
	int PORT = 10000;
    /**
     * This is the default value. We associate this with doing no action when any String has this value
     */
	String DEFAULT = "-1\n";
    /**
     * Name of schema used to create the tables on the database
     */
	String SCHEMA = "airlinedata";
    /**
     * Username used to access the database
     */
	String USER = "root";
    /**
     * Password used to access the database
     */
	String PASS = "HP2159m";
}
