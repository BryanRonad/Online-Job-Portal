package jobUtil;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jobBean.dao.JobDao;

public class DeleteJob extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		String Jpost=request.getParameter("post");
		String Company=request.getParameter("comp");
		HttpSession session = request.getSession(false);
		String user = (String) session.getAttribute("username");
		System.out.println(Jpost);
		System.out.println(Company);
		PrintWriter p = response.getWriter();
		JobDao d=new JobDao();
		if(d.deleteJob(Jpost, Company)==1) {
			p.println("<script>alert('Job Deleted Successfully')</script>");
			if(user=="admin@admin.com")
			response.setHeader("Refresh", "1;Admin.jsp");
			else
			response.setHeader("Refresh", "1;CompanyHome.jsp");
		}
		else
		{
			p.println("<script>alert('Deletion failed')</script>");
			response.setHeader("Refresh", "1;JobViewCompany.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {doGet(request, response);}

}
