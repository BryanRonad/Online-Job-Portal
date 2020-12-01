package credentials;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import credentials.dao.FeedbackDao;

public class Feedback extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter p = response.getWriter();
		response.setContentType("text/html");
		String email = request.getParameter("email");
	 	String feedback = request.getParameter("subject");
	 	//String Ulname = request.getParameter("rating");
	 	
	 	FeedbackDao dao=new FeedbackDao();
	 	if(dao.giveFeedback(email,feedback)==1) {
	 		p.println("<script>alert('Feedback given successfully')</script>");
			response.setHeader("Refresh", "1;index.html");
	 	}else {
	 		p.println("<script type=\"text/javascript\">"); 
			p.println("alert(\"Feedback submission failed\")");
			p.println("</script>");
	 		
	 	}
	}

	
		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

