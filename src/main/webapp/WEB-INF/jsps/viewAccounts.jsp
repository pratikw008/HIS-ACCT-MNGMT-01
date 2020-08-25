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

$("#role").change(function(){
$("#user_table").empty();
		$("#role").find('table').remove();
		var role=$("#role").val();
		  $.ajax({
                 type :"GET",
                   url  : "getUserByRole?role="+role,
                   success : function(res){
                	   var tr = '';
                	   var action='';
               		   var table =' <table id="response_table" border="1"><thead> <tr><th>Name</th><th>Email</th><th>Action</th></tr></thead><tbody>'; 
               
						$.each(res,function(key,value){

                        	var state = value.accountState;

                            if(state ==='ACTIVE'){
								action='<a href=edit?id='+value.userId+'>Edit</a>' +'||'+ '<a href=delete?id='+value.userId+' onClick=return deleteConfirm()>Delete</a>';
							} 
							else{
	                        	action='<a href=edit?id='+value.userId+'>Edit</a>' +'||'+ '<a href=activateAcc?id='+value.userId+'>Active</a>';
		                    }   	
                            table += '<tr><td>' + value.firstName + '</td><td>' + value.email + '</td><td>' +action + '</td></tr>';
                        });

                        table += '  </tbody> </table>';

   	                	$('#user_table').append(table);
                                       // $('#response_table tbody').html(tr);
                  }
                });
          });
		});
function deleteConfirm(){
	return confirm("Are you sure, you want to delete?");
}
</script>
</head>
<body>
	<div align="center">
		<h1>View Accounts</h1>
		<table>
			<tr>
				<td><b>Select Role:</b></td>
				<td><select id="role">
						<option value="">--Select--</option>
						<c:forEach var="role" items="${roles}">
							<option value="${role}" label="${role}" />
						</c:forEach>
				</select></td>
			</tr>
		</table>
		<table id="user_table" border="1">
			<thead>
				<tr>
					<th>Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
</body>
</html>