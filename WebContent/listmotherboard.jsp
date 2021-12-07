<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<title>MIE350 Sample Web App - All Motherboards in DB</title>
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
				<h1><font color="Black">Motherboard Directory</font></h1>

				The Motherboard is a printed board of circuits which allows the other hardware components of a computer to talk with each other. On them have plugs so you can plug in the components such as the CPU. There is a lot of variation in the design of each Motherboard, and the design will dictate the types of parts you can use to build your computer. This includes something like the amount of RAM memory it can have or the type of power supply. 
				<br /><br />
				<br /> The following <B><font color="Black"><c:out
						value="${motherboards.size()}" /> motherboard options</font></B> are in our database: <br /> <br />
				<table border=1 class="sortable">
					<thead>
						<tr> 
							<th><font color="DarkBlue">Name</font></th>
							<th><font color="DarkBlue">Manufacturer</font></th>
							<th><font color="DarkBlue">Form</font></th>
							<th><font color="DarkBlue">Ram Slots</font></th>
							<th><font color="DarkBlue">CPU Socket Type</font></th>
							<th><font color="DarkBlue">Price</font></th>
							
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${motherboards}" var="motherboard">
							<tr>
								<td align="center"><c:out value="${motherboard.getName()}" /></td>
								<td align="center"><c:out value="${motherboard.getManufacturer()}" /></td>
								<td align="center"><c:out value="${motherboard.getForm()}" /></td>
								<td align="center"><c:out value="${motherboard.getRamSlots()}" /></td>
								<td align="center"><c:out value="${motherboard.getCpuSocketType()}" /></td>
								<td align="center"><c:out value="${motherboard.getPrice()}" /></td>

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