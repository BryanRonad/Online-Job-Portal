package credentials.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sqlConnect.SqlConnection;

public class LoginDao  {

	String query = "select * from employee where Email = ? and Password = ?";
	public boolean validate(String E_mail, String pass) {
		try {
			Connection con=SqlConnection.dbConnector();
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1,E_mail);
			st.setString(2, pass);
			ResultSet rs = st.executeQuery();
				if (rs.next()) 
				{return true;}
			} 
		catch (Exception e){System.out.println(e);}
		return false;

	
	}	
	 
}

