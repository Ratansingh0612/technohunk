  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
    <title>${companyName} - Show Technology Progress</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/trainer-css/trainer.css" type="text/css" media="all">
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<!--[if lt IE 9]>
<script type="text/javascript" src="js/html5.js"></script>
<style type="text/css">.bg, .box2{behavior:url("js/PIE.htc");}</style>
<![endif]-->
</head>
<body>
<!-- PAGE WRAP -->
   <div class="body121">
  <div class="main">
      <c:if test="${sessionScope.user_session_data.role=='trainer'}">	
      <%@include file="theader.jsp"%>
      </c:if>
        <c:if test="${sessionScope.user_session_data.role=='admin'}">	
       <%@include file="/aheader.jsp"%>
       </c:if>
  </div>
</div>

    <!-- PROFILE FEATURE -->
    <%@include file="profile-feature.jsp" %>
    <!-- END / PROFILE FEATURE -->
    <!-- CONTEN BAR -->
     <%@include file="content-bar.jsp" %>
   <!-- END / CONTENT BAR -->
   <section class="quizz-intro-section" style="padding-top: 0px;padding-bottom:10px;background-color: #eee;min-height: 600px;" id="content">
        <div class="container">
          <br/>
         <div class="title-ct">
                 &nbsp;&nbsp;<h3 style="color: black;font-size: 17px;display: inline;"><img src="${pageContext.request.contextPath}/images/document-paper-64.png" width="40px;"/> - <b> Consultant Session Detail Page </b></h3>
                   <span style="float: right;">
                   </span>
            </div>
              <hr style="color: blue;height: 5px;background-color: #37abf2;"/>
						<div style="font-size:16px;">
							<table border="0" width="40%" >
							<tr height="30px"><td  rowspan="6"><img src="${pageContext.request.contextPath}/action/findConsultantImage?userid=${consultantsVO.empid}" style="height: 100px;" /></td></tr>
							<tr height="30px"><td >Consultant Name </td><td width="30px" >:</td><td>${consultantsVO.name}</td></tr>
							<tr height="30px"><td>Batch           </td><td>:</td><td>${consultantsVO.batch}</td></tr>
							<tr height="30px"><td>DOJ             </td><td>:</td><td>${consultantsVO.doj}</td></tr>
							<tr height="30px"><td>Total Hrs      </td><td>:</td><td>${formatedDuration}</td></tr>
							<tr height="30px"><td>Stream          </td><td>:</td><td>${consultantsVO.stream}</td></tr>
							</table>
							<table border="0" width="40%" style="float: right; margin-top: -150px; margin-right: 80px;">
							<tr height="30px"><td>Total Days      </td><td>:</td><td>${noOfDays}</td></tr>
							<tr height="30px"><td id="ConsultantEmail">Consultant email      </td><td>:</td><td>${consultantsVO.email}</td></tr>
							</table>
							</div>
						  <hr style="color: blue;height: 5px;background-color: #ffffff;"/>
						 <div style="font-size:16px;">
						  <label for="testName" style="font-family: 'Lato', sans-serif;font-size: 16px;">Technology :&nbsp;&nbsp;&nbsp;</label>
								<select name="techName"  id="techName" class="form-control" style="display: inline;width: 300px;">
								<option value="All" selected="selected">All</option>
								<c:forEach items="${techNameList}" var="item">
								 		<option>${item}</option>
								 		</c:forEach>
							</select> 
				 </div><br/><br/>
				 
				 
						 <img src="${pageContext.request.contextPath}/img/users.png"/> 
					   <span style="font-size: 16px;font-weight: bold;"> Sessions Details:-</span>
					    <br/><br/>
					    <span style="float: right;margin-top: -35px;margin-right: 60px;">
                       			  <img src="${pageContext.request.contextPath}/img/favicon.ico" > <b>Total Sessions :</b> <span id="totalRecords">${fn:length(trainingSessionsDetailVO)}</span>
                             </span> 
                             
                             <table class="table  table-bordered"">
      			            <tr style="background-color: #b5e8fd;;color:black;font-size: 16px;">
      			            <td class="score">SNo. </td>
      			          <td class="score" style="width:25%">Date of Session </td>
      			          <td class="score" style="width:25%">Tech Name </td>
                            <td class="submit-date" style="width:20%">Topic Covered</td>
                            <td class="author" style="width:20%">Start Time </td>
                            <td class="submit-date" style="width:20%">End Time</td>
                             <td class="submit-date" style="width:15%">Duration(Mins)</td>  
                            	<td class="submit-date" style="width:30%">Trainer </td>
                             </tr>
                             
                             
                            <tbody id="partialContent">
					      <c:forEach var="item" items="${trainingSessionsDetailVO}" varStatus="status">
					      <tr height="25px" style="color: black">
					     <td><b>${status.count}.</b></td>
					   	   <td align="left">${item.doe}</td>
					   	   <td align="left">${item.techName}</td>
					   	   <td >&nbsp;${item.topics}</td>
					   	   <td align="center">${item.starttime}</td>
					   	   <td align="center">${item.endtime}</td>
					   	   <td align="center">${item.timeduration}</td>
					   	   <td align="center">${item.userid}</td>
					     </tr>
					     </c:forEach>
						</tbody>     
						
						  <tr height="30px" style="vertical-align: middle;" align="center">
					     <td >&nbsp;</td>
					      <td >&nbsp;</td>
					      <td >&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					   	    <td>
					   	    <b>&nbsp;</b></td>
					     </tr>
						
					</table>     
      </div>
     </section> 
    <!-- FOOTER -->
    <footer id="footer" class="footer">
     <%--   <%@include file="/ffooter.jsp" %> --%>
       <%@include file="/sfooter.jsp" %>
    </footer>
    <!-- END / FOOTER -->


