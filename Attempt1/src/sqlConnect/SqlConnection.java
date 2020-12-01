package sqlConnect;

import java.sql.*;

public class SqlConnection {
	
	public static Connection dbConnector()
	{
	    try {
	    	
	    	String url = "jdbc:mysql://localhost:3306/opd";
	    	Class.forName ("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance ();
	    	Connection conn = DriverManager.getConnection (url, "root", "ntusm123");
	    
	    	return conn;
	    	
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e);
	    	return null; 	
	    }
	}

}
