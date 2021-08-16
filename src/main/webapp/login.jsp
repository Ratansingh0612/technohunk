<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <!-- Google font -->
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Raleway:300,400,700,900' rel='stylesheet' type='text/css'>
    <!-- Css -->
        <%@include file="/resources.jsp" %>
        
    <title>${companyName} - Login Page</title>
    
</head>
<body id="page-top" class="home">

<!-- PAGE WRAP -->
<div id="page-wrap">


    <!-- HEADER -->
    <header id="header" class="header">
        <%@include file="/lheader.jsp" %>
    </header>
    <br/>
    <!-- END / HEADER -->


    <!-- LOGIN -->
    <section id="login-content" class="login-content">
        <div class="awe-parallax bg-login-content"></div>
        <div class="awe-overlay"></div>
        <div class="container">
            <div class="row">
                <!-- FORM -->
                <div class="col-xs-12 col-lg-4 pull-right">
                    <div class="form-login">
                        <form id="loginFormId" method="post" action="${pageContext.request.contextPath}/action/validateUser">
                            <h2 class="text-uppercase">sign in</h2>
                              <div class="form-email">
                                    <span id="errorMessage" style="color:yellow;font-weight: bold;">${emessage}</span>
                            </div>
                            <div class="form-email">
                                <input type="text" placeholder="Email/Empid" id="login" name="login" style="color:black;">
                            </div>
                            <div class="form-password">
                                <input type="password" placeholder="Password" id="password" name="password" style="color:black;">
                            </div>
                            <div class="form-check">
                                <input type="checkbox" id="check">
                                <label for="check">
                                <i class="icon md-check-2"></i>
                                Remember me</label>
                                <a href="#">Forget password?</a>
                            </div>
                            <div class="form-submit-1">
                                <input type="button" value="Sign In" class="mc-btn btn-style-1"  id="go" name="go" >
                            </div>
                            <div class="link">
                                <a href="${pageContext.request.contextPath}/register.jsp">
                                    <i class="icon md-arrow-right"></i>Don't have account yet ? Join Us
                                </a>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- END / FORM -->
   
                <div class="image">
                   <img src="${pageContext.request.contextPath}/images/homeslider/services-students.png" alt=""> 
                </div>
    
            </div>
        </div>
    	<marquee><b>${companyName} Online Exam welcomes you ! , all the best</b></marquee>
    </section>
    <!-- END / LOGIN -->
    
      
    <!-- FOOTER -->
    <footer id="footer" class="footer"  style="background-color: #00192e">
         <%@include file="/ffooter.jsp" %>
 		<%@include file="/sfooter.jsp" %>
    </footer>
    <!-- END / FOOTER -->
</div>
<!-- END / PAGE WRAP -->
<!-- Load jQuery -->
 <%@include file="js.jsp" %>
 <script>
var ccontextPath="${pageContext.request.contextPath}";
	$(function() {
		
		$("#password").keyup(function(e) {
			 if(e.keyCode == 13) {
				 $("#loginFormId").submit();
			 }
		});
		
		$("input[type='text'][name='login']").keypress(
			     function() {
			    	 $("#errormessage").html("");
	     });
		$("input[type='password'][name='password']").keypress(
			     function() {
			    	 $("#errormessage").html("");
	     });
		
		$("#go").click(
			     function(event) {
			    	 var gfound="nfound";
			    	 var login=$("input[type='text'][name='login']").val();
						if(login.length==0) {
							$("#errorMessage").html("Login id cannot be blank.");
							$("input[type='text'][name='login']").focus();
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
						 $("#loginFormId").submit();
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