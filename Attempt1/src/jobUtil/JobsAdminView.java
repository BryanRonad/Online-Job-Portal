package jobUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import jobBean.Job;
import jobBean.dao.JobDao;

public class JobsAdminView extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		 try {List<Job> jobs =JobDao.list();
		 request.setAttribute("JobViewList",jobs);
		 request.getRequestDispatcher("JobView.jsp").forward(request, response);
		 
		 } catch (SQLException e) {System.out.println(e);}
		 
		 
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
