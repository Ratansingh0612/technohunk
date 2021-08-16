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
     <%@include file="uheader.jsp" %>
     </k:if>
       <k:if test="${sessionScope.user_session_data.role=='consultant'}">	
     <%@include file="uheader.jsp" %>
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
    
    <section class="profile" style="padding-top: 0px;padding-bottom: 30px;">
        <div class="container">
            <h3 class="md black">Profile</h3>
            <div class="row">
                <div class="col-md-9">
                  <form id="consultantForm" action="${pageContext.request.contextPath}/action/profilePost" method="post" enctype="multipart/form-data">
                    <div class="avatar-acount">
                        <div class="changes-avatar">
         
                            <div class="img-acount">
                                <img id="bimage" src="${pageContext.request.contextPath}/action/imageByUserId?userid=${sessionScope.user_session_data.loginId}" class="img-thumbnail"/>
                            </div>
                             <div class="choses-file up-file">
                                <input type="file" name="photo" id="fimage">
                                <input type="hidden">
                                <a href="#" class="mc-btn btn-style-6">Changes image</a>
                            </div>
                           
                        </div>   
                        <div class="info-acount">
                            <h3 class="md black">${sessionScope.user_session_data.name}  <input readonly="readonly" type="text" class="form-control" name="userid" value="${user.loginid}"/>
                                  </h3>
                            <p>This is the page where trainer can edit his or her personal informations. </p>
                            <div class="security">
                                <div class="tittle-security">
                                   <span id="AppMessage" style="color:blue;font-weight: bold;"></span>	
                                   <input  type="hidden" class="form-control" name="loginid" value="${user.loginid}"/>
                                    
                                  <h5>Name *</h5>
                                     <input type="text" class="form-control" name="name" value="${user.firstName} ${user.lastName}" readonly="readonly"/>
                                    <h5>Email *</h5>
                                    <input type="text"  class="form-control" name="email" value="${user.email}">
                                      <h5>Mobile *</h5>
                                    <input type="text" class="form-control" name="mobile" value="${user.mobile}">
                                     <h5>Gender</h5>
                                     <select class="form-control" name="gender">
                                     	<option ${user.gender=='MALE'?'selected':''} value="MALE">Male</option>
	                                     <option ${user.gender=='FEMALE'?'selected':''} value="FEMALE">Female</option>
                                     </select>
                                     
                                      <h5>Department   -   ${user.stream}</h5>
                                     <select class="form-control" name="stream">
                                     	<option ${user.stream=='ME'?'selected':''}>ME</option>
                                     	<option ${user.stream=='CS'?'selected':''}>CS</option>
                                     		<option ${user.stream=='EC'?'selected':''}>EC</option>
                                     			<option ${user.stream=='EE'?'selected':''}>EE</option>
                                     				<option ${user.stream=='CE'?'selected':''}>CE</option>
                                     					<option ${user.stream=='ME'?'selected':''}>ME</option>
                                     					<option ${user.stream=='MCA'?'selected':''}>MCA</option>
                                     						<option ${user.stream=='MBA'?'selected':''}>MBA</option>
                                     							<option ${user.stream=='BCA'?'selected':''}>BCA</option>
                                     </select>
                                </div>
                            </div>
                        </div>
                     	<span style="float: right;">
                        <button type="button" class="btn btn-primary" id="editConsultantProfile">Edit</button>
                    	</span>
                    	<br/>	
                    	<hr/>
                    </div>    
                    </form>
                </div>
                <div class="col-md-3">
                    <div class="social-connect">
                        <h5>Social connect</h5>
                        <ul>
                            <li>
                                <a href="#" class="twitter">
                                    <i class="icon md-twitter"></i>
                                    <p>https://www.facebook.com/</p>
                                </a>
                            </li>
                            <li>
                                <a href="#" class="facebook">
                                    <i class="icon md-facebook-1"></i>
                                    <p>https://www.facebook.com/</p>
                                </a>
                            </li>
                            <li>
                                <a href="#" class="gg-plus">
                                    <i class="icon md-google-plus"></i>
                                    <p>https://www.facebook.com/</p>
                                </a>
                            </li>
                            <li>
                                <a href="#" class="printerest">
                                    <i class="icon md-pinterest-1"></i>
                                    <p>https://www.facebook.com/</p>
                                </a>
                            </li>
                        </ul>
                        <div class="add-link">
                            <i class="icon md-plus"></i>
                            <input type="text" placeholder="paste link here">
                        </div>
                    </div>
                </div>
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

function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $('#bimage').attr('src', e.target.result);
        }
        reader.readAsDataURL(input.files[0]);
    }
}
	
	$(document).ready(function(){
		
		$("#fimage").change(function(){
		    readURL(this);
		});
		
		$("input[type='text']").keyup(function(){
			$("#AppMessage").html("");
		});
		$("#editConsultantProfile").click(function(){
			console.log("_@#)#)#(#(##*#*#*#*#&#&#))");
			var name=$("input[type='text'][name='name']").val();
			
			if(name.length==0){
				$("#AppMessage").html("Name cannot be empty..");
				$("input[type='text'][name='name']").focus();
				return;
			}
			
			var email=$("input[type='text'][name='email']").val();
			if(email.length==0){
				$("#AppMessage").html("Email cannot be empty..");
				$("input[type='text'][name='email']").focus();
				return;
			}
			
			
			var mobile=$("input[type='text'][name='mobile']").val();
			if(mobile.length==0){
				$("#AppMessage").html("Mobile cannot be empty..");
				$("input[type='text'][name='mobile']").focus();
				return;
			}
			
			$("#consultantForm").submit();
		
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