package jdbcDemo;

import java.sql.*;

public class FifthExample {

	static String QUERY = "CALL P_addUserRecord(?, ?, ?, ?);";
	

    public static void main(String[] args) {
        // Open a connection
    	
        try {
        	Connection conn = DatabaseConfig.setDBConnection();
        	CallableStatement cstmt=conn.prepareCall(QUERY);
        	
            cstmt.setString(1, "Anant");
            cstmt.setString(2, "Naik");
            cstmt.setString(3, "anant@meraemi.com");
            cstmt.registerOutParameter(4, Types.INTEGER);
        		
                boolean status = cstmt.execute(); 
	            // Extract data from result set
	            if (status) {
	                
	                System.out.print("User Record successfully Inserted  with ->");
	                System.out.print(" User Id:"+cstmt.getInt(4));
	                
	            }else {
	            	System.out.print("Error inserting user record :"+status);
	            }
                
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
