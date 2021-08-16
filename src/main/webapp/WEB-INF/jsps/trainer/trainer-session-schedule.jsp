<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <title>${companyName} - Trainer  Session Schedule</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.5.2.js" ></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/trainer-css/trainer.css" type="text" media="all">
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>

 
 <script type="text/javascript">
 var ccontextPath="${pageContext.request.contextPath}";
 function deleteRecord(tsid){
	  var yesno=confirm("Are you sure want to delete this record?");
	  if(yesno) {
		  $("#tsid").val(tsid);
		  $("#deleteSessionForm").submit();
				 /*   $.getJSON(ccontextPath+"/action/delete-trainer-session",{tsid:tsid},function(jsonResponse) {
					 console.log(jsonResponse);
					  if(jsonResponse.status=="success") {
						  $("#"+tid).closest("tr").hide();
						  //var totalRecords= $("#totalRecords").html(); 
						  //totalRecords=parseInt(totalRecords)-1;
						  //$("#totalRecords").html(totalRecords); 
						  $("#applicationMessage").html(jsonResponse.message);
					  }		  
	}); */
	 }
 }
 
$(document).ready(function() {
			$("input[type='button'][id='addTrainerSession']").click(function() {
					  $("#addTrainerSessionModel").modal("show");
			});		
			
			$("input[type='button'][id='addTrainerSessionPopup']").click(function() {
				var techName=$("#techName").val();
		 		  if(techName=="0"){
					    	$("#ErrorMessage").html("Please select a technology.");
					    	$("#techName").focus();
					   	 return;
				  }
		 		
		 		 var batchName=$("#batchName").val();
		 		 if(batchName=="Select Batch"){
					    $("#ErrorMessage").html("Please select  a batch.");
					    $("#batchName").focus();
					    return;
				  }
		 	/* 	$.ajax({url:contextPath+"/action/add-trainerSession", type: 'POST',data:$("#addTrainerSessionModelForm").serialize(),success:function(jsonData) {  //data= this.responseText
		 			if(jsonData.status=='success') {
				    			$("#addTopicModel").modal("hide");
				    			$("#applicationMessage").html(jsonData.message);	
				    	  		$(".alert").show();
				    			//adding new row
				    	 		var tableContents="";
		 			}	
		 		}});
					 */
					$("#addTrainerSessionModelForm").submit();
		});		
			
			
});
</script>	
<style>
input[type=radio]{
  display:none;
}

input[type=radio] + label:before{
  content: '';
  display:inline-block;
  border-radius: 10px;
  width: 16px;
  height:16px;
  background:#fdfdfa;
  color:blue;
  border: 1px solid black;
  line-height: 15px;
  text-align: center;
  font-size:25px;
  margin-right: 5px;
}

input[type=radio]:checked + label:before{
  color: red;
   background:#37abf2;
}
</style>
</head>
<body>

<!-- PAGE WRAP -->
<div id="page-wrap">

       <div class="body121">
  <div class="main">
      <k:if test="${sessionScope.user_session_data.role=='trainer'}">	
      <%@include file="../trainer/theader.jsp"%>
      </k:if>
        <k:if test="${sessionScope.user_session_data.role=='admin'}">	
       <%@include file="/aheader.jsp"%>
       </k:if>
          <k:if test="${sessionScope.user_session_data.role=='consultant'}">	
       <%@include file="/uheader.jsp"%>
       </k:if>
  </div>
