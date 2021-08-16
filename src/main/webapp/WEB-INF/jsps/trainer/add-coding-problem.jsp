<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/trainer-css/trainer.css" type="text/css" media="all">
   <script type="text/javascript"
	src="http://code.jquery.com/jquery.min.js" charset="utf-8"></script>
    	<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/jquery-te-1.4.0.css" />
<script type="text/javascript"	src="${pageContext.request.contextPath}/js/jquery-te-1.4.0.min.js"></script>
    <title>${companyName} - Add Coding Problem</title>

<style type="text/css">


.ptextarea {
    padding: .5%;
    width: 100%;
    background-color: #e7eeef2b;
    color: #454C5F;
    font-weight: 400;
    font-size: 14px;
    line-height: 20px;
    border-left: 5px solid #48e244;
    border-right: 5px solid #f44336;
    box-shadow: 0 0.125rem 0.625rem 0 rgba(0,0,0,0.2);
    float: left;
}
</style>
		
<script type="text/javascript">
$(document).ready(function(){
	
	$("#alertId").hide();
	var appMessage="${ApplicationMessage}";
	console.log(appMessage);
	if(appMessage.length>0){
		$("#customMessage").html(appMessage);
		$("#alertId").show();
	}
	
	$("#problemTitle").keyup(function(){
		$("#customMessage").html("");
		$("#alertId").hide();
	});
	
	$("#problemDescription").keyup(function(){
		$("#customMessage").html("");
		$("#alertId").hide();
	});

	$("#addProblem").click(function(){
		var problemTitle=$("#problemTitle").val();
		if(problemTitle.trim().length==0){
			$("#customMessage").html("Problem Title text cannot be blank.");
			$("#alertId").show();
			$("#problemTitle").focus();
			window.scrollTo(100, 300);
			return;
			
		}
		var problemDescription=$("#problemDescription").val();
		if(problemDescription.trim().length==0){
			$("#customMessage").html("Problem description cannot be blank.");
			$("#alertId").show();
			$("#problemDescription").focus();
			window.scrollTo(100, 300);
			return;
		}
		$("#addCodingProblemForm").submit();
	});
});	

</script>


<!--[if lt IE 9]>
<script type="text/javascript" src="js/html5.js"></script>
<style type="text/css">.bg, .box2{behavior:url("js/PIE.htc");}</style>
<![endif]-->
</head>
<body id="page-top">

<!-- PAGE WRAP -->
<div id="page-wrap">
<div class="body121">																		
  <div class="main">
      <k:if test="${sessionScope.user_session_data.role=='trainer'}">	
      <%@include file="theader.jsp"%>
      </k:if>
        <k:if test="${sessionScope.user_session_data.role=='admin'}">	
       <%@include file="/aheader.jsp"%>
       </k:if>
  </div>
