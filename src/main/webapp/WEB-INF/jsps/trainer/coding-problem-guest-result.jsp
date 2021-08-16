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

<style type="text/css">

textarea {
width: 300px;
height: 7em;
scrollbar-base-color: #ff8c00;
scrollbar-arrow-color: white;
}

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
               	    <input type="button" value="Search Results"	class="mc-btn btn-style-1" id="searchGuestTest" style="background-color: #00bcd4;;margin: 0px;font-size: 14px;"/>  
               	</h3>
               	
             <form:form id="userTestHistoryForm"
							action="${pageContext.request.contextPath}/action/user-test-history"
							method="POST">
							<input type="hidden" name="userid" id="userid"/>
							 <span id="ApplicationMessage" style="font-size: 15px;color: #ef6028"></span> 
							<hr style="color: blue" />		
							
            <div class="table-student-submission">
           <img src="${pageContext.request.contextPath}/images/icon/cheers.png" width="30px;"/> 
           <span style="font-size: 14px;color:#2b382a;margin-right: 100px;">Guest user(s) list:-</span>
           <span style="font-size: 14px;"><img src="${pageContext.request.contextPath}/images/configure.png" style="height: 20px;"> Test Status : Completed</span>
					    <div style="float: right;">
					    		 <a href="${pageContext.request.contextPath}/action/codings/coding-problem-guest-result">
					    		 Refresh	
								<img src="${pageContext.request.contextPath}/images/favicon.ico" height="30px">
								</a>
								&nbsp;<span style="font-family: 'Lato', sans-serif;font-size: 14px;">Total Result(s) :</span> <b><span id="totalUsers">${fn:length(userList)}</span></b>
							</div>
                <table class="table table-bordered" id="tab1" style="margin-bottom: 0px;">
                    <thead>
                        <tr style="background-color: #607D8B;">
                            <th class="submissions" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">SNo</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Name</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Email </th>
                            <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Problem Title</th>
                               <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Grade</th>
                            <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">LinkDate</th>
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

function deleteGuestUserTestLink(userid,gid) {
	var ccontextPath="${pageContext.request.contextPath}";
		  var yesno=confirm("Are you sure want to delete the test link for user "+userid);
		  if(yesno) {
	      		$.getJSON(ccontextPath+"/action/delete-guest-user-test-link", {userid:userid,gid:gid,withHistoryStatus:"yes"}, function(jsonResponse) {
  		  				console.log(jsonResponse); 
  		  				$("#ApplicationMessage").html(jsonResponse.message);
  		  				$("#"+gid).hide();
	      		});			
	      }		
} 

