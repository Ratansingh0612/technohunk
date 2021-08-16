<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
    <title>${companyName} - Login</title>
    
</head>
<body id="page-top" class="home">

<!-- PAGE WRAP -->
<div id="page-wrap">


    <!-- HEADER -->
    <header id="header" class="header">
    <c:choose>
         <c:when test = "${sessionScope.user_session_data.role=='admin'}">
             <%@include file="aheader.jsp" %>
         </c:when>
         
         <c:otherwise>
              <%@include file="/lheader.jsp" %>
         </c:otherwise>
       </c:choose>
         
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
                            <h2 class="text-uppercase">${loginContentVO.loginTitle}
                            
                            <img src="${pageContext.request.contextPath}/images/icon/user_login.png" alt=""> 
                            </h2>
                             <div class="form-email">
                                    <span id="errorMessage" style="color:yellow;font-weight: bold;">${emessage}</span>
                            </div>
                            <div class="form-email">
                                <input type="text" placeholder="Email/Empid" name="login" id="login" style="color:#000">
                            </div>
                            <div class="form-password">
                                <input type="password" placeholder="Password" id="password" name="password"  style="color:#000;">
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
                		 <k:if test="${sessionScope.user_session_data.role=='admin'}">	
                             <a href="javascript:openLoginPopup(${loginContentVO.lpid});"><img src="${pageContext.request.contextPath}/images/icon/edit.png" style="margin-left: 20px;margin-top: 0px;"/></a>
                           </k:if> 
                        <img src="${pageContext.request.contextPath}/action/dimage?imagePath=${loginContentVO.sliderImage}" alt="" style="height: 600px;"> 
                </div>
    
            </div>
        </div>
        	<marquee><b>${companyName} ${loginContentVO.welcomeMessage}</b></marquee>
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
 <%@include file="/js.jsp" %>
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
			    	 $("#errorMessage").html("");
	     });
		$("input[type='password'][name='password']").keypress(
			     function() {
			    	 $("#errorMessage").html("");
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
						if(password==0) {
							$("#errorMessage").html("Password cannot be blank.");
							$("input[type='password'][name='password']").focus();
							event.preventDefault();
							return;
						} 
						//submitting the form through jQuery
						 $("#loginFormId").submit();
		//preventing default click on image button
		   if(gfound!='found') {
		   	 	event.preventDefault();
	    		 return;
		    }
		 }); //end of signid clicked method
		

	 		$("#psliderimage").change(function(){
	 			readURL(this,'tsliderimage');
			});
		 
		 
	 		 $("#updatecontents").click(function(){
	 				$("#loginModelForm").submit();
	 			});
	 		
		 
	}); //end of the read handler
	
	
	 function readURL(input,tid) {
	       if (input.files && input.files[0]) {
		        var reader = new FileReader();
		        reader.onload = function (e) {
		            $('#'+tid).attr('src', e.target.result);
		        }
		        reader.readAsDataURL(input.files[0]);
		   }
	} 
	
	
	
	function openLoginPopup(lpid){
		 console.log("lpid  = "+lpid);
			var context="${pageContext.request.contextPath}";  
		/* 	fetch(context+"/action/find-main-slider?lpid="+lpid)
			.then(res => res.json())
			.then(json => console.log(json)); */
			 $.getJSON(context+"/action/find-login-content?lpid="+lpid,function(jsonResponse) {
     		  			console.log(jsonResponse);
     		  			$("#welcomeMessage").val(jsonResponse.welcomeMessage);
     		  			$("#loginTitle").val(jsonResponse.loginTitle);
     		  			var icontext="${pageContext.request.contextPath}/action/dimage?imagePath";
     		  		    $("#tsliderimage").attr("src",icontext+"="+jsonResponse.sliderImage);
     		      		$("#sliderimage").val(jsonResponse.sliderImage);
     			  		$("#lpid").val(jsonResponse.lpid);
     		 });
			 $("#loginPageModel").modal("show");
	}
</script>


<!-- Modal -->
<form  id="loginModelForm" action="${pageContext.request.contextPath}/action/edit-login-page"  method="post" enctype="multipart/form-data">
<div id="loginPageModel" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content" style="background-image: url('${pageContext.request.contextPath}/images/bg/backgrounds.jpg');">
      <div class="modal-header"  style="background-color: #37abf2;height: 35px; ">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      <img src="${pageContext.request.contextPath}/images/icon/user-icon.png" width="30px;"/>
            <p style="display: inline;margin-left: 20px;">   <span style="font-weight: bold;" id="name"></span></p>
      </div>
      <div class="bloading">
      <div class="modal-body">
       <span style="color:red;font-size: 15px;" id="ErrorMessage"></span>
       
       	<input type="hidden" name="lpid" id="lpid"/>
      <div class="form-group">
      	 Main Heading   :   <span style="font-weight: bold;color:red;">*</span>
        <input type="text" class="form-control" id="welcomeMessage" name="welcomeMessage"/>
        </div>
        
          <div class="form-group">
       Login Title   :   <span style="font-weight: bold;color:red;">*</span>
        <input type="text" class="form-control" id="loginTitle" name="loginTitle"/>
        </div>
      
      
           <div class="form-group">
           
       Slider Image   :   <span style="font-weight: bold;color:red;">*</span>
       <input type="hidden" name="sliderImage" id="sliderimage">
        <input type="file" class="form-control" id="psliderimage" name="psliderImage"/>
            <img src="" id="tsliderimage" style="height: 120px;">
        </div>
      </div>
      </div>
      <div class="modal-footer">
        	<input type="button" value="Close"  class="mc-btn btn-style-1" id="close"  data-dismiss="modal"/>
        	<input type="button"  value="Update Contents" class="mc-btn btn-style-1" id="updatecontents"/>
      </div>
    </div>

  </div>
</div>
</form>
</body>
</html>