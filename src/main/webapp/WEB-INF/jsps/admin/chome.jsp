<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
      <%@include file="/resources.jsp" %>
    <title>${companyName} - Home</title>
<script src="https://www.google.com/recaptcha/api.js"></script>
</head>
<body>
<!-- PAGE WRAP -->
<div id="page-wrap">

    <!-- PRELOADER -->
    <div id="preloader">
        <div class="pre-icon">
            <div class="pre-item pre-item-1"></div>
            <div class="pre-item pre-item-2"></div>
            <div class="pre-item pre-item-3"></div>
            <div class="pre-item pre-item-4"></div>
        </div>
    </div>
    <!-- END / PRELOADER -->

    <!-- HEADER -->
   	    
   	    <c:choose>
         <c:when test = "${sessionScope.user_session_data.role=='admin'}">
            <%@include file="aheader.jsp" %>
         </c:when>
         
         <c:otherwise>
           <%@include file="/mhome.jsp" %>
         </c:otherwise>
       </c:choose>
    <!-- END / HEADER -->

    <!-- HOME SLIDER -->
    <section class="slide" style="margin-bottom: 10px;">
        <div class="container">
            <div class="slide-cn" id="slide-home">
              <!-- SLIDE ITEM -->
               <c:forEach var="item" items="${sliderItems}">
                <div class="slide-item">
                    <div class="item-inner">
                        <div class="text">
                          <k:if test="${sessionScope.user_session_data.role=='admin'}">	
                             <a href="javascript:openSliderPopup(${item.lpid});"><img src="${pageContext.request.contextPath}/images/icon/edit.png" style="margin-left: 20px;margin-top: 0px;"/></a>
                           </k:if> 
                            <h4 style="color:#333;font-weight: bold;margin-left: 20px;">${item.mainHeading}</h4>
                            <a href="javascript:openRegistrationPopup();">
                                                       <p style="color:black;font-weight: bold;font-size: 18px;">
                            <img src="${pageContext.request.contextPath}/action/dimage?imagePath=${item.icon}" style="height: 100px;"/>
                          		  ${item.subHeading}
                            </p>
                              </a>
                        </div>

                        <div class="img">
                            <img src="${pageContext.request.contextPath}/action/dimage?imagePath=${item.sliderImage}" alt="">
                        </div>
                    </div>
                </div>  
                </c:forEach>
            	<!-- SLIDE ITEM -->
              <%--   <div class="slide-item">
                    <div class="item-inner">
                        <div class="text">
                           <a href="javascript:openSliderPopup();"> <img src="${pageContext.request.contextPath}/images/icon/edit.png" style="margin-left: 20px;margin-top: 0px;"/></a>
                            <h4 style="color:#333;font-weight: bold;">Learn more - Earn more</h4>
                           <a href="javascript:openRegistrationPopup();">
                            <p style="color:#333;font-weight: bold;font-size: 18px;">
                            <!-- <img src="${pageContext.request.contextPath}/images/icon/start.png" style="height: 100px;"/> -->
                              <img src="${pageContext.request.contextPath}/images/profilepic.png" style="height: 100px;"/>
                          		  Start Core Java Test
                            </p>
                              </a>
                        </div>

                        <div class="img">
                            <img src="${pageContext.request.contextPath}/images/homeslider/main_bnr2.jpg" alt="">
                        </div>

                    </div>  
                </div>   --%>
                <!-- SLIDE ITEM -->  
            	
            
                
                <!-- SLIDE ITEM -->     

                <!-- SLIDE ITEM -->
            <%--     <div class="slide-item">
                    <div class="item-inner">
                        <div class="text">
                          <a href="javascript:openSliderPopup();">  <img src="${pageContext.request.contextPath}/images/icon/edit.png" style="margin-left: 20px;margin-top: 0px;"/></a>
                       	 <h4 style="color:#333;font-weight: bold;">Training - Training</h4> 
                          <a href="javascript:openRegistrationPopup();">
                                                      <p  style="color:#333;font-weight: bold;font-size: 18px;">
                           <!--  <img src="${pageContext.request.contextPath}/images/icon/start.png" style="height: 100px;"/> -->
                              <img src="${pageContext.request.contextPath}/images/profilepic.png" style="height: 100px;"/>
                          		  Start Core Java Test
                            </p>
                              </a>
                                 
                        </div>

                        <div class="img">
                            <img src="${pageContext.request.contextPath}/images/homeslider/main_bnr3.jpg" alt="">
                        </div>
   
                    </div>  
                </div>   --%>
                <!-- SLIDE ITEM -->  
            </div>
        </div>
    </section>
    <!-- END / HOME SLIDER -->
    <!-- AFTER SLIDER -->
  <section id="after-slider" class="after-slider section">
        <div class="container" style="background-color: #eeeeee;width: 1170px;">
            <div class="after-slider-content tb">
                    <h4 style="font-family:'Neuton',serif; font-weight:200;font-size:18px; color:#000; letter-spacing:2px; text-transform:uppercase;">Test Result !</h4>
                     <form method="POST" action="${pageContext.request.contextPath}/action/guest-tech-test-history">
			                    <div class="course-keyword">
			                        <input type="text" placeholder="Enter your email/consultant id" name="email" id="semail" required="required"/>
			                    </div>
			                        <input type="submit" value="     Go     " class="mc-btn btn-style-1" style="background-color: #10538c" >
                </form>
            </div>
    
        </div>
    </section> 
    <!-- END / AFTER SLIDER -->
    
    <!-- SECTION 3 -->
    <section id="mc-section-3" class="mc-section-3 section" style="margin-top: 0px;">
        <div class="container">
            <!-- FEATURE -->
            <div class="feature-course">
                <h4 class="title-box text-uppercase">Popular Java Interview Questions</h4>
                <a href="categories.html" class="all-course mc-btn btn-style-1">View all</a>
                <div class="row">
                    <div class="feature-slider">
                      <c:forEach var="item" items="${popularJavaInterviewVOs}">
                        <div class="mc-item mc-item-1">
                            <div class="image-heading">
                                <img src="${pageContext.request.contextPath}/action/dimage?imagePath=${item.image}" alt="">
                            </div>
                            <div class="meta-categories">
                            <k:if test="${sessionScope.user_session_data.role=='admin'}">	
                                <a href="javascript:openPopularInterviewPopup(${item.pjiid});"><img src="${pageContext.request.contextPath}/images/icon/edit.png" style="height: 30px;"/></a> 
                            </k:if>
                            <a href="${item.url}">${item.technology}</a>
                            </div>
                            
                            <div class="content-item">
                                <div class="image-author">
                                    <img src="${pageContext.request.contextPath}/action/dimage?imagePath=${item.icon}" alt="">
                                </div>
                                <h4><a href="course-intro.html">${item.text}</a></h4>
                                <div class="name-author">
                                    By <a href="${item.url}">${item.author}</a>
                                </div>
                            </div>
                             <div class="ft-item">
                                <div class="rating">
                                    <a href="#" class="active"></a>
                                    <a href="#" class="active"></a>
                                    <a href="#" class="active"></a>
                                    <a href="#"></a>
                                    <a href="#"></a>
                                </div>
                                <!-- <div class="view-info">
                                    <i class="icon md-users"></i>
                                    2568
                                </div>
                                <div class="comment-info">
                                    <i class="icon md-comment"></i>
                                    25
                                </div>
                                <div class="price">
                                    $190
                                    <span class="price-old">$134</span>
                                </div> -->
                            </div> 
                        </div>
                        </c:forEach>
                       <%--  <div class="mc-item mc-item-1">
                            <div class="image-heading">
                                <img src="${pageContext.request.contextPath}/images/feature/img-1.jpg" alt="">
                            </div>
                            <div class="meta-categories">
                                 <img src="${pageContext.request.contextPath}/images/icon/edit.png" style="height: 30px;"/>
                            <a href="${companyStudyMat}/jsp-interview-questions">JSP/Servlet</a></div>
                            <div class="content-item">
                                <div class="image-author">
                                    <img src="${pageContext.request.contextPath}/images/avatar-1.png" alt="">
                                </div>
                                <h4><a href="course-intro.html">Covered all the most frequently asked questions in the interview.</a></h4>
                                <div class="name-author">
                                    <span>By <a href="${companyStudyMat}/jsp-interview-questions">JavaHunk</a></span>
                                </div>
                            </div>
                            <div class="ft-item">
                             <div class="rating">
                                    <a href="#" class="active"></a>
                                    <a href="#" class="active"></a>
                                    <a href="#" class="active"></a>
                                    <a href="#"></a>
                                    <a href="#"></a>
                                </div>
                               <!--  
                                <div class="view-info">
                                    <i class="icon md-users"></i>
                                    2568
                                </div>
                                <div class="comment-info">
                                    <i class="icon md-comment"></i>
                                    25
                                </div>
                                <div class="price">
                                    Free
                                </div> -->
                            </div>
                        </div>
                        <div class="mc-item mc-item-1">
                            <div class="image-heading">
                                <img src="${pageContext.request.contextPath}/images/feature/img-1.jpg" alt="">
                            </div>
                            <div class="meta-categories">
                                 <img src="${pageContext.request.contextPath}/images/icon/edit.png" style="height: 30px;"/>
                            	<a href="${companyStudyMat}/hibernate-interview-questions">Hibernate 4.x</a>
                            
                            </div>
                            <div class="content-item">
                                <div class="image-author">
                                    <img src="${pageContext.request.contextPath}/images/avatar-1.png" alt="">
                                </div>
                                <h4><a href="course-intro.html">Covered all the most frequently asked questions in the interview.</a></h4>
                                <div class="name-author">
                                    <span>By <a href="${companyStudyMat}/hibernate-interview-questions">JavaHunk</a></span>
                                </div>
                            </div>
                            <div class="ft-item">
                                <div class="rating">
                                    <a href="#" class="active"></a>
                                    <a href="#" class="active"></a>
                                    <a href="#" class="active"></a>
                                    <a href="#"></a>
                                    <a href="#"></a>
                                </div>
                                <!-- <div class="view-info">
                                    <i class="icon md-users"></i>
                                    2568
                                </div>
                                <div class="comment-info">
                                    <i class="icon md-comment"></i>
                                    25
                                </div>
                                <div class="price">
                                    $190
                                    <span class="price-old">$134</span>
                                </div> -->
                            </div>
                        </div>
    
                        <div class="mc-item mc-item-1">
                            <div class="image-heading">
                                <img src="${pageContext.request.contextPath}/images/feature/img-1.jpg" alt="">
                            </div>
                            <div class="meta-categories">
                             <img src="${pageContext.request.contextPath}/images/icon/edit.png" style="height: 30px;"/>
                            <a href="${companyStudyMat}/spring-interview-questions">Spring 4.x</a></div>
                            <div class="content-item">
                                <div class="image-author">
                                    <img src="${pageContext.request.contextPath}/images/avatar-1.png" alt="">
                                </div>
                                <h4><a href="course-intro.html">Covered all the most frequently asked questions in the interview.</a></h4>
                                <div class="name-author">
                                    <span>By <a href="${companyStudyMat}/spring-interview-questions">JavaHunk</a></span>
                                </div>
                            </div>
                            <div class="ft-item">
                                <div class="rating">
                                    <a href="#" class="active"></a>
                                    <a href="#" class="active"></a>
                                    <a href="#" class="active"></a>
                                    <a href="#"></a>
                                    <a href="#"></a>
                                </div>
                              <!--   <div class="view-info">
                                    <i class="icon md-users"></i>
                                    2568
                                </div>
                                <div class="comment-info">
                                    <i class="icon md-comment"></i>
                                    25
                                </div>
                                <div class="price">
                                    $190
                                </div> -->
                            </div>
                        </div> --%>
    
                  
                    </div>
                </div>
            </div>
            <!-- END / FEATURE -->
        </div>
    </section>
    <!-- END / SECTION 3 -->
    
    
   <section id="mc-section-3" class="mc-section-3 section">
        <div class="container">
        	<div class="row category">
        	     <c:forEach var="item" items="${companyBusinessVOs}">
            	<div class="col-sm-4">
                    <img src="${pageContext.request.contextPath}/action/dimage?imagePath=${item.image}" alt="${item.mainHeading}" class="img-responsive center-block">
                    <h2>${item.mainHeading} </h2>
                    <k:if test="${sessionScope.user_session_data.role=='admin'}">	
                    <a href="javascript:openCompanyBusiness(${item.cbid});"><img src="${pageContext.request.contextPath}/images/icon/edit.png" style="height: 30px;"/></a>
                    </k:if>        	
                    <div  style="font-family:'Source Sans Pro',sans-serif;color:#000;font-size:15px;font-weight:400;line-height:27px">${item.text}</div>
                    <a href="${item.url}">Read more <img src="http://www.JavaHunk.com/wp-content/uploads//arrow.jpg" alt="Arrow"></a>
                </div>
                </c:forEach>
            <%-- 	<div class="col-sm-4">
                    <img src="http://www.JavaHunk.com/wp-content/uploads/hm_pic2.jpg" alt="Staffing" class="img-responsive center-block">
                    <h2>Staffing <img src="${pageContext.request.contextPath}/images/icon/edit.png" style="height: 30px;"/>
                            	</h2>
                    <div  style="font-family:'Source Sans Pro',sans-serif;color:#000;font-size:15px;font-weight:400;line-height:27px">JavaHunk is able to work quickly and thoroughly to efficiently address human capital augmentation needs. Through resource optimization, we combine flexible employment options of contract,…</div>
                    <a href="?page_id=149">Read more <img src="http://www.JavaHunk.com/wp-content/uploads//arrow.jpg" alt="Arrow"></a>
                </div>
            	<div class="col-sm-4">
                    <img src="http://www.JavaHunk.com/wp-content/uploads/hm_pic3.jpg" alt="Benefits" class="img-responsive center-block">
                    <h2>Benefits <img src="${pageContext.request.contextPath}/images/icon/edit.png" style="height: 30px;"/>
                            	</h2>
                    <div style="font-family:'Source Sans Pro',sans-serif;color:#000;font-size:15px;font-weight:400;line-height:27px">JavaHunk  is one of the most respectable firms in IT Staffing and Development. And that is because, we make decisions after considering all the possible consequences and aspects of our decision.</div>
                    <a href="?page_id=50">Read more <img src="http://www.JavaHunk.com/wp-content/uploads//arrow.jpg" alt="Arrow"></a>
                </div> --%>
            </div>
        </div>
    </section>
    
    
    
    <!-- BEFORE FOOTER -->
