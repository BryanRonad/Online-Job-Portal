package jobUtil;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import application.SendMail;
import jobBean.dao.JobDao;

public class UpdateApplications extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		String Jpost=request.getParameter("post");
		String Company=request.getParameter("comp");
		String Uemail=request.getParameter("uemail");
		String Uname=request.getParameter("uname");
		HttpSession session = request.getSession(false);
		String user = (String) session.getAttribute("username");
		System.out.println(Jpost);
		System.out.println(Company);
		System.out.println(Uemail);
		System.out.println(Uname);
		PrintWriter p = response.getWriter();
		JobDao d=new JobDao();
		if(d.updateApprove(Jpost, Company)!=0) {
			p.println("<script>alert('Approved Successfully')</script>");
			if(user=="admin@admin.com")
			response.setHeader("Refresh", "1;Admin.jsp");
			else
			response.setHeader("Refresh", "1;CompanyHome.jsp");
			
			String subject = "Your application has been approved!";
            String content = "Hi, "+Uname+"!\nYour application has been approved by "+Company+" for the job post of "+Jpost+"!";
            try {
				SendMail.sendMail(Uemail, subject, content);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			p.println("<script>alert('Approve failed')</script>");
			response.setHeader("Refresh", "1;AppliedJobs.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {doGet(request, response);}

}

