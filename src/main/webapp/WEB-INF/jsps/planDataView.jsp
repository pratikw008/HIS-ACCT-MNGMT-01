<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Plan Data</title>
<script type="text/javascript">
function deleteConfirm() {
	return confirm("Are you sure, you want to delete?");
}
</script>
</head>
<body>
	<div align="center">
		<h1>View Plans</h1>
		<table border="1">
			<thead>
				<tr>
					<th>S.No</th>
					<th>Plan Name</th>
					<th>Plan Description</th>
					<th>Plan Start Date</th>
					<th>Plan End Date</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${!empty listPlans}">
						<c:forEach var="plan" items="${listPlans}" varStatus="index">
							<tr>
								<td><c:out value="${index.count}" /></td>
								<td><c:out value="${plan.planName}" /></td>
								<td><c:out value="${plan.planDescription}" /></td>
								<td><c:out value="${plan.planStartDate}" /></td>
								<td><c:out value="${plan.planEndDate}" /></td>
								<td>
									<a href="/editPlan?id=${plan.planId}">Edit</a>
									
									<c:if test="${plan.planAccountState == 'ACTIVE'}">									
										<a href="/deletePlan?id=${plan.planId}" onclick="return deleteConfirm()">Delete</a>
									</c:if>
									<c:if test="${plan.planAccountState == 'INACTIVE'}">									
										<a href="/activePlan?id=${plan.planId}">Active</a>
									</c:if>
									
								</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="6"><c:out value="${message}"></c:out></td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
</body>
</html>