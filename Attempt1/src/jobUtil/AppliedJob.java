package jobUtil;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jobBean.Job;
import jobBean.dao.JobDao;


public class AppliedJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Jpost=request.getParameter("id");
		String Company=request.getParameter("comp");
		System.out.println("id"+Jpost);
		System.out.println("cmail"+Company);
		try {Job Ajobs =JobDao.applylist(Jpost, Company);
		 request.setAttribute("ApplyJobList",Ajobs);
		 request.getRequestDispatcher("Apply.jsp").forward(request, response);
	}
		catch (SQLException e) {System.out.println(e);}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {doGet(request, response);}

}

