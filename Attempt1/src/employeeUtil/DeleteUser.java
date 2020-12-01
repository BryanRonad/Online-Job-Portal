package employeeUtil;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import credentials.dao.EmployeeDao;

public class DeleteUser extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		String email = request.getParameter("email");
		System.out.println(email + "deleted");
		PrintWriter p = response.getWriter();
		EmployeeDao e = new EmployeeDao();
		if(e.deleteUser(email)==1) {
			p.println("<script>alert('User Deleted Successfully')</script>");
			response.setHeader("Refresh", "1;Admin.jsp");
		}
		else
		{
			p.println("<script>alert('Deletion Failed')</script>");
			response.setHeader("Refresh", "1;EmployeeView.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {doGet(request, response);}

}
