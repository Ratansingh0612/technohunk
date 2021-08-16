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

<!-- Mirrored from envato.megadrupal.com/html/megacourse/account-assignment.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 19 Mar 2017 04:41:35 GMT -->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <title>${companyName} - Questions Bank</title>
    
	

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
   <br/>
        <div class="container" style="background-color: white;">
              <br/>
			  <img src="${pageContext.request.contextPath}/images/icon/Icon_01.png" width="40px;"/>
                 <h3 style="color: black;font-size: 17px;display: inline;"> Questions -> Questions Bank (${fn:length(questionsBankFormList)})</h3> 
			<span id="message" style="color:red;font-size: 16px;font-weight: normal;">
			 ${param.AppMsg}
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
                        <tr style="background-color: #b5e8fd;;color:black;">
                            <td class="submissions" style="width:5px;">SNo</td>
                            <td class="author" style="width:25%">Bank Name </td>
                            <td class="score">Tech Name </td>
                            <td class="submit-date" style="width:5%">Questions</td>
                            <td class="submit-date" style="width:25%">Excel Name</td>
                            <td class="submit-date" style="width:15%">Upload Date</td>
                              <td class="submit-date" style="width:8%">Details</td>
                         </tr>
                        </thead>    
                    <tbody>
									
								<c:forEach items="${questionsBankFormList}" var="item" varStatus="ss">	
								<tr  style="color: black">
									<td bgcolor="white">&nbsp;${ss.count}</td>
									<td bgcolor="white">&nbsp;${item.qbankname}</td>
									<td bgcolor="white">&nbsp;${item.techName}</td>
									<td bgcolor="white">&nbsp;${item.noq}</td>
									<td bgcolor="white">&nbsp;<img src="${pageContext.request.contextPath}/images/excel.png"/><a href="${item.url}">${item.excelSheetName}</a></td>
									<td bgcolor="white">&nbsp;${item.doe}</td>
									<td bgcolor="white">&nbsp;
									<a href="${pageContext.request.contextPath}/action/show-questions-in-bank?qbankName=${item.qbankname}&techName=${item.techName}">
									<img src="${pageContext.request.contextPath}/images/details.png" style="height: 40px;"/>
									</a>
									</td>
									
								</tr>
								</c:forEach>
								<tr style="color: black">
								<td bgcolor="white">&nbsp;</td>
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