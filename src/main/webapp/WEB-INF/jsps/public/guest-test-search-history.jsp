<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <title>${companyName} - Search & Guest Test History</title>
    
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
     <k:if test="${sessionScope.user_session_data.role=='career'}">	
      <%@include file="/guestheader.jsp" %>
      </k:if>
      <k:if test="${sessionScope.user_session_data.role=='consultant'}">	
      <%@include file="/guestheader.jsp" %>
      </k:if>
        <k:if test="${sessionScope.user_session_data.role=='trainer'}">	
       <%@include file="/theader.jsp" %>
       </k:if>
             <k:if test="${sessionScope.user_session_data.role=='admin'}">	
       <%@include file="/aheader.jsp" %>
           </k:if>
                <k:if test="${sessionScope.role=='guest'}">	
       <%@include file="guestheader.jsp" %>
           </k:if>
  </div>
</div>

    <!-- PROFILE FEATURE -->
    <%@include file="profile-feature.jsp" %>
    <!-- END / PROFILE FEATURE -->

 
    <!-- COURSE CONCERN -->
    <section class="quizz-intro-section" style="padding-top: 0px;padding-bottom:10px;background-color: #eee;" id="content">
    	<section style="height: 10px;background-color: #eee;width: 100px;">
   		</section>
        <div class="container" style="background-color: white;min-height: 600px;">
                <h3 style="color: black"><img src="${pageContext.request.contextPath}/images/icon/search-results.png" width="50px;"/>&nbsp;&nbsp;<b style="font-size: 18px;">Test - >Search Student Career Counseling Test Result!</b></h3> 
             						<hr style="border-top: 1px solid #a9a9a9;margin-top: 0px"/>
						 <div class="col-xs-12" style="margin-top: 20px;">
						<label for="searchConsultant" style="font-size: 15px;margin-right: 20px;">Name/Email/Mobile/Test ID</label>		
						   &nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp; 
						 <input type="text" name="searchConsultant" id="searchKey" class="form-control" style="width:300px;display:inline;">
						   &nbsp;&nbsp;&nbsp; 
						   <label for="Go" style="font-family: 'Lato', sans-serif;font-size: 15px;"></label>
						 <input type="button" value="Search" class="mc-btn btn-style-1"  id="goID" />
						   &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 
						    <input type="button" value="Clear" class="mc-btn btn-style-1"  id="clearSearch"  onclick="window.location.assign('${pageContext.request.contextPath}/action/guest-test-search-history');"/>
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
					    <b style="font-size: 15px;">Search Result(s)</b>
					     &nbsp;&nbsp;&nbsp;  
                            <a href="${pageContext.request.contextPath}/action/adminAvailableQuestionsBankTest">
                            </a>
					    <div style="float: right;">
                            <b style="font-size: 15px;">Total Result(s) : <span id="totalUser">${fn:length(userList)}</span></b>
                             </div> 
                
               
							<input type="hidden" name="NoOfUsers" value="${fn:length(userList)}" /> <br /> 
                <table class="table table-bordered" id="tab1">
                    <thead>
                        <tr style="background-color: #607D8B;">
                            <th class="submissions" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">SNo</th>
                            <th class="score" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Name </th>
                            <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Email</th>
                                <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Test Id</th>
                                  <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Mobile</th>
                                  <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">R</th>
                                  <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">I</th>
                                  <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">A</th>
                                  <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">S</th>
                                  <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">E</th>
                                  <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">C</th>
                                  
								   <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Detail</th>
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
										<td bgcolor="white">&nbsp;</td>
											<td bgcolor="white">&nbsp;</td>
												<td bgcolor="white">&nbsp;</td>
								</tr>
                    </tbody>
                </table>
                	<h5 style="color:black;">Student Career Counseling Test History</h5>
                   <table class="table table-bordered" id="tab1">
                    <thead>
                        <tr style="background-color: #607D8B;">
                            <th class="submissions" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">SNo</th>
                            <th class="score" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">No of students </th>
                            <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Date of Test</th>
								   <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Detail</th>
                        </tr>
                    </thead>

                    <tbody>
					   
					      <tr height="35px" style="color: black">
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
								</tr>
								      <tr height="35px" style="color: black">
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
								</tr>
                    </tbody>
                </table>
        </div>
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
	$.getJSON(ccontextPath+"/action/find-guest-test-search-history", {searchString:searchKey},function(jsonResponse){
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
        		tableContent=tableContent+'<th class="score" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Detail </th>';
        		tableContent=tableContent+'<th class="score" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">DOT </th>';
          		tableContent=tableContent+'</tr>';
          		tableContent=tableContent+' </thead>';
		    if(len>0)	{
					for(var row=0; row<jsonResponse.length;row++)
					{
							tableContent=tableContent+'<tr height="35px" style="color: black; vertical-align: middle;">';
							tableContent=tableContent+'<td align="center">'+(row+1)+'</td>';
							tableContent=tableContent+'<td >&nbsp;'+jsonResponse[row].techName+'</td>';
							tableContent=tableContent+'<td >&nbsp;'+jsonResponse[row].testName+'</td>';
							tableContent=tableContent+'<td >&nbsp;'+jsonResponse[row].firstName+'</td>';
							tableContent=tableContent+'<td >&nbsp;'+jsonResponse[row].email+'</td>';
							tableContent=tableContent+'<td >&nbsp;'+jsonResponse[row].techTestStatus+'</td>';
							tableContent=tableContent+'<td >&nbsp;'+jsonResponse[row].score+'</td>';
							tableContent=tableContent+'<td align="center">';
		      				if ( jsonResponse[row].techTestStatus!=null && "Not Started".toLowerCase() !== jsonResponse[row].techTestStatus.toLowerCase()){
		      					var jsmethod="<a href=javascript:showGuestTestSummary('"+jsonResponse[row].email+"','"+jsonResponse[row].userSessionId+"')";
		      					tableContent=tableContent+jsmethod+'><img	src="${pageContext.request.contextPath}/images/not-started.png" width="24" height="24" alt="Click Here to reset the test" id="imageId'+val+'"/></a>';
		      				}else{
		      					tableContent=tableContent+'NA';
		      				}
		      				tableContent=tableContent+'</td>';
		      				tableContent=tableContent+'<td >&nbsp;'+jsonResponse[row].dot+'</td>';
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
			  			tableContent=tableContent+'<td bgcolor="white">&nbsp;</td>';
			  			tableContent=tableContent+'</tr>';
			  		}
		
				tableContent=tableContent+'<tr height="35px" style="color: white; background-color: white; vertical-align: middle;" align="center">';
				$("#tab1").html(tableContent);
		} //end of if response
	});
	});
});	
  
  function showGuestTestSummary(email,userSessionId) {
		 $("#semail").val(email);
		 $("#userSessionId").val(userSessionId);
		$("#guestTestHistoryForm").submit();
}

	</script>
	
 <form method="POST" action="${pageContext.request.contextPath}/action/guest-tech-test-history"  id="guestTestHistoryForm">
			                    <div class="course-keyword">
			                        <input type="hidden"  name="email" id="semail"/>
			                        <input type="hidden" name="userSessionId" id="userSessionId"/>
			                        
			                    </div>
                </form>					

</body>
</html>