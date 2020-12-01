package jobUtil;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jobBean.TotalApplication;
import jobBean.dao.JobDao;

public class ApproveJobs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		 List<TotalApplication> TotalJ =JobDao.appliedJobs();
		 request.setAttribute("TotalJobs",TotalJ);
		 request.getRequestDispatcher("AppliedJobs.jsp").forward(request, response);
		 
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		}

}

