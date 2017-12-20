<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer </title>
</head>
<body>
	<c:forEach var="customer" items="${customers}" >
			${customer.login} ${customer.password}
			${customer.mail} 
			<a href="deleteCustomer/${customer.id}">delete</a> 
			<br> 


	</c:forEach>
	<form action="saveCustomer" method="post">
	
		<input name="login" placeholder="login"> <br>
		<input name="password" placeholder="password"> <br>
		<input name="mail" placeholder="mail"> <br>
		
		<button>add Customer</button>
	
	
	
	</form>

	

</body>
</html>