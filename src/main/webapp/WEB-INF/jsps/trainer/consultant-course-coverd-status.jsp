<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon-96x96.png" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/trainer-css/trainer.css" type="text/css" media="all">
<title>${companyName} | Course Covered Status</title>
<meta charset="utf-8">
 <%@include file="/resources.jsp" %>
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/datepicker.css" type="text/css" media="all">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-datepicker.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">


<!-- Mirrored from envato.megadrupal.com/html/megacourse/account-assignment.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 19 Mar 2017 04:41:35 GMT -->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- Google font -->
     <script type="text/javascript">
 $(document).ready(function() {
	 $("#batchList").change(function() {
		 	var batchId=$(this).val();
			 var ccontextPath="${pageContext.request.contextPath}"
			 var tableContents="";
			 $.getJSON(ccontextPath+"/action/findCourseCoverageForBatch",{batchId:batchId},function(jsonResponse) {
				 $.each(jsonResponse,function(key,pdata){
					 tableContents=tableContents+'<hr/>';	
					 console.log(key);
					 var tokens=key.split(",");	
					 var totalCoursePerTokens=tokens[3].split("=");
					 var totalCoursePer=totalCoursePerTokens[1].substring(0,totalCoursePerTokens[1].length-1);
					 var nameTokens=tokens[2].split("=");
					 var useridTokens=tokens[0].split("=");
					 var imageURL=ccontextPath+'/action/findConsultantImage?userid='+useridTokens[1];
					 tableContents=tableContents+'<img style="border-radius: 25px;margin-top:-10px;" src="'+imageURL+'" alt=""  width="50" height="50"/>';
					 tableContents=tableContents+'&nbsp;&nbsp;(Name : <b>'+nameTokens[1].substring(0,(nameTokens[1].length-1))+")</b>"+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;User ID : <b style="color:red;">'+useridTokens[1]+"</b>";
					 tableContents=tableContents+'<br/><table class="table table-bordered" style="width: 100%;display: block;overflow-x: auto;" id="tableContent">';
					 tableContents=tableContents+'<tbody id="tableContent">	';				   
					 tableContents=tableContents+' <tr height="10px"  style="color: black;background-color:pink;vertical-align: middle;" align="center">';
					 tableContents=tableContents+'<td width="40px;"><b>Sno.</b></td>';
					 tableContents=tableContents+' <td><b>Technology</b></td>';
					 tableContents=tableContents+'<td style="width:20%;"><b>Topic Coverd</b></td>';
					 tableContents=tableContents+' <td width=""><b>Topic Remaining</b></td>';
					 tableContents=tableContents+'  <td width="40px;">';
					 tableContents=tableContents+'  <b>Complete(%)</b></td>';
					 tableContents=tableContents+' </tr>';
					 var datalen=pdata.length;
					 var innerData=pdata;
			        for(var rows=0;rows<datalen;rows++) {
			        	tableContents=tableContents+' <tr height="25px" style="color: black">';
			        	tableContents=tableContents+' <td>&nbsp;'+(rows+1)+'</td>';
			        	tableContents=tableContents+' <td>&nbsp;'+innerData[rows].technology+'</td>';
			        	tableContents=tableContents+' <td>&nbsp;'+innerData[rows].topicCovered+'</td>';
			        	tableContents=tableContents+' <td>&nbsp;'+innerData[rows].topicRemaining+'</td>';
			        	tableContents=tableContents+' <td align="center">'+innerData[rows].courseStatus+'</td>';
			        	tableContents=tableContents+' </tr>';
			        }
					 tableContents=tableContents+'<tr height="30px" style="vertical-align: middle;" align="center">';
					 tableContents=tableContents+'<td width="">&nbsp;</td>';
					 tableContents=tableContents+' <td width="">&nbsp;</td>';
					 tableContents=tableContents+' <td width="">&nbsp;</td>';
					 tableContents=tableContents+'<td align="left">&nbsp;Total Course Covered(%)   =   <span style="background-color:yellow;font-weight:bold;">'+totalCoursePer+'</span></td>';
					 tableContents=tableContents+' <td style="color:blue;">&nbsp;'+totalCoursePer+'</td>';
					 tableContents=tableContents+' </tr>';
					sssssssssss
					 tableContents=tableContents+' </table>';
					 tableContents=tableContents+'<hr/>';
				 });
				 if(jsonResponse){
					 var graphURL=ccontextPath+"/action/courseCoveredPercentageBarStatus?batchId="+batchId;
				 	tableContents=tableContents+'<img src="'+graphURL+'" width="1100px" height="450px;"/>';
				 }
				 $("#courseCoveredStatusContent").html(tableContents);
			 });
	 });
  	 
  	 
  	 
  	
});
</script>
</head>
<body id="page-top">

