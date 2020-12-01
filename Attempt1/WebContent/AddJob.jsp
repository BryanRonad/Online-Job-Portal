<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Jobs</title>
<link rel = "stylesheet" type="text/css" href="header.css">

<style>
body {
	font-family: montserrat;
	background: #fffff0;
	margin:0;
	padding:0;
}

* {box-sizing: border-box}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for all buttons */
button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 50%;
  opacity: 0.9;
}

button:hover {
  opacity:1;
}

/* Extra styles for the cancel button */
.cancelbtn {
  padding: 14px 20px;
  background-color: #f44336;
}

button+button{
margin-left:30px;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
  float: left;
  width: 20%;
}

/* Add padding to container elements */
.container {
  padding: 120px;
  position:relative;
  top:-100px;
}

/* Clear floats */
.clearfix::after {
  content: "";
  clear: both;
  display: table;
}

/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
  .cancelbtn, .signupbtn {
     width: 100%;
  }
}

</style>
</head>
 <body>
 		<header>
			<h3>JobStudio</h3>
			<ul>
			<li><a href="CompanyHome.jsp">Home</a></li>
			<li><a href="Logout">Logout</a></li>
			</ul>
		</header>
		 <div class="container">
        <div>
            <h2><strong><center>ADD JOB</center></strong></h2>
            <hr/>
        </div>
        
        <form action="AddJob"  method="post">
            <div class="form-group">
                <label for="name" class="control-label col-sm-2">Location</label>
                <div class="col-sm-4">
                    <input type="text" name="location" value="" placeholder=""> 
                </div>
               
             </div>    
           
            <div class="form-group">
                <label for="userName" class="control-label col-sm-2">Functional Area</label>
                <div class="col-sm-4">
                   <input type="text" name="area" value="" placeholder="">
                </div>
                 
            </div>
            
            <div class="form-group">
                <label for="email" class="control-label col-sm-2">Job Post</label>
                <div class="col-sm-4">
            	<input type="text" name="post" value="" placeholder="">
                </div>
             
            </div>
           
            <div class="form-group">
                <label for="pwd" class="control-label col-sm-2">Vacancy</label>
                <div class="col-sm-4">
                    <input type="text" name="vacancy" value="" placeholder="Integer Value">
                </div>
              
            </div>
            
            <div class="form-group">
                <label for="cnfrmPwd" class="control-label col-sm-2">Skills Required</label>
                <div class="col-sm-4">
                    <input type="text" name="skill" value="">
                </div>
                
            </div>
            <div class="form-group">
                <label for="cnfrmPwd" class="control-label col-sm-2">Salary</label>
                <div class="col-sm-4">
                <input type="text" name="salary" value="" placeholder="Integer Value">
                </div>
                
            </div>
            <div class="form-group">
                <label for="cnfrmPwd" class="control-label col-sm-2">Interview Date</label>
                <div class="col-sm-4">
                    <input type="text" name="ivdate" value="" placeholder="dd/mm/yyy">
                </div>
               
            </div>
            <div class="form-group">
                <label for="cnfrmPwd" class="control-label col-sm-2">Interview Time</label>
                <div class="col-sm-4">
                <input type="text" name="ivtime" value="" placeholder="hh:mm"> 
                </div>
                
            </div>
             <div class="form-group">
                <label for="cnfrmPwd" class="control-label col-sm-2">Interview Place</label>
                <div class="col-sm-4">
                <input type="text" name="ivplace" value="">
                </div>
                
            </div>
            
           
            
    <div class="clearfix">
      <button type="button" class="cancelbtn">Cancel</button>
      <button type="submit" class="signupbtn">Submit</button>
    </div>
        </form>
      
    </body>
</body>
</html>