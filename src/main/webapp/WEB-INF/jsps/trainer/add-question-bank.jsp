<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from envato.megadrupal.com/html/megacourse/account-assignment.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 19 Mar 2017 04:41:35 GMT -->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <title>${companyName} - Add Question Bank</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/trainer-css/trainer.css" type="text" media="all">

</head>
<body  id="page2" style="background:url(${pageContext.request.contextPath}/images/bg_top2.jpg) top repeat-x #fff;" onkeydown="return (event.keyCode != 116)">

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
   
             <!-- AFTER SLIDER -->
        
    <!-- COURSE CONCERN -->
  <section style="padding-top: 0px;background-color: #eee;min-height: 500px;">
  		<br/>
        <div class="container" style="background-color: white;">
			  <img src="${pageContext.request.contextPath}/images/icon/Icon_01.png" width="40px;"/>
                 <h3 style="color: black;font-size: 17px;display: inline;"> Questions -> Add Question Bank</h3> 
				<span style="color: red;font-size:14px;font-weight: bold;" id="applicationMessage">${ApplicationMessage}</span>
                 <form:form  id="questionBankFormId" action="${pageContext.request.contextPath}/action/add-question-bank" method="post" commandName="questionBankVO">
        	<table class="table table-bordered" width="60%">
      			 	 <tbody>
      			 	  <tr height="25px" >
					     <td colspan="1" align="left" valign="bottom"  style="width: 30%">
					       <span style="font-family: 'Lato', sans-serif;font-size: 16px;">Technology&nbsp; :</span> 
					     </td>
					     <td colspan="1" align="left" valign="bottom" >
					       	<form:select path="techName"  class="input-large form-control" style="width:300px;">
					       		 <option>--Select--</option>
					       		<form:options items="${technologyList}" />
					       	</form:select>
					     </td>
					   </tr>
      			 	 <tr height="25px" >
					     <td colspan="1" align="left" valign="bottom"  style="width: 30%">
					       <span style="font-family: 'Lato', sans-serif;font-size: 16px;">Question Bank Name&nbsp; :</span> 
					     </td>
					     <td colspan="1" align="left" valign="bottom" >
					        <form:input path="qbankname" style="width: 60%;" class="input form-control"/>
					     </td>
					   </tr>
					   <tr height="25px"  >
					    <td colspan="1" align="left" valign="bottom"  style="width: 30%">
					         <span style="font-family: 'Lato', sans-serif;font-size: 16px;">Description&nbsp; :</span> 
					     </td>
					     <td colspan="1" align="left" valign="bottom" >
					          <form:textarea rows="" cols="60" path="description" class="input form-control"  style="width: 80%"/>
					     </td>
					   </tr>
					   
					    <tr height="25px" >
					     <td colspan="1" align="left" valign="bottom"  style="width: 30%">
					       <span style="font-family: 'Lato', sans-serif;font-size: 16px;">Visible All&nbsp; :</span> 
					     </td>
					     <td colspan="1" align="left" valign="bottom" >
					       	<form:select path="visibleAll"  class="input-large form-control" style="width:300px;">
					       		 <option>YES</option>
					       		 <option>NO</option>
					       	</form:select>
					     </td>
					   </tr>
					   
					    <tr height="25px"  >
					    <td colspan="1" align="left" valign="bottom"  style="width: 30%">
					         <b><input type="reset" value="Clear" class="mc-btn btn-style-1"/></b> 
					     </td>
					     <td colspan="1" align="left" valign="bottom" >
					            <input type="button" value="${buttonLable}" class="mc-btn btn-style-1"  id="addQuestionBankName"/>
					     </td>
					   </tr>
					  </tbody>
					  
					 </table>
				
					   <hr style="color: blue"/>
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

 <script type="text/javascript">
 
$(document).ready(function() {
		//alert(techs);
		$("#techName").change(function(){
			$("#applicationMessage").html("");
		});
		$("input[type='text'][name='qbankname']").keyup(function(){
			$("#applicationMessage").html("");
		});
		
  	 $("input[type='button'][id='addQuestionBankName']").click(function() {
  		 	var techName=$("#techName").val();
  		    if(techName=='--Select--'){
  		  		$("#applicationMessage").html("Please select a technology for the question bank to be added.");
				return;   	
  		    }
  		    //validating the test name
  			var qbankName=$("input[type='text'][name='qbankname']").val();
  			if(qbankName.length==0){
  					$("#applicationMessage").html("Question Bank Name cannot be blank.......");
  					$("input[type='text'][name='qbankname']").focus();
  					return;
  			}
  		var ccontextPath="${pageContext.request.contextPath}";
  		  $.getJSON(ccontextPath+"/action/findQuestionBankNameByTechName",{techName:techName,qbankName:qbankName},function(jsonResponse) {
  			  if(jsonResponse.status=="yes") {
  				 	 $("#applicationMessage").html("Question bank name  "+qbankName+" already exists into the database...");
  			  }else{
  				$("#questionBankFormId").submit();		
  			  }
  		  });
	 });
});
</script>	
</body>

</html>