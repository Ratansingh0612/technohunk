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
    <section class="quizz-intro-section" style="padding-top: 0px;padding-bottom:10px;background-color: #eee;min-height: 600px;background-image: url('${pageContext.request.contextPath}/images/bg/backgrounds.jpg');" id="content">
        <div class="container">
        <hr/>
            <h3 style="color: black;background-color:#e2e21b;font-size: 20px;display: inline;margin-right: 300px;font-weight: bold;"> 	<img src="${pageContext.request.contextPath}/images/questions-bank.png" style="height: 60px;"/> Most Frequently Asked  Core Java Interview Question Answer</h3> 
            <br/>
            <div class="table-student-submission" style="background-color: white;">
            	<table class="table table-bordered" style="width: 100%" id="theader" >
					      <tr style="color: black">
					   	   <!-- <td colspan="2"><h3 style="color: black;font-size: 20px;background-color:honeydew;display: inline;"> -->
					   	   <td colspan="2">
					   	   <h3 style="color: black;font-size: 20px;background-color:#b1ffb1;display: inline;"> 
							1 .&nbsp;&nbsp; What are the important features of Java 9 release?</h3>
					   	   </td>
					     </tr>
					   <tr height="25px" style="color: black">
					   	   <td colspan="2">&nbsp;
					   	    <label for="sel1" style="font-size: 18px;color:#052c4a;">
					   	    <img src="${pageContext.request.contextPath}/images/qa.jpg" style="height: 60px;">
					   	    Java 9 was a major release and brought a lot of features. Some of the important features are:
					   	    	  <ul>
					   	   		  <li>Java 9 REPL (JShell)</li>
<li>Java 9 Module System</li>
<li>Factory Methods for Immutable List, Set, Map and Map.Entry</li>
<li>Private methods in Interfaces</li>
<li>Reactive Streams</li>
<li>GC (Garbage Collector) Improvements</li>
</ul>
					   	    </label>
					   	    <br/>
					   	   </td>
						</tbody>     
					</table>  
					     	<table class="table table-bordered" style="width: 100%" id="theader" >
					      <tr style="color: black">
					   	   <!-- <td colspan="2"><h3 style="color: black;font-size: 20px;background-color:honeydew;display: inline;"> -->
					   	   <td colspan="2"><h3 style="color: black;font-size: 20px;background-color:#b1ffb1;display: inline;"> 
					   	   
							1 .&nbsp;&nbsp; What are the important features of Java 9 release?</h3>
					   	   </td>
					     </tr>
					   <tr height="25px" style="color: black">
					   	   <td colspan="2">&nbsp;
					   	    <label for="sel1" style="font-size: 18px;color:#666;color:black;">
					   	    <img src="${pageContext.request.contextPath}/images/qa.jpg" style="height: 60px;">
					   	    Java 9 was a major release and brought a lot of features. Some of the important features are:
					   	    	  <ul>
					   	   		  <li>Java 9 REPL (JShell)</li>
<li>Java 9 Module System</li>
<li>Factory Methods for Immutable List, Set, Map and Map.Entry</li>
<li>Private methods in Interfaces</li>
<li>Reactive Streams</li>
<li>GC (Garbage Collector) Improvements</li>
</ul>
					   	    </label>
					   	    <br/>
					   	   </td>
						</tbody>     
					</table>  
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