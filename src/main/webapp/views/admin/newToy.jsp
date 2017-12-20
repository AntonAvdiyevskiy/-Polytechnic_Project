<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<script src="/js/jquery-3.1.1.min.js"></script> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
<link rel="stylesheet" href="css/registration.css">
<link rel="stylesheet" href="css/validation-category.css">
<c:forEach var="toy" items="${toys}" > 
${toy.name} ${toy.color} ${toy.price} ${toy.rating}  

<a href="deleteToy/${toy.id}">delete</a> 
<br> 

</c:forEach > 

<sf:form modelAttribute="toy" action="saveToy" method="post" > 
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600' rel='stylesheet' type='text/css'>
<link href="//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css" rel="stylesheet">

<div class="testbox">
  <h1>New Toy</h1>

  <form>
   <label for="name">${toyException}</label>
  <sf:input path="name" type="text" placeholder="name" required="required"/> 
<sf:input path="color" type="text" placeholder="color" required="required"/> 
<input name="price" type="text" placeholder="price"  required="required" />
<input name="rating" type="text" placeholder="rating" required="required"/>  



<%--<sf:select path="category" items="${categoriesOfToy}" itemLabel="name" 
itemValue="id"> 
</sf:select>--%>
<sf:select path="category" itemLabel="name"> 
<c:forEach var="category" items="${categoriesOfToy}"> 
<sf:option value="${category.id}">${category.name}</sf:option>
</c:forEach> 
</sf:select> 


<sf:select path="brand"> 
<c:forEach var="brand" items="${brands}"> 
<sf:option value="${brand.id}">${brand.name}</sf:option>
 
</c:forEach> 
</sf:select> 
  
   
  <input type="submit" value="save toy">
   <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/> 
  </form>
</div>	  
						
	
	
	
	
	</sf:form>
	

	

