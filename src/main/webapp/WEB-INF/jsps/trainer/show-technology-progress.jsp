<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
    <title>${companyName} - Show Technology Progress</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/trainer-css/trainer.css" type="text/css" media="all">
     <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script
    src="http://maps.googleapis.com/maps/api/js?key=YOUR_APIKEY&sensor=false">
</script>
     <script type="text/javascript">
     $(document).ready(function() {
 		//alert("good morning!");
   	 $("#batchName").change(function() {
   		   var ccontextPath="${pageContext.request.contextPath}"
 			var tableRemoteData="";
//    		 $('body').prelodr('in', 'Loading data please wait...');
   		   $.getJSON(ccontextPath+"/action/findConsultantsByBatch",{batchName:$("#batchName").val()},function(jsonResponse){
//    			 $('body').prelodr('out');
   			 tableRemoteData=tableRemoteData+'<tr style="background-color: #607D8B;;color:white;">';
 	  	  		tableRemoteData=tableRemoteData+'<td width="10px"><b>SNo.</b></td>';
 	  	  		tableRemoteData=tableRemoteData+'<td width="10px"><b>EmpId</b></td>';
 	  			tableRemoteData=tableRemoteData+'<td width="300px"><b>Name</b></td>';
 	  			tableRemoteData=tableRemoteData+'<td><b>Email</b></td>';
 	  			tableRemoteData=tableRemoteData+'<td><b>Doj</b></td>';
 	  			tableRemoteData=tableRemoteData+'<td width="60px"><b>Photo</b></td>';
 	  			tableRemoteData=tableRemoteData+'<td width="120px">';
 	  			tableRemoteData=tableRemoteData+'<b>Action</b></td>';
 	  			tableRemoteData=tableRemoteData+'</tr>';
 	  			
   	  		for(var i=0;i<jsonResponse.length;i++){
 			  			tableRemoteData=tableRemoteData+'<tr height="25px" style="color: black">';
 			  			tableRemoteData=tableRemoteData+'<td>'+(i+1)+'</td>';
 			  			tableRemoteData=tableRemoteData+'<td>&nbsp;'+jsonResponse[i].empid+'</td>';
 			  			tableRemoteData=tableRemoteData+'<td>&nbsp;'+jsonResponse[i].name+'</td>';
 			  			tableRemoteData=tableRemoteData+'<td>&nbsp;'+jsonResponse[i].email+'</td>';
 			  			tableRemoteData=tableRemoteData+'<td>&nbsp;19-Feb-2018</td>';
 			  			var imageURL=ccontextPath+'/action/findConsultantImage?userid='+jsonResponse[i].userid;
 			  			tableRemoteData=tableRemoteData+'<td style="text-align:center;"><img style="border-radius: 25px;" src="'+imageURL+'" alt=""  width="50" height="50"/></td>';
 			  			tableRemoteData=tableRemoteData+'<td>&nbsp;<a href="'+ccontextPath+'/action/find-consultant-detail?consultantId='+jsonResponse[i].userid+'&empid='+jsonResponse[i].empid+'">Detail</a></td>';
 						tableRemoteData=tableRemoteData+' </tr>';
   		  		}	 
   	  		var brows=6-jsonResponse.length;
   	  		 for(var p=0;p<brows;p++) {
 	  	  		 tableRemoteData=tableRemoteData+'<tr height="30px">';
 	  	  		 tableRemoteData=tableRemoteData+'<td width="10px">&nbsp;</td>';
 	  	 		 tableRemoteData=tableRemoteData+'<td width="10px">&nbsp;</td>';
 	  			 tableRemoteData=tableRemoteData+'<td width="300px">&nbsp</td>';
 	  		 	tableRemoteData=tableRemoteData+'<td>&nbsp</td>';
 			  	tableRemoteData=tableRemoteData+'<td>&nbsp</td>';
 			  	tableRemoteData=tableRemoteData+'<td>&nbsp</td>';
 			  	tableRemoteData=tableRemoteData+'<td>&nbsp</td>';
 			  	tableRemoteData=tableRemoteData+'</tr>';
 			  	}
   	  		    $("#totalRecords").html(jsonResponse.length);
 				$("#tableContent").html(tableRemoteData);
   		   });
   			//$("#technologyFormId").submit();		
 	 });
 });
</script>	
</head>
<body id="page2" style="background:url(${pageContext.request.contextPath}/images/bg_top2.jpg) top repeat-x #fff;" onkeydown="return (event.keyCode != 116)">
<div class="body121">
  <div class="main">
    <!-- header -->
    <!-- / header -->
  </div>
