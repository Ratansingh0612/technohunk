<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <!-- Google font -->
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Raleway:300,400,700,900' rel='stylesheet' type='text/css'>
       <%@include file="/resources.jsp" %>
    <title>${companyName} -Coding Problems List</title>
    <!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
    <![endif]-->
    <style type="text/css">
    .breadscrumscrollcoll {
    padding: 1%;
    width: 100%;
    background-color: #e7eeef2b;
    color: #454C5F;
    font-size: 18px;
    line-height: 20px;
    font-weight:bold;
    border-left: 5px solid #c2bcf9;
    margin: 1%;
    box-shadow: 0 0.125rem 0.625rem 0 rgba(0,0,0,0.2);
    float: left;
}
    </style>
</head>
<body id="page-top">

<!-- PAGE WRAP -->
<div id="page-wrap">

    <!-- PRELOADER -->
    <div id="preloader">

    </div>
    <!-- END / PRELOADER -->

    <!-- HEADER -->
       <!-- HEADER -->
     <%@include file="/aheader.jsp" %>
    <!-- END / HEADER -->

    <!-- PROFILE FEATURE -->
    <section class="profile-feature">
        <div class="awe-parallax bg-profile-feature"></div>
        <div class="awe-overlay overlay-color-3"></div>
        <div class="container">
            <div class="info-author">
                <div class="image">
                     <img src="${pageContext.request.contextPath}/action/imageByUserId?userid=${sessionScope.user_session_data.loginId}" alt="">
                </div>    
                <div class="name-author">
                    <h2 class="big" style="color:white;;font-size: 24px;">${sessionScope.user_session_data.name}</h2>
                </div>     
                <div class="address-author">
                    <i class="fa fa-map-marker"></i>
             <h3>${sessionScope.user_session_data.address}&nbsp;&nbsp;(${sessionScope.user_session_data.batch})</h3>
                </div>
            </div>
                     <%@include file="/tech-profile.jsp"%>
        </div>
    </section>
    <!-- END / PROFILE FEATURE -->


    <!-- CONTEN BAR -->
   <%@include file="../admin/content-bar.jsp" %>
   <!-- END / CONTENT BAR -->
    <!-- BLOG -->
    <section class="blog">
        <div class="container" style="background-color: white;">
        	 <section>
        		<p class="breadscrumscrollcoll" >
        		Java Coding Problem List&nbsp;(${fn:length(codingProblemsVOs)})</p> 
        	 </section>
        	 <br/>	 <br/>
        	 <div style="float: left;">
        	  <ul class="pager">
                            <k:forEach begin="1" end="${totalPage}" varStatus="loop">
   									 <li><a id="hpagecount_${loop.count}" href="${pageContext.request.contextPath}/action/codings/java/pagelists?page=${loop.count}">${loop.count}</a></li>
							</k:forEach>
                            <li><a id="hpagecount_next" href="${pageContext.request.contextPath}/action/codings/java/pagelists?page=${currentPage+1}">next ></a></li>
                            <li><a href="${pageContext.request.contextPath}/action/codings/java/pagelists?page=${totalPage}">last >></a></li>
                        </ul>
                        
                      		
        	 </div>
        	 
        	  <br/> <br/> <br/> 
        	  <hr/>
        	  
        	  	 	<span style="font-size: 16px;margin-right: 20px;">Filter : </span> 
                    <select id="complexity" name="complexity" class="form-control" style="display: inline;width: 300px;">
                    	<option value="All">All</option>
        				<option value="Simple" ${param.pc=='Simple'?'selected':''}>Simple</option>
        				<option value="Medium" ${param.pc=='Medium'?'selected':''}>Medium</option>
        				<option value="Difficult" ${param.pc=='Difficult'?'selected':''}>Difficult</option>
        		</select> 
        		  <span style="font-size: 16px;margin-left: 100px;margin-right: 150px;">Total selected Problems : <span id="totalSelected">0</span></span> 
        		 <input type="button" value="Send Problem Link (s)" class="mc-btn btn-style-1" id="sendMultipleLinks" style="background-color: #F44336;margin: 0px; font-weight: 500;font-size: 15px;width: auto;" onclick="sendCodingLinks();"/>  
         
            <hr/>
         <form id="send-coding-links-form" action="${pageContext.request.contextPath}/action/codings/send-coding-links" method="post"> 
             <input type="hidden" name="name" id="mcpname"/>
             <input type="hidden" name="email" id="mcpemail"/>
            <div class="row">
                <!-- BLOG LIST -->
                <div class="col-md-8">
                    <div class="blog-list-content">
                        <!-- POST -->
                        <k:forEach items="${codingProblemsVOs}" var="item" varStatus="oop">
                        <div class="post">
                            <!-- POST MEDIA -->
                            <div class="post-media">
                                <div class="image-thumb">
                                	    
                                    <img src="${pageContext.request.contextPath}/${item.image}" alt="" style="height: 110px;display: inline;">
 								<div class="setting-box">
				                            <ul>
				                                <li>
				                                    <input type="checkbox" name="pprobsId" class="inputcheck" id="show-my-location_${item.cpid}" value="${item.cpid}">
				                                    <label for="show-my-location_${item.cpid}">
				                                        <i class="icon md-check-1" style="float: left;"></i>
				                                    </label>
				                                </li>
				                            </ul>
                       					 </div>
                                </div>
                            </div>
                            <!-- END / POST MEDIA -->

                            <!-- POST BODY -->
                            <div class="post-body">
                                <div class="post-title">
                                    <h3 class="md"><a href="${pageContext.request.contextPath}/${item.readMore}?problemId=${item.cpid}">${oop.count}.&nbsp;&nbsp;${item.title}&nbsp;(${item.problemType})</a>&nbsp;&nbsp;&nbsp;&nbsp;
                                     <a href="javascript:openEditProblemModal('${item.cpid}','${item.title}','${item.level}','${item.duration}','${item.techName}');">
                                     <img src="${pageContext.request.contextPath}/images/edit.png"/>
                                     </a>
                                    
                                    </h3>
                                     Level : ${item.level}  <span style="margin-left:50px;">Duration : <b style="color:red;">${item.duration}</b> Minutes</span>
                               
                                </div>
                                <div class="post-meta" style="font-size: 15px;">
                                    by <a href="#">${item.author}</a> on&nbsp;&nbsp;   <span style="color:black;"><fmt:formatDate type="date" value = "${item.doe}" /></span>
                                    
                                </div>
                                <div class="post-content">
                                    <p>${item.description}</p>
                                </div>
                                <div>
                                    <a href="${pageContext.request.contextPath}/${item.readMore}?problemId=${item.cpid}">
                                        <img src="${pageContext.request.contextPath}/images/codings/read-more.png" style="height: 35px;"/>Read More
                                    </a>
                                     <span style="float: right;">
                                     <input type="button" value="Send Problem Link" class="mc-btn btn-style-1" id="sendLink" style="background-color: #8bc34a;;margin: 0px; font-weight: 500;font-size: 15px;width: auto;" onclick="sendCodingLink('${item.cpid}','${item.techName}','${item.title}');"/>
                                       <k:if test="${item.problemType=='PUIM'}">	
                                      <input type="button" value="Review Test Case" class="mc-btn btn-style-1" id="reviewTestCases" style="background-color: #2196f3;;margin: 0px; font-weight: 500;font-size: 15px;width:auto;" onclick="loadTestCases('${item.cpid}','${item.title}')"/>
                                      </k:if>
                                      <k:if test="${item.problemType!='PUIM'}">	
                                      <input disabled="disabled" type="button" value="No Test Case" class="mc-btn btn-style-1" id="reviewTestCases" style="background-color: #E91E63;;margin: 0px; font-weight: 500;font-size: 15px;width:auto;" onclick="loadTestCases('${item.cpid}','${item.title}')"/>
                                     </k:if>
                                     </span>
                                </div>
                            </div>
                                                                                                      
                            <!-- END / POST BODY -->
                        </div>
                        </k:forEach>
                        <!-- END / POST -->




                        <ul class="pager">
                            <k:forEach begin="1" end="${totalPage}" varStatus="loop">
   									 <li><a id="pagecount_${loop.count}" href="${pageContext.request.contextPath}/action/codings/java/pagelists?page=${loop.count}">${loop.count}</a></li>
							</k:forEach>
                            <li><a id="pagecount_next" href="${pageContext.request.contextPath}/action/codings/java/pagelists?page=${currentPage+1}">next ></a></li>
                            <li><a href="${pageContext.request.contextPath}/action/codings/java/pagelists?page=${totalPage}">last >></a></li>
                        </ul>
                    </div>
                </div>
                <!-- END / BLOG LIST -->

                <!-- SIDEBAR -->
             <%@include file="/sidebar.jsp" %>
                <!-- END / SIDEBAR -->


            </div>
        	</form>
        </div>

    </section>
    <!-- END / BLOG -->

    
    
    <!-- FOOTER -->
 <!-- FOOTER -->
    <footer id="footer" class="footer">
