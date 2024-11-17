import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUpdate {
 
		// TODO Auto-generated method stub
	 public static void main(String[] args) {
		 
		try {
			
			Connection connection = ConnectionProvider.getConnection();
			
			

			String qString = "update table1 set  tName = ?, tCity=? where tName=? ";
			PreparedStatement preparedStatement =  connection.prepareStatement(qString);
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter name : ");
			String nameString = bufferedReader.readLine();
			
			System.out.println("Enter City : ");
			String cityString = bufferedReader.readLine();
			

			System.out.println("Enter the update name : ");
			String uName = bufferedReader.readLine();

			preparedStatement.setString(1, nameString);
			preparedStatement.setString(2, cityString); 
			preparedStatement.setString(3, uName); 
			
			
			preparedStatement.executeUpdate();
			System.out.println("Data updated");
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 
		 
		 
		 
		 
		 
	 }
	
}
