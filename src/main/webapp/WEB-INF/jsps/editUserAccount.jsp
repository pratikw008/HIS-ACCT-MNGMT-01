<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Account</title>
</head>
<body>
	<div align="center">
		<h2><b>Update Account</b></h2>
		<form:form action="/update" method="post" modelAttribute="userDTO">
			<table>
				<tr>
					<td><form:label path="userId" /><b>First Name:</b>
					<td><form:input path="userId" readonly="true"/></td>
				</tr>
				<tr>
					<td><form:label path="firstName" /><b>First Name:</b>
					<td><form:input path="firstName" /></td>
				</tr>
				<tr>
					<td><form:label path="lastName" /><b>Last Name:</b>
					<td><form:input path="lastName" /></td>
				</tr>
				<tr>
					<td><form:label path="email" /><b>Email:</b>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td><form:label path="gender" /><b>Gender:</b>
					<td><form:radiobutton path="gender" value="MALE" />MALE <form:radiobutton
							path="gender" value="FEMALE" />FEMALE</td>
				</tr>
				<tr>
					<td><form:label path="role" /><b>Role:</b>
					<td><form:select path="role">
							<form:option value="">--Select--</form:option>
							<form:options items="${roles}" />
						</form:select></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Create" style="height:30px; width:100px; background-color:green; font-size:100%; color:white;"></td>					
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>