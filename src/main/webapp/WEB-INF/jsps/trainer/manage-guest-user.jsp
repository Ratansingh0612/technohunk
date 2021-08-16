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
    <title>${companyName} - Manage Guest User</title>
       
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
 
    <!-- COURSE CONCERN -->
  <section style="padding-top: 0px;padding-bottom:10px;background-color: #eee;min-height:600px;" id="quizz-intro-section">
  		 <hr/>	
        <div class="container" style="background-color: white;">
               	<h3 style="color: black;margin-top: -5px;"><img src="${pageContext.request.contextPath}/images/icon/Icon_01.png" width="40px;"/> - <span style="font-size: 16px;">Test - > Manage Guest Test</span></h3>
             <form:form id="userTestHistoryForm"
							action="${pageContext.request.contextPath}/action/user-test-history"
							method="POST">
							<input type="hidden" name="userid" id="userid"/> 
							<hr style="color: blue" />		
							 <span id="ApplicationMessage" style="font-size: 14px;color:black;"></span>
            <div class="table-student-submission">
           <img src="${pageContext.request.contextPath}/images/icon/cheers.png" width="30px;"/> 
           <span style="font-size: 14px;">Guest User(s) List:-</span>
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
	/* var groupName=$("#selectedGroupName").val();
	if(groupName.length==0){
		groupName="guest";
	} */
	var len=0;
  //$('body').prelodr('in', 'Loading data please wait...');
	$.getJSON(ccontextPath+"/action/find-guest-users", {batchName:"guest"}, function(jsonResponse) {
		 //$('body').prelodr('out');
		console.log(jsonResponse); 
		if(jsonResponse) {
			 len = jsonResponse.length;
      	var tableContent='';
      	var val;
      	$("#totalUsers").html(len);
      	tableContent=tableContent+' <thead>';
      	tableContent=tableContent+' <tr style="background-color: #607D8B;">';
      	tableContent=tableContent+'<th class="submissions" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">SNo</th>';
      	tableContent=tableContent+'<th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Name</th>';
      	tableContent=tableContent+' <th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Email </th>';
      	tableContent=tableContent+'<th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Mobile</th>';
      	tableContent=tableContent+'<th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Status</th>';
    	tableContent=tableContent+'<th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Link Url</th>';
    	tableContent=tableContent+'<th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Dor</th>';
    	tableContent=tableContent+'<th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">&nbsp;Reset</th>';
      	tableContent=tableContent+'</tr>';
      	tableContent=tableContent+' </thead>';
      	if(len>0){
        var baseUrl="${applicationScope.companyUrl}";		
      	for(var i=0;i<len;i++){
      			val=i+1;
      				tableContent=tableContent+'<tr height="35px" style="color: black; vertical-align: middle;">';
      				tableContent=tableContent+'<td align="center">'+val+'</td>';
      				tableContent=tableContent+'<td>'+jsonResponse[i].name+'</td>';
      				tableContent=tableContent+'<td >'+jsonResponse[i].email+'</td>';
      				tableContent=tableContent+'<td id="testStatus"'+val+'>&nbsp;&nbsp;&nbsp;'+jsonResponse[i].mobile+'</td>';
      				tableContent=tableContent+'<td>'+jsonResponse[i].testStatus+'</td>';
      				tableContent=tableContent+'<td>'+baseUrl+'/'+jsonResponse[i].generatedTestLink+'</td>';
      				var jsmethod="<a href=\"javascript:resetGuestUserTest('"+jsonResponse[i].email+"','"+jsonResponse[i].userSessionId+"');\">";
      				//alert(jsmethod);
      				tableContent=tableContent+'<td>'+jsonResponse[i].doe+'</td>';
      				if(jsonResponse[i].testStatus=='complete' || jsonResponse[i].testStatus=='COMPLETED' || jsonResponse[i].testStatus=='In Porgress') {
      						tableContent=tableContent+'<td>&nbsp;'+jsmethod;
      						tableContent=tableContent+'<img src="'+ccontextPath+'/images/icon/reset.png"  style="max-width:50px;"/></a>';
      						tableContent=tableContent+'</td>';
      				}else{
      						tableContent=tableContent+'<td>&nbsp</td>';
      				}
      				tableContent=tableContent+'</tr>'
      				//alert(tableContent);
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
      			tableContent=tableContent+'</tr>';
      		}
      	
      	tableContent=tableContent+'<tr height="35px" style="color: white; background-color: white; vertical-align: middle;" align="center">';
      	$("#tab1").html(tableContent);
		}
		
	});//end of getJSON
}

 $(document).ready(function(){
	 	$("#selectedGroupName").change(function(){
	 		loadData();
	 	});
	 	
	 	//Loading the data first time when this page is loaded first time....
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
    
    function resetGuestUserTest(userid,puserSessionId) {
    	var ccontextPath="${pageContext.request.contextPath}";
    	//@RequestParam("withHistoryStatus") String withHistoryStatus,@RequestParam("userid") String userid,@RequestParam(value="userSessionId",required=false) String userSessionId
		// alert(" userid  = "+userid);
		 var withHistoryStatus="no";
    	$.getJSON(ccontextPath+"/action/reset-guest-user-test", {userid:userid,withHistoryStatus:withHistoryStatus,userSessionId:puserSessionId}, function(jsonResponse) {
    		  console.log(jsonResponse); 
    		  $("#ApplicationMessage").html(jsonResponse.message);
    	});
    } 

</script>
</body>

</html>