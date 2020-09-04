<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Application Data View</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#pageSize").change(function() {
			
			$("#pageForm").submit();
		});
	});
</script>
</head>
<body>
	<div align="center">
		<h1>View Applications</h1>
		<c:if test="${!empty applicationList}">
			<form action="viewApplications" method="get" id="pageForm">
				<div align="center">
					<label><b>Page Size</b></label> <select name="pageSize"
						id="pageSize">
						<option value="">--Select--</option>
						<option value="3">3</option>
						<option value="5">5</option>
						<option value="10">10</option>
					</select>
				</div>
			</form>
		</c:if>
	</div>
	<div align="center">
		<c:choose>
			<c:when test="${!empty applicationList}">
				<table border="1">
					<thead>
						<tr>
							<th>Sr.No</th>
							<th>Name</th>
							<th>DOB</th>
							<th>Gender</th>
							<th>SsnNo</th>
							<th>PH.No</th>
							<th>Email</th>
							<th>App State</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach var="application" items="${applicationList}"
							varStatus="index">
							<tr>
								<td>${index.count}</td>
								<td>${application.firstName} ${application.lastName}</td>
								<td>${application.dateOfBirth}</td>
								<td>${application.gender}</td>
								<td>${application.ssnNo}</td>
								<td>${application.phoneNumber}</td>
								<td>${application.applicantEmail}</td>
								<td>${application.deleteState}</td>
								<td>
									<a href="/editApplication?applicationId=${application.applicationId}">Edit</a> 
									<c:if test="${application.deleteState == 'ACTIVE'}">
										<a href="/deleteApplication?applicationId=${application.applicationId}">Delete</a>
									</c:if>
									<c:if test="${application.deleteState == 'INACTIVE'}">
										<a href="/activeApplication?applicationId=${application.applicationId}">Active</a>
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
					<span><b>Total Pages::</b></span><span><b>${totalPages}</b></span>
					&nbsp;
					&nbsp;
					<c:if test="${hasPrev}">
						<a href="viewApplications?pageNo=${currentPage-1}&pageSize=${pageSize}">Previous</a>
					</c:if>
					<c:if test="${!hasPrev}">
						<a>Previous</a>
					</c:if>
					<c:forEach begin="1" end="${totalPages}" var="i" >
						<c:if test="${currentPage == i}">
							${i}
						</c:if>
						<c:if test="${currentPage != i}">
							<a href="viewApplications?pageNo=${i}&pageSize=${pageSize}">${i}</a>
						</c:if>
					</c:forEach>
					<c:if test="${hasNext}">
						<a href="viewApplications?pageNo=${currentPage+1}&pageSize=${pageSize}">Next</a>
					</c:if>
					<c:if test="${!hasNext}">
						<a>Next</a>
					</c:if>
			</c:when>
			<c:otherwise>No Application Found</c:otherwise>
		</c:choose>
	</div>
</body>
</html>