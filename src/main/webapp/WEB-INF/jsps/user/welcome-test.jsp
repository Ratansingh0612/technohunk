<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<!DOCTYPE html>
<html lang="en">
<head>
<title>${companyName} - Test Welcome</title>
 <%@include file="/resources.jsp" %>
<!--[if lt IE 9]>
<script type="text/javascript" src="js/html5.js"></script>
<style type="text/css">.bg, .box2{behavior:url("js/PIE.htc");}</style>
<![endif]-->
</head>
<body style="background:url${pageContext.request.contextPath}/(images/bg_top2.jpg) top repeat-x #fff;">
<div class="body121">
  <div class="main">
    <!-- header -->
   <k:if test="${sessionScope.user_session_data.role=='user'}">	
      <%@include file="uheader.jsp" %>
      </k:if>
      <k:if test="${sessionScope.user_session_data.role=='consultant'}">	
      <%@include file="uheader.jsp" %>
      </k:if>
        <k:if test="${sessionScope.user_session_data.role=='trainer'}">	
       <%@include file="/theader.jsp" %>
       </k:if>
             <k:if test="${sessionScope.user_session_data.role=='admin'}">	
       <%@include file="/aheader.jsp" %>
           </k:if>
                <k:if test="${sessionScope.user_session_data.role=='guest'}">	
       <%@include file="guestheader.jsp" %>
           </k:if>
           
    <!-- / header -->
  </div>
</div>
    <!-- content -->
    <section>
      <hr/>
                <h1 style="font-family: 'Lato', sans-serif;font-size: 14px; margin-left: 150px; color: black;">
                  <img src="${pageContext.request.contextPath}/images/trophy_award.png"  style="height: 50px;"/> - <span style="font-size: 18px;text-decoration: underline;">Welcome to online test.</span></h1>
                <table class="table table-bordered" style="width:80%;background-image:url('${pageContext.request.contextPath}/images/icon/search-result.jpg');" align="center">
	 	 <tr height="25px" >
					     <td colspan="1" align="left" valign="bottom" >
					           <span style="font-family: 'Lato', sans-serif;font-size: 16px;">Test Name:</span>
								 &nbsp;&nbsp;
								 <b style="background-color: #d4f5f3;color:black;">${availableTest.testName}</b>
								 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					     </td>
					     
					        <td colspan="1" align="left" valign="bottom" >
					            <span style="font-family: 'Lato', sans-serif;font-size: 16px;">Tech Name:</span>
								 &nbsp;&nbsp;
								 <b style="background-color: #d4f5f3;color:black;">${availableTest. techName}</b>
								 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					     </td>
					    
					        <td colspan="1" align="left" valign="bottom" >
					           <span style="font-family: 'Lato', sans-serif;font-size: 16px;">Total Questions:</span>
								 &nbsp;&nbsp;
								 <b style="background-color: #d4f5f3;color:black;">${availableTest.totalQuestions}</b>
								 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					     </td>
					     
					       <td colspan="1" align="left" valign="bottom" >
					          <span style="font-family: 'Lato', sans-serif;font-size: 16px;">Total Duration:</span>
								 &nbsp;&nbsp;
								 <b style="background-color: #d4f5f3;color:black;">${availableTest.testDuration}&nbsp;(Mins.)</b>
								 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					     </td>
					   </tr>
				 </table>	   
                <hr style="color: black"/> 
      			<table border="1" style="width:80%;font-size: 18px; color:black;background-image:url('${pageContext.request.contextPath}/images/bg/page-backgroung.png'); " align="center">
					     <tr height="35px" style="color: white;background-color:#013648;vertical-align: middle;" align="center">
					     <td align="center"><span style="font-family: 'Lato', sans-serif;font-size: 16px;">Sno.</span></td>
					   	   <td align="left">&nbsp;&nbsp;<span style="font-family: 'Lato', sans-serif;font-size: 16px;">Test Instructions</span></td>
					     </tr>
					  
					      <tr height="30px">
					     <td align="center" style="font-family: 'Lato', sans-serif;font-size: 16px;">&nbsp;1. </td>
					   	   <td style="font-family: 'Lato', sans-serif;font-size: 16px;">&nbsp;Do not click on back button during test.</td>
					     
					     </tr>
					      <tr height="35px">
					       <td align="center" style="font-family: 'Lato', sans-serif;font-size: 16px;">&nbsp;2. </td>
					   	   <td style="font-family: 'Lato', sans-serif;font-size: 16px;">&nbsp;Do not click on refresh during test.</td>
					     
					     </tr>
					      <tr height="35px">
					       <td align="center" style="font-family: 'Lato', sans-serif;font-size: 16px;">&nbsp;3. </td>
					   	  <td style="font-family: 'Lato', sans-serif;font-size: 16px;">&nbsp;Read question very carefully before attempt it.</td>
					     </tr>
					      <tr height="35px">
					     <td align="center" style="font-family: 'Lato', sans-serif;font-size: 16px;">&nbsp;4. </td>
					   	   <td style="font-family: 'Lato', sans-serif;font-size: 16px;">&nbsp;You can change option of question at any moment.</td>
					     </tr>
					      <tr height="35px">
					       <td align="center" style="font-family: 'Lato', sans-serif;font-size: 16px;">&nbsp;5. </td>
					     <td style="font-family: 'Lato', sans-serif;font-size: 16px;">&nbsp;Do not submit your test until you finish it</td>
					     </tr>
					    <%--   <tr height="35px">
					       <td align="center" style="font-family: 'Lato', sans-serif;font-size: 14px;">&nbsp;6. </td>
					   	   <td style="font-family: 'Lato', sans-serif;font-size: 14px;">&nbsp;Please contact at <span style="background-color:#e5ffa3;">${companyEmail}</span> in case of any query or question</td>
					     </tr> --%>
					      <tr height="35px">
					     <td>&nbsp;</td>
					   	   <td align="right"> 
					   	   <a href="${pageContext.request.contextPath}/action/start-tech-test">
       	<span style="font-family: 'Lato', sans-serif;font-size: 14px; margin-top: 10px;font-size: 40px;">Start <img src="${pageContext.request.contextPath}/images/DL25-icon.png" title="Please click here to start your test , thanks"/> Test </a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
               		
               		
                </td>
					     </tr>
					      <tr height="35px">
					       <td align="center" style="font-family: 'Lato', sans-serif;font-size: 14px;">&nbsp; </td>
					   	   <td style="font-family: 'Lato', sans-serif;font-size: 14px;">&nbsp;</td>
					     </tr>
					     
					        <tr height="35px">
					       <td align="center" style="font-family: 'Lato', sans-serif;font-size: 14px;">&nbsp; </td>
					   	   <td style="font-family: 'Lato', sans-serif;font-size: 14px;">&nbsp;</td>
					     </tr>
					</table>  
					     <%-- <img style="margin-left: 140px;margin-top: 10px;"  src="${pageContext.request.contextPath}/images/exam-tips.png"/> --%>	
					     		     <img style="margin-left: 140px;margin-top: 10px;height: 80px;"  src="${pageContext.request.contextPath}/images/welcome1.jpg"/>
					<br/>
    </section>
       
    <!-- FOOTER -->
    <footer id="footer" class="footer">
       <%@include file="/sfooter.jsp" %>
    </footer>
    <!-- END / FOOTER -->
