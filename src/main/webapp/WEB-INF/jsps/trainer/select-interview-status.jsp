<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <title>${companyName} -  Screening Interview Status</title>
    
    <script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
 
</head>
<body>
<div class="body121">
  <div class="main">
<!-- PAGE WRAP -->
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

</div>
    <!-- PROFILE FEATURE -->
    <%@include file="profile-feature.jsp" %>
    <!-- END / PROFILE FEATURE -->


    <!-- CONTEN BAR -->
     <%@include file="content-bar.jsp" %>
   <!-- END / CONTENT BAR -->
 
    <!-- COURSE CONCERN -->
<!--   <section style="padding-top: 0px;padding-bottom:10px;background-color: white;" id="quizz-intro-section" class="quizz-intro-section learn-section"> -->
   <section class="quizz-intro-section" style="padding-top: 0px;padding-bottom:10px;background-color: #eee;min-height: 600px;" id="content">   
      
        <div class="container">
            <div class="title-ct">
                
                 &nbsp;&nbsp;<h3 style="color: black;font-size: 18px;"><img src="${pageContext.request.contextPath}/images/configure.png" width="20px;"/> - <b> ${pageTitle}</b></h3> 
            </div>

            <div class="table-student-submission">
            <table class="table table-bordered" width="60%">
      			 	 <tbody>
      			 	 <tr height="25px" >
					     <td colspan="1" align="left" valign="bottom" >
					           <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 14px;">Select Batch:</label>
								 &nbsp;&nbsp;
								 <select class="form-control" name="batchName" id="batchName" style="width: 300px;display: inline;">
								 	<option>Select Batch</option>
								 		<c:forEach items="${batchList}" var="item">
								 			<option>${item}</option>
								 		</c:forEach>
								 </select>
								 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								 <!--  <input type="button" value="Load Users" class="btn btn-primary btn-md"  id="loadUsers"/> -->
					     </td>
					   </tr>
					  </tbody>
					  
					 </table>
					  <hr style="color: blue"/>
					   <img src="${pageContext.request.contextPath}/images/users.png" width="25px;"/> 
					    <span style="font-family: 'Lato', sans-serif;font-size: 14px;">Consultant(s) List:-</span>
					 <div style="float: right;">
                          <img src="${pageContext.request.contextPath}/images/favicon.ico" width="25px;">   <span style="font-family: 'Lato', sans-serif;font-size: 14px;">Total Records :</span> <b><span id="totalRecords">${fn:length(allTechs)}</span></b>
                             </div>
                              <div class="wrapper">
<!--                 <hr style="color: black"/>  -->
                   <h4 style="color: red">
								 ${ApplicationMessage}
						</h4>
                             
                <table class="table table-bordered" id="tableContent">
               			<tbody id="tableContent">
                    <thead>
                        <tr style="background-color: #607D8B;">
                            <th class="submissions" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">SNo</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Consultant Id</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Name </th>
                            <th class="score" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Email </th>
                            <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Photo </th>
                         	<th style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Action</th>
                        </tr>
                    </thead>

<!--                     <tbody  id="tableContent"> -->
                      <tr height="25px" style="color: black">
					     <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	  <td bgcolor="white">&nbsp;</td>
					   	     <td bgcolor="white">&nbsp;</td>
							  <td bgcolor="white">&nbsp;</td>
							  <td bgcolor="white">&nbsp;</td>
					     </tr>
					    <tr height="30px" style="vertical-align: middle;" align="center">
					    <td bgcolor="white">&nbsp;</td>
					      <td bgcolor="white">&nbsp;</td>
					   	    <td bgcolor="white">&nbsp;</td>
					   	 <td bgcolor="white">&nbsp;</td>
					   	     <td bgcolor="white">&nbsp;</td>
					   	  <td bgcolor="white">&nbsp;</td>
					     </tr>
					        <tr height="30px" style="vertical-align: middle;" align="center">
					     <td bgcolor="white">&nbsp;</td>
					      <td bgcolor="white">&nbsp;</td>
					       <td bgcolor="white">&nbsp;</td>
					        <td bgcolor="white">&nbsp;</td>
					         <td bgcolor="white">&nbsp;</td>
					          <td bgcolor="white">&nbsp;</td>
					     </tr>
					     
					        <tr height="30px" style="vertical-align: middle;" align="center">
					      <td bgcolor="white">&nbsp;</td>
					       <td bgcolor="white">&nbsp;</td>
					        <td bgcolor="white">&nbsp;</td>
					         <td bgcolor="white">&nbsp;</td>
					          <td bgcolor="white">&nbsp;</td>
					           <td bgcolor="white">&nbsp;</td>
					     </tr>
					     
					        <tr height="30px" style="vertical-align: middle;" align="center">
					     <td bgcolor="white">&nbsp;</td>
					      <td bgcolor="white">&nbsp;</td>
					       <td bgcolor="white">&nbsp;</td>
					        <td bgcolor="white">&nbsp;</td>
					         <td bgcolor="white">&nbsp;</td>
					          <td bgcolor="white">&nbsp;</td>
					     </tr>
						</tbody>     
                </table>
            </div>

            
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

    <script src="http://code.jquery.com/jquery-3.0.0.min.js"></script>
