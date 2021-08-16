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
    <title>${companyName} - Lock/Unlock Consultant</title>
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


    <!-- CONTEN BAR -->
     <%@include file="content-bar.jsp" %>
   <!-- END / CONTENT BAR -->
 
    <!-- COURSE CONCERN -->
  <section style="padding-top: 0px;padding-bottom:10px;background-color: white;min-height:600px;" id="quizz-intro-section">
        <div class="container">
               		  <span>	
               		 	<h3 style="color: black;"><img src="${pageContext.request.contextPath}/images/icon/Icon_01.png" width="40px;"/>  <span style="font-size: 16px;">Test - > Lock/Unlock Consultant</span></h3>
               		 	 <hr/>
						 <img src="${pageContext.request.contextPath}/images/lock-unlock-bar.png" style="height: 35px;"/>		
						<h3 style="font-size: 18px;display: inline;"> Group Name:</h3>
						<select class="form-control" name="selectedGroupName" id="selectedGroupName" style="width: 400px;display: inline;margin-left: 10px;">
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
						 </select> 
						 </span>
             <form:form id="userTestHistoryForm"
							action="${pageContext.request.contextPath}/action/user-test-history"
							method="POST">
							<input type="hidden" name="userid" id="userid"/> <br /> 
							<section style="margin-left: -16px;">
							<div class="col-xs-12">
						 </div>
						</section>
							<hr style="color: blue" />		
							 <span id="ApplicationMessage" style="font-size: 14px;color:blue;"></span>
            <div class="table-student-submission">
           <img src="${pageContext.request.contextPath}/images/icon/cheers.png" width="30px;"/> <span style="font-size: 16px;">User(s) List:-</span>
					    <div style="float: right;">
								<img src="${pageContext.request.contextPath}/images/favicon.ico" height="30px">&nbsp;<span style="font-size: 14px;">Total Users :</span> <b><span id="totalUsers">${fn:length(userList)}</span></b>
							</div>
                <table class="table table-bordered" id="tab1" style="margin-bottom: 0px;">
                    <thead>
                        <tr style="background-color: #607D8B;">
                            <th class="submissions" >SNo</th>
                            <th class="author" >Name</th>
                            <th class="author" >Email </th>
                            <th class="submit-date" >Batch</th>
                            <th class="submit-date" >Photo</th>
                               <th class="submit-date" >Test Status</th>
                            <th class="submit-date" >Lock/Unlock</th>
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
	var groupName=$("#selectedGroupName").val();
	var len=0;
  //$('body').prelodr('in', 'Loading data please wait...');
	$.getJSON(ccontextPath+"/action/findConsultantsByBatch", {batchName:groupName}, function(jsonResponse) {
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
      	tableContent=tableContent+'<th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Consultant Id</th>';
      	tableContent=tableContent+'<th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Name</th>';
      	tableContent=tableContent+' <th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Email </th>';
    	tableContent=tableContent+' <th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Password </th>';
      	tableContent=tableContent+'<th class="submit-date" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Photo</th>';
      	tableContent=tableContent+'<th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Mobile</th>';
      	tableContent=tableContent+'<th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Stream</th>';
    	tableContent=tableContent+'<th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Lock/Unlock</th>';
      	tableContent=tableContent+'</tr>';
      	tableContent=tableContent+' </thead>';
      	if(len>0){
      		
      	for(var i=0;i<len;i++){
      			val=i+1;
      				tableContent=tableContent+'<tr height="35px" style="color: black; vertical-align: middle;">';
      				tableContent=tableContent+'<td align="center">'+val+'</td>';
      				tableContent=tableContent+'<td >&nbsp;&nbsp;&nbsp;'+jsonResponse[i].empid+'</td>';
      				tableContent=tableContent+'<td >&nbsp;&nbsp;&nbsp;'+jsonResponse[i].name+'</td>';
      				tableContent=tableContent+'<td >&nbsp;&nbsp;&nbsp;'+jsonResponse[i].email+'</td>';
      				tableContent=tableContent+'<td >&nbsp;&nbsp;&nbsp;'+jsonResponse[i].password+'</td>';
      				var imageURI="";
      				if(userRole=="admin") {
      					 imageURI='${pageContext.request.contextPath}/action/imageByUserId?userid='+jsonResponse[i].userid;
      				}
      				else if(userRole=="trainer") {
      					 imageURI='${pageContext.request.contextPath}/action/findConsultantImage?userid='+jsonResponse[i].userid;
      				}
      				tableContent=tableContent+'<td align="center"><img src="'+imageURI+'" style="height:30px" /></td>';
      				tableContent=tableContent+'<td id="testStatus"'+val+'>&nbsp;&nbsp;&nbsp;'+jsonResponse[i].mobile+'</td>';
      				tableContent=tableContent+'<td>'+jsonResponse[i].stream+'</td>';
      				var jsmethod="<a href=\"javascript:lockUnlockStatus('"+jsonResponse[i].userid+"',"+val+");\"";
          			
      				tableContent=tableContent+'<td align="center">';
      				if("yes"==jsonResponse[i].active){
      					tableContent=tableContent+jsmethod+'"><img	src="${pageContext.request.contextPath}/images/unlocked.png" style="height:24px;"  id="imageId'+val+'"/></a>';
      				}else {
      					tableContent=tableContent+jsmethod+'"><img	src="${pageContext.request.contextPath}/images/lock.png" style="height:24px;"  id="imageId'+val+'"/></a>';
      				}
      				tableContent=tableContent+'</td>';
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
    
    function lockUnlockStatus(userid,val) {
    	var imageId="imageId"+val;
    	var imagePath=$("#"+imageId).attr("src");
    	var lockstatus="yes";
    	console.log("-----imagePath----  = "+imagePath);
    	if(imagePath.endsWith("unlocked.png")){
    		lockstatus="no"
    	}
    	var ccontextPath="${pageContext.request.contextPath}";
    	$.getJSON(ccontextPath+"/action/lockUnlockUser", {userid:userid,lockstatus:lockstatus}, function(jsonResponse) {
    		  console.log(jsonResponse); 
    		 if("no"==lockstatus){
    			 $("#"+imageId).attr("src",ccontextPath+"/images/lock.png");
    		 }else{
    			 $("#"+imageId).attr("src",ccontextPath+"/images/unlocked.png");
    		 }
    	});
    	console.log("-----lockUnlockStatus----  = "+userid);
    } 

</script>
</body>

</html>