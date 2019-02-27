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
  <link href="css/style.css" type="text/css" rel="stylesheet"/>
</head>
<body>
  <nav class="white" role="navigation">
    <div class="nav-wrapper container">
      <a id="logo-container" href="/" class="brand-logo"> <img style="width:70px; height:auto; margin-top: 5px;" src="img\download2.png" alt=""></a>
      <ul class="right hide-on-med-and-down">
        <li style="margin-top: 5px;"><a  href="/logout" style="color: #1413109e;"><h6><b>Logout</b></h6></a></li>
      </ul>
    </div>
  </nav>

  <div  class="parallax-container">
    <div class="section no-pad-bot">
      <div class="container">
        <br><br>
        <div class="row center">
      		<div class="col s12 m3" ></div>
      		<div class="col s12 m6" style="border: 3px solid white;" >
		        <h1 id="head" class="header center white-text ">Hello, ${user.name}</h1>
      		</div>
      </div>
       
        <div class="col s12 m4">
        
       <div class="row center">
      		<div class="col s12 m4" ></div>
      		
      		<div class="col s12 m4" >
          
         
           </div>
      	</div>
            
              
        </div>
      </div>
    </div>
    <div class="parallax"><img src="img/back.jpg" alt="Unsplashed background img 1"></div>
  </div>




      <!--   Icon Section   -->
      <div class="row center">
      <div class="col s12 m1" ></div>
        <div class="col s12 m3" id="border">
            <h5 id="lisy" class="header center light">Call List</h5>
            <table id="myTable2">
            <tbody>
            <c:if test="${not empty list}">
             <c:forEach var="b" items="${list}">
              <tr>
                <td>${b.name}</td>
                <td>${b.phone}</td>
                <td>
                  <a  href="delete/${user.id}/${b.id}" ><img title="remove" style="width:20px; height:auto;" src="img/cancelgrey.png" alt=""></a>
                </td>
              </tr>
             </c:forEach>
            </c:if>
             <c:if test="${empty list}">
                 	<tr>
	                    <td class="center">--------------</td>
	                    <td class="center">--------------</td>
	                    <td class="center">--------------</td>
	                 </tr>
			       
			 </c:if>
        
            </tbody>
          </table>
      
        </div>
      <div class="col s12 m1" ></div>

        <div class="col s12 m2 center text-center" style="
    margin-top: 10px;">
          <form action="/company/${user.id}" method="POST">
           <div class="form-group">
                          <label>Registered Charities</label>
                      <select class="browser-default" name="bank">
                         <c:forEach items="${banks}" var="b">
                             <c:choose>
                            <c:when test="${user.getRequest_banks().contains(b)}">
                              <option value="${b.id}" disabled><c:out value="${b.name}"/></option>	
                            </c:when>
                            <c:when test="${user.getBanks().contains(b)}">
                              <option value="${b.id}" disabled><c:out value="${b.name}"/></option>	
                            </c:when>
                            <c:otherwise>
                                       <option value="${b.id}"><c:out value="${b.name}"/></option>		
                            </c:otherwise>
                          </c:choose>
                               </c:forEach>
                      </select>  
                  </div>
                  <input style="margin: 10px 0 30px 0; background-color: #23a346;"  type="submit" value="Request" class="btn btn-default">
                </form>
        </div>
        <div class="col s12 m1" ></div>
        <div class="col s12 m3" id="border">
    
           <h5 id="lisy" class="header center light">Waiting Approval</h5>
            <table id="myTable">
            <tbody>
             <c:if test="${not empty requests}">
	            <c:forEach var="bank" items="${requests}">
	              <tr>
	                <td>${bank.name}</td>
	              </tr>
	             </c:forEach>
             </c:if>
             <c:if test="${empty requests}">
                <tr>
                    <td class="center">--------------</td>
                 </tr>
		       
			 </c:if>
            </tbody>
          </table>
          <tbody>
          
        </div>

        
      </div>

    </div>
  </div>


 


  <div class="parallax-container valign-wrapper">
    <div class="section no-pad-bot">
    </div>
    <div class="parallax"><img src="img\back2.jpg" alt="Unsplashed background img 3"></div>
  </div>
   <footer class="page-footer" style="background:#a6ad87; height: 200px; ">
    <div class="container">
      <div class="row" style="margin-top: 40px">
      <div class="col l1 s12 center">
           
      </div>
        <div class="col l2 s12 center">
         <img style="width:70%; height:auto;" src="img/Amazon_feature.png" alt="">

        </div>
        <div class="col l2 s12 center">
           <img style="width:40%; height:auto;" src="img/arrow.png" alt="">
        </div>
         <div class="col l2 s12 center">
           <img style="width:60%; height:auto;" src="img/sms.png" alt="">
        </div>
         <div class="col l2 s12 center">
           <img style="width:40%; height:auto;" src="img/arrow.png" alt="">
        </div>
        <div class="col l2 s12 center">
           <img style="width:35%; height:auto;" src="img/recieve.png" alt="">
        </div>
           <div class="col l1 s12 center">
           
      </div>
      </div>
    </div>

  </footer>


  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="js/materialize.js"></script>
  <script src="js/init.js"></script>
  <script type="text/javascript" src="js/pagination.js"></script>
 
  
  <script>
  $(document).ready(function(){
	  $('#myTable').pageMe({
	    pagerSelector:'#myPager',
	    activeColor: 'blue',
	    prevText:'Anterior',
	    nextText:'Siguiente',
	    showPrevNext:true,
	    hidePageNumbers:false,
	    perPage:3
	  });
	  
	  $('#myTable2').pageMe({
	    pagerSelector:'#myPager2',
	    activeColor: 'blue',
	    prevText:'Anterior',
	    nextText:'Siguiente',
	    showPrevNext:true,
	    hidePageNumbers:false,
	    perPage:3
	  });
  </script>

  </body>
</html>