<%@page import="java.util.List"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <title>${companyName} - Send Test Link</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon-96x96.png"/>
    <!-- Google font -->
     <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
    <%@include file="/resources.jsp" %>
    
    <title>${companyName} - Send Exam Link</title>
    <style>
<!--
input[type="checkbox"] { -webkit-appearance: checkbox; }
input[type="radio"] { -webkit-appearance: radio; }
input[type="submit"], input[type="button"] { -webkit-appearance: button; }
select { -webkit-appearance:textfield; }
-->
 </style>
    
    <script type="text/javascript">
  	 var ccontextPath="${pageContext.request.contextPath}";
     function loadData() {
    		var batch=$("#selectedGroupName").val();
    		var tableContent='';
    		tableContent=tableContent+'<tr style="color: white; background-color: #607D8B; vertical-align: middle;"align="center">';
    		tableContent=tableContent+'<td width="10px"><b>SNO.</b></td>';
    		tableContent=tableContent+'<td width="240px"><b>Consultant Id</b></td>';
    		tableContent=tableContent+'<td><b>Name</b></td>';
    		tableContent=tableContent+'<td><b>Email</b></td>';
    		tableContent=tableContent+'<td><b>Batch</b></td>';
    		tableContent=tableContent+'<td><b>Photo</b></td>';
    		tableContent=tableContent+'<td><b>OP</b>';
    		tableContent=tableContent+'<input type="checkbox" name="selectAllUserID"  checked="checked" onClick="selectAll(this)"/></td>';
    		tableContent=tableContent+'</tr>';
    		var value;
    		var imageURL="action/findConsultantImage";
    		$.getJSON(ccontextPath+'/action/load-consultant-batch-testName',{batch:batch},function(jsonResponse){
    			var len=jsonResponse.length;
    			$("input[type='hidden'][name='NoOfUsers']").val(len);
    			for(var i=0;i<jsonResponse.length;i++){
    				value=i+1;
    				tableContent=tableContent+'<tr style="color: black; vertical-align: middle;">';
    				tableContent=tableContent+'<td align="center">'+value+'</td>';
    				tableContent=tableContent+'<td>'+jsonResponse[i].loginid+'</td>';
    				tableContent=tableContent+'<td>'+jsonResponse[i].firstName+jsonResponse[i].lastName+'</td>';
    				tableContent=tableContent+'<td>'+jsonResponse[i].email+'</td>';
    				tableContent=tableContent+'<td>'+batch+'</td>';
    				tableContent=tableContent+'<td><img src="'+ccontextPath+'/action/findConsultantImage?userid='+jsonResponse[i].loginid+'" style="height:40px;"/></td>';
    				tableContent=tableContent+'<td><input type="checkbox" name="userCb" id="userCb" value="'+jsonResponse[i].loginid+'" checked="checked"/></td>';
    				tableContent=tableContent+'</tr>';
    			}
    			for(var p=0;p<5;p++){
    			tableContent=tableContent+'<tr  style="color: black">';
    			tableContent=tableContent+'<td bgcolor="white">&nbsp;</td>';
    			tableContent=tableContent+'<td bgcolor="white">&nbsp;</td>';
    			tableContent=tableContent+'<td bgcolor="white">&nbsp;</td>';
    			tableContent=tableContent+'<td bgcolor="white">&nbsp;</td>';
    			tableContent=tableContent+'<td bgcolor="white">&nbsp;</td>';
    			tableContent=tableContent+'<td bgcolor="white">&nbsp;</td>';
    			tableContent=tableContent+'<td>&nbsp;</td>';
    			tableContent=tableContent+'</tr>';
    			}
    			

    			
    			$("#tbl1").html(tableContent);
    			$("#selectedUsers").html(len);
    			$("#showBatch").html(batch);
    			
    		});
     }
    