<%--    <%@include file="/ffooter.jsp" %> --%>

       <%@include file="/sfooter.jsp" %>
    </footer>
    <!-- END / FOOTER -->
    <!-- END / FOOTER -->


    


</div>
<!-- END / PAGE WRAP -->

<!-- Load jQuery -->
  <%@include file="/js.jsp" %>
  
    <!-- Modal -->
<form  id="sendLinksModelForm">
<div id="sendLinksModel" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content" style="background-image: url('${pageContext.request.contextPath}/images/bg/backgrounds.jpg');">
      <div class="modal-header"  style="background-color: #37abf2;height: 35px; ">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      <img src="${pageContext.request.contextPath}/images/codings/coding-icon.png" width="40px;"/>
            <p style="display: inline;margin-left: 20px;">   <span style="font-weight: bold;" id="name"></span></p>
      </div>
      <div class="bloading">
      <div class="modal-body">
              <div class="form-group">
       Technology   :   <span style="font-weight: bold;color:red;">*</span>
        	<label style="font-weight: bold;margin-right: 50px;">Core Java</label>
        	
        	Coding Name   :   <span style="font-weight: bold;color:red;">*</span>
        	<label style="font-weight: bold;">Java Coding Problems</label>
        </div>
        <hr/>
           <span style="color:red;font-size: 15px;" id="LinksErrorMessage"></span>
      <div class="form-group">
      	Email    :   <span style="font-weight: bold;color:red;font-size: 18px;">*</span>
        <input type="text" class="form-control" id="memail" name="email"/>
        </div>
        
        
          <div class="form-group">
       Name   :   <span style="font-weight: bold;color:red;"></span>
        <input type="text" class="form-control" id="mpname" name="name"/>
        </div>
        
      </div>
      </div>
      <div class="modal-footer">
        	<input type="button" value="Close"  class="mc-btn btn-style-1" id="close"  data-dismiss="modal"/>
        	<input type="button"  value="Send Link(s)" class="mc-btn btn-style-1" id="sendNewTestLinks"/>
      </div>
    </div>

  </div>
