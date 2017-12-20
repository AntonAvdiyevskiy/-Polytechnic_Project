<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="css/loginpage.css">
<!-- <h2>login</h2> -->
<%-- <form:form action="loginprocesing" method="post">
	<input name="username" type="text" placeholder="Login"/>
	<input name="password" type="password" placeholder="Password"/>
	<button>login</button> --%>


<form:form action="loginprocesing" method="post">

<div class="container">

  <div id="login-form">

    <h3>Login</h3>

    <fieldset>

    

		<input name="username" type="text" placeholder="Login" required>

        <input name="password" type="password" placeholder="Password" required> <!-- JS because of IE support; better: placeholder="Password" -->

        <input type="submit" value="Login">

        <footer class="clearfix">

        

        </footer>

   

    </fieldset>

  </div> <!-- end login-form -->

</div>

  </form:form>
    