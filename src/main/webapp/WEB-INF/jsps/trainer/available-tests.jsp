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
    <title>${companyName} - Send Guest Test Link</title>
       
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
   <!-- END / CONTENT BAR -->
 	
    <!-- COURSE CONCERN -->
  <section style="padding-top: 0px;;background-color: #eee;min-height: 500px;" id="quizz-intro-section">
  		<section id="topcontent">
   		</section>
        <div class="container" style="background-color: white;">
          <hr style="color: blue" />	
            <div class="title-ct" style="margin-top:0px;">
                <h3 style="color: black"><img src="${pageContext.request.contextPath}/images/icon/cheers.png" style="height:40px;"/> - <span style="font-size: 16px;">Test -> Send Guest Test Link</span>
                <label for="testName" style="font-size: 15px;margin-left: 100px;">Technology :&nbsp;&nbsp;&nbsp;</label>
								<select
								name="techName"  id="techName" class="form-control" style="display: inline;width: 300px;">
								<option value="All" selected="selected">All</option>
								<k:forEach var="techname" items="${techList}">
									<option value="${techname}">${techname}</option>
								</k:forEach>
							</select>
							<input type="button" value="Send Multiple Link(s)"	class="mc-btn btn-style-1" id="sendMultipleLink" style="background-color: #03a9f4;;margin: 0px;font-size: 14px;margin-left:60px;" onclick="sendMultipleTestLinks();"/> 
                 </h3>
                    
            </div>
            
           <k:if test="${availableTechList.size() == 0}">
              <h3 style="font-size: 18px;"><img src="${pageContext.request.contextPath}/images/icon/cube.png" style="height: 32px;margin-right: 10px;"> - No test is configured in portal by you , please go to test menu & configure a test.</h3>
           </k:if> 
             <form:form id="sendMutipleTestLinksForm"
							action="${pageContext.request.contextPath}/action/sendMutipleTestLinks"
							method="post">
							<hr style="color: blue" />		
					
					 <div class="alert alert-info fade in" style="margin-top: 20px;padding: 8px;font-size:16px;" id="alertMessage">
   			    		 <strong>Note!</strong> <span style="font-size:14px;font-weight: bold;" id="applicationMessage">${ApplicationMessage}</span> 
			    </div>
					 
            <div class="table-student-submission">
            <img src="${pageContext.request.contextPath}/images/icon/status.png" style="height: 32px;margin-right: 2px;">
            <span style="font-family: 'Lato', sans-serif;font-size: 16px;">Test(s) List:-</span>
					    <div style="float: right;">
								<img src="../images/favicon.ico" height="30px">&nbsp;<span style="font-family: 'Lato', sans-serif;font-size: 14px;">Total Test(s) :</span> <b><span id="totalUsers">${fn:length(availableTechList)}</span></b>
							</div>
                <table class="table table-bordered" id="tab1">
                    <thead>
                        <tr style="background-color: #607D8B;vertical-align:middle;">
                            <th class="submissions" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">SNo</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Tech Name</th>
                                    <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Icon</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Test Name </th>
                            <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Total Questions</th>
                            <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Duration</th>
                               <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">DOT Configured</th>
                                     <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;width:11%">Action</th>
                        </tr>
                    </thead>

                    <tbody id="partialContent">
                    
                    		<k:forEach var="item" items="${availableTechList}" varStatus="ooooo">
					       <tr style="color: black;vertical-align:middle;font-size: 13px;" id="${item.techName}_${item.testName}"  >
					     <td bgcolor="white">&nbsp;${ooooo.count}
					     &nbsp;&nbsp;
					     <input type="checkbox" class="control-class" name="selectedTests" id="selectedTests" value="${item.techName}__${item.testName}"/>	
					     </td>
					   	   <td bgcolor="white">&nbsp;${item.techName}</td>
					   	    	    <td>&nbsp;TODO</td>
					   	    	   <td bgcolor="white">&nbsp;${item.testName}</td>
					   	  <td bgcolor="white">&nbsp;${item.totalQuestions}</td>
					   	  <td bgcolor="white">&nbsp;${item.testDuration}</td>
					   	   <td bgcolor="white">&nbsp;${item.dateOfEntry}</td>
					   	    <td bgcolor="white">&nbsp;
					   	       <input type="button" value="Send Link"	class="mc-btn btn-style-1" id="sendLink" style="background-color: #00bcd4;;margin: 0px;font-size: 14px;width: 100px;" onclick="sendTestLink('${item.techName}','${item.testName}','${item.testDuration}');"/> 
					   	    <k:if test="${sessionScope.user_session_data.deleteAllow}">
					   		<a href="javascript:deleteTest('${item.techName}','${item.testName}');">
					   		 <img src="${pageContext.request.contextPath}/images/delete-q.png"/>
					   		</a>
							</k:if>
					   		</td>
					     </tr>
					     </k:forEach>

                    </tbody>
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
					   	      <td>&nbsp;</td>
					   	         <td>&nbsp;</td>
					     </tr>
					     
					     
					     
                </table>
                </div>
                </form:form>
            </div>
    </section>
            
        </div>


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

