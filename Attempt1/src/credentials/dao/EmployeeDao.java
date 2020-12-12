package credentials.dao;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import employeeBean.Employee;
import jobBean.Job;
import sqlConnect.SqlConnection;

public class EmployeeDao {

	static Connection con = null;

	public int registerUser(String Uemail, String Ufname, String Ulname, String Password, String gen,
			String exp, String PI, String skill) {
		try {
			con = SqlConnection.dbConnector();
			String query = "insert into employee values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, Uemail);
			st.setString(2, Ufname);
			st.setString(3, Ulname);
			st.setString(4, Password);
			st.setString(5, gen);
			st.setString(6, exp);
			st.setString(7, PI);
			st.setString(8, skill);
			st.setNull(9, java.sql.Types.NULL);
			int i = st.executeUpdate();
			return i;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return 0;
	}

	public static int update(Employee e, String Umail) {
		int status = 0;

		try {
			System.out.println("mail from DAO"+Umail);

			con = SqlConnection.dbConnector();
			PreparedStatement st = con.prepareStatement(
					"UPDATE employee SET FirstName= ?, LastName=?, Password=?, Gender= ?, Experience = ?,  Industry= ?, keySkills =? WHERE email =? ");
			st.setString(1, e.getUfname());
			st.setString(2, e.getUlname());
			st.setString(3, e.getPassword());
            st.setString(4, e.getGen());
			st.setString(5, e.getExp());
			st.setString(6, e.getPI());
			st.setString(7, e.getSkill());
			st.setString(8, Umail);
			status = st.executeUpdate();
			if (status > 0) {
				System.out.println("Updated successfully");
			}
			return status;
		} catch (Exception e1) {
			System.out.println(e1);
		}
		return 0;
	}

	public static Employee getEmployeeById(String Uemail) {
		Employee e = new Employee();
	
		try {
			con = SqlConnection.dbConnector();
			PreparedStatement ps = con.prepareStatement("select * from employee where Email=?");
			ps.setString(1, Uemail);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				e.setUemail(rs.getString((1)));
				e.setUfname(rs.getString(2));
				e.setUlname(rs.getString(3));
				e.setPassword(rs.getString(4));
				e.setGen(rs.getString(5));
				e.setExp(rs.getString(6));
				e.setPI(rs.getString(7));
				e.setSkill(rs.getString(8));
				System.out.println("Get emp by id"+e);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return e;
	}
	
	public static List<Employee> list() throws SQLException {

		List<Employee> employee = new ArrayList<Employee>();
		try {
			con = SqlConnection.dbConnector();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select * from employee where email!='admin@jobportal.com'");
			while (rs.next()) {
				Employee e = new Employee();
				e.setUemail(rs.getString((1)));
				e.setUfname(rs.getString(2));
				e.setUlname(rs.getString(3));
				e.setPassword(rs.getString(4));
				e.setGen(rs.getString(5));
				e.setExp(rs.getString(6));
				e.setPI(rs.getString(7));
				e.setSkill(rs.getString(8));
				employee.add(e);
				
			}
			return employee;
		} catch (Exception e) {System.out.println(e);}
		return null;

	}

	public  int uploadResume(String email,InputStream resume) {
		
			int status = 0;
		try {
			System.out.println(email);
		
			con = SqlConnection.dbConnector();
			PreparedStatement st = con.prepareStatement("UPDATE employee SET resume=? WHERE email =?");
			
			st.setBlob(1, resume);
			st.setString(2, email);
			status = st.executeUpdate();
		  return status;
		  }
		catch(Exception e) {System.out.println(e);}
		return 0;
		}
	
	public Blob downloadResume(String Email) {
		try {
			
			System.out.println("download resume called");
		System.out.println("DR1::"+Email);
			con = SqlConnection.dbConnector();
			PreparedStatement st = con.prepareStatement("select resume from employee where email=?");
			st.setString(1, Email);
			
			ResultSet result = st.executeQuery();
			System.out.println(result);
			if(result.next()) {
		    Blob EResume = result.getBlob("resume");
		    System.out.println("DR2::"+Email);
		    return EResume;
			}
		    
		           
			}
		catch(Exception e) {
			
		}
		return null;

		
	}
	
	public int deleteUser(String email) {
		try {
			con=SqlConnection.dbConnector();
			String Query="DELETE FROM employee WHERE Email = ?";
			PreparedStatement st = con.prepareStatement(Query);
			st.setString(1, email);
			int i = st.executeUpdate();
			return i;
		}
	 catch (Exception e) {System.out.println(e);}
		return 0;
		}
	
	public int uploadCV(String email,InputStream cv) {
		
		int status = 0;
	try {
		System.out.println(email);
	
		con = SqlConnection.dbConnector();
		PreparedStatement st = con.prepareStatement("UPDATE employee SET cv=? WHERE Email =?");
		
		st.setBlob(1, cv);
		st.setString(2, email);
		status = st.executeUpdate();
	  return status;
	  }
	catch(Exception e) {System.out.println(e);}
	return 0;
	}
	
	public Blob downloadCV(String Email) {
		try {
			
			System.out.println("download resume servlet called");
			System.out.println("CV of "+Email);
			con = SqlConnection.dbConnector();
			PreparedStatement st = con.prepareStatement("SELECT cv FROM employee WHERE Email=?");
			st.setString(1, Email);
			
			ResultSet result = st.executeQuery();
			System.out.println(result);
			if(result.next()) {
		    Blob cv = result.getBlob("cv");
		    System.out.println("CV Received");
		    return cv;
			}
		    
		           
			}
		catch(Exception e) {
			
		}
		return null;
	}
	
	public int checkCV(String Uemail) {
		con = SqlConnection.dbConnector();
		PreparedStatement st;
		try {
			st = con.prepareStatement("SELECT * FROM employee WHERE Email =? AND cv IS NOT NULL");
			st.setString(1, Uemail);
			ResultSet result = st.executeQuery();
			if(result.next())
			{
				return 1;
			}
			else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
	}
}

