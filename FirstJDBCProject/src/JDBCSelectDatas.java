import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCSelectDatas {

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
			
			
			String qString = "select * from table1 ";


			Statement statement  =   connection.createStatement();
			ResultSet set= statement.executeQuery(qString);
			 
			while(set.next()) {
				int id = set.getInt(1);
				String nameString = set.getString(2);
				String cityString =set.getString(3);
				
				System.out.println(id + " = " +nameString +   " = " +  cityString);
			}
			 
			System.out.println("Data fetched");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
