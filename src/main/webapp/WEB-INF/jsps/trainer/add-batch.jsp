<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon-96x96.png" />
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <title>${companyName} - Add Batch</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.5.2.js" ></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/trainer-css/trainer.css" type="text" media="all">
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>

     <style>
<!--
input[type="checkbox"] { -webkit-appearance: checkbox; }
input[type="radio"] { -webkit-appearance: radio; }
input[type="submit"], input[type="button"] { -webkit-appearance: button; }
select { -webkit-appearance:textfield; }
-->
</style>
 <script type="text/javascript">
 $(document).ready(function() {
	 
	  $("#applicationMessage").html("");
	   $(".alert").hide();
	 $("input[type='button'][id='addBatch']").click(function() {
		  $("#applicationMessage").html("");
		   $(".alert").hide();
		  //alert(techName);
			$("#batch").val("");
			$("#comment").val("");
		    $("#addBatchModel").modal("show");
	});
	 
	 $("input[type='text']").keyup(function(){
		 $("#errorMessage").html("");
	 });
		//alert("good morning!");
  	 $("input[type='button'][id='addNewBatch']").click(function() {
  		    //validating the test name
  		    var batch=$("input[type='text'][name='batch']").val();
  			if(batch.length==0){
  					$("#ErrorMessage").html("Batch Name  cannot be blank.......");
  					$("input[type='text'][name='batch']").focus();
  					return;
  			}else{
  				var ccontextPath="${pageContext.request.contextPath}";
  				$.getJSON(ccontextPath+"/action/check-batch", {batch:batch}, function(jsonResponse) {
  					if(jsonResponse.status=="yes"){
  						$("#ErrorMessage").html("Sorry this  batch name is already in use.......");
  	  					$("input[type='text'][name='batch']").focus();
  	  					status=0;
  	  					return;
  					}else{
  						var comment=$("input[type='text'][name='comment']").val();
  			  			if(comment.length==0){
  			  					$("#ErrorMessage").html("Comement cannot be blank.......");
  			  					$("input[type='text'][name='comment']").focus();
  			  					return;
  			  			}
  			  			//submittin the form using JavaScript and jQuery
  			  			//$("#createBatchForm").submit();
  			  			///#########################################
  			  				var contextPath="${pageContext.request.contextPath}";
  			  			$.ajax({url:contextPath+"/action/add-batch", type: 'POST',data:$("#addBatchModelForm").serialize(),success:function(jsonData) {  //data= this.responseText
					//data is JavaScript object against JSON response coming fromm the server
						console.log(jsonData);
						if(jsonData.status=='success') {
					    	$("#addBatchModel").modal("hide");
					    	 $("#applicationMessage").html(jsonData.message);	
					    	  $(".alert").show();
					    	//adding new row
					    	 var tableContents="";
					    	 var today = new Date();
					    	 var dd = today.getDate();
					    	 var mm = today.getMonth()+1; //January is 0!
					    	 var yyyy = today.getFullYear();
					    	 if(dd<10){
					    	     dd='0'+dd;
					    	 } 
					    	 if(mm<10){
					    	     mm='0'+mm;
					    	 } 
					    	  var date = dd+'-'+mm+'-'+yyyy;
					    	  //document.getElementById("DATE").value = today;
					    	  var totalRecord=$("#totalRecords").html();
					    	  var nextNo=parseInt(totalRecord)+1;
					    	  tableContents=tableContents+' <tr height="25px" style="color: black">';
		 				 	  tableContents=tableContents+'<td><b>'+nextNo+'.</b></td>';
		 				 	  tableContents=tableContents+' <td>&nbsp;'+batch+'</td>';
		 				 	  tableContents=tableContents+'<td>&nbsp;'+comment+'</td>';
		 				 	  tableContents=tableContents+'<td align="center">&nbsp;'+date+'</td>';
		 				 	 var activeyesno = $("input[name='active']:checked").val();
		 					  tableContents=tableContents+'<td align="center">&nbsp;'+activeyesno+'</td>';
		 				 	  tableContents=tableContents+' <td align="center">';
		 				 	  var tid=jsonData.cmessage;
		 				 	  tableContents=tableContents+' <a href="#"';
		 				 	  tableContents=tableContents+' <img alt="" src="${pageContext.request.contextPath}/images/close.png"/>';
		 				 	  tableContents=tableContents+' </a>';
		 				 	  tableContents=tableContents+' / ';
		 					  tableContents=tableContents+' <img alt="" src="${pageContext.request.contextPath}/images/edit.png"/>';
		 				 	  tableContents=tableContents+' </td>';
		 				 	  tableContents=tableContents+' </tr>';
		 					   $("#totalRecords").html(nextNo); 
		 		 			   $("#tableContent").append(tableContents);
						}else {
							  $("#applicationMessage").html("There is some problem to process this request ,please contact to the app admin.");	
							   $(".alert").show();
							  $("#addTopicModel").modal("hide");
						}
					} //end of the method
				});	 //end of the ajax	
  			  			
  			  			
  			  			/////###############################
  					}
  				}); 
  			}
	 });
  	 
  	 $("input[type='text'][id='batch']").keyup(function(){
	  		 $("#ErrorMessage").html("");
	 });
	 $("input[type='text'][id='comment']").keyup(function(){
  		 $("#ErrorMessage").html("");
 });
  	 
});
</script>	
</head>
<body id="page2">
<!-- PAGE WRAP -->
  <div class="main">
      <k:if test="${sessionScope.user_session_data.role=='trainer'}">	
      <%@include file="theader.jsp"%>
      </k:if>
        <k:if test="${sessionScope.user_session_data.role=='admin'}">	
       <%@include file="/aheader.jsp"%>
       </k:if>
  </div>
    <!-- PROFILE FEATURE -->
    <%@include file="profile-feature.jsp" %>
    <!-- END / PROFILE FEATURE -->


    <!-- CONTEN BAR -->
     <%@include file="content-bar.jsp" %>
   <!-- END / CONTENT BAR -->
 
    <!-- COURSE CONCERN -->
    
      <!-- COURSE CONCERN -->
      <section class="quizz-intro-section" style="padding-top: 0px;padding-bottom:10px;background-color: #eee;min-height: 600px;" id="content">
        <div class="container">
         <div class="title-ct">
         		<br/>
                 &nbsp;&nbsp;<h3 style="color: black;font-size: 17px;display: inline;"><img src="${pageContext.request.contextPath}/images/document-paper-64.png" width="40px;"/> - <b> Add/Edit Batch</b></h3>
                   <span style="float: right;">
                   <input type="button" value="Add New Batch"	class="mc-btn btn-style-1" id="addBatch"/> 
                   </span>
                   <br/>   <br/>
            </div>
				<%-- <span style="color: red;font-size:14px;font-weight: bold;" id="applicationMessage">${ApplicationMessage}</span> --%>
				 <div class="alert alert-info fade in" style="margin-top: 20px;padding: 8px;" id="alertMessage">
   			    		 <strong>Note!</strong> <span style="font-size:14px;font-weight: bold;" id="applicationMessage">${ApplicationMessage}</span> 
			    </div>
					   <hr style="color: blue;height: 5px;background-color: #37abf2;"/>
					   <img src="${pageContext.request.contextPath}/images/test-icon.png" style="margin-top: -5px; width: 25px;"> 
					    <span style="font-size: 16px;">Batch List:-</span>
					    <div style="float: right;">
                           <img src="${pageContext.request.contextPath}/images/favicon.ico"width="25px;">   <span style="font-family: 'Lato', sans-serif;font-size: 14px;">Total Records :</span> <b><span id="totalRecords">${fn:length(batchVOs)}</span></b>
                             </div> 
                             <table class="table  table-bordered" id="tableContent">
      			            <tr style="color: white;background-color:#013648">
      			          <td class="score" style="width:5%">SNo </td>
                            <td class="submit-date" style="width:25%">Batch Name</td>
                            <td class="author" style="width:30%">Description</td>
                            <td class="submit-date" style="width:20%">Doe</td>
                             <td class="submit-date" style="width:15%">Active</td>
                             <td class="submit-date" style="width:5%">OP</td> 
                         </tr>
                       <c:forEach items="${batchVOs}" var="item" varStatus="cool">
					     <tr height="30px" style="vertical-align: top: ;" align="left">
					        <td>&nbsp;${cool.count}</td>
					     <td width="10px">&nbsp;${item.batch}</td>
					      <td width="10px">&nbsp;${item.comment}</td>
					   	   <td width="10px">&nbsp;${item.doe}</td>
					   	    <td width="10px">&nbsp;${item.active}</td>
					   	    <td align="center">&nbsp;<a href="#"><img src="${pageContext.request.contextPath}/images/icon/edit.png" style="height: 30px;"/></a></td>
					     </tr>
					     </c:forEach>
					    
					  <tr height="30px" style="vertical-align: middle;" align="center">
					     <td width="10px">&nbsp;</td>
					      <td width="10px">&nbsp;</td>
					   	   <td width="300px">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	      <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					     </tr>
					        <tr height="30px" style="vertical-align: middle;" align="center">
					     <td width="10px">&nbsp;</td>
					      <td width="10px">&nbsp;</td>
					   	   <td width="300px">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	      <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					     </tr>
					        <tr height="30px" style="vertical-align: middle;" align="center">
					     <td width="10px">&nbsp;</td>
					      <td width="10px">&nbsp;</td>
					   	   <td width="300px">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	      <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					     </tr>
					        <tr height="30px" style="vertical-align: middle;" align="center">
					     <td width="10px">&nbsp;</td>
					      <td width="10px">&nbsp;</td>
					   	   <td width="300px">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					   	       <td>&nbsp;</td>
					     </tr> 
					</table>     
				
					</div>
    </section>

    <!-- END / COURSE CONCERN -->
      
