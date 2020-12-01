<!DOCTYPE html>
<html>
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
	color: #fff;
	background-color: #1d1e22;
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

a:hover {
	color: #df2359;
}

h1, h2, header a {
	text-transform: uppercase;
}

.smooth {
	margin: 0 auto;
	height: 100%;
	overflow-x: hidden;
	overflow-y: scroll;
	scroll-behavior: smooth;
}

section {
	position: relative;
	display: flex;
	min-height: 100vh;
	padding: 2em 3em;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	font-size: 1rem;
	background-color: #191a1d;
}

section#one {
	background-image:linear-gradient(0deg, rgba(29, 30, 34, 0.05), #1d1e22), url("https://visme.co/blog/wp-content/uploads/2017/07/50-Beautiful-and-Minimalist-Presentation-Backgrounds-01.jpg");
	background-position: center;
	background-size: cover;
	color: #fff;
}

section h2 span {
	color: #df2359;
}

.content {
	position: relative;
	top: -35px;
	z-index: 1;
	display: flex;
	align-items: center;
}

.content h1 {
	position: relative;
	top:-10px;
	font-size: 3rem;
}

.content .blur {
	position: relative;
	overflow: hidden;
	margin: auto;
	margin-left: 2em;
	padding: 0.5em;
	width: 350px;
	height: 400px;
	border-radius: 0.35em;
}

.content .blur::before {
	position: absolute;
	content: '';
	top: -25%;
	left: -25%;
	width: 150%;
	height: 150%;
	box-shadow: inset 0 0 0 600px rgba(255, 255, 255, 0.3);
	filter: blur(10px);
}

form {
	position: relative;
	z-index: 3;
	padding: 1em;
	display: flex;
	width: 100%;
	height: 100%;
	flex-direction: column;
	align-items: center;
	justify-content: space-around;
	border: 2px solid #fff;
	border-radius: 0.35em;
}

form input {
	position: relative;
	top:-25px;
	margin-bottom: 1em;
	min-height: 3em;
	font-size: 1em;
	color: #fff;
	border: 0;
	border-bottom: 2px solid #fff;
	background: none;
}

form a{
	position:relative;
	top:-15px;
}

form input::placeholder {
	position: relative;
	top: 0;
	color: inherit;
	transition: all 0.2s linear ease-in;
}

form input:focus {
	outline: none;
}

form input:focus::placeholder {
	top: -1.25em;
	font-size: 0.825rem;
}


}
</style> 
 </head>
<body>
    <div class="smooth">
		<header>
			<h3>JobStudio</h3>
			<ul>
				<li><a href="index.html">Back</a></li>
			</ul>
		</header>
		<section id="one">
			<div class="content">
				<div class="blur">
					    <form class="box" action="CompanyLogin" method="post">
						<h1>Login</h1>
						<input type="email" name="mail" placeholder="E-mail">
						<input type="password" name="pwd" placeholder="Password">
						<input type="submit" name="" value="Submit">
						<a href="RegisterCompany.jsp" text-align: center>Not a user?<strong>  Register</strong></a>
						</form>
				</div>
			</div>
		</section>
</body>
</html>