<%--     <section id="before-footer" class="before-footer">
        <div class="container">
            <div class="row">
                
                <div class="col-lg-8">
                    <div class="mc-count-item">
                         <h4>Core Java</h4>
                         <p><span class="countup">40 hrs</span></p>
                     </div>
                     <div class="mc-count-item">
                         <h4>Spring 4.x</h4>
                         <p><span class="countup">36 Hrs</span></p>
                     </div>
                     <div class="mc-count-item">
                         <h4>Web Service</h4>
                         <p><span class="countup">20 Hrs</span></p>
                     </div>
                     <div class="mc-count-item">
                         <h4>Hibernate 4.x</h4>
                         <p> <span class="countup">14 Hrs</span></p>
                     </div>
                </div>
    
                <div class="col-lg-4">
                    <div class="before-footer-link">
                        <a href="${pageContext.request.contextPath}/register.jsp" class="mc-btn btn-style-2">Become a member</a>
                        <a href="${pageContext.request.contextPath}/register.jsp" class="mc-btn btn-style-1">Become a teacher</a>
                    </div>
                </div>
            </div>
        </div>
    </section> --%>
    <!-- END / BEFORE FOOTER -->

    
    <!-- FOOTER -->
    <footer id="footer" class="footer" style="background-color: #00192e">
     <%@include file="/ffooter.jsp" %>
