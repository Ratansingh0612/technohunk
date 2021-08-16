<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
     <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/css/bootstrap-datepicker.css">
     <!-- Css -->
     <%@include file="/resources.jsp" %>
    <!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
    <![endif]-->
    <title>${companyName} | Member Registration</title>
    <style type="text/css">
    .datepicker,
.table-condensed {
  width: 300px;
  //height:500px;
}
    </style>
     
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
                <div class="col-lg-12 pull-right">
                    <div class="form-login" style="width: 650px; max-width: 800px;">
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
                                <input type="text" placeholder="Date of Birth" name="dob" id="dob" style="color:black;">
                                
                            </div>
                            <div class="form-email">
                                <input type="text" placeholder="Email" name="email" style="color:black;">
                            </div>
                            <div class="form-password">
                                <input type="password" placeholder="Password" name="password" style="color:black;">
                            </div>
                            
                            <br/>
                              <div class="mc-select-wrap">
                        <div class="mc-select">
                            <select class="select" name="gender" id="all-categories">
                                <option value="MALE" selected>MALE</option>
                                <option value="FEMALE">FEMALE</option>
                            </select>
                        </div>
                   			 </div>
                            
                            <div class="form-submit-1">
                                <input type="button" id="becomeMemeber" value="Become a member" class="mc-btn btn-style-1">
                            </div>
                        </form>
                    </div>
                </div>
                <!-- END / FORM -->
    
                <div class="image">
               <img src="${pageContext.request.contextPath}/images/createuser.png" alt="" style="height: 580px;">  
                </div>
    			
            </div>
            <br/>
        </div>
    </section>
    <!-- END / LOGIN -->
      
    <!-- FOOTER -->
  <!-- FOOTER -->
     <footer id="footer" class="footer"  style="background-color: #00192e">
         <%@include file="/ffooter.jsp" %>
 		<%@include file="/sfooter.jsp" %>
    </footer>
    <!-- END / FOOTER -->
    <!-- END / FOOTER -->


    


</div>
<!-- END / PAGE WRAP -->

<!-- Load jQuery -->
 <%@include file="js.jsp" %>
<!-- Include Date Range Picker -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/js/bootstrap-datepicker.js"></script>

 <script>
 $(document).ready(function() {
	 var date_input=$('#dob'); //our date input has the name "date"
		///var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
		date_input.datepicker({
			format: 'dd-mm-yyyy',
			autoclose: true,
		})
		$(date_input).datepicker( "setDate", new Date());  
		$("#dob").datepicker();		
 
 });
 
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