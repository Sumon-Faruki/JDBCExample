import java.sql.*;
import java.sql.DriverManager; 

public class ConnectionProvider {
	
	private static Connection connection;
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		
		if(connection == null) {
			 

				//loading the driver
				Class.forName("com.mysql.jdbc.Driver");
				//creating a connection

				String url  = "jdbc:mysql://localhost:3306/youtube?useSSL=false";
				String username = "root";
				String password = "root";
				
				
 
			
				connection = DriverManager.getConnection(url, username, password);
  
			
		} 
		
 
	
	
		
		 return connection;
		
	}

}
