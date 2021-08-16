<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <title>${companyName} - Search Consultants</title>
    
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
    <section class="quizz-intro-section" style="padding-top: 0px;padding-bottom:10px;background-color: #eee;" id="content">
 <section style="height: 10px;background-color: #eee;width: 100px;">
   		</section>
        <div class="container" style="background-color: white;min-height: 600px;">
 <form id="assignTestToUserFrom"
							action="${pageContext.request.contextPath}/action/search-assign-test-to-user"
							method="post">	
                <h3 style="color: black"><img src="${pageContext.request.contextPath}/images/icon/search-results.png" width="50px;"/>&nbsp;&nbsp;<span style="font-size: 16px;">Test - > Search Consultant Test History</span></h3> 
             					
						 <div class="col-xs-12" style="margin-top: 20px;">
						<label for="searchConsultant" style="font-size: 15px;margin-right: 20px;">Consultant Name/Email</label>		
						   &nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp; 
						 <input type="text" name="searchConsultant" id="searchKey" class="form-control" style="width:300px;display:inline;">
						   &nbsp;&nbsp;&nbsp; 
						   <label for="Go" style="font-family: 'Lato', sans-serif;font-size: 15px;"></label>
						 <input type="button" value="Search" class="mc-btn btn-style-1"  id="goID" />
						   &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 
						    <input type="button" value="Clear" class="mc-btn btn-style-1"  id="clearSearch"  onclick="window.location.assign('${pageContext.request.contextPath}/action/search-consultant-test-history');"/>
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
					    <span style="font-size: 14px;">Search Result(s)</span>
					     &nbsp;&nbsp;&nbsp;  
                            <a href="${pageContext.request.contextPath}/action/adminAvailableQuestionsBankTest">
                            </a>
					    <div style="float: right;">
                            <span style="font-size: 14px;">Total Result(s) : <span id="totalUser">${fn:length(userList)}</span></span>
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
								   <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Action</th>
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

	
  $(document).ready(function(){
	  
	  $("#searchKey").keyup(function(){
		  $("#AppMessage").html("");	
	  });
	  
	  
	$("#goID").click(function() {
	var searchKey = $("#searchKey").val();
	if(searchKey.length==0) {
		$("#AppMessage").html("Search string cannot be empty.....");	
		$("#searchKey").focus();
		return;
	}
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
          		tableContent=tableContent+' <tr style="background-color: #607D8B;">';
          		tableContent=tableContent+'<th class="submissions" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">SNo</th>';
          		tableContent=tableContent+'<th class="score" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Consultant Id </th>';
          		tableContent=tableContent+'<th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Name</th>';
          		tableContent=tableContent+'<th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Batch</th>';
          		tableContent=tableContent+' <th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Email </th>';
          		tableContent=tableContent+'<th class="score" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Userid </th>';
          		tableContent=tableContent+'<th class="submit-date" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Photo</th>';
        		tableContent=tableContent+'<th class="score" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Action </th>';
          		tableContent=tableContent+'</tr>';
          		tableContent=tableContent+' </thead>';
		    if(len>0)	{
					for(var row=0; row<jsonResponse.length;row++)
					{
							tableContent=tableContent+'<tr height="35px" style="color: black; vertical-align: middle;">';
							tableContent=tableContent+'<td align="center">'+(row+1)+'</td>';
							tableContent=tableContent+'<td >&nbsp;&nbsp;&nbsp;'+jsonResponse[row].empid+'</td>';
							tableContent=tableContent+'<td >&nbsp;&nbsp;&nbsp;'+jsonResponse[row].firstName+'</td>';
							tableContent=tableContent+'<td >&nbsp;&nbsp;&nbsp;'+jsonResponse[row].batch+'</td>';
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
							var jsmethod="<a href=\"javascript:editConsultant('"+jsonResponse[row].loginid+"');\"";
		      				tableContent=tableContent+'<td align="center">';
		      				tableContent=tableContent+jsmethod+'"><img	src="${pageContext.request.contextPath}/images/not-started.png" width="30" height="30"  id="imageId'+val+'"/></a>';
		      				tableContent=tableContent+'</td>';
							tableContent=tableContent+'</tr>';
					}
			}else {
				$("#AppMessage").html("Sorry! no record exists for search criteria "+searchKey+".<br/>");
				$("#searchKey").focus();
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
			  			tableContent=tableContent+'</tr>';
			  		}
		
				tableContent=tableContent+'<tr height="35px" style="color: white; background-color: white; vertical-align: middle;" align="center">';
				$("#tab1").html(tableContent);
		} //end of if response
	});
	});
	});	
  
  function showUserHistory(userid) {
  	$("#userid").val(userid);
  	$("#userTestHistoryForm").submit();
  } 
  
  function editConsultant(loginid){
	  $("#approveTrainerModel").modal("show");
  }
  

	</script>
	
	  <form:form id="userTestHistoryForm"
							action="${pageContext.request.contextPath}/action/user-test-history"
							method="POST">
							<input type="hidden" name="userid" id="userid"/> 
	</form:form>						
	
	
	<!-- Modal -->
<form  id="approveTrainerModelForm">
<div id="approveTrainerModel" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
         <input type="hidden" name="email" id="hemail"/>
           <input type="hidden" name="empid" id="empid"/>
            <input type="hidden" name="tcid" id="tcid"/>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title"> <img src="${pageContext.request.contextPath}/images/icon/user-icon.png" width="30px;"/>
           <p style="display: inline;margin-left: 20px;">Email   :   <span style="font-weight: bold;" id="email">nagendraxxxx@gmail.com</span></p>
            <p style="display: inline;margin-left: 20px;">Name   :   <span style="font-weight: bold;" id="name"> Nagendraxx Kumar</span></p>
         </h4>
      </div>
      <div class="modal-body">
      <div class="form-group">
       Consultant Id   :   <span style="font-weight: bold;" id="cid">000</span>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Note: Type <span style="background-color: #a8bcff;">E</span> with id for consultant
        <input type="text" class="form-control" id="consultantId" name="consultantid"/>
        </div>
         <div class="form-group">
      	<label id="stream">Stream:</label>
  			<select name="stream" class="form-control" id="stream">
  			<k:forEach items="${findstreams}" var="item">
  					<option ${item.value}>${item.value}</option>	
  			</k:forEach>
  			</select>
        </div>
        
            <div class="form-group">
      	<label id="stream">Batch:</label>
  			<select name="batch" class="form-control" id="batch">
  				<k:forEach items="${findbatches}" var="item">
  					<option ${item.value}>${item.value}</option>	
  			</k:forEach>
  			</select>
        </div>
        
          <div class="form-group">
      	<label id="role">Role:</label>
  			<select name="role" class="form-control" id="role">
  				<option value="consultant">Student</option>	
  					<option value="trainer">Trainer</option>	
  				<option value="admin">Admin</option>
  			</select>
        </div>
        
          <div class="form-group">
      	<label id="active">Active:</label>
  			<select name="active" class="form-control" id="active">
  					<option value="yes">Yes</option>	
  					<option value="no">No</option>	
  			</select>
        </div>
        
      </div>
      <div class="modal-footer">
        	<input type="button" value="Close"  class="mc-btn btn-style-1" id="close"  data-dismiss="modal"/>
        	<input type="button" onclick="approveRemoteUser();"  value="Approved" class="mc-btn btn-style-1" id="approved"/>
      </div>
    </div>

  </div>
</div>
</form>

</body>
</html>