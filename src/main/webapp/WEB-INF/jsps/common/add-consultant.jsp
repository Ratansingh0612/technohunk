<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from envato.megadrupal.com/html/megacourse/account-assignment.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 19 Mar 2017 04:41:35 GMT -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/img/favicon-96x96.png" />
<!-- Google font -->
<%@include file="/resources.jsp"%>
<title>${companyName}- Add Consultant</title>
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/datepicker.css"
	type="text/css" media="all">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap-datepicker.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">

<style>
<!--
input[type="checkbox"] {
	-webkit-appearance: checkbox;
}

input[type="radio"] {
	-webkit-appearance: radio;
}

input[type="submit"], input[type="button"] {
	-webkit-appearance: button;
}

select {
	-webkit-appearance: textfield;
}
-->
</style>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("input[type='text']").keyup(function() {
							$("#errorMessage").html("");
						});

						$("#doj").datepicker();
						$("#doj").val("02/05/2019");
						//alert("good morning!");
						$("input[type='button'][id='userRegistrationBt']")
								.click(
										function() {
											//validating the test name
											var org = $("#org").val();
											if (org.length == 0) {
												$("#errorMessage")
														.html(
																"Org  cannot be blank.......");
														$("#org").focus();
												return;
											} /* else {
												var ccontextPath = "${pageContext.request.contextPath}";
												$
														.getJSON(
																ccontextPath
																		+ "/action/check-consultantid",
																{
																	consultantId : empid
																},
																function(
																		jsonResponse) {
																	if (jsonResponse.status == "yes") {
																		$(
																				"#errorMessage")
																				.html(
																						"Sorry this  empid is already in use.......");
																		$(
																				"input[type='text'][name='empid']")
																				.focus();
																		return;
																	}
																});
											} */

											var fname = $(
													"input[type='text'][name='name']")
													.val();
											if (fname.length == 0) {
												$("#errorMessage")
														.html(
																"First Name cannot be blank.......");
												$(
														"input[type='text'][name='name']")
														.focus();
												return;
											}

											var email = $(
													"input[type='text'][name='email']")
													.val();
											if (email.length == 0) {
												$("#errorMessage")
														.html(
																"Email cannot be blank.......");
												$(
														"input[type='text'][name='email']")
														.focus();
												return;
											}

											var mobile = $(
													"input[type='text'][name='mobile']")
													.val();
											if (mobile.length == 0) {
												$("#errorMessage")
														.html(
																"Mobile cannot be blank.......");
												$(
														"input[type='text'][name='mobile']")
														.focus();
												return;
											}

											var stream =$("#stream")
													.val();
											if (stream.length == 0) {
												$("#errorMessage")
														.html(
																"Steam cannot be blank.......");
												$("#stream")
														.focus();
												return;
											}

											
											var address = $("#address")
											.val();
									if (address.length == 0) {
										$("#errorMessage")
												.html(
														"Address cannot be blank.......");
												 $("#address")
												.focus();
										return;
									}

											$("#userRegistrationForm").submit();
										});

					});
