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
import jobBean.dao.JobDao;
import credentials.dao.EmployeeDao;

public class Jobs extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		HttpSession session = request.getSession();
		//System.out.println(session.getAttribute("username"));
		EmployeeDao d = new EmployeeDao();
		System.out.println(d.checkCV((String)session.getAttribute("username")));
		if(d.checkCV((String)session.getAttribute("username"))==1) {		
		 try {List<Job> jobs =JobDao.list();
		 request.setAttribute("JobList",jobs);
		 request.getRequestDispatcher("JobApply.jsp").forward(request, response);
		 
		 } catch (SQLException e) {System.out.println(e);}
		}else
        {
           request.getRequestDispatcher("UploadResume.jsp").forward(request, response);
}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
