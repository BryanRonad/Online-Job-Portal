<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="employeeBean.Employee"%>
<!DOCTYPE>
<HTML>
<HEAD>
<TITLE>Employee View</TITLE>
<link rel="shortcut icon"
	href="http://www.iconarchive.com/download/i47277/avosoft/warm-toolbar/user.ico">
<link rel = "stylesheet" type="text/css" href="header.css">	
<style >
body {
margin:0px;
	font-family: montserrat;
	background: #fffff0;
}

table{
        border-collapse: collapse;
        text-align: center;
        padding
    }

th{
	background-color: #FFC21F;
}

th,td{
	padding: 5px;
}

</style>
</HEAD>
<BODY>
<header>
	<h3>JobStudio</h3>
	<ul>
		<li><a href="Admin.jsp">Home</a></li>
		<li><a href="Logout">Logout</a></li>
	</ul>
</header>
<h2><strong><center>View Applicants</center></strong></h2>
	<table border="1" width="500" align="center" id="myTable">
		<tr class="header">
			<th style="width:60%;" ><b>Email</b></th>
			<th style="width:60%;"><b>FirstName</b></th>
			<th style="width:60%;"><b>LastName</b></th>
			<th style="width:60%;"><b>Password</b></th>
			<th style="width:60%;"><b>Gender</b></th>
			<th style="width:60%;"><b>Experience</b></th>
			<th style="width:60%;"><b>Industry</b></th>
			<th style="width:60%;"><b>keySkills</b></th>
			<th style="width:60%;"><b>Delete User</b></th>
		</tr>
		<%
			List<Employee> J = (List<Employee>) request.getAttribute("EmployeeViewList");
		if(J!=null){
			for (Employee j : J) {
		%>
		<tr>
			<td><%=j.getUemail()%></td>
			<td><%=j.getUfname()%></td>
			<td><%=j.getUlname()%></td>
			<td><%=j.getPassword()%></td>
			<td><%=j.getGen()%></td>
			<td><%=j.getExp()%></td>
			<td><%=j.getPI()%></td>
			<td><%=j.getSkill()%></td>
			<td><form action="DeleteUser" method="post"><a style="color:#000000" href="DeleteUser?email=<%=j.getUemail()%>">DELETE</a></form>
		</tr>
		<%}}%>
	</table>
</body>
</html>