<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Accounts</title>
<link
	href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"
	type="text/javascript"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#role').on('change', function() {
			this.form.submit();
		});
	});
</script>
</head>
<body>
	<div align="center">
		<h1>View Accounts</h1>
		<form action="/viewAccounts">
			<table>
				<tr>
					<td><b>Select Role:</b></td>
					<td><select id="role" name="role">
							<option value="">--Select--</option>
							
							<c:forEach var="role" items="${roles}">
								<option value="${role.name}" label="${role.name}" />
							</c:forEach>
					</select></td>
				</tr>
			</table>
		</form>
		<table id="user_table" border="1">
			<thead>
				<tr>
					<th>S.No</th>
					<th>Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${listUsers}" varStatus="index">
					<tr>
						<td><c:out value="${index.count}"/></td>
						<td><c:out value="${user.firstName} ${user.lastName}"/></td>
						<td><c:out value="${user.email}"/></td>
						<td>
							<a href="edit?id=${user.userId}">Edit</a>
							<c:if test="${user.deleteState == 'ACTIVE'}">
								<a href="delete?id=${user.userId}">Delete</a>
							</c:if>
							<c:if test="${user.deleteState == 'INACTIVE'}">
								<a href="active?id=${user.userId}">Active</a>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>