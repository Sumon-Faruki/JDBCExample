import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCDynamicDataInsert {

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
			
			
			String qString = "insert into table1(  tName,tCity) values (  ?,?) ";
			PreparedStatement preparedStatement =  connection.prepareStatement(qString);
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter name : ");
			String nameString = bufferedReader.readLine();
			
			System.out.println("Enter City : ");
			String cityString = bufferedReader.readLine();

			preparedStatement.setString(1, nameString);
			preparedStatement.setString(2, cityString); 
			
			
			preparedStatement.executeUpdate();
			System.out.println("Data Inserted");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		
		
		
		
	}

}
