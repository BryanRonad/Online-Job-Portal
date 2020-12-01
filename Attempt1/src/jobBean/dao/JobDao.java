package jobBean.dao;

import java.util.ArrayList;
import java.util.List;

import jobBean.Job;
import jobBean.TotalApplication;
import sqlConnect.SqlConnection;

import java.sql.*;

public class JobDao {

	static Connection con = null;

	public static List<Job> list() throws SQLException {

		List<Job> jobs = new ArrayList<Job>();
		try {
			con = SqlConnection.dbConnector();
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from job");

			while (resultSet.next()) {
				Job j = new Job();
				j.setLocation(resultSet.getString("location"));
				j.setFarea(resultSet.getString("area"));
				j.setJpost(resultSet.getString("post"));
				j.setVacancy(resultSet.getInt("vacancy"));
				j.setSalary(resultSet.getString("salary"));
				j.setIdate(resultSet.getString("ivdate"));
				j.setItime(resultSet.getString("ivtime"));
				j.setIplace(resultSet.getString("ivplace"));
				j.setSkills(resultSet.getString("skill"));
				j.setCompany(resultSet.getString("mail"));
				jobs.add(j);
				
			}
			return jobs;
		} catch (Exception e) {System.out.println(e);}
		return null;

	}
	public static Job applylist(String post,String company) throws SQLException {
		try {
			con = SqlConnection.dbConnector();
			PreparedStatement  statement = con.prepareStatement("select * from job where post=? and mail=?");
			statement.setString(1, post);
			statement.setString(2, company);
			ResultSet resultSet = statement.executeQuery();
			
			Job j = new Job();
			while (resultSet.next()) {
				j.setJpost(resultSet.getString("post"));
				j.setCompany(resultSet.getString("mail"));
			
			}
			return j;
		} catch (Exception e) {System.out.println(e);}
		
		return null;}
	
	public static List<Job> jobViewCompany(String company) throws SQLException {
		List<Job> jobs = new ArrayList<Job>();
		try {
			con = SqlConnection.dbConnector();
			PreparedStatement  statement = con.prepareStatement("select * from job where mail=?");
			statement.setString(1, company);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				Job j = new Job();
				j.setLocation(resultSet.getString("location"));
				j.setFarea(resultSet.getString("area"));
				j.setJpost(resultSet.getString("post"));
				j.setVacancy(resultSet.getInt("vacancy"));
				j.setSalary(resultSet.getString("salary"));
				j.setIdate(resultSet.getString("ivdate"));
				j.setItime(resultSet.getString("ivtime"));
				j.setIplace(resultSet.getString("ivplace"));
				j.setSkills(resultSet.getString("skill"));
				j.setCompany(resultSet.getString("mail"));
				jobs.add(j);
			
			}
			return jobs;
		} catch (Exception e) {System.out.println(e);}
		
		return null;}
	
	public int applyToJob(String CompanyName,String JobPost,String Email,String FullName, String MobileNo,String Skills) {
		try {
			con = SqlConnection.dbConnector();
			String query = "INSERT INTO appliedjobs VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(query);
			String Applied="yes";
			String Approved="no";
			st.setString(1, CompanyName);
			st.setString(2, JobPost);
			st.setString(3, Email);
			st.setString(4, FullName);
			st.setString(5, MobileNo);
			st.setString(6, Skills);
			st.setString(7, Applied);
			st.setString(8, Approved);
			int i = st.executeUpdate();
			return i;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	public static List<TotalApplication>appliedJobs() {
		List<TotalApplication> TA = new ArrayList<TotalApplication>();
		try {
			con = SqlConnection.dbConnector();
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from appliedjobs");

			while (resultSet.next()) {
				TotalApplication t = new TotalApplication();
				t.setCompanyName(resultSet.getString("companyname"));
				t.setJobPost(resultSet.getString("jobpost"));
				t.setEmail(resultSet.getString("email"));
				t.setFullName(resultSet.getString("fullname"));
				t.setMobileNo(resultSet.getString("mobile"));
				t.setSkills(resultSet.getString("skills"));
				t.setApplied(resultSet.getString("applied"));
				t.setApproved(resultSet.getString("approved"));
				System.out.println(t);
			    TA.add(t);
			}
		   return TA;
		} catch (Exception e) {System.out.println(e);}
		return null;
		
	}
	
	public static List<TotalApplication>appliedJobsCompany(String cname) {
		List<TotalApplication> TA = new ArrayList<TotalApplication>();
		try {
			System.out.println(cname);
			con = SqlConnection.dbConnector();
			PreparedStatement statement = con.prepareStatement("select * from appliedjobs where companyname = ?");
			statement.setString(1, cname);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				TotalApplication t = new TotalApplication();
				t.setCompanyName(resultSet.getString("companyname"));
				t.setJobPost(resultSet.getString("jobpost"));
				t.setEmail(resultSet.getString("email"));
				t.setFullName(resultSet.getString("fullname"));
				t.setMobileNo(resultSet.getString("mobile"));
				t.setSkills(resultSet.getString("skills"));
				t.setApplied(resultSet.getString("applied"));
				t.setApproved(resultSet.getString("approved"));
				System.out.println(t);
			    TA.add(t);
			}
		   return TA;
		} catch (Exception e) {System.out.println(e);}
		return null;
		
	}

public int updateApprove(String jpost,String company) {
	try {
		con=SqlConnection.dbConnector();
		String Query="UPDATE appliedjobs SET Approved =? where JobPost=? and CompanyName=?";
	    String approve="yes";
		PreparedStatement st = con.prepareStatement(Query);
		st.setString(1, approve);
		st.setString(2, jpost);
		st.setString(3, company);
		int i = st.executeUpdate();
		System.out.println(i);
		return i;
	}
 catch (Exception e) {System.out.println(e);}
	return 0;
	}

public int deleteJob(String jpost,String company) {
	try {
		con=SqlConnection.dbConnector();
		String Query1="DELETE FROM job where post=? and mail=?";
		PreparedStatement st = con.prepareStatement(Query1);
		st.setString(1, jpost);
		st.setString(2, company);
		
		String Query2="DELETE FROM appliedjobs where companyname=? AND jobpost=?";
		PreparedStatement st2 = con.prepareStatement(Query2);
		st2.setString(1, company);
		st2.setString(2, jpost);
		if(st.executeUpdate()==1 && st2.executeUpdate()==1)
			{return 1;}
		else
		{
			return 0;
		}
	}
 catch (Exception e) {System.out.println(e);}
	return 0;
	}
}