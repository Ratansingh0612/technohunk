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
    <title>${companyName} -  Java Full Stack Developer</title>

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
    <!-- PROFILE FEATURE -->
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
            <h3 style="color: black;background-color:#e2e21b;font-size: 20px;display: inline;margin-right: 300px;font-weight: bold;"> 	
            <img src="${pageContext.request.contextPath}/images/notes/soap/soap_vs_rest.png" style="height: 60px;margin-right: 20px;"/>
             Java Full Stack Developer Course by Nagendra&nbsp;&nbsp;</h3> 
            <br/>
            <div class="table-student-submission" style="background-color: white;">
						<table class="table table-bordered" style="width: 100%" id="theader" >
					      <tr style="color: black">
					   	   <td colspan="2"><h3 style="color: black;font-size: 20px;background-color:#b1ffb1;display: inline;"> 
							1 .&nbsp;&nbsp;This course would be covered in three phases.</h3>
					   	   </td>
					     </tr>
					   <tr height="25px" style="color: black">
					   	   <td colspan="2">&nbsp;
					   	    <label for="sel1" style="font-size: 18px;color:#666;color:black;">
					   	    <img src="${pageContext.request.contextPath}/images/qa.jpg" style="height: 60px;">
							   	<img src="${pageContext.request.contextPath}/images/notes/course/corejava/new.gif" style="height: 80px;">This course would be covered in three phases 
								<br/>
								 <img src="${pageContext.request.contextPath}/images/notes/course/syllabus.png" class="img-thumbnail">
					   	    </label>
					   	    <br/>
					   	   </td>
						</tbody>     
					</table>  
					
					<table class="table table-bordered" style="width: 100%" id="theader" >
					   <tr height="25px" style="color: black">
					   	   <td colspan="2">&nbsp;
					   	   <img src="${pageContext.request.contextPath}/images/notes/course/corejava/front-end.png" class="img-thumbnail">
					   	    <hr/>
					   	   <img src="${pageContext.request.contextPath}/images/notes/course/corejava/web-app.png" class="img-thumbnail">
					   	   <hr/>
					   	    <label for="sel1" style="font-size: 18px;color:#666;color:black;">
					   	    <h3 style="color: black;font-size: 24px;background-color:#b1ffb1;display: inline;font-weight: bold;">1 .</h3><img src="${pageContext.request.contextPath}/images/qa.jpg" style="height: 60px;">
					   	    <br/>
					   	   <h3 style="color: black;font-size: 24px;background-color:#b1ffb1;display: inline;font-weight: bold;"> 
								<img src="${pageContext.request.contextPath}/images/notes/course/corejava/new.gif" style="height: 80px;">Core Java Topics</span></h3>
							  <br/>
					   	     <b style="font-size: 26px;font-weight: bold;">Java Week 1</b>
					   	     <img src="${pageContext.request.contextPath}/images/notes/course/corejava/core-java-part-1.png">
					   	     <img src="${pageContext.request.contextPath}/images/notes/course/corejava/core-java-part-2.png">
					   	      <hr/>
					   	       <img src="${pageContext.request.contextPath}/images/qa.jpg" style="height: 60px;">
					   	      <b style="font-size: 26px;font-weight: bold;">Java Week 2</b>
					   	     <img src="${pageContext.request.contextPath}/images/notes/course/corejava/core-java-part-3.png">
					   	     <img src="${pageContext.request.contextPath}/images/notes/course/corejava/core-java-part-4.png">
					   	        <hr/>
					   	        <img src="${pageContext.request.contextPath}/images/qa.jpg" style="height: 60px;">
					   	      <b style="font-size: 26px;font-weight: bold;">Java Week 3</b>
					   	        <img src="${pageContext.request.contextPath}/images/notes/course/corejava/core-java-part-5.png">
					   	        <img src="${pageContext.request.contextPath}/images/notes/course/corejava/core-java-part-6.png">
					   	        <hr/>
					   	        <img src="${pageContext.request.contextPath}/images/qa.jpg" style="height: 60px;">
					   	      <b style="font-size: 26px;font-weight: bold;">Java Week 4</b>
					   	             <img src="${pageContext.request.contextPath}/images/notes/course/corejava/core-java-part-7.png">
					   	             <img src="${pageContext.request.contextPath}/images/notes/course/corejava/core-java-part-9.png">
					   	             
					   	    </label>
					   	    <br/>
					   	   </td>
						</tbody>     
					</table>  
					
				<table class="table table-bordered" style="width: 100%" id="theader" >
					   <tr height="25px" style="color: black">
					   	   <td colspan="2">&nbsp;
					   	    <label for="sel1" style="font-size: 18px;color:#666;color:black;">
					   	    2 . <img src="${pageContext.request.contextPath}/images/qa.jpg" style="height: 60px;">
					   	   <h3 style="color: black;font-size: 24px;background-color:#b1ffb1;display: inline;font-weight: bold;"> 
					   	   <br/>
							<img src="${pageContext.request.contextPath}/images/notes/course/corejava/new.gif" style="height: 80px;">
							Mastering in HTML-5,&nbsp;CSS-3,&nbsp;Bootstrap, &nbsp;JSP , Servlet & JDBC Programming!</h3>
							<br/>
							<img src="${pageContext.request.contextPath}/images/notes/course/corejava/jsp-servlet-jdbc.png" style="height: 300px;">
							<hr/>
							 <img src="${pageContext.request.contextPath}/images/notes/course/corejava/jsp-servlet-page.png">
							  <br/>
					   	   <b style="font-size: 26px;font-weight: bold;">JSP/Servlet/JavaScript/jQuery/Ajax Week 1</b>
					   	     <img src="${pageContext.request.contextPath}/images/notes/course/corejava/jsp-servlet-part-1.png">
					   	     <img src="${pageContext.request.contextPath}/images/notes/course/corejava/jsp-servlet-part-2.png">
					   	        <hr/>
					   	        <img src="${pageContext.request.contextPath}/images/qa.jpg" style="height: 60px;">
					   	      <b style="font-size: 26px;font-weight: bold;">JSP/Servlet/JavaScript/jQuery/Ajax Week 2</b>
					   	        <img src="${pageContext.request.contextPath}/images/notes/course/corejava/JavaScript_part_1.png">
					   	          <img src="${pageContext.request.contextPath}/images/notes/course/corejava/JavaScript_part_1.png">
					   	        <hr/>
					   	    </label>
					   	    <br/>
					   	   </td>
						</tbody>     
					</table>  
					
							
				<table class="table table-bordered" style="width: 100%" id="theader" >
					   <tr height="25px" style="color: black">
					   	   <td colspan="2">&nbsp;
					   	    <label for="sel1" style="font-size: 18px;color:#666;color:black;">
					   	   <b>3 .</b> <img src="${pageContext.request.contextPath}/images/qa.jpg" style="height: 60px;">
					   	   <h3 style="color: black;font-size: 24px;background-color:#b1ffb1;display: inline;font-weight: bold;"> 
					   	   <br/>
							<img src="${pageContext.request.contextPath}/images/notes/course/corejava/new.gif" style="height: 80px;">
							Spring 5.x + Spring Boot 2.x + Hibernate 5.x + Spring Data JPA</h3>
							<br/>
							<img src="${pageContext.request.contextPath}/images/notes/course/corejava/spring-j2ee.png" style="height: 300px;">
							<hr/>
							  <br/>
					   	   <b style="font-size: 26px;font-weight: bold;">Spring 5.x + Spring Modules</b>
					   	   
					   	   <img src="${pageContext.request.contextPath}/images/notes/course/corejava/spring-modules.png">
					   	     <img src="${pageContext.request.contextPath}/images/notes/course/corejava/spring-part-1.png">
					   	     <img src="${pageContext.request.contextPath}/images/notes/course/corejava/spring-part-2.png">
					   	        <hr/>
					   	        <img src="${pageContext.request.contextPath}/images/qa.jpg" style="height: 60px;">
					   	      <b style="font-size: 26px;font-weight: bold;">Spring 5.x + Spring Modules</b>
					   	        <img src="${pageContext.request.contextPath}/images/notes/course/corejava/spring-hibernate.png">
					   	          <img src="${pageContext.request.contextPath}/images/notes/course/corejava/spring-hibernate-2.png">
					   	        <hr/>
					   	        <img src="${pageContext.request.contextPath}/images/qa.jpg" style="height: 60px;">
					   	      <b style="font-size: 26px;font-weight: bold;">Spring 5.x + Spring Modules</b>
					   	        <img src="${pageContext.request.contextPath}/images/notes/course/corejava/spring-boot-2.0.png">
					   	          <hr/>
					   	             <b style="font-size: 26px;font-weight: bold;">
					   	              <img src="${pageContext.request.contextPath}/images/qa.jpg" style="height: 60px;">
					   	             <img src="${pageContext.request.contextPath}/images/notes/course/corejava/new.gif" style="height: 80px;">Spring Boot 2.x Full Stack Project!!</b>
					   	        <img style="width: 98%;" src="${pageContext.request.contextPath}/images/notes/course/corejava/project-spring-boot-2.0.png">
					   	         <hr/>
					   	          <b style="font-size: 26px;font-weight: bold;">
					   	           <img src="${pageContext.request.contextPath}/images/notes/course/corejava/new.gif" style="height: 80px;">
					   	          <u>Project Building Tools!</u></b>
					   	        <img style="width: auto;" src="${pageContext.request.contextPath}/images/notes/course/corejava/misc-tech.png">
					   	        
					   	        
					   	        <hr/>
					   	         
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