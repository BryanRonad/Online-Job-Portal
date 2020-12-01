package credentials;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import credentials.dao.EmployeeDao;

import java.io.InputStream;
import java.io.PrintWriter;

@MultipartConfig(maxFileSize = 16177215)
public class UploadCV extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 PrintWriter out=response.getWriter();  
			 HttpSession session=request.getSession(); 
		     String email=(String)session.getAttribute("username");
			InputStream inputStream = null; // input stream of the upload file
	        // obtains the upload file part in this multipart request
	        Part filePart = request.getPart("filename");
	        if (filePart != null) {

	            System.out.println(filePart.getName());
	            System.out.println(filePart.getSize());
	            System.out.println(filePart.getContentType());
	             
	            // obtains input stream of the upload file
	            inputStream = filePart.getInputStream();
	            
	            EmployeeDao e=new EmployeeDao();
	            if(e.uploadCV(email, inputStream)==1)
	            {
	              	
	            	 out.println("<script>alert('CV Uploaded Successfully.')</script>");
	         		response.setHeader("Refresh", "1;ApplicantPage.jsp");
	            }else{
	              	
	            	 out.println("<script>alert('CV Upload Unsuccessful.')</script>");
	         		response.setHeader("Refresh", "1;UploadResume.jsp");
	            }
	            	
	            
	        }
	         
			
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}
}