/*  $(document).ready(function(){
	 $("#testName").change(function(){
			loadData();	
		});
		$("#techName").change(function(){
			var techName=$(this).val();
			var ccontextPath="${pageContext.request.contextPath}";
			 $.getJSON(ccontextPath+"/action/findConfigureTestsByTechName", {techName:techName}, function(jsonResponse) {
				 	console.log(jsonResponse);
				 	$('#testName').empty()
				 	if(jsonResponse.length>0){
				 		 $.each(jsonResponse, function(i, item) {
				 			$("#testName").append($("<option />").val(item).text(item));
				 		});
				 	}
				 	//loadData();	
			 }//end of the callback function..................
			 );
		});		
		
		//Loading the data when page is loaded first time.........
		loadData();
 }); */

 function deleteTest(ptechName,ptestName){
	 console.log("techName = "+ptechName);
	 console.log("techName = "+ptestName);
		var ccontextPath="${pageContext.request.contextPath}";
	 $.getJSON(ccontextPath+"/action/deleteTestByTechName", {techName:ptechName,testName:ptestName}, function(jsonResponse) {
		 	console.log(jsonResponse);
		 	if(jsonResponse.status=='success') {
		 			 $("#"+ptechName+"_"+ptestName).hide();
		 			$("#ApplicationMessage").html(ptestName+ " has been deleted successfully for the technology "+ptechName);
		 	}
	 }); 	
 }
 function loadData() {
	 var techName=$("#techName").val();
	var ccontextPath="${pageContext.request.contextPath}";
	 $.getJSON(ccontextPath+"/action/findConfigureTestDetailsByTechName", {techName:techName}, function(jsonResponse) {
		 	///console.log(jsonResponse);
		 	var contentData="";
		 	  var deleteAllow="${sessionScope.user_session_data.deleteAllow}";
		 	  console.log("deleteAllow  =  "+deleteAllow);
		 	for(var row=0;row<jsonResponse.length;row++) {
		 		contentData=contentData+' <tr style="font-size: 13px;color: black"  id="'+jsonResponse[row].techName+'_'+jsonResponse[row].testName+'">';
		 		contentData=contentData+'  <td bgcolor="white">&nbsp;'+(row+1)+'</td>';
		 		contentData=contentData+' <td bgcolor="white">&nbsp;'+jsonResponse[row].techName+'</td>';
		 		contentData=contentData+'  <td>&nbsp;TODO</td>';
		 		contentData=contentData+'   <td bgcolor="white">&nbsp;'+jsonResponse[row].testName+'</td>';
		 		contentData=contentData+' 	  <td bgcolor="white">&nbsp;'+jsonResponse[row].totalQuestions+'</td>';
		 		contentData=contentData+' <td bgcolor="white">&nbsp;'+jsonResponse[row].testDuration+'</td>';
		 		contentData=contentData+'  <td bgcolor="white">&nbsp;'+jsonResponse[row].dateOfEntry+'</td>';
		 		contentData=contentData+'   <td bgcolor="white">&nbsp;';
		 		contentData=contentData+' <input type="button" value="Send Link"	class="mc-btn btn-style-1" id="sendLink" style="background-color: #00bcd4;;margin: 0px;font-size: 14px;width: 100px;" onclick="sendTestLink(\''+jsonResponse[row].techName+'\',\''+jsonResponse[row].testName+'\',\''+jsonResponse[row].testDuration+'\');"/>'; 
				   	
		 		if(deleteAllow==true){
		 			contentData=contentData+" <a href=\"javascript:deleteTest('"+jsonResponse[row].techName+"','"+jsonResponse[row].testName+"');\">";
		 			contentData=contentData+'  <img src="${pageContext.request.contextPath}/images/delete-q.png"/>';
		 			contentData=contentData+' </a>';
		 		}
		 		contentData=contentData+' </td>';
		 		contentData=contentData+'  </tr>';
		 	}
		 	if(jsonResponse.length==0){
		 		$("#alertMessage").html("No test is configured for selected technologty "+techName);
		 	    $(".alert").show();
		 	}else{
		 		$("#alertMessage").html("");
		 	   $(".alert").hide();
		 	}
		
		 	$("#partialContent").html(contentData);	
		 	//loadData();	
	 });//end of the callback function..................
	 
 }
 
