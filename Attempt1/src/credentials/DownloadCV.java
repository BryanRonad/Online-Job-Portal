package credentials;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Blob;
import java.sql.SQLException;

import credentials.dao.EmployeeDao;

public class DownloadCV extends HttpServlet {
		private static final long serialVersionUID = 1L;
	 
	   
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String email=request.getParameter("user");
			System.out.println(email);
			EmployeeDao e = new EmployeeDao();
			try {
	        Blob fileData = e.downloadCV(email);
	        String contentType = getServletContext().getMimeType("filename");
	        if (contentType == null) {        
	            contentType = "application/octet-stream";
	        }
	        System.out.println("Content Type: " + contentType);
	        response.setContentType("APPLICATION/OCTET-STREAM");   
	        response.setHeader("Content-Type", contentType);
	        response.setHeader("Content-Length", String.valueOf(fileData.length()));
	        response.setHeader("Content-Disposition", "inline; filename=\"" +" cv.pdf"+ "\"");
	        System.out.println(fileData);
	        if(fileData!=null) {
	        InputStream is = fileData.getBinaryStream();
	        byte[] bytes = new byte[1024];
	        int bytesRead;

	        while ((bytesRead = is.read(bytes)) != -1) {
	            // Write image data to Response.
	            response.getOutputStream().write(bytes, 0, bytesRead);
	        }
	        is.close();
	        }
			}
			catch(SQLException ex) { System.out.println(ex);}
		}

		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}
}
