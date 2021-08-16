<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <title>${companyName} - Guest Test History</title>
</head>
<body>

<!-- PAGE WRAP -->
<div id="page-wrap">

      <!-- HEADER -->
      <c:choose>
      <c:when test = "${sessionScope.user_session_data.role=='user'}">
               <%@include file="uheader.jsp" %>
         </c:when>
         
         <c:when test = "${sessionScope.user_session_data.role=='consultant'}">
               <%@include file="uheader.jsp" %>
         </c:when>
         
            <c:when test = "${sessionScope.user_session_data.role=='trainer'}">
       							<%@include file="../trainer/theader.jsp" %>
         </c:when>
         
             <c:when test = "${sessionScope.user_session_data.role=='admin'}">
               <%@include file="/aheader.jsp" %>
         </c:when>
         
         <c:otherwise>
           <%@include file="oguestheader.jsp" %>
         </c:otherwise>
         </c:choose>
    <!-- END / HEADER -->
   <%--   <%@include file="oguestheader.jsp" %> --%>
 
    <%@include file="og-profile-feature.jsp" %>
    
    <!-- END / PROFILE FEATURE -->
    <!-- END / PROFILE FEATURE -->
 <!-- COURSE CONCERN --> 
  <section class="quizz-intro-section" style="padding-top: 0px;padding-bottom:10px;background-color: #f9f9f9;min-height: 570px;" id="content">
  
       <div class="container">
		
            <div  style="font-size: 16px;">
                 <br/>
                <img src="${pageContext.request.contextPath}/images/question1.png"/>  &nbsp;&nbsp;- &nbsp;&nbsp;<b>Online Technical Test Score Summary.</b>
                 <hr/>
            </div>
              <img src="${pageContext.request.contextPath}/action/tdchart?userid=${guestUserDetail.userid}&userSessionId=${userOnlineExamStatusForm.userSessionId}" style="display: inline;">   <img src="${pageContext.request.contextPath}/images/icon/test-summary-header-image.png" style="display: inline;width: 400px;">
  		
        <hr style="height: 4px;background-color: #bdbdd9"/>  
 		   <div style="background-color: #e0d4d4;height: 28px;font-size: 18px;">Personal Details</div>
  			 <table class="table table-bordered" style="font-size: 16px;">
        <tbody>
          <tr>
                <td style="width: 35%">Name : ${guestUserDetail.name}</td>
                <td style="width: 35%"><img src="${pageContext.request.contextPath}/images/icon/email.png" style="height: 25px;">&nbsp;Email  : ${guestUserDetail.email}</td>
                <td><img src="${pageContext.request.contextPath}/images/icon/mobile.png"  style="height: 25px;"/>&nbsp;Exam Status : ${userOnlineExamStatusForm.examStatus}</td>
            </tr>
            </tbody>
         </table>   

            <div style="background-color: #e0d4d4;height: 28px;font-size: 18px;">Test Summary</div>
       <table class="table table-bordered" style="font-size: 15px;">
               <tbody>
           <tr>
                <td  style="width: 35%">Technology : <b>${userOnlineExamStatusForm.techName}</b></td>
                <td style="width: 35%">&nbsp;Test Name  : <b>${userOnlineExamStatusForm.testName}</b></td>
                <td><img src="${pageContext.request.contextPath}/images/icon/score.png"  style="height: 30px;"/>&nbsp;Score% :  
                <b>  <fmt:formatNumber
													type="number" minFractionDigits="2" maxFractionDigits="2"
													value="${(userOnlineExamStatusForm.secureMarks/userOnlineExamStatusForm.totalNoQuestion)*100}"/></b>
              
                </td>
                </tr>
        </tbody>
         </table> 
         
          <table class="table table-bordered" style="font-size: 15px;">         
             <tr>
                <td style="width: 35%"><img src="${pageContext.request.contextPath}/images/icon/c.png">Correct Questions : <b>${userOnlineExamStatusForm.totalCorrectAnswer}</b></td>
                    <td style="width: 35%"><img src="${pageContext.request.contextPath}/images/icon/w.png"/>Wrong Questions  : <b>${userOnlineExamStatusForm.totalWrongAnswer}</b></td>
                <td><img src="${pageContext.request.contextPath}/images/icon/t.png"/>&nbsp;Total Questions : ${userOnlineExamStatusForm.totalNoQuestion}</td>
            </tr>
        </tbody>
    </table>
    
     <table class="table table-bordered" style="font-size: 15px;">         
             <tr>
                <td style="width: 35%">&nbsp;Date of Test : <b>${userOnlineExamStatusForm.dateOfTest}</b></td>
                    <td style="width: 35%">&nbsp;Test Duration  : <b>NA Mins</b></td>
                     <td>&nbsp;Not Attempted Question(s) : <b>${userOnlineExamStatusForm.totalNoQuestion-userOnlineExamStatusForm.totalCorrectAnswer-userOnlineExamStatusForm.totalWrongAnswer}</b> </td>
            </tr>
        </tbody>
    </table>
      <a href="${pageContext.request.contextPath}/action/guest-tech-test-details?testName=${userOnlineExamStatusForm.testName}&techName=${userOnlineExamStatusForm.techName}&userSessionId=${userOnlineExamStatusForm.userSessionId}&email=${guestUserDetail.email}" style="font-size: 16px;margin-right: 60px;"><img src="${pageContext.request.contextPath}/images/icon/test-details.png" style="height: 60px;">Click for test details</a>
      
            <!-- HEADER -->
      <c:choose>
         
            <c:when test = "${sessionScope.user_session_data.role=='trainer'}">
      <a href="${pageContext.request.contextPath}/action/guest-tech-test-details?testName=${userOnlineExamStatusForm.testName}&techName=${userOnlineExamStatusForm.techName}&userSessionId=${userOnlineExamStatusForm.userSessionId}&email=${guestUserDetail.email}&ctest=complete" style="font-size: 16px;"><img src="${pageContext.request.contextPath}/images/icon/test-details.png" style="height: 60px;">Click for complete test details</a>
         </c:when>
             <c:when test = "${sessionScope.user_session_data.role=='admin'}">
               <a href="${pageContext.request.contextPath}/action/guest-tech-test-details?testName=${userOnlineExamStatusForm.testName}&techName=${userOnlineExamStatusForm.techName}&userSessionId=${userOnlineExamStatusForm.userSessionId}&email=${guestUserDetail.email}&ctest=complete" style="font-size: 16px;"><img src="${pageContext.request.contextPath}/images/icon/cdetails.jpg" style="height: 60px;">Click for complete test details</a>
         </c:when>
         </c:choose>
    
        </div>
    </section>
   <!-- FOOTER -->
    <footer id="footer" class="footer">
     <%--   <%@include file="/ffooter.jsp" %> --%>
       <%@include file="/sfooter.jsp" %>
    </footer>
    <!-- END / FOOTER -->
</div>

<!-- END / PAGE WRAP -->

  <%@include file="/js.jsp" %>

</body>
</html>