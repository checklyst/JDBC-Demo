package jdbcDemo;

import java.sql.*;

public class ThirdExample {
	
	static String QUERY = "CALL P_getUserRecord(?)";
    static Connection conn;
    static CallableStatement cstmt;
    static ResultSet rs;


    public static void main(String[] args) throws Exception{
        // Open a connection
    	
    	
        try {
           
        	conn = DatabaseConfig.setDBConnection();
        	cstmt =conn.prepareCall(QUERY);
        	cstmt.setInt(1, 1);
        		
        		
                rs = cstmt.executeQuery(); 
	            // Extract data from result set
	            while (rs.next()) {
	                // Retrieve by column name
	            	 System.out.print("ID: " + rs.getInt("user_id")+"\n");
		             System.out.print("First Name: " + rs.getString("first_name")+"\n");
		             System.out.print("Last Name: " + rs.getString("last_name")+"\n");
		             System.out.print("========================================\n");
	            }
                
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
        	
        	rs.close();
        	cstmt.close();
        	conn.close();
        }
    }
}
