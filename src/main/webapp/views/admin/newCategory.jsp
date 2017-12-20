<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
       <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
       <link rel="stylesheet" href="css/registration.css">
<link rel="stylesheet" href="css/validation-category.css">
	<c:forEach var="category" items="${categories}" >
			${category.name}
			 
			<a href="deleteCategory/${category.id}">delete</a> 
			<c:forEach var="toy" items="${category.toys}">
			${toy.name}
			<a href="deleteToyFromCategory/${toy.id}">delete toy</a>

		</c:forEach>
			<br> 
			


	</c:forEach>
	
	<sf:form modelAttribute="category" action="saveCategory" method="post">
	<%---------------- <label for="name" >${nameException}</label>
	<sf:input path="name" placeholder="name"/><br>
	<label for="type" >${typeException}</label>
	<sf:input path="type" placeholder="type"/><br>
	<label for="status" >${statusException}</label>
	<sf:input path="status" placeholder="status"/><br>
	
	
	
	
	<input type="submit" value="save category"> -----------------------------%> 
		
	
	
				<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600' rel='stylesheet' type='text/css'>
<link href="//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css" rel="stylesheet">

<div class="testbox">
  <h1>New Category</h1>

  <form>
   
  	<label for="name" >${nameException}</label>
	<sf:input path="name" type="text" placeholder="name" required="required"/>
  	<input type="submit" value="save category">
   <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/> 
  </form>
</div>	  
						
	
	
	
	
	</sf:form>
	
	
	
	
	<!-- <form action="saveCategoryOfCommodity" method="post">
	
		<input name="name" placeholder="category"> <br>
		<input name="availability" placeholder="availability"> <br>
		
		<button>save  category</button>
	
	
	
	</form> -->

	

