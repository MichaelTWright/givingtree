<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
  <title>gTree</title>

  <!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
</head>
<body>
         <!-- Bank login form -->
         <div class="container">
            <div id="form" class="row center">
           
            <img class="header center" style="width:100px; height:auto; margin-top: 80px;" src="img/download.png" alt="">
            <h5 class="header center light">Charity Registration</h5>
            <br>
        
             <p><form:errors path="bank.*"/></p>
        <form:form method="POST" action="/bregister" modelAttribute="bank">
      
             <div class="input-field">
                <form:input type="text" id="name" path="name"/>
                <form:label path="name">Charity Name</form:label>
              </div>
              <br>
            <div class="input-field">
               <form:input type="text" id="zip" path="zip" />
               <form:label path="zip">Zip Code</form:label>
             </div>
              <br>
           <div class="input-field">
                <form:input type="text" id="phone" path="phone" />
                <form:label path="phone">Phone</form:label>
              </div>
              <br>
        
              <div class="input-field">
                <form:input type="password" id="pass" path="password" />
                <form:label path="password">Password</form:label>
              </div>
              <br>
  
              <div class="input-field">
                  <form:input type="password" id="pass" path="passwordConfirmation" />
                  <form:label path="passwordConfirmation">Password Confirmation</form:label>
              </div>
                <br>
      
            
            <button type="submit" value="Register" class='col s12 btn btn-large waves-effect' style="background-color: #0a862e">Register</button>
            
  </form:form>
              <p id="back"><a href="/">Go Back</a></p>
      
            </div>
          </div>



      



  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="js/materialize.js"></script>


  </body>
</html>