<%--        <%@include file="ffooter.jsp" %>
 --%> 		<%@include file="/sfooter.jsp" %>
    </footer>
    <!-- END / FOOTER -->

</div>
<!-- END / PAGE WRAP -->

<!-- Load jQuery -->
 <%@include file="/js.jsp" %>
 
 <script type="text/javascript">
 		 function readURL(input,tid) {
	       if (input.files && input.files[0]) {
		        var reader = new FileReader();
		        reader.onload = function (e) {
		            $('#'+tid).attr('src', e.target.result);
		        }
		        reader.readAsDataURL(input.files[0]);
		   }
		 } 
 		 
 		 /**
 		  * ##############################
 		 */
 		 $(document).ready(function(){
 			//Image chage for main slider
        	$("#picon").change(function(){
	 			readURL(this,'ticon');
			});	
        	
 	 		$("#psliderimage").change(function(){
 	 			readURL(this,'tsliderimage');
 			});
 	 		
 	 		//image change for popular questions
 	 		$("#pimage").change(function(){
 	 			readURL(this,'timage');
 			});
 	 		
 	 		$("#piicon").change(function(){
 	 			readURL(this,'tticon');
 			});
 	 		
 	 		//image change for popular questions
 	 		$("#pcbtimage").change(function(){
 	 			readURL(this,'cbtimage');
 			});
 	 		
 			 
 			 $("#updatecontents").click(function(){
 				$("#sliderModelForm").submit();
 			});
 			
 			$("#updateCompanyBusinessItem").click(function(){
 				$("#companyBusinessModelForm").submit();
 			});
 			
 			$("#updatePopularQuestionItem").click(function(){
 				$("#popularJavaQuestionModelForm").submit();
 			});
 			
 			
 			$("input[type='text']").keyup(function(){
 	 			$("#ErrorMessage").html("");
 	 			$("#CaptchaMessage").html("");
 	 		});	
			 		$("#generateTestLink").click(function(){
			 			
							var username=$("#username").val();
							var email=$("#email").val();
							var mobile=$("#mobile").val();
							if(username.trim().length==0){
								 $("#ErrorMessage").html("Username cannot be blank!");
								 $("#username").focus();
								return;
							}else 	if(email.trim().length==0){
								 $("#ErrorMessage").html("Email cannot be blank!");
								 $("#email").focus();
								return;
							}else 	if(mobile.trim().length==0){
								 $("#ErrorMessage").html("Mobile cannot be blank!");
								 $("#mobile").focus();
								return;
							}
							else{
								 $('.bloading').loading({ overlay: true,base: 0.6 });
							 	$('.bloading').loading('show');
								var contextPath="${pageContext.request.contextPath}";
								$.ajax({url:contextPath+"/action/add-guest-user", type: 'POST',data:$("#approveTrainerModelForm").serialize(),success:function(jsonData) {  //data= this.responseText
									//data is JavaScript object against JSON response coming fromm the server
										console.log(jsonData);
										$('.bloading').loading('hide');
										if(jsonData.status=='success') {
											setTimeout(function() {
												 $("#approveTrainerModel").modal("show");
											  window.location.href = contextPath+"/successStatus.jsp?name="+username+"&email="+email;
											}, 10);
										}else{
											 $("#ErrorMessage").html(jsonData.message);
											 $("#CaptchaMessage").html(jsonData.cmessage);
										}
								}
								});	 //end of the ajax			
							}
					}); //end of click
 		 });	//end of ready function
 
 		
 	
 		 
 		function openSliderPopup(lpid){
			 console.log("lpid  = "+lpid);
				var context="${pageContext.request.contextPath}";  
	 		/* 	fetch(context+"/action/find-main-slider?lpid="+lpid)
	 			.then(res => res.json())
	 			.then(json => console.log(json)); */
	 			 $.getJSON(context+"/action/find-main-slider?lpid="+lpid,function(jsonResponse) {
          		  			 console.log(jsonResponse);
          		  			$("#mainheading").val(jsonResponse.mainHeading);
          		  			$("#subheading").val(jsonResponse.subHeading);
          		  			var icontext="${pageContext.request.contextPath}/action/dimage?imagePath";
          		  		    $("#tsliderimage").attr("src",icontext+"="+jsonResponse.sliderImage);
          		  	        $("#ticon").attr("src",icontext+"="+jsonResponse.icon);
          		  	    	$("#icon").val(jsonResponse.icon);
          		      		$("#sliderimage").val(jsonResponse.sliderImage);
          			  		$("#lpid").val(jsonResponse.lpid);
          		 });
 				 $("#sliderModel").modal("show");
		}
 		 
 		function openPopularInterviewPopup(pjiid){
			   console.log("pjiid  = "+pjiid);
			  var context="${pageContext.request.contextPath}";  
	 		/* 	fetch(context+"/action/find-main-slider?lpid="+lpid)
	 			.then(res => res.json())
	 			.then(json => console.log(json)); */
	 			 $.getJSON(context+"/action/ffind-popular-interview?pjiid="+pjiid,function(jsonResponse) {
         		  			 console.log(jsonResponse);
         		  			$("#technology").val(jsonResponse.technology);
         		  			$("#author").val(jsonResponse.author);
         		  			$("#piurl").val(jsonResponse.url);
         		  			var icontext="${pageContext.request.contextPath}/action/dimage?imagePath";
         		  		    $("#timage").attr("src",icontext+"="+jsonResponse.image);
         		  	        $("#tticon").attr("src",icontext+"="+jsonResponse.icon);
         		  	    	$("#iicon").val(jsonResponse.icon);
         		      		$("#iimage").val(jsonResponse.image);
         			  		$("#pjiid").val(jsonResponse.pjiid);
         			  		console.log(jsonResponse.text);
         			  		$("#texData").html(jsonResponse.text);
         		 });
				 $("#popularJavaQuestionModel").modal("show");
		}
 		
 		function openCompanyBusiness(cbid){
			   console.log("cbid  = "+cbid);
			  var context="${pageContext.request.contextPath}";  
	 		/* 	fetch(context+"/action/find-main-slider?lpid="+lpid)
	 			.then(res => res.json())
	 			.then(json => console.log(json)); */
	 			 $.getJSON(context+"/action/find-company-business-info?cbid="+cbid,function(jsonResponse) {
      		  			 console.log(jsonResponse);
      		  			$("#cbmainHeading").val(jsonResponse.mainHeading);
      		  			$("#cburl").val(jsonResponse.url);
      		  			var icontext="${pageContext.request.contextPath}/action/dimage?imagePath";
      		  		    $("#cbtimage").attr("src",icontext+"="+jsonResponse.image);
      		      		$("#cbimage").val(jsonResponse.image);
      			  		$("#cbid").val(jsonResponse.cbid);
      			  		console.log(jsonResponse.text);
      			  		$("#cbtext").html(jsonResponse.text);
      		 });
				 $("#companyBusinessModel").modal("show");
		}
 		
 		
 		
 		 
 		function openRegistrationPopup(){
 			 $("#approveTrainerModel").modal("show");
 		}
 
 </script>
 
 <!-- Modal -->