<!-- END / PAGE WRAP -->

<!-- Load jQuery -->
<!-- Load jQuery -->
  <%@include file="/js.jsp" %>
  <script>
  		$(function(){
  			$("#sendLinkModel").modal("show");	
  			$("#pname").keyup(function(){
  				$("#ErrorMessage").html("");
  			});
  			
  		   $("input[type='button'][id='updateUsername']").click(function() {
  				var salutation=$("#salutation").val();
  		 		var pname=$("#pname").val();
  		 		  if(pname.length==0){
  		 			$("#ErrorMessage").html("Name cannot be empty , enter your name please.");
  					$("#pname").focus();
  					    return;
  				  }
  		 			var contextPath="${pageContext.request.contextPath}";
  					$.ajax({url:contextPath+"/action/update-guest-name", type: 'GET',data:$("#sendLinkModelForm").serialize(),success:function(jsonData) {  //data= this.responseText
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
  		});
  		
  </script>
  
  <!-- Modal -->
<form  id="sendLinkModelForm"  >
<div id="sendLinkModel" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content" style="background-image: url('${pageContext.request.contextPath}/images/bg/namebg.jpg');">
      <div class="modal-header"  style="background-color: #2196f3;;height: 35px; ">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      <img src="${pageContext.request.contextPath}/images/icon/cheers.png" style="height:60px;"/>
            <p style="display: inline;margin-left: 20px;">   <span style="font-weight: bold;" id="name"></span></p>
      </div>
      <div class="bloading">
      <div class="modal-body">
       			<br/>
       			<input type="hidden" name="techName" id="ttechName">
       				<input type="hidden" name="testName" id="testName">
              <div class="form-group">
       Technology   :   <span style="font-weight: bold;color:red;">*</span>
        	<label style="font-weight: normal;margin-right: 50px;" id="ptechName">${availableTest.techName}</label>
        	
        	Test Name   :   <span style="font-weight: bold;color:red;">*</span>
        	<label style="font-weight: normal;" id="ptestName">${availableTest.testName}</label>
        </div>
        <hr/>
           <span style="color:darkblue;font-size: 15px;" id="ErrorMessage"></span>
      <div class="form-group">
      	Salutation    :   <span style="font-weight: bold;color:red;font-size: 18px;">*</span>
        <select type="text" class="form-control" id="salutation" name="salutation" style="width: 50%;">
        	<option value="1">Mr.</option>
        	<option value="2">Ms.</option>
        </select>
        </div>
        
          <div class="form-group">
      Enter your name please   :   <span style="font-weight: bold;color:red;"></span>
        <input type="text" class="form-control" id="pname" name="name"/>
        </div>
        
      </div>
      </div>
      <div class="modal-footer">
        	<input type="button"  value="Next" class="mc-btn btn-style-1" id="updateUsername"/>
      </div>
    </div>

  </div>
</div>
</form>
</body>
</html>