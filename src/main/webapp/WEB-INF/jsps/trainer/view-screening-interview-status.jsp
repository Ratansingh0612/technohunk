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
    <title>${companyName} - View Screening Interview Status</title>
 
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
    <section class="quizz-intro-section" style="padding-top: 0px;padding-bottom:10px;background-color: #eee;min-height: 600px;" id="content">
<!--   <section style="padding-top: 0px;padding-bottom:10px;background-color: white;" id="quizz-intro-section" class="quizz-intro-section learn-section"> -->
        <div class="container">
            <div class="title-ct">
                
                 &nbsp;&nbsp;<h3 style="color: black;font-size: 18px;"><img src="${pageContext.request.contextPath}/images/configure.png" width="25px;"/> - <b> Consultant Screening Interview Status</b></h3> <span style="float: right;">Total Question(s) : <span id="questionNumber" style="font-weight: bold;background-color: yellow;">${totalQuestions}</span></span>	
            </div>
                    <table class="table table-bordered" width="60%" style="background-color: white;">
      			 	 <tbody>
      			 	 <tr height="25px" >
					     <td colspan="1" align="left" valign="bottom" >
					           <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Name&nbsp;&nbsp;: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${consultantsVO.name}</label>
								 &nbsp;&nbsp;
								  <img style="border-radius: 25px;" src="${pageContext.request.contextPath}/action/findConsultantImage?userid=${param.consultantId}" alt=""  width="50" height="50"/>
								 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;     <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Consultant Id&nbsp;&nbsp;: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${param.consultantId}</label>
							 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;     <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Designation&nbsp;&nbsp;: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	${consultantsVO.role}</label>
							 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Batch&nbsp;&nbsp;: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	${consultantsVO.batch}</label>
								 &nbsp;&nbsp;
					     </td>
					       </tr>
					      <tr height="25px" >
					     <td>
					     	<br/>
					      <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Stream&nbsp;&nbsp;: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${consultantsVO.batch}</label>
							 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;     <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Interviewer Name&nbsp;&nbsp;: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	<font style="color:blue;">${interviewRatingStatusVOs.get(0).interviewerName}</font></label>
							 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Duration&nbsp;&nbsp;: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	TODO Minutes</label>
							  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Interview Date&nbsp;&nbsp;: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	${consultantsVO.doj}</label>
								 &nbsp;&nbsp;
					     </td>
					   </tr>
					  </tbody>
					 </table>
            
         <%--    <table class="table table-bordered" width="60%">
      			 	 <tbody>
      			 	 <tr height="25px" >
					     <td colspan="1" align="left" valign="bottom" >
					           <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Technology:</label>
								 &nbsp;&nbsp;
								  <form:select path="technology" items="${technologyList}" multiple="false" class="form-control"  style="width:300px;display:inline;"/>
								 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								   <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Topic:</label>
								 &nbsp;&nbsp;
								 <form:select path="topic" items="${questionComplexityList}" multiple="false"  class="form-control"  style="width:300px;display:inline;"/>
					   			 <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;margin-left: 60px;">Question No   :   </label><span id="questionNumber" style="background-color: yellow;">${totalQuestions}</span>
					     </td>
					   </tr>
					  </tbody>
					 </table> --%>
					 <section style="height: 1px;background-color: #ff9800;margin-bottom: 5px;">
						</section>
                <div class="table-student-submission">
            <span style="font-family: 'Lato', sans-serif;font-size: 16px;">Interview Summary-</span>
                <table class="table table-bordered" id="tab1">
                    <thead>
                        <tr style="background-color: #1192ea;">
                            <th class="submissions" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">SNo</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Technology</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Logo </th>
                            <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Rating(10)</th>
                            <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Comment</th>
                               <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Interviewer Name</th>
                        </tr>
                    </thead>

                    <tbody>
                      <c:forEach items="${interviewRatingStatusVOs}" var="item" varStatus="pk">
					       <tr style="color: black">
					     <td bgcolor="white">&nbsp;${pk.count}.</td>
					   	   <td bgcolor="white">&nbsp;${item.technology}</td>
					   	     <td bgcolor="white">&nbsp;TODO</td>
					   	   <td bgcolor="white">&nbsp;${item.crating}</td>
					   	    <td bgcolor="white">&nbsp;${item.comment}</td>
					   	       <td bgcolor="white">&nbsp;${item.interviewerName}</td>
					     </tr>
					     </c:forEach>
					     <tr style="color: black">
					     <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	    <td bgcolor="white">&nbsp;</td>
					   	   	    <td bgcolor="white">&nbsp;</td>
					   	   	     	    <td bgcolor="white">&nbsp;</td>
					     </tr>
					     
					       <tr style="color: black">
					     <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	    <td bgcolor="white">&nbsp;</td>
					   	   	    <td bgcolor="white">&nbsp;</td>
					   	   	     	    <td bgcolor="white">&nbsp;</td>
					     </tr>
                    </tbody>
                </table>
                </div>
					<span style="background-color: yellow;height: 20px;font-size: 16px;color: black;width: 100%;">
					<img src="${pageContext.request.contextPath}/img/feedback.jpg" style="height: 32px;"/>&nbsp;Detailed Feedback</span>
					 <c:forEach items="${interviewRatingStatusVOs}" var="item" varStatus="pk">
					   <table class="table table-bordered" id="tab1">
                    <thead>
                        <tr style="background-color: #1192ea;">
                            <th class="submissions" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;" colspan="1">Technology Name &nbsp;&nbsp; :  &nbsp;&nbsp;${item.technology} </th>
                        </tr>
                    </thead>

                    <tbody>
                     <c:forEach items="${item.consultantScreeningInterviewHistoryVOs}" var="pitem" varStatus="ppk">
					       <tr style="color: black">
					     <td bgcolor="white">&nbsp;<img src="${pageContext.request.contextPath}/images/question1.png"  style="height: 20px;"/>&nbsp;${ppk.count}.&nbsp;&nbsp;${pitem.questionText}.
					      <br/> <br/>
					     <b>&nbsp;&nbsp;&nbsp;Answer :</b> <font style="color:black;font-size: 15px;">  ${pitem.answer}</font>
					      <br/>
					     	&nbsp;&nbsp;&nbsp;<img src="${pageContext.request.contextPath}/images/rating.png" />&nbsp;&nbsp;Rating  : &nbsp;&nbsp;   <b>${pitem.rating}</b>
					      <br/> <br/>
					     </td>
					       </tr>
					         <tr style="background-color:#eeeeee;height: 10px;">
					   			  <td>&nbsp;
					     </td>
					     </tr>
					     </c:forEach>
					     </tbody>
					    </table> 
					    </c:forEach>
        </div>
    </section>
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