</div>
    <!-- PROFILE FEATURE -->
    <%@include file="profile-feature.jsp" %>
    <!-- END / PROFILE FEATURE -->
    <!-- CONTEN BAR -->
     <%@include file="content-bar.jsp" %>
   <!-- END / CONTENT BAR -->
	 
    <!-- COURSE CONCERN -->
     <form:form id="addCodingProblemForm" action="${pageContext.request.contextPath}/action/codings/add-coding-problem"  method="POST" commandName="codingProblemsVO"> 
    <input type="hidden" name="operation" value="next" id="operation"/>
						<input type="hidden" name="consultantId" value="${param.consultantId}"/>
						<input type="hidden" name="interviewerUserid" value="${sessionScope.user_session_data.loginId}"/>
    <section class="quizz-intro-section" style="padding-top: 0px;padding-bottom:10px;background-color: #eee;min-height: 600px;" id="content">
      <section id="topcontent">
   		</section>

         <div class="container" style="background-color: white;">
            <h3 style="color: black;font-size: 18px;"><img src="${pageContext.request.contextPath}/images/codings/coding-icon.png" style="height:40px;"/> - <b> Add Coding Problem</b></h3>
             <div class="alert alert-warning fade in" id="alertId">
      			  <a href="#" class="close" data-dismiss="alert">&times;</a>
        			<strong>Error!</strong> <span id="customMessage">There was a problem with your <a href="#" class="alert-link">network connection</a>.</span>
   			 </div> 
            <table class="table" style="width: 100%;">
      			 	 <tbody>
      			 	 <tr height="25px" >
					     <td colspan="1" align="left" valign="bottom" >
					           <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Problem Title:</label>
								  <input type="text" id="problemTitle"  name="title"  class="form-control"  style="display:inline;"/>
					     </td>
					   </tr>
					  </tbody>
					 </table>
            	<table class="table table-bordered" style="width: 100%" id="theader">
					      <tr height="25px" style="color: black">
					   	   <td colspan="2">&nbsp;
					   	    <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Problem description:</label>
					   	    <br/>
					   	   <textarea name="description" id="problemDescription" class="jqte-test"
										style="width: 100%;  min-height: 100px !important;" rows="80">
							</textarea> <script>
							$('.jqte-test').val(' ');
								$('.jqte-test').jqte();
								// settings of status
								var jqteStatus = true;
								$(".status").click(function() {
										jqteStatus = jqteStatus ? false : true;
										$('.jqte-test').jqte({
										"status" : jqteStatus
										})
								});
							</script>
					   	   
					   	   </td>
					     </tr>
					   <tr height="25px" style="color: black">
					   	   <td colspan="2">&nbsp;
					   	    Default Code
					   	    <p  class="ptextarea">
<textarea rows="13" cols="8" id="defaultCode" name="defaultCode" class="form-control" style="width: 100%;margin-bottom: 5px;font-size: 16px;border:dotted 1px red;">
class Main {
		public static void main(String args[]) {
  			//write your default code here	
  		}
}	
</textarea>
 							</p>
					   	   
					   	   </td>
					     </tr>
					        <tr height="30px" style="vertical-align: middle;" align="left">
					     <td width="10px" colspan="2">&nbsp;
					     
					       <img src="${pageContext.request.contextPath}/images/icon/score.png" style="height: 40px;"/>&nbsp;
					      <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;color:black;">Tech Name</label>
					      &nbsp;&nbsp;&nbsp;  &nbsp;
					      		 <form:select path="techName" items="${techNameList}" multiple="false"  class="form-control"  style="width: 100px;display: inline;"/>
									 &nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;  
									  <img src="${pageContext.request.contextPath}/images/complexity.png"/>&nbsp;
									   <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;color:black;">Complexity</label>
									        &nbsp;&nbsp;&nbsp;  &nbsp;
									 <form:select path="level" items="${complexity}" multiple="false"  class="form-control"  style="width:150px;display: inline;"/>
									 
									  &nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;  
									  <img src="${pageContext.request.contextPath}/images/codings/time-duration.png" style="height: 30px;"/>&nbsp;
									   <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;color:black;">Time Duration</label>
									        &nbsp;&nbsp;&nbsp;  &nbsp;
									 <form:select path="duration" items="${timeduration}" multiple="false"  class="form-control"  style="width:150px;display: inline;"/>
					
					     </td>
									
					     </tr>
					     
					        <tr height="30px" style="vertical-align: middle;" align="center">
					   	    <td colspan="2">&nbsp;</td>
					     </tr>
					     
					        <tr height="30px" style="vertical-align: middle;" align="left">
					     <td width="10px" colspan="2">&nbsp;
						    <input type="button" value="Clear"
									class="mc-btn btn-style-1"
									id="clear"/>
					      <input type="button" value="Add Problem"
									class="mc-btn btn-style-1"
									id="addProblem"/>
					      </td>
					     </tr>
						</tbody>     
					</table>  

            
        </div>
    </section>
    </form:form>
			  <footer id="footer" class="footer">
     <%--   <%@include file="/ffooter.jsp" %> --%>
       <%@include file="/sfooter.jsp" %>
    </footer>
    <!-- END / FOOTER -->



<!-- END / PAGE WRAP -->

<!-- Load jQuery -->
<!-- Load jQuery -->
  <%@include file="/js.jsp" %>
</body>
</html>