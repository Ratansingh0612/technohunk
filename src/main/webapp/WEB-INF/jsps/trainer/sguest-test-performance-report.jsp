<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <title>${companyName} - Search & Guest Reset sTest History</title>
    
    <style>
<!--
input[type="checkbox"] { -webkit-appearance: checkbox; }
input[type="radio"] { -webkit-appearance: radio; }
input[type="submit"], input[type="button"] { -webkit-appearance: button; }
select { -webkit-appearance:textfield; }
-->

#tab1 img{height:30px;}
</style>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css//TableBarChart.css" />
	<style type="text/css">
		table {
			border-collapse: collapse;
		}
		caption {
			background: #D3D3D3;
		}
		th {
			background: #b6ffd7;
			border: 1px solid #98BF21;
			color: black;
			font-weight: normal;
			text-align: left;
		}
		td {
			text-align: left;
			font-weight: normal;
			color: #000000;
		}
		tr:nth-child(odd) {
			background: #ffffff;
		}
		tbody tr:nth-child(odd) th {
			background: #ffffff;
			color: #000000;
		}
		tr:nth-child(even) {
			background: #EAF2D3;
		}
		tbody tr:nth-child(even) th {
			background: #EAF2D3;
			color: #000000;
		}
		#source {
			width: 100%;
		}
		#target {
			width: 55%;
			height: 400px;
		}
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
     <%@include file="content-bar.jsp" %>
   <!-- END / CONTENT BAR -->
 
    <!-- COURSE CONCERN -->
    <section class="quizz-intro-section" style="padding-top: 0px;padding-bottom:10px;background-color: #eee;min-height: 600px;" id="content">
<!--   <section style="padding-top: 0px;padding-bottom:10px;background-color: white;" id="quizz-intro-section"> -->
        <br/>	
        <div class="container" style="background-color: white;">
                <h3 style="color: black"><img src="${pageContext.request.contextPath}/images/icon/performance.png" width="50px;"/>&nbsp;&nbsp;<span style="font-size: 18px;">Test - > Guest Test Performance Report</span></h3> 
						 <div class="col-xs-12" style="margin-top: 20px;font-size: 16px;background-color: #156bb4;color:white;">
								<span style="margin-right: 100px;">Name : ${guestUser.name}</span><span style="margin-right: 100px;">Email : ${guestUser.email}</span><span style="margin-right: 100px;">Gender : ${guestUser.gender}</span>
						</div>
								
							&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 

            <div class="table-student-submission">
	<table id="source">
		<thead>
			<tr  style="border: 1px solid #98BF21;">
				<th></th>
				<k:forEach items="${testNames}"  var="tname">
					<th>${tname}</th>
				</k:forEach>
			</tr>
		</thead>
		<tbody>
		<k:forEach var="rowdata" items="${testResultReportMap}">
			<tr style="border: 1px solid #98BF21;">
				<th>${rowdata.key}</th>
				<k:forEach items="${rowdata.value}" var="rowcol">
					<td  style="border: 1px solid #98BF21;">${rowcol.score}</td>
				</k:forEach>
				
			</tr>
			</k:forEach>
			
		</tbody>
	</table>
	<p/>
 <table style="width: 100%;">
 <tr>
 <td>
<div id="target" style="">
	</div>
	</td>
	</tr>
	</table>
		      		
        </div>
        </div>
    </section>
   
  <br/>
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
  <%@include file="/js.jsp" %>
  	<script type="text/javascript" src="${pageContext.request.contextPath}/js/TableBarChart.js"></script>
	
   <script type="text/javascript">
	
  $(document).ready(function(){
	     var tsize="${testNames.size()}";
		$('#source').tableBarChart('#target','', false);
	/* 	var per=tsize*20;
		 if(per>100){
			 tsize=100;
		 }
		document.getElementById("target").style.width = per+"%"; */
		//$("#source").hide();
	});	
    
 function deleteGuestUserTestWithHistory(userid,gid) {
	  	var ccontextPath="${pageContext.request.contextPath}";
			  var yesno=confirm("Are you sure want to delete the test for "+userid);
			  if(yesno) {
		      		$.getJSON(ccontextPath+"/action/delete-guest-user-test", {userid:userid,gid:gid,withHistoryStatus:"yes"}, function(jsonResponse) {
	  		  				console.log(jsonResponse); 
	  		  				$("#ApplicationMessage").html(jsonResponse.message);
	  		  				$("#"+gid).hide();
		      		});			
		      }		
  } 
  
 function resetGuestUserTest(userid,userSessionId,gid) {
  	      var ccontextPath="${pageContext.request.contextPath}";
  	    var yesno=confirm("Are you sure want to reset the test with history for "+userid);
		  if(yesno) {
				  $.getJSON(ccontextPath+"/action/reset-guest-user-test", {userid:userid,userSessionId:userSessionId,withHistoryStatus:"yes"}, function(jsonResponse) {
		  		  		console.log(jsonResponse); 
		  		 	    $("#ApplicationMessage").html(jsonResponse.message);
		  		 	 	$("#status"+gid).html("&nbsp;Not Started");
		     	});
		  }  
  } 
  
  function resetGuestUserTestWithOutHistory(userid,userSessionId,gid) {
	  	var ccontextPath="${pageContext.request.contextPath}";
	  	var yesno=confirm("Are you sure want to reset the test without history for "+userid);
		  if(yesno) {
				$.getJSON(ccontextPath+"/action/reset-guest-user-test", {userid:userid,userSessionId:userSessionId,withHistoryStatus:"no"}, function(jsonResponse) {
		  		  console.log(jsonResponse); 
		  		  $("#ApplicationMessage").html(jsonResponse.message);
	  			  $("#status"+gid).html("&nbsp;Not Started");
	  		});
		  }		
	  } 
</script>
</body>
</html>