package credentials;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import credentials.dao.LoginDao;

public class LoginApp extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		HttpSession session = request.getSession();
		session.setAttribute("username", email);
		System.out.println("Email ID: "+email);
		System.out.println("Password: "+pass);
		 
		LoginDao dao = new LoginDao();
		if (dao.validate(email, pass)) {

			session.setAttribute("username", email);
			
			if (email.equals("admin@jobportal.com")) {
				RequestDispatcher dd = request.getRequestDispatcher("Admin.jsp");
				dd.forward(request, response);

			} else {
				RequestDispatcher dd = request.getRequestDispatcher("ApplicantPage.jsp");
				dd.forward(request, response);		
			}

		} else if (email != "" && pass != "") {
			
            request.setAttribute("errorValue", "False");
            RequestDispatcher rd = request.getRequestDispatcher("Error");
            rd.forward(request, response);

		} else {
			RequestDispatcher d = request.getRequestDispatcher("index.html");
			d.forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
}
}