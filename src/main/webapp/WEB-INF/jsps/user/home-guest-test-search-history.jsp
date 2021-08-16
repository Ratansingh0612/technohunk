<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <title>${companyName} - Search & Guest Test History</title>
    
    <style>
<!--
input[type="checkbox"] { -webkit-appearance: checkbox; }
input[type="radio"] { -webkit-appearance: radio; }
input[type="submit"], input[type="button"] { -webkit-appearance: button; }
select { -webkit-appearance:textfield; }
-->

#tab1 img{height:30px;}
</style>
</head>
<body id="page-top">

<!-- PAGE WRAP -->
<div id="page-wrap">

<div class="body121">
  <div class="main">
     <!-- HEADER -->
      <k:choose>
      <k:when test = "${sessionScope.user_session_data.role=='user'}">
               <%@include file="uheader.jsp" %>
         </k:when>
         
         <k:when test = "${sessionScope.user_session_data.role=='consultant'}">
               <%@include file="uheader.jsp" %>
         </k:when>
         
            <k:when test = "${sessionScope.user_session_data.role=='trainer'}">
       							<%@include file="../trainer/theader.jsp" %>
         </k:when>
         
             <k:when test = "${sessionScope.user_session_data.role=='admin'}">
               <%@include file="/aheader.jsp" %>
         </k:when>
         <k:otherwise>
           <%@include file="oguestheader.jsp" %>
         </k:otherwise>
        </k:choose>
  </div>
</div>

    <!-- PROFILE FEATURE -->
 <!-- PROFILE FEATURE -->
         <k:choose>
            <k:when test = "${sessionScope.user_session_data.role=='trainer'}">
               <%@include file="../trainer/profile-feature.jsp" %>
         </k:when>
         <k:otherwise>
           <%@include file="og-profile-feature.jsp" %>
         </k:otherwise>
         </k:choose>
    <!-- END / PROFILE FEATURE -->
    <!-- END / PROFILE FEATURE -->

   <!-- END / CONTENT BAR -->
 
    <!-- COURSE CONCERN -->
    <section class="quizz-intro-section" style="padding-top: 0px;padding-bottom:10px;background-color: #eee;min-height: 600px;" id="content">
<!--   <section style="padding-top: 0px;padding-bottom:10px;background-color: white;" id="quizz-intro-section"> -->
		<hr/>	
        <div class="container" style="background-color: white;background-image: url('${pageContext.request.contextPath}/images/icon/search-result1.jpg')">
                <h3 style="color: black"><img src="${pageContext.request.contextPath}/images/icon/search-results.png" width="50px;"/>&nbsp;&nbsp;<span style="font-size: 16px;">Guest Test Status History</span></h3> 
             						<hr style="border-top: 1px solid #a9a9a9;margin-top: 0px"/>
								
            <div class="table-student-submission">
             <img src="${pageContext.request.contextPath}/images/icon/exam.png" width="40px;"/>
					    <span style="font-size: 14px;">Search Result(s)</span>
					     &nbsp;&nbsp;&nbsp;  
					    <div style="float: right;">
                            <span>Total Result(s) : <span id="totalUser">${fn:length(guestAllTechHistoryList)}</span></span>
                             </div> 
                
               
							<input type="hidden" name="NoOfUsers" value="${fn:length(guestAllTechHistoryList)}" /> <br /> 
                <table class="table table-bordered" id="tab1">
                    <thead>
                        <tr style="background-color: #607D8B;">
                            <th class="submissions" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">SNo</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Tech Name</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Test Name </th>
                            <th class="score" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Name </th>
                            <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Email</th>
                                <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Test Status</th>
                                  <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Score%</th>
								   <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Detail</th>
								   <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">DOT</th>
                        </tr>
                    </thead>

                    <tbody>
					   	 <k:forEach items="${guestAllTechHistoryList}" var="Item" varStatus="snnn">
					      <tr height="35px" style="color: black">
									<td bgcolor="white">&nbsp;${snnn.count}</td>
									<td bgcolor="white">&nbsp;${Item.techName}</td>
									<td bgcolor="white">&nbsp;${Item.testName}</td>
									<td bgcolor="white">&nbsp;${Item.firstName}</td>
									<td bgcolor="white">&nbsp;${Item.email}</td>
										<td bgcolor="white">&nbsp;${Item.techTestStatus}</td>
									<td bgcolor="white">&nbsp;${Item.score}</td>
									<td bgcolor="white">&nbsp;
									<a href="javascript:showGuestTestSummary('${Item.email}','${Item.userSessionId}');"><img	src="${pageContext.request.contextPath}/images/not-started.png" width="24" height="24" alt="Click Here to reset the test" id="imageId'+val+'"/></a>
									</td>
									<td bgcolor="white">&nbsp;${Item.dot}</td>
								</tr>
								</k:forEach>
								 <tr height="35px" style="color: black">
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
								</tr>
								 <tr height="35px" style="color: black">
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
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
        </div>
    </section>
    <hr/>

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
	  $("#searchKey").keyup(function(){
		  $("#AppMessage").html("");	
	  });
});	
  
  function showGuestTestSummary(email,userSessionId) {
		 $("#semail").val(email);
		 $("#userSessionId").val(userSessionId);
		$("#guestTestHistoryForm").submit();
}

	</script>
	
 <form method="POST" action="${pageContext.request.contextPath}/action/guest-tech-test-history"  id="guestTestHistoryForm">
			                    <div class="course-keyword">
			                        <input type="hidden"  name="email" id="semail"/>
			                        <input type="hidden" name="userSessionId" id="userSessionId"/>
			                        
			                    </div>
                </form>					

</body>
</html>