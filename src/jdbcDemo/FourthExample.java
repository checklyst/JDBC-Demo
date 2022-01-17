package jdbcDemo;

import java.sql.*;

public class FourthExample {

	static String QUERY = "INSERT INTO `sys_user_m` (`first_name`, `last_name`, `email`) VALUES (?, ?, ?);";
	

    public static void main(String[] args) {
        // Open a connection
    	
    	
        try {
        	
        	Connection conn = DatabaseConfig.setDBConnection();
            PreparedStatement stmt=conn.prepareStatement(QUERY);
            stmt.setString(1, "Mohan");
            stmt.setString(2, "Kutty");
            stmt.setString(3, "mohan@meraemi.com");

        		
                int status = stmt.executeUpdate(); 
	            // Extract data from result set
	            if (status == 1) {
	                // Retrieve by column name
	                System.out.print("User Record successfully Inserted");
	            }else {
	            	System.out.print("Error inserting user record");
	            }
                
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
