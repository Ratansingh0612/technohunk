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
    <title>${companyName} - Coding Problem Result(s)</title>
       
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
  		<section id="topcontent">
   		</section>
        <div class="container" style="background-color: white;">
               	<h3 style="color: black;"><img src="${pageContext.request.contextPath}/images/codings/coding-icon.png" width="40px;"/> - <span style="font-size: 16px;margin-right: 100px;">Challenges - > Coding Problem Result(s)</span>
               		<br/>
               		<input type="text" name="email" id="semail" class="form-control" style="width: 50%;display: inline;" placeholder="Enter Email Id"/> 
               	    <input type="button" value="Search Users"	class="mc-btn btn-style-1" id="searchGuestTest" style="background-color: #00bcd4;;margin: 0px;font-size: 14px;"/>  
               	</h3>
               	
             <form:form id="userTestHistoryForm"
							action="${pageContext.request.contextPath}/action/user-test-history"
							method="POST">
							<input type="hidden" name="userid" id="userid"/>
							 <span id="ApplicationMessage" style="font-size: 15px;color: #ef6028"></span> 
							<hr style="color: blue" />		
							
            <div class="table-student-submission">
           <img src="${pageContext.request.contextPath}/images/icon/cheers.png" width="30px;"/> 
           <span style="font-size: 14px;color:#2b382a;margin-right: 100px;">Guest user(s) list, who have not started coding problem :-</span>
           <span style="font-size: 14px;"><img src="${pageContext.request.contextPath}/images/configure.png" style="height: 20px;"> Coding Problem Status : Not Started</span>
					    <div style="float: right;">
					    		 <a href="${pageContext.request.contextPath}/action/pending-test-guest-user">
					    		 Refresh	
								<img src="${pageContext.request.contextPath}/images/favicon.ico" height="30px">
								</a>
								&nbsp;<span style="font-family: 'Lato', sans-serif;font-size: 14px;">Pending Coding Problem(s) :</span> <b><span id="totalUsers">${fn:length(userList)}</span></b>
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

function deleteGuestUserCodingProblemLinkTestLink(userid,gid) {
		var ccontextPath="${pageContext.request.contextPath}";
		  var yesno=confirm("Are you sure want to delete the coding problem link for user "+userid);
		  if(yesno) {
	      		$.getJSON(ccontextPath+"/action/codings/delete-guest-user-coding-problem-link", {userid:userid,gid:gid,withHistoryStatus:"yes"}, function(jsonResponse) {
  		  				console.log(jsonResponse); 
  		  				$("#ApplicationMessage").html(jsonResponse.message);
  		  				$("#"+gid).hide();
	      		});			
	      }		
} 

function loadData(email=""){
	/* var groupName=$("#selectedGroupName").val();
	if(groupName.length==0){
		groupName="guest";
	} */
	var len=0;
  //$('body').prelodr('in', 'Loading data please wait...');
	$.getJSON(ccontextPath+"/action/codings/find-guest-pending-cproblems", {batchName:"guest",email:email}, function(jsonResponse) {
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
      	tableContent=tableContent+'<th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Problem Title</th>';
    	tableContent=tableContent+'<th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Link Url</th>';
    	tableContent=tableContent+'<th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Link Date</th>';
    	tableContent=tableContent+'<th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">&nbsp;</th>';
      	tableContent=tableContent+'</tr>';
      	tableContent=tableContent+' </thead>';
      	if(len>0){
        var baseUrl="${applicationScope.companyUrl}";		
      	for(var i=0;i<len;i++){
      			val=i+1;
      				tableContent=tableContent+'<tr height="35px" style="color: black; vertical-align: middle;" id="'+jsonResponse[i].gid+'">';
      				tableContent=tableContent+'<td align="center">'+val+'</td>';
      				tableContent=tableContent+'<td>'+jsonResponse[i].name+'</td>';
      				tableContent=tableContent+'<td >'+jsonResponse[i].email+'</td>';
      				tableContent=tableContent+'<td id="testStatus"'+val+'>&nbsp;&nbsp;&nbsp;'+jsonResponse[i].problemTitle+'</td>';
      				tableContent=tableContent+'<td>'+baseUrl+'/'+jsonResponse[i].generatedCodeLink+'</td>';
      				var jsmethod="<a href=\"javascript:deleteGuestUserCodingProblemLinkTestLink('"+jsonResponse[i].email+"',"+jsonResponse[i].gid+");\">";
      				//alert(jsmethod);
      				tableContent=tableContent+'<td>'+jsonResponse[i].doe+'</td>';
      				tableContent=tableContent+'<td>';
      				tableContent=tableContent+jsmethod;
      				tableContent=tableContent+'<img src="${pageContext.request.contextPath}/images/delete-test-icon.png">';
      				tableContent=tableContent+'</a></td>';
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
      			tableContent=tableContent+'</tr>';
      		}
      	tableContent=tableContent+'<tr height="35px" style="color: white; background-color: white; vertical-align: middle;" align="center">';
      	$("#tab1").html(tableContent);
    	if(len==0){
  			 $("#ApplicationMessage").html("Sorry no record exists for email id "+email);	
  			 return;
  		}
      	
	}
		
	});//end of getJSON
}

 $(document).ready(function(){
	 
	 $("#semail").keyup(function(){
		 $("#ApplicationMessage").html("");		
	 });
	    
	 	$("#searchGuestTest").click(function(){
	  			var email=$("#semail").val();
	  			if(email.length==0){
	  			  $("#ApplicationMessage").html("Email id cannot be blank.");		
	  			  $("#semail").focus();	
	  				return;
	  			}
	  			loadData(email);
	    });		
	 	
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
    

</script>
</body>

</html>