package credentials.dao;

import java.sql.*;

import sqlConnect.SqlConnection;
public class RegisterCompanyDao {
	Connection con=null;
	public int update(String s1,String s2,String s3,String s4) {
		con=SqlConnection.dbConnector();
		String query = "INSERT INTO company VALUES (?,?,?,?)";
		PreparedStatement st;
		try {
			st = con.prepareStatement(query);
			st.setString(1,s4);
			st.setString(2,s1);
			st.setString(3,s3);
			st.setString(4, s2);
			int i=st.executeUpdate();
			return i;
		} catch (SQLException e) {e.printStackTrace();}
		return 0;
		
	}

}

