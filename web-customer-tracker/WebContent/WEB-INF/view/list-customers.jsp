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
<div class="outerdiv">
	<div id="wrapper">
		<div id="header">
			<h2>CRM</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<input type="button" value="Add Customer"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button" />
			<table>
				<head>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Action</th>
				</head>
				<tbody>
					<c:forEach var="customer" items="${customers}">
						<c:url var="updateLink" value="/customer/showFormForUpdate">
							<c:param name="customerId" value="${customer.id}" />
						</c:url>
						<c:url var="deleteLink" value="/customer/deleteCustomer">
							<c:param name="customerId" value="${customer.id}" />
						</c:url>
						<tr>
							<td>${customer.getFirstName()}</td>
							<td>${customer.getLastName()}</td>
							<td>${customer.getEmail()}</td>
							<td>
								<a href="${updateLink}">Update</a> | <a href="${deleteLink}" onclick="if(!(confirm('Are you sure?'))) return false;">Delete</a> 
							</td>
						<tr>
					</c:forEach>
				</tbody>


			</table>

		</div>
	</div>
</div>
</body>
</html>