<form  id="approveTrainerModelForm"  >
<div id="approveTrainerModel" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content" style="background-image: url('${pageContext.request.contextPath}/images/bg/backgrounds.jpg');">
      <div class="modal-header"  style="background-color: #37abf2;height: 35px; ">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      <img src="${pageContext.request.contextPath}/images/icon/user-icon.png" width="30px;"/>
            <p style="display: inline;margin-left: 20px;">   <span style="font-weight: bold;" id="name"></span></p>
      </div>
      <div class="bloading">
      <div class="modal-body">
       <span style="color:red;font-size: 15px;" id="ErrorMessage"></span>
      <div class="form-group">
      	 Name   :   <span style="font-weight: bold;color:red;">*</span>
        <input type="text" class="form-control" id="username" name="name"/>
        </div>
        
        <div class="form-group">
      	<label id="stream">Occupation:</label>
  			<select name="occupation" class="form-control" id="occupation">
  					<option>Software Developer</option>	
  					<option>Student</option>	
  					<option>Others</option>	
  			</select>
        </div>
        
          <div class="form-group">
       Email   :   <span style="font-weight: bold;color:red;">*</span>
        <input type="text" class="form-control" id="email" name="email"/>
        </div>
      
      
          <div class="form-group">
       Mobile   :   <span style="font-weight: bold;color:red;">*</span>
        <input type="text" class="form-control" id="mobile" name="mobile"/>
        </div>
         
         <div class="form-group">
      	<label id="stream">Gender:</label>
  			<select name="gender" class="form-control" id="gender">
  					<option>Male</option>	
  					<option>Female</option>	
  			</select>
        </div>
        
       <div id="captchaid" class="g-recaptcha" data-sitekey="6Lc7wk8UAAAAAPK4Gamn0Orn3vu74WrtsdwPmxfO"  data-callback="callback">
			</div>
			  <span style="color:blue;font-size: 15px;" id="CaptchaMessage"></span>
      </div>
      </div>
      <div class="modal-footer">
        	<input type="button" value="Close"  class="mc-btn btn-style-1" id="close"  data-dismiss="modal"/>
        	<input type="button"  value="Generate Test Link" class="mc-btn btn-style-1" id="generateTestLink"/>
      </div>
    </div>

  </div>
