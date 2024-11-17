import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.*;

public class JDBCImageInsert {

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
			
			
			
			
			 	String qString= "insert into images(pic) values(?)";
				PreparedStatement preparedStatement =  connection.prepareStatement(qString);  
				String filepathString = "/C:/Users/Ex Ten/Downloads/60456.jpg";
				
				
				System.out.println(filepathString);
				FileInputStream fileInputStream = new FileInputStream(filepathString);
				preparedStatement.setBinaryStream(1, fileInputStream, fileInputStream.available() );
				
				
				preparedStatement.executeUpdate();
				System.out.println("Image Inserted");
			
			
//			
//			String qString = "insert into table1(tName,tCity) values (?,?) ";
//				PreparedStatement preparedStatement =  connection.prepareStatement(qString);
//			
//
//			preparedStatement.setString(1, "name");
//			preparedStatement.setString(2, "city"); 
//			
//			
//			preparedStatement.executeUpdate();
//			System.out.println("Data Inserted");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		
		

	}

}