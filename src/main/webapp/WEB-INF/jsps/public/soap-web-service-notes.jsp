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
    <title>${companyName} -  Core Java Interview Question Answer</title>

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
            <h3 style="color: black;background-color:#e2e21b;font-size: 20px;display: inline;margin-right: 300px;font-weight: bold;"> 	<img src="${pageContext.request.contextPath}/images/notes/soap/soap_vs_rest.png" style="height: 60px;margin-right: 20px;"/> Soap web service notes by Nagendra&nbsp;&nbsp;</h3> 
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
					
						<table class="table table-bordered" style="width: 100%" id="theader" >
					      <tr style="color: black">
					   	   <!-- <td colspan="2"><h3 style="color: black;font-size: 20px;background-color:honeydew;display: inline;"> -->
					   	   <td colspan="2"><h3 style="color: black;font-size: 20px;background-color:#b1ffb1;display: inline;"> 
					   	   
							1 .&nbsp;&nbsp;What is web service?</h3>
					   	   </td>
					     </tr>
					   <tr height="25px" style="color: black">
					   	   <td colspan="2">&nbsp;
					   	    <label for="sel1" style="font-size: 18px;color:#666;color:black;">
					   	    <img src="${pageContext.request.contextPath}/images/qa.jpg" style="height: 60px;">
							   Web service is technology which allows data exchange between two different applications developed on different platform and technology. 
								<br/>
								 <img src="${pageContext.request.contextPath}/images/notes/soap/what-is-webservice.png">
					   	    </label>
					   	    <br/>
					   	   </td>
						</tbody>     
					</table>  
					
					<table class="table table-bordered" style="width: 100%" id="theader" >
					      <tr style="color: black">
					   	   <!-- <td colspan="2"><h3 style="color: black;font-size: 20px;background-color:honeydew;display: inline;"> -->
					   	   <td colspan="2"><h3 style="color: black;font-size: 20px;background-color:#b1ffb1;display: inline;"> 
					   	   
							2 .&nbsp;&nbsp;What is difference between Soap and Rest web service?</h3>
					   	   </td>
					     </tr>
					   <tr height="25px" style="color: black">
					   	   <td colspan="2">&nbsp;
					   	    <label for="sel1" style="font-size: 18px;color:#666;color:black;">
					   	    <img src="${pageContext.request.contextPath}/images/qa.jpg" style="height: 60px;">
							   Followings are main differences between soap and rest web service
								<br/>
								 <img src="${pageContext.request.contextPath}/images/notes/soap/soap-rest-difference.png">
					   	    </label>
					   	    <br/>
					   	   </td>
						</tbody>     
					</table>  
					
						<table class="table table-bordered" style="width: 100%" id="theader" >
					      <tr style="color: black">
					   	   <!-- <td colspan="2"><h3 style="color: black;font-size: 20px;background-color:honeydew;display: inline;"> -->
					   	   <td colspan="2"><h3 style="color: black;font-size: 20px;background-color:#b1ffb1;display: inline;"> 
					   	   
							3 .&nbsp;&nbsp;What is web service container?</h3>
					   	   </td>
					     </tr>
					   <tr height="25px" style="color: black">
					   	   <td colspan="2">&nbsp;
					   	    <label for="sel1" style="font-size: 18px;color:#666;color:black;">
					   	    <img src="${pageContext.request.contextPath}/images/qa.jpg" style="height: 60px;">
							 Below is diagram for web service container.
								<br/>
								 <img src="${pageContext.request.contextPath}/images/notes/soap/web-service-container.png">
					   	    </label>
					   	    <br/>
					   	   </td>
						</tbody>     
					</table>  
					
					
					
					
						<table class="table table-bordered" style="width: 100%" id="theader" >
					      <tr style="color: black">
					   	   <!-- <td colspan="2"><h3 style="color: black;font-size: 20px;background-color:honeydew;display: inline;"> -->
					   	   <td colspan="2"><h3 style="color: black;font-size: 20px;background-color:#b1ffb1;display: inline;"> 
					   	   
							1 .&nbsp;&nbsp;How to develop soap web service in bottom up approach using Metro </h3>
					   	   </td>
					     </tr>
					   <tr height="25px" style="color: black">
					   	   <td colspan="2">&nbsp;
					   	    <label for="sel1" style="font-size: 18px;color:#666;color:black;">
					   	    <img src="${pageContext.request.contextPath}/images/qa.jpg" style="height: 60px;">
							1. Creating dynamic web project with maven support
							<br/><br/>
					
					   	    <br/> <br/>
					   	    	  <ul>
					   	   		  <li>1. Creating dynamic web project with maven support</li>
					   	   		  <li>
					   	   		  2. Add below dependency inside pom.xml
					   	   		  <br/>
					   	   		  	<dependency>
			<groupId>com.sun.xml.ws</groupId>
			<artifactId>jaxws-rt</artifactId> 
			<version>2.2.8</version>
		</dependency>
		
		 <!-- jax-ws runtime from glassfish Metro - project tango -->
    <dependency>
        <groupId>org.glassfish.metro</groupId>
        <artifactId>webservices-rt</artifactId>
        <version>2.3</version>
    </dependency>
					   	   		  
					   	   		  </li>
					   	   		   <li>3. Develop web service endpoint
					   	   		  	//JAX-WS
