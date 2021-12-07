<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<title>MIE350 Sample Web App - All Memory in DB</title>
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
<body style="background-color:WhiteSmoke;">
<font color="Gray">

	<%@ include file="navbar.jsp"%>

	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav" style="background-color:Gainsboro;">
				<!-- You can put left sidebar links here if you want to. -->
			</div>
			<div class="col-sm-8 text-left">
				<h1><font color="Black">Memory Directory</font></h1>

				The Random Access Memory or RAM is the temporary storage space of your computer. RAM hold the user data and software applications the computer gathers while it is running. Everything stored here gets lost once the computer is turned off. Any data in RAM can be directly accessed by the computer, which makes it faster because going to the storage and look for data takes time.
				<br /> <br >
				The speed of a RAM is measured in MHz (megahertz), and the memory space of a RAM is measured in GB (gigabytes). The larger the storage space, the more data that can be stored in the RAM, the faster the computer becomes.
				<br /><br />
				<br /> The following <B><font color="Black"><c:out
						value="${memorys.size()}" /> memory options</font></B> are in our database: <br /> <br />
				<table border=1 class="sortable">
					<thead>
						<tr>
							<th><font color="DarkBlue">Name</font></th>
							<th><font color="DarkBlue">Manufacturer</font></th>
							<th><font color="DarkBlue">Speed</font></th>
							<th><font color="DarkBlue">Modules</font></th>
							<th><font color="DarkBlue">Size in GB</font></th>
							<th><font color="DarkBlue">Price</font></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${memorys}" var="memory">
							<tr>
								<td align="center"><c:out value="${memory.getName()}" /></td>
								<td align="center"><c:out value="${memory.getManufacturer()}" /></td>
								<td align="center"><c:out value="${memory.getSpeed()}" /></td>
								<td align="center"><c:out value="${memory.getModules()}" /></td>
								<td align="center"><c:out value="${memory.getSizeGB()}" /></td>
								<td align="center"><c:out value="${memory.getPrice()}" /></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>

				<br /> <br />
			</div>
			<div class="col-sm-2 sidenav" style="background-color:Gainsboro;">
				<!-- You can put right sidebar links here if you want to. -->
			</div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>

</font>
</body>
</html>