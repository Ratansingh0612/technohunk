<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from envato.megadrupal.com/html/megacourse/account-assignment.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 19 Mar 2017 04:41:35 GMT -->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <title>${companyName} - Add Contents Course Details</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/trainer-css/trainer.css" type="text/css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css" type="text/css" media="all">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/treset.css"
	type="text/css" media="all">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/layout.css"
	type="text/css" media="all">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" type="text/css"
	media="all">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/tstyle.css"
	type="text/css" media="all">
	
	<link href="${pageContext.request.contextPath}/css/timedropper.css" rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.5.2.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/cufon-yui.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/cufon-replace.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/Molengo_400.font.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/Expletus_Sans_400.font.js"></script>
	 <script type="text/javascript" src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script> 
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-datepicker.js"></script>


  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath}/js/timedropper.js"></script>
<script>$( "#alarm" ).timeDropper();</script>
<script type="text/javascript">
</script>

<script type="text/javascript">
$(document).ready(function() {
	$("#addTopics").click(function(){
		var selectedTopics="";
		$("input:checkbox[name=selectedTopics]:checked").each(function(){
			selectedTopics=selectedTopics+$(this).val()+",";
			$("#topics").val(selectedTopics);
		});		
		
	});
	
	$("#pupopLink").click(function(){
		 var ccontextPath="${pageContext.request.contextPath}"
			 var planguage=$("#technologyname").val();
		 	  var tableContents="";
	 		   $.getJSON(ccontextPath+"/action/findTopicsByLanguage",{language:planguage},function(jsonResponse) {
	 				 var topicsData=jsonResponse.topicVOList;
	 				tableContents=tableContents+'<tr height="30px" 	style="color: white; background-color: pink; vertical-align: middle;" align="center">';
	 				tableContents=tableContents+'<td width="10px" style="color: black;"><b>SNO.</b></td>';
	 				tableContents=tableContents+'<td style="color: black;"><b>Topic Name</b>';
	 				tableContents=tableContents+'</td>';
	 				tableContents=tableContents+'	<td style="color: black;"><b>Action</b></td>	</tr>';
	 			   for(var i=0;i<topicsData.length;i++) {
	 				 //alert(")@)@)_@ = "+topicsData[i].topic);
	 				  tableContents=tableContents+'<tr height="25px" style="color: black">';
	 				  tableContents=tableContents+'<td bgcolor="white">&nbsp;'+(i+1)+'</td>';
	 				  tableContents=tableContents+'<td bgcolor="white">&nbsp;'+topicsData[i].topic+'</td>';
	 				  tableContents=tableContents+'<td bgcolor="white">&nbsp;<input type="checkbox" name="selectedTopics"   id="selectedTopics" value="'+topicsData[i].tid+'"/> </td>';
	 				  tableContents=tableContents+'</tr>';
	 			  } //end of the for loop
	 			
	 			 tableContents=tableContents+'<tr height="25px" style="color: black">';
	 			tableContents=tableContents+'<td bgcolor="white">&nbsp;</td>';
	 			tableContents=tableContents+'<td bgcolor="white">&nbsp;</td>';
	 			tableContents=tableContents+'<td bgcolor="white">&nbsp;</td>';
	 			tableContents=tableContents+'</tr>';
	 			tableContents=tableContents+'<tr height="25px" style="color: black">';
	 			tableContents=tableContents+'<td bgcolor="white">&nbsp;</td>';
	 			tableContents=tableContents+'<td bgcolor="white">&nbsp;</td>';
	 			tableContents=tableContents+'<td bgcolor="white">&nbsp;</td>';
	 			tableContents=tableContents+'</tr>';
		 		   $("#popupContents").html(tableContents);
	 		   });
	 		   
	});
});

</script>
<style type="text/css">
.modal-body{
    max-height: calc(100vh - 200px);
    overflow-y: auto;
}
</style>

</head>
<body id="page2"
	style="background:url(${pageContext.request.contextPath}/images/bg_top2.jpg) top repeat-x #fff;"
	onkeydown="return (event.keyCode != 116)">

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
    </div>
    <!-- END / PRELOADER -->

    <!-- HEADER -->
