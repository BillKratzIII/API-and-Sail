package localhost.javaSailsRestDemo.employee;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

/**
 * Class holds a method to update an employee in the system based off their
 * employeeID. The updateEmployee method takes in an employee id as a parameter
 * and will prompt the user to enter necessary data, then build a URL to post to
 * the API.
 * 
 * @author William Kratz
 * @since 9-7-16
 */

public class Update {
	// endpoint is the location port on the local host where the employee
	// database connects
	protected static String endpoint = "http://localhost:1337/employee";
	// charset is the format used to encode the strings
	protected static String charset = "UTF-8";
	// Scanners are used to take in input from the user through the console.
	static Scanner sc = new Scanner(System.in);

	// method accepts the employeeID as a parameter and prompts user for fields
	// needed to create a new employee. It them
	// prepares the URL needed to POSTs to the API
	public static void updateEmployee(int employeeID) {
		try {
			// variables to be filled by user input
			String firstName = null;
			String lastName = null;
			String email = null;
			String homePhone = null;
			String cellPhone = null;
			String password = null;
			String active;

			// prompt user to enter data and store in variables
			System.out.println("What is the new first name?");
			firstName = sc.nextLine();
			System.out.println("What is the new last name?");
			lastName = sc.nextLine();
			System.out.println("What is the new email?");
			email = sc.nextLine();
			System.out.println("What is the new homePhone? (###-###-####)");
			homePhone = sc.nextLine();
			System.out.println("What is the new cellPhone? (###-###-####)");
			cellPhone = sc.nextLine();
			System.out
					.println("What is the new password? (must contain one lower case, one upper case and one number)");
			password = sc.nextLine();
			System.out.println("Is the employee active? Enter 1 for yes and 0 for no.");
			active = sc.nextLine();

			// query string holds the parameters to pass to the API
			String queryString = String.format(
					"firstName=%s&lastName=%s&email=%s&homePhone=%s&cellPhone=%s&password=%s&active=%s",
					URLEncoder.encode(firstName, charset), URLEncoder.encode(lastName, charset),
					URLEncoder.encode(email, charset), URLEncoder.encode(homePhone, charset),
					URLEncoder.encode(cellPhone, charset), URLEncoder.encode(password, charset),
					URLEncoder.encode(active, charset));

			// request holds the complete URL to be passed sent to the API
			URL request = new URL(endpoint + "/" + employeeID + "?" + queryString);

			// opens connection with API, sends data via URL request
			HttpURLConnection connection = (HttpURLConnection) request.openConnection();
			connection.setRequestMethod("PUT");

			// if anything other than a successful connection occurs, stop
			// program and display the error code
			if (connection.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + connection.getResponseCode());
			}

			// print out confirmation to the console if successful
			System.out.println("Employee Updated.\n");

		} /* try */ catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// updateEmployee()

}// class