<!-- PAGE WRAP -->
<div id="page-wrap">

<div class="body121">
  <div class="main">
      <k:if test="${sessionScope.user_session_data.role=='trainer'}">	
      <%@include file="theader.jsp"%>
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
  <section style="padding-top: 0px;padding-bottom:10px;background-color: white;" id="quizz-intro-section" class="quizz-intro-section learn-section">
        <div class="container">

            <div class="title-ct">
                
                 <br><img src="${pageContext.request.contextPath}/images/course-icon.png" width="25"/> - <span style="font-family: 'Lato', sans-serif;font-size:14px;">Course Coverd Status</span> 
            </div>
            
            

            <div class="table-student-submission">
            
            <table class="table table-bordered" style="width: 70%;">
      			 		 <tbody>
      			 	 <tr height="25px" >
					     <td colspan="1" align="left" valign="bottom" >
					           <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 14px;">Select Batch:</label>
								 &nbsp;&nbsp;
								 <select class="form-control" name="batchList" id="batchList" style="width: 300px;display: inline;">
								 	<option>--Select Batch--</option>
								 		<c:forEach items="${batchMap}" var="item">
								 			<option value="${item.value}">${item.value}</option>
								 		</c:forEach>
								 </select>
								 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								
					     </td>
					       
					   </tr>
					  </tbody>
					  
					 </table>
                             
                              <div class="wrapper">
                <hr style="color: black"/> 
                   <h4 style="color: red">
								 ${ApplicationMessage}
						</h4>
                 <div id="courseCoveredStatusContent">
                 
                 <table class="table  table-bordered" width="100%">
                   <thead class="theader">
      			            <tr style="background-color: #b5e8fd;;color:black;">
      			          <td class="score" style="width:20%">SNo </td>
                            <td class="submit-date" style="width:20%">Technology</td>
                            <td class="author" style="width:20%">Topic Coverd</td>
                            <td class="submit-date" style="width:20%">Topic Remaining</td>
<!--                              <td class="submit-date" style="width:15%">Topic Remaining</td>  -->
                           	<td class="submit-date" style="width:20%">Complete(%)</td> 
                         </tr>
                   </thead>
                             
<!--                 <table class="table table-bordered"> -->
<!--                     <thead class="theader"> -->
<!--                         <tr style="background-color: #1192ea;"> -->
<!--                             <th class="submissions">SNo</th> -->
<!--                             <th class="author">Technology</th> -->
<!--                             <th class="author">Topic Coverd</th> -->
<!--                             <th class="score">Topic Remaining</th> -->
<!--                             <th class="submit-date">Complete(%)</th> -->
<!--                         </tr> -->
<!--                     </thead> -->

                    <tbody>
                      <tr height="25px" style="color: black">
					     <td>&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td align="center">
							</td>
							 <td align="center">
							</td>
					     </tr>
					    <tr height="30px" style="vertical-align: middle;" align="center">
					     <td width="10px">&nbsp;</td>
					      <td width="10px">&nbsp;</td>
					   	   <td width="300px">&nbsp</td>
					   	   <td>&nbsp</td>
					   	    <td>&nbsp</td>
					     </tr>
					        <tr height="30px" style="vertical-align: middle;" align="center">
					     <td width="10px">&nbsp;</td>
					      <td width="10px">&nbsp;</td>
					   	   <td width="300px">&nbsp</td>
					   	   <td>&nbsp</td>
					   	    <td>&nbsp</td>
					     </tr>
					     
					        <tr height="30px" style="vertical-align: middle;" align="center">
					     <td width="10px">&nbsp;</td>
					      <td width="10px">&nbsp;</td>
					   	   <td width="300px">&nbsp</td>
					   	   <td>&nbsp</td>
					   	    <td>&nbsp</td>
					     </tr>
					     
					        <tr height="30px" style="vertical-align: middle;" align="center">
					     <td width="10px">&nbsp;</td>
					      <td width="10px">&nbsp;</td>
					   	   <td width="300px">&nbsp</td>
					   	    <td>&nbsp</td>
					   	    <td>
					   	    <b>&nbsp</b></td>
					     </tr>
						</tbody>     
                </table>
                </div>
            </div>

            
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
</body>

</html>