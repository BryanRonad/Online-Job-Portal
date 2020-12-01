package jobUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jobBean.Job;
import jobBean.TotalApplication;
import jobBean.dao.JobDao;

public class JobViewCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		HttpSession session = request.getSession(false);
		String cname = (String) session.getAttribute("username");
		System.out.println(cname);
		 try {List<Job> jobs =JobDao.jobViewCompany(cname);
		 request.setAttribute("JobList",jobs);
		 request.getRequestDispatcher("JobViewCompany.jsp").forward(request, response);
		 
		 } catch (SQLException e) {System.out.println(e);}
		 
		 
		 
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