</div>
</form>


<!-- Modal -->
<form  id="sliderModelForm" action="${pageContext.request.contextPath}/action/edit-landing-page"  method="post" enctype="multipart/form-data">
<div id="sliderModel" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content" style="background-image: url('${pageContext.request.contextPath}/images/bg/backgrounds.jpg');">
      <div class="modal-header"  style="background-color: #37abf2;height: 35px; ">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      <img src="${pageContext.request.contextPath}/images/icon/user-icon.png" width="30px;"/>
            <p style="display: inline;margin-left: 20px;">   <span style="font-weight: bold;" id="name"></span></p>
      </div>
      <div class="bloading">
      <div class="modal-body">
       <span style="color:red;font-size: 15px;" id="ErrorMessage"></span>
       
       
       	<input type="hidden" name="lpid" id="lpid"/>
      <div class="form-group">
      	 Main Heading   :   <span style="font-weight: bold;color:red;">*</span>
        <input type="text" class="form-control" id="mainheading" name="mainHeading"/>
        </div>
        
          <div class="form-group">
       Sub Heading   :   <span style="font-weight: bold;color:red;">*</span>
        <input type="text" class="form-control" id="subheading" name="subHeading"/>
        </div>
      
      
          <div class="form-group">
       Icon   :   <span style="font-weight: bold;color:red;">*</span>
         <input type="hidden" name="icon" id="icon"/>
        <input type="file" class="form-control" id="picon" name="picon"/>
         <img src="" id="ticon" style="height: 30px;">
        </div>
         
           <div class="form-group">
           
       Slider Image   :   <span style="font-weight: bold;color:red;">*</span>
       <input type="hidden" name="sliderImage" id="sliderimage">
        <input type="file" class="form-control" id="psliderimage" name="psliderImage"/>
            <img src="" id="tsliderimage" style="height: 60px;">
        </div>
      </div>
      </div>
      <div class="modal-footer">
        	<input type="button" value="Close"  class="mc-btn btn-style-1" id="close"  data-dismiss="modal"/>
        	<input type="button"  value="Update Contents" class="mc-btn btn-style-1" id="updatecontents"/>
      </div>
    </div>

  </div>
