<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css"
		  />


</head>

<body>

	<div id="wrapper" >
		<div id="header" style="text-align:center;">
		
			<h2>HR_Administrator</h2>	
		
		
		</div>
	</div>
	
	
	<div id="container">
	
		<div id="content">
			
			
			<!-- add customer block javascript-->
			<input type="button" value="addEmployee"
				   onclick="window.location.href='showAddForm';return false;"
					   class="add-button" />
			
			
			<br>
			<br>
	
	
		
			<!--  add our html table here -->
		
			<table class="table">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Sex</th>
					<th>Date of Birth</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempEmployee" items="${employees}">
					
					
					<!-- construct update link -->
					<c:url var="updateLink" value="/employee/showFormUpdate">
						<c:param name="employeeId" value="${tempEmployee.id}"/>
					</c:url>
					
					<!-- construct delete link -->
					<c:url var="deleteLink" value="/employee/delete">
						<c:param name="employeeId" value="${tempEmployee.id}"/>
					</c:url>
					<tr>
						<td> ${tempEmployee.firstName} </td>
						<td> ${tempEmployee.lastName} </td>
						<td> ${tempEmployee.email} </td>
						<td> ${tempEmployee.sex} </td>
						<td> ${tempEmployee.dob} </td>
						<td> <a href="${updateLink}">Update</a>
							 |
							 <a href="${deleteLink}">Delete</a> </td>
					</tr>
				
				</c:forEach>
						
			</table>
				
				
		</div>
	
	</div>




</body>



</html>