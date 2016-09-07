package localhost.javaSailsRestDemo.employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetSingle {
	protected static String endpoint = "http://localhost:1337/employee";
	protected static String charset = "UTF-8";

	public static void getEmployee(int employeeID) {
		try {

			URL request = new URL(endpoint + "/" + employeeID);
			HttpURLConnection connection = (HttpURLConnection) request.openConnection();
			connection.setRequestMethod("GET");

			if (connection.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + connection.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));

			while (br.readLine() != null) {
				System.out.println(br.readLine());
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
