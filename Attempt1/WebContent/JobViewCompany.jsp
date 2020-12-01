<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="jobBean.Job"%>
<!DOCTYPE>
<HTML>
<HEAD>
<TITLE>Job View</TITLE>
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
		position:relative;
		top:20px;
        border-collapse: collapse;
        text-align: center;
    }

th{
	background-color: #FFC21F;
}

th,td{
	padding: 5px;
}

.tabledel a:hover{
	color:#df2359;
}
</style>
</HEAD>
<BODY>
	<header>
	<h3>JobStudio</h3>
	<ul>
		<li><a href="CompanyHome.jsp">Home</a></li>
		<li><a href="Logout">Logout</a></li>
	</ul>
</header>
<h2><strong><center>View Jobs</center></strong></h2>
<div class="tabledel">
	<table border="1" width="500" align="center" id="myTable">
		<tr class="header">
			<th style="width:60%;" ><b>Location</b></th>
			<th style="width:60%;"><b>Functional Area</b></th>
			<th style="width:60%;"><b>JobPost</b></th>
			<th style="width:60%;"><b>Vacancy</b></th>
			<th style="width:60%;"><b>Salary</b></th>
			<th style="width:60%;"><b>Interview data</b></th>
			<th style="width:60%;"><b>Interview time</b></th>
			<th style="width:60%;"><b>Interview place</b></th>
			<th style="width:60%;"><b>Skills</b></th>
			<th style="width:60%;"><b>Company-Mail</b></th>
			<th style="width:60%;"><b>Delete Job</b></th>
		</tr>
		<%
			List<Job> J = (List<Job>) request.getAttribute("JobList");
		if(J!=null){
			for (Job j : J) {
		%>
		
		<tr>
			<td><%=j.getLocation()%></td>
			<td><%=j.getFarea()%></td>
			<td><%=j.getJpost()%></td>
			<td><%=j.getVacancy()%></td>
			<td><%=j.getSalary()%></td>
			<td><%=j.getIdate()%></td>
			<td><%=j.getItime()%></td>
			<td><%=j.getIplace()%></td>
			<td><%=j.getSkills()%></td>
			<td><%=j.getCompany()%></td>
			<td><form action="DeleteJob" method="post"><a class="two" style="color:#000000" href="DeleteJob?post=<%=j.getJpost()%>&comp=<%=j.getCompany()%>">YES</a></form></td>
			
		</tr>
		<%}}%>
		
	</table>
	</div>
</body>
</html>