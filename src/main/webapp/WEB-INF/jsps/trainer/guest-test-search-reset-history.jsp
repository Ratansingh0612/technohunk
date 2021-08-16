<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <title>${companyName} - Search & Guest Reset sTest History</title>
    
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
    	<section style="topcontent">
   		</section>
        <div class="container" style="background-color: white;min-height: 600px;">
                <h3 style="color: black"><img src="${pageContext.request.contextPath}/images/icon/search-globe.ico" width="50px;"/>&nbsp;&nbsp;<b style="font-size: 16px;">Test - > Search Guest Test & Reset History</b></h3> 
             						<hr style="border-top: 1px solid #a9a9a9;margin-top: 0px"/>
						 <div class="col-xs-12" style="margin-top: 20px;">
						<label for="searchConsultant" style="font-size: 15px;margin-right: 20px;">Consultant Name/Email</label>		
						   &nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp; 
						 <input type="text" name="searchConsultant" id="searchKey" class="form-control" style="width:300px;display:inline;">
						   &nbsp;&nbsp;&nbsp; 
						   <label for="Go" style="font-family: 'Lato', sans-serif;font-size: 15px;"></label>
						 <input type="button" value="Search" class="mc-btn btn-style-1"  id="goID" />
						   &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 
						    <input type="button" value="Clear" class="mc-btn btn-style-1"  id="clearSearch"  onclick="window.location.assign('${pageContext.request.contextPath}/action/guest-test-search-reset-history);"/>
						   &nbsp;&nbsp;&nbsp; 
						</div>
							<hr style="border-top: 1px solid #a9a9a9;margin-top: 0px"/>
								
							 <br/> 
							&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 
							<br/>		

			<hr style="border-top: 1px solid #a9a9a9;margin-top: 0px"/>
			<span id="ApplicationMessage" style="color:green;font-size: 16px;font-weight: bold;"></span>
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
                        <tr style="background-color: #607D8B;">
                            <th class="submissions" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">SNo</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Tech Name</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Test Name </th>
                            <th class="score" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Name </th>
                            <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Email</th>
                                <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Test Status</th>
                                  <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Score%</th>
                                     <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">DOT</th>
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
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
								</tr>
                    </tbody>
                </table>
             <img 	src="${pageContext.request.contextPath}/images/not-started.png" style="height:30px;" alt="Click Here to reset the test" id="imageId"/>&nbsp;&nbsp;
		      Reset Guest Test without history&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		      <img	src="${pageContext.request.contextPath}/images/reset.png" style="height:30px;" alt="Click Here to reset the test" id="imageId"/>&nbsp;&nbsp;
		      Reset Guest Test with history&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		      <img	src="${pageContext.request.contextPath}/images/delete-test-icon.png" style="height:30px;" alt="Click Here to reset the test" id="imageId"/>&nbsp;&nbsp;
		      Delete Guest Test&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		      		
        </div>
        <hr/>
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
  <%@include file="/js.jsp" %>
   <script type="text/javascript">
	
  $(document).ready(function(){
	  $("#searchKey").keyup(function(){
		  $("#ApplicationMessage").html("");	
	  });
	  
	$("#goID").click(function() {
	var searchKey = $("#searchKey").val();
	if(searchKey.length==0) {
		$("#ApplicationMessage").html("Search string cannot be empty.....");	
		$("#searchKey").focus();
		return;
	}else{
		$("#ApplicationMessage").html("");	
	}
	var ccontextPath="${pageContext.request.contextPath}";
	//var groupName=$("#selectedGroupName").val();
	var userRole="${sessionScope.user_session_data.role}";
	$.getJSON(ccontextPath+"/action/find-guest-reset-test-search-history", {searchString:searchKey},function(jsonResponse){
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
          		tableContent=tableContent+'<th class="score" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Tech Name </th>';
         		tableContent=tableContent+'<th class="score" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Test Name </th>';
          		tableContent=tableContent+'<th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Name</th>';
          		tableContent=tableContent+' <th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Email </th>';
          		tableContent=tableContent+'<th class="score" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Test Status </th>';
          		tableContent=tableContent+'<th class="submit-date" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Score%</th>';
          		tableContent=tableContent+'<th class="score" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">DOT </th>';
        		tableContent=tableContent+'<th class="score" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Action </th>';
          		tableContent=tableContent+'</tr>';
          		tableContent=tableContent+' </thead>';
		    if(len>0)	{
					for(var row=0; row<jsonResponse.length;row++)
					{
							tableContent=tableContent+'<tr height="35px" style="color: black; vertical-align: middle;" id="'+jsonResponse[row].id+'">';
							tableContent=tableContent+'<td align="center">'+(row+1)+'</td>';
							tableContent=tableContent+'<td>&nbsp;'+jsonResponse[row].techName+'</td>';
							tableContent=tableContent+'<td>&nbsp;'+jsonResponse[row].testName+'</td>';
							tableContent=tableContent+'<td>&nbsp;'+jsonResponse[row].firstName+'</td>';
							tableContent=tableContent+'<td>&nbsp;'+jsonResponse[row].email+'</td>';
							tableContent=tableContent+'<td id="status'+jsonResponse[row].id+'">&nbsp;'+jsonResponse[row].techTestStatus+'</td>';
							tableContent=tableContent+'<td>&nbsp;'+jsonResponse[row].score+'</td>';
							tableContent=tableContent+'<td>&nbsp;'+jsonResponse[row].dot+'</td>';
							tableContent=tableContent+'<td align="center">';
		      				if ("Not Started".toLowerCase() !== jsonResponse[row].techTestStatus.toLowerCase()){
		      					var jsmethod="<a href=javascript:resetGuestUserTestWithOutHistory('"+jsonResponse[row].email+"','"+jsonResponse[row].userSessionId+"',"+jsonResponse[row].id+")";
		      					tableContent=tableContent+jsmethod+'><img	src="${pageContext.request.contextPath}/images/not-started.png" height="24" alt="Click Here to reset the test" id="imageId'+val+'"/></a>&nbsp;&nbsp;';
		      					var jsmethodw="<a href=javascript:resetGuestUserTestWithHistory('"+jsonResponse[row].email+"','"+jsonResponse[row].userSessionId+"',"+jsonResponse[row].id+")";
		      					tableContent=tableContent+jsmethodw+'><img	src="${pageContext.request.contextPath}/images/reset.png" height="24" alt="Click Here to reset the test" id="imageId'+val+'"/>&nbsp;&nbsp;</a>';
		      					var jsmethoddelete="<a href=javascript:deleteGuestUserTestWithHistory('"+jsonResponse[row].email+"',"+jsonResponse[row].id+")";
		      					tableContent=tableContent+jsmethoddelete+'><img	src="${pageContext.request.contextPath}/images/delete-test-icon.png" height="24" alt="Click Here to reset the test" id="imageId'+val+'"/>&nbsp;&nbsp;</a>';	
		      				}else{
		      					tableContent=tableContent+'NA';
		      				}
		      				tableContent=tableContent+'</td>';
							tableContent=tableContent+'</tr>';
					}
			}else {
				$("#ApplicationMessage").html("Sorry! no record exists for search criteria "+searchKey+".<br/>");
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
			  			tableContent=tableContent+'<td bgcolor="white">&nbsp;</td>';
			  			tableContent=tableContent+'</tr>';
			  		}
		
				tableContent=tableContent+'<tr height="35px" style="color: white; background-color: white; vertical-align: middle;" align="center">';
				$("#tab1").html(tableContent);
		} //end of if response
	});
	});
	});	
    
 function deleteGuestUserTestWithHistory(userid,gid) {
	  	var ccontextPath="${pageContext.request.contextPath}";
			  var yesno=confirm("Are you sure want to delete the test for "+userid);
			  if(yesno) {
		      		$.getJSON(ccontextPath+"/action/delete-guest-user-test", {userid:userid,gid:gid,withHistoryStatus:"yes"}, function(jsonResponse) {
	  		  				console.log(jsonResponse); 
	  		  				$("#ApplicationMessage").html(jsonResponse.message);
	  		  				$("#"+gid).hide();
		      		});			
		      }		
  } 
  
 function resetGuestUserTest(userid,userSessionId,gid) {
  	      var ccontextPath="${pageContext.request.contextPath}";
  	    var yesno=confirm("Are you sure want to reset the test with history for "+userid);
		  if(yesno) {
				  $.getJSON(ccontextPath+"/action/reset-guest-user-test", {userid:userid,userSessionId:userSessionId,withHistoryStatus:"yes"}, function(jsonResponse) {
		  		  		console.log(jsonResponse); 
		  		 	    $("#ApplicationMessage").html(jsonResponse.message);
		  		 	 	$("#status"+gid).html("&nbsp;Not Started");
		     	});
		  }  
  } 
  
  function resetGuestUserTestWithOutHistory(userid,userSessionId,gid) {
	  	var ccontextPath="${pageContext.request.contextPath}";
	  	var yesno=confirm("Are you sure want to reset the test without history for "+userid);
		  if(yesno) {
				$.getJSON(ccontextPath+"/action/reset-guest-user-test", {userid:userid,userSessionId:userSessionId,withHistoryStatus:"no"}, function(jsonResponse) {
		  		  console.log(jsonResponse); 
		  		  $("#ApplicationMessage").html(jsonResponse.message);
	  			  $("#status"+gid).html("&nbsp;Not Started");
	  		});
		  }		
	  } 
</script>
</body>
</html>