$("#techName").change(function() {
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
    
   function sendTestLink(techname,testname,tduration) {
		$("#applicationMessage").html("");	
	    $(".alert").hide();
	   $("#ptechName").html(techname);
	   $("#ptestName").html(testname);
	   $("#ttechName").val(techname);
	   $("#testName").val(testname);
	   $("#tduration").val(tduration);
	   $("#sendLinkModel").modal("show");
   }
   function sendMultipleTestLinks() {
	   if($("input[type='checkbox'][id$='selectedTests']:checked").length == 0){
    	   $("#applicationMessage").html("Please select at least one test using check box. ");
		   $(".alert").show();
		   return;
	   }
	   
	   $("#applicationMessage").html("");	
	    $(".alert").hide();
	  // $("#ptechName").html(techname);
	   var allVals ="";
	   $("input[type='checkbox'][id$='selectedTests']:checked").each(function() {
		   allVals=allVals+$(this).val()+",";
    	 });
  	    $('#mtestName').html(allVals);
  	    $('#mhtestName').val(allVals);
        $("#sendMultipleLinkModel").modal("show");
  }
   
   $(function(){
	   $('input[type="checkbox"]').click(function(){
		   $("#applicationMessage").html("");
		   $(".alert").hide();
	   })
	   
	    $(".alert").hide();
	   $("input[type='text']").keyup(function() {
		   $("#ErrorMessage").html("");
	   });

	   $("input[type='button'][id='sendNewTestLink']").click(function() {
			var email=$("#email").val();
	 		var name=$("#pname").val();
	 		  if(email.length==0){
				    $("#ErrorMessage").html("Email cannot be empty.");
				    $("#email").focus();
				    return;
			  }
	 		  
	 		 if(name.length==0){
				    $("#ErrorMessage").html("Name cannot be empty.");
				    $("#pname").focus();
				    return;
			  }
	 		 //  alert("ee = "+$("#sendLinkModelForm").serialize());
	 			var contextPath="${pageContext.request.contextPath}";
				$.ajax({url:contextPath+"/action/send-test-link", type: 'POST',data:$("#sendLinkModelForm").serialize(),success:function(jsonData) {  //data= this.responseText
					//data is JavaScript object against JSON response coming fromm the server
						console.log(jsonData);
						if(jsonData.status=='success') {
					   		 	$("#sendLinkModel").modal("hide");
					    		$("#applicationMessage").html(jsonData.message);	
					    	    $(".alert").show();
						}else{
							$("#ErrorMessage").html(jsonData.message);							
						}
				}//end of callback response
			}); //end of the AJAX		
	 		
	   });
	   
	   $("input[type='button'][id='sendMultipleNewTestLink']").click(function() {
			var email=$("#memail").val();
	 		var name=$("#mmname").val();
	 		  if(email.length==0){
				    $("#mErrorMessage").html("Email cannot be empty.");
				    $("#memail").focus();
				    return;
			  }
	 		  
	 		 if(name.length==0){
				    $("#mErrorMessage").html("Name cannot be empty.");
				    $("#mmname").focus();
				    return;
			  }
	 		 
	 		  var allSelectedTests=$("#mhtestName").val();
	 		  var contextPath="${pageContext.request.contextPath}";
	 		 //Core-Java__OCA-DUMMY,Core-Java__OCA_TEST_1
	 		  var queryString="";
	 		  var testTokens=allSelectedTests.split(",");
	 		 
	 		  for(var x=0;x<testTokens.length;x++) {
	 			   var token=testTokens[x];
	 			   if(token.length==0 || token.length<3){
	 				   continue;
	 			   }
	 			   var testTechName=token.split("__");
	 			   var techName=testTechName[0];
	 			   var testName=testTechName[1];
	 			  $("#sendMultipleLinkModel").modal("hide");
		    	     $("input[type='checkbox'][id$='selectedTests']").attr('checked',false);
	 			   var queryString="techName="+techName+"&testName="+testName+"&email="+email+"&name="+name;
	 				 $.ajax({url:contextPath+"/action/send-test-link", type: 'POST',data:queryString,success:function(jsonData) {  //data= this.responseText
							//data is JavaScript object against JSON response coming fromm the server
								console.log(jsonData);
								if(jsonData.status=='success') {
						    		 $("#applicationMessage").html(jsonData.message);	
						    	     $(".alert").show(); 
						    	     $("input[type='checkbox'][id$='selectedTests']").attr('checked',false);
								}else{
									$("#ErrorMessage").html(jsonData.message);							
								}
						}//end of callback response
					 }); //end of the AJAX	
	 		 } //end of the for loop!
	   });
   });

</script>

<!-- Modal -->
<form  id="sendLinkModelForm"  >
<div id="sendLinkModel" class="modal fade" role="dialog">
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
       
       			<input type="hidden" name="techName" id="ttechName">
       				<input type="hidden" name="testName" id="testName">
              <div class="form-group">
       Technology   :   <span style="font-weight: bold;color:red;">*</span>
        	<label style="font-weight: bold;margin-right: 50px;" id="ptechName">Angular2</label>
        	
        	Test Name   :   <span style="font-weight: bold;color:red;">*</span>
        	<label style="font-weight: bold;" id="ptestName">OPPS_BASIC</label>
        </div>
        <hr/>
           <span style="color:red;font-size: 15px;" id="ErrorMessage"></span>
      <div class="form-group">
      	Email    :   <span style="font-weight: bold;color:red;font-size: 18px;">*</span>
        <input type="text" class="form-control" id="email" name="email"/>
        </div>
        
        
          <div class="form-group">
       Name   :   <span style="font-weight: bold;color:red;"></span>
        <input type="text" class="form-control" id="pname" name="name"/>
        </div>
        
            <div class="form-group">
      	 Test Duration   :   <span style="font-weight: bold;color:red;"></span>(Mins)
        	<select  class="form-control" id="tduration" name="tduration" style="width: 25%">
        	<option>1</option>
        	 	<option>2</option>
        	 	 	<option>3</option>
        	 	 	 	<option>4</option>
        	      <%
        	       for(int x=5;x<=200;x=x+5){
        	    	   %>
        	    	   <option><%=x %></option>
        	      <%
        	      } %>
        	      </select>
        </div>
        
      </div>
      </div>
      <div class="modal-footer">
        	<input type="button" value="Close"  class="mc-btn btn-style-1" id="close"  data-dismiss="modal"/>
        	<input type="button"  value="Send Link" class="mc-btn btn-style-1" id="sendNewTestLink"/>
      </div>
    </div>

  </div>
</div>
</form>

<!-- Modal -->
<form  id="sendMultipleLinkModelForm"  >
<div id="sendMultipleLinkModel" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content" style="background-image: url('${pageContext.request.contextPath}/images/bg/backgrounds.jpg');">
      <div class="modal-header"  style="background-color: #37abf2;height: 35px; ">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      <img src="${pageContext.request.contextPath}/images/course-icon.png" width="30px;"/>
            <p style="display: inline;margin-left: 20px;">   <span style="font-weight: bold;" id="mname"></span></p>
      </div>
      <div class="bloading">
      <div class="modal-body">
       
   			<input type="hidden" name="testName" id="mhtestName">
              <div class="form-group">
       
        	
        	Selected Test Name(s)   :   <span style="font-weight: bold;color:red;">*</span>
        	<label style="font-weight: normal;" id="mtestName">OPPS_BASIC</label>
        </div>
        <hr/>
           <span style="color:red;font-size: 15px;" id="mErrorMessage"></span>
      <div class="form-group">
      	Email    :   <span style="font-weight: bold;color:red;font-size: 18px;">*</span>
        <input type="text" class="form-control" id="memail" name="email"/>
        </div>
        
        
          <div class="form-group">
       Name   :   <span style="font-weight: bold;color:red;"></span>
        <input type="text" class="form-control" id="mmname" name="name"/>
        </div>
       
      
        
      </div>
      </div>
      <div class="modal-footer">
        	<input type="button" value="Close"  class="mc-btn btn-style-1" id="close"  data-dismiss="modal"/>
        	<input type="button"  value="Send Link(s)" class="mc-btn btn-style-1" id="sendMultipleNewTestLink"/>
      </div>
    </div>

  </div>
</div>
</form>
</body>

</html>