<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
  
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
	<link rel="stylesheet" href="css/list.css">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<c:forEach var="toy" items="${searchedToys}">
<ul class="photo-stack-grid">
  <li>
    <a href="#d">
      <figure class="photo-stack">
          
        
        <img src="http://3i1e5d437yd84efcy34dardm.wpengine.netdna-cdn.com/wp-content/uploads/2017/07/despicable-me-3-talking-jail-time-tom-toy-2017-2018.jpg" />
          
          
      </figure>
      <p>Name:${toy.name}</p>
      <p>Category:${toy.category.name}</p>
      <p>Price:${toy.price}$</p>
       <sec:authorize access="isAuthenticated()">
		 <sec:authorize access="!hasRole('ROLE_ADMIN')">

		<h1><a href="buyToy/${toy.id}" >buy</a></h1>
				</sec:authorize>
        </sec:authorize>
    </a>
  </li>
</ul>
		
        </c:forEach>