</div>
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
   <section class="quizz-intro-section" style="padding-top: 0px;padding-bottom:10px;background-color: #eee;min-height: 600px;" id="content">
   		<hr/>
      <div class="container" style="background-color: white;">
         <br/>
         <div class="title-ct">
                 &nbsp;&nbsp;<h3 style="color: black;font-size: 17px;display: inline;"><img src="${pageContext.request.contextPath}/images/document-paper-64.png" width="40px;"/> - <b> Consultant Course Progress Status Page</b></h3>
            </div>
             <br/>
            <div class="table-student-submission">
          	<table class="table table-bordered">
      			 	 <tbody>
      			 	 <tr height="25px" >
					     <td colspan="1" align="left" valign="bottom" >
					           <label for="sel1" style="font-size: 16px;">Select Batch:</label>
								 &nbsp;&nbsp;
								 <select class="form-control" name="batchName" id="batchName" style="width: 300px;display: inline;">
								 <option>--Select Batch--</option>
								 		<c:forEach items="${batchList}" var="item">
								 		<option>${item}</option>
								 		</c:forEach>
								 </select>
								 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<!--   <input type="button" value="Load Users" class="btn btn-primary btn-md"  id="loadUsers"/> -->
					     </td>
					        <td colspan="1" align="left" valign="bottom" >
					     </td>
					   </tr>
					  </tbody>
					 </table>
					   <hr style="color: blue;height: 5px;background-color: #37abf2;"/>
					   <img src="${pageContext.request.contextPath}/images/icon/cheers.png" width="40px;"/> 
					    <span style="font-size: 14px;"> Consultant(s) List:-</span>
					    <div style="float: right;">
                         <img src="${pageContext.request.contextPath}/images/favicon.ico" width="25px;"> <span style="font-size: 14px;"> Total Records :</span> <b><span id="totalRecords">${fn:length(allTechs)}</span></b>
                             </div> 
                              <div class="wrapper">
                   <h4 style="color: red">
								 ${ApplicationMessage}
						</h4>
                             <table class="table  table-bordered"   id="tableContent">
      			 <tr style="background-color: #607D8B;;color:white;">
      			          <td class="score" style="width:20%">SNo </td>
                            <td class="submit-date" style="width:20%">EmpId</td>
                            <td class="author" style="width:20%">Name</td>
                            <td class="submit-date" style="width:20%">Email</td>
                                         <td class="submit-date" style="width:20%">Doj</td>
                             <td class="submit-date" style="width:15%">Photo</td> 
                            	<td class="submit-date" style="width:20%">Action</td>
                            	
<!--                              <td class="submit-date" style="width:15%">Test Name</td> -->
<!--                               <td class="submit-date" style="width:20%">Marks Obtained</td> -->
                         </tr>

                      <tr height="25px" style="color: black">
					     <td>&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	      	   <td>&nbsp;</td>
					   	    <td align="center">
							</td>
							 <td align="center">
							</td>
							 <td align="center">
							</td>
					     </tr>
					    <tr height="30px" style="vertical-align: middle;" align="center">
					     <td width="10px">&nbsp;</td>
					      <td width="10px">&nbsp;</td>
					   	 <td width="10px">&nbsp;</td>
					   	  <td width="10px">&nbsp;</td>
					   	   <td width="10px">&nbsp;</td>
					   	    <td>
					   	  <td width="10px">&nbsp;</td>
					     </tr>
					         <tr height="30px" style="vertical-align: middle;" align="center">
					     <td width="10px">&nbsp;</td>
					      <td width="10px">&nbsp;</td>
					   	  <td width="10px">&nbsp;</td>
					   	  <td width="10px">&nbsp;</td>
					   	   <td width="10px">&nbsp;</td>
					   	    <td>
					   	  <td width="10px">&nbsp;</td>
					     </tr>
					     
					      <tr height="30px" style="vertical-align: middle;" align="center">
					     <td width="10px">&nbsp;</td>
					   	 <td width="10px">&nbsp;</td>
					   	  <td width="10px">&nbsp;</td>
					   	  <td width="10px">&nbsp;</td>
					   	   <td width="10px">&nbsp;</td>
					   	    <td>
					   	  <td width="10px">&nbsp;</td>
					     </tr>
					     
					          <tr height="30px" style="vertical-align: middle;" align="center">
					     <td width="10px">&nbsp;</td>
					      <td width="10px">&nbsp;</td>
					   	 <td width="10px">&nbsp;</td>
					   	  <td width="10px">&nbsp;</td>
					   	   <td width="10px">&nbsp;</td>
					   	    <td>
					   	  <td width="10px">&nbsp;</td>
					     </tr>
						</tbody>     
                </table>
            </div>
        </div>
    </div>
    </section>
    <!-- END / COURSE CONCERN -->
          <script src="http://code.jquery.com/jquery-3.0.0.min.js"></script> 
     <script src="${pageContext.request.contextPath}/js/prelodr.js"></script> 
    <script> 
//    $(function() {
//          $('body').prelodr({
//            prefixClass: 'prelodr',
//            show: function(){
//              console.log('Show callback')
//            },
//            hide: function(){
//              console.log('Hide callback')
//            }
//          });
//       });
     </script> 

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

</body>

</html>