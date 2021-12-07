<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<title>MIE350 Sample Web App - Contact</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- Date Picker Javascript -->
<!-- https://jqueryui.com/datepicker/ -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<link rel="stylesheet" type="text/css" href="css/mystyle.css">
</head>
<body>

	<%@ include file="navbar.jsp"%>


	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<!-- You can put left sidebar links here if you want to. -->
			</div>
			<div class="col-sm-8 text-left">
				<h1>Meet the Team</h1><br /> <br />
				<center>
						<div class="row">
						  <div class="column">
						    <div class="card">
						      <img src="img/Claire.jpg" alt="Claire" width="200" height="200">
						      <div class="container">
						        <h2>Claire Shaw</h2>
						        <p class="title">CEO &amp; Founder</p>
						        <p>That's hot</p>
						        <p>claire.shaw@mail.utoronto.ca</p>
						      </div>
						    </div>
						  </div>
						
						  <div class="column">
						    <div class="card">
						      <img src="img/Selena.jpg" alt="Selena" width="200" height="200">
						      <div class="container">
						        <h2>Selena Lombardi</h2>
						        <p class="title">Technical Program Manager</p>
						        <p>meep</p>
						        <p>selena.lombardi@mail.utoronto.ca</p>
						      </div>
						    </div>
						  </div>
						
						  <div class="column">
						    <div class="card">
						      <img src="img/Anita.jpg" alt="Anita" width="200" height="200">
						      <div class="container">
						        <h2>Anita Xu</h2>
						        <p class="title">Product Manager & Software Engineer</p>
						        <p>anita</p>
						        <p>anitaa.xu@mail.utoronto.ca</p>
						      </div>
						    </div>
						  </div>
						</div>
						
						<div class="row">
						  <div class="column">
						    <div class="card">
						      <img src="img/Nick.png" alt="Nick" width="200" height="200">
						      <div class="container">
						        <h2>Nick Diep</h2>
						        <p class="title">UX/UI Designer</p>
						        <p>XD</p>
						        <p>nick.diep@mail.utoronto.ca</p>
						      </div>
						    </div>
						  </div>
						
						  <div class="column">
						    <div class="card">
						      <img src="img/Vanessa.jpg" alt="Vanessa" width="200" height="200">
						      <div class="container">
						        <h2>Vanessa Elefteriadis</h2>
						        <p class="title">UX/UI Designer</p>
						        <p>paris hilton</p>
						        <p>vanessa.elefteriadis@mail.utoronto.ca</p>
						      </div>
						    </div>
						  </div>
						
						  <div class="column">
						    <div class="card">
						      <img src="img/Justin.png" alt="Justin" width="200" height="200">
						      <div class="container">
						        <h2>Justin Semelhago</h2>
						        <p class="title">Software Engineer</p>
						        <p>I am Justin</p>
						        <p>justin.semelhago@mail.utoronto.ca</p>
						      </div>
						    </div>
						  </div>
						</div>
						
						  <div class="column">
						    <div class="card">
						      <img src="img/Emily.jpg" alt="Emily" width="200" height="200">
						      <div class="container">
						        <h2>Emily Jiao</h2>
						        <p class="title">Software Engineer</p>
						        <p>:)</p>
						        <p>emily.jiao@mail.utoronto.ca</p>
						      </div>
						    </div>
						  </div>
				</center>
				<br />
				<br />
			</div>
			<div class="col-sm-2 sidenav">
				<!-- You can put right sidebar links here if you want to. -->
			</div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>


</body>
</html>