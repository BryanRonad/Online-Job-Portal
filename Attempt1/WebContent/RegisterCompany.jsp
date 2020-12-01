<!DOCTYPE html>

<!-- Daily UI day 1 -->
<!-- Would potentially make a good modal -->
<!-- TODO: style error message when required info is left off -->

<head>
<meta charset="utf-8">
<title>Recruiter Registration</title>
<link rel = "stylesheet" type="text/css" href="header.css">
<style>    
body {
	margin:0px;
	font-family: montserrat;
	background: #fffff0;
}
* {box-sizing: border-box}

	.container{
        font-size: 20px;
        color: #800000;
    }
    .container h1{
        text-align: center;
        color: #800000;

    }

/* Full-width input fields */
input[type=email], input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #fffafa;
}

input[type=email]:focus, input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

hr{
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}
p{
	text-align: center;
}
/* Set a style for all buttons */
button {
  background-color: #fa8072;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 50%;
  opacity: 0.9;
}

button:hover {
  opacity: 1;
}

/* Extra styles for the cancel button */
.cancelbtn {
  padding: 14px 20px;
  background-color: #4682b4;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
  float: left;
  width: 20%;
}

/* Add padding to container elements */
.container {
  padding: 16px;
}
form{
padding:30px;
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
   
    hr.new, hr.new1{
        color: #f08080;
    }
    
</style>
</head>
<body>
<header>
	<h3>JobStudio</h3>
	<ul>
		<li><a href="index.html">Home</a></li>
	</ul>
</header>
<div id="container">
	<div>
            <h2><strong><center>Register Job Provider</center></strong></h2>
            <hr/>
        </div>
	<form action="RegisterCompany" method="post">
		<div class="form-group">
			<input type="email" placeholder="E-mail Id" name="mail"  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required><br />
			<input type="text" placeholder="Company Name" name="username" required><br />
			<input type="text" placeholder="Web-Address" name="web" required><br />
			<input type="password" placeholder="Password" name=passwd pattern=".{6,}" title="Minimum 6 characters" required><br />
			</div>
			<div class="clearfix">
      <button onclick="location.href = 'index.html';" type="button" class="cancelbtn">Cancel</button>
      <button type="submit" class="signupbtn">Register</button>
    </div>
	</form>
</div>
</div>
</body>
</html>