</div>
</form>



<!-- Modal -->
<form  id="popularJavaQuestionModelForm" action="${pageContext.request.contextPath}/action/edit-pop-interviewq"  method="post" enctype="multipart/form-data">
<div id="popularJavaQuestionModel" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content" style="background-image: url('${pageContext.request.contextPath}/images/bg/backgrounds.jpg');">
      <div class="modal-header"  style="background-color: #37abf2;height: 35px; ">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      <img src="${pageContext.request.contextPath}/images/icon/user-icon.png" width="30px;"/>
            <p style="display: inline;margin-left: 20px;">   <span style="font-weight: bold;" id="name"></span></p>
      </div>
      <div class="bloading">
      <div class="modal-body">
       <span style="color:red;font-size: 15px;" id="PopularJavaQuestionErrorMessage"></span>
       
      <div class="form-group">
      	 Technology   :   <span style="font-weight: bold;color:red;">*</span>
        <input type="text" class="form-control" id="technology" name="technology"/>
        </div>
        
          	<input type="hidden" name="pjiid" id="pjiid"/>
      <div class="form-group">
      	 Author   :   <span style="font-weight: bold;color:red;">*</span>
        <input type="text" class="form-control" id="author" name="author"/>
        </div>
        
          <div class="form-group">
        Image   :   <span style="font-weight: bold;color:red;">*</span>
       <input type="hidden" name="image" id="iimage">
        <input type="file" class="form-control" id="pimage" name="pimage"/>
            <img src="" id="timage" style="height: 60px;">
        </div>
        
          <div class="form-group">
       Icon   :   <span style="font-weight: bold;color:red;">*</span>
         <input type="hidden" name="icon" id="iicon"/>
        <input type="file" class="form-control" id="piicon" name="picon"/>
         <img src="" id="tticon" style="height: 30px;">
        </div>
        
         <div class="form-group">
       Url   :   <span style="font-weight: bold;color:red;">*</span>
        <input type="text" class="form-control" id="piurl" name="url"/>
        </div>
         
      <div class="form-group">
      	 Text   :   <span style="font-weight: bold;color:red;">*</span>
        <textarea  class="form-control" id="texData" name="text">
        </textarea>
        </div>
         
      </div>
      </div>
      <div class="modal-footer">
        	<input type="button" value="Close"  class="mc-btn btn-style-1" id="close"  data-dismiss="modal"/>
        	<input type="button"  value="Update Contents" class="mc-btn btn-style-1" id="updatePopularQuestionItem"/>
      </div>
    </div>

  </div>
