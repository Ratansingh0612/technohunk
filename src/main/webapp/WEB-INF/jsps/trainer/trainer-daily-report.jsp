<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/trainer-css/trainer.css" type="text/css" media="all">
   <script type="text/javascript"
	src="http://code.jquery.com/jquery.min.js" charset="utf-8"></script>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
    <title>${companyName} - Trainer Daily Session</title>

 <script type="text/javascript">
 
$(document).ready(function() {
	//setting the date format...
	var date_input=$('#sessiondate'); //our date input has the name "date"
		///var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
		date_input.datepicker({
			format: 'dd-mm-yyyy',
			todayHighlight: true,
			autoclose: true,
		});
	$("#showSessionRecord").click(function(e){
			var date_input=$('#sessiondate'); 
			$("input[type='hidden'][id='dos']").val(date_input.val());
			$("#trainerSessionForm").submit();
	});
});
</script>

<!--[if lt IE 9]>
<script type="text/javascript" src="js/html5.js"></script>
<style type="text/css">.bg, .box2{behavior:url("js/PIE.htc");}</style>
<![endif]-->
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
	   <form id="trainerSessionForm" action="${pageContext.request.contextPath}/action/trainer-daily-report"  method="POST"> 
	       <input type="hidden" name="dos" id="dos">
      </form>
	
	 
    <!-- COURSE CONCERN -->
    <section class="quizz-intro-section" style="padding-top: 0px;padding-bottom:10px;background-color: #eee;min-height: 600px;" id="content">
<!--   <section style="padding-top: 0px;padding-bottom:10px;background-color: white;" id="quizz-intro-section" class="quizz-intro-section learn-section"> -->
        <div class="container">
                 <br/>
                 &nbsp;&nbsp;<h3 style="color: black;font-size: 17px;display: inline;margin-right: 200px;"><img src="${pageContext.request.contextPath}/images/not-started.png" width="25px;"/> - <b> Trainer Daily Session Report</b></h3> 
                 <img src="${pageContext.request.contextPath}/images/calendar.png" width="40px;"/>
                 <span style="background-color: #ffffff;font-size: 16px;">Date : <input type="text" id="sessiondate" name="dos" class="form-control" style="width: 200px;display: inline;"  value="${dateOfSession}"/>
      									 &nbsp;&nbsp;	(dd-MM-yyyy)
      										 <span id="sessionmessage" style="display:none;font-size:16px;color:red; font-weight: 600;">
      										 Please Select Your Session Date!</span></span> 
                      <span>
                 	 <input type="button" value="Show Record" class="mc-btn btn-style-1"  id="showSessionRecord" style="float: right;margin-top: -2px;"/>
                 	 </span>
                 	 
                 <br/><br/>
             	<span style="color:blue;font-size: 16px;font-family: rockwell;">${ApplicationMessage}</span>    	 
            <c:forEach var="item"  items="${dailySessionReportLists}">
            <div>
                   <br/>
               <hr style="height: 10px;background-color: #e8b192;"/>
                    <table class="table table-bordered">
      			 	 <tbody>
      			 	 <tr height="25px" >
					     <td colspan="1" align="left" valign="bottom" >
					           <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Trainer Name</label>&nbsp;&nbsp;: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="background-color: #ffd3fc;font-size: 16px;">${item.name}</span>
								 &nbsp;&nbsp;
								  <img style="border-radius: 25px;" src="${pageContext.request.contextPath}/action/findConsultantImage?userid=${param.consultantId}" alt=""  width="50" height="50"/>
								 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;     <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Email&nbsp;&nbsp;: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${item.email}	</label>
							 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;     <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Empid &nbsp;&nbsp;: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   ${item.empid}	</label>
							 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;"><img src="${pageContext.request.contextPath}/images/test-icon.png" style="height: 40px;"/>Technology&nbsp;&nbsp;: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	<b>${item.technology}</b></label>
								 &nbsp;&nbsp;
					     </td>
					   </tr>
					  </tbody>
					 </table>
            
            <table class="table table-bordered">
      			 	 <tbody>
      			 	 <tr height="25px" >
					     <td>
					           <span style="font-family: 'Lato', sans-serif;font-size: 16px;margin-right: 20px;">Session Start Time:</span>
								  <b>${item.startTime}</b> 
						<td>
					 <td >
					           <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Session End Time:</label>
								 &nbsp;&nbsp; &nbsp;&nbsp;
								 	  <b>${item.endTime}</b> 
						<td>
						
						 <td align="left" valign="bottom" >
					           <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Total Session Duration</label>
								 &nbsp;&nbsp;
								 <b>${item.sessionDuration}</b> Minutes
						<td>
					   </tr>
					   	 <tr height="25px" >
					     <td align="left" valign="bottom" colspan="5" >
					           <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Topics Covered:</label>
								 &nbsp;&nbsp;
								 <span style="font-family: rockwell;font-size: 16px;background-color: #fefeff;"> ${item.topicCovered}.</span>
						<td>
					   </tr>
					  </tbody>
					 </table>
					     <span style="font-family: 'Lato', sans-serif;font-size: 16px;margin-right: 20px;">Batch Name :  <b>${item.batchName}</b></span>
				<table class="table  table-bordered"  id="tableContent">
      			    <tr height="30px" style="color: white;background-color:#1192ea;vertical-align: middle;" align="center">
      			          <td class="score" style="width:5%"><b>SNo</b> </td>
                            <td class="submit-date" style="width:10%"><b>EmpId</b></td>
                            <td class="author" style="width:30%"><b>Name</b></td>
                            <td class="submit-date" style="width:35%"><b>Email</b></td>
                              <td class="submit-date" style="width:35%"><b>Doj</b></td>
                             <td class="submit-date" style="width:15%"><b>Photo</b></td> 
                         </tr>
                         <c:forEach items="${item.consultantList}" varStatus="son" var="citem">
                         <tr height="25px" style="color: black">
                         		<td>&nbsp;${son.count}</td>
                         		<td>&nbsp;${citem.empid}</td>
                         		<td>&nbsp;${citem.name}</td>
                         			<td>&nbsp;${citem.email}</td>
                         				<td>&nbsp;<fmt:formatDate  value = "${citem.doj}" pattern="dd-MMM-yyyy"/></td>>
                         		<td>&nbsp;<img style="border-radius: 25px;" src="${pageContext.request.contextPath}/action/findConsultantImage?userid=E0999" alt=""  width="26" height="26"/></td>
                         </tr>
                         </c:forEach>
                       </table>  
 <hr style="height: 10px;background-color: #1192ea;"/>
 ============================================================================================================================================================================================
   <hr style="height: 10px;background-color: #e8b192;"/>
 </div>
 </c:forEach>     	
