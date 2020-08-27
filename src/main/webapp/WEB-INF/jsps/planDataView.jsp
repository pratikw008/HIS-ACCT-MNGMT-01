<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Plan Data</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
/* $(document).ready(function() {
	
	$("#pageSize").change(function(){
			
		var pageSize = $('#pageSize').val();
		console.log(pageSize);
		var old = '&pageSize=3'+pageSize;
		 $('a').click(function () {
		        $(this).attr('href',$(this).attr('href').replace(old, newValue));
		    });
		$('a#pageSize').attr('href', function(index, attr) {
		    return attr + '&' + pageSize;
		});
		console.log(pageSize)
		alert(pageSize);
	});
}); */
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
			<table>
				<tr>
					<td><h3>Page Size::</h3></td>
					<td><select id="pageSize" name="pageSize">
							<option value="3" selected="selected">3</option>
							<option value="5">5</option>
							<option value="10">10</option>
					</select></td>
				</tr>
			</table>
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
											test="${plan.planAccountState == 'ACTIVE'}">
											<a href="/deletePlan?id=${plan.planId}"
												onclick="return deleteConfirm()">Delete</a>
										</c:if> <c:if test="${plan.planAccountState == 'INACTIVE'}">
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
						<c:set var="previousPage" value="${currentPage+1}" ></c:set>
						<a href="viewPlansPaging?pageNo=${previousPage-1}&pageSize=3">Previous</a>
					</c:if>
					<c:if test="${!hasPrevious}">
						<a>Previous</a>
					</c:if>
					&nbsp;
					&nbsp;
					<c:forEach begin="1" end="${totalPages}" var="i" varStatus="index">
						<a href="viewPlansPaging?pageNo=${index.count}&pageSize=3">${index.count}</a>
					</c:forEach>
				</c:if>
					&nbsp;
					&nbsp;
					<c:if test="${hasNext}">
						<c:set var="nextPage" value="${currentPage+1}"></c:set>
						<a href="viewPlansPaging?pageNo=${nextPage+1}&pageSize=3">Next</a>
					</c:if>
					<c:if test="${!hasNext}">
						<a>Next</a>
					</c:if>
		</div>
	</div>
</body>
</html>