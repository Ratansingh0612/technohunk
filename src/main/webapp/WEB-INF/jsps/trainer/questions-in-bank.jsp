<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <title>${companyName} - Questions In Bank</title>
    
   <style type="text/css">
   			p{
   			    color: black;
   			    font-size: 15px;
   			    font-family: 'Raleway',rockwell;
   			}
   	
   </style>	

</head>
<body id="page2"
	style="background:url(${pageContext.request.contextPath}/images/bg_top2.jpg) top repeat-x #fff;"
	onkeydown="return (event.keyCode != 116)">

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
  <section class="quizz-intro-section" style="padding-top: 0px;padding-bottom:10px;background-color: #eee;min-height: 570px;" id="content">
        <div class="container">
        <br/>
         <img src="${pageContext.request.contextPath}/images/icon/Icon_01.png"  style="width:40px;"/>  
              <span style="font-size: 15px;">
               <a href="${pageContext.request.contextPath}/action/questions-bank">Questions-Bank</a>  ->  Questions</span>
               <hr/> 
           	 <span style="font-size: 17px;">${ApplicationMessage}</span>
             <hr style="border-top: 1px solid #fbd7d7;"/>
			<span id="message" style="color:black;font-size: 15px;font-weight: normal;margin-right: 100px;">
			 <img src="${pageContext.request.contextPath}/images/icon/success-icon.png" style="height: 30px;"/>
			 Question Bank Name : <b>${param.qbankName} </b>
			</span>	
			
				<span id="message" style="color:black;font-size: 15px;font-weight: normal;margin-right: 200px">
			  <img src="${pageContext.request.contextPath}/images/icon/formula_icon.png" style="height: 30px;"/>
			    Total Questions :
			   <b> (${fn:length(questionsInBankList)})</b>
			</span>
			
				<span style="color:black;font-size: 15px;font-weight: normal;float: right;">
			  Export Questions : 
			  <a href="javascript:downloadQuestionBankAsExcel();">
			  <img src="${pageContext.request.contextPath}/images/icon/excel.png" style="height: 42px;"/> 
			  <img src="${pageContext.request.contextPath}/images/DL25-icon.png" style="height: 42px;"/> 
			  </a>
			</span>	
			
            <form id="uploadQuestionBankFrom"
							action="${pageContext.request.contextPath}/action/upload-questions-answers"
							method="post" enctype="multipart/form-data">
							
					 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<!-- <input type="button"
										value="Upload Question Bank"
										class="btn btn-danger"
										id="uploadQuestionBankBt" />		 -->
            <div class="table-student-submission">
               <table class="table  table-bordered" width="100%" id="tbl1">
               		   <thead>
                        <tr style="background-color: #b5e8fd;;color:black;font-size: 15px;font-weight: bold;">
                            <td class="submissions" style="width:5px;">SNo</td>
                            <td class="author">Question Text </td>
                             <td class="score" style="width:15%">Technology </td>
                            <td class="score" style="width:10%">Complexity </td>
                              <td class="submit-date" style="width:11%">Action</td>
                         </tr>
                        </thead>    
                    <tbody>
									
								<c:forEach items="${questionsInBankList}" var="item" varStatus="ss">	
								<tr  style="color: black;">
									<td>&nbsp;${ss.count}</td>
									<td bgcolor="white" style="color:black;"> &nbsp;${item.questionText}&nbsp;</td>
										<td bgcolor="white">&nbsp;${item.technology}</td>
									<td bgcolor="white">&nbsp;${item.questionComplexity}</td>
									<td bgcolor="white">&nbsp;
									
										<span style="text-align: center;">
										<a href="${pageContext.request.contextPath}/action/edit-question-and-answer?questionId=${item.questionId}">
										<img src="${pageContext.request.contextPath}/images/icon/edit.png" style="height: 40px;"/>
										</a>
										     <k:if test="${sessionScope.user_session_data.role=='admin'}">	
										     <a href="javascript:deleteQuestion('${item.questionId}');">
										     		<img src="${pageContext.request.contextPath}/images/icon/delete.png" style="height: 40px;margin-left: 8px;"/>
									       	</a>
									       </k:if>
									
									</span>
								
									</td>
								</tr>
								</c:forEach>
								<tr  style="color: black">
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
								</tr>
								<tr style="color: black">
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
								</tr>


                    </tbody>
                </table> 
            </div>
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

<form id="deleteQuestionForm" action="${pageContext.request.contextPath}/action/delete-question-and-answer" method="post">
		<input type="hidden" name="questionId" id="questionId">
		<input type="hidden" name="qbankName" value="${param.qbankName}">
		<input type="hidden" name="techName" value="${param.techName}">
</form>

  <form id="downloadExcelSheetForm" action="${pageContext.request.contextPath}/report/questions-bank-with-answers-excel" method="post">
  		<input type="hidden" name="qbankName" value="${param.qbankName}">
		<input type="hidden" name="techName" value="${param.techName}">
  </form>

<!-- END / PAGE WRAP -->
 

<!-- Load jQuery -->
<!-- Load jQuery -->
  <%@include file="/js.jsp" %>



<script type="text/javascript">

function downloadQuestionBankAsExcel(){
	var yesno=confirm("Are you sure want to export all the questions into excel sheet?");
		if(yesno) {
			$("#downloadExcelSheetForm").submit();
		}
}

function deleteQuestion(questionId) {
	var yesno=confirm("Are you sure want to delete this question with question id = "+questionId);
	if(yesno) {
		$("#questionId").val(questionId);
		$("#deleteQuestionForm").submit();
	}
}

$(document).ready(function(){
	
	$("#fileData").click(function(e){
		$("#errorMessage").html("");
	});
	
	$("#questionBankName").keyup(function(e){
		$("#errorMessage").html("");
	});
	$("#uploadQuestionBankBt").click(function(e){
		var techid=$("#techid").val();	
		var questionBankName=$("#questionBankName").val();
		if(questionBankName.length==0){
			$("#errorMessage").html("Question bank name cannot be blank.");
			$("#questionBankName").focus();
			return;
		}
		else if(questionBankName.length<4){
			$("#errorMessage").html("Question bank name should be more than three characters .");
			$("#questionBankName").focus();
			return;
		}
		
		var fileData=$("#fileData").val();
		if(fileData==0){
		
			$("#errorMessage").html("Please select the question bank to be uploaded .");
			$("#fileData").focus();
			return;
		}
		
		
		$("#uploadQuestionBankFrom").submit();
	});
});	

</script>
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