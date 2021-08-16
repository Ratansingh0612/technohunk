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
    <title>${companyName} - CARRER COUNSELING ASSESSMENT RESULT</title>
</head>
<body id="page2"
	style="background:url(${pageContext.request.contextPath}/images/bg_top2.jpg) top repeat-x #fff;"
	onkeydown="return (event.keyCode != 116)">

<!-- PAGE WRAP
    overflow: hidden - >>>menu was hide behind the main page
 -->

<div id="page-wrap" style="overflow: inherit">

   <c:choose>
      <c:when test = "${sessionScope.user_session_data.role=='user'}">
               <%@include file="/uheader.jsp" %>
         </c:when>
         
         <c:when test = "${sessionScope.user_session_data.role=='consultant'}">
               <%@include file="/uheader.jsp" %>
         </c:when>
         
             <c:when test = "${sessionScope.user_session_data.role=='admin'}">
               <%@include file="/aheader.jsp" %>
         </c:when>
         
         <c:otherwise>
            <%@include file="/uheader.jsp" %>
         </c:otherwise>
         </c:choose>
 </div>
 
 
    <!-- PROFILE FEATURE -->
    
    <!-- END / PROFILE FEATURE -->
    <!-- END / PROFILE FEATURE -->
 <!-- COURSE CONCERN --> 
  <section class="quizz-intro-section" style="padding-top: 0px;padding-bottom:10px;background-color: #f9f9f9;min-height: 570px;" id="content">
       <div class="container">
            <div  style="font-size: 16px;margin-top: 10px;">
                	   <img src="${pageContext.request.contextPath}/images/icon/logo.png" width="40px;"/>
	                 <h3 style="color: black;font-size: 20px;display: inline;"> <b><u>Online Career Counseling Test Summary</u></b></h3> 
            </div>
        <hr style="height: 4px;background-color: #bdbdd9"/>  
 		   <div style="background-color: #f49347;height: 28px;font-size: 18px;"><b>Personal Details</b></div>
  			 <table class="table table-bordered" style="font-size: 16px;">
        <tbody>
          <tr>
                <td style="width: 30%">Name : ${guestUserDetail.name}</td>
                <td style="width: 30%"><img src="${pageContext.request.contextPath}/images/icon/email.png" style="height: 25px;">&nbsp;Email  : ${guestUserDetail.email}</td>
                  <td style="width: 20%">Test ID : ${guestUserDetail.name}</td>
                <td><img src="${pageContext.request.contextPath}/images/icon/mobile.png"  style="height: 25px;"/>&nbsp;Mobile: <b>NA</b></td>
            </tr>
            </tbody>
         </table>   

            <div style="background-color: #e4e339;height: 28px;font-size: 18px;font-weight: bold;">Your Self Awareness Test Result Are - ></div>
       	<hr/>
       <table class="table table-bordered" style="font-size: 17px;">
       			<thead style="background-color: #40c9a2;">
       				<th>Trait</th>
       				<th>Description</th>
       				<th>Score%</th>
       			</thead>
               <tbody>
           <tr>
                <td style="font-weight: bold;">&nbsp;Realistic </td>
                <td>Involve work activities that include practical, hands-on problems and solutions. They often deal with
real-world materials, and do not involve a lot of paperwork or working closely with others.
                </td>
                <td>&nbsp;20</td>
                </tr>
                
                  <tr>
                <td style="font-weight: bold;">&nbsp;Artistic  </td>
                <td>Involve working with forms, designs and patterns. They often require self-expression and the work can be done without following a clear set of rules.
                </td>
                <td>&nbsp;20</td>
                </tr>
                
                  <tr>
                <td style="font-weight: bold;">&nbsp;Investigative   </td>
                <td>Involve working with ideas, and require an extensive amount of thinking. These occupations can involve searching for facts and figuring out problems
mentally.

                </td>
                <td>&nbsp;20</td>
                </tr>
                
                 <tr>
                <td style="font-weight: bold;">&nbsp;Enterprising    </td>
                <td>Involve starting up and carrying out projects, leading people and making many decisions, risk taking, dealing with business.

                </td>
                <td>&nbsp;20</td>
                </tr>
                
                  <tr>
                <td style="font-weight: bold;">&nbsp;Conventional     </td>
                <td>Involve following set procedures and routines, working with data and details more than with ideas. Usually there is a clear line of authority to follow.

                </td>
                <td>&nbsp;20</td>
                </tr>
                
                
                  <tr>
                <td style="font-weight: bold;">&nbsp;Social     </td>
                <td>Involve working with, communicating with, and teaching people. These occupations often involve helping or providing service to others.

                </td>
                <td>&nbsp;20</td>
                </tr>
        </tbody>
         </table> 
         
           <div style="background-color: #bfe5ff;height: 28px;font-size: 18px;font-weight: bold;">Some  Skill options for you can be : </div>
			<table class="table table-bordered" style="font-size: 17px;">
               <tbody>
           <tr>
                <td>Card1 </td>
                   <td>Card2</td>
                       <td>Card3 </td>
                </tr>
                </tbody>
                </table>         
                
                  <div style="background-color: #c7f9c1;height: 28px;font-size: 18px;font-weight: bold;">Next 3 Skills options can be  </div>
			<table class="table table-bordered" style="font-size: 17px;">
               <tbody>
           <tr>
                <td>Card1 </td>
                   <td>Card2</td>
                       <td>Card3 </td>
                </tr>
                </tbody>
                </table>         
       <div style="background-color: white;height: 28px;font-size: 18px;">For  more options contact at <img src="${pageContext.request.contextPath}/images/icon/email.png" style="height: 18px;"><b>pratap.ashutosh@gmail.com</b> </div>
    <%--   <a href="${pageContext.request.contextPath}/action/${test_history_name}?testName=${userOnlineExamStatusForm.testName}&techName=${userOnlineExamStatusForm.techName}&userSessionId=${userOnlineExamStatusForm.userSessionId}&email=${guestUserDetail.email}" style="font-size: 16px;"><img src="${pageContext.request.contextPath}/images/icon/test-details.png">Click for test details</a> --%>
        </div>
    </section>
   <!-- FOOTER -->
    <footer id="footer" class="footer">
     <%--   <%@include file="/ffooter.jsp" %> --%>
       <%@include file="/sfooter.jsp" %>
    </footer>
    <!-- END / FOOTER -->



<!-- END / PAGE WRAP -->

  <%@include file="/js.jsp" %>

</body>
</html>