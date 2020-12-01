package jobUtil;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.SendMail;
import jobBean.dao.JobDao;

public class SubmitJobApply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String CompanyName=request.getParameter("Cname");
		String JobPost=request.getParameter("Jpost");
		String Email=request.getParameter("email");
		String FullName=request.getParameter("Fname");
		String MobileNo=request.getParameter("Mno");
		String Skills=request.getParameter("skill");
		
		JobDao d=new JobDao();
		PrintWriter p = response.getWriter();
		if(d.applyToJob(CompanyName,JobPost,Email,FullName,MobileNo,Skills)==1) {
			p.println("<script>alert('Applied To Job  Successfully.')</script>");
			response.setHeader("Refresh", "1;ApplicantPage.jsp");
			
			String subject = "Application sent!";
            String content = "Hi, "+FullName+"!\nYour job application has been sent to "+CompanyName+" for the post of "+JobPost;
            try {
				SendMail.sendMail(Email, subject, content);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 	}else {
	 		p.println("<script>alert('Application Failed')</script>");
	 		response.setHeader("Refresh", "1;ApplicantPage.jsp");
	 		
	 	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {doGet(request, response);}

}

