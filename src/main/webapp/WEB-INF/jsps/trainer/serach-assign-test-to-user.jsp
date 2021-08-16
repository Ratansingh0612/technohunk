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
    <title>${companyName} - Search & Assign Test User</title>
    
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
    <section class="quizz-intro-section" style="padding-top: 0px;padding-bottom:10px;background-color: #fdfff3;min-height: 600px;" id="content">
<!--   <section style="padding-top: 0px;padding-bottom:10px;background-color: white;" id="quizz-intro-section"> -->
        <div class="container" style="background-color: #fff7f8;">
 <form id="assignTestToUserFrom"
							action="${pageContext.request.contextPath}/action/serach-assign-test-to-user"
							method="post">	
                <h3 style="color: black"><img src="${pageContext.request.contextPath}/images/icon/search-globe.ico" width="50px;"/>&nbsp;&nbsp;<b style="font-size: 16px;">Test - > Search & Assign Test To User</b></h3> 
             					
             						<hr style="border-top: 1px solid #a9a9a9;margin-top: 0px"/>
             					<div class="col-xs-6">
								<label for="techName" style="font-size: 15px;">Technology :</label>
								<select
								name="techName"  id="techName" class="form-control" style="display: inline;">
								<k:forEach var="techName" items="${techNames}">
									<option value="${techName}">${techName}</option>
								</k:forEach>
							</select> 
							</div>
							<div class="col-xs-6">
								<label for="testName" style="font-size: 15px;">Test Name :</label>
								<select
								name="testName"  id="testName" class="form-control" style="display: inline;">
								<k:forEach var="testname" items="${testNames}">
									<option value="${testname}">${testname}</option>
								</k:forEach>
							</select> 
							</div>
						 <div class="col-xs-12" style="margin-top: 20px;">
						<label for="searchConsultant" style="font-size: 15px;margin-right: 20px;">Consultant Name/Email</label>		
						   &nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp; 
						 <input type="text" name="searchConsultant" id="searchKey" class="form-control" style="width:300px;display:inline;">
						   &nbsp;&nbsp;&nbsp; 
						   <label for="Go" style="font-family: 'Lato', sans-serif;font-size: 15px;"></label>
						 <input type="button" value="Search" class="mc-btn btn-style-1"  id="goID" />
						   &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 
						    <input type="button" value="Clear" class="mc-btn btn-style-1"  id="clearSearch"  onclick="window.location.assign('${pageContext.request.contextPath}/action/serach-assign-test-to-user');"/>
						   &nbsp;&nbsp;&nbsp; 
						</div>
							<hr style="border-top: 1px solid #a9a9a9;margin-top: 0px"/>
								
							 <br/> 
							&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 
							<br/>		

			<hr style="border-top: 1px solid #a9a9a9;margin-top: 0px"/>
			<span id="AppMessage" style="color:blue;font-size: 15px;"></span>
            <div class="table-student-submission">
             <img src="${pageContext.request.contextPath}/images/icon/exam.png" width="40px;"/>
					    <b style="font-family: 'Lato', sans-serif;font-size: 14px;">Search Result(s)</b>
					     &nbsp;&nbsp;&nbsp;  
                            <a href="${pageContext.request.contextPath}/action/adminAvailableQuestionsBankTest">
                            </a>
					    <div style="float: right;">
                            <b style="font-family: 'Lato', sans-serif;font-size: 14px;">Total Result(s) : <span id="totalUser">${fn:length(userList)}</span></b>
                             </div> 
                
               
							<input type="hidden" name="NoOfUsers" value="${fn:length(userList)}" /> <br /> 
                <table class="table table-bordered" id="tab1">
                    <thead>
                        <tr style="background-color: #1192ea;">
                            <th class="submissions" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">SNo</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Name</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Email </th>
                            <th class="score" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Batch </th>
                            <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Photo</th>
                       			<td width="50px">
									<input type="checkbox" name="selectAllUserID"   onClick="selectAll(this)"/>
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
							<div style="float: right;">
								<input type="button" value="Assign Test To Consultant" class="mc-btn btn-style-1" id="assignTestID" />
							</div>
							  Selected User(s) :<span id="selectedUsers">${fn:length(userList)}</span>
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
		 var userid=$(t).val();
		var count=0;
        if (t.checked) {
        	count=$("#selectedUsers").html();
        	count=parseInt(count)+1; 
        	 var ccontextPath="${pageContext.request.contextPath}";
			 var testName=$("#testName").val();
			 var techName=$("#techName").val();
			 $.getJSON(ccontextPath+"/action/check-assign-test-consultant", {techName:techName,testName:testName,userid:userid}, function(jsonResponse) {
					 console.log("_@)jsonResponse.status @) = "+jsonResponse.status);
				 	 if(jsonResponse.status=='yes') {
				 		 $("#AppMessage").html("Sorry this test \""+testName +"\" is already assigned to this consultant "+userid+" .<br/>");		
				 		// window.scrollTo(0, 0);
				 	 } 
				 	else {
				 		$("#AppMessage").html("Yes this test \""+testName +"\" is can be assigned to this consultant "+userid+" .<br/>");		
				 	 }
			 });
        }else{
        	$("#AppMessage").html("");
        	count=$("#selectedUsers").html();
        	count=parseInt(count)-1; 
        }
        $("#selectedUsers").html(count);
        $("#selectAllUserID").removeAttr('checked');
	}

	