</script>
</head>
<body id="page2" onkeydown="return (event.keyCode != 116)">
	<!-- PAGE WRAP -->
	<div id="page-wrap">
		  <!-- HEADER -->
    <header id="header" class="header">
        <%@include file="/lheader.jsp" %>
    </header>
    <!-- END / HEADER -->
	<hr/>
		<!-- COURSE CONCERN -->

		<div class="main">
			<!-- content -->

			<section id="content">
				<div class="box1">
					<div class="wrapper" style="">
						<div class="container">
							<form:form id="userRegistrationForm" method="POST"
								commandName="consultant" enctype="multipart/form-data"
								action="${pageContext.request.contextPath}/action/add-consultant-admin"
								class="form-horizontal">
								<img
									src="${pageContext.request.contextPath}/images/icon/file-icon.png"
									width="50px;" /> 
										<img
									src="${pageContext.request.contextPath}/images/notes/course/corejava/new.gif"
									width="70px;" /> 
								- <span style="font-size: 17px;; font-weight: bold;">Consultant
									Sign Up Page</span>
								<br />
								<span
									style="color: #ea210c; margin-left: 135px; font-size: 17px;; font-weight: bold;"
									id="errorMessage">${ApplicationMessage}</span>
								<br />
								<br />
								<div class="form-group">
									<label class="col-sm-2 control-label"
										style="font-family: 'Lato', sans-serif; font-size: 17px;">Consultancy
										Name* </label>
									<div class="col-sm-5">
										<form:select class="form-control" path="org"  cssStyle="background-color:azure;height:40px;font-size: 17px;">
											<option value="Reb3Tech">Rab3 Tech</option>
											<option value="CubicTech">Cubic Tech</option>
											<option value="Kuebiko">Kuebiko</option>
										</form:select>
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 control-label"
										style="font-family: 'Lato', sans-serif; font-size: 17px;">Name
										* </label>
									<div class="col-sm-7">
										<form:input path="name" class="form-control" id="name"  cssStyle="height: 40px;font-size: 17px;color:black;font-weight:bold;" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label"
										style="font-family: 'Lato', sans-serif; font-size: 17px;;">Email
										*</label>
									<div class="col-sm-7">
										<form:input path="email" class="form-control " id="email"  cssStyle="height: 40px;font-size: 17px;color:black;" />
									</div>
								</div>
								
									<div class="form-group">
									<label class="col-sm-2 control-label"
										style="font-family: 'Lato', sans-serif; font-size: 17px;;">Mobile
										*</label>
									<div class="col-sm-5">
										<form:input path="mobile" class="form-control " id="mobile"  cssStyle="height: 40px;font-size: 17px;color:black;background-color:#fffffa;" />
									</div>
								</div>
								<div class="form-group"
									style="margin-left: -10px; width: 100%;">
									<label class="col-sm-2 control-label"
										style="font-family: 'Lato', sans-serif; font-size: 17px;;">DOJ
									</label>
									<div class="col-sm-5">
										<form:input path="doj" class="form-control"  cssStyle="height: 40px;font-size: 17px;color:black;" />
									</div>
								</div>
									<div class="form-group">
									
										<label class="col-sm-2 control-label"
										style="font-family: 'Lato', sans-serif; font-size: 17px;">Batch
									</label>
									<div class="col-sm-3">
										<form:select class="form-control" path="batch" cssStyle="height: 40px;font-size: 17px;color:black;background-color:#f7f7f7;">
											<form:options items="${batchList}" />
										</form:select>
									</div>
									
									<label class="col-sm-2 control-label"
										style="font-family: 'Lato', sans-serif; font-size: 17px;margin-left: -100px;">Gender
									</label>
									<div class="col-sm-3">
										<form:select class="form-control" path="gender"  cssStyle="background-color:azure;height: 40px;font-size: 17px;color:black;">
											<option>Male</option>
											<option>Female</option>
										</form:select>
									</div>
								
								</div>
								<br />
							
								<div class="form-group">
									
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label"
										style="font-family: 'Lato', sans-serif; font-size: 17px;;">Stream
										*</label>
									<div class="col-sm-3">
											<form:select class="form-control" path="stream"  cssStyle="background-color:azure;height:40px;font-size: 17px;">
											<option>IT</option>
											<option>Non IT</option>
											<option>NA
											</option>
										</form:select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label"
										style="font-family: 'Lato', sans-serif; font-size: 17px;;">Address
										*</label>
									<div class="col-sm-7">
										<form:textarea path="address" class="form-control" value="SOT" cssStyle="height: 40px;background-color:#f8f8ff;" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label"
										style="font-family: 'Lato', sans-serif; font-size: 17px;;">Photo
									</label>
									<div class="col-sm-5">
										<input type="file" name="image" class="form-control"
											id="image" style="height: 40px;background-color: #fffff4;">
									</div>
								</div>

								<div style="margin-left: 195px;">
									<input type="button" value="Sign Up" class="btn btn-primary"
										id="userRegistrationBt"
										style="font-family: 'Lato', sans-serif; font-size: 17px;;" />
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset"
										value="Clear" class="btn btn-default"
										style="font-family: 'Lato', sans-serif; font-size: 17px;;" />
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
										href="${pageContext.request.contextPath}/action/show-all-consultants">
										<input type="button" value="Back" class="btn btn-danger"
										style="font-family: 'Lato', sans-serif; font-size: 17px;;" />
									</a>

								</div>

							</form:form>
						</div>
					</div>
					<hr />
				</div>

			</section>

		</div>

		<!-- content -->
		<!--    <hr style="color: blue"/> -->
		<!-- / footer -->
	</div>
	<!-- FOOTER -->
	<footer id="footer" class="footer">
		<%@include file="/sfooter.jsp"%>
	</footer>
	<!-- END / FOOTER -->
</body>

</html>