@WebService
public class PassportSoapEndpoint {
	public List<Passport> findPassports() {
	}
}	</li>
   <li>Create web service deployment descriptor file : 
         /WEB-INF/sun-jaxws.xml file  
   </li>
   
   <li>Register your  web service inside the below file : 
         <?xml version="1.0" encoding="UTF-8"?>
<endpoints
  xmlns="http://java.sun.com/xml/ns/jax-ws/ri/runtime"
  version="2.0">
  <!-- Here we are registering web service 
  and our web service can be accessed by below url-pattern
   -->
      <endpoint
      name="passportSoapEndpoint"
      implementation="com.soap.web.model.PassportSoapEndpoint"
      url-pattern="/passportSoapEndpoint"/>
</endpoints>  
         <br/><br/>
   </li>
   
   <li>Define a servlet inside web.xml which will be responsible for forwarding incoming requests to web service container 
         <br/>
           <servlet>
        <servlet-name>metro</servlet-name>
        <servlet-class>
                com.sun.xml.ws.transport.http.servlet.WSServlet
        </servlet-class>
        <load-on-startup>1</load-on-startup>
    </servlet>
    
    <servlet-mapping>
        <servlet-name>metro</servlet-name>
        <url-pattern>/passportSoapEndpoint</url-pattern>
          </servlet-mapping>
  
   </li>

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
					   	   
							4 .&nbsp;&nbsp; What is WSDL?</h3>
					   	   </td>
					     </tr>
					   <tr height="25px" style="color: black">
					   	   <td colspan="2">&nbsp;
					   	    <label for="sel1" style="font-size: 18px;color:#666;color:black;">
					   	    <img src="${pageContext.request.contextPath}/images/qa.jpg" style="height: 60px;">
					   	    	<br/>
								 <img src="${pageContext.request.contextPath}/images/notes/soap/what-is-wsdl.png">
					   	    </label>
					   	    <br/>
					   	   </td>
						</tbody>     
					</table>  
					
						<table class="table table-bordered" style="width: 100%" id="theader" >
					      <tr style="color: black">
					   	   <!-- <td colspan="2"><h3 style="color: black;font-size: 20px;background-color:honeydew;display: inline;"> -->
					   	   <td colspan="2"><h3 style="color: black;font-size: 20px;background-color:#b1ffb1;display: inline;"> 
					   	   
							5 .&nbsp;&nbsp; Explain different elements of the WSDL?</h3>
					   	   </td>
					     </tr>
					   <tr height="25px" style="color: black">
					   	   <td colspan="2">&nbsp;
					   	    <label for="sel1" style="font-size: 18px;color:#666;color:black;">
					   	    <img src="${pageContext.request.contextPath}/images/qa.jpg" style="height: 60px;">
					   	     Different elements of WSDL are : -
					   	      <br/> 
					   	    	  <ul>
					   	   		  <li>1. <img src="${pageContext.request.contextPath}/images/notes/soap/types.png">
					   	   		  </li>
	  <li>1. <img src="${pageContext.request.contextPath}/images/notes/soap/types.png">
					   	   		  </li>
<li>ListIterator inherits from Iterator interface and comes with extra functionalities like adding an element, replacing an element, getting index position for previous and next elements.</li>
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