<%--              <div>
                    <table class="table table-bordered" width="60%">
      			 	 <tbody>
      			 	 <tr height="25px" >
					     <td colspan="1" align="left" valign="bottom" >
					           <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Trainer Name&nbsp;&nbsp;: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${consultantsVO.name}</label>
								 &nbsp;&nbsp;
								  <img style="border-radius: 25px;" src="${pageContext.request.contextPath}/action/findConsultantImage?userid=${param.consultantId}" alt=""  width="50" height="50"/>
								 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;     <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Email&nbsp;&nbsp;: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;nagen@javahu.com	</label>
							 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;     <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Empid&nbsp;&nbsp;: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; E04944	</label>
							 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;"><img src="${pageContext.request.contextPath}/images/test-icon.png"/>Technology&nbsp;&nbsp;: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	<b>Soap Web Service</b></label>
								 &nbsp;&nbsp;
					     </td>
					   </tr>
					  </tbody>
					 </table>
            
            <table class="table table-bordered">
      			 	 <tbody>
      			 	 <tr height="25px" >
					     <td>
					           <span style="font-family: 'Lato', sans-serif;font-size: 16px;margin-right: 20px;">Session Start Time:</span>
								  <b>12:45 PM</b> 
						<td>
					 <td >
					           <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Session Start Time:</label>
								 &nbsp;&nbsp; &nbsp;&nbsp;
								  <b>12:45 PM</b> 
						<td>
						
						 <td align="left" valign="bottom" >
					           <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Total Session Duration</label>
								 &nbsp;&nbsp;
								  <b>5 Hrs - 15 Minutes</b> 
						<td>
					   </tr>
					   	 <tr height="25px" >
					     <td align="left" valign="bottom" colspan="5" >
					           <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Topics Covered:</label>
								 &nbsp;&nbsp;
								  Setter Injection and constructor injection.
						<td>
					   </tr>
					  </tbody>
					 </table>
					     <span style="font-family: 'Lato', sans-serif;font-size: 16px;margin-right: 20px;">Batch Name :  JEE-5</span>
				<table class="table  table-bordered"  id="tableContent">
      			    <tr height="30px" style="color: white;background-color:#1192ea;vertical-align: middle;" align="center">
      			          <td class="score" style="width:20%"><b>SNo</b> </td>
                            <td class="submit-date" style="width:20%"><b>EmpId</b></td>
                            <td class="author" style="width:20%"><b>Name</b></td>
                            <td class="submit-date" style="width:20%"><b>Email</b></td>
                             <td class="submit-date" style="width:15%"><b>Photo</b></td> 
                         </tr>
                         <tr height="25px" style="color: black">
                         		<td>&nbsp;1</td>
                         		<td>&nbsp;E0999</td>
                         		<td>&nbsp;Parth Packer</td>
                         		<td>&nbsp;parth@gmail.com</td>
                         		<td>&nbsp;<img style="border-radius: 25px;" src="${pageContext.request.contextPath}/action/findConsultantImage?userid=E0999" alt=""  width="26" height="26"/></td>
                         </tr>
                            <tr height="25px" style="color: black">
                         				<td>&nbsp;2</td>
                         		<td>&nbsp;E01000</td>
                         		<td>&nbsp;Jasmin Jacker</td>
                         		<td>&nbsp;Jasmin@gmail.com</td>
                         		<td>&nbsp;<img style="border-radius: 25px;" src="${pageContext.request.contextPath}/action/findConsultantImage?userid=E0999" alt=""  width="26" height="26"/></td>
                         </tr>
                             <tr height="25px" style="color: black">
                         				<td>&nbsp;3</td>
                         		<td>&nbsp;E1500</td>
                         		<td>&nbsp;rapiddi coper</td>
                         		<td>&nbsp;rapidi@gmail.com</td>
                         		<td>&nbsp;<img style="border-radius: 25px;" src="${pageContext.request.contextPath}/action/findConsultantImage?userid=E0999" alt=""  width="26" height="26"/></td>
                         </tr>
                       </table>  
 <hr style="height: 10px;background-color: #1192ea;"/>
 </div> --%>
 </div>
    </section>
			  <footer id="footer" class="footer">
     <%--   <%@include file="/ffooter.jsp" %> --%>
       <%@include file="/sfooter.jsp" %>
    </footer>
    <!-- END / FOOTER -->



<!-- END / PAGE WRAP -->

<!-- Load jQuery -->
<!-- Load jQuery -->

  <%@include file="/js.jsp" %>
  <!-- Include Date Range Picker -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
</body>
</html>