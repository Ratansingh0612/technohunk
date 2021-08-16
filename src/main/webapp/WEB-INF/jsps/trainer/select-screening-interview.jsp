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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/trainer-css/trainer.css" type="text/css" media="all">
   <script type="text/javascript"
	src="http://code.jquery.com/jquery.min.js" charset="utf-8"></script>
    	<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/jquery-te-1.4.0.css" />
<script type="text/javascript"	src="${pageContext.request.contextPath}/js/jquery-te-1.4.0.min.js"></script>
    <title>${companyName} - Select Screening Interview</title>

  <script type="text/javascript">
$(document).ready(function() {
		//alert("good morning!");
  	 $("input[type='button'][id='loadUsers']").click(function() {
  		   var ccontextPath="${pageContext.request.contextPath}"
			var tableRemoteData="";
  		   $.getJSON(ccontextPath+"/action/findConsultantsByBatch",{batchName:$("#batchName").val()},function(jsonResponse){
  			 tableRemoteData=tableRemoteData+'<tr height="30px" style="color: white;background-color:#013648;vertical-align: middle;" align="center">';
	  	  		tableRemoteData=tableRemoteData+'<td width="10px"><b>Sno.</b></td>';
	  	  		tableRemoteData=tableRemoteData+'<td width="10px"><b>EmpId</b></td>';
	  			tableRemoteData=tableRemoteData+'<td width="300px"><b>Name</b></td>';
	  			tableRemoteData=tableRemoteData+'<td><b>Email</b></td>';
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
			  			var imageURL=ccontextPath+'/action/findConsultantImage?userid='+jsonResponse[i].userid;
			  			tableRemoteData=tableRemoteData+'<td style="text-align:center;"><img style="border-radius: 25px;" src="'+imageURL+'" alt=""  width="50" height="50"/></td>';
			  			tableRemoteData=tableRemoteData+'<td>&nbsp;<a href="'+ccontextPath+'/action/${nextAction}?consultantId='+jsonResponse[i].userid+'"><img src="'+ccontextPath+'/img/start-interview.png"/>&nbsp;Interview</a></td>';
						tableRemoteData=tableRemoteData+' </tr>';
  		  		}	 
				$("#tableContent").html(tableRemoteData);
  		   });
  			//$("#technologyFormId").submit();		
	 });
});
</script>	

<!--[if lt IE 9]>
<script type="text/javascript" src="js/html5.js"></script>
<style type="text/css">.bg, .box2{behavior:url("js/PIE.htc");}</style>
<![endif]-->
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
    <section class="quizz-intro-section" style="padding-top: 0px;padding-bottom:10px;background-color: #eee;min-height: 600px;" id="content">
