<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="css/registration.css">
<link rel="stylesheet" href="css/validation-category.css">
<%-- <form:form action="updateProfile" method="post">
    <input type="text" name="login" value="${customer.login}">
    <input type="text" name="mail" value="${customer.mail}">
    <input type="text" name="password">
    <button>save updates</button>
</form:form> --%>
<sf:form action="updateProfile" method="post">
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600' rel='stylesheet' type='text/css'>
<link href="//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css" rel="stylesheet">

<div class="testbox">
  <h1>Change registration inf</h1>

  <form>
   
	 <label for="name" >${loginException}</label>
    <input type="text" name="login" value="${customer.login}" required="required">
    <label for="mail">${mailException}</label> 
    <input type="email" name="mail" value="${customer.mail}" required="required" pattern="\S+@[a-z]+.[a-z]+">
    <label for="password">${passwordException}</label>
    <input type="password" name="password" placeholder="enter new password" required="required">
    <input type="submit" value="save">
   <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
  </form>
</div>	  
						
	
	
	
	
	</sf:form>
	



















<%-- <br>
update only image
<br>
<form:form action="./saveImage?${_csrf.parameterName}=${_csrf.token}"
           method="post" enctype="multipart/form-data">
    <input type="file" name="image" id="image">
    <button id="saveImage">save new image</button>
</form:form>
<br>


<script>
    if(document.getElementById('image').value == ''){
    }else{
        document.getElementById('saveImage').textContent = 'saveImage';
    }
</script> --%>