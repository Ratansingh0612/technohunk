<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Learn Center | Courses</title>
<meta charset="utf-8">
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
	 <script type="text/javascript" src=${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script> 
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<script type="text/javascript">
  function resetTestForUser(userid,testName) {
	    $("input[type='hidden'][name='hTestName']").val(testName);
	    $("input[type='hidden'][name='huserId']").val(userid);
	    $("#resetTestForm").submit();
  }
</script>

<script type="text/javascript">
$(document).ready(function() {
		//alert("good morning!");
//   	 $("input[type='button'][id='loadUsersId']").click(function() {
// 			$("#assignTestToUserFromid").submit();		
// 	 });
  	 
  	 $("#searchUsersBtn").click(function() {
  		alert( "Search User" );
  		$("#searchUser").submit();
  	 });
  	
});

</script>

<style type="text/css">
.not-active {
	 pointer-events: none;
	 cursor: default;
	}

	
</style>

<!--[if lt IE 9]>
<script type="text/javascript" src="js/html5.js"></script>
<style type="text/css">.bg, .box2{behavior:url("js/PIE.htc");}</style>
<![endif]-->




</head>
<body id="page2"
	style="background:url(${pageContext.request.contextPath}/images/bg_top2.jpg) top repeat-x #fff;"
	onkeydown="return (event.keyCode != 116)">
	<div class="body121">
		<div class="main">
			<!-- header -->
			   <%@include file="aheader.jsp"%>
			<!-- / header -->
		</div>
	</div>
	<div class="body2">
		<div class="main">
			<!-- content -->
			<section id="content">
				<div class="box1">
					<div class="wrapper">
						&nbsp;&nbsp;
						<h4 style="color: black">
							<img
								src="${pageContext.request.contextPath}/images/uphoto.png" />
							- <b>Available Users</b>
						</h4>
						 <form  id="resetTestForm" action="${pageContext.request.contextPath}/action/resetUserTest" method="post">
						        <input type="hidden" name="hTestName"/>
						        <input type="hidden" name="huserId"/>
						 </form>
						 </div>
						 </div>
						 </section>
						 
						 <div class="container">
						<form id="searchUser" action="${pageContext.request.contextPath}/action/findUsersByName" method="get">
							<input type="hidden" name="NoOfUsers"
								value="${fn:length(userList)}" /> <br /> 
								
										<div class="form-group">
    						  				<label for="search" style=" margin-left: 45px; margin-top:50px;">Search:</label>
      										<input type="search" class="form-control" name="userId"  placeholder="Search" style="width:300px; margin-left: 110px;margin-top: -30px;"/>
							   			 </div>
							   <button type="submit" class="btn btn-primary" id="searchUsersBtn"  style="margin-left: 450px; margin-top: -90px;">Search Users</button>
							
							
							 
							<!--   <input type="button" value="Filter" id="filterRecord"
									style="background-color: pink; color: black; font-weight: bold;height:25px;width: 80px "/>
                         -->
							<hr style="color: black" />
							   <h4 style="color: red">
								 ${ApplicationMessage}
						</h4>
							<hr style="color: blue" />
							<img
								src="${pageContext.request.contextPath}/images/User List.png" />
							<b>User List:-</b>
							<div style="float: right;">
								<img
									src="${pageContext.request.contextPath}/images/uphoto.png" />
								Total Users : <b>${fn:length(assignedTestUserList)}</b>
							</div>
							<table class="table table-bordered" width="100%">
								<tr height="30px"
									style="color: white; background-color: #013648; vertical-align: middle;"
									align="center">
									<td width="10px"><b>SNO.</b>
									</td>
									<td width="100px"><b>User Id</b>
									</td>
									<td><b>Test Status</b>
									</td>
									
									<td><b>Assign Date</b>
									</td>
									<td><b>Attampt Limit</b>
									</td>
									<td width="100px"><b>Reset Test</b>
									</td>
								</tr>
								<c:forEach var="userItem" items="${assignedTestUserList}"
									varStatus="status">
									<c:if test="${userItem.testStatus=='Not Started'}">
									<tr height="25px" style="color: black; vertical-align: middle;">
										<td align="center"><b>${status.count}.</b>
										</td>
										<td>&nbsp;${userItem.assignedTestCompositeKey.userId}</td>
										<td align="center">&nbsp;${userItem.testStatus}</td>
												<td>&nbsp;${userItem.assignDate}</td>
										<td align="center">&nbsp;${userItem.attamptLimit}</td>
										<td align="center">&nbsp;		<a href="javascript:resetTestForUser('${userItem.userId}','${techName}');" class="not-active"><img
								src="${pageContext.request.contextPath}/images/reset.png" width="24" height="24"/></a></td>
									</tr>
									</c:if>
									
										<c:if test="${userItem.testStatus=='complete'}">
									<tr height="25px" style="color: black; vertical-align: middle;">
										<td align="center"><b>${status.count}.</b>
										</td>
										<td>&nbsp;${userItem.assignedTestCompositeKey.userId}</td>
										<td align="center">&nbsp;${userItem.testStatus}</td>
												<td>&nbsp;${userItem.assignDate}</td>
										<td align="center">&nbsp;${userItem.attamptLimit}</td>
										<td align="center">&nbsp;		
										<a href="javascript:resetTestForUser('${userItem.userId}','${techName}');"><img
								src="${pageContext.request.contextPath}/images/reset.png" width="24" height="24"/></a></td>
									</tr>
									</c:if>
								</c:forEach>

								<tr height="25px" style="color: black">
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
								</tr>
								<tr height="25px" style="color: black">
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
								</tr>
								<tr height="25px" style="color: black">
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
								</tr>

								<tr height="25px"
									style="color: white; background-color: #FFC0CB; vertical-align: middle;"
									align="center">
									<td colspan="7" align="right">&nbsp; </td>
								</tr>
							</table>
							</form>
							</div>
							
					</div>
				</div>
			<!-- content -->

	 <footer id="footer" class="footer">
     <%--   <%@include file="/ffooter.jsp" %> --%>
       <%@include file="/sfooter.jsp" %>
    </footer>
</body>
</html>