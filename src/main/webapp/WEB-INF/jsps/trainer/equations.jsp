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
    <title>${companyName} - Equations-Special Page</title>
       
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
  <section style="padding-top: 0px;padding-bottom:10px;background-color: #eee;min-height:580px;" id="quizz-intro-section">
  	<br/>
        <div class="container" style="background-color: white;">
		 <div class="title-ct">
		 <br/>
                 &nbsp;&nbsp;
                 <img src="${pageContext.request.contextPath}/images/icon/Icon_01.png" width="40px;"/>
                 <h3 style="color: black;font-size: 18px;display: inline;"> <b> Page  -> Equations Image Page:-</b></h3>
                  <br/>     <br/>
            </div>
               		  <span>
               		   <form:form id="techUnitNameForm"
							action="${pageContext.request.contextPath}/action/equations/tech-units-images"
							method="POST">	
						<img src="${pageContext.request.contextPath}/images/lock-unlock-bar.png" style="height: 40px;"/>		
						<h3 style="font-size: 18px;display: inline;"> Technology:</h3>
						<select class="form-control" name="techName" id="selectedTechName" style="width: 300px;display: inline;margin-left: 10px;margin-right: 50px;">
									<k:forEach items="${technologies}" var="item">
											<option ${param.techName==item.tname?'selected':''}>${item.tname}</option>
									</k:forEach>
						 </select> 
						 <h3 style="font-size: 18px;display: inline;"> Unit:</h3>
						 <select class="form-control" name="units" id="units" style="width: 200px;display: inline;margin-right: 50px;">
						 			<option>General</option>
									<k:forEach items="${units}" var="unit">
											<option ${param.units==unit.name?'selected':''}>${unit.name}</option>
									</k:forEach>
									
						 </select> 
						 	<input type="submit"  value="LOAD..." class="mc-btn btn-style-1" style="background-color: #4594fd" id="updateCompanyBusinessItem"/>
				   </form:form>
					<a href="javascript:openPopupModal();" style="font-size: 16px;color:black;"><img src="${pageContext.request.contextPath}/images/icon/upload-images.jpg" style="width:70px;margin-left: 40px;display: inline;"><b>Upload Images</b></a>
			
				</span>

						
             <form:form id="userTestHistoryForm"
							action="${pageContext.request.contextPath}/action/user-test-history"
							method="POST">
							<input type="hidden" name="userid" id="userid"/> <br /> 
							<section style="margin-left: -16px;">
							<div class="col-xs-12">
								
						 </div>
						</section>
							<hr style="color: blue;border-top:1px solid #fdd12b" />		
							 <span id="ApplicationMessage" style="font-size: 14px;color:#ea5827;font-weight: bold;">${ApplicationMessage}...</span>
					 		<br/><br/>
            <div class="table-student-submission">
           <img src="${pageContext.request.contextPath}/images/icon/cheers.png" width="30px;"/> <span style="font-size: 16px;">Equations(s) List: - &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; (Base Path = <b>${param.techName}/${param.units}</b>)</span>
					    <div style="float: right;">
								<img src="${pageContext.request.contextPath}/images/favicon.ico" height="30px">&nbsp;<span style="font-size: 14px;">Total Records :</span> <b><span id="totalUsers" style="margin-right: 10px;">${fn:length(listOfFiles)}</span></b>
							</div>
                <table class="table table-bordered" id="tab1" style="margin-bottom: 0px;font-size: 15px;">
                    <thead>
                        <tr style="background-color: #607D8B;">
                            <th class="submissions" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">SNo</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Name</th>
                                <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Image</th>
                         <!--    <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">URL </th> -->
                            <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">File Name</th>
                               <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Action</th>
                        </tr>
                    </thead>

                    <tbody>
                      <k:forEach items="${listOfFiles}" var="item" varStatus="ooo">
					       <tr style="color: black">
					     <td bgcolor="white">&nbsp;${ooo.count}</td>
					   	   <td bgcolor="white">&nbsp;${item.name}</td>
					   	   <td bgcolor="white" align="center">&nbsp;<img  src="${pageContext.request.contextPath}/images/${fn:substring(item.path, fn:indexOf(item.path, 'images')+7,fn:length(item.path))}"></td>
					   <%-- 	  <td bgcolor="white">&nbsp;
					   	    ${fn:substring(item.path, fn:indexOf(item.path, "images")+7,fn:length(item.path))}
					   	   	</td> --%>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;
					   	    		<a href="javascript:deleteRecord('${item.name}');"><img src="${pageContext.request.contextPath}/images/delete-q.png"/></a>
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
					     </tr>
					   <tr  style="color: black">
					     <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	    <td bgcolor="white">&nbsp;</td>
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

