package localhost.javaSailsRestDemo.employee;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Class holds a method to delete an employee based on their employeeID. The
 * deleteEmployee method take in the employeeID as a parameter then build a URL
 * to send to the API.
 * 
 * @author William Kratz
 * @since 9-7-16
 */

public class Delete {
	// endpoint is the location port on the local host where the employee
	// database connects
	protected static String endpoint = "http://localhost:1337/employee";
	// charset is the format used to encode the strings
	protected static String charset = "UTF-8";

	// method takes in an employeeID to be deleted. It them
	// prepares the URL needed to send to the API
	public static void deleteEmployee(int employeeID) {
		try {

			// request holds the complete URL to be passed sent to the API
			URL request = new URL(endpoint + "/" + employeeID);

			// opens connection with API, sends data via URL request
			HttpURLConnection connection = (HttpURLConnection) request.openConnection();
			connection.setRequestMethod("DELETE");

			// if anything other than a successful connection occurs, stop
			// program and display the error code
			if (connection.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + connection.getResponseCode());
			}

			// print out confirmation to the console if successful
			System.out.println("Employee Deleted.\n");

		} /* try */ catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// deleteEmployee()

}// class
