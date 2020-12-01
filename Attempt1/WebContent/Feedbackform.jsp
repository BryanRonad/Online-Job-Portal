<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>FEEDBACK FORM</title>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel ="stylesheet" type="text/css" href="header.css">

    

    <style>
    @import
	url("https://fonts.googleapis.com/css?family=Montserrat:100,200,300,400,500,600,700,800,900");
    	
    body {
    		font-family: montserrat;
    		background-color:#120307;
    		background-image:linear-gradient(0deg, rgba(29, 30, 34, 0.1), #1d1e22), url("office1.jpg");
    		height: 100vh;
    		background-position: center;
    		background-repeat: no-repeat;
    		background-size: cover; 

    	}

         /* Style inputs with type="text", select elements and textareas */
input[type=email], select, textarea {
  width: 100%; /* Full width */
  padding: 12px; /* Some padding */ 
  border: 1px solid #ccc; /* Gray border */
  border-radius: 4px; /* Rounded borders */
  box-sizing: border-box; /* Make sure that padding and width stays in place */
  margin-top: 6px; /* Add a top margin */
  margin-bottom: 16px; /* Bottom margin */
  resize: vertical /* Allow the user to vertically resize the textarea (not horizontally) */
}
input[type=text], select, textarea{
  width: 100%; /* Full width */
  padding: 12px; /* Some padding */ 
  border: 1px solid #ccc; /* Gray border */
  border-radius: 4px; /* Rounded borders */
  box-sizing: border-box; /* Make sure that padding and width stays in place */
  margin-top: 6px; /* Add a top margin */
  margin-bottom: 16px; /* Bottom margin */
  resize: vertical /* Allow the user to vertically resize the textarea (not horizontally) */
}

/* Style the submit button with a specific background color etc */
input[type=submit] {
  background-color: #e9967a;
  color: white;
  padding: 12px 20px;
  border: none;
  cursor: pointer;
}

/* When moving the mouse over the submit button, add a darker green color */
input[type=submit]:hover {
  background-color: #ffa07a;
}

/* Add a background color and some padding around the form */
.container {
  padding-top:40px;
  border-radius: 5px;
  color:#fff;
} 

header{
font-size:2rem;
}

header h3{
font-size:3rem;
}

h2{
	position:relative;
	text-align:center;
	color:#fff;
}

    </style>
</head>
<body>

<header>
	<h3>JobStudio</h3>
	<ul>
		<li><a href="ApplicantPage.jsp">Home</a></li>
		<li><a href="Logout">Logout</a></li>
	</ul>
</header>




<div class="box">
  <div class="container">
  	<h2>FEEDBACK</h2>
  <form action="Feedback">
  	
    <label for="email">E-mail Id</label>
    <input type="email" id="email" name="email" placeholder="Enter your registered e-mail id">
    

    <!--  <label for="cname">Company Name</label>
    <input type="text" id="cname" name="companyname" placeholder="Enter name of the company">-->

    

    <label for="subject">Feedback</label>
    <textarea id="subject" name="subject" placeholder="" style="height:200px"></textarea>

    <input type="submit" value="Submit">

  </form>
</div> 
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
</html>