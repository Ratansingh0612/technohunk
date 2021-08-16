<%@page import="java.util.List"%>
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
    <title>${companyName} - Search Consultant Test Status</title>
       
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
  <section style="padding-top: 0px;padding-bottom:10px;background-color: white;min-height:600px;" id="quizz-intro-section">
        <div class="container">
            <div class="title-ct">
                 &nbsp;&nbsp;
                  <hr/>	
                 <img src="${pageContext.request.contextPath}/images/test-report.png" style="height: 80px;display:inline;"/>
                <h3 style="font-size: 16px;color:black;display:inline;">Tech Name(Filter) &nbsp;&nbsp;:&nbsp;&nbsp;</h3>
								<select class="form-control" name="selectedGroupName" id="selectedGroupName" style="width: 400px;display: inline;">
							 	   <option>Select Technology</option>
							 	   <%
							 		List<String> techNameList=(List<String>)request.getAttribute("techNameList");
							 		for(String techName:techNameList){
							 		%>
									<option><%=techName%></option>
									<% 
							 		}
									%>
						 </select> 
						  <span style="float: right;">
						  	  <img src="${pageContext.request.contextPath}/images/child.png" style="height: 90px;" class="img-circle">
						  	  <br/>
						  	  <b>(${consultantsVO.name})</b>
						  </span>	
            </div>
             <form:form id="userTestHistoryForm"
							action="${pageContext.request.contextPath}/action/user-test-history"
							method="POST">
							<input type="hidden" name="userid" id="userid"/> <br /> 
							<section style="margin-left: -16px;">
							<div class="col-xs-12">
								
						 </div>
						</section>
			
						   <br/>			
						   Consultant Id : <b>${consultantsVO.empid}</b>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Name : <b>${consultantsVO.name}</b>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Stream : <b>${consultantsVO.stream}</b>   
             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Batch : <b>${consultantsVO.batch}</b>
           
							<hr style="color: blue" />		
						
							 <span id="ApplicationMessage" style="font-size: 14px;color:blue;"></span>
					 
            <div class="table-student-submission">
             
            <span style="font-family: 'Lato', sans-serif;font-size: 16px;">Test(s) List:-</span>
					    <div style="float: right;">
								<img src="../images/favicon.ico" height="30px">&nbsp;<span style="font-family: 'Lato', sans-serif;font-size: 14px;">Total Users :</span> <span id="totalUsers">${fn:length(userList)}<b>10</b></span>
							</div>
                <table class="table table-bordered" id="tab1">
                    <thead>
                        <tr style="background-color: #1192ea;">
                            <th class="submissions" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">SNo</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Technology</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">TestName </th>
                            <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">DOT</th>
                            <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">ICON</th>
                               <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Secure Marks</th>
                            <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Max Marks</th>
                            <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Marks%</th>
                        </tr>
                    </thead>

                    <tbody>
                        <k:forEach items="${userOnlineExamStatusList}" var="item" varStatus="pp">
					       <tr style="color: black">
					     <td bgcolor="white">&nbsp;${pp.count}</td>
					         <td bgcolor="white">&nbsp;${item.techName}</td>
					   	    <td bgcolor="white">&nbsp;${item.testName}</td>
					   	   <td bgcolor="white">&nbsp;${item.dateOfTest}</td>
					   	   <td bgcolor="white">&nbsp;${item.secureMarks}</td>
					   	  <td bgcolor="white">&nbsp;${item.secureMarks}</td>
					   	   <td bgcolor="white">&nbsp;${item.totalMarks}</td>
					   	    <td>&nbsp;<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${item.secureMarks*100/item.totalMarks}" /></td>
					     </tr>
					     </k:forEach>
					     <tr style="color: black">
					     <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	       <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	    <td bgcolor="white">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					   	     <td>&nbsp;</td>
					     </tr>
					   <tr  style="color: black">
					     <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	       <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	    <td bgcolor="white">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					   	      <td>&nbsp;</td>
					     </tr>
					   <tr style="color: black">
					     <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	    <td bgcolor="white">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					   	      <td>&nbsp;</td>
					   	       <td>&nbsp;</td>
					     </tr>

                    </tbody>
                </table>
                <hr/>
                  <h5 style="color:black;">Consultant Test Progress Bar Chart.</h5>
                 <img src="${pageContext.request.contextPath}/action/chart/studentTestReportAsBarChart?consultantId=${consultantsVO.empid}" class="img-responsive"/>
                </div>
                </form:form>
            </div>
    </section>
    <!-- END / COURSE CONCERN -->

   <!-- FOOTER -->
    <footer id="footer" class="footer">
     <%--   <%@include file="/ffooter.jsp" %> --%>
       <%@include file="/sfooter.jsp" %>
    </footer>
    <!-- END / FOOTER -->
<!-- END / PAGE WRAP -->
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
    
    function showUserHistory(userid) {
    	$("#userid").val(userid);
    	$("#userTestHistoryForm").submit();
    } 
</script>
</body>

</html>