</div>

    <!-- PROFILE FEATURE -->
    <%@include file="profile-feature.jsp" %>
    <!-- END / PROFILE FEATURE -->

    <!-- CONTEN BAR -->
     <%@include file="content-bar.jsp" %>
   <!-- END / CONTENT BAR -->
  <form id="deleteSessionForm" action="${pageContext.request.contextPath}/action/delete-trainer-session" method="post">
  		<input type="hidden" name="tsid" id="tsid">
  </form>
    <!-- COURSE CONCERN -->
   <section class="quizz-intro-section" style="padding-top: 0px;padding-bottom:10px;background-color: #eee;min-height: 600px;" id="content">
        <div class="container">
        <br/>
         <div class="title-ct">
                 &nbsp;&nbsp;<h3 style="color: black;font-size: 17px;display: inline;margin-right: 150px;"><img src="${pageContext.request.contextPath}/images/document-paper-64.png" width="40px;"/> - <b> Trainer Session Details -> &nbsp;&nbsp;&nbsp;&nbsp;<span style="color:#2196f3;"></span></b></h3>
                     <span style="float: right;">
                   <input type="button" value="Add Session"	class="mc-btn btn-style-1" id="addTrainerSession"/> 
                   </span>
            </div>
				<%-- <span style="color: red;font-size:14px;font-weight: bold;" id="applicationMessage">${ApplicationMessage}</span> --%>
				 <div class="alert alert-info fade in" style="margin-top: 20px;padding: 8px;" id="alertMessage">
   			    		 <strong>Note!</strong> <span style="font-size:14px;font-weight: bold;" id="applicationMessage">${param.ApplicationMessage}</span> 
			    </div>
        	<table class="table table-bordered">
      			 	 <tbody>
      			 	  <tr height="25px" >
					     <td style="width: 20%;">
					       <span style="font-size: 16px;">Select Batch&nbsp; :</span> 
					     </td>
					     <td>
					       	<select name="batch"  class="input-large form-control" style="width:300px;display:inline;" id="batch">
					       		 <option>--Select--</option>
					       	 	   <c:forEach items="${batchList}"  var="item">
        								<option>${item}</option>
        							</c:forEach>
					       	</select>
					     </td>
					   </tr>
      			 
					  </tbody>
					 </table>
					 <c:forEach var="item" items="${batchTrainerSessionList}">
					 	<div>
					   <hr style="color: blue;height: 5px;background-color: #37abf2;"/>
					   <img src="${pageContext.request.contextPath}/images/test-icon.png" style="margin-top: -5px; width: 25px;"> 
					    <span style="font-size: 16px;">Batch Name : <b>${item.key}</b></span>
					    <span style="font-size: 16px;margin-left: 100px;">Start Date : 12-Apr-2018</span>
					    <div style="float: right;">
                           <img src="${pageContext.request.contextPath}/images/favicon.ico"width="25px;">   <span style="font-family: 'Lato', sans-serif;font-size: 14px;">Total Records :</span> <b><span id="totalRecords">${fn:length(item.value)}</span></b>
                             </div> 
                             <table class="table  table-bordered" id="tableContent" style="font-size: 15px;">
      			            <tr style="color: white;background-color:#013648">
      			          <td class="score" style="width:4%">SNo </td>
                            <td class="submit-date" style="width:15%">Technology</td>
                            <td class="author" style="width:20%">Trainer Name</td>
                            <td class="submit-date" style="width:19%">First Half</td>
                             <td class="submit-date" style="width:19%">Middle Half</td> 
                        	<td class="submit-date" style="width:19%">Second Half</td> 
                        		<td class="submit-date" style="width:4%">&nbsp;</td> 
                         </tr>

						  <c:forEach items="${item.value}" var="iitem" varStatus="ol">
					     <tr height="30px" style="vertical-align: middle;" align="left"  id="${iitem.tsid}">
								     <td>&nbsp;${ol.count}</td>
								      <td>&nbsp;${iitem.technology}</td>
								   	    <td style="background-color: ${iitem.tcolor}">&nbsp;${iitem.trainer}</td>
								   	  <td style="background-color:${iitem.fcolor}">&nbsp;${iitem.firsthalf}</td>
								   	   <td style="background-color:${iitem.mcolor} ">&nbsp;${iitem.middlehalf}</td>
								   	    <td style="background-color: ${iitem.scolor}">&nbsp;${iitem.secondhalf}</td>
								   	    <td><a href="javascript:deleteRecord(${iitem.tsid});"><img src="${pageContext.request.contextPath}/images/icon/delete.png"></a></td>
					     </tr>
					     </c:forEach>
					   
					        <tr height="30px" style="vertical-align: middle;" align="center">
					     <td width="10px">&nbsp;</td>
					      <td width="10px">&nbsp;</td>
					   	   <td width="300px">&nbsp;</td>
					   	   <td>&nbsp;</td>
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
					   	      <td>&nbsp;</td>
					     </tr>
					</table>     
					</div>
					</c:forEach>
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

<!-- Modal -->
<form  id="addTrainerSessionModelForm" action="${pageContext.request.contextPath}/action/add-trainer-session" method="post" >
<div id="addTrainerSessionModel" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content" style="background-image: url('${pageContext.request.contextPath}/images/bg/backgrounds.jpg');">
      <div class="modal-header"  style="background-color: #37abf2;height: 35px; ">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      <img src="${pageContext.request.contextPath}/images/course-icon.png" width="30px;"/>
            <p style="display: inline;margin-left: 20px;">   <span style="font-weight: bold;" id="name"></span></p>
      </div>
      <div class="bloading">
      <div class="modal-body">
           <span style="color:red;font-size: 15px;" id="ErrorMessage"></span>
              <hr/>
              <div class="form-group">
       Technology   :   <span style="font-weight: bold;color:red;">*</span>
        		<select class="form-control" name="techName" id="techName">
        		     <option value="0">Select Technology</option>
        		    <c:forEach items="${techidnameMap}"  var="item">
        			<option value="${item.key}">${item.value}</option>
        			</c:forEach>
        		</select>
        </div>
               <div class="form-group">
       Batch   :   <span style="font-weight: bold;color:red;">*</span>
        		<select class="form-control" name="batchName" id="batchName">
        		    <c:forEach items="${batchList}"  var="item">
        			<option>${item}</option>
        			</c:forEach>
        			
        		</select>
        </div>
           
      <div class="form-group">
      		Trainer Name    :   <span style="font-weight: bold;color:red;">*</span>
     	 <select class="form-control" name="trainerName" id="trainerName">
     	   			<c:forEach items="${trainerNameList}"  var="item">
        			<option>${item}</option>
        			</c:forEach>
        			
        		</select>
        </div>
        
        
           <div class="form-group">
      		Meeting    :   <span style="font-weight: bold;color:red;">*</span>
     	 <select class="form-control" name="meeting" id="meeting">
        			<option value="100">First Half</option>
        		<option value="200">Middle Half</option>
        			<option value="300">Second Half</option>
        		</select>
        </div>
        
      </div>
      </div>
      <div class="modal-footer">
        	<input type="button" value="Close"  class="mc-btn btn-style-1" id="close"  data-dismiss="modal"/>
        	<input type="button"  value="Add Session" class="mc-btn btn-style-1" id="addTrainerSessionPopup"/>
      </div>
    </div>

  </div>
</div>
</form>
</body>

</html>