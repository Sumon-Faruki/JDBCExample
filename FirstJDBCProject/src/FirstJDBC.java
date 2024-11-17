import java.sql.*;

public class FirstJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			//loading the driver
			Class.forName("com.mysql.jdbc.Driver");
			//creating a connection
			
			String url  = "jdbc:mysql://localhost:3306/youtube?useSSL=false";
			String username = "root";
			String password = "root";
			
			Connection connection = DriverManager.getConnection(url, username, password);
			
			if(connection.isClosed()) {
				System.out.println("Conncetion is closed.");
			}else {
				System.out.println("Connection created...");
			}
			
			//create a query
			String q  =  "CREATE TABLE table1 (    tId int NOT NULL AUTO_INCREMENT,    tName varchar(255) NOT NULL,    tCity varchar(255),     PRIMARY KEY (tId))";
			  
			//create a statement
			Statement statement = connection.createStatement();
			statement.executeUpdate(q);
			System.out.println("table creatted in data base...");
			connection.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