<!--   <section style="padding-top: 0px;padding-bottom:10px;background-color: white;" id="quizz-intro-section" class="quizz-intro-section learn-section"> -->
        <div class="container">
            <div class="title-ct">
                
                 &nbsp;&nbsp;<h3 style="color: black;font-size: 18px;"><img src="${pageContext.request.contextPath}/images/configure.png" width="25px;"/> - <b> Consultant Screening Interview(s)</b></h3> 
            </div>
                    <table class="table table-bordered" width="60%">
      			 	 <tbody>
      			 	 <tr height="25px" >
					     <td colspan="1" align="left" valign="bottom" >
					           <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Name&nbsp;&nbsp;: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${consultantsVO.name}</label>
								 &nbsp;&nbsp;
								  <img style="border-radius: 25px;" src="${pageContext.request.contextPath}/action/findConsultantImage?userid=${param.consultantId}" alt=""  width="50" height="50"/>
								 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;     <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Consultant Id&nbsp;&nbsp;: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${param.consultantId}</label>
							 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;     <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Designation&nbsp;&nbsp;: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	${consultantsVO.role}</label>
							 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Batch&nbsp;&nbsp;: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	${consultantsVO.batch}</label>
								 &nbsp;&nbsp;
					     </td>
					   </tr>
					   <tr height="25px" >
					     <td colspan="1" align="left" valign="bottom" >
					           <br/>
					           <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Address&nbsp;&nbsp;: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CA100, Fremont</label>
								 &nbsp;&nbsp;
								 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;     <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">DOJ&nbsp;&nbsp;: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;19-Sept-2017</label>
							 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;     <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Email&nbsp;&nbsp;: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	vxfxfxxfxf@gmail.com</label>
							 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Mobile&nbsp;&nbsp;: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	9283773633</label>
								 &nbsp;&nbsp;
					     </td>
					   </tr>
					  </tbody>
					 </table>
            
           <%--  <table class="table table-bordered" width="60%">
      			 	 <tbody>
      			 	 <tr height="25px" >
					     <td colspan="1" align="left" valign="bottom" >
					           <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Technology:</label>
								 &nbsp;&nbsp;
								  <form:select path="technology" items="${technologyList}" multiple="false" class="form-control"  style="width:300px;display:inline;"/>
								 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								   <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Topic:</label>
								 &nbsp;&nbsp;
								 <form:select path="topic" items="${questionComplexityList}" multiple="false"  class="form-control"  style="width:300px;display:inline;"/>
					   			 <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;margin-left: 60px;">Question No   :   </label><span id="questionNumber" style="background-color: yellow;">${totalQuestions}</span>
					     </td>
					   </tr>
					  </tbody>
					 </table> --%>
 <hr style="color: blue"/>
                <div class="table-student-submission">
            <span style="font-family: 'Lato', sans-serif;font-size: 16px;">Consultant Interview(s) List:-</span>
					    <div style="float: right;">
								<img src="../images/favicon.ico" height="30px">&nbsp;<span style="font-family: 'Lato', sans-serif;font-size: 14px;color:blue;">Total Screening(s) :</span> <b><span id="totalUsers" style="color:red;">${fn:length(consultantScreeningInterviewVOs)}</span></b>
							</div>
                <table class="table table-bordered" id="tab1">
                    <thead>
                        <tr style="background-color: #1192ea;">
                            <th class="submissions" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">SNo</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Consultant Id</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Screening ID. </th>
                            <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Date of Screening</th>
                            <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Status</th>
                        </tr>
                    </thead>

                    <tbody>
                      <c:forEach items="${consultantScreeningInterviewVOs}" var="item" varStatus="pk">
					       <tr style="color: black">
					     <td bgcolor="white">&nbsp;${pk.count}.</td>
					   	   <td bgcolor="white">&nbsp;${item.consultantId}</td>
					   	   <td bgcolor="white">&nbsp;${item.interviewId}</td>
					   	    <td bgcolor="white">&nbsp;${item.dateOfInterview}</td>
					   	   <td  bgcolor="white">&nbsp;<a href="${pageContext.request.contextPath}/action/viewScreeningInterviewStatus?consultantId=${item.consultantId}&interviewId=${item.interviewId}"><img src="${pageContext.request.contextPath}/img/start-interview.png"/>&nbsp;Detail</a></td>
					     </tr>
					     </c:forEach>
					     <tr style="color: black">
					     <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	    <td bgcolor="white">&nbsp;</td>
					   	   <td  bgcolor="white">&nbsp;</td>
					     </tr>
					   <tr  style="color: black">
					     <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	    <td bgcolor="white">&nbsp;</td>
					   	   <td  bgcolor="white">&nbsp;</td>
					     </tr>
					   <tr style="color: black">
					     <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	    <td bgcolor="white">&nbsp;</td>
					   	   <td  bgcolor="white">&nbsp;</td>
					     </tr>
					   <tr  style="color: black">
					     <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	    <td bgcolor="white">&nbsp;</td>
					   	   <td  bgcolor="white">&nbsp;</td>
					     </tr>
					     
					     <tr  style="color: black">
					     <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	    <td bgcolor="white">&nbsp;</td>
					   	   <td  bgcolor="white">&nbsp;</td>
					     </tr>
					     
					     <tr  style="color: black">
					     <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	    <td bgcolor="white">&nbsp;</td>
					   	   <td  bgcolor="white">&nbsp;</td>
					     </tr>
					     
					       <tr  style="color: black">
					     <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	    <td bgcolor="white">&nbsp;</td>
					   	   <td  bgcolor="white">&nbsp;</td>
					     </tr>
					     


                    </tbody>
                </table>
                </div>

            
        </div>
    </section>
			  <footer id="footer" class="footer">
     <%--   <%@include file="/ffooter.jsp" %> --%>
       <%@include file="/sfooter.jsp" %>
    </footer>
    <!-- END / FOOTER -->



<!-- END / PAGE WRAP -->

<!-- Load jQuery -->
<!-- Load jQuery -->
  <%@include file="/js.jsp" %>
</body>
</html>