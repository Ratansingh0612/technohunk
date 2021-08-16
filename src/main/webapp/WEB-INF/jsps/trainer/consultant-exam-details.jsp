<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>${companyName} | Exam Detail Summary</title>
<meta charset="utf-8">
 <%@include file="/resources.jsp" %>
<style>
<!--
input[type="checkbox"] { -webkit-appearance: checkbox; }
input[type="radio"] { -webkit-appearance: radio; }
input[type="submit"], input[type="button"] { -webkit-appearance: button; }
select { -webkit-appearance:textfield; }
-->
</style>	
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
     <%@include file="/uheader.jsp" %>
    <!-- END / HEADER -->


    <!-- PROFILE FEATURE -->
    <%@include file="profile-feature.jsp" %>
    <!-- END / PROFILE FEATURE -->


    <!-- CONTEN BAR -->
     <%@include file="content-bar.jsp" %>
   <!-- END / CONTENT BAR -->
    <!-- COURSE CONCERN -->
  <section style="padding-top: 0px;padding-bottom:10px;background-color: white;" id="quizz-intro-section" class="quizz-intro-section learn-section">
        <div class="container">
          <hr style="color: black"/> 
        				 <h3 style="font-size: 18px;">
        				 <img src="${pageContext.request.contextPath}/images/exam-summary.png" style="height:60px;"/>
        				 Exam/Test Detail Summary:-  <img src="${pageContext.request.contextPath}/action/findConsultantImage?userid=${param.consultantId}" style="height: 60px;margin-left: 150px;" class="img-circle"></h3>
        				  Consultant Id : 02902939393 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  Group : ${param.batch}  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   Name :${param.name}${param.consultantId}  
        				<hr/>
							<table class="table table-bordered">
								<tr>
								<td>
                				Technology :  </b>&nbsp;&nbsp;&nbsp; 
                			    <span style="font-weight: bold;">${param.techName}</span> 
                				</td>
                				<td>
                				Test Name :  </b>&nbsp;&nbsp;&nbsp; 
                				<span style="font-weight: bold;">${testName}</span> 
                				</td>
								<td>                				
                				Secured Marks :  </b>&nbsp;&nbsp;&nbsp; 
                				<span style="font-weight: bold;">${testConfiguration.secureMarks} </span>
                				</td>
       							<td>         				
                				Total Marks :  </b>&nbsp;&nbsp;&nbsp; 
                				<span style="font-weight: bold;">${testConfiguration.totalMarks} </span>
                				</td>
                				<td>         				
                				 Marks% :  </b>&nbsp;&nbsp;&nbsp; 
                				<span style="font-weight: bold;"> 
                				 <fmt:formatNumber
													type="number" minFractionDigits="2" maxFractionDigits="2"
													value="${(testConfiguration.secureMarks/testConfiguration.totalMarks)*100}"/>
                				</span>
                				</td>
                				</tr>
                				  </table>
                               
                <hr style="color: black"/> 
                <img src="${pageContext.request.contextPath}/images/icon/success-icon.png" style="height: 40px;"/>
								
						<div style="float: right">
							  Total Questions : <b>${fn:length(questionList)}</b>
						</div>
						 <br/>
						<form  id="addQToConfigureTest" action="${pageContext.request.contextPath}/action/add-qconfigure-test" method="post">
						<table class="table table-bordered">
					 	<c:forEach var="question" items="${questionList}"  varStatus="status" >
					<tr>
						<td  colspan=3 height="30" style="color: black;font-size: 16px;">
								<span id="questionTextId" style="color:black;"><b>${status.count} .</b>&nbsp;<img src="${pageContext.request.contextPath}/images/pquestion.png"/>${question.questionText}</span>
						</td>
					</tr>
					<tr>
						<td bgcolor="white" width=2%>1.</td>
						<td colspan="2" bordercolor="black" 
						<c:if test="${question.selectedOption == question.answerId1 && question.correctOption == question.answerId1}">
									style="background-color:rgba(183, 207, 255, 0.91);"
						</c:if>
							<c:if test="${question.selectedOption == question.answerId1 && question.correctOption != question.answerId1}">
									style="background-color:rgba(233, 30, 99, 0.66);"
							</c:if>>
							<input type="radio"  id="selectedAnswerId1"  disabled="disabled"  
							name="${question.questionId}" value="${question.answerId1}" 
							<c:if test="${question.selectedOption == question.answerId1}">checked</c:if>/>
						  ${question.answerText1}
							<c:if test="${question.correctOption == question.answerId1}">
							  <c:set var="correct" value="${question.answerText1}"/>
						    </c:if>
			               </td>
					</tr>

					<tr>
						<td bgcolor="white" width="2%">2.</td>
						<td 	
						
							<c:if test="${question.selectedOption == question.answerId2 && question.correctOption == question.answerId2}">
									style="background-color:#42BB7B"
						</c:if>
							<c:if test="${question.selectedOption == question.answerId2 && question.correctOption != question.answerId2}">
									style="background-color:rgba(233, 30, 99, 0.66);"
							</c:if>>
							<span class="style3"><input type="radio"  disabled="disabled"  id="selectedAnswerId2" name="${question.questionId}" value="${question.answerId2}" 
							<c:if test="${question.selectedOption == question.answerId2}">checked</c:if>/>
							${question.answerText2}</span>
							<span class="style3">
							<c:if test="${question.correctOption == question.answerId2}">
							  <c:set var="correct" value="${question.answerText2}"/>
						    </c:if>
			                </span>
			               </td>
					</tr>
					
					
					<c:if test="${question.noOfOptions >2}">
					<tr>
						<td bgcolor="white" width=2%>3.</td>
						<td bgcolor="white" 
					<c:if test="${question.selectedOption == question.answerId3 && question.correctOption == question.answerId3}">
									style="background-color:#42BB7B"
						</c:if>
							<c:if test="${question.selectedOption == question.answerId3 && question.correctOption != question.answerId3}">
									style="background-color:rgba(233, 30, 99, 0.66);"
							</c:if>>
						<span class="style3">
						<input type="radio"  disabled="disabled"  id="selectedAnswerId3"  name="${question.questionId}" value="${question.answerId3}" 
					      <c:if test="${question.selectedOption == question.answerId3}">checked</c:if>
					    />
					  ${question.answerText3}</span></td>
						<c:if test="${question.correctOption == question.answerId3}"><c:set var="correct" value="${question.answerText3}"/></c:if>
					</tr>
					</c:if>
					
					<c:if test="${question.noOfOptions >3}">
					<tr>
						<td bgcolor="white" width=2%>4.</td>
						<td bgcolor="white" 
						<c:if test="${question.selectedOption == question.answerId4 && question.correctOption == question.answerId4}">
									style="background-color:#42BB7B"
						</c:if>
							<c:if test="${question.selectedOption == question.answerId4 && question.correctOption != question.answerId4}">
									style="background-color:rgba(233, 30, 99, 0.66);"
							</c:if>>
						
						<span class="style3"><input type="radio"  disabled="disabled"  id="selectedAnswerId4" name="${question.questionId}" value="${question.answerId4}" 
					      <c:if test="${question.selectedOption == question.answerId4}">checked</c:if>
					    />
					  ${question.answerText4}</span></td>
						<c:if test="${question.correctOption == question.answerId4}"><c:set var="correct" value="${question.answerText4}"/></c:if>
					</tr>
					</c:if>
					
					<c:if test="${question.noOfOptions >4}">
					<tr>
						<td bgcolor="white" width=2%>5.</td>
						<td bgcolor="white" 
						
						<c:if test="${question.selectedOption == question.answerId5 && question.correctOption == question.answerId5}">
									style="background-color:#42BB7B"
						</c:if>
							<c:if test="${question.selectedOption == question.answerId5 && question.correctOption != question.answerId5}">
									style="background-color:rgba(233, 30, 99, 0.66);"
							</c:if>>
						<span class="style3"><input type="radio"  disabled="disabled"  id="selectedAnswerId5" name="${question.questionId}" value="${question.answerId5}" 
					      <c:if test="${question.selectedOption == question.answerId5}">checked</c:if>
					    />
					  ${question.answerText5}</span></td>
							<c:if test="${question.correctOption == question.answerId5}"><c:set var="correct" value="${question.answerText5}"/></c:if>
					</tr>
					</c:if>
					
					<c:if test="${question.noOfOptions >5}">
					<tr>
						<td bgcolor="white" width=2%>6.</td>
						<td bgcolor="white" 
						   <c:if test="${question.selectedOption == question.answerId6 && question.correctOption == question.answerId6}">
									style="background-color:#42BB7B"
						  </c:if>
							<c:if test="${question.selectedOption == question.answerId6 && question.correctOption != question.answerId6}">
									style="background-color:rgba(233, 30, 99, 0.66);"
							</c:if>>
						
						<span class="style3"><input type="radio"  disabled="disabled"  id="selectedAnswerId6" name="${question.questionId}" value="${question.answerId6}" 
					      <c:if test="${question.selectedOption == question.answerId6}">checked</c:if>
					    />
					  ${question.answerText6}</span></td>
							<c:if test="${question.correctOption == question.answerId6}"><c:set var="correct" value="${question.answerText6}"/></c:if>
					</tr>
					</c:if>
					
						<c:if test="${question.noOfOptions >6}">
					<tr>
						<td bgcolor="white" width=2%>7.</td>
						<td bgcolor="white" 
						 <c:if test="${question.selectedOption == question.answerId7 && question.correctOption == question.answerId7}">
									style="background-color:#42BB7B"
						  </c:if>
							<c:if test="${question.selectedOption == question.answerId7 && question.correctOption != question.answerId7}">
									style="background-color:rgba(233, 30, 99, 0.66);"
							</c:if>>
						<span class="style3"><input type="radio"  disabled="disabled"  id="selectedAnswerId7" name="${question.questionId}" value="${question.answerId7}" 
					      <c:if test="${question.selectedOption == question.answerId7}">checked</c:if>
					    />
					  ${question.answerText7}</span></td>
						<c:if test="${question.correctOption == question.answerId7}">
						<c:set var="correct" value="${question.answerText7}"/></c:if>
					</tr>
					</c:if>
						<tr>
						<td bgcolor="" colspan="3" height="30"><span id="ans" style="color:black;background-color: #DBEAF9">Answer : ${correct}</span></td>
					</tr>
					
					<tr>
						<td bgcolor="" colspan="3" height="30">&nbsp;</td>
					</tr>
					
					</c:forEach>
					</table>    
						</form>
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