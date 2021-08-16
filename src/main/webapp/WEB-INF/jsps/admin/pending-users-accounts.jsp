<%@page import="java.util.List"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <META HTTP-EQUIV="Refresh" CONTENT="50">
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <title>${companyName} - Approve User Account</title>
       
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
      <%@include file="../trainer/theader.jsp"%>
      </k:if>
        <k:if test="${sessionScope.user_session_data.role=='admin'}">	
       <%@include file="../admin/aheader.jsp"%>
       </k:if>
  </div>
</div>

    <!-- PROFILE FEATURE -->
    <%@include file="profile-feature.jsp" %>
    <!-- END / PROFILE FEATURE -->


    <!-- CONTEN BAR -->
   <!-- END / CONTENT BAR -->
 
    <!-- COURSE CONCERN -->
  <section style="padding-top: 0px;background-color: #eee;min-height:680px;" id="quizz-intro-section">
  		<hr/>
        <div class="container" style="background-color: white;">
						 <img src="${pageContext.request.contextPath}/images/login.gif" style="height:70px;display: inline;"/><h3 style="font-size: 16px;display: inline;"> Action - > Pending User  Approval Page :</h3>
						 <span style="float: right;">
						   <a href="${pageContext.request.contextPath}/action/add-consultant" style="font-size: 16px;color:black;">
						  <img src="${pageContext.request.contextPath}/images/wow.png" style="height:80px;display: inline;"/>
						   Add New Consultant
						  </a>
						  </span>	
             <form:form id="userTestHistoryForm"
							action="${pageContext.request.contextPath}/action/user-test-history"
							method="POST">
							<input type="hidden" name="userid" id="userid"/>
							<hr style="color: blue" />		
							 <span id="ApplicationMessage" style="font-size: 14px;color:blue;"></span>
            <div class="table-student-submission">
           <img src="${pageContext.request.contextPath}/images/icon/cheers.png" width="30px;"/> <span style="font-size: 16px;">User(s) List:-</span>
					    <div style="float: right;">
								<img src="${pageContext.request.contextPath}/images/favicon.ico" height="30px">&nbsp;<span style="font-size: 16px;">Total Users :</span> <b><span id="totalUsers">${fn:length(userFormList)}</span></b>
							</div>
                <table class="table table-bordered" id="tab1" style="margin-bottom: 0px;min-height: 500px;font-size: 16px;">
                    <thead>
                        <tr style="background-color: #607D8B;">
                            <th class="submissions" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">SNo</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Name</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Email </th>
                            <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Mobile</th>
                            <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Photo</th>
                               <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Role</th>
                                  <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">RDate</th>
                            <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Lock/Unlock</th>
                        </tr>
                    </thead>

                    <tbody>
                    
                      <k:forEach items="${userFormList}" var="item" varStatus="pkk">
					       <tr style="color: black" id="rownum_${item.empid}">
					     <td bgcolor="white">&nbsp;${pkk.count}</td>
					   	   <td bgcolor="white">&nbsp;${item.firstName}&nbsp;&nbsp;${item.lastName}</td>
					   	   <td bgcolor="white">&nbsp;${item.email}</td>
					   	    <td bgcolor="white">&nbsp;${item.mobile}</td>
					   	   <td>&nbsp;<img src="${pageContext.request.contextPath}/action/imageByUserId?userid=${item.loginid}" style="height: 40px;"/></td>
					   	   <td>&nbsp;${item.role}</td>
					   	   <td>&nbsp;${item.doe}</td>
					   	    <td style="width: 130px;">
					   	   <%--  <img src="${pageContext.request.contextPath}/images/icon/ac-icon.png"/>
					   	    &nbsp;&nbsp;
					   	    &nbsp; --%>
					   	   <%--   <a href="javascript:openApproveTrainerModel('${item.firstName}  ${item.lastName}','${item.email}',${item.id});"><img src="${pageContext.request.contextPath}/images/icon/at-icon.png"/> --%>
					   	    		
   	       <input type="button" value="Approved"	class="mc-btn btn-style-1" id="sendLink" style="background-color: #f96e15;;margin: 0px;font-size: 14px;width: 100px;" onclick="javascript:openApproveTrainerModel('${item.firstName}  ${item.lastName}','${item.email}','${item.empid}',${item.id});"/> 
					   
					   	    </a>
					   	    
					   	    </td>
					     </tr>
			</k:forEach>
					     <tr style="color: black">
					     <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	    <td bgcolor="white">&nbsp;</td>
					   	   <td>&nbsp;</td>
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
					   	      <td>&nbsp;</td> <td>&nbsp;</td>
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
    
    
    function openApproveTrainerModel(name,email,empid,csaid){
		$("#name").html(name);
		$("#email").html(email);
		$("#hemail").val(email);
		$("#consultantId").val("E"+empid);
		$("#tcid").val(csaid);
		$("#empid").val(empid);
		$("#approveTrainerModel").modal("show");
	}
    
    
    function approveRemoteUser(){
    	//Hiding the row of the table after the approval
    			var contextPath="${pageContext.request.contextPath}";
					$.ajax({url:contextPath+"/action/approve-pending-user", type: 'POST',data:$("#approveTrainerModelForm").serialize(),success:function(jsonData) {  //data= this.responseText
						//data is JavaScript object against JSON response coming fromm the server
							console.log(jsonData);
							if(jsonData.status=='success') {
								var empid=$("#empid").val();
						    	$("#rownum_"+empid).hide();
						    	$("#approveTrainerModel").modal("hide");
						    	$("#ApplicationMessage").html(jsonData.message);	
							}else {
								$("#ApplicationMessage").html(jsonData.message);	
							 	//$("#approveTrainerModel").modal("hide");
							}
					}
					});	 //end of the ajax		
    	
    }

</script>

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