$(document).ready(function() {
		$("input[type='button'][id='loadUserBtn']").click(function() {
					$("#sendLinkToUserFrom").attr('action','${pageContext.request.contextPath}/action/loadSendExamLink');
					$("#sendLinkToUserFrom").submit();
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
				 }//end of the callback function..................
				 );
			});		
			
			
		$("#selectedGroupName").change(function(){
				loadData();
		});

  	 $("input[type='button'][id='sendLinkId']").click(function() {
  		 	var NoOfUsers=$("input[type='hidden'][name='NoOfUsers']").val();
  			if(NoOfUsers==0){
  					$("AppMessage").html("Users List cannot be empty to send the tech exam link");
  					return;
  			}
  			 if($("input[type='checkbox'][id$='userCb']").is(':checked')){
  				 
  			 }else{
  				$("AppMessage").html("Users List cannot be empty to send the tech exam link");
  				return;
  			 }
  			$("#sendLinkToUserFrom").submit();		
	 });
  	 //loading the data when page is getting loaded
  	loadData();
});

function sendTestLink() {
	var NoOfUsers=$("input[type='hidden'][name='NoOfUsers']").val();
		  if(NoOfUsers==0) {
				alert("Users List cannot be empty to send the link for users.");
				return;
		 }
		 if($("input[type='checkbox'][id$='userCb']").is(':checked')) {
			 
		 }else{
			alert("Please select a least one consultant from user list to send the test link.");
			return;
		 }
		$("#sendLinkToUserFrom").submit();		
}

</script>
<script type="text/javascript">
	function selectAll(source) {
		checkboxes = document.getElementsByName('userCb');
		var count=0; 
		for(var i in checkboxes){
			if(source.checked) {
				count++;
			}
			checkboxes[i].checked = source.checked;
		}
	 		$("#selectedUsers").html(count);
	}
</script>
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
  <section style="padding-top: 0px;background-color: #eee;" id="content">
  		<section style="height: 10px;background-color: #eee;width: 100px;">
   		</section>
        <div class="container" style="background-color: white;">
                <h3 style="color: black"><img src="${pageContext.request.contextPath}/images/configure.png" width="20px;"/> - <span style="font-family: 'Lato', sans-serif;font-size: 16px;">Send Exam Link Page</span></h3> 
            <form id="sendLinkToUserFrom"
							action="${pageContext.request.contextPath}/action/sendExamLink"
							method="post">
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
							
							&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 
								<hr/>
								<span id="AppMessage" style="color:red;font-size: 15px;"></span>
							<img src="${pageContext.request.contextPath}/images/icon/user-icon.png" width="30px;"/>
							<span style="font-family: 'Lato', sans-serif;font-size: 14px;">User List:-</span><span id="showBatch">(${param.selectedGroupName}${dgname})</span></b>
							<div style="float: right;">
								<img src="${pageContext.request.contextPath}/images/favicon.ico" width="25px;"/>
								<span style="font-family: 'Lato', sans-serif;font-size: 14px;">Total Users :</span> <b><span id="selectedUsers">${fn:length(users)}</span></b>
							</div>

            <div class="table-student-submission">
                <table class="table  table-bordered" width="100%" id="tbl1" style="margin-bottom: 0px;">
                    <thead>
                        <tr style="background-color: #607D8B;">
                            <th class="submissions" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">SNo</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Name</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Email</th>
                            <th class="score" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">LoginId</th>
                            <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Batch </th>
                         	<th style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Photo</th>
                         	<th style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">OP
                         	<input type="checkbox" name="selectAllUserID"  checked="checked"/>
                         	</th>
                        </tr>
                    </thead>

                    <tbody>
										<tr  style="color: black">
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr style="color: black">
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr  style="color: black">
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr  style="color: black">
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr style="color: black">
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr style="color: black">
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr style="color: black">
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr style="color: black">
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr style="color: black">
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr style="color: black">
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
                    </tbody>
                </table>
    			<input type="button"	value="Send Link"	 class="mc-btn btn-style-1"	id="sendLinkId"  onclick="sendTestLink();"/>
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