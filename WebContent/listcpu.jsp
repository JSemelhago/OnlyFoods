<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<title>MIE350 Sample Web App - All CPUs in DB</title>
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
				<h1><font color="Black">CPU Directory</font></h1>

				The Centralised Processing Unit (CPU) is like the brain of the computer, it is responsible for doing a list of instructions that it is told to do. These lists are normally sent to it in the form of a program. 
				<br /><br />
				When you look at one of the processors below you will see a few numbers. 
				<ul>
					<li>When you see core i7 or core i5 for intel processors, the number following the ¡®i¡¯ is a rough indicator of it¡¯s speed. The higher the number, the faster the processor. A higher number also might indicate whether there are more cores in the processor, but we will get to that below. </li>
					<li>The number of cores in the processor is like the number of brains thinking. If the processor has two cores, then it has two brains each capable of doing its own list of instructions.</li>
					<li>The speed of the processor is measured in terms of GHz. The higher the number the faster the computer thinks, so it can do more in less time.</li>
				</ul>
				<br /> The following <B><font color="Black"><c:out
						value="${cpus.size()}" /> CPU options</font></B> are in our database: <br /> <br />
				<table border=1 class="sortable">
					<thead>
						<tr>
							<th><font color="DarkBlue">Name</font></th>
							<th><font color="DarkBlue">Manufacturer</font></th>
							<th><font color="DarkBlue">Speed in Ghz</font></th>
							<th><font color="DarkBlue">Cores</font></th>
							<th><font color="DarkBlue">Price</font></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${cpus}" var="cpu">
							<tr>
								<td align="center"><c:out value="${cpu.getCPUName()}" /></td>
								<td align="center"><c:out value="${cpu.getManufacturer()}" /></td>
								<td align="center"><c:out value="${cpu.getSpeed()}" /></td>
								<td align="center"><c:out value="${cpu.getCores()}" /></td>
								<td align="center"><c:out value="${cpu.getPrice()}" /></td>

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