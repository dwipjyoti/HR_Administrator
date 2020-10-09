<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/loginForm.css"
		  />
</head>



<body>


	<div class="loginbox">
	<img src="https://vectorified.com/images/google-profile-icon-26.png"
			class="avatar">
			
		<h1 class="h1">Login Here</h1>
		
		<form:form action="processLogin" modelAttribute="user" method="post">
			
			<p>Username</p> 
			<form:password style="color:#696969;" path="user_name" name="" placeholder="enter username"/>
			
			<p>Password</p>
			<form:password style="color:#696969;"  path="user_password" placeholder="enter password"/>
			<br>
			${msg}
			<br>
			<input type="submit" value="login" />
			<br>
			
		
	
	</form:form>
	</div>



</body>




</html>