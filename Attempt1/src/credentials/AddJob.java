package credentials;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import credentials.dao.AddJobDao;

public class AddJob extends HttpServlet {

	public AddJob() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AddJobDao dao = new AddJobDao();
		PrintWriter p = response.getWriter();
		String s1 = request.getParameter("location");
		String s2 = request.getParameter("area");
		String s3 = request.getParameter("post");
		String s4 = request.getParameter("vacancy");
		String s5 = request.getParameter("salary");
		String s6 = request.getParameter("ivdate");
		String s7 = request.getParameter("ivtime");
		String s8 = request.getParameter("ivplace");
		String s9 = request.getParameter("skill");
		HttpSession session = request.getSession(false);
		String s10 = (String) session.getAttribute("username");
		System.out.println(s10);
		System.out.println(s1 + "" + s2 + "" + s3 + "" + s4 + "" + s5 + "" + s6 + "" + s7 + "" + s8 + "" + s9);
		if (s1 != null && s2 != null && s3 != null && s4 != null && s5 != null && s6 != null && s7 != null && s8 != null
				&& s9 != null && s10 != null) {
			System.out.println("Dao.update called");
			if (dao.update(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10) == 1) {

				p.println("<script>alert('Job Added Successfully')</script>");
				response.setHeader("Refresh", "1;CompanyHome.jsp");
			} else {
				p.println("<script>alert('Job Adding Failed')</script>");
				response.setHeader("Refresh", "1;CompanyHome.jsp");
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

