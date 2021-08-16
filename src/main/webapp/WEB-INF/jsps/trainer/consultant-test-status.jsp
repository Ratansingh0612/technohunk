<%@page import="java.util.List"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <title>${companyName} - Consultant Test Status</title>
       
    <style>
<!--
input[type="checkbox"] { -webkit-appearance: checkbox; }
input[type="radio"] { -webkit-appearance: radio; }
input[type="submit"], input[type="button"] { -webkit-appearance: button; }
select { -webkit-appearance:textfield; }
-->
</style>
</head>
<body id="page-top" class="bloading">

<form id="pdfReportForm" action="${pageContext.request.contextPath}/report/consultant-tech-test-report/pdf" method="POST">
		<input type="hidden" name="pptechName"  id="ptechName"/>
		<input type="hidden" name="pptestName"  id="ptestName"/>
		<input type="hidden" name="ppbatchName"  id="tbatchName"/>
</form>

<form id="excelReportForm" action="${pageContext.request.contextPath}/report/consultant-tech-test-report/excel" method="POST">
		<input type="hidden" name="pptechName"  id="exceltechName"/>
		<input type="hidden" name="pptestName"  id="exceltestName"/>
		<input type="hidden" name="ppbatchName"  id="excelbatchName"/>
</form>
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
  <section style="padding-top: 0px;padding-bottom:0px;background-color: #eee;" class="quizz-intro-section learn-section">
   	<br/>
        <div class="container" style="background-color: white;">
    <h3 style="color: black;margin-top: -5px;"><img src="${pageContext.request.contextPath}/images/icon/Icon_01.png" width="40px;"/> - <span style="font-size: 16px;">Test - > Consultant Test Report</span></h3>
             	
             <form:form id="showUsersFormId"
							action="${pageContext.request.contextPath}/action/loadUsersByGroup"
							method="post" commandName="userListInput">
							<input type="hidden" name="NoOfUsers"
								value="${fn:length(userList)}" /> <br /> 
							<div class="col-xs-4">
								<label for="Group" style="font-family: 'Lato', sans-serif;font-size: 16px;"> Group/Batch :</label>
								<select class="form-control" name="selectedGroupName" id="selectedGroupName">
<%-- 							 		<k:forEach var="groupName" items="${userGroupList}"> --%>
							 	   <%
							 		List<String> groupNames=(List<String>)request.getAttribute("userGroupList");
							 	    String selectedGroupName=(String)request.getParameter("selectedGroupName"); 
							 		for(String gname:groupNames){
							 		%>
									<option value="<%=gname%>" 
									   <% 
									    if(gname.equals(selectedGroupName)){
									    	 %>
									    	selected
									   <%
	 								   } 
									   %> 
									   >
									<%=gname%>
									
									</option>
									<%
							 	     }
									%>
<%-- 									</k:forEach> --%>
						 </select> 
						 </div>
						
						
