<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<title>Only Foods Recipe Database</title>
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
				<h1>All Recipes in the OnlyFoods Database</h1>

				The time is now <b><%=new java.util.Date()%></b>.<br> <br>

				<a class="btn btn-primary" href="RecipeController?action=insert">Add
					A New Recipe</a>
				<br /> <br /> The following <B><c:out
						value="${recipes.size()}" /> recipes</B> are in your database: <br /> <br />

				<table border=1 class="sortable">
					<thead>
						<tr>
							<th>Post ID</th>
							<th>Recipe Title</th>
							<th>Image</th>
							<th>NumberOfLikes</th>
							<th>Username</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${recipes}" var="recipe">
							<tr>
								<td align="center"><c:out value="${recipe.getPostId()}" /></td>
								<td align="center"><c:out value="${recipe.getRecipeTitle()}" /></td>
								<td align="center"><c:out value="${recipe.getImageUrl()}" /></td>
								<td align="center"><c:out value="${recipe.getNumberOfLikes()}" /></td>
								<td align="center"><c:out value="${recipe.getUsername()}" /></td>
								<td align="center"><a class="btn btn-warning"
									href="RecipeController?action=edit&PostId"><c:out value="${recipe.getPostId()}"/>Edit</a></td>
								<td align="center"><a class="btn btn-danger"
									href="RecipeController?action=delete&PostId"><c:out value="${recipe.getPostid()}"/>Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<br /> <br />
			</div>
			<div class="col-sm-2 sidenav">
				<!-- You can put right sidebar links here if you want to. -->
			</div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>


</body>
</html>