</div>
</form>


<!-- Modal -->
<form  id="companyBusinessModelForm" action="${pageContext.request.contextPath}/action/edit-company-business-info"  method="post" enctype="multipart/form-data">
<div id="companyBusinessModel" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content" style="background-image: url('${pageContext.request.contextPath}/images/bg/backgrounds.jpg');">
      <div class="modal-header"  style="background-color: #37abf2;height: 35px; ">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      <img src="${pageContext.request.contextPath}/images/icon/user-icon.png" width="30px;"/>
            <p style="display: inline;margin-left: 20px;">   <span style="font-weight: bold;" id="name"></span></p>
      </div>
      <div class="bloading">
      <div class="modal-body">
       <span style="color:red;font-size: 15px;" id="CompanyBusinessErrorMessage"></span>
       
       
       	<input type="hidden" name="cbid" id="cbid"/>
      <div class="form-group">
      	 Title   :   <span style="font-weight: bold;color:red;">*</span>
        <input type="text" class="form-control" id="cbmainHeading" name="mainHeading"/>
        </div>
          	
      <div class="form-group">
      	 Read More   :   <span style="font-weight: bold;color:red;">*</span>
        <input type="text" class="form-control" id="cburl" name="url"/>
        </div>
        
          <div class="form-group">
        Image   :   <span style="font-weight: bold;color:red;">*</span>
       <input type="hidden" name="image" id="cbimage">
        <input type="file" class="form-control" id="pcbtimage"  name="pimage"/>
            <img src="" id="cbtimage" style="height: 80px;">
        </div>
         
      <div class="form-group">
      	 Text   :   <span style="font-weight: bold;color:red;">*</span>
        <textarea class="form-control" id="cbtext" name="text" rows="3"></textarea>
        </div>
         
      </div>
      </div>
      <div class="modal-footer">
        	<input type="button" value="Close"  class="mc-btn btn-style-1" id="close"  data-dismiss="modal"/>
        	<input type="button"  value="Update Contents" class="mc-btn btn-style-1" id="updateCompanyBusinessItem"/>
      </div>
    </div>

  </div>
</div>
</form>
</body>
</html>