<%--    <section class="quizz-intro-section" style="padding-top: 0px;padding-bottom:10px;background-color: #eee;min-height: 600px;" id="content">
        <div class="container">
         <div class="title-ct">
             <br/>  
                 &nbsp;&nbsp;<h3 style="color: black;font-size: 17px;display: inline;"><img src="${pageContext.request.contextPath}/images/executive.png" width="40px;"/> - <b> Create New Batch Page</b></h3>
              
            </div>
                <hr style="height: 5px;background-color: #8cdf9d;"/>
				<span style="color: red;font-size:14px;font-weight: bold;" id="applicationMessage">${ApplicationMessage}</span>
              	<form id="createBatchForm" method="POST"
								action="${pageContext.request.contextPath}/action/add-batch"
								class="form-horizontal" >
								<hr style="color: red; width: 100%" />
								<span style="color: blue;font-size: 16px;"  id="errorMessage">${AppMessage}</span>
								<fieldset style="border-width:4px !important;border-color: red; ">
    								<legend style="color:black;font-weight:bold;font-size: 17px;">Batch Details</legend>
    								  <div>
								<div class="form-group">
									<label class="col-sm-2 control-label" style="font-family: 'Lato', sans-serif;font-size: 14px;">Name * </label>
									<div class="col-sm-5">
										<input type="text" class="form-control"
											id="batch" name="batch"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" style="font-family: 'Lato', sans-serif;font-size: 14px;">Comment *</label>
									<div class="col-sm-7">
										<input type="text" name="comment" class="form-control " id="comment" />
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label" style="font-family: 'Lato', sans-serif;font-size: 14px;">&nbsp;</label>
									<div class="col-sm-7">
									 &nbsp;
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label" style="font-family: 'Lato', sans-serif;font-size: 14px;">Active *</label>
									<div class="col-sm-7">
      									<input type="radio" name="active" value="YES" checked="checked"/>
      									<label class="control-label" style="font-family: 'Lato', sans-serif;font-size: 14px;">
      									Yes
      									</label>
      									  &nbsp; &nbsp; &nbsp; &nbsp; 
     									<input type="radio" name="active" value="NO"/>
     									<label class="control-label" style="font-family: 'Lato', sans-serif;font-size: 14px;">No</label>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label" style="font-family: 'Lato', sans-serif;font-size: 14px;">&nbsp;</label>
									<div class="col-sm-7">
									 &nbsp;
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label" style="font-family: 'Lato', sans-serif;font-size: 14px;">&nbsp;</label>
									<div class="col-sm-7">
									 &nbsp;<input type="button" value="Create Batch" class="mc-btn btn-style-1" 
										id="createBatch" style="font-family: 'Lato', sans-serif;font-size: 14px;"/>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset"
										value="Clear" class="mc-btn btn-style-1" style="font-family: 'Lato', sans-serif;font-size: 14px;"/>
							
									</div>
								</div>
								</div>
								</fieldset>
								
								</form>
					</div>
    </section> --%>

    <!-- END / COURSE CONCERN -->
 <!-- FOOTER -->
    <footer id="footer" class="footer">

       <%@include file="/sfooter.jsp" %>
    </footer>
    
    
