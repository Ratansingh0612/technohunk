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
	<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/jquery-te-1.4.0.css" />
<script type="text/javascript"	src="${pageContext.request.contextPath}/js/jquery-te-1.4.0.min.js"></script>
	
    <title>${companyName} - Upload Questions Answers</title>
    
	

</head>
<body>

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
  <section class="quizz-intro-section" style="padding-top: 0px;padding-bottom:10px;background-color: #eee;min-height: 500px;" id="content">
  <br/>
        <div class="container" style="background-color: white;height: 570px;">
                 <h3 style="color: black;font-size: 17px;display: inline;"> <b> Questions  -> Upload Questions/Answers</b></h3> 
                 <hr/>
			<span id="errorMessage" style="color:red;font-size: 16px;font-weight: normal;">
			</span>	
			<span  style="color:red;font-size: 16px;font-weight: normal;">${message}</span>
			<span style="color:red;font-size: 16px;font-weight: normal;">${url}</span>
			
            <form id="uploadQuestionBankFrom"
							action="${pageContext.request.contextPath}/action/upload-questions-answers"
							method="post" enctype="multipart/form-data">
							
							<input type="hidden" name="excelSheetType" value="QuestionBank">
							
							<table class="table" style="width: 100%;margin-top: 10px;" id="tab1">
							<tbody>
							<tr>
							<td>
							<input type="hidden" name="NoOfUsers"
								value="${fn:length(users)}" /> 
							</td>
							<td>
							 <label
								style="font-family: 'Lato', sans-serif;font-size: 16px;"> Technology :&nbsp; </label>
								<select
								name="techid"  id="techid" class="form-control" style="display: inline;width: 250px;">
								<c:forEach var="technology" items="${technologies}">
									<option>${technology.tname}</option>
								</c:forEach>
							</select> 
							</td>
							<td>
							 <label
								style="font-family: 'Lato', sans-serif;font-size: 16px;"> Question Bank Name :&nbsp; </label>
								<input
								name="questionBankName"  id="questionBankName" class="form-control" style="display: inline;width: 350px;"/>
							</td>
								</tr>
								
								<tr>
									<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
								</tr>
								
					</tbody>
					</table>
					
					<input type="file" id="fileData" name="fileData" class="form-control" style="display: inline;width: 300px;"/>	
					 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button"
										value="Upload Question Bank"
										class="btn btn-danger"
										id="uploadQuestionBankBt" />		
										
			 <br/>			 <br/>	
            <div class="table-student-submission">
               <!--  <table class="table  table-bordered" width="100%" id="tbl1">

                    <tbody>
										<tr  style="color: black">
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr style="color: black">
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr  style="color: black">
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr style="color: black">
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr style="color: black">
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td>&nbsp;</td>
								</tr>

	


                    </tbody>
                </table> -->
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
<!-- END / PAGE WRAP -->

<!-- Load jQuery -->
<!-- Load jQuery -->
  <%@include file="/js.jsp" %>



<script type="text/javascript">
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