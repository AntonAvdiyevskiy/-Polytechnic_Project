<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
  
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
	<link rel="stylesheet" href="css/list.css">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<sec:authorize access="hasRole('ROLE_ADMIN')">

	<a href="admin" class="button3">admin page</a>

</sec:authorize>
<form:form modelAttribute="toy" action="search" method="post">
  <h1>search toy by name</h1>
   <form>
   
  
		
		<form:input path="name" type="text" placeholder="name of Brand" required="required"/>
		<input type="submit" value="search">
        <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/> 
		
   </form>	
  </form:form> 
  <form:form modelAttribute="toy" action="sortPrice" method="post">
  <h1>show toys by the price lower then you enter</h1>
   <form>
   
  
		
		<form:input path="price" type="text" placeholder="sort by price" required="required"/>
		<input type="submit" value="search">
        <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/> 
		
   </form>	
  </form:form> 
  <form:form modelAttribute="toy" action="sortByCategory" method="post">
  <h1>show all toys by chose category</h1>
   <form>
		<form:select path ="id" > 
			<c:forEach var="category" items="${categoriesOfToy}"> 
				<form:option value="${category.id}">${category.name}</form:option>
			</c:forEach> 
		</form:select> 
		<input type="submit" value="sort by category">
        <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/> 
		
   </form>	
  </form:form> 
   
<c:forEach var="toy" items="${toys}">
<ul class="photo-stack-grid">
  <li>
    <a href="#d">
      <figure class="photo-stack">
          
        
        <img src="http://3i1e5d437yd84efcy34dardm.wpengine.netdna-cdn.com/wp-content/uploads/2017/07/despicable-me-3-talking-jail-time-tom-toy-2017-2018.jpg" />
          
          
      </figure>
      <p>Name:${toy.name}</p>
      <p>Category:${toy.category.name}</p>
      <p>Price:${toy.price}</p>
       <sec:authorize access="isAuthenticated()">
		 <sec:authorize access="!hasRole('ROLE_ADMIN')">

		<h1><a href="buyToy/${toy.id}" >buy</a></h1>
				</sec:authorize>
        </sec:authorize>
    </a>
  </li>
</ul>
		
        </c:forEach>
        <input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}"/>
<input type="hidden" name="csrf_value"
       value="${_csrf.token}"/>


  

 


<%-- <sec:authentication property="name"/> --%>
<sec:authorize access="isAuthenticated()">
<form:form action="logout" method="post">
  
<button class = "button1">logout</button>
</form:form>

</sec:authorize>
<br>

 
<sec:authorize access="hasRole('ROLE_USER')">

	<a href="profile" class="button2">profile</a>

</sec:authorize>
 
<br>

<br>
























