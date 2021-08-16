<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from envato.megadrupal.com/html/megacourse/register.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 19 Mar 2017 04:41:39 GMT -->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <!-- Google font -->
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Raleway:300,400,700,900' rel='stylesheet' type='text/css'>
     <!-- Css -->
        <%@include file="/resources.jsp" %>
    <!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
    <![endif]-->
    <title>Success Confirmation Page</title>
     
</head>
<body id="page-top" class="home">

<!-- PAGE WRAP -->
<div id="page-wrap">


     <!-- HEADER -->
    <header id="header" class="header">
        <%@include file="/lheader.jsp" %>
    </header>
    <!-- END / HEADER -->
    
       <!-- PROFILE FEATURE -->
    <section class="profile-feature">
        <div class="awe-parallax bg-profile-feature"></div>
        <div class="awe-overlay overlay-color-3"></div>
        <div class="container">
            <div class="info-author">
            
                <div class="image">
                    <img src="${pageContext.request.contextPath}/action/imageByUserId?userid=${sessionScope.user_session_data.loginId}" alt="">
                </div>    
                <div class="name-author">
                    <h2 class="big" style="color:#E91E63;font-size: 24px;">${sessionScope.user_session_data.name}Hello Mr. Nagendra</h2>
                </div>     
                <div class="address-author">
                    <i class="fa fa-map-marker"></i>
                    <h3>${sessionScope.user_session_data.address}&nbsp;&nbsp;(${sessionScope.user_session_data.batch})</h3>
                </div>
            </div>
              <%@include file="/tech-profile.jsp"%>
        </div>
    </section>
    <!-- END / PROFILE FEATURE -->
    

    <!-- LOGIN -->
    <section id="login-content" class="login-content1" style="height: 500px;">
        <div class="awe-parallax bg-login-content1"></div>
        <div class="awe-overlay"></div>
        <div class="container">
            <div class="row" style="margin-top: 30px;">
                <!-- FORM -->
				  <span id="errorMessage" style="color:rgb(23, 86, 144);font-weight: bold;font-size: 17px;margin-left: 10px;">
				   <img src="${pageContext.request.contextPath}/images/mobile_confirm-256.png" style="height: 100px;"/>${ApplicationMessage}
				    You have successfully registered with us , please click here to go to home page
				   </span>	
               	<!--   <hr/> -->
                 <img src="${pageContext.request.contextPath}/images/happy-students.jpg">
                 <span id="errorMessage" style="color:#ffffff;font-weight: bold;font-size: 16px;margin-left: 400px;">
                </span>	
                <!-- END / FORM -->
    
    
            </div>
        </div>
    </section>
    <!-- END / LOGIN -->
    
      
    <!-- FOOTER -->
  <!-- FOOTER -->
    <footer id="footer" class="footer">
         <%@include file="/ffooter.jsp" %>
 		<%@include file="/sfooter.jsp" %>
    </footer>
    <!-- END / FOOTER -->
    <!-- END / FOOTER -->


    


</div>
<!-- END / PAGE WRAP -->

<!-- Load jQuery -->
 <%@include file="js.jsp" %>
 <script>
var ccontextPath="${pageContext.request.contextPath}";
	$(function() {
		
		$("input[type='text'][name='firstName']").keypress(
			     function() {
			    	 $("#errorMessage").html("");
	     });
		$("input[type='password'][name='password']").keypress(
			     function() {
			    	 $("#errorMessage").html("");
	     });
		
		$("input[type='text'][name='dob']").keypress(
			     function() {
			    	 $("#errorMessage").html("");
	     });
		
		$("input[type='text'][name='email']").keypress(
			     function() {
			    	 $("#errorMessage").html("");
	     });
		
		$("#becomeMemeber").click(
			     function(event) {
			    	 var gfound="nfound";
			    	 var firstName=$("input[type='text'][name='firstName']").val();
						if(firstName.length==0) {
							$("#errorMessage").html("First name cannot be blank.");
							$("input[type='text'][name='firstName']").focus();
							event.preventDefault();
							return;
						}
						
						var dob=$("input[type='text'][name='dob']").val();
						if(dob.length==0) {
							$("#errorMessage").html("Date of birth cannot be blank.");
							$("input[type='text'][name='dob']").focus();
							event.preventDefault();
							return;
						}
						
						var email=$("input[type='text'][name='email']").val();
						if(email.length==0) {
							$("#errorMessage").html("Email cannot be blank.");
							$("input[type='text'][name='text']").focus();
							event.preventDefault();
							return;
						} 
						
						var password=$("input[type='password'][name='password']").val();
						if(password.length==0) {
							$("#errorMessage").html("Password cannot be blank.");
							$("input[type='password'][name='password']").focus();
							event.preventDefault();
							return;
						} 
						 $("#registrationForm").submit();
		//preventing default click on image button
		   if(gfound!='found') {
		   	 	event.preventDefault();
	    		 return;
		    }
		 }); //end of signid clicked method
	});
</script>
</body>
</html>