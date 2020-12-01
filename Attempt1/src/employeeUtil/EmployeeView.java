package employeeUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employeeBean.Employee;
import credentials.dao.EmployeeDao;

public class EmployeeView extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		 try {List<Employee> employee = EmployeeDao.list();
		 request.setAttribute("EmployeeViewList",employee);
		 request.getRequestDispatcher("EmployeeView.jsp").forward(request, response);
		 
		 } catch (SQLException e) {System.out.println(e);}
		 
		 
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