<%--     <script src="${pageContext.request.contextPath}/js/prelodr.js"></script> --%>
   <!--  <script>
      $(function() {
        $('body').prelodr({
          prefixClass: 'prelodr',
          show: function(){
            console.log('Show callback')
          },
          hide: function(){
            console.log('Hide callback')
          }
        });
      });
    </script> -->
    <script type="text/javascript">
$(document).ready(function() {
		//alert("good morning!");
  	 $("#batchName").change(function() {
  		   var ccontextPath="${pageContext.request.contextPath}"
			var tableRemoteData="";
  		 // $('body').prelodr('in', 'Loading data please wait...');
  		   $.getJSON(ccontextPath+"/action/findConsultantsByBatch",{batchName:$("#batchName").val()},function(jsonResponse){
  			 //$('body').prelodr('out');
	  			 tableRemoteData=tableRemoteData+'<tbody>';
	  			 tableRemoteData=tableRemoteData+' <thead>';
	  			 tableRemoteData=tableRemoteData+'<tr style="background-color: #607D8B;">';
	  			 tableRemoteData=tableRemoteData+'<th class="submissions" style="color: white;font-family: sans-serif;font-size: 14px;">SNo</th>';
	  			 tableRemoteData=tableRemoteData+'<th class="author" style="color: white;font-family:  sans-serif;font-size: 14px;">Consultant Id</th>';
	  			 tableRemoteData=tableRemoteData+'<th class="author" style="color: white;font-family:  sans-serif;font-size: 14px;">Name </th>';
	  			 tableRemoteData=tableRemoteData+' <th class="score" style="color: white;font-family: sans-serif;font-size: 14px;">Email </th>';
	  			 tableRemoteData=tableRemoteData+'<th class="submit-date" style="color: white;font-family: sans-serif;font-size: 14px;">Photo </th>';
	  			 tableRemoteData=tableRemoteData+'<th style="color: white;font-family:sans-serif;font-size: 14px;">Action</th>';
	  			 tableRemoteData=tableRemoteData+'</tr>';
	  			 tableRemoteData=tableRemoteData+'</thead>';
	  			
  	  		for(var i=0;i<jsonResponse.length;i++){
			  			tableRemoteData=tableRemoteData+'<tr height="25px" style="color: black">';
			  			tableRemoteData=tableRemoteData+'<td>'+(i+1)+'</td>';
			  			tableRemoteData=tableRemoteData+'<td>&nbsp;'+jsonResponse[i].empid+'</td>';
			  			tableRemoteData=tableRemoteData+'<td>&nbsp;'+jsonResponse[i].name+'</td>';
			  			tableRemoteData=tableRemoteData+'<td>&nbsp;'+jsonResponse[i].email+'</td>';
			  			var imageURL=ccontextPath+'/action/findConsultantImage?userid='+jsonResponse[i].userid;
			  			tableRemoteData=tableRemoteData+'<td style="text-align:center;"><img style="border-radius: 25px;" src="'+imageURL+'" alt=""  width="40" height="40"/></td>';
			  			tableRemoteData=tableRemoteData+'<td>&nbsp;<a href="'+ccontextPath+'/action/${nextAction}?consultantId='+jsonResponse[i].userid+'"><img src="'+ccontextPath+'/images/more-detail.png"/>&nbsp;${nextTitle}</a></td>';
						tableRemoteData=tableRemoteData+' </tr>';
  		  		}	 
  	  		    $("#totalRecords").html(jsonResponse.length);
  	  	 var rows=6-jsonResponse.length;		
  	  	for(var p=0;p<rows;p++) {
				  	  	tableRemoteData=tableRemoteData+'<tr height="25px">';
				  	  tableRemoteData=tableRemoteData+'<td>&nbsp;</td>';
				  	tableRemoteData=tableRemoteData+' <td>&nbsp;</td>';
				  	tableRemoteData=tableRemoteData+'<td>&nbsp;</td>';
				  	tableRemoteData=tableRemoteData+'<td>&nbsp;</td>';
				  	tableRemoteData=tableRemoteData+'<td>&nbsp;</td>';
				  	tableRemoteData=tableRemoteData+'<td align="center">';
				  	tableRemoteData=tableRemoteData+'</td>';
				  	tableRemoteData=tableRemoteData+'</tr>';
  	  	}
				$("#tableContent").html(tableRemoteData);
  		   });
  			//$("#technologyFormId").submit();		
	 });
});
</script>	
</body>

</html>