</div>
</form>
  
  <!-- Modal -->
<form  id="sendLinkModelForm">
<div id="sendLinkModel" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content" style="background-image: url('${pageContext.request.contextPath}/images/bg/backgrounds.jpg');">
      <div class="modal-header"  style="background-color: #37abf2;height: 35px; ">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      <img src="${pageContext.request.contextPath}/images/codings/coding-icon.png" width="40px;"/>
            <p style="display: inline;margin-left: 20px;">   <span style="font-weight: bold;" id="name"></span></p>
      </div>
      <div class="bloading">
      <div class="modal-body">
       
   			<input type="hidden" name="techName" id="ttechName"/>
   			<input type="hidden" name="problemId" id="cpid"/>
   			<input type="hidden" name="problemTitle" id="problemTitle"/>
   			
              <div class="form-group">
       Technology   :   <span style="font-weight: bold;color:red;">*</span>
        	<label style="font-weight: bold;margin-right: 50px;" id="ptechName">Core Java</label>
        	
        	Coding Name   :   <span style="font-weight: bold;color:red;">*</span>
        	<label style="font-weight: bold;" id="ptestName">Java String Problem</label>
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
      	 Coding Duration   :   <span style="font-weight: bold;color:red;"></span>(Mins)
        	<select  class="form-control" id="pduration" name="pduration" style="width: 25%">
        	<option>1</option>
        	 	<option>2</option>
        	 	 	<option>3</option>
        	 	 	 	<option>4</option>
        	      <%
        	       for(int x=5;x<=200;x=x+5){
        	    	   if(x!=30){	
        	    	   %>
        	    	   <option><%=x %></option>
        	         <%
        	    	   }else{
        	    		   %>
            	    	   <option selected="selected"><%=x %></option>
            	         <%
        	    	   }
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



 <script type="text/javascript">
 		var contextPath="${pageContext.request.contextPath}";
 		var referer=contextPath+"/action/codings/java/lists?problemCategory=${param.problemCategory}";
 	 	function deleteTestCase(pid,input,expectedOutput){
 			$.getJSON(contextPath+"/action/codings/delete-particular-test-case",{pid:pid,input:input,expectedOutput:expectedOutput},function(data){
 				console.log(data);
 				$("#addEditTestCasesModel").modal("hide");			
 			});
 		}
 		
 		function loadTestCases(cpid,title) {
 				//make an ajax call to bring all available test case data from the database
 				$("#tcpid").val(cpid);
 				$("#pptestName").html(title);
 				$("#testInput").val("");
				$("#expectedTestOutput").val("");
				$("#testDescription").val("NA");
				$("#testcaseErrorMessage").html("");
				$.getJSON(contextPath+"/action/codings/find-test-cases-by-problemid?cpid="+cpid,function(data){
					 console.log(data);
				 var testCases=data.testCasesVOs;
				 $("#totalRecords").html(testCases.length);
				 if(testCases.length>0){
					 var testCaseContents="";
					 for(var x=0;x<testCases.length;x++) {
						 testCaseContents=testCaseContents+'<tr style="color: black">';
						 testCaseContents=testCaseContents+'<td bgcolor="white">&nbsp;'+(x+1)+'</td>';
						 testCaseContents=testCaseContents+'<td bgcolor="white">&nbsp;'+testCases[x].expectedInput+'</td>';
						 testCaseContents=testCaseContents+'<td>&nbsp;'+testCases[x].expectedOutput+'</td>';
						 testCaseContents=testCaseContents+'<td>&nbsp;'+testCases[x].comment+'</td>';
						 testCaseContents=testCaseContents+'<td>&nbsp;'+testCases[x].doe+'</td>';
						 var jsdeleteMethod="javascript:deleteTestCase('"+cpid+"','"+testCases[x].expectedInput+"','"+testCases[x].expectedOutput+"');"
						 testCaseContents=testCaseContents+'<td>&nbsp;<a href="'+jsdeleteMethod+'"><img src="'+contextPath+'/images/icon/delete.png" style="height:30px;"></a></td>';
						 testCaseContents=testCaseContents+'</tr>';
					 }
					 
					 testCaseContents=testCaseContents+'<tr style="color: black">';
					 testCaseContents=testCaseContents+'<td bgcolor="white">&nbsp;</td>';
					 testCaseContents=testCaseContents+'<td bgcolor="white">&nbsp;</td>';
					 testCaseContents=testCaseContents+'<td>&nbsp;</td>';
					 testCaseContents=testCaseContents+'<td>&nbsp;</td>';
					 testCaseContents=testCaseContents+'<td>&nbsp;</td>';
					 testCaseContents=testCaseContents+'<td>&nbsp;</td>';
					 testCaseContents=testCaseContents+'</tr>';
					 $("#tableContent").html(testCaseContents);
				 }else{
					 testCaseContents=testCaseContents+'<tr style="color: black">';
					 testCaseContents=testCaseContents+'<td bgcolor="white">&nbsp;</td>';
					 testCaseContents=testCaseContents+'<td bgcolor="white">&nbsp;</td>';
					 testCaseContents=testCaseContents+'<td>&nbsp;</td>';
					 testCaseContents=testCaseContents+'<td>&nbsp;</td>';
					 testCaseContents=testCaseContents+'<td>&nbsp;</td>';
					 testCaseContents=testCaseContents+'<td>&nbsp;</td>';
					 testCaseContents=testCaseContents+'</tr>';
					 testCaseContents=testCaseContents+'<tr style="color: black">';
					 testCaseContents=testCaseContents+'<td bgcolor="white">&nbsp;</td>';
					 testCaseContents=testCaseContents+'<td bgcolor="white">&nbsp;</td>';
					 testCaseContents=testCaseContents+'<td>&nbsp;</td>';
					 testCaseContents=testCaseContents+'<td>&nbsp;</td>';
					 testCaseContents=testCaseContents+'<td>&nbsp;</td>';
					 testCaseContents=testCaseContents+'<td>&nbsp;</td>';
					 testCaseContents=testCaseContents+'</tr>';
					 testCaseContents=testCaseContents+'<tr style="color: black">';
					 testCaseContents=testCaseContents+'<td bgcolor="white">&nbsp;</td>';
					 testCaseContents=testCaseContents+'<td bgcolor="white">&nbsp;</td>';
					 testCaseContents=testCaseContents+'<td>&nbsp;</td>';
					 testCaseContents=testCaseContents+'<td>&nbsp;</td>';
					 testCaseContents=testCaseContents+'<td>&nbsp;</td>';
					 testCaseContents=testCaseContents+'<td>&nbsp;</td>';
					 testCaseContents=testCaseContents+'</tr>';
					 $("#tableContent").html(testCaseContents);
				 }	 
					$("#addEditTestCasesModel").modal("show");
					
				});
				
 		}
 		
 		$(document).ready(function(){
 			var currentPage="${currentPage}";
 			var totalPage="${totalPage}";
 			if(currentPage==totalPage){
 				$("#pagecount_next").attr("href","javascript:");
 				$("#hpagecount_next").attr("href","javascript:");
 				
 			}
 			//#37ABF2
 			//$("p").css("background-color", "yellow");
 			$("#pagecount_"+currentPage).css("background-color","rgb(55, 171, 242)");
 			$("#pagecount_"+currentPage).css("color","rgb(255, 255, 255)");
 			$("#hpagecount_"+currentPage).css("background-color","rgb(55, 171, 242)");
 			$("#hpagecount_"+currentPage).css("color","rgb(255, 255, 255)");
 			
 			 $("input[type='text']").keyup(function() {
 				    $("#LinksErrorMessage").html("");
 				   $("#ErrorMessage").html("");
	 			    $("#PErrorMessage").html("");
 					$("#testcaseErrorMessage").html("");
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
 					$.ajax({url:contextPath+"/action/codings/send-coding-link", type: 'POST',data:$("#sendLinkModelForm").serialize(),success:function(jsonData) {  //data= this.responseText
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
 			
 			$("input[type='button'][id='sendNewTestLinks']").click(function() {
 				var email=$("#memail").val();
 		 		var name=$("#mpname").val();
 		 		  if(email.length==0){
 					    $("#LinksErrorMessage").html("Email cannot be empty.");
 					    $("#memail").focus();
 					    return;
 				  }
 		 		  
 		 		 if(name.length==0){
 					    $("#LinksErrorMessage").html("Name cannot be empty.");
 					    $("#mpname").focus();
 					    return;
 				  }
 		 		 
 		 		 $("#mcpname").val(name);
 		 		$("#mcpemail").val(email);
		 		 
 		 		 //  alert("ee = "+$("#sendLinkModelForm").serialize());
 					$.ajax({url:contextPath+"/action/codings/send-coding-links", type: 'POST',data:$("#send-coding-links-form").serialize(),success:function(jsonData) {  //data= this.responseText
 						//data is JavaScript object against JSON response coming fromm the server
 							console.log(jsonData);
 							if(jsonData.status=='success') {
 						   		 	$("#sendLinksModel").modal("hide");
 						   			$("input[type='checkbox'][name='pprobsId']").each(function(){ //iterate all listed checkbox items
 						   					this.checked = false; //change ".checkbox" checked status
 						   			});
 						   			count=0;
 						   			$("#totalSelected").html(0);
 						    		$("#applicationMessage").html(jsonData.message);	
 						    	    $(".alert").show();
 							}else{
 								$("#LinksErrorMessage").html(jsonData.message);							
 							}
 					}//end of callback response
 				}); //end of the AJAX		
 		 		
 		   });
 		
 			//code to add new test cases
			$("#addTestCaseButton").click(function(){
				//code for validation
				var testInput=$("#testInput").val();
				if(testInput.length==0) {
					$("#testcaseErrorMessage").html("Test Input cannot be blank.");
					$("#testInput").focus();
					return;
				}
				
				var expectedTestOutput=$("#expectedTestOutput").val();
				if(expectedTestOutput.length==0) {
					$("#testcaseErrorMessage").html("Expected Test Output cannot be blank.");
					$("#expectedTestOutput").focus();
					return;
				}
				
				var testDescription=$("#testDescription").val();
				if(testDescription.length==0) {
					$("#testcaseErrorMessage").html("Test Description cannot be blank.");
					$("#testDescription").focus();
					return;
				}
				var yesno=confirm("Are you sure want to add new test case?");
				if(yesno){
					$.ajax({url:contextPath+"/action/codings/add-new-testcase-for-problem", type: 'POST',data:$("#addEditTestCasesModelForm").serialize(),success:function(data) {  //data= this.responseText
						//data is JavaScript object against JSON response coming fromm the server
							console.log(data); // success = is values coming from the server
							$("#testInput").val("");
							$("#expectedTestOutput").val("");
							$("#testDescription").val("");
							$("#testcaseErrorMessage").html("");
							$("#addEditTestCasesModel").modal("hide");
						} //end of function
				
					}); 	
				} //end of yesno if
 			});

 			$("#complexity").change(function(){
				var selectedText=$(this).val();
				var surl=referer+"&pc="+selectedText;
				window.location.href=surl;		
 	 		});


 			$("#updateProblemBt").click(function() {
 	 			 
 				  var problemTitle=$("#tproblemTitle").val();
 		 		  if(problemTitle.length==0){
 					    $("#PErrorMessage").html("Problem Title cannot be empty.");
 					    $("#tproblemTitle").focus();
 					    return;
 				  }
 		 		 //  alert("ee = "+$("#sendLinkModelForm").serialize());
 					$.ajax({url:contextPath+"/action/codings/update-coding-problem", type: 'POST',data:$("#editProblemModelForm").serialize(),success:function(jsonData) {  //data= this.responseText
 						//data is JavaScript object against JSON response coming fromm the server
 							console.log(jsonData);
 							if(jsonData.status=='success') {
 						   		 	$("#editProblemModel").modal("hide");
 						   		 	 //Refreshing the current page
 						   			 window.location.reload();
 						    		//$("#applicationMessage").html(jsonData.message);	
 						    	    //$(".alert").show();
 							}else{
 								$("#PErrorMessage").html(jsonData.message);							
 							}
 					}//end of callback response
 				}); //end of the AJAX		
 		 		
 		   });
 			
 			var  count=0;
 			$("input[name='pprobsId']").change(function(){
 				if($(this).prop("checked") == true){
 					count++;
 				}else{
 					count--;
 				}
 				$("#totalSelected").html(count);
 			});
 	 			
 			
 		});	
 		
 		
 		function sendCodingLinks() {
 			$("#sendLinksModel").modal("show");
 		}
 
 		function sendCodingLink(cpid,techName,title) {
 			$("#cpid").val(cpid);
 			$("#problemTitle").val(title);
 			$("#ptechName").html(techName);
 			$("#ptestName").html(title);
 			$("#ttechName").val(techName);
 			$("#sendLinkModel").modal("show");
 		}

 		function openEditProblemModal(cpid,title,level,duration,techName){
 	 		//alert(level);
 	 		$("#pcpid").val(cpid);
 	 		$("#tptechName").html(techName);
 	 		$("#tproblemTitle").val(title);
 	 		$("#tptestName").html(title);
 	 		$("#tlevel").val(level);
 	 		$("#cduration").val(duration);
 			$("#editProblemModel").modal("show");
 	 	}

 		
 </script>
 
 <!-- Modal -->
<form  id="addEditTestCasesModelForm" action="${pageContext.request.contextPath}/action/codings/add-new-testcase-for-problem" method="post">
<div id="addEditTestCasesModel"  class="modal fade" role="dialog">
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
   			<input type="hidden" name="cpid" id="tcpid"/>
   			<input type="hidden" name="problemTitle" id="problemTitle"/>
   			
              <div class="form-group" style="font-size: 15px;">
       Technology   :   <span style="font-weight: bold;color:red;">*</span>
        	<label style="font-weight: bold;margin-right: 50px;" id="ptechName">Core Java</label>
        	
        	Coding Name   :   <span style="font-weight: bold;color:red;">*</span>
     		   	<label style="font-weight: bold;margin-right: 50px;" id="pptestName">Java String Problem</label>
        		
        		Level   :   <span style="font-weight: bold;color:red;">*</span>
        	<label style="font-weight: bold;" id="plevel">Medium</label>
        	
        	
        </div>
        
        <hr/>
         
        <div class="form-group">
          <span style="font-size: 15px;font-weight: normal;">Available Test Cases :</span>
             <span style="font-size: 15px;font-weight: normal;float:right;">Total Records : <span id="totalRecords"></span></span>  
            <table class="table table-bordered" id="tab1" style="margin-bottom: 0px;">
                    <thead>
                        <tr style="background-color: #607D8B;">
                            <th class="submissions" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">SNo</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Input</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Expected Output </th>
                            <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Test Description</th>
                               <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Entry Date</th>
                                <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Action</th>
                        </tr>
                    </thead>

                    <tbody id="tableContent">
					       <tr style="color: black">
					     <td bgcolor="white">&nbsp;</td>
					   	    <td bgcolor="white">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					     </tr>
					     <tr style="color: black">
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
					   	   <td>&nbsp;</td>
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
					     </tr>
					   <tr  style="color: black">
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
					     
					     <tr  style="color: black">
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
      	 		<span id="testcaseErrorMessage" style="font-size:16px;color:red;"></span>
        </div>
        
      </div>
      </div>
      
      <div class="modal-footer">
     	 <div class="form-group">
     	 <input type="text" class="form-control" id="testInput" placeholder="Enter Test Input" name="testInput">
    	</div>
    	 <div class="form-group">
     	 	 <input type="text" class="form-control" id="expectedTestOutput" placeholder="Enter Test Expected Output" name="expectedTestOutput">
    	</div>
    	
    		 <div class="form-group">
     	 	 <input type="text" class="form-control" id="testDescription" placeholder="Enter Test Description" name="description" value="NA">
    	</div>
    	<input type="button" value="Cancel" style="background-color: #2196f3" data-dismiss="modal"  class="mc-btn btn-style-1" id="cancelTestCase"/>
       	<input type="button" value="Add Test Case" style="background-color: #2196f3"  class="mc-btn btn-style-1" id="addTestCaseButton"/>
      </div>
    </div>
  </div>
</div>
</form>

  <!-- Modal -->
<form  id="editProblemModelForm">
<div id="editProblemModel" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content" style="background-image: url('${pageContext.request.contextPath}/images/bg/backgrounds.jpg');">
      <div class="modal-header"  style="background-color: #37abf2;height: 35px; ">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      <img src="${pageContext.request.contextPath}/images/codings/coding-icon.png" width="40px;"/>
            <p style="display: inline;margin-left: 20px;">   <span style="font-weight: bold;" id="name"></span></p>
      </div>
      <div class="bloading">
      <div class="modal-body">
       
   			<input type="hidden" name="problemId" id="pcpid"/>
   			
              <div class="form-group">
       Technology   :   <span style="font-weight: bold;color:red;">*</span>
        	<label style="font-weight: bold;margin-right: 50px;" id="tptechName">Core Java</label>
        	
        	Coding Name   :   <span style="font-weight: bold;color:red;">*</span>
        	<label style="font-weight: bold;" id="tptestName">Java String Problem</label>
        </div>
        <hr/>
           <span style="color:red;font-size: 15px;" id="PErrorMessage"></span>
      <div class="form-group">
      	Title    :   <span style="font-weight: bold;color:red;font-size: 18px;">*</span>
        <input type="text" class="form-control" id="tproblemTitle" name="problemTitle"/>
        </div>
        
        
          <div class="form-group">
       Complexity   :   <span style="font-weight: bold;color:red;"></span>
      <select  class="form-control" id="tlevel" name="level" style="width:50%">
      			<option value="Simple">Simple</option>
        		<option value="Medium">Medium</option>
        	 	<option value="Difficult">Difficult</option>
       </select> 	 	
        </div>
        
            <div class="form-group">
      	 Coding Duration   :   <span style="font-weight: bold;color:red;"></span>(Mins)
        	<select  class="form-control" id="cduration" name="duration" style="width: 50%">
        	<option>1</option>
        	 	<option>2</option>
        	 	 	<option>3</option>
        	 	 	 	<option>4</option>
        	      <%
        	       for(int x=5;x<=200;x=x+5){
        	    	   if(x!=30){	
        	    	   %>
        	    	   <option><%=x %></option>
        	         <%
        	    	   }else{
        	    		   %>
            	    	   <option selected="selected"><%=x %></option>
            	         <%
        	    	   }
        	      } %>
        	      </select>
        </div>
        
      </div>
      </div>
      <div class="modal-footer">
        	<input type="button" value="Close"  class="mc-btn btn-style-1" id="close"  data-dismiss="modal"/>
        	<input type="button"  value="Update Problem" class="mc-btn btn-style-1" id="updateProblemBt"/>
      </div>
    </div>

  </div>
</div>
</form>

</body>
</html>