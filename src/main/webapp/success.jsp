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
    <title>Member Registration</title>
     
</head>
<body id="page-top" class="home">

<!-- PAGE WRAP -->
<div id="page-wrap">


     <!-- HEADER -->
    <header id="header" class="header">
        <%@include file="/lheader.jsp" %>
    </header>
    <!-- END / HEADER -->

    <!-- LOGIN -->
    <section id="login-content" class="login-content">
        <div class="awe-parallax bg-login-content"></div>
        <div class="awe-overlay"></div>
        <div class="container">
            <div class="row">
                <!-- FORM -->
				  <span id="errorMessage" style="color:#000000;font-size: 20px;"><img src="${pageContext.request.contextPath}/images/icon/success-icon.png" style="height:30px;"/>${ApplicationMessage}${param.ApplicationMessage}</span>	
               	  <hr/>
                 <span id="errorMessage" style="color:black;font-size: 18px;margin-left: 400px;"><a href="${pageContext.request.contextPath}/action/oauth">Please click here to login!<img src="${pageContext.request.contextPath}/images/elogin.png" style="height: 100px;"></a></span>	
                <div class="col-lg-5 pull-right" style="height: 450px;">
                	
                    <%-- <div class="form-login">
                      <form id="registrationForm" action="${pageContext.request.contextPath}/action/userRegistration" method="post">
                            <h2 class="text-uppercase">sign up</h2>
                              <input type="hidden" name="member" value="yes"/>
                             <div class="form-email">
                                    <span id="errorMessage" style="color:yellow;font-weight: bold;"></span>
                            </div>
                            <div class="form-fullname">
                                <input class ="first-name"type="text" placeholder="First name" name="firstName" style="color:black;">
                                <input class="last-name" type="text" placeholder="Last name" name="lastName" style="color:black;">
                            </div>
                            <div class="form-datebirth">
                                <input type="text" placeholder="Date of Birth" name="dob" style="color:black;">
                            </div>
                            <div class="form-email">
                                <input type="text" placeholder="Email" name="email" style="color:black;">
                            </div>
                            <div class="form-password">
                                <input type="password" placeholder="Password" name="password" style="color:black;">
                            </div>
                            
                            <div class="form-submit-1">
                                <input type="button" id="becomeMemeber" value="Become a member" class="mc-btn btn-style-1">
                            </div>
                            <div class="link">
                                <a href="login.html">
                                    <i class="icon md-arrow-right"></i>Already have account ? Log in
                                </a>
                            </div>
                        </form>
                    </div> --%>
                </div>
                <!-- END / FORM -->
    
                <div class="image">
                    <img src="images/homeslider/img-thumb.png" alt="">
                </div>
    
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