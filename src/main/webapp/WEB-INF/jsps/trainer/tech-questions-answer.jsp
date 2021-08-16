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
    <title>${companyName} -  Interview Question Answer</title>

 <script type="text/javascript">
 
$(document).ready(function() {
	//loadTopics();
	$("#techName").change(function() {
		loadTopics();
	});
});

function loadTopics() {
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
    <input type="hidden" name="operation" value="next" id="operation"/>
						<input type="hidden" name="consultantId" value="${param.consultantId}"/>
						<input type="hidden" name="interviewerUserid" value="${sessionScope.user_session_data.loginId}"/>
    <section class="quizz-intro-section" style="padding-top: 0px;padding-bottom:10px;background-color: #eee;min-height: 600px;" id="content">
<!--   <section style="padding-top: 0px;padding-bottom:10px;background-color: white;" id="quizz-intro-section" class="quizz-intro-section learn-section"> -->
        <div class="container">
              <form:form id="addQuestionAnswerForm" action="${pageContext.request.contextPath}/action/tech-questions-answer"  method="POST" commandName="interviewQuestionsAnswerVO"> 
       
            <div class="title-ct">
                 &nbsp;&nbsp;<h3 style="color: black;font-size: 18px;display: inline;margin-right: 300px;"> 	<img src="${pageContext.request.contextPath}/images/questions-bank.png" style="height: 100px;"/> - <b>Most Frequently Asked Interview Question Answer</b></h3> 
       
       	
            </div>
            <br/>
            <div class="row">
             <div class="col-sm-3" style="background-color:lavender;"> <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;display:inline;">Technology:</label>
								  <form:select path="techName" items="${technologyList}" multiple="false" class="form-control"  style="display:inline;"/>
		</div>
    <div class="col-sm-3" style="background-color:lavenderblush;">   <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;display:inline;">Topic:</label>
								 <form:select path="topic" items="${topicList}" multiple="false"  class="form-control"  style=";display:inline;"/>
								 </div>

    <div class="col-sm-3" style="background-color:lavender;">   <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;display:inline;">Level :</label>
								 <form:select path="complexity" items="${questionComplexityList}" multiple="false"  class="form-control"  style="display:inline;"/>
					 </div>
					  <div class="col-sm-3" style="background-color:lavenderblush;">
					   <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;display:inline;">&nbsp; &nbsp;</label>
					   <br/>
					  <input type="submit" value="Show Questions"
									class="btn btn-danger btn-md"
									id="nextQuestion"  />
					   </div>
  </div>
            
            
				
					    </form:form>
 <hr style="color: blue"/>
    
            <div class="table-student-submission" style="background-color: white;">
            
            <c:if test="${interviewQuestionsAnswerVOs.size() > 0}">
             <c:forEach items="${interviewQuestionsAnswerVOs}" var="item" varStatus="oppo">
            	<table class="table table-bordered" style="width: 100%" id="theader" >
					      <tr style="color: black">
					   	   <td colspan="2">&nbsp;
							<h3 style="color: black;font-family: 'Lato', sans-serif;font-size: 17px;background-color:honeydew;">
							${oppo.count} .&nbsp;&nbsp; ${item.questionText} </h3>
					   	   </td>
					     </tr>
					   <tr height="25px" style="color: black">
					   	   <td colspan="2">&nbsp;
					   	    <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 18px;color:#666;">
					   	    <img src="${pageContext.request.contextPath}/images/qa.jpg" style="height: 60px;">
					   	   		  ${item.answerText} 
					   	    </label>
					   	    <br/>
					   	   </td>
						</tbody>     
					</table>  
					</c:forEach>
					</c:if>
					 <c:if test="${interviewQuestionsAnswerVOs.size() == 0}">
					   <h3>${AppMessage}</h3>
					 </c:if>
            </div>
            </div>
            </section>
        </div>

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