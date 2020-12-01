<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="jobBean.Job"%>
<!DOCTYPE>
<HTML>
<HEAD>
<TITLE>Job Apply</TITLE>
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
    }

th{
	background-color: #FFC21F;
}

th,td{
	padding: 5px;
}

#myInput{
	position:relative;
	top:40px;
	left:3%;
}
</style>
<script >
function myFunction() {
  // Declare variables 
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");

  // Loop through all table rows, and hide those who don't match the search query
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[8];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    } 
  }
}

function select(){
}
</script>
</HEAD>
<BODY>
<header>
	<h3>JobStudio</h3>
	<ul>
		<li><a href="ApplicantPage.jsp">Home</a></li>
		<li><a href="Logout">Logout</a></li>
	</ul>
</header>
<h2><strong><center>Available Jobs</center></strong></h2>
<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for Skills..">
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
			<th style="width:60%;"><b>Apply</b></th>
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
			<td><form action="AppliedJob" method="post"><a style="color:#000000" href="AppliedJob?id=<%=j.getJpost()%>&comp=<%=j.getCompany()%>">YES</a></form></td>
			
		</tr>
		<%}}%>
	</table>
</body>
</html>