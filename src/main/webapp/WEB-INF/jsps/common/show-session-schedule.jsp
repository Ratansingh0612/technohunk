<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>${companyName} | Session Detail</title>
<meta charset="utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/trainer-css/trainer.css" type="text/css" media="all">
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css" type="text/css" media="all">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/treset.css"
	type="text/css" media="all">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/layout.css"
	type="text/css" media="all">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" type="text/css"
	media="all">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/tstyle.css"
	type="text/css" media="all">
	
	<link href="${pageContext.request.contextPath}/css/timedropper.css" rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.5.2.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/cufon-yui.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/cufon-replace.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/Molengo_400.font.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/Expletus_Sans_400.font.js"></script>
	 <script type="text/javascript" src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script> 
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>

<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script> --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-datepicker.js"></script>


  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!--   <link rel="stylesheet" href="/resources/demos/style.css"> -->
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath}/js/timedropper.js"></script>
<script>$( "#alarm" ).timeDropper();</script>

 <script type="text/javascript">
$(document).ready(function() {
  	 $("select[id$='questionComplexity']").change(function() {
			$("#aquestionsBankFormId").submit();		 
	 });
});
</script>	
	
<body id="page-top">

<!-- PAGE WRAP -->
<div id="page-wrap">

<div class="body121">
  <div class="main">
      <k:if test="${sessionScope.user_session_data.role=='trainer'}">	
      <%@include file="/theader.jsp"%>
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
    <section class="quizz-intro-section" style="padding-top: 0px;padding-bottom:10px;background-color: #eee;min-height: 600px;" id="content">
<!--   <section style="padding-top: 0px;padding-bottom:10px;background-color: white;" id="quizz-intro-section" class="quizz-intro-section learn-section"> -->
        <div class="container">
				
				<form:form  id="#" action="#" method="post" commandName="">
				
            <div class="title-ct">
                
                 <br><img src="${pageContext.request.contextPath}/images/ScheduleIcon.png" width="25" /> - <span style="font-family: 'Lato', sans-serif;font-size: 14px;">Session Schedule Page</span> 
            </div>
            
            

            <div class="table-student-submission">
            
                             
                              <div class="wrapper">
                <hr style="color: black"/> 
                   <h4 style="color: red">
								 ${ApplicationMessage}
						</h4>
                 <div id="courseCoveredStatusContent">            
                <table class="table table-bordered">
               
                    <thead class="theader">
                        <tr style="background-color: #1192ea;">
                         <th class="submissions" style="text-align: center;">Sno</th>
                            <th class="submissions" style="width: 17%; text-align: center;">DOS (Date Of Session)</th>
                            <th class="author" style="text-align: center;width: 17%;">Technology</th>
                            <th class="author" style="text-align: center;width: 17%;">Topic</th>
                            <th class="score" style="text-align: center;">Batch</th>
                            <th class="submit-date" style="text-align: center;width: 10%;">Start Time</th>
					   	     <th style="text-align: center;width: 10%;">  End Time</th>
					   	       <th style="text-align: center;width: 10%;">Trainer Name</th>
                        </tr>
                           
                    </thead>
                    <c:forEach var="item" items="${trainingSessionsDetailVOList}" varStatus="status">
					     <tr>
					     	<td>${status.count}</td>
					     	<td>${item.doe}</td>
					     	<td>${item.technology}</td>	
					     	<td>${item.topics}</td>	
					     	<td>${item.batch}</td>	
					     		<td>${item.starttime}</td>	
					     		<td>${item.endtime}</td>	
					     		<td></td>
					     </tr>
					      	</c:forEach>

                    <tbody>
                     
                       <tr height="25px" style="color: black">
					        <td bgcolor="white">&nbsp;</td>
					          <td bgcolor="white">&nbsp;</td>
					            <td bgcolor="white">&nbsp;</td>
					              <td bgcolor="white">&nbsp;</td>
					                <td bgcolor="white">&nbsp;</td>
					                  <td bgcolor="white">&nbsp;</td>
					                    <td bgcolor="white">&nbsp;</td>
					                      <td bgcolor="white">&nbsp;</td>
					     </tr>
					    <tr height="30px" style="vertical-align: middle;" align="center">
					      <td bgcolor="white">&nbsp;</td>
					          <td bgcolor="white">&nbsp;</td>
					            <td bgcolor="white">&nbsp;</td>
					              <td bgcolor="white">&nbsp;</td>
					                <td bgcolor="white">&nbsp;</td>
					                  <td bgcolor="white">&nbsp;</td>
					                    <td bgcolor="white">&nbsp;</td>
					                      <td bgcolor="white">&nbsp;</td>
					     </tr>
					        <tr height="30px" style="vertical-align: middle;" align="center">
					     <td bgcolor="white">&nbsp;</td>
					          <td bgcolor="white">&nbsp;</td>
					            <td bgcolor="white">&nbsp;</td>
					              <td bgcolor="white">&nbsp;</td>
					                <td bgcolor="white">&nbsp;</td>
					                  <td bgcolor="white">&nbsp;</td>
					                    <td bgcolor="white">&nbsp;</td>
					                      <td bgcolor="white">&nbsp;</td>
					     </tr>
					     
					        <tr height="30px" style="vertical-align: middle;" align="center">
					     <td bgcolor="white">&nbsp;</td>
					          <td bgcolor="white">&nbsp;</td>
					            <td bgcolor="white">&nbsp;</td>
					              <td bgcolor="white">&nbsp;</td>
					                <td bgcolor="white">&nbsp;</td>
					                  <td bgcolor="white">&nbsp;</td>
					                    <td bgcolor="white">&nbsp;</td>
					                      <td bgcolor="white">&nbsp;</td>
					     </tr>
					     
					        <tr height="30px" style="vertical-align: middle;" align="center">
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
          
		</div>
		<button type="button" class="btn btn-primary btn-md" id="addSchedule" style="float: right;">Add Schedule Detail</button>
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