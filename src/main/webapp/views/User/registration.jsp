<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="css/registration.css">
<link rel="stylesheet" href="css/validation-mail.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


    <%--  <c:forEach var="customer" items="${customers}">
		
			 ${customer.login} ${customer.mail}
			<a href="deleteCustomer/${customer.id}">delete customer</a>
		<br>
	</c:forEach> --%>

	<%-- <c:forEach var="customerDto" items="${customerDtos}">
		
			${customerDto.login} ${customerDto.mail} 
			<a href="deleteCustomer/${customerDto.id}">delete</a> 
			<a href="deleteCustomer/${authorDto.id}">delete customer</a>
		<br>
	</c:forEach> --%>
	<form:form  modelAttribute="customer" action="registration" method="post">
		
		<%-- 	 <form> 
			
						<label for="name">${loginException}</label>
						<form:input path="login" type="text" placeholder="login"/>
							
					

						<label for="mail">${mailException}</label>
						<form:input path="mail" type="text" placeholder="email"/>
							

						<label for="password">${passwordException}</label>
						<form:input path="password" type="password" placeholder="password"/>
							
							<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/> 
					
						 <input type="submit" value="SEND"  /> 
						 
    
			
						 
			</form>	 --%>	
			<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600' rel='stylesheet' type='text/css'>
<link href="//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css" rel="stylesheet">

<div class="testbox">
  <h1>Registration</h1>

  <form>
      <hr>
    <div class="accounttype">
      <input type="radio" value="None" id="radioOne" name="account" checked/>
      <label for="radioOne" class="radio" chec>Personal</label>
      <input type="radio" value="None" id="radioTwo" name="account" />
      <label for="radioTwo" class="radio">Company</label>
    </div>
  <hr>
  <label for="name" >${loginException}</label>
  <form:input path="login" type="text" placeholder="login" />
							
  <label for="mail">${mailException}</label>
  <form:input path="mail"  type="email" placeholder="example@gmail.com"  />
							
  <label for="password">${passwordException}</label>
  <form:input path="password" type="password" placeholder="password"/>
  <div class="gender">
    <input type="radio" value="None" id="male" name="gender" checked/>
    <label for="male" class="radio" chec>Male</label>
    <input type="radio" value="None" id="female" name="gender" />
    <label for="female" class="radio">Female</label>
   </div> 
   <p>By clicking Register, you agree on our <a href="#">terms and condition</a>.</p>
   <input type="submit" value="Send">
   <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/> 
  </form>
</div>	  
						
				
				 	 
				
	</form:form>
	
	