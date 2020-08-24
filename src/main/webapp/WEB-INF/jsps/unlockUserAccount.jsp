<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Unlock User Account</title>
</head>
<body>
	<div align="center">
	<h2><b>Unlock Account</b></h2>
		<form:form action="/unlockAcc" method="post" modelAttribute="unlockAccount">
			<table>
				<tr>
					<td><b>Email:</b></td>
					<td><form:input path="email"/></td>
				</tr>
				<tr>
					<td><b>Temp Pwd:</b></td>
					<td><form:input path="tempPwd"/></td>
				</tr>
				<tr>
					<td><b>New Pwd:</b></td>
					<td><form:input path="newPwd"/></td>
				</tr>
				<tr>
					<td><b>Confirm Pwd:</b></td>
					<td><form:input path="confirmPwd"/></td>
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