package jdbcDemo;

import java.sql.*;

public class SecondExample {

	static String QUERY = "SELECT user_id, first_name, last_name FROM sys_user_m WHERE user_id = ? AND status = ?";
    static Connection conn;
    static PreparedStatement pstmt;
    static ResultSet rs;

    public static void main(String[] args) throws Exception{
        // Open a connection
    	
    	
        try {
           
        	conn = DatabaseConfig.setDBConnection();
            pstmt=conn.prepareStatement(QUERY);
            pstmt.setInt(1, 1);
            pstmt.setInt(2, 1);
        		
                rs = pstmt.executeQuery(); 
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
        	pstmt.close();
        	conn.close();
        }
    }
}
