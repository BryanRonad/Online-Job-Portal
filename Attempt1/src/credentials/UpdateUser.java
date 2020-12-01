package credentials;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import credentials.dao.EmployeeDao;
import employeeBean.Employee;

public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<link rel ='stylesheet' type='text/css' href='header.css'>");
        out.println("<style>body {padding-top:150px;font-family: montserrat;background: #fffff0;}</style>");
        HttpSession session=request.getSession(); 
        String Umail=(String)request.getAttribute("username");
        System.out.println("session "+session.getAttribute("username"));
      
          
        Employee e = EmployeeDao.getEmployeeById((String)session.getAttribute("username"));  
        out.print("<body style='padding-top:0px;'>");
        out.println("<header>\r\n" + 
        		"	<h3>JobStudio</h3>\r\n" + 
        		"	<ul>\r\n" + 
        		"		<li><a href=\"ApplicantPage.jsp\">Home</a></li>\r\n" + 
        		"		<li><a href=\"Logout\">Logout</a></li>\r\n" + 
        		"	</ul>\r\n" + 
        		"</header>");
        out.print("<center>");
        out.println("<h1>Update Info</h1>");
        out.print("<form action='UpdatedUser' method='POST'>");  
        out.print("<table>");  
        //out.print("<tr><td></td><td><input type='hidden' name='E-mail' value='"+e.getUemail()+"'/></td></tr>");  
        out.print("<tr><td>FirstName:</td><td><input type='text' name='FirstName' value='"+e.getUfname()+"'/></td></tr>");  
        out.print("<tr><td>LastName:</td><td><input type='text' name='LastName' value='"+e.getUlname()+"'/></td></tr>");    
        out.print("<tr><td>password:</td><td><input type='password' name='Password' value='"+e.getPassword()+"'/></td></tr>");  
        out.print("<tr><td>Gender:</td><td><input type='text' name='Gender' value='"+e.getGen()+"'/></td></tr>");  
        out.print("<tr><td>Expirence:</td><td><input type='text' name='Expirence' value='"+e.getExp()+"'/></td></tr>");  
        out.print("<tr><td>PreferedIndustry:</td><td><input type='text' name='PreferedIndustry' value='"+e.getPI()+"'/></td></tr>");
        out.print("<tr><td>KeySkills:</td><td><input type='text' name='KeySkills' value='"+e.getSkill()+"'/></td></tr>");
        
        out.print("</td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value='Update'/></td></tr>");  
        out.print("</table>");  
        out.print("</form>"); 
        out.print("</center>");
        out.println("</body>");
        out.close();  
    } 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {doGet(request, response);}
}

