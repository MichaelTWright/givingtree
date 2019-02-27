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
       
         <div class="container">
            <div id="form" class="row center">
           
            <img class="header center" style="width:100px; height:auto; margin-top: 100px;" src="img/download.png" alt="">
            <h5 class="header center light">Company Login</h5>
            <br>
        	<p><c:out value="${error}" /></p>
              <form method="post" action="/logincompany">
          
                <div class="input-field">
                  <input type="text" id="phone" name="phone">
                  <label for="phone">Phone</label>
                </div>
                <br>
          
                <div class="input-field">
                  <input type="password" id="pass" name="password">
                  <label for="password">Password</label>
                </div>
                <br>
          
            
                <button id="button" type="submit" value="login" class='col s12 btn btn-large waves-effect' style="background-color: #0a862e">Login</button>
       
              </form>
              <p id="back"><a href="/">Go Back</a></p>
      
            </div>
          </div>



      



  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="js/materialize.js"></script>


  </body>
</html>