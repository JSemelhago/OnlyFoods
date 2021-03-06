<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="com.mie.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<!-- Check to see if the user is logged in. Otherwise, redirect back to the login page.-->
<%
	session = request.getSession();
	System.out.println(session);
	if (session.getAttribute("username") == null) {
		response.sendRedirect("login.jsp");
	}
%>

<head>
<title>MIE350 Sample Web App - All Students in DB</title>
 <!-- Load icon library -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="styles.css"/>
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

</head>
<body>

	<%@ include file="navbar_loggedin.jsp"%>
	<%
		Student student = (Student) session.getAttribute("currentSessionUser");
		String username = (String) session.getAttribute("username");
		String firstname = (String) session.getAttribute("firstname");
		String lastname = (String) session.getAttribute("lastname");
	%>
	
  <table>

	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-8 text-left">
				<h1>All Recipes In Website</h1>

				<a class="btn btn-primary" href="RecipeController?action=insert">Add
					A New Recipe</a> <br /> <br /> The following <B><c:out
						value="${recipes.size()}" /> recipes</B> are in your database (you can click on the table headings to sort the recipes): <br>
				<br>
				<table border=1 class="sortable">
					<thead>
						<tr>
							<th>Recipe Name</th>
							<th>Author</th>
							<th colspan=2>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${recipes}" var="recipe">
							<tr>
								<td align="center"><c:out value="${recipe.getRecipeTitle()}" /></td>
								<td align="center"><c:out value="${recipe.getUsername()}" /></td>
								<td align="center"><c:out value="${student.getLastName()}" /></td>
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