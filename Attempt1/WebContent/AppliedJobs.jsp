<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="jobBean.TotalApplication"%>
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
    td = tr[i].getElementsByTagName("td")[5];
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

</script>
</HEAD>
<BODY>
<header>
	<h3>JobStudio</h3>
	<ul>
		<li><a href=<%if(session.getAttribute("username").equals("admin@jobportal.com")){out.println("Admin.jsp");}else{out.println("CompanyHome.jsp");}%>>Home</a></li>
		<li><a href="Logout">Logout</a></li>
	</ul>
</header>
<h2><strong><center>View Applicantions</center></strong></h2>

<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for Skills..">
	<table border="1" width="500" align="center" id="myTable">
		<tr class="header">
			<th style="width:60%;" ><b>Company</b></th>
			<th style="width:60%;"><b>JobPost</b></th>
			<th style="width:60%;"><b>Email</b></th>
			<th style="width:60%;"><b>Full Name</b></th>
			<th style="width:60%;"><b>Mobile No.</b></th>
			<th style="width:60%;"><b>Skills</b></th>
			<th style="width:60%;"><b>Applied</b></th>
			<th style="width:60%;"><b>Approved</b></th>
			<th style="width:60%;"><b>CV</b></th>
			<th <%if(session.getAttribute("username").equals("admin@jobportal.com")){out.println("style=display:none;");}%> style="width:60%;"><b>Approve Applicant</b></th>
		</tr>
		<%
			List<TotalApplication> J = (List<TotalApplication>)request.getAttribute("TotalJobs");
		if(J!=null){
			for (TotalApplication j : J) {
		%>
		<tr>
			<td><%=j.getCompanyName()%></td>
			<td><%=j.getJobPost()%></td>
			<td><%=j.getEmail()%></td>
			<td><%=j.getFullName()%></td>
			<td><%=j.getMobileNo()%></td>
			<td><%=j.getSkills()%></td>
			<td><%=j.getApplied()%></td>
			<td><%=j.getApproved()%></td>
			<td><form action="DownloadCV" method="post"><a style="color:#000000" href="DownloadCV?user=<%=j.getEmail()%>">Download</a></form></td>
			<td hidden ><input type="text" name="jobid" value=<%=j.getId()%> readonly></td>
			<td <%if(session.getAttribute("username").equals("admin@jobportal.com")){out.println("style=display:none;");}%>><form action="UpdateApplications" method="post"><a style="color:#000000" class="two" href="UpdateApplications?post=<%=j.getJobPost()%>&comp=<%=j.getCompanyName()%>&uemail=<%=j.getEmail()%>&uname=<%=j.getFullName()%>">YES</a></form></td>
		</tr>
		<%}}%>
	</table>
<!--  	<div style="text-align:center;"><input type="Submit" value="APPROVE"></div>-->	</form>

</body>
</html>