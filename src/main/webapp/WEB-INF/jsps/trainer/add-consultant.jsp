<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from envato.megadrupal.com/html/megacourse/account-assignment.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 19 Mar 2017 04:41:35 GMT -->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon-96x96.png" />
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <title>${companyName} - Add Consultant</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/datepicker.css" type="text/css" media="all">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-datepicker.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">

     <style>
<!--
input[type="checkbox"] { -webkit-appearance: checkbox; }
input[type="radio"] { -webkit-appearance: radio; }
input[type="submit"], input[type="button"] { -webkit-appearance: button; }
select { -webkit-appearance:textfield; }
-->
</style>
 <script type="text/javascript">
 $(document).ready(function() {
	 $("input[type='text']").keyup(function(){
		 $("#errorMessage").html("");
	 });
	 
	 $("#doj").datepicker();
	 $("#doj").val("02/05/2019");
		//alert("good morning!");
  	 $("input[type='button'][id='userRegistrationBt']").click(function() {
  		    //validating the test name
  		    
  		    
  		    var empid=$("input[type='text'][name='empid']").val();
  			if(empid.length==0){
  					$("#errorMessage").html("Empid  cannot be blank.......");
  					$("input[type='text'][name='empid']").focus();
  					return;
  			}else{
  				var ccontextPath="${pageContext.request.contextPath}";
  				$.getJSON(ccontextPath+"/action/check-consultantid", {consultantId:empid}, function(jsonResponse) {
  					if(jsonResponse.status=="yes"){
  						$("#errorMessage").html("Sorry this  empid is already in use.......");
  	  					$("input[type='text'][name='empid']").focus();	
  	  					return;
  					}
  				});
  			}
  		    
  			var fname=$("input[type='text'][name='name']").val();
  			if(fname.length==0){
  					$("#errorMessage").html("First Name cannot be blank.......");
  					$("input[type='text'][name='name']").focus();
  					return;
  			}
  			
  			
  			var email=$("input[type='text'][name='email']").val();
  			if(email.length==0){
  					$("#errorMessage").html("Email cannot be blank.......");
  					$("input[type='text'][name='email']").focus();
  					return;
  			}
  			
  			var mobile=$("input[type='text'][name='mobile']").val();
  			if(mobile.length==0){
  					$("#errorMessage").html("Mobile cannot be blank.......");
  					$("input[type='text'][name='mobile']").focus();
  					return;
  			}
  			
  		
  			var stream=$("input[type='text'][name='stream']").val();
  			if(stream.length==0){
  				$("#errorMessage").html("Steam cannot be blank.......");
  					$("input[type='text'][name='stream']").focus();
  					return;
  			}
  			
  			var org=$("input[type='text'][name='org']").val();
  			if(org.length==0){
  				$("#errorMessage").html("Organization name cannot be blank.......");
  					$("input[type='text'][name='org']").focus();
  					return;
  			}
  			
  			
  			$("#userRegistrationForm").submit();		
	 });
  	 
});
</script>	
</head>
<body id="page2"  onkeydown="return (event.keyCode != 116)">
<!-- PAGE WRAP -->
<div id="page-wrap">
   <div class="body121">
  <div class="main">
      <c:if test="${sessionScope.user_session_data.role=='trainer'}">	
      <%@include file="theader.jsp"%>
      </c:if>
        <c:if test="${sessionScope.user_session_data.role=='admin'}">	
       <%@include file="/aheader.jsp"%>
       </c:if>
  </div>
