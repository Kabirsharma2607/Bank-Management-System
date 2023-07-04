import java.lang.System.Logger;
import java.sql.*;
import java.util.logging.Level;

import javax.swing.JOptionPane;

public class Connect  {
	Connection cn;
	Statement st;
	
	public Connect() {
		//To connect to database
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost/bank", "root", "Kabir#2003");
			//To execute t
			st = cn.createStatement();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error Connecting to database");
		}
		
		
	}
	
}