var gdata={};
function loadData(email=""){
	/* var groupName=$("#selectedGroupName").val();
	if(groupName.length==0){
		groupName="guest";
	} */
	var len=0;
  //$('body').prelodr('in', 'Loading data please wait...');
	$.getJSON(ccontextPath+"/action/codings/find-guest-cproblems-results", {batchName:"guest",email:email}, function(jsonResponse) {
		 //$('body').prelodr('out');
		console.log(jsonResponse); 
		if(jsonResponse) {
		//Setting incoming response into a global variable!	
		gdata=jsonResponse;	
		len = jsonResponse.length;
      	var tableContent='';
      	var val;
      	$("#totalUsers").html(len);
      	tableContent=tableContent+' <thead>';
      	tableContent=tableContent+' <tr style="background-color: #607D8B;">';
      	tableContent=tableContent+'<th class="submissions" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">SNo</th>';
      	tableContent=tableContent+'<th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Name</th>';
      	tableContent=tableContent+' <th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Email </th>';
    	tableContent=tableContent+' <th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Tech Name </th>';
      	tableContent=tableContent+'<th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Problem Title</th>';
    	tableContent=tableContent+'<th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Grade</th>';
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
      				tableContent=tableContent+'<td>'+jsonResponse[i].codingProblmesLinkVO.name+'</td>';
      				tableContent=tableContent+'<td >'+jsonResponse[i].consultantid+'</td>';
      				tableContent=tableContent+'<td >'+jsonResponse[i].codingProblemsVO.techName+'</td>';
      				
      				tableContent=tableContent+'<td id="testStatus"'+val+'>'+jsonResponse[i].codingProblmesLinkVO.problemTitle+'</td>';
      				tableContent=tableContent+'<td>'+jsonResponse[i].grade+'</td>';
      				var jsmethod="<a href=\"javascript:showDetails("+i+",'"+jsonResponse[i].consultantid+"','"+jsonResponse[i].userSessionId+"');\">";
      				//alert(jsmethod);
      				tableContent=tableContent+'<td>'+jsonResponse[i].doe+'</td>';
      				tableContent=tableContent+'<td>';
      				tableContent=tableContent+jsmethod;
      				tableContent=tableContent+'<img src="${pageContext.request.contextPath}/images/not-started.png">';
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
    
   function showDetails(rownum,email,userSessionId){
	   // alert("rownum = "+rownum);
	    console.log("Yeah yeah!)");
	    console.log(gdata);
	    console.log(gdata[rownum]);
	    $("#ptechName").html(gdata[rownum].codingProblmesLinkVO.techName);
	    $("#ptestName").html(gdata[rownum].codingProblemsVO.title);
	    $("#pemailid").html(gdata[rownum].codingProblmesLinkVO.email);
	    $("#ttestCasePassed").html(gdata[rownum].testPassed);
	    $("#ttestCaseFailed").html(gdata[rownum].testFailed);
	    $("#tgrade").html(gdata[rownum].grade);
	    $("#scode").html(gdata[rownum].javacode);
	    $("#ttestdate").html(gdata[rownum].doe);
	    
	   	$("#problemResultSummary").modal("show");
   } 	

</script>

<!-- Modal -->
<form  id="sendLinkModelForm">
<div id="problemResultSummary"  class="modal fade" role="dialog">
  <div class="modal-dialog" style="width:950px;">
    <!-- Modal content-->
    <div  class="modal-content" style="background-image: url('${pageContext.request.contextPath}/images/bg/backgrounds.jpg');">
      <div class="modal-header"  style="background-color: #ff9a9a;height: 35px; ">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      <img src="${pageContext.request.contextPath}/images/codings/coding-icon.png" width="40px;"/>
            <p style="display: inline;margin-left: 20px;">   <span style="font-weight: bold;" id="name"></span></p>
      </div>	
      <div class="bloading">
      <div class="modal-body">
       
   			<input type="hidden" name="techName" id="ttechName"/>
   			<input type="hidden" name="problemId" id="cpid"/>
   			<input type="hidden" name="problemTitle" id="problemTitle"/>
   			
              <div class="form-group" style="font-size: 15px;">
       Technology   :   <span style="font-weight: bold;color:red;">*</span>
        	<label style="font-weight: bold;margin-right: 50px;" id="ptechName">Core Java</label>
        	
        	Coding Name   :   <span style="font-weight: bold;color:red;">*</span>
     		   	<label style="font-weight: bold;margin-right: 50px;" id="ptestName">Java String Problem</label>
        		
        		Email   :   <span style="font-weight: bold;color:red;">*</span>
        	<label style="font-weight: bold;" id="pemailid">menou3w7737373teddgdgd@gmail.com</label>
        	
        	
        </div>
        
        <hr/>
         
      <div class="form-group" style="font-size: 15px;">
     	  Test Cases Passed   :   <span style="font-weight: bold;color:red;">*</span>
        	<label style="font-weight: bold;margin-right: 50px;" id="ttestCasePassed">5</label>
        	
        	Test Cases Failed   :   <span style="font-weight: bold;color:red;">*</span>
     		   	<label style="font-weight: bold;margin-right: 50px;" id="ttestCaseFailed">1</label>
        		
        		Grade   :   <span style="font-weight: bold;color:red;">*</span>
        	<label style="font-weight: bold;margin-right: 50px;" id="tgrade">Good</label>
        	
        		DOT   :   <span style="font-weight: bold;color:red;">*</span>
        	<label style="font-weight: bold;color:#b57d2a;" id="ttestdate">09-08-2018</label>
        </div>
        
        <div class="form-group">
          <span style="font-size: 16px;font-weight: bold;">Coding Exercise :</span> 
          <textarea  cols="10" rows="15" class="form-control" id="scode" name="scode"></textarea>
      	 		
        </div>
        
      </div>
      </div>
      <div class="modal-footer">
        	<input type="button" value="Close"  class="mc-btn btn-style-1" id="close"  data-dismiss="modal"/>
      </div>
    </div>

  </div>
</div>
</form>


</body>

</html>