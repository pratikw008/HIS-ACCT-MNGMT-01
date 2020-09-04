<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Plan Data</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$(document).ready(function() {
		$("#pageSize").change(function() {	
			$("#planForm").submit();
		});
	});
});
</script>
<script type="text/javascript">
function deleteConfirm() {
	return confirm("Are you sure, you want to delete?");
};
</script>
</head>
<body>
	<div align="center">
		<div align="center">
			<h1>View Plans</h1>
			<form action="viewPlansPaging" method="get" id="planForm">
				<label><b>Page Size::</b></label>
				<select id="pageSize" name="pageSize">
					<option value="">--Select--</option>
					<option value="3">3</option>
					<option value="5">5</option>
					<option value="10">10</option>
				</select>
			</form>
		</div>
		<div align="center">
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
									<td><a href="/editPlan?id=${plan.planId}">Edit</a> <c:if
											test="${plan.deleteState == 'ACTIVE'}">
											<a href="/deletePlan?id=${plan.planId}"
												onclick="return deleteConfirm()">Delete</a>
										</c:if> <c:if test="${plan.deleteState == 'INACTIVE'}">
											<a href="/activePlan?id=${plan.planId}">Active</a>
										</c:if></td>
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
		<div align="center">
			<c:if test="${totalPages > 1}">
				<b>Total Pages::</b>
				<c:out value="${totalPages}" />
					&nbsp;
					&nbsp;
					&nbsp;
					<c:if test="${hasPrevious}">
					<a href="viewPlansPaging?pageNo=${currentPage-1}&pageSize=${pageSize}">Previous</a>
				</c:if>
				<c:if test="${!hasPrevious}">
					<a>Previous</a>
				</c:if>
					&nbsp;
					&nbsp;
					<c:forEach begin="1" end="${totalPages}" var="i" varStatus="index">
					<c:if test="${currentPage == i}">
							${i}
						</c:if>
					<c:if test="${currentPage != i}">
						<a class="aClass" href="viewPlansPaging?pageNo=${i}&pageSize=${pageSize}">${i}</a>
					</c:if>

				</c:forEach>
			</c:if>
			&nbsp; &nbsp;
			<c:if test="${hasNext}">
				<a href="viewPlansPaging?pageNo=${currentPage+1}&pageSize=${pageSize}">Next</a>
			</c:if>
			<c:if test="${!hasNext}">
				<a>Next</a>
			</c:if>
		</div>
	</div>
</body>
</html>