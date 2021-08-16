<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from envato.megadrupal.com/html/megacourse/account-assignment.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 19 Mar 2017 04:41:35 GMT -->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <title>${companyName} - Exam Summary Page</title>
</head>
<body id="page-top">

<!-- PAGE WRAP -->
<div id="page-wrap"> 	

    <!-- PRELOADER -->
    <div id="preloader">
        <div class="pre-icon">
            <div class="pre-item pre-item-1"></div>
            <div class="pre-item pre-item-2"></div>
            <div class="pre-item pre-item-3"></div>
            <div class="pre-item pre-item-4"></div>
        </div>
    </div>
    <!-- END / PRELOADER -->

    <!-- HEADER -->
     <%@include file="uheader.jsp" %>
    <!-- END / HEADER -->


    <!-- PROFILE FEATURE -->
    <%@include file="profile-feature.jsp" %>
    <!-- END / PROFILE FEATURE -->


    <!-- CONTEN BAR -->
     <%@include file="content-bar.jsp" %>
   <!-- END / CONTENT BAR -->
 
    <!-- COURSE CONCERN --> 
  <section  id="quizz-intro-section" class="quizz-intro-section learn-section" style="padding-top: 0px;padding-bottom: 10px;background-color: white;">
  
       <div class="container">

<!--             <div class="title-ct"> -->
                