<!-- 						 <b style="color: black">Select Test Name :- </b>  -->
								<div class="col-xs-4">
								<label for="testName" style="font-family: 'Lato', sans-serif;font-size: 16px;">Technology :</label>
								<select
								name="techName"  id="techName" class="form-control" style="display: inline;">
								<k:forEach var="techname" items="${techNames}">
									<option value="${techname}">${techname}</option>
								</k:forEach>
							</select> 
							</div>
							
							<div class="col-xs-4">
								<label for="testName" style="font-family: 'Lato', sans-serif;font-size: 16px;">Test Name :</label>
								<select
								name="testName"  id="testName" class="form-control" style="display: inline;">
								<k:forEach var="testname" items="${testNames}">
									<option value="${testname}">${testname}</option>
								</k:forEach>
							</select> 
							</div>
							
							&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 
							<!-- <input style="margin-top:25px;"
							type="button" value="Load Users" class="btn btn-primary" id="loadUsersId" /> -->
							
							<hr style="color: blue" />		
						
							 <span id="ApplicationMessage" style="font-size: 14px;color:blue;"></span>
							
					 
            <div class="table-student-submission">
            <img src="${pageContext.request.contextPath}/images/icon/cheers.png" width="30px;"/>
            		<span style="font-family: 'Lato', sans-serif;font-size: 16px;">Consultant(s) List:-</span>
					<span style="font-family: 'Lato', sans-serif;font-size: 16px;margin-left: 50px;">
					<a href="javascript:generatePdf();">
							<img src="${pageContext.request.contextPath}/images/icon/pdf-logo.png" style="height: 40px;"/>
					</a>
					</span>
					
					<span style="font-family: 'Lato', sans-serif;font-size: 16px;margin-left: 10px;">
						<a href="javascript:generateExcel();">
					<img src="${pageContext.request.contextPath}/images/icon/excel.png" style="height: 40px;"/>
					</a>
					</span>
					    
					    <div style="float: right;">
								
								<img src="${pageContext.request.contextPath}/images/favicon.ico" height="30px">&nbsp;<span style="font-family: 'Lato', sans-serif;font-size: 14px;">Total Users :</span> <b><span id="totalUsers">${fn:length(userList)}</span></b>
							</div>
                <table class="table table-bordered" id="tab1" style="margin-bottom: 0px;">
                    <thead>
                        <tr style="background-color: #607D8B;">
                            <th class="submissions" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">SNo</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Name</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Email </th>
                            <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Batch</th>
                            <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Photo</th>
                               <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Test Status</th>
                            <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Lock/Unlock</th>
                        </tr>
                    </thead>

                    <tbody>
					       <tr style="color: black">
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
					     </tr>
					   <tr  style="color: black">
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
					     </tr>
					   <tr  style="color: black">
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
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					   	      <td>&nbsp;</td>
					     </tr>
					     
					     <tr  style="color: black">
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
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					   	      <td>&nbsp;</td>
					     </tr>

                    </tbody>
                </table>
                </div>
                </form:form>
            </div>
        </div>

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

function generateExcel(){
	var groupName=$("#selectedGroupName").val();
	var testName=$("#testName").val();
	var techName=$("#techName").val();
	$("#exceltestName").val(testName);
	$("#exceltestTech").val(techName);
	$("#excelbatchName").val(groupName);
	$("#excelReportForm").submit();
}

function generatePdf(){
	var groupName=$("#selectedGroupName").val();
	var testName=$("#testName").val();
	var techName=$("#techName").val();
	$("#ptestName").val(testName);
	$("#ptechName").val(techName);
	$("#tbatchName").val(groupName);
	$("#pdfReportForm").submit();
}

