<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="jobBean.Job"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Application Page</title>
<link rel = "stylesheet" type="text/css" href="header.css">	
</head>
<style>
    body{
        font-family: montserrat;
        background: #fffff0;
    }
    .container{
        font-size: 20px;
        color: #800000;
    }
    .container h1{
        text-align: center;
        color: #800000;

    }
    
    form{
    padding:25px;}

    hr.new, hr.new1 {
        color: #f08080;
    }
    .registerbtn{
        border: 0;
        background: none;
        display: block;
        margin: 20px auto;
        text-align: center;
        border: 2px solid #e9967a;
        padding: 10px 25px;
        outline: none;
        color: #800000;
        border-radius: 24px;
        transition: 0.25s ;
        cursor: pointer;
    }
    .registerbtn:hover{
        background: #fa8072;
    }
    /* Style inputs, select elements and textareas */
    input[type=text], select, textarea{
       width: 100%;
       padding: 12px;
       border: 1px solid #ccc;
       border-radius: 4px;
       box-sizing: border-box;
       resize: vertical;
   }

    /* Style the label to display next to the inputs */
    label {
       padding: 12px 12px 12px 0;
       display: inline-block;
   }

    /* Style the submit button */
    input[type=submit] {
       background-color: #4CAF50;
       color: white;
       padding: 12px 20px;
       border: none;
       border-radius: 4px;
       cursor: pointer;
       float: right;
   }

</style>

<body>
	<header>
	<h3>JobStudio</h3>
	<ul>
		<li><a href="ApplicantPage.jsp">Home</a></li>
		<li><a href="Logout">Logout</a></li>
	</ul>
</header>

<form action="SubmitJobApply" method="post">

  <div class="container">
    <h1>Register</h1>
    <hr class="new">
     <div class="container">
  <form action="action_page.php">
    <div class="row">
      <div class="col-25">
        <label><b>Company mail</b></label>
      </div>
      <div class="col-75">
        <input type="text"  name="Cname"  value="${ApplyJobList.company}" readonly><br>
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label><b>Job Post</b></label>
      </div>
      <div class="col-75">
        <input type="text"  name="Jpost" value="${ApplyJobList.jpost}" readonly><br>
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label><b>Email</b></label>
      </div>
      <div class="col-75">
        <input type="text" name="email" placeholder="Enter Email" name="email" required><br>
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label><b>Full Name</b></label>
      </div>
      <div class="col-75">
        <input type="text" name="Fname" placeholder="Enter Full Name" name="name" required><br>
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label><b>Mobile Number</b></label>
      </div>
      <div class="col-75">
        <input type="text" name="Mno" placeholder="Enter Mobile.No " name="number" pattern="\d{10}" title="Please enter a 10 digit number"required><br>
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label><b>Skills Matched</b></label>
      </div>
      <div class="col-75">
         <input type="text" name="skill" placeholder="Enter skills matched as per required " name="skill" required><br>
      </div>
    </div>
  </form>
</div> 

    
    <hr class="new1">
    <button type="submit" class="registerbtn">Submit</button>
  </div>
</form>

</body>
</html>