<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer List</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<table>
				<head>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				</head>
				<tbody>
					<c:forEach var="customer" items="${customers}">
						<tr>
							<td>${customer.getFirstName()}</td>
							<td>${customer.getLastName()}</td>
							<td>${customer.getEmail()}</td>
						<tr>
					</c:forEach>
				</tbody>


			</table>

		</div>
	</div>

</body>
</html>