var ccontextPath="${pageContext.request.contextPath}";
var userRole="${sessionScope.user_session_data.role}";
function loadData(){
	var groupName=$("#selectedGroupName").val();
	var testName=$("#testName").val();
	var techName=$("#techName").val();
	var len=0;
  //$('body').prelodr('in', 'Loading data please wait...');
	 $('.bloading').loading({ overlay: true,base: 0.6 });
 	$('.bloading').loading('show');
  $.getJSON(ccontextPath+"/action/findUserBygroupNameTestTechNameAjax", {groupName:groupName,testName:testName,techName:techName}, function(jsonResponse) {
		 //$('body').prelodr('out');
		if(jsonResponse) {
			 len = jsonResponse.length;
      	var tableContent='';
      	var val;
      	$("#totalUsers").html(len);
      	tableContent=tableContent+' <thead>';
      	tableContent=tableContent+' <tr style="background-color: #607D8B;">';
      	tableContent=tableContent+'<th class="submissions" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">SNo</th>';
      	tableContent=tableContent+'<th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Consultant Id</th>';
      	tableContent=tableContent+'<th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Name</th>';
      	tableContent=tableContent+' <th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Email </th>';
      	tableContent=tableContent+'<th class="submit-date" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Photo</th>';
      	tableContent=tableContent+'<th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Test Status</th>';
      	tableContent=tableContent+'<th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Score%</th>';
    	tableContent=tableContent+'<th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Detail</th>';
      	tableContent=tableContent+'<th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Date of Test</th>';
      	tableContent=tableContent+'</tr>';
      	tableContent=tableContent+' </thead>';
      	if(len>0){
      		
      	for(var i=0;i<len;i++){
      			val=i+1;
      				tableContent=tableContent+'<tr height="35px" style="color: black; vertical-align: middle;">';
      				tableContent=tableContent+'<td align="center">'+val+'</td>';
      				tableContent=tableContent+'<td >&nbsp;&nbsp;&nbsp;'+jsonResponse[i].loginid+'</td>';
      				tableContent=tableContent+'<td >&nbsp;&nbsp;&nbsp;'+jsonResponse[i].firstName+' '+jsonResponse[i].lastName+'</td>';
      				tableContent=tableContent+'<td >&nbsp;&nbsp;&nbsp;'+jsonResponse[i].email+'</td>';
      				var imageURI="";
      				if(userRole=="admin") {
      					 imageURI='${pageContext.request.contextPath}/action/imageByUserId?userid='+jsonResponse[i].loginid;
      				}
      				else if(userRole=="trainer") {
      					 imageURI='${pageContext.request.contextPath}/action/findConsultantImage?userid='+jsonResponse[i].loginid;
      				}
      				tableContent=tableContent+'<td align="center"><img src="'+imageURI+'" style="height:30px" /></td>';
      				tableContent=tableContent+'<td id="testStatus"'+val+'>&nbsp;&nbsp;&nbsp;'+jsonResponse[i].techTestStatus+'</td>';
      				tableContent=tableContent+'<td>'+jsonResponse[i].score+'</td>';
      				tableContent=tableContent+'<td align="center">';
      				if ("Completed".toLowerCase() === jsonResponse[i].techTestStatus.toLowerCase()){
      					var jsmethod="<a href=\"${pageContext.request.contextPath}/action/consultant-exam-detail?userSessionId="+jsonResponse[i].userSessionId+"&consultantId="+jsonResponse[i].loginid+"&name="+jsonResponse[i].firstName+"&batch="+groupName+"&techName="+techName+"&testName="+testName+"\"";
      					tableContent=tableContent+jsmethod+'"><img	src="${pageContext.request.contextPath}/images/not-started.png" width="24" height="24" alt="Click Here to reset the test" id="imageId'+val+'"/></a>';
      				}
      				tableContent=tableContent+'</td>';
      				
      				tableContent=tableContent+'<td>'+jsonResponse[i].dot+'</td>';
      				tableContent=tableContent+'</tr>'
      			
      	}
      	}
      	
      	   var rows=6-jsonResponse.length;
      		for(var p=0;p<rows;p++){
      			tableContent=tableContent+'	<tr height="35px" style="color: black">';
      			tableContent=tableContent+'<td bgcolor="white">&nbsp;</td>';
      			tableContent=tableContent+'<td bgcolor="white">&nbsp;</td>';
      			tableContent=tableContent+'<td bgcolor="white">&nbsp;</td>';
      			tableContent=tableContent+'<td bgcolor="white">&nbsp;</td>';
      			tableContent=tableContent+'<td bgcolor="white">&nbsp;</td>';
      			tableContent=tableContent+'<td bgcolor="white">&nbsp;</td>';
      			tableContent=tableContent+'<td bgcolor="white">&nbsp;</td>';
      			tableContent=tableContent+'<td bgcolor="white">&nbsp;</td>';
      			tableContent=tableContent+'<td bgcolor="white">&nbsp;</td>';
      			tableContent=tableContent+'</tr>';
      		}
      		
      	
      	tableContent=tableContent+'<tr height="35px" style="color: white; background-color: white; vertical-align: middle;" align="center">';
      	$("#tab1").html(tableContent);
      	$('.bloading').loading('hide');
		}
		
	});//end of getJSON
}

 $(document).ready(function(){
	 $("#testName").change(function(){
			loadData();	
		});
		$("#techName").change(function(){
			var techName=$(this).val();
			var ccontextPath="${pageContext.request.contextPath}";
			 $.getJSON(ccontextPath+"/action/findConfigureTestsByTechName", {techName:techName}, function(jsonResponse) {
				 	console.log(jsonResponse);
				 	$('#testName').empty()
				 	if(jsonResponse.length>0){
				 		 $.each(jsonResponse, function(i, item) {
				 			$("#testName").append($("<option />").val(item).text(item));
				 		});
				 	}
				 	loadData();	
			 }//end of the callback function..................
			 );
		});		
		
		//Loading the data when page is loaded first time.........
		loadData();
 });

$("#selectedGroupName").change(function() {
	loadData();
});


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