<!-- Load jQuery -->
<!-- Load jQuery -->
  <%@include file="/js.jsp" %>
    
    <!-- END / FOOTER -->
    <!-- Modal -->
<form  id="addBatchModelForm"  >
<div id="addBatchModel" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content" style="background-image: url('${pageContext.request.contextPath}/images/bg/backgrounds.jpg');">
      <div class="modal-header"  style="background-color: #37abf2;height: 35px; ">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      <img src="${pageContext.request.contextPath}/images/course-icon.png" width="30px;"/>
            <p style="display: inline;margin-left: 20px;">   <span style="font-weight: bold;color:black;" id="name">Add Batch</span></p>
      </div>
      <div class="bloading">
      <div class="modal-body">
        <hr/>
           <span style="color:red;font-size: 15px;" id="ErrorMessage"></span>
      <div class="form-group">
      	Batch Name    :   <span style="font-weight: bold;color:red;">*</span>
        <input type="text" class="form-control" id="batch" name="batch"/>
        </div>
        
          <div class="form-group">
       Comment   :   <span style="font-weight: bold;color:red;">*</span>
        <input type="text" class="form-control" id="comment" name="comment"/>
        </div>
        
                  <div class="form-group">
                     Active   :   <span style="font-weight: bold;color:red;">*</span>
     	<input type="radio" name="active" value="YES" checked="checked"/>
      									<label class="control-label" style="font-family: 'Lato', sans-serif;font-size: 14px;">
      									Yes
      									</label>
      									  &nbsp; &nbsp; &nbsp; &nbsp; 
     									<input type="radio" name="active" value="NO"/>
     									<label class="control-label" style="font-family: 'Lato', sans-serif;font-size: 14px;">No</label>
        </div>
        
      </div>
      </div>
      <div class="modal-footer">
        	<input type="button" value="Close"  class="mc-btn btn-style-1" id="close"  data-dismiss="modal"/>
        	<input type="button"  value="Add Batch" class="mc-btn btn-style-1" id="addNewBatch"/>
      </div>
    </div>

  </div>
</div>
</form>
</body>

</html>