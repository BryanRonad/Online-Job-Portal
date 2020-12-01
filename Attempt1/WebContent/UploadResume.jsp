<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html lang="en">
<head>
  <title>Resume</title>
  <link rel="shortcut icon"
	href="http://www.iconarchive.com/download/i47277/avosoft/warm-toolbar/user.ico">
	<link rel = "stylesheet" type="text/css" href="header.css">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <style>
  body {
	margin:0px;
	font-family: montserrat;
	background: #fffff0;
}

header .dhakka{
position:relative;
top:-50px;}

.container{
		padding-top:50px;
}

input{
	padding-top:20px;
}

a:hover {
	color: #df2359;
}

header ul li a{
	text-decoration:none !important;
}
 </style>
</head>
<body>

<header>
	<h3>JobStudio</h3>
	<div class="dhakka">
	<ul>
		<li><a href="ApplicantPage.jsp">Home</a></li>
		<li><a href="Logout">Logout</a></li>
	</ul>
	</div>
</header>

<div class="container">
  <h2>Custom File</h2>
  <form action="UploadCV" method="post" enctype="multipart/form-data" >
    <div class="custom-file mb-3">
      <input type="file" class="custom-file-input" id="customFile" name="filename">
      <label class="custom-file-label" for="customFile">Choose file</label>
    </div>
    <div class="mt-3">
      <button type="submit" class="btn btn-primary">Submit</button>
    </div>
  </form>
</div>

<script>
// Add the following code if you want the name of the file appear on select
$(".custom-file-input").on("change", function() {
  var fileName = $(this).val().split("\\").pop();
  $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
});
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
