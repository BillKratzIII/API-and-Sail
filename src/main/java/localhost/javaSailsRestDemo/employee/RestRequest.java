package localhost.javaSailsRestDemo.employee;

import java.util.Scanner;

/**
 * Class displays a menu and continues running until the user selects to exit to
 * the program. Options include display all employees, find and display a single
 * employee, update an employee, delete an employee and add a new employee.So
 * long as a valid entry is submitted, methods will be called from other
 * classes.
 *
 * @author William Kratz
 * @since 9-7-16
 */
public class RestRequest {

	public static void main(String[] args) {
		// employeeID holds the integer to be used to identify employee id to
		// display, update or delete
		int employeeID;
		// stillRunning is true so long as the user wishes the program to
		// continue looping
		boolean stillRunning = true;
		// userInput is used to store input from the Scanner
		String userInput = null;
		// Scanner is used to collect input from the user through the console
		Scanner sc = new Scanner(System.in);

		// Program will continue and loop the menu until the user selects the
		// option to exit
		while (stillRunning) {
			// print menu options
			printMenu();
			userInput = sc.nextLine();

			// switch statement will call methods based on the user's input
			switch (userInput) {
			// case 1 will display all employees in system
			case "1":
				GetAll.getAllEmployees();
				break;
			// case 2 will display a single employee based off their employee ID
			case "2":
				System.out.println("OK, I'll find one employee for you.");
				employeeID = getEmployeeID();
				GetSingle.getEmployee(employeeID);
				break;
			// case 3 will update a single employee determined by their employee
			// ID
			case "3":
				System.out.println("OK, I'll update an employee for you.");
				employeeID = getEmployeeID();
				Update.updateEmployee(employeeID);
				break;
			// case 4 will delete an employee based off their employee ID
			case "4":
				System.out.println("OK, I'll delete an employee for you.");
				employeeID = getEmployeeID();
				Delete.deleteEmployee(employeeID);
				break;
			// case 5 will add a new employee to the system
			case "5":
				Add.addEmployee();
				break;
			// case 6 will cause the program to stop looping
			case "6":
				System.out.println("Goodbye");
				stillRunning = false;
				break;
			// if no valid selections are found, print an error message and
			// continue looping
			default:
				System.out.println("Invalid selection, please try again.");
				break;
			}
		}
		
		// close scanner
		sc.close();
	}

	// method displays menu options to the user through the console
	public static void printMenu() {
		System.out.println("Please select from an option below:");
		System.out.println("1 - display all employees");
		System.out.println("2 - display single employee");
		System.out.println("3 - update employee");
		System.out.println("4 - delete employee");
		System.out.println("5 = add new employee");
		System.out.println("6 - exit program");
	}// printMenu()

	// method prompts user to enter the employee id, takes the user input from
	// the console through a Scanner then returns the employee ID
	public static int getEmployeeID() {
		int employeeID;
		Scanner sr = new Scanner(System.in);
		
		System.out.println("Please enter the employee ID:");
		employeeID = sr.nextInt();
		
		return employeeID;
	}// getEmployeeID()
	
}// class