<%--                  &nbsp;&nbsp;<h3 style="font-family: 'Lato', sans-serif;font-size: 14px;"><img src="${pageContext.request.contextPath}/images/question1.png"/> - <b>Available Test(s)</b></h3>  --%>
<!--             </div> -->

            <div class="table-student-submission">
             &nbsp;&nbsp;<h3 style="font-family: 'Lato', sans-serif;font-size: 14px;"><img src="${pageContext.request.contextPath}/images/question1.png"/> - <b>Exam Summary Page 
        &nbsp;&nbsp; (${userOnlineExamStatus.testName}  (${userOnlineExamStatus.secureMarks}/${userOnlineExamStatus.totalMarks})</b></h3> 
                  <div>
                           <span style="float:left;font-family: 'Lato', sans-serif;font-size: 16px;">Test Name : 
                         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${userOnlineExamStatus.testName}</span>
                             </div>
                          <span style="float:right;margin-right: 600px;font-family: 'Lato', sans-serif;font-size: 16px;">Technology : 
                         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${userOnlineExamStatus.techName}</span>
                             </div>
               
            
                <hr style="color: black"/> 
<!--       			<table border="1" style="width: 1100px;  cellpadding=2px; cellspacing=0px;" > -->
      			<table class="table  table-bordered" width="100%">
      			
      			 <tr style="background-color: #b5e8fd;;color:black;">
      			 
      			          <td class="score" style="width:20%">Questions Attempted </td>
                            <td class="submit-date" style="width:20%">Correct Questions</td>
                            <td class="author" style="width:20%">Total Questions </td>
                            <td class="submit-date" style="width:20%">Secure Marks</td>
<!--                              <td class="submit-date" style="width:15%">Total Marks</td>  -->
                            	<td class="submit-date" style="width:20%">Marks%</td>
                            	<td class="submit-date" style="width:20%">Detail</td>
                            	
<!--                              <td class="submit-date" style="width:15%">Test Name</td> -->
<!--                               <td class="submit-date" style="width:20%">Marks Obtained</td> -->
                         </tr>
<!-- 					     <tr height="35px" style="color: white;background-color:#013648;vertical-align: middle;" align="center"> -->
<!-- 					     	<td bgcolor="#003D50"><b>SNo</b></td> -->
<!-- 					     	<td bgcolor="#003D50"><b>Total Questions</b></td> -->
<!-- 						<td bgcolor="#003D50"><b>Questions Attempted</b></td> -->
<!-- 						<td bgcolor="#003D50"><b>Correct Questions</b></td> -->
<!-- 						<td bgcolor="#003D50"><b>Marks Obtained</b></td> -->
<!-- 					   	<td bgcolor="#003D50"><b>Total Marks</b></td> -->
<!-- 					   	<td bgcolor="#003D50"><b>Mark%</b></td> -->
<!-- 					   	<td bgcolor="#003D50"><b>Detail Test Summary</b></td> -->
<!-- 					     </tr> -->
					      <tr height="25px" align="center" style="background-color: #FCF6CF">
<%-- 					        <td  align="center"> &nbsp;<b>${userOnlineExamStatus.testName}</b></td> --%>
					   	   <td>&nbsp;&nbsp;<b>${userOnlineExamStatus.totalNoAnsweredQuestion}</b></td>
					   	   <td><b>${userOnlineExamStatus.totalCorrectAnswer}</b></td>
					   	   <td  align="center"> &nbsp;<b>${userOnlineExamStatus.totalNoQuestion}</b></td>
					   	     <td><b>${userOnlineExamStatus.secureMarks}</b></td>
<%-- 					   	   <td><b>${userOnlineExamStatus.totalMarks}</b></td> --%>
					   	      	<td><fmt:formatNumber
													type="number" minFractionDigits="2" maxFractionDigits="2"
													value="${(userOnlineExamStatus.secureMarks/userOnlineExamStatus.totalNoQuestion)*100}"/></td>
													 <td>
													 	<a href="${pageContext.request.contextPath}/action/examDetail?testName=${userOnlineExamStatus.testName}&techName=${userOnlineExamStatus.techName}&userSessionId=${userOnlineExamStatus.userSessionId}"><font
													color="#000000">Detail<img src="${pageContext.request.contextPath}/images/ddetails.png" style="height:20px; "/></font></a>
									
													 </td>
												
<%-- 					   	      <td align="center"><a href="${pageContext.request.contextPath}/action/examDetail?testName=${userOnlineExamStatus.testName}"><img src="${pageContext.request.contextPath}/images/summary.png"/></a></td> --%>
					     </tr>
					        <tr height="35px">
					     <td>&nbsp;</td>
					   	   <td></td>
					   	          <td></td>
					   	   <td></td>
					   	   <td></td>
					   	    <td></td>
					     </tr>
					    
					        <tr height="35px">
					     <td>&nbsp;</td>
					        <td>&nbsp;</td>
					   	   <td></td>
					   	          <td></td>
					   	   <td></td>
					   	    <td></td>
					     </tr>
					     
					     
<!-- 					         <tr height="35px"> -->
<!-- 					     <td>&nbsp;</td> -->
<!-- 					        <td>&nbsp;</td> -->
<!-- 					   	   <td></td> -->
<!-- 					   	          <td></td> -->
<!-- 					   	   <td></td> -->
<!-- 					     </tr> -->
					     
<!-- 					         <tr height="35px"> -->
<!-- 					     <td>&nbsp;</td> -->
<!-- 					        <td>&nbsp;</td> -->
<!-- 					   	   <td></td> -->
<!-- 					   	          <td></td> -->
<!-- 					   	   <td></td> -->
<!-- 					     </tr> -->
					     
<!-- 					         <tr height="35px"> -->
<!-- 					     <td>&nbsp;</td> -->
<!-- 					        <td>&nbsp;</td> -->
<!-- 					   	   <td></td> -->
<!-- 					   	          <td></td> -->
<!-- 					   	   <td></td> -->
<!-- 					     </tr> -->
<!-- 					         <tr height="35px"> -->
<!-- 					     <td>&nbsp;</td> -->
<!-- 					        <td>&nbsp;</td> -->
<!-- 					   	   <td></td> -->
<!-- 					   	          <td></td> -->
<!-- 					   	   <td></td> -->
<!-- 					     </tr> -->
					     
					</table>
            </div>

            
        </div>
    </section>

    <!-- END / COURSE CONCERN -->


   <!-- FOOTER -->
    <footer id="footer" class="footer">
     <%--   <%@include file="/ffooter.jsp" %> --%>
       <%@include file="/sfooter.jsp" %>
    </footer>
    <!-- END / FOOTER -->



</div>
<!-- END / PAGE WRAP -->

<!-- Load jQuery -->
<!-- Load jQuery -->
  <%@include file="/js.jsp" %>

<script type="text/javascript">

    $.each($('.table-wrap'), function() {
        $(this)
            .find('.table-item')
            .children('.thead:not(.active)')
            .next('.tbody').hide();
        $(this)
            .find('.table-item')
            .delegate('.thead', 'click', function(evt) {
                evt.preventDefault();
                if ($(this).hasClass('active')==false) {
                    $('.table-item')
                        .find('.thead')
                        .removeClass('active')
                        .siblings('.tbody')
                            .slideUp(200);
                }
                $(this)
                    .toggleClass('active')
                    .siblings('.tbody')
                        .slideToggle(200);
        });
    });

</script>
</body>

</html>