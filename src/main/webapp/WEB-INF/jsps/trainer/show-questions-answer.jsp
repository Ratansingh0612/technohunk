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
    <title>${companyName} - Add Question Answer</title>

 <script type="text/javascript">
 
$(document).ready(function() {
	loadTopics();
	$("#techName").change(function() {
		loadTopics();
	});
});

function loadTopics(){
	 var ccontextPath="${pageContext.request.contextPath}"
	  		var planguage=$("#techName").val();
		   $.getJSON(ccontextPath+"/action/findTopicsByLanguage",{language:planguage},function(jsonResponse) {
			 	$("#topic").empty();
			 	var topicsData=jsonResponse;
			   for(var i=0;i<topicsData.length;i++) {
				 $('#topic')
			      .append($('<option>', { value : topicsData[i].name })
			      .text( topicsData[i].name)); 
			 	}
		   });
}
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
     <form:form id="addQuestionAnswerForm" action="${pageContext.request.contextPath}/action/addQuestionAnswer"  method="POST" commandName="interviewQuestionsAnswerVO"> 
    <input type="hidden" name="operation" value="next" id="operation"/>
						<input type="hidden" name="consultantId" value="${param.consultantId}"/>
						<input type="hidden" name="interviewerUserid" value="${sessionScope.user_session_data.loginId}"/>
    <section class="quizz-intro-section" style="padding-top: 0px;padding-bottom:10px;background-color: #eee;min-height: 600px;" id="content">
<!--   <section style="padding-top: 0px;padding-bottom:10px;background-color: white;" id="quizz-intro-section" class="quizz-intro-section learn-section"> -->
        <div class="container">

            <div class="title-ct">
                
                 &nbsp;&nbsp;<h3 style="color: black;font-size: 18px;"><img src="${pageContext.request.contextPath}/images/configure.png" width="25px;"/> - <b> Interview Question Answer</b></h3> 
            </div>
            
            <table class="table table-bordered" style="width: 100%;">
      			 	 <tbody>
      			 	 <tr height="25px" >
					     <td colspan="1" align="left" valign="bottom" >
					           <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Technology:</label>
								 &nbsp;&nbsp;
								  <form:select path="techName" items="${technologyList}" multiple="false" class="form-control"  style="width:300px;display:inline;"/>
								 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								   <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Topic:</label>
								 &nbsp;&nbsp;
								 <form:select path="topic" items="${questionComplexityList}" multiple="false"  class="form-control"  style="width:300px;display:inline;"/>
					     </td>
					   </tr>
					  </tbody>
					 </table>
 <hr style="color: blue"/>
            <div class="table-student-submission">
            	<table class="table table-bordered" style="width: 100%" id="theader">
					      <tr height="25px" style="color: black">
					   	   <td colspan="2">&nbsp;
					   	    <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Question Text:</label>
					   	    <br/>
					   	   <textarea name="questionText" id="questionText" class="jqte-test"
										style="width: 100%;  min-height: 300px;" rows="120">
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
					   	    <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Answer Text:</label>
					   	    <br/>
					   	   <textarea name="answerText" id="answerText" class="ajqte-test"
										style="width: 100%;  min-height: 300px;" rows="120">
							</textarea> <script>
							$('.ajqte-test').val(' ');
								$('.ajqte-test').jqte();
								// settings of status
								var jqteStatus = true;
								$(".status").click(function() {
										jqteStatus = jqteStatus ? false : true;
										$('.ajqte-test').jqte({
										"status" : jqteStatus
										})
								});
							</script>
					   	   
					   	   </td>
					     </tr>
					        <tr height="30px" style="vertical-align: middle;" align="left">
					     <td width="10px" colspan="2">&nbsp;
					      <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;color:black;">Rating</label>
					      &nbsp;&nbsp;&nbsp;  &nbsp;
					     	<select class="form-control" name="rating" id="rating" style="width: 100px;display: inline;">
											<option value="NA">NA</option>
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
											<option value="6">6</option>
											<option value="7">7</option>
											<option value="8">8</option>
											<option value="9">9</option>
											<option value="10">10</option>
									</select>
									 &nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;  
									  <img src="${pageContext.request.contextPath}/images/complexity.png"/>&nbsp;
									   <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;color:black;">Complexity</label>
									        &nbsp;&nbsp;&nbsp;  &nbsp;
									 <form:select path="complexity" items="${questionComplexityList}" multiple="false"  class="form-control"  style="width:150px;display: inline;"/>
					
					     </td>
									
					     </tr>
					     
					        <tr height="30px" style="vertical-align: middle;" align="center">
					   	    <td colspan="2">&nbsp;</td>
					     </tr>
					     
					        <tr height="30px" style="vertical-align: middle;" align="center">
					     <td width="10px" colspan="2">&nbsp;
					      <input type="submit" value="Finish"
									class="btn btn-primary btn-md"
									id="finishInterview"  style="margin-right: 830px;"/>
									&nbsp;
					      <input type="submit" value="Next Question"
									class="btn btn-primary btn-md"
									id="nextQuestion" />
					      </td>
					     </tr>
						</tbody>     
					</table>  
            </div>

            
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