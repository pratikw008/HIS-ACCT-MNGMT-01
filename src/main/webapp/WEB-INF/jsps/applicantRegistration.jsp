<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Applicant Registration Page</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
  $( function() {
    $( "#datePicker" ).datepicker({ dateFormat: 'yy-mm-dd' }).val();
  });
  </script>
</head>
<body>
	<div align="center">
		<h1>Applicant Registration</h1>

		<form:form action="/regApplicant" method="post" modelAttribute="applicantDTO">
			<table>
				<tr>
					<td><b>First Name:</b></td>
					<td><form:input path="firstName" /></td>
				</tr>
				<tr>
					<td><b>Last Name:</b></td>
					<td><form:input path="lastName" /></td>
				</tr>
				<tr>
					<td><b>DOB:</b></td>
					<td><form:input path="dateOfBirth" id="datePicker" /></td>
				</tr>
				<tr>
					<td><b>Gender:</b></td>
					<td>
						<form:radiobutton path="gender" value="MALE"/>MALE
						<form:radiobutton path="gender" value="FEMALE"/>FEMALE
					</td>
				</tr>
				<tr>
					<td><b>SSN No:</b></td>
					<td><form:input path="ssnNo" /></td>
				</tr>
				<tr>
					<td><b>Phone No:</b></td>
					<td><form:input path="phoneNumber" /></td>
				</tr>
				<tr>
					<td><b>Email:</b></td>
					<td><form:input path="applicantEmail" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Register" style="height:30px; width:106px; background-color:green; font-size:100%; color:white; text-align:center;"></td>
				</tr>
				<c:if test="${!empty msg}">
					<tr>
					<td></td>
					<td><b><c:out value="${msg}" /></b></td>
				</tr>
				</c:if>
			</table>
		</form:form>


	</div>
</body>
</html>