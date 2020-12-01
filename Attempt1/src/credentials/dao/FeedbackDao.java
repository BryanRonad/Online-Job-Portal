package credentials.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sqlConnect.SqlConnection;

public class FeedbackDao {
	
	static Connection con = null;
	
	public int giveFeedback(String email, String feedback) {
		try {
			con = SqlConnection.dbConnector();
			String query = "insert into feedback values(?,?)";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, email);
			st.setString(2, feedback);
			//st.setString(3, Ulname);
			int i = st.executeUpdate();
			return i;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return 0;
	}

}
