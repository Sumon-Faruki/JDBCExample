 
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection; 
import java.sql.PreparedStatement;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;  


public class JDBCLargeImage {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Connection connection  =   ConnectionProvider.getConnection() ;
		
	try { 
				
			
			 	String qString= "insert into images(pic) values(?)";
				PreparedStatement preparedStatement =  connection.prepareStatement(qString); 
//				String filepathString = "/C:/Users/Ex Ten/Desktop/jdbc/60456.jpg";
//				
//				
//				System.out.println(filepathString);
				 
				JFileChooser jFileChooser = new JFileChooser();
				jFileChooser.showOpenDialog(null);
				File file =  jFileChooser.getSelectedFile();
				

				FileInputStream fileInputStream = new FileInputStream( file);
				
				preparedStatement.setBinaryStream(1, fileInputStream, fileInputStream.available() );
				
				
				preparedStatement.executeUpdate();
				System.out.println("Image Inserted");
			
			 JOptionPane.showMessageDialog(null, "sucess bro");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		
		

	}

}



