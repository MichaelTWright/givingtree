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

  <!-- header -->
  <div role="navigation" style="border-bottom: solid rgba(0, 0, 0, 0.233) 2px; ">
    <div class="nav-wrapper container">
      <a id="logo-container" href="#" class="brand-logo">
        <img style="width:90px; height:auto; margin-top: 5px;" src="img/download.png" alt="">
      </a>


      <ul class="right hide-on-med-and-down">
          <li><a  href="#login" class="modal-trigger" style="color: #1413109e;"><h6><b>Login</b></h6></a></li>
      </ul>
     
    </div>
  </div>

  <!-- main content -->
  <div class="section no-pad-bot" id="index-banner" style="
  padding-top: 0px;">
    <div class="container">
      <br><br>
      <h3 class="header center" style="margin-top: 0;" #92506c>Connecting food donators with local food banks</h3>
      <div class="row center">
        <h5 class="header col s12 light">With a click of a button...</h5>
        <img style="width:300px; height:auto;" src="img/Amazon_feature.jpg" alt="">
        <h5 class="header col s12 light">alert charities in your area to pick-up your surplus</h5>
        
        
      </div>
      <div class="row center">
        <a href="#start" id="download-button" class="btn-large waves-effect waves modal-trigger" style="background-color: #0a862e ">Get Started</a>
      </div>
      <br><br>

    </div>

    

  <!-- register start -->
  <div id="start" class="modal">
      <div class="modal-content">
        <h4 class="row center" style="
        margin-bottom: 50px;" >You are a _______ .</h4>
        <div class="row center">
          <a href="/companyreg" id="download-button" class="btn-large waves-effect waves modal-trigger" style="background-color: #46a3d6 ">Company (Donator)</a>
          <div style="width: 50px; display: inline-block;">or</div>
          <a href="/bankreg" id="download-button" class="btn-large waves-effect waves modal-trigger" style="background-color: #0a862e ">Charity (Food Bank)</a>
        </div>
      </div>
      <div class="modal-footer">
        <a href="#!" class="modal-close waves-effect waves-green btn-flat">Exit</a>
      </div>
    </div>
    <!-- login start -->
    <div id="login" class="modal">
        <div class="modal-content">
          <h4 class="row center" style="
          margin-bottom: 50px;" >You are a _______ .</h4>
          <div class="row center">
            <a href="/companylog" id="download-button" class="btn-large waves-effect waves" style="background-color: #46a3d6 ">Company (Donator)</a>
            <div style="width: 50px; display: inline-block;">or</div>
            <a href="/banklog" id="download-button" class="btn-large waves-effect waves" style="background-color: #0a862e ">Charity (Food Bank)</a>
          </div>
        </div>
        <div class="modal-footer">
          <a href="#!" class="modal-close waves-effect waves-green btn-flat">Exit</a>
        </div>
      </div>
      
      




      



  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="js/materialize.js"></script>
  <script src="js/init.js"></script>
  
  <script>
      $(document).ready(function(){
        $('.modal').modal();
      });
  </script>

  </body>
</html>