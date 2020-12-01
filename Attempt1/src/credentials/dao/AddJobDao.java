package credentials.dao;

import java.sql.* ;

import sqlConnect.SqlConnection;

public class AddJobDao {
	
	Connection con=null;
	public int update(String location,String area,String jobpost,String vacancy,String salary,String ivdt,String ivt,String ivtp,String skill,String mail) {
		System.out.println("Update Started");
		System.out.println(location+" "+area+" "+jobpost+" "+vacancy+" "+salary+" "+ivdt+" "+ivt+" "+skill+" "+mail);
		con=SqlConnection.dbConnector();
		String query="insert into job values(?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement st= con.prepareStatement(query);
			st.setString(1,location);
			st.setString(2,area);
			st.setString(3,jobpost);
			st.setString(4,vacancy);
			st.setString(5,salary);
			st.setString(6,ivdt);
			st.setString(7,ivt);
			st.setString(8,ivtp);
			st.setString(9,skill);
			st.setString(10, mail);
			int i=st.executeUpdate();
			System.out.println("added job");
			return i;
		} catch (SQLException e) {System.out.println(e);System.out.println("Something went wrong");}
		return 0;
	}

}