//************************************************My Code********************************************************************
	$("#goID").click(function() {
	var searchKey = $("#searchKey").val();
	var ccontextPath="${pageContext.request.contextPath}";
	//var groupName=$("#selectedGroupName").val();
	var userRole="${sessionScope.user_session_data.role}";
	$.getJSON(ccontextPath+"/action/findAllConsultantsWithSearchString", {searchKey:searchKey},function(jsonResponse){
		console.log("JSON Data: "+jsonResponse);
		var tableContent = "";
		if(jsonResponse) {
				var len = jsonResponse.length;
          	var tableContent='';
          	var val;
          	$("#totalUser").html(len);
          	tableContent=tableContent+' <thead>';
          	tableContent=tableContent+' <tr style="background-color: #1192ea;">';
          	tableContent=tableContent+'<th class="submissions" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">SNo</th>';
          	tableContent=tableContent+'<th class="score" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Consultant Id </th>';
          	tableContent=tableContent+'<th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Name</th>';
          	tableContent=tableContent+' <th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Email </th>';
          	tableContent=tableContent+'<th class="score" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Userid </th>';
          	tableContent=tableContent+'<th class="submit-date" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Photo</th>';
          	tableContent=tableContent+'<td width="50px">';
          	tableContent=tableContent+'<input type="checkbox" name="selectAllUserID"   onClick="selectAll(this)"/>';
          	tableContent=tableContent+'</td>';	
          	tableContent=tableContent+'</tr>';
          	tableContent=tableContent+' </thead>';
          	$("#selectedUsers").html("0");
    if(len>0){
		for(var row=0; row<jsonResponse.length;row++)
			{
			tableContent=tableContent+'<tr height="35px" style="color: black; vertical-align: middle;">';
tableContent=tableContent+'<td align="center">'+(row+1)+'</td>';
tableContent=tableContent+'<td >&nbsp;&nbsp;&nbsp;'+jsonResponse[row].empid+'</td>';
tableContent=tableContent+'<td >&nbsp;&nbsp;&nbsp;'+jsonResponse[row].firstName+'</td>';
tableContent=tableContent+'<td >&nbsp;&nbsp;&nbsp;'+jsonResponse[row].email+'</td>';
tableContent=tableContent+'<td >&nbsp;&nbsp;&nbsp;'+jsonResponse[row].loginid+'</td>';
var imageURI="";
if(userRole=="admin") {
	 imageURI='${pageContext.request.contextPath}/action/imageByUserId?userid='+jsonResponse[row].loginid;
}
else if(userRole=="trainer") {
	 imageURI='${pageContext.request.contextPath}/action/findConsultantImage?userid='+jsonResponse[row].loginid;
}
tableContent=tableContent+'<td align="center"><img src="'+imageURI+'" height="30px" /></td>';
tableContent=tableContent+'<td align="center"><input type="checkbox" name="userCb" id="userCb" value="'+jsonResponse[row].loginid+'"  onclick="pchecked(this)"/></td>';
tableContent=tableContent+'</tr>';
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
	});
	
});
	
	
	
	
	
	
	
	
//************************************************End of Code********************************************************************
	
	
$(document).ready(function() {
	
	$("input[type='checkbox'][name='userCb']").click(function() {
		alert("::::");
		
    });
	
		//alert("good morning!");
  	 $("#assignTestID").click(function() {
  			//var NoOfUsers=$("input[type='hidden'][name='NoOfUsers']").val();
  			 var NoOfUsers=$("#selectedUsers").html();
  		  	 if(parseInt(NoOfUsers)==0){
  					$("#AppMessage").html("Please select at aleast once consultant to assign the selected test.");
  					 window.scrollTo(0, 0);
  					return;
 	 		 }
  			$("#assignTestToUserFrom").submit();		
  				
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
		 $("#userCb").removeAttr('checked');
	});		
  	
  	$("#testName").change(function() {
		$("#AppMessage").html("");
		 $("#userCb").removeAttr('checked');
  	});
  	
	//Load the data when page is loaded first time...
	//loadData();
	
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