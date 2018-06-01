package dataAccessLayer;
import java.sql.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Connection;


public class DBConnection {

	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/nationalthdb?autoReconnect=true&useSSL=false";
    private String USER = "root";
	private String PASS = "newpassword";
	private Connection connection;
	
	public DBConnection(String db)
	{
		 try {
	            Class.forName(DRIVER);
	            connection = (Connection) DriverManager.getConnection(DBURL + db, USER, PASS);
	            
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	}
	
	public DBConnection()
	{
		 try {
	            Class.forName(DRIVER);
	            connection = (Connection) DriverManager.getConnection(DBURL , USER, PASS);
	            
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	}
	
	
	
	  public boolean testConnection() throws SQLException {
	        return connection.isValid(5);
	    }

	    public Connection getConnection() {
	        return connection;
	    }
	
}
