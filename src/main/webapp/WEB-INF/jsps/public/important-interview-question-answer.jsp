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
    <title>${companyName} -  ${stechName} Interview Question Answer</title>

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
          <!-- HEADER -->
      <c:choose>
      <c:when test = "${sessionScope.user_session_data.role=='user'}">
               <%@include file="/uheader.jsp" %>
         </c:when>
         
         <c:when test = "${sessionScope.user_session_data.role=='consultant'}">
               <%@include file="/uheader.jsp" %>
         </c:when>
         
            <c:when test = "${sessionScope.user_session_data.role=='trainer'}">
       							<%@include file="../trainer/theader.jsp" %>
         </c:when>
         
             <c:when test = "${sessionScope.user_session_data.role=='admin'}">
               <%@include file="/aheader.jsp" %>
         </c:when>
         
         <c:otherwise>
              <%@include file="/mhome.jsp" %>
         </c:otherwise>
         </c:choose>
  </div>
</div>
  <br/>
    <!-- PROFILE FEATURE -->
    <%@include file="/profile-feature.jsp" %>
    <!-- END / PROFILE FEATURE -->
    <!-- CONTEN BAR -->
      <section class="content-bar">
        <div class="container">
            <ul>
                <li class="current">
                		
      							 <a href="#">
                        <i class="icon md-book-1"></i>
                        Learning
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/action/oauth">
                        <i class="icon md-shopping"></i>
                        Login
                    </a>
                </li>
            </ul>
        </div>
    </section>
   <!-- END / CONTENT BAR -->
	 
    <!-- COURSE CONCERN -->
    <section class="quizz-intro-section" style="padding-top: 0px;padding-bottom:10px;background-color: #eee;min-height: 600px;background-image: url('${pageContext.request.contextPath}/images/bg/backgrounds.jpg');" id="content">
        <div class="container">
        <hr/>
            <h3 style="color: black;background-color:#e2e21b;font-size: 20px;display: inline;margin-right: 300px;font-weight: bold;"> 	<img src="${pageContext.request.contextPath}/images/questions-bank.png" style="height: 60px;"/> Most Frequently Asked  ${stechName}  Interview Question Answer&nbsp;&nbsp; - (${fn:length(interviewQuestionsAnswerVOs)})</h3> 
            <br/>
            <div class="table-student-submission" style="background-color: white;">
              <c:forEach items="${interviewQuestionsAnswerVOs}" var="pitem" varStatus="oop">
            	<table class="table table-bordered" style="width: 100%" id="theader" >
					      <tr style="color: black">
					   	   <!-- <td colspan="2"><h3 style="color: black;font-size: 20px;background-color:honeydew;display: inline;"> -->
					   	   <td colspan="2">
					   	   <h3 style="color: black;font-size: 20px;background-color:#b1ffb1;display: inline;"> 
							${oop.count} .&nbsp;&nbsp; ${pitem.questionText}</h3>
					   	   </td>
					     </tr>
					   <tr height="25px" style="color: black">
					   	   <td colspan="2">&nbsp;
					   	    <label for="sel1" style="font-size: 18px;color:#052c4a;">
					   	    <img src="${pageContext.request.contextPath}/images/qa.jpg" style="height: 60px;">
								${pitem.answerText}
					   	    </label>
					   	    <br/>
					   	   </td>
						</tbody>     
					</table>  
					</c:forEach>
					
				<%-- 	<table class="table table-bordered" style="width: 100%" id="theader" >
					      <tr style="color: black">
					   	   <!-- <td colspan="2"><h3 style="color: black;font-size: 20px;background-color:honeydew;display: inline;"> -->
					   	   <td colspan="2"><h3 style="color: black;font-size: 20px;background-color:#b1ffb1;display: inline;"> 
					   	   
							1 .&nbsp;&nbsp;What is difference between ServletConfig and ServletContext?</h3>
					   	   </td>
					     </tr>
					   <tr height="25px" style="color: black">
					   	   <td colspan="2">&nbsp;
					   	    <label for="sel1" style="font-size: 18px;color:#666;color:black;">
					   	    <img src="${pageContext.request.contextPath}/images/qa.jpg" style="height: 60px;">
				Some of the differences between <b>ServletConfig</b> and <b>ServletContext</b> are:
						<br/> <br/>
					   	    	  <ul>
					   	   		  <li>ServletConfig is a unique object per servlet whereas ServletContext is a unique object for complete application.</li>
									<li>ServletConfig is used to provide init parameters to the servlet whereas ServletContext is used to provide application level init parameters that all other servlets can use.</li>
										<li>We can't set attributes in ServletConfig object whereas we can set attributes in ServletContext that other servlets can use in their implementation.</li>
							</ul>
						    </label>
						   
					   	    <br/>
					   	   </td>
						</tbody>     
					</table>   --%>
					
					<%-- 	<table class="table table-bordered" style="width: 100%" id="theader" >
					      <tr style="color: black">
					   	   <!-- <td colspan="2"><h3 style="color: black;font-size: 20px;background-color:honeydew;display: inline;"> -->
					   	   <td colspan="2"><h3 style="color: black;font-size: 20px;background-color:#b1ffb1;display: inline;"> 
					   	   
							1 .&nbsp;&nbsp;What is difference between PrintWriter and ServletOutputStream?
					   	   </td>
					     </tr>
					   <tr height="25px" style="color: black">
					   	   <td colspan="2">&nbsp;
					   	    <label for="sel1" style="font-size: 18px;color:#666;color:black;">
					   	    <img src="${pageContext.request.contextPath}/images/qa.jpg" style="height: 60px;">
   						<b>PrintWriter</b> is a character-stream class whereas <b>ServletOutputStream</b> is a byte-stream class.<br/> We can use PrintWriter to write character based information such as character array and String to the response whereas we can use ServletOutputStream to write byte array data to the response.
   						<br/><br/>
   						We can use ServletResponse getWriter() to get the PrintWriter instance whereas we can use ServletResponse getOutputStream() method to get the ServletOutputStream object reference.
					   	    </label>
					   	    <br/>
					   	   </td>
						</tbody>     
					</table>  
					 --%>
			<%-- 		<table class="table table-bordered" style="width: 100%" id="theader" >
					      <tr style="color: black">
					   	   <!-- <td colspan="2"><h3 style="color: black;font-size: 20px;background-color:honeydew;display: inline;"> -->
					   	   <td colspan="2"><h3 style="color: black;font-size: 20px;background-color:#b1ffb1;display: inline;"> 
					   	   
							1 .&nbsp;&nbsp;What is difference between ServletResponse sendRedirect() and RequestDispatcher forward() method?</h3>
					   	   </td>
					     </tr>
					   <tr height="25px" style="color: black">
					   	   <td colspan="2">&nbsp;
					   	    <label for="sel1" style="font-size: 18px;color:#666;color:black;">
					   	    <img src="${pageContext.request.contextPath}/images/qa.jpg" style="height: 60px;">
					   	    	  <ul>
					   	   		  <li><b>RequestDispatcher</b> forward() is used to forward the same request to another resource whereas ServletResponse sendRedirect() is a two step process. In sendRedirect(), web application returns the response to client with status code 302 (redirect) with URL to send the request. The request sent is a completely new request.</li>
					   	   		  <li><b>forward()</b> is handled internally by the container whereas sednRedirect() is handled by browser.</li>
								<li>We should use <b>forward()</b> when accessing resources in the same application because it's faster than sendRedirect() method that required an extra network call.</li>
									<li>In <b>forward()</b> browser is unaware of the actual processing resource and the URL in address bar remains same whereas in sendRedirect() URL in address bar change to the forwarded resource.</li>
										<li><b>forward()</b> can't be used to invoke a servlet in another context, we can only use sendRedirect() in this case.</li>

	</ul>
					   	    </label>
					   	    <br/>
					   	   </td>
						</tbody>     
					</table>   --%>
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