//delete record 
function deleteRecord(imageName) {
		var yesno=confirm("Are you sure want to delete this image ?");
		if(yesno) {
			  //window.location.href=ccontextPath+"/equations/maths/dimage?imageName="+imageName;
			 $("#pimageName").val(imageName);
			 $("#dtechName").val($("#selectedTechName").val());
			 $("#dunits").val($("#units").val());
			 $("#deleteImageForm").submit();
		}
}

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
      	tableContent=tableContent+'<th class="submissions" style="color: white;font-size: 14px;">SNo</th>';
      	tableContent=tableContent+'<th class="author" style="color: white;font-size: 14px;">Consultant Id</th>';
      	tableContent=tableContent+'<th class="author" style="color: white;font-size: 14px;">Name</th>';
      	tableContent=tableContent+' <th class="author" style="color: white;font-size: 14px;">Email </th>';
    	tableContent=tableContent+' <th class="author" style="color: white;font-size: 14px;">Password </th>';
      	tableContent=tableContent+'<th class="submit-date" style="color: white;font-size: 14px;">Photo</th>';
      	tableContent=tableContent+'<th class="author" style="color: white;font-size: 14px;">Mobile</th>';
      	tableContent=tableContent+'<th class="author" style="color: white;font-size: 14px;">Stream</th>';
    	tableContent=tableContent+'<th class="author" style="color: white;font-size: 14px;">Lock/Unlock</th>';
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
	 
	  // loadData(); 

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
    
 });
 
 
	 function openPopupModal() {
		 $("#unitName").val($("#units").val());
		 $("#ptechName").val($("#selectedTechName").val());
		 $("#ttechName").val($("#selectedTechName").val());
		 $("#imageUploadModel").modal("show");
	 }
	  
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

<form id="deleteImageForm" action="${pageContext.request.contextPath}/action/equations/maths/dimage">
	 <input type="hidden" name="imageName" id="pimageName"> 	
	 <input type="hidden" name="techName" id="dtechName"> 	
	 <input type="hidden" name="units" id="dunits"> 	
	 
</form>

<!-- Modal -->
<form  id="companyBusinessModelForm" action="${pageContext.request.contextPath}/action/equations/upload-images"  method="post" enctype="multipart/form-data">
<div id="imageUploadModel" class="modal fade" role="dialog" style="margin-top: 60px;">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content" style="background-image: url('${pageContext.request.contextPath}/images/bg/backgrounds.jpg');">
      <div class="modal-header"  style="background-color: #37abf2;height: 35px;margin-top: -30px; ">
      <button type="button" class="close" data-dismiss="modal">&times;</button>
      <input type="hidden" class="form-control" id="ptechName" name="techName"/>
      <img src="${pageContext.request.contextPath}/images/icon/user-icon.png" width="30px;"/>
            <p style="display: inline;margin-left: 20px;">   
            <span style="font-weight: bold;font-size: 16px;color:black;" id="name">
             Tech :- <span id="ttechName">Mathematics</span>	
            </span></p>
      </div>
      <div class="bloading">
      <div class="modal-body">
       <span style="color:red;font-size: 15px;" id="CompanyBusinessErrorMessage"></span>
       
       
      <div class="form-group">
      	 Unit Name   :   <span style="font-weight: bold;color:red;">*</span>
        <input type="text" class="form-control" id="unitName" name="unitName" value="Unit-1" readonly="readonly"/>
        </div>
          <br/>
        <label>
        Tech Name : <b>Mathematics</b>
        </label>
        <br/><br/>
        
          <div class="form-group">
        Select Images   :   <span style="font-weight: bold;color:red;">*</span>
        <input type="file" class="form-control" id="pcbtimage"  name="images" multiple="multiple"/>
            <img src="" id="cbtimage" style="height: 80px;"/>
        </div>
      </div>
      </div>
      <div class="modal-footer">
        	<input type="button" value="Close"  class="mc-btn btn-style-1" id="close"  data-dismiss="modal"/>
        	<input type="submit"  value="Upload Image" class="mc-btn btn-style-1" id="updateCompanyBusinessItem"/>
      </div>
    </div>

  </div>
</div>
</form>
</body>

</html>