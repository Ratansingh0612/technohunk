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
    <title>${companyName} - Assign Test Group</title>
    
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
    <section class="quizz-intro-section" style="padding-top: 0px;padding-bottom:10px;background-color: #eee;min-height: 600px;" id="content">
<!--   <section style="padding-top: 0px;padding-bottom:10px;background-color: white;" id="quizz-intro-section"> -->
		 <hr/>
        <div class="container" style="background-color: white;"> 
 <form id="assignTestToUserFrom"
							action="${pageContext.request.contextPath}/action/assignTestToUser"
							method="post">	
                				<h3 style="color: black;margin-top: -5px;"><img src="${pageContext.request.contextPath}/images/icon/Icon_01.png" width="40px;"/> - <span style="font-size: 16px;">Test - > Assign Test To Group</span></h3> 
								<div class="col-xs-4">
								<label for="Group" style="font-family: 'Lato', sans-serif;font-size: 16px;"> Group/Batch :</label>
								<select class="form-control" name="selectedGroupName" id="selectedGroupName" style="width:250px;">
							<%-- 	<c:forEach var="groupName" items="${userGroupList}">
							 --%>	   <%
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
						 </select> 
						 </div>
							
								<div class="col-xs-4">
								<label for="techName" style="font-family: 'Lato', sans-serif;font-size: 16px;">Technology :</label>
								<select
								name="techName"  id="techName" class="form-control" style="display: inline;">
								<k:forEach var="techName" items="${techNames}">
									<option value="${techName}">${techName}</option>
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
					 

			<hr style="border-top: 1px solid #00233c21;margin-top: 0px"/>
				Test Validity(Hrs.)  : <input	name="validity"  id="validity" class="form-control" style="display: inline;width: 100px;margin-right: 215px;" value="1000"/> 
								<input type="button" value="Assign Test To Group" class="mc-btn btn-style-1" id="assignTestID" style="margin-top: -30px;" />
			 		<hr style="border-top: 1px solid #00233c21;margin-bottom: 10px"/>
			<span id="AppMessage" style="color:blue;font-size: 15px;"></span>
			<br/>
            <div class="table-student-submission">
             <img src="${pageContext.request.contextPath}/images/user1.png" width="20px;"/>
					    <span style="font-family: 'Lato', sans-serif;font-size: 16px;">Consultant(s) List</span>
					     &nbsp;&nbsp;&nbsp;  
                            <a href="${pageContext.request.contextPath}/action/adminAvailableQuestionsBankTest">
                            </a>
					    <div style="float: right;">
<%-- 					    	  <span style="font-family: 'Lato', sans-serif;font-size: 16px;margin-right: 100px;"> Selected Consultant(s) : <span id="selectedUsers">${fn:length(userList)}</span></span>	
 --%>                            <span style="font-family: 'Lato', sans-serif;font-size: 16px;">Total Consultant : <span id="totalUser">${fn:length(userList)}</span></span>
                             </div> 
                
               
							<input type="hidden" name="NoOfUsers" value="${fn:length(userList)}" /> <br /> 
                <table class="table table-bordered" id="tab1">
                    <thead>
                        <tr style="background-color: #607D8B;">
                            <th class="submissions" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">SNo</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Name</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Email </th>
                            <th class="score" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Batch </th>
                            <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Photo</th>
                       			<td width="50px">
									<input type="checkbox" name="selectAllUserID"   onClick="selectAll(this)" checked="checked"/>
									</td>	
                        </tr>
                    </thead>

                    <tbody>
					   
					      <tr height="35px" style="color: black">
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
								</tr>
								<tr height="35px" style="color: black">
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
								</tr>
								<tr height="35px" style="color: black">
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									
								</tr>
                    </tbody>
                </table>
							<div  style="margin-top: -60px;">
								<input type="button" value="Assign Test To Group" class="mc-btn btn-style-1" id="assignTestID" />
							</div>
            </div>
