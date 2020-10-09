<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Customer</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>HR_Administrator</h2>
		</div>
	</div>

	<div id="container" >
		<h3>Save Employee</h3>
	
		<form:form action="saveEmployee" modelAttribute="employee" method="POST">
		
		<!-- need to associate data with customer id -->
		<form:hidden path="id"/>
		
			<table class="table" >
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="firstName" /></td>
					</tr>
				
					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path="lastName" /></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" /></td>
					</tr>
					
					<tr>
						<td><label>Sex:</label></td>
						<td><form:input path="sex" /></td>
					</tr>
					
					<tr>
						<td><label>Date of Birth:</label></td>
						<td><form:input path="dob" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/employee/list" class="p">Back to List</a>
		</p>
	
	</div>

</body>

</html>










