<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="com.mie.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<title>Add Recipe</title>
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

	<%@ include file="navbar_loggedin.jsp"%>

	<%
		Student member = (Student) session.getAttribute("currentSessionUser");
		String username = (String) session.getAttribute("username");
		String name = (String) session.getAttribute("name");
	%>

	<div class="container-fluid text-center">
		<div class="row content">
			<%@ include file="sidebar_loggedin.jsp"%>
			<div class="col-sm-8 text-left">
				<h1>Add A Recipe</h1>

				
				<br>
				<br>

				

				<form method="POST" action="RecipeController" name="formAddUser">
					Post ID*: <input type ="text" readonly="readonly" name = "postid" 
					value= "<c:out value = "${recipe.postid}" />"><br>
					Recipe Title*: <input type="text"
						name="recipetitle" value="<c:out value="${recipe.recipeTitle}" />"><br>
					Image URL*: <input type="text" 
						name="imageurl" value="<c:out value="${recipe.imageUrl}" />"><br>
					Serving*: <input type="number" min = "0"
						name="serving" value="<c:out value="${recipe.serving}" />"><br>
					Difficulty*: <input type="text" 
						name="difficulty" value="<c:out value="${recipe.difficulty}" />"><br>	
					Prep Time*: <input type="number" min = "0" 
						name="preptime" value="<c:out value="${recipe.prepTime}" />"><br>
					Ingredients*: <input type="text"
						name="ingredients" value="<c:out value="${recipe.ingredients}" />"><br>
					Instructions*: <input type="text"
						name="instructions" value="<c:out value="${recipe.instructions}" />"><br>
					Dish Type*: <input type="text" 
						name="dishtype" value="<c:out value="${recipe.dishType}" />"><br>
					Cuisine Type*: <input type="text" 
						name="cuisinetype" value="<c:out value="${recipe.cuisineType}" />"><br>
					<input type="submit" class="btn btn-info" value="Submit" />
				 </form>
			</div>
			<div class="col-sm-2 sidenav">
				<!-- You can put right sidebar links here if you want to. -->
			</div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>


</body>
</html>

