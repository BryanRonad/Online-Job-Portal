<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Online Job Portal</title>
<link rel="shortcut icon" href="http://www.iconarchive.com/download/i47277/avosoft/warm-toolbar/user.ico">
<link rel = "stylesheet" type="text/css" href="header.css">

<style>
@import
	url("https://fonts.googleapis.com/css?family=Montserrat:100,200,300,400,500,600,700,800,900")
	;

*, ::before, ::after {
	box-sizing: border-box;
}

body {
	margin: 0;
	padding: 0.5em 0.5em 0.5em 0;
	height: 100vh;
	overflow: hidden;
	font-family: 'Montserrat', sans-serif;
	font-size: 62.5%;
	background-image:linear-gradient(0deg, rgba(29, 30, 34, 0.05), #1d1e22), url("https://visme.co/blog/wp-content/uploads/2017/07/50-Beautiful-and-Minimalist-Presentation-Backgrounds-01.jpg");
	background-position: center;
	background-size: cover;
	color: #fff;
	
}

::-webkit-scrollbar {
	width: 8px;
	height: 6px;
}

::-webkit-scrollbar-track {
	background-color: #1d1e22;
}

::-webkit-scrollbar-thumb {
	border-radius: 1em;
	background-color: #b3b3b3;
}

::-webkit-scrollbar-thumb:hover {
	background-color: #df2359;
}

a {
	text-decoration: none;
	color: #fff;
}

a+a{
	margin-left:20px;
}

a:hover, .content a:hover {
	color: #df2359;
}

h1, h2, header a {
	text-transform: uppercase;
}

.title{
	position:absolute;
	top: 40%;
	left: 50%;
	transform: translate(-50%,-50%);
	font-size:30px;
}

.content{
	position:absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%,-50%);
}

.content a{
	font-size:20px;
	border:1px solid #fff;
	padding: 10px 30px;
}

.smooth {
	margin: 0 auto;
	height: 100%;
	overflow-x: hidden;
	overflow-y: scroll;
	scroll-behavior: smooth;
}
</style>
</head>
<body>
	<div class="smooth">
		<header>
			<h3>JobStudio</h3>
			<ul>
				<li><a href="ApplicantPage.jsp">Home</a></li>
				<li><a href="Feedbackform.jsp">Feedback</a></li>
				<li><a href="Logout">Logout</a></li>
			</ul>
		</header>
		<section id="one">
			<div class="title">
				<h1> Welcome, ${username} </h1>
			</div>
			<div class="content">
				<a href="UpdateUser">Update Profile</a>
				<a href="Jobs">Job Search</a>
				<a href="UploadResume.jsp">Upload CV</a>
			</div>
		</section>
	</div>
				<%
					
					if(session.getAttribute("username")==null)
			    	{
			    	response.sendRedirect("index.html");
			    	}
                    System.out.println("session "+session.getAttribute("username"));

				%>

</body>
</html>
