<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>${companyName} | Question Bank</title>
<meta charset="utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/trainer-css/trainer.css" type="text/css" media="all">
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

<div class="body121">
   <div class="main">
        <k:if test="${sessionScope.user_session_data.role=='trainer'}">	
      <%@include file="/theader.jsp"%>
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
  <section style="padding-top: 0px;padding-bottom:0px;background-color: white;" id="quizz-intro-section">
        <div class="container">
        				<hr/>
							<img
								src="${pageContext.request.contextPath}/images/question1.png" style="margin-top: -5px;"/>
							<span style="font-size: 16px;">Home -> Questions Bank</span>
							 &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 
							<img
								src="${pageContext.request.contextPath}/images/test-icon.png" style="height: 32px;margin-top: -5px;font-size: 16px;"/><span style="font-size: 16px;">Technology :</span>&nbsp;
						<b>  ${techName} </b>
						&nbsp;&nbsp;&nbsp;&nbsp;
							 &nbsp;
						<span style="font-size: 16px;">Question Bank : </span>
						&nbsp; <b> ${param.qBankName}</b>
					 &nbsp;&nbsp;&nbsp; 
						<span style="font-size: 16px;">Question Owner : </span>
						&nbsp; <b> ${questionOwner}</b>
						<br/>
						<hr/>
							<label style="margin-top:2px;">Complexity :</label> &nbsp; <select
							style="width: 120px; background-color: #F2F2F2;display:inline;"
							name="questionComplexity" class="form-control">
							<option selected="selected" value="None">None</option>
							<option>Normal</option>
							<option>Medium</option>
							<option>Complex</option>
						</select>
						&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; 
							<input type="button" value="Add Questions" class="mc-btn btn-style-1"  id="addQuestionsToTest"/>
							 <span style="float: right;">	
							 <a href="${pageContext.request.contextPath}/action/admin-available-questions-bank-test" title="Click here to return back to configure test page."> Back 
							  <img width="20" height="20" src="${pageContext.request.contextPath}/images/configure.png"/> </a>
						   </span>
						<hr style="color: black" />
						<img
								src="${pageContext.request.contextPath}/images/ask.ico" style="margin-top: -5px;"/>
								<b>Questions List</b>
								<span id="AppMessage" style="color: red;font-size: 17px;margin-left: 100px;"></span>
								
						<div style="float: right">
							  Total Questions : <span id="totalQuestions" style="font-weight: bold;">${fn:length(questionsList)}</span>
						</div>
						 <br/>
						<form  id="addQToConfigureTest" action="${pageContext.request.contextPath}/action/add-qconfigure-test" method="post">
						<table class="table table-bordered">
							<tr style="color: white; background-color: #1192ea; vertical-align: middle;">
								
								<th>
								<input type="checkbox" name="selectAllId" id="selectAllId" checked="checked"/>
								S</th>
								<th>&nbsp;&nbsp;Complexity&nbsp;&nbsp;</th>
								<th>Questions</th>
								<th width="100px">E/D &nbsp;&nbsp;</th>
							</tr>

							<c:set var="count" scope="page" value="0" />
							<c:forEach var="questionItem" items="${questionsList}"
								varStatus="status">
								<c:set var="count" scope="page" value="${count+1}" />
								<c:if test="${count%2==0}">
									<tr style="color: black;">
										<td>&nbsp;&nbsp;<input type="checkbox" id="selectedQuestionIds" name="selectedQuestionIds"
											value="${questionItem.questionId}" checked="checked"/> ${status.count}.
										</td>
										<td>&nbsp;&nbsp;${questionItem.questionComplexity}</td>
										<td>&nbsp;&nbsp;${questionItem.questionText}</td>
										<td><img alt=""
											src="${pageContext.request.contextPath}/images/edit.png" />
											&nbsp; <img alt=""
											src="${pageContext.request.contextPath}/images/close.png" />
										</td>
									</tr>
								</c:if>
								<c:if test="${count%2!=0}">

									<tr style="color: black;">
										<td>&nbsp;&nbsp;<input type="checkbox"
											name="selectedQuestionIds" id="selectedQuestionIds" value="${questionItem.questionId}" checked="checked"/> ${status.count}.
										</td>
										<td>&nbsp;&nbsp;${questionItem.questionComplexity}</td>
										<td>&nbsp;&nbsp;${questionItem.questionText}</td>
										<td><img alt=""
											src="${pageContext.request.contextPath}/images/edit.png" />
											&nbsp; <img alt=""
											src="${pageContext.request.contextPath}/images/close.png" />
										</td>
									</tr>
								</c:if>
							</c:forEach>
						</table>
							<span style="float: right;margin-top: -15px;">
							<input type="button" value="Add Questions" class="mc-btn btn-style-1"  id="addQuestionsToTest"/>
					</span>
						</form>
				      </div>
				       <hr style="background-color:#688298;height: 10px;"/>
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
<script type="text/javascript">
		$(document).ready(function() {
			
			$("#selectAllId").click(function(){
			    $('input:checkbox').not(this).prop('checked', this.checked);
			    var len= $('input:checkbox').not(this).length;
			    if($("input[type='checkbox'][ id='selectAllId']").is(':checked')){
			    	$("#totalQuestions").html(len);
			    }else{
			     	$("#totalQuestions").html(0);
			    }
			});
			
			$("input[type='checkbox'][id$='selectedQuestionIds']").click(function(){
				$("#selectAllId").removeAttr('checked');
				$("#AppMessage").html("");
				if($(this).is(':checked')){
					$("#totalQuestions").html(parseInt($("#totalQuestions").html())+1);
				}else{
					$("#totalQuestions").html(parseInt($("#totalQuestions").html())-1);
				}
			});
			//alert("good morning!");
		  	 $("input[type='button'][id$='addQuestionsToTest']").click(function() {
					 if($("input[type='checkbox'][id='selectedQuestionIds']").is(':checked')){
						    $("#addQToConfigureTest").submit();		 
					 }else{
						 $("#AppMessage").html("Please select a least one question from questions list!");
					 }
			 });
		});
</script>	
</body>

</html>