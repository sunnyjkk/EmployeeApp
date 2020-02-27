<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

	<head>
		<title>Employee | Management</title>
	
	</head>
	
	<body>
		<h1>Add New Employee</h1>
			
			
			<form:form action="${pageContext.request.contextPath}/save" modelAttribute="employee" method="Post">
		
				Firstname: <br />
				<form:input type="text" path="firstName" />
				
				<br /><br />
				
				Lastname: <br />
				<form:input type="text" path="lastName" />
				
				
				<br /><br />
				Email: <br />
				<form:input type="email" path="email" />
				
				
				<br /><br />
				Phone-number: <br />
				<form:input type="text" path="phoneNumber" />
				
				
				<br /><br />
				<input type="submit" value="Save"> 
				
			</form:form>
		
		<br /> <br />
		
	
	
	</body>

</html>