<!-- END / PAGE WRAP -->

<!-- Load jQuery -->
<!-- Load jQuery -->
  <%@include file="/js.jsp" %>
    
    <!-- / footer -->
    
 <script
    src="http://maps.googleapis.com/maps/api/js?key=YOUR_APIKEY&sensor=false">
</script>
       
     <script type="text/javascript">
     $(document).ready(function() {
 		//alert("good morning!");
   	 $("#techName").change(function() {
   			alert("hey how are you!!!")
   			 var techName=$("#techName").val();
   				var loginId = "${consultantsVO.email}";
   				alert("Login ID is "+loginId);
   			var ccontextPath="${pageContext.request.contextPath}";
   			//I want to send consultantVo obj here
   			 $.getJSON(ccontextPath+"/action/filterConsultantSessionDetailsByTechName", {techName:techName , loginId:loginId},function(jsonResponse) {
   				 	//alert("Are you getting json response..");
   				 	console.log(jsonResponse);
   				 	var contentData="";
   				 	for(var row=0;row<jsonResponse.length;row++) {
   				 		alert("looping....")
   				 		contentData=contentData+'  <tr>';
   				 		contentData=contentData+'  <td bgcolor="white">&nbsp;'+(row+1)+'</td>';
				 		contentData=contentData+' <td bgcolor="white">&nbsp;'+jsonResponse[row].sessiondate+'</td>';
				 		contentData=contentData+'   <td bgcolor="white">&nbsp;'+jsonResponse[row].techName+'</td>';
				 		contentData=contentData+' 	  <td bgcolor="white">&nbsp;'+jsonResponse[row].topics+'</td>';
				 		contentData=contentData+' <td bgcolor="white">&nbsp;'+jsonResponse[row].starttime+'</td>';
				 		contentData=contentData+'  <td bgcolor="white">&nbsp;'+jsonResponse[row].endtime+'</td>';
				 		contentData=contentData+'  <td bgcolor="white">&nbsp;'+jsonResponse[row].timeduration+'</td>';
						contentData=contentData+'  <td bgcolor="white">&nbsp;'+jsonResponse[row].userid+'</td>';
				 		contentData=contentData+' </td>';
				 		contentData=contentData+'  </tr>';
   				 	}
   				
   				 	$("#partialContent").html(contentData);	
   				 	alert(contentData);
   				 	//loadData();	
   			 });//end of the callback function..................
   			 
   		});
   	 
     });
   		 
</script>	
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

</body>
</html>