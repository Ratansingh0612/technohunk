<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <title>${companyName} - Available Test</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/trainer-css/trainer.css" type="text/css" media="all">
</head>
<body>
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


    <!-- COURSE CONCERN -->
<section id="content" style="background-color: #eee">
		<section style="height: 10px;background-color: #eee;width: 100px;">
   		</section>
        <div class="container" style="background-color: white;">
                  <h3 style="color: black"><img src="${pageContext.request.contextPath}/images/icon/Icon_01.png" width="40px;"/> - <span style="font-size: 16px;">Test - > All Available Test</span></h3>
                  <hr style="color: black"/> 
								   <div style="float: right;">
								<span style="font-family: 'Lato', sans-serif;font-size: 14px; margin-right:">Total Records :</span> <b>${fn:length(testConfigurationsList)}</b>
							</div> 
                 
                <form id="completedTestListForm" action="${pageContext.request.contextPath}/action/completedTestList" method="post">
                    <input type="hidden" name="tttechnology"/> 
                </form>
      			   <table class="table table-bordered" id="tab1">
                    <thead>
                        <tr style="background-color: #607D8B;">
                            <th class="submissions" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">SNo</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Tech Name</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Test Name </th>
                            <th class="score" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">No of Questions</th>
                            <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Test Duration(Mins)</th>
                       			                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Test Created On </th>
                       			<th style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">
                       			Detail
                         	</th>
                         	
                         		<th style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Assigned Users
                         	</th>
                       			
                    </thead>
					    
					     <k:forEach var="aOnlineTest" items="${testConfigurationsList}" varStatus="tt">
					      <tr height="25px" style="color: black">
					     <td  align="center">${tt.count}.</td>
					   	   <td>&nbsp;&nbsp;${aOnlineTest.techName}</td>
					   	   <td>&nbsp;${aOnlineTest.testName}</td>
					   	   <td align="center">${aOnlineTest.totalQuestions}</td>
					   	   <td align="center">${aOnlineTest.testDuration}</td>
					   	      <td align="left">
					           	  ${aOnlineTest.lastModifyOn}
					   	      </td>
					   	       <td  align="center">
					           	  <a href="${pageContext.request.contextPath}/action/edit-configure-test?techName=${aOnlineTest.techName}&testName=${aOnlineTest.testName}">
					           	  		<img src="${pageContext.request.contextPath}/images/icon/writing-icon.png" style="height: 35px;"/>
					           	  </a>
					   	      </td>
					   	      <td  align="center">
					           	  <a href="javascript:showUsersForTest('${aOnlineTest.testName}');">Show</a>
					   	      </td>
					     </tr>
					     </k:forEach>
					      <tr height="30px">
					     <td>&nbsp;</td>
					   	   <td></td>
					   	     <td></td>
					   	   <td></td>
					   	   <td></td>
					   	   <td></td>
					       <td></td>
					      <td></td>
					     </tr>
					      <tr height="35px">
					     <td>&nbsp;</td>
					   	   <td></td>
					   	     	   <td></td>
					   	   <td></td>
					   	   <td></td>
					   	   <td></td>
					       <td></td>
					      <td></td>
					     </tr>
					     </tbody>
					     
					</table>     
        </div>
  </section>

    <!-- END / COURSE CONCERN -->


   <!-- FOOTER -->
    <footer id="footer" class="footer">
     <%--   <%@include file="/ffooter.jsp" %> --%>
       <%@include file="/sfooter.jsp" %>
    </footer>
    <!-- END / FOOTER -->

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