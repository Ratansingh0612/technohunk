<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from envato.megadrupal.com/html/megacourse/account-assignment.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 19 Mar 2017 04:41:35 GMT -->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <title>${companyName} - User Profile</title>
</head>
<body id="page-top">

<!-- PAGE WRAP -->
<div id="page-wrap">

    <!-- PRELOADER -->
    <div id="preloader">
        <div class="pre-icon">
            <div class="pre-item pre-item-1"></div>
            <div class="pre-item pre-item-2"></div>
            <div class="pre-item pre-item-3"></div>
            <div class="pre-item pre-item-4"></div>
        </div>
    </div>
    <!-- END / PRELOADER -->

    <!-- HEADER -->
   
         <k:if test="${sessionScope.user_session_data.role=='trainer'}">	
      <%@include file="/theader.jsp"%>
      </k:if>
        <k:if test="${sessionScope.user_session_data.role=='admin'}">	
       <%@include file="/aheader.jsp"%>
       </k:if>
       
       <k:if test="${sessionScope.user_session_data.role=='user'}">
         <%@include file="/uheader.jsp" %>
         </k:if>
       
       <k:if test="${sessionScope.user_session_data.role=='consultant'}">
         <%@include file="/uheader.jsp" %>
         </k:if>
       
       
    <!-- END / HEADER -->


    <!-- PROFILE FEATURE -->
    <%@include file="profile-feature.jsp" %>
    <!-- END / PROFILE FEATURE -->


    <!-- CONTEN BAR -->
     <%@include file="content-bar.jsp" %>
   <!-- END / CONTENT BAR -->
 
    <!-- COURSE CONCERN -->
  <section style="padding-top: 0px;padding-bottom:10px;background-color: white;" id="quizz-intro-section" class="quizz-intro-section learn-section">
        <div class="container">

<!-- PROFILE -->
    
    <section class="profile">
        <div class="container">
            <h3 class="md black">Change Password</h3>
            <div class="row">
                <div class="col-md-9">
                      <form id="passwordChangeForm" action="${pageContext.request.contextPath}/action/uchange-password" method="post">
                    <div class="avatar-acount">
                        <div class="changes-avatar">
         
                            <div class="img-acount">
                                <img src="${pageContext.request.contextPath}/action/imageByUserId?userid=${sessionScope.user_session_data.loginId}" class="img-thumbnail"/>
                            </div>
                           <!--   <div class="choses-file up-file">
                                <input type="file">
                                <input type="hidden">
                                <a href="#" class="mc-btn btn-style-6">Changes image</a>
                            </div>
                            -->                 
                           
                        </div>   
                        <div class="info-acount">
                            <h3 class="md black">${sessionScope.user_session_data.name}</h3>
                            <p>This the page where user can change his/her password. </p>
                            <div class="security">
                                <div class="tittle-security">
                                	 <span id="AppMessage" style="color:blue;font-weight: bold;"></span>	
                                    <h5>Change Password</h5>
                                    
                                    <input type="hidden"  name="userid" value="sessionScope.user_session_data.loginId">
                                    <input type="password"  name="currentPassword" value="${changePassword.currentPassword}" readonly="readonly">
                                    <input type="password" placeholder="New password" name="newPassword">
                                    <input type="password" placeholder="Confirm password" name="confirmPassword">
                                </div>
                            </div>
                        </div>

                        <div class="input-save">   
                            <input type="button" value="Change Password" class="mc-btn btn-style-1" id="changePasswordBt">
                        </div>
                    </div>    
                    </form>
                </div>
<!--                 <div class="col-md-3"> -->
<!--                     <div class="social-connect"> -->
<!--                         <h5>Social connect</h5> -->
<!--                         <ul> -->
<!--                             <li> -->
<!--                                 <a href="#" class="twitter"> -->
<!--                                     <i class="icon md-twitter"></i> -->
<!--                                     <p>https://www.facebook.com/</p> -->
<!--                                 </a> -->
<!--                             </li> -->
<!--                             <li> -->
<!--                                 <a href="#" class="facebook"> -->
<!--                                     <i class="icon md-facebook-1"></i> -->
<!--                                     <p>https://www.facebook.com/</p> -->
<!--                                 </a> -->
<!--                             </li> -->
<!--                             <li> -->
<!--                                 <a href="#" class="gg-plus"> -->
<!--                                     <i class="icon md-google-plus"></i> -->
<!--                                     <p>https://www.facebook.com/</p> -->
<!--                                 </a> -->
<!--                             </li> -->
<!--                             <li> -->
<!--                                 <a href="#" class="printerest"> -->
<!--                                     <i class="icon md-pinterest-1"></i> -->
<!--                                     <p>https://www.facebook.com/</p> -->
<!--                                 </a> -->
<!--                             </li> -->
<!--                         </ul> -->
<!--                         <div class="add-link"> -->
<!--                             <i class="icon md-plus"></i> -->
<!--                             <input type="text" placeholder="paste link here"> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                 </div> -->
            </div>
        </div>
    </section>


    <!-- END / PROFILE -->

            
        </div>
    </section>

    <!-- END / COURSE CONCERN -->


   <!-- FOOTER -->
    <footer id="footer" class="footer">
     <%--   <%@include file="/ffooter.jsp" %> --%>
       <%@include file="/sfooter.jsp" %>
    </footer>
    <!-- END / FOOTER -->



</div>
<!-- END / PAGE WRAP -->

<!-- Load jQuery -->
<!-- Load jQuery -->
  <%@include file="/js.jsp" %>

<script type="text/javascript">



$(document).ready(function(){
	
	
	$("input[type='password']").keyup(function(){
		$("#AppMessage").html("");
	});
	$("#changePasswordBt").click(function(){
		console.log("_@#)#)#(#(##*#*#*#*#&#&#))");
		var newPassword=$("input[type='password'][name='newPassword']").val();
		
		if(newPassword.length==0){
			$("#AppMessage").html("New password cannot be empty..");
			$("input[type='password'][name='newPassword']").focus();
			return;
		}
		
		var confirmPassword=$("input[type='password'][name='confirmPassword']").val();
		if(confirmPassword.length==0){
			$("#AppMessage").html("Confirm password cannot be empty..");
			$("input[type='password'][name='confirmPassword']").focus();
			return;
		}
		if(newPassword!=confirmPassword){
			$("#AppMessage").html("New password and confirm password are not matched..");
			$("input[type='password'][name='newPassword']").focus();
			return;
		}
		
		$("#passwordChangeForm").submit();
	
	});
});	


    $.each($('.table-wrap'), function() {
        $(this)
            .find('.table-item')
            .children('.thead:not(.active)')
            .next('.tbody').hide();
        $(this)
            .find('.table-item')
            .delegate('.thead', 'click', function(evt) {
                evt.preventDefault();
                if ($(this).hasClass('active')==false) {
                    $('.table-item')
                        .find('.thead')
                        .removeClass('active')
                        .siblings('.tbody')
                            .slideUp(200);
                }
                $(this)
                    .toggleClass('active')
                    .siblings('.tbody')
                        .slideToggle(200);
        });
    });

</script>
</body>

</html>