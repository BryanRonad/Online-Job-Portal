package credentials;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import credentials.dao.EmployeeDao;
import application.SendMail;

public class RegisterUser extends HttpServlet {
	
    public RegisterUser() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter p = response.getWriter();
		response.setContentType("text/html");
		String Uemail = request.getParameter("email");
	 	String Ufname = request.getParameter("firstName");
	 	String Ulname = request.getParameter("lastName");
	 	String Password = request.getParameter("passwd");
	 	String gen = request.getParameter("gender");
	 	String exp =request.getParameter("exp_in_years");
	 	String PI =request.getParameter("industry");
	 	String skill=request.getParameter("keySkills");
	 	
	 	EmployeeDao dao=new EmployeeDao();
	 	if(dao.registerUser(Uemail,Ufname,Ulname,Password,gen,exp,PI,skill)==1) {
	 		p.println("<script>alert('User Registered Successfully.')</script>");
			response.setHeader("Refresh", "1;index.html");
			
			String subject = "Welcome, Seeker!";
            String content = "Hi, "+Ufname+" "+Ulname+"!\nWelcome to JobStudio. A place where you can find your dream job in a few clicks :D";
            try {
				SendMail.sendMail(Uemail, subject, content);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 	}else {
	 		p.println("<script type=\"text/javascript\">"); 
			p.println("alert(\"Registration failed\")");
			p.println("</script>");
	 		
	 	}
	}

	
		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