</form>
            
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
	function pchecked(t){
		var count=0;
        if (t.checked) {
        	count=$("#selectedUsers").html();
        	count=parseInt(count)+1; 
        }else{
        	count=$("#selectedUsers").html();
        	count=parseInt(count)-1; 
        }
        $("#selectedUsers").html(count);
        $("#selectAllUserID").removeAttr('checked');
	}

	function loadData(){
		var ccontextPath="${pageContext.request.contextPath}";
  		var userRole="${sessionScope.user_session_data.role}";
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
              	tableContent=tableContent+'<th class="score" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Consultant Id </th>';
              	tableContent=tableContent+'<th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Name</th>';
              	tableContent=tableContent+' <th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Email </th>';
              	tableContent=tableContent+'<th class="score" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Userid </th>';
              	tableContent=tableContent+'<th class="submit-date" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Photo</th>';
             // 	tableContent=tableContent+'<td width="50px">';
              //	tableContent=tableContent+'<input type="checkbox" name="selectAllUserID"   onClick="selectAll(this)" checked="checked"/>';
              //	tableContent=tableContent+'</td>';	
              	tableContent=tableContent+'</tr>';
              	tableContent=tableContent+' </thead>';
              	$("#selectedUsers").html(len);
              	
              	if(len>0){
              		
		              	for(var i=0;i<len;i++){
		              			val=i+1;
		              				
		              				tableContent=tableContent+'<tr height="35px" style="color: black; vertical-align: middle;">';
		              				tableContent=tableContent+'<td align="center">';
		              				tableContent=tableContent+'<input type="hidden" name="userCb" value="'+jsonResponse[i].loginid+'"/>';
		              				tableContent=tableContent+val+'</td>';
		              				tableContent=tableContent+'<td >&nbsp;&nbsp;&nbsp;'+jsonResponse[i].loginid+'</td>';
		              				tableContent=tableContent+'<td >&nbsp;&nbsp;&nbsp;'+jsonResponse[i].firstName+'</td>';
		              				tableContent=tableContent+'<td >&nbsp;&nbsp;&nbsp;'+jsonResponse[i].email+'</td>';
		              				tableContent=tableContent+'<td >&nbsp;&nbsp;&nbsp;'+jsonResponse[i].loginid+'</td>';
		              				var imageURI="";
		              				if(userRole=="admin") {
		              					 imageURI='${pageContext.request.contextPath}/action/imageByUserId?userid='+jsonResponse[i].loginid;
		              				}
		              				else if(userRole=="trainer") {
		              					 imageURI='${pageContext.request.contextPath}/action/findConsultantImage?userid='+jsonResponse[i].loginid;
		              				}
		              				tableContent=tableContent+'<td align="center"><img src="'+imageURI+'" height="30px" /></td>';
									//tableContent=tableContent+'<td align="center"><input type="checkbox" name="userCb" id="userCb" value="'+jsonResponse[i].loginid+'" checked="checked" onclick="pchecked(this)"/></td>';
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
              			//tableContent=tableContent+'<td bgcolor="white">&nbsp;</td>';
              			tableContent=tableContent+'</tr>';
              		}
              		
              	
              	tableContent=tableContent+'<tr height="35px" style="color: white; background-color: white; vertical-align: middle;" align="center">';
              	$("#tab1").html(tableContent);
  			}
  			
  		});//end of getJSON
  		
  		$("#AppMessage").html("");
	}
	
$(document).ready(function() {
	
	$("input[type='checkbox'][name='userCb']").click(function() {
		alert("::::");
		
    });
	
		//alert("good morning!");
  	 $("#assignTestID").click(function() {
  			//var NoOfUsers=$("input[type='hidden'][name='NoOfUsers']").val();
  			 var NoOfUsers=$("#selectedUsers").html();
  		  	 if(parseInt(NoOfUsers)==0){
  					$("#AppMessage").html("Users List cannot be empty for the assigned test.");
  					 window.scrollTo(0, 0);
  					return;
 	 		 }
  		  	 var validity=$("#validity").val();
  		  	 if(validity.length==0){
  		 		 	 $("#AppMessage").html("Validity of test cannot be empty , please specify number of hrs.<br/>");		
  		 		 	 $("#validity").focus();
  		 		 	 return;	
  		  	 }
  			 var ccontextPath="${pageContext.request.contextPath}";
  		  	 var groupName=$("#selectedGroupName").val();
  			 var testName=$("#testName").val();
  			 var techName=$("#techName").val();
  			 $.getJSON(ccontextPath+"/action/check-assign-test-group", {techName:techName,testName:testName,groupName:groupName}, function(jsonResponse) {
  					 console.log("_@)jsonResponse.status @) = "+jsonResponse.status);
  				 	 if(jsonResponse.status=='yes') {
  				 		 $("#AppMessage").html("Sorry this test \""+testName +"\" is already assigned to this group .<br/>");		
  				 		 window.scrollTo(0, 0);
  				 	 } 
  				 	else {
  				 	 	$("#assignTestToUserFrom").submit();		
  				 	 	// what are the values going to controller ??
  				 	 }
  			 });
  				
   });
  	 
  	$("#loadUsersId").click(function() {
  				$("#assignTestToUserFrom").attr('action','${pageContext.request.contextPath}/action/loadGroupUsers');
				$("#assignTestToUserFrom").submit();
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
		 }//end of the callback function..................
		 );
	});		
  	
  	$("#testName").change(function() {
		$("#AppMessage").html("");
  	});
  	
	$("#selectedGroupName").change(function() {
		$("#AppMessage").html("");
		loadData();
  	});
	//Load the data when page is loaded first time...
	loadData();
	
});
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
		if(count!=0){
			$("#selectedUsers").html($("#totalUser").html());
		}else {
	 		$("#selectedUsers").html(count);
		}
	}
</script>

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