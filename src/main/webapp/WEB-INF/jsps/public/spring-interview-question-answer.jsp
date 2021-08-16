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
    <title>${companyName} -  Spring Interview Question Answer</title>

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
            <h3 style="color: black;background-color:#e2e21b;font-size: 20px;display: inline;margin-right: 300px;font-weight: bold;"> 	<img src="${pageContext.request.contextPath}/images/questions-bank.png" style="height: 60px;"/> Most Frequently Asked  Spring Interview Question Answer&nbsp;&nbsp; - (${fn:length(interviewQuestionsAnswerVOs)})</h3> 
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
					   	   
							1 .&nbsp;&nbsp;What is Comparable and Comparator interface?</h3>
					   	   </td>
					     </tr>
					   <tr height="25px" style="color: black">
					   	   <td colspan="2">&nbsp;
					   	    <label for="sel1" style="font-size: 18px;color:#666;color:black;">
					   	    <img src="${pageContext.request.contextPath}/images/qa.jpg" style="height: 60px;">
							Java provides Comparable interface which should be implemented by any custom class if we want to use Arrays or Collections sorting methods. Comparable interface has compareTo(T obj) method which is used by sorting methods. We should override this method in such a way that it returns a negative integer, zero, or a positive integer if “this” object is less than, equal to, or greater than the object passed as argument.
								<br/><br/>
								But, in most real life scenarios, we want sorting based on different parameters. For example, as a CEO, I would like to sort the employees based on Salary, an HR would like to sort them based on the age. This is the situation where we need to use Comparator interface because Comparable.compareTo(Object o) method implementation can sort based on one field only and we can't chose the field on which we want to sort the Object.
					   	    			<br/><br/>
					   	    			Comparator interface compare(Object o1, Object o2) method need to be implemented that takes two Object argument, it should be implemented in such a way that it returns negative int if first argument is less than the second one and returns zero if they are equal and positive int if first argument is greater than second one.
					   	    </label>
					   	    <br/>
					   	   </td>
						</tbody>     
					</table>  
					
						<table class="table table-bordered" style="width: 100%" id="theader" >
					      <tr style="color: black">
					   	   <!-- <td colspan="2"><h3 style="color: black;font-size: 20px;background-color:honeydew;display: inline;"> -->
					   	   <td colspan="2"><h3 style="color: black;font-size: 20px;background-color:#b1ffb1;display: inline;"> 
					   	   
							1 .&nbsp;&nbsp;What is the importance of hashCode() and equals() methods?</h3>
					   	   </td>
					     </tr>
					   <tr height="25px" style="color: black">
					   	   <td colspan="2">&nbsp;
					   	    <label for="sel1" style="font-size: 18px;color:#666;color:black;">
					   	    <img src="${pageContext.request.contextPath}/images/qa.jpg" style="height: 60px;">
							HashMap uses Key object hashCode() and equals() method to determine the index to put the key-value pair. These methods are also used when we try to get value from HashMap. If these methods are not implemented correctly, two different Key's might produce same hashCode() and equals() output and in that case rather than storing it at different location, HashMap will consider them same and overwrite them.
							<br/><br/>
					Similarly all the collection classes that doesn't store duplicate data use hashCode() and equals() to find duplicates, so it's very important to implement them correctly. The implementation of equals() and hashCode() should follow these rules.
					   	    <br/> <br/>
					   	    	  <ul>
					   	   		  <li>If o1.equals(o2), then o1.hashCode() == o2.hashCode()should always be true.</li>
<li>If o1.hashCode() == o2.hashCode is true, it doesn't mean that o1.equals(o2) will be true.</li>
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
					   	   
							1 .&nbsp;&nbsp; What is different between Iterator and ListIterator?</h3>
					   	   </td>
					     </tr>
					   <tr height="25px" style="color: black">
					   	   <td colspan="2">&nbsp;
					   	    <label for="sel1" style="font-size: 18px;color:#666;color:black;">
					   	    <img src="${pageContext.request.contextPath}/images/qa.jpg" style="height: 60px;">
		Iterator and ListIterator are having following differences
					   	    	  <ul>
					   	   		  <li>We can use Iterator to traverse Set and List collections whereas ListIterator can be used with Lists only.</li>
<li>Iterator can traverse in forward direction only whereas ListIterator can be used to traverse in both the directions.</li>
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