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
    <section class="quizz-intro-section" style="padding-top: 0px;padding-bottom:10px;background-color: #eee;min-height: 600px;" id="content">
    <section id="topcontent">
   		</section>
        <div class="container" style="background-color: white;">
                <h3 style="color: black"><img src="${pageContext.request.contextPath}/images/icon/performance.png" width="50px;"/>&nbsp;&nbsp;<span style="font-size: 16px;">Test - > Search Guest Performance</span></h3> 
						 <div class="col-xs-12" style="margin-top: 20px;">
						<span for="searchConsultant" style="font-size: 14px;margin-right: 20px;">Consultant Name/Email</span>		
						   &nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp; 
						 <input type="text" name="searchConsultant" id="searchKey" class="form-control" style="width:300px;display:inline;">
						   &nbsp;&nbsp;&nbsp; 
						   <label for="Go" style="font-family: 'Lato', sans-serif;font-size: 15px;"></label>
						 <input type="button" value="Search" class="mc-btn btn-style-1"  id="goID" />
						   &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 
						    <input type="button" value="Clear" class="mc-btn btn-style-1"  id="clearSearch"  onclick="window.location.assign('${pageContext.request.contextPath}/action/guest-test-performance-report');"/>
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
					    <span style="font-family: 'Lato', sans-serif;font-size: 14px;">Search Result(s)</span>
					     &nbsp;&nbsp;&nbsp;  
                            <a href="${pageContext.request.contextPath}/action/adminAvailableQuestionsBankTest">
                            </a>
					    <div style="float: right;">
                            <span style="font-family: 'Lato', sans-serif;font-size: 14px;">Total Result(s) : <span id="totalUser">${fn:length(userList)}</span></span>
                             </div> 
                
               
							<input type="hidden" name="NoOfUsers" value="${fn:length(userList)}" /> <br /> 
                <table class="table table-bordered" id="tab1">
                    <thead>
                        <tr style="background-color: #607D8B;">
                            <th class="submissions" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">SNo</th>
                            <th class="score" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Name </th>
                            <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Email</th>
                                <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Gender</th>
                                  <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Location</th>
                                     <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Occupation</th>
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
								</tr>
								 <tr height="35px" style="color: black">
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
								</tr>
								 <tr height="35px" style="color: black">
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
								</tr>
									 <tr height="35px" style="color: black">
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
	$.getJSON(ccontextPath+"/action/search-guest-email-name", {searchString:searchKey},function(jsonResponse){
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
          		tableContent=tableContent+'<th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Name</th>';
          		tableContent=tableContent+' <th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Email </th>';
          		tableContent=tableContent+'<th class="score" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Gender </th>';
          		tableContent=tableContent+'<th class="submit-date" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Location</th>';
          		tableContent=tableContent+'<th class="score" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Occupation </th>';
        		tableContent=tableContent+'<th class="score" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Action </th>';
          		tableContent=tableContent+'</tr>';
          		tableContent=tableContent+' </thead>';
		    if(len>0)	{
					for(var row=0; row<jsonResponse.length;row++)
					{
							tableContent=tableContent+'<tr height="35px" style="color: black; vertical-align: middle;" id="'+jsonResponse[row].id+'">';
							tableContent=tableContent+'<td align="center">'+(row+1)+'</td>';
							tableContent=tableContent+'<td>&nbsp;'+jsonResponse[row].name+'</td>';
							tableContent=tableContent+'<td>&nbsp;'+jsonResponse[row].email+'</td>';
							tableContent=tableContent+'<td>&nbsp;'+jsonResponse[row].gender+'</td>';
							tableContent=tableContent+'<td>&nbsp;'+jsonResponse[row].location+'</td>';
							tableContent=tableContent+'<td>&nbsp;'+jsonResponse[row].occupation+'</td>';
							tableContent=tableContent+'<td align="center">';
							
							tableContent=tableContent+'<a href="javascript:showPerformance(\''+jsonResponse[row].email+'\');"><img src="'+ccontextPath+'/images/icon/bar-graph-icon.png"/></a>';
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
			  			tableContent=tableContent+'</tr>';
			  		}
		
				tableContent=tableContent+'<tr height="35px" style="color: white; background-color: white; vertical-align: middle;" align="center">';
				$("#tab1").html(tableContent);
		} //end of if response
	});
	});
	});	
    
 function showPerformance(userid) {
	  	$("#spuserid").val(userid);
		$("#guestperformancereportform").submit();	 
  } 
  

</script>
  <form id="guestperformancereportform"  action="${pageContext.request.contextPath}/action/guest-performance-report" method="post">
   		<input type="text" name="userid" id="spuserid"/>
  </form>
</body>
</html>