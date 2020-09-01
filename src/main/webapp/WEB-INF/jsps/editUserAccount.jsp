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
					<td><form:label path="pazzword" /><b>Password:</b>
					<td><form:input path="pazzword" /></td>
				</tr>
				<tr>
					<td><form:label path="gender" /><b>Gender:</b>
					<td><form:radiobutton path="gender" value="MALE" />MALE <form:radiobutton
							path="gender" value="FEMALE" />FEMALE</td>
				</tr>
				<tr>
					<td><form:label path="role" /><b>Role:</b>
					<td><form:select path="role">
							<form:options items="${roles}" itemLabel="name" itemValue="roleId"/>
						</form:select></td>
				</tr>
				<tr>
					<td><form:label path="accountStatus" /><b>Account Status:</b>
					<td><form:input path="accountStatus" readonly="true"/></td>
				</tr>
				<tr>
					<td><form:label path="accountState" /><b>Account State:</b>
					<td><form:input path="accountState" readonly="true"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Update User" style="height:30px; width:106px; background-color:green; font-size:100%; color:white; text-align:center;"></td>					
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>