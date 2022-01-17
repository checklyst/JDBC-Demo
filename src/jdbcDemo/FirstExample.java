package jdbcDemo;

import java.sql.*;

public class FirstExample {

    static final String QUERY = "SELECT user_id, first_name, last_name FROM sys_user_m";
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    

    public static void main(String[] args) throws Exception {

        // Open a connection
        try {
        	
             conn = DatabaseConfig.setDBConnection();
             stmt = conn.createStatement();
             rs = stmt.executeQuery(QUERY);
            
                // Extract data from result set
                while (rs.next()) {
                    // Retrieve by column name
                    System.out.print("ID: " + rs.getInt("user_id") + "\n");
                    System.out.print("First Name: " + rs.getString("first_name") + "\n");
                    System.out.print("Last Name: " + rs.getString("last_name") + "\n");
                    System.out.print("========================================\n");
                }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        	
        	rs.close();
        	stmt.close();
        	conn.close();
        }
    }

}