</div>
    <!-- PROFILE FEATURE -->
    <%@include file="profile-feature.jsp" %>
    <!-- END / PROFILE FEATURE -->


    <!-- CONTEN BAR -->
     <%@include file="content-bar.jsp" %>
   <!-- END / CONTENT BAR -->
 
    <!-- COURSE CONCERN -->
  
  <div class="main">
    <!-- content -->
    
    <section id="content">
      <div class="box1" >
        <div class="wrapper" style="">
              <div class="container" >
							<form:form id="userRegistrationForm" method="POST"
								commandName="consultant" enctype="multipart/form-data"
								action="${pageContext.request.contextPath}/action/add-consultant-admin"
								class="form-horizontal" >
								<img src="${pageContext.request.contextPath}/images/icon/file-icon.png" width="50px;"/> - <span style="font-size: 16px;font-weight: bold;">Consultant Sign Up Page</span>
								<br/>
								<span style="color: #ea210c;margin-left: 135px;font-size:16px;font-weight: bold;" id="errorMessage">${ApplicationMessage}</span>
								<br/><br/>
								<div class="form-group">
									<label class="col-sm-2 control-label" style="font-family: 'Lato', sans-serif;font-size: 15px;">Consultant Id * </label>
									<div class="col-sm-5">
										<form:input path="empid" class="form-control"
											id="empid" style="background-color:rgba(255, 235, 59, 0.06);"/>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label" style="font-family: 'Lato', sans-serif;font-size: 15px;">Name * </label>
									<div class="col-sm-5">
										<form:input path="name" class="form-control"
											id="name" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" style="font-family: 'Lato', sans-serif;font-size: 15px;">Email *</label>
									<div class="col-sm-7">
										<form:input path="email" class="form-control " id="email" />
									</div>
								</div>
								<div  class="form-inline" style="margin-left:-10px;width:100%;">
								
									<label class="col-sm-2 control-label" style="font-family: 'Lato', sans-serif;font-size: 15px;">DOJ </label>
									<div class="col-sm-5">
										<form:input path="doj" class="form-control"/>
									</div>
								<div class="form-group" style="margin-left:-260px;">
									<label class="col-sm-3 control-label" style="font-family: 'Lato', sans-serif;font-size: 15px;">Mobile*</label>
									<div class="col-sm-5">
										<form:input path="mobile" class="form-control" id="mobile" width="250px" value="9899001122"/>
									</div>
								</div>
								</div><br/>
								<div class="form-group">
									<label class="col-sm-2 control-label" style="font-family: 'Lato', sans-serif;font-size: 15px;">Gender </label>&nbsp;&nbsp;
									<label class="radio-inline ">
      									<form:radiobutton path="gender" value="Male"/>Male
   									</label>
   									<label class="radio-inline">
     									<form:radiobutton path="gender" value="Female"/>Female
  									</label>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" style="font-family: 'Lato', sans-serif;font-size: 15px;">Batch </label>
									<div class="col-sm-3">
									<form:select class="form-control" path="batch">
									    <form:options items="${batchList}"/>
									 </form:select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" style="font-family: 'Lato', sans-serif;font-size: 15px;">Stream *</label>
									<div class="col-sm-3">
										<form:input path="stream" class="form-control"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" style="font-family: 'Lato', sans-serif;font-size: 15px;">Org. *</label>
									<div class="col-sm-5">
										<form:input path="org" class="form-control" value="SOT"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" style="font-family: 'Lato', sans-serif;font-size: 15px;"	>Photo </label>
									<div class="col-sm-5">
										<input type="file" name="image" class="form-control"
											id="image">
									</div>
								</div>
								
								<div style="margin-left: 195px;">
									<input type="button" value="Sign Up" class="btn btn-primary"
										id="userRegistrationBt" style="font-family: 'Lato', sans-serif;font-size: 15px;"/>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset"
										value="Clear" class="btn btn-default" style="font-family: 'Lato', sans-serif;font-size: 15px;"/>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="${pageContext.request.contextPath}/action/show-all-consultants">
										<input type="button"
										value="Back" class="btn btn-danger" style="font-family: 'Lato', sans-serif;font-size: 15px;"/>
										</a>
										
								</div>
								
							</form:form>
						</div>
			</div>	
				    <hr/>
        </div>
    
        </section>
            
      </div>

    <!-- content -->
    	<!--    <hr style="color: blue"/> -->
    <!-- / footer -->
</div>
 <!-- FOOTER -->
    <footer id="footer" class="footer">

       <%@include file="/sfooter.jsp" %>
    </footer>
    <!-- END / FOOTER -->
</body>

</html>