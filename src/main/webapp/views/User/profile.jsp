<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
 
<link rel="stylesheet" href="css/profile.css">

${customer.login} ${customer.mail} 

<h1><center>Your Commodities</center></h1>
<c:forEach var="toy" items="${toys}">

	<ul class="photo-stack-grid">
  <li>
    <a href="#d">
      <figure class="photo-stack">
          
          
        <!-- 
            ***change aspect ratio of image - /200/400*** 
        -->
        <img src="http://3i1e5d437yd84efcy34dardm.wpengine.netdna-cdn.com/wp-content/uploads/2017/07/despicable-me-3-talking-jail-time-tom-toy-2017-2018.jpg" />
          
          
      </figure>
      <p>Name:${toy.name}</p>
      <p>Category:${toy.category.name}</p>
      <p>Price:${toy.price}$</p>
     
	  <a href="deleteToyFromCustomer/${toy.id}">delete</a> 
	</a>

</li>
</ul>
<br>

</c:forEach> 
<img src="${customer.pathImage}" alt="add foto" width="300px" height="300px">

<form:form action="./saveImage?${_csrf.parameterName}=${_csrf.token}"
	method="post" enctype="multipart/form-data">
	<input type="file" name="image" required="required">
	<button>save image</button>
	
</form:form>


<!--<a href="updateProfile" class="button3">update profile</a>-->