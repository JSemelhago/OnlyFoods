<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	
<!DOCTYPE html>

<html>
  <head>
    <div class="topnav">
      <div style="background-image: url('food.jpg');">
      <h1>OnlyFoods</h1>
      <<style media="screen">
        h1 {text-align: center;}
      </style>
    </div>
  </head>
  <body>
      <body style="background-color:#D1FDD1;">
      <title>OnlyFoods - SignUp</title>
    <h2>Sign up!</h2>
  </body>
  <form action="/action_page.php">
  <label for="fname">Full Name:</label>
  <input type="text" id="fname" name="fname"><br><br>
  <label for="uname">Username:</label>
  <input type="text" id="uname" name="uname"><br><br>
  <label for="email">Email:</label>
  <input type="email" id="email" name="email"><br><br>
  <label for="pass">Password:</label>
  <input type="password" id="pass" name="pass"><br><br>
  <label for="bio">Bio:</label>
  <input type="text" id="bio" name="bio"><br><br>
</form>
<h3>Enter link of profile photo</h3>
<label for="dp">Profile Photo link:</label>
<input type="url" id="dp" name="dp"><br><br>
<input type="Submit">
</form>

</html>