<%--      <%@include file="theader.jsp" %> --%>
    <!-- END / HEADER -->


    <!-- PROFILE FEATURE -->
    <%@include file="profile-feature.jsp" %>
    <!-- END / PROFILE FEATURE -->


    <!-- CONTEN BAR -->
     <%@include file="content-bar.jsp" %>
   <!-- END / CONTENT BAR -->
 
    <!-- COURSE CONCERN -->
  <div class="body121">
		<div class="main">
			<!-- header -->
			<!-- / header -->
		</div>
	</div>
	<div class="body2">
		<div class="main" style="background-color: white;">
			<section id="content">
				<div class="box1"><br/>
					<div class="wrapper">
							<span style="margin-left: 150px;"><img
								src="${pageContext.request.contextPath}/images/uphoto.png" />
							- <span style="font-family: 'Lato', sans-serif;font-size: 14px;">Add Course Contents Detail</span></span>
						 </div>
						 </div>
						 </section>
						 <br/>
						 <div class="container">
						<form:form commandName="courseContentsDetailVO" id="#" action="${pageContext.request.contextPath}/action/add-contents-course-detail" method="POST" class="form-inline" role="from">
							<table class="table table-bordered" width="60%">
							 <tbody>
							 
							 <tr height="25px" >
					     <td colspan="1" align="left" valign="bottom" >
					           <label for="sel1" style="margin-top: 5px;font-family: 'Lato', sans-serif;font-size: 14px;">Languages:</label>
								 &nbsp;&nbsp;
								 
								 <form:select path="technologyname" class="form-control"  style="width: 300px;display: inline;">
								 
								 	<form:options items="${languageList}"/>
								 
								 </form:select>
								  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
        <b>Please Add Topics Here</b>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body">
   <form:form class="form-inline">
		
				<table class="table table-bordered" id="popupContents">
					  <tr height="30px"
									style="color: white; background-color: pink; vertical-align: middle;"
									align="center">
									<td width="10px" style="color: black;"><b>SNO.</b>
									</td>
									<td style="color: black;" id="topicList"><b>Topic Name</b>
									</td>
									<td style="color: black;"><b>Action</b>
									</td>
									
								</tr>
								
								<tr height="25px" style="color: black">
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
								</tr>
								<tr height="25px" style="color: black">
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
								</tr>
								<tr height="25px" style="color: black">
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
								</tr>
								
				</table>

    
   </form:form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-primary btn-md" data-dismiss="modal">Close</button>
          <button type="button" class="btn btn-primary btn-md" id="addTopics" data-dismiss="modal">Add Topics</button>
        </div>
      </div>
      
    </div>
  </div>
  <td colspan="1" align="left" valign="bottom" >
					         &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;<label for="course" style="margin-top: 5px;font-family: 'Lato', sans-serif;font-size: 14px;">Course:</label>
								 &nbsp;&nbsp;  
								 
								 <form:select path="course" class="form-control"  style="width: 320px;display: inline;">
								 <form:options items="${courseList}"/>
								 </form:select>	
								 </tr>
								  <tr height="25px" >
					     <td colspan="1" align="left" valign="bottom" >
 								 <a href="javascript:" data-toggle="modal" data-target="#myModal" id="pupopLink"> <img
								src="${pageContext.request.contextPath}/images/select-topics.png"/></a>
 
 								 <label for="topic" style="margin-top: 5px;font-family: 'Lato', sans-serif;font-size: 14px;">Please Click here for Select Topics</label>
								 &nbsp;&nbsp;
								 
 								 </td> 
 						<td colspan="3" align="left">
 							  <label for="seltopics" style="margin-top: 5px;font-family: 'Lato', sans-serif;font-size: 14px;">Selected Topics:</label>
      						 <textarea rows="1" name="topics" id="topics" class="form-control"  readonly="readonly" style="min-width:70%"></textarea>
 							 </td>
								 
								  <tr height="25px" > 
				     <td colspan="3" align="left">
				     <label for="seltopics" style="margin-top: 5px;font-family: 'Lato', sans-serif;font-size: 14px;">Description:</label>
      						 <textarea rows="1" name="decription" id="decription" class="form-control"  readonly="readonly" style="min-width: 100%"></textarea>
      				     </td> 
					   </tr> 
 					   </tbody> 
                  </table>
                  <input type=submit value="Add Topics to Course" class="btn btn-primary btn-md"  id="#" style="float: right;font-family: 'Lato', sans-serif;font-size: 14px;"/>
		</form:form>
	
	</div>
		<hr/>
					</div>
				</div>

</body>

</html>