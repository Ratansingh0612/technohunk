<%@page import="java.util.List"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from envato.megadrupal.com/html/megacourse/account-assignment.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 19 Mar 2017 04:41:35 GMT -->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <title>${companyName} - Reset Consultant Test</title>
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


 <form  id="resetConsultantGroupTestForm" action="${pageContext.request.contextPath}/action/consultant-group-test-reset" method="post">
			 <input type="hidden" name="groupName" id="ggroupName"/>
			 <input type="hidden" name="testName" id="gtestName"/>
			 <input type="hidden" name="techName" id="gtechName"/>
			 <input type="hidden" name="trainerid" id="gtrainerid"/>
			 <input type="hidden" name="withHistory" id="gwithHistory"/>
</form>

 <form  id="resetTestForm" action="${pageContext.request.contextPath}/action/reset-user-test" method="post">
			 <input type="hidden" name="hTestName"/>
			 <input type="hidden" name="huserId"/>
</form>

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
     <k:if test="${sessionScope.user_session_data.role=='trainer'}">	
      <%@include file="../trainer/theader.jsp"%>
      </k:if>
        <k:if test="${sessionScope.user_session_data.role=='admin'}">	
       <%@include file="aheader.jsp"%>
       </k:if>
    <!-- END / HEADER -->


    <!-- PROFILE FEATURE -->
    <%@include file="profile-feature.jsp" %>
    <!-- END / PROFILE FEATURE -->


    <!-- CONTEN BAR -->
   <!-- END / CONTENT BAR -->
 
    <!-- COURSE CONCERN -->
  <section style="padding-top: 0px;padding-bottom:10px;background-color: #eee;" id="quizz-intro-section" class="quizz-intro-section learn-section">
		<hr/>        
        <div class="container" style="background-color: white;">
                <h3 style="color: black"><img src="${pageContext.request.contextPath}/images/group-icon.png" style="height: 60px;"/> - <span style="font-family: 'Lato', sans-serif;font-size: 16px;margin-right: 55%">Reset Group Consultant Test Page</span><input type="button"  onclick="resetTestForWholeGroup();"  value="Reset Group Test" class="mc-btn btn-style-1" id="resetGroupTest"/></h3> 
									<hr style="color: blue" />
								
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
								 <form id="consultantTestResetForm"
							action="${pageContext.request.contextPath}/action/consultantTestReset"
							method="post">
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
								 <br/>	 <br/>	
								<hr style="color: blue" />
							<!-- <input style="margin-top:25px;"
							type="button" value="Load Users" class="btn btn-primary" id="loadUsersId" /> -->
					
                <img	src="${pageContext.request.contextPath}/images/not-assigned.png" width="24" height="24"/>
                Test is assigned but not started
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 <img	src="${pageContext.request.contextPath}/images/with-history.png" width="24" height="24"/>
                   Reset Complete Test with History
                   
                     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <img	src="${pageContext.request.contextPath}/images/reset.png" width="24" height="24"/>
                  Reset Test with out deleting history...
                  
                  
                     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <img	src="${pageContext.request.contextPath}/images/not-started.png" width="24" height="24"/>
                  Assign  Test to consultant
                  
							<div style="margin-top:-5px;margin-left:1035px;">
								 
							</div>
							<hr style="color: blue" />
				<span id="AppMessage" style="color: blue;font-size: 18px;">${ApplicationMessage}</span>		 
		<hr style="color: blue" />
             <img src="${pageContext.request.contextPath}/images/icon/user-icon.png" width="30px;"/>
					    <b style="font-family: 'Lato', sans-serif;font-size: 14px;">User(s) List</b>
					     &nbsp;&nbsp;&nbsp;  
                            <a href="${pageContext.request.contextPath}/action/adminAvailableQuestionsBankTest">
                            </a>
					    <div style="float: right;">
                            <b style="font-family: 'Lato', sans-serif;font-size: 14px;">Total Users : <span id="totalUser">${fn:length(userList)}</span></b>
                             </div> 
                <table class="table table-bordered" id="tab1">
                    <thead>
                        <tr style="background-color: #607D8B;">
                            <th class="submissions" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">SNo</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Name</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Email </th>
                            <th class="score" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">User Id</th>
                            <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Photo</th>
                       			                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Test Status </th>
                       			<th style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Reset
                         	</th>
                       			
                    </thead>

                    <tbody>
					   
					      <tr height="35px" style="color: black">
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr height="35px" style="color: black">
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr height="35px" style="color: black">
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr height="35px" style="color: black">
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr height="35px" style="color: black">
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td>&nbsp;</td>
									
								</tr>


                    </tbody>
                </table>
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
var ccontextPath="${pageContext.request.contextPath}";
var userRole="${sessionScope.user_session_data.role}";
function loadData(){
	var groupName=$("#selectedGroupName").val();
	var testName=$("#testName").val();
	var techName=$("#techName").val();
  //$('body').prelodr('in', 'Loading data please wait...');
	$.getJSON(ccontextPath+"/action/findUserBygroupNameTestTechNameAjax", {groupName:groupName,testName:testName,techName:techName}, function(jsonResponse) {
		 //$('body').prelodr('out');
		if(jsonResponse) {
			var len = jsonResponse.length;
      	var tableContent='';
      	var val;
      	$("#totalUser").html(len);
      	tableContent=tableContent+' <thead>';
      	tableContent=tableContent+' <tr style="background-color: #607D8B;">';
      	tableContent=tableContent+'<th class="submissions" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">SNo</th>';
      	tableContent=tableContent+'<th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Name</th>';
      	tableContent=tableContent+' <th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Email </th>';
      	tableContent=tableContent+'<th class="score" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">User Id </th>';
      	tableContent=tableContent+'<th class="submit-date" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Photo</th>';
      	tableContent=tableContent+'<th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Test Status</th>';
    	tableContent=tableContent+'<th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Reset</th>';
        
      	tableContent=tableContent+'</tr>';
      	tableContent=tableContent+' </thead>';
      	$("#selectedUsers").html(len);
      	
      	if(len>0){
      		
      	for(var i=0;i<len;i++){
      			val=i+1;
      			//if(jsonResponse[i].assigned=='no'){
      				
      				tableContent=tableContent+'<tr height="35px" style="color: black; vertical-align: middle;">';
      				tableContent=tableContent+'<td align="center">'+val+'</td>';
      				tableContent=tableContent+'<td >&nbsp;&nbsp;&nbsp;'+jsonResponse[i].firstName+' '+jsonResponse[i].lastName+'</td>';
      				tableContent=tableContent+'<td >&nbsp;&nbsp;&nbsp;'+jsonResponse[i].email+'</td>';
      				tableContent=tableContent+'<td >&nbsp;&nbsp;&nbsp;'+jsonResponse[i].loginid+'</td>';
      				var imageURI="";
      				if(userRole=="admin") {
      					 imageURI='${pageContext.request.contextPath}/action/imageByUserId?userid='+jsonResponse[i].loginid;
      				}
      				else if(userRole=="trainer") {
      					 imageURI='${pageContext.request.contextPath}/action/findConsultantImage?userid='+jsonResponse[i].loginid;
      				}
      				tableContent=tableContent+'<td align="center"><img src="'+imageURI+'" style="height:30px" /></td>';
      				tableContent=tableContent+'<td align="center"  id="testStatus'+val+'">&nbsp;&nbsp;&nbsp;'+jsonResponse[i].techTestStatus+'</td>';
      				tableContent=tableContent+'<td align="center"  id="tdnum'+val+'">';
      				var testName="AAFSFSFSFS";
      				var jsmethod="<a id=\"resetHistoryIcon"+val+"\"" +" href=\"javascript:resetTestForUser('"+jsonResponse[i].loginid+"',"+val+");\"";
      				var jsmethodWithOutHistory="<a id=\"withoutHistoryIcon"+val+"\"" +"  href=\"javascript:resetTestForUserWithOutHistory('"+jsonResponse[i].loginid+"',"+val+");\"";
      				var assignjsmethod="<a href=\"javascript:assignTechTestForUser('"+jsonResponse[i].loginid+"',"+val+");\"";
      				if ("Completed".toLowerCase() === jsonResponse[i].techTestStatus.toLowerCase()){
      					tableContent=tableContent+jsmethod+'"><img	src="${pageContext.request.contextPath}/images/with-history.png" width="30" height="30" alt="Click Here to reset the test" id="imageId'+val+'"/></a>';
      					tableContent=tableContent+"&nbsp;&nbsp;&nbsp;&nbsp;"+jsmethodWithOutHistory+'"><img	src="${pageContext.request.contextPath}/images/reset.png" width="30" height="30" alt="Click Here to reset the test" id="imageId'+val+'"/></a>';
      				}else if ("Not Started".toLowerCase() === jsonResponse[i].techTestStatus.toLowerCase()){
      					tableContent=tableContent+'<img	src="${pageContext.request.contextPath}/images/not-assigned.png" width="24" height="24" alt="Click Here to reset the test" id="imageId'+val+'"/>';
      				}else if ("In progress".toLowerCase() === jsonResponse[i].techTestStatus.toLowerCase()){
      					tableContent=tableContent+jsmethod+'"><img	src="${pageContext.request.contextPath}/images/with-history.png" width="30" height="30" alt="Click Here to reset the test" id="imageId'+val+'"/></a>';
      					tableContent=tableContent+"&nbsp;&nbsp;&nbsp;&nbsp;"+jsmethodWithOutHistory+'"><img	src="${pageContext.request.contextPath}/images/reset.png" width="30" height="30" alt="Click Here to reset the test" id="imageId'+val+'"/></a>';
      				}else{
      					tableContent=tableContent+assignjsmethod+'"><img	src="${pageContext.request.contextPath}/images/not-started.png" width="24" height="24" alt="Click Here to reset the test" id="imageId'+val+'"/></a>';
      				}
      				tableContent=tableContent+'</td>';
      				tableContent=tableContent+'</tr>'
      			//}
      			
      			/* if(jsonResponse[i].assigned=="yes"){
      			
      				tableContent=tableContent+'<tr height="35px" style="color: black; vertical-align: middle;">';
      				tableContent=tableContent+'<td align="center">'+val+'</td>';
      				tableContent=tableContent+'<td >&nbsp;&nbsp;&nbsp;'+jsonResponse[i].name+'</td>';
      				tableContent=tableContent+'<td >&nbsp;&nbsp;&nbsp;'+jsonResponse[i].email+'</td>';
      				tableContent=tableContent+'<td >&nbsp;&nbsp;&nbsp;'+jsonResponse[i].loginid+'</td>';
      				var imageURI="";
      				if(userRole=="admin") {
      					 imageURI='${pageContext.request.contextPath}/action/imageByUserId?userid='+jsonResponse[i].loginid;
      				}
      				else if(userRole=="trainer") {
      					 imageURI='${pageContext.request.contextPath}/action/findConsultantImage?userid='+jsonResponse[i].loginid;
      				}
      				tableContent=tableContent+'<td align="center"><img src="'+imageURI+'" height="20px" style="height:20px;"/></td>';
      				tableContent=tableContent+'<td >&nbsp;&nbsp;&nbsp;'+jsonResponse[i].techTestStatus+'</td>';
      				tableContent=tableContent+'<td align="center">';
      				var testName="AAFSFSFSFS";
      				var jsmethod="<a href=\"javascript:resetTestForUser('"+jsonResponse[i].loginid+"');\"";
      				tableContent=tableContent+jsmethod+'"><img	src="${pageContext.request.contextPath}/images/reset.png" width="24" height="24" alt="Click Here to reset the test"/></a>';
      				tableContent=tableContent+'</td>';
      				tableContent=tableContent+'</tr>'
      			} */
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
      			tableContent=tableContent+'</tr>';
      		}
      		
      	
      	tableContent=tableContent+'<tr height="35px" style="color: white; background-color: white; vertical-align: middle;" align="center">';
      	$("#tab1").html(tableContent);
		}
		
	});//end of getJSON
}

$("#selectedGroupName").change(function() {
	 $("#AppMessage").html("");
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
<script type="text/javascript">

function resetTestForWholeGroup() {
	var totalUsers=$("#totalUser").html();
	var nou=parseInt(totalUsers);
	if(nou==0){
		$("#AppMessage").html("Sorry , No consultant is  selected to reset the test.");
		return;
	}
	var groupName=$("#selectedGroupName").val();
	var testName=$("#testName").val();
	var techName=$("#techName").val();
	 var yesno=confirm("Are you sure want to reset whole group test with group name "+groupName);	
	 if(yesno) {
	 	$("#ggroupName").val(groupName);
	 	$("#gtestName").val(testName);
	 	$("#gtechName").val(techName);
	 	$("#gwithHistory").val("yes");
	 	$("#resetConsultantGroupTestForm").submit();
	 }
}

function assignTechTestForUser(userid,rownum) {
	var groupName=$("#selectedGroupName").val();
	var testName=$("#testName").val();
	var techName=$("#techName").val();
	var ccontextPath="${pageContext.request.contextPath}";
	 $.getJSON(ccontextPath+"/action/assign-consultant-tech-test", { testName: testName,techName:techName,batchName:groupName,consultantid:userid}, function(jsonResponse) {
		 $("#imageId"+rownum).attr("src",ccontextPath+"/images/not-started.png");
		 $("#testStatus"+rownum).html("&nbsp;&nbsp;&nbsp;Not Started");
		 $("#withoutHistoryIcon"+rownum).hide();
		 $("#AppMessage").html("Test "+testName+"  has been assigned successfully to the user "+userid);
	 }//end of the callback function..................
	);
}

	function resetTestForUser(userid,rownum) {
		var groupName=$("#selectedGroupName").val();
		var testName=$("#testName").val();
		var techName=$("#techName").val();
		var ccontextPath="${pageContext.request.contextPath}";
		 $.getJSON(ccontextPath+"/action/reset-consultant-test-ajax", { testName: testName,techName:techName,batchName:groupName,consultantid:userid,withHistory:"yes"}, function(jsonResponse) {
			 $("#imageId"+rownum).attr("src",ccontextPath+"/images/not-assigned.png");
			 $("#imageId"+rownum).attr("height","24px;");
			 $("#withoutHistoryIcon"+rownum).hide();
			 $("#resetHistoryIcon"+rownum).attr("href", "javascript:;");
			 $("#testStatus"+rownum).html("Not Started");
			 $("#AppMessage").html("Test "+testName+"  has been reset successfully for "+userid);
		 	 
		 }//end of the callback function..................
		 );
	}
	function resetTestForUserWithOutHistory(userid,rownum) {
		var groupName=$("#selectedGroupName").val();
		var testName=$("#testName").val();
		var techName=$("#techName").val();
		var ccontextPath="${pageContext.request.contextPath}";
		 $.getJSON(ccontextPath+"/action/reset-consultant-test-ajax", { testName: testName,techName:techName,batchName:groupName,consultantid:userid,withHistory:"no"}, function(jsonResponse) {
			 $("#imageId"+rownum).attr("src",ccontextPath+"/images/not-assigned.png");
			 $("#imageId"+rownum).attr("height","24px;");
			 $("#withoutHistoryIcon"+rownum).hide();
			 $("#resetHistoryIcon"+rownum).attr("href", "javascript:;");
			 $("#testStatus"+rownum).html("Not Started");
			 $("#AppMessage").html("Test "+testName+"  has been reset successfully for "+userid);
		 }//end of the callback function..................
		 );
	}

	$(document).ready(function(){
		$("#testName").change(function(){
			 $("#AppMessage").html("");
			loadData();	
		});
		$("#techName").change(function(){
			 $("#AppMessage").html("");
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
		loadData();	
	});


</script>
</body>

</html>