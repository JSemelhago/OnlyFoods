<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	
<!DOCTYPE html>

<html>
  <head>
    <div class="topnav">
      <div style="background-image: url('food.jpg');">
  <body style="background-color:#D1FDD1;">
      <h1>OnlyFoods</h1>
    </div>
  </head>
  <body>
  <body style="background-color:#D1FDD1;">
      <title>OnlyFoods - Log In</title>
    <h2>Log In and Start Sharing!</h2>
  </body>
  <form action="UserLoginController">
  <label for="uname">Username:</label>
  <input type="text" id="uname" name="uname"><br><br>
  <label for="pass">Password:</label>
  <input type="password" id="pass" name="pass"><br><br>
  <input type="submit" value="Next">
  <p> Sample credentials for testing purposes: </p>
  <p> Username: michael </p>
  <p> Password: gruninger  </p>

</html>