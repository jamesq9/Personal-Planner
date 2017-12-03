import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;




public class PP {

	/**
	 * @param args
	 */
	
	
public static LoginPage loginpage;
	
	public static void main(String[] args) {
		
		loginpage = new LoginPage();
		
		
	}


	// Throws an Error MEssage any where aytime 24x7 :-D
	public static void throwError(String head, String body) {
		// TODO Auto-generated method stub
		JOptionPane optionPane2 = new JOptionPane(body, JOptionPane.ERROR_MESSAGE,JOptionPane.DEFAULT_OPTION);
		
		JDialog dialog2 = optionPane2.createDialog(head);
		dialog2.setAlwaysOnTop(true);
		dialog2.setVisible(true);

	} // Error Message
	
	// Gives Connection to the database 
	public static Connection GimmeConnection(  ) {
		Connection conn = null;
		try {
           Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			PP.throwError("Error","JDBC DRIVER MISSING");
			System.exit(0);
		}
		try {
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", "system",
					"icecream");
		} catch (SQLException e) {
			PP.throwError("Connection Falied", "Check Output Console");
			System.exit(0);
		}
		if (conn == null) {
				PP.throwError("Error", "Coudn't Make a Conection To DB ");
				System.exit(0);
		} 
		return conn;
	} // GimmeConnection

	
} // classs
