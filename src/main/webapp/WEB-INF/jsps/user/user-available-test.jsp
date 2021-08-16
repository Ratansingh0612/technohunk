<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <title>${companyName} - Available Test</title>
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
  <section class="quizz-intro-section" style="padding-top: 0px;padding-bottom:10px;background-color: #eee;" id="content">
   <section style="height: 11px;width:100%;background-color: #eee">&nbsp;</section>    
       <div class="container" style="background-color: white;">
                   <img src="${pageContext.request.contextPath}/images/icon/Icon_01.png" width="40px;"/>
                 <h3 style="color: black;font-size: 17px;display: inline;"> Online Test -> Available Test(s)</h3> 
                 
            <div class="table-student-submission">
                <table class="table table-bordered">
                    <thead>
                        <tr style="background-color: #607D8B;">
                            <th class="submissions" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">SNo</th>
                             <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Technology </th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Test Name </th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Questions </th>
                            <th class="score" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Durations </th>
                            <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Assigned Date </th>
                         	<th style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Test Expire Time(Hrs)</th>
                         	<th style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Test Expiry Date</th>
                         	<th style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Test Status/Action</th>
                        </tr>
                    </thead>
                    <tbody>
                     <k:forEach var="aOnlineTest" items="${assignedTestUserList}" varStatus="pk">
                        <tr class="new">
                            <td class="submissions">${pk.count}</td>
                             <td>${aOnlineTest.techName}</td>
                            <td>${aOnlineTest.testName}</td>
							<td>${aOnlineTest.numberOfQuestions}</td>
                            <td>${aOnlineTest.durationInMin}</td>
                            <td>${aOnlineTest.assignDate}</td>
                            <td width="15%;">${aOnlineTest.testExpireTimeInHrs}</td>
                            <td width="15%;">${aOnlineTest.testExpireOn}</td>
                            <td>
                             <k:if test="${aOnlineTest.testStatus=='Not Started'}">
							           	<a href="${pageContext.request.contextPath}/action/load-tech-test?testName=${aOnlineTest.testName}&techName=${aOnlineTest.techName}"><b>StartTechTest</b><img align="center" src="${pageContext.request.contextPath}/images/start.png" alt="" width="20" height="20"/></a>
							           	</k:if>
							         <k:if test="${aOnlineTest.testStatus=='In progress'}">
							           	<a href="${pageContext.request.contextPath}/action/resumePreviousTechTest?testName=${aOnlineTest.testName}&techName=${aOnlineTest.techName}"><b>Resume Test</b><img align="center" src="${pageContext.request.contextPath}/images/start.png" alt="" width="20" height="20"/>
							           	</a>
							          </k:if> 	
							            <k:if test="${aOnlineTest.testStatus=='complete'}">
							       			<b>Complete</b><img src="${pageContext.request.contextPath}/images/finish.jpg" alt=""  width="25" height="25"/>
   									 </k:if> 	
                                                    </td>
                        </tr>
                        
					</k:forEach>	
						<tr style="height: 35px;">
							 <td>&nbsp;</td>
							  <td>&nbsp;</td>
							   <td>&nbsp;</td>
							    <td>&nbsp;</td>
							     <td>&nbsp;</td>
							      <td>&nbsp;</td>
							       <td>&nbsp;</td>
                            <td>&nbsp;</td>
                                 <td>&nbsp;</td>
                            </tr>
                            <tr style="height: 35px;"><td></td>
                            <td></td>
                                 <td>&nbsp;</td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            </tr>
                            <tr style="height: 35px;"><td></td>
                                 <td>&nbsp;</td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            </tr>
                             <tr style="height: 35px;"><td></td>
                                  <td>&nbsp;</td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            </tr>
                            <tr style="height: 35px;"><td></td>
                                 <td>&nbsp;</td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            </tr>
                            <tr style="height: 35px;"><td></td>
                                 <td>&nbsp;</td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            </tr>
                            <tr style="height: 35px;"><td></td>
                                 <td>&nbsp;</td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            </tr>
                            <tr style="height: 35px;"><td></td>
                                 <td>&nbsp;</td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            </tr>
                            <tr style="height: 35px;"><td></td>
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