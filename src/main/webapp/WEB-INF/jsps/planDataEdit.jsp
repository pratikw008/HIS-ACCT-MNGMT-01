<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Plan Data</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$(".datepicker").datepicker({
			dateFormat : 'yy-mm-dd'
		}).val();
	});
</script>

</head>
<body>
	<div align="center">
		<h2>Create Plan</h2>
		<form:form action="/updatePlan" method="post" modelAttribute="planDTO">
			<table>
				<tr>
					<td><form:label path="planId">
							<b>Plan ID:</b>
						</form:label></td>
					<td><form:input path="planId" readonly="true" /></td>
				</tr>
				<tr>
					<td><form:label path="planName">
							<b>Plan Name:</b>
						</form:label></td>
					<td><form:input path="planName" /></td>
				</tr>
				<tr>
					<td><form:label path="planDescription">
							<b>Plan Description:</b>
						</form:label></td>
					<td><form:input path="planDescription" /></td>
				</tr>
				<tr>
					<td><form:label path="planStartDate">
							<b>Plan Start Date:</b>
						</form:label></td>
					<td><form:input path="planStartDate" class="datepicker" /></td>
				</tr>
				<tr>
					<td><form:label path="planEndDate">
							<b>Plan End Date:</b>
						</form:label></td>
					<td><form:input path="planEndDate" class="datepicker" /></td>
				</tr>
				<tr>
					<td><form:label path="deleteState">
							<b>Plan State:</b>
						</form:label></td>
					<td><form:input path="deleteState" readonly="true"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Update Plan"
						style="height: 30px; width: 100px; background-color: green; font-size: 100%; color: white;"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>