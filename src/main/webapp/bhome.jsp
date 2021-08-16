<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
      <%@include file="resources.jsp" %>
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
   	   <%@include file="mhome.jsp" %>
    <!-- END / HEADER -->

    <!-- HOME SLIDER -->
    <section class="slide" style="margin-bottom: 10px;">
        <div class="container">
            <div class="slide-cn" id="slide-home">
            
              <!-- SLIDE ITEM -->
                <div class="slide-item">
                    <div class="item-inner">
                        <div class="text">
                            <h4 style="color:#333;font-weight: bold;margin-left: 20px;">${companyName} welcomes you !</h4>
                            <a href="javascript:openRegistrationPopup();">
                                                       <p style="color:black;font-weight: bold;font-size: 18px;">
                            <img src="images/profilepic.png" style="height: 100px;"/>
                          		  Start Core Java Test
                            </p>
                              </a>
                        </div>

                        <div class="img">
                            <img src="images/homeslider/main_bnr1.jpg" alt="">
                        </div>
                    </div>

                </div>  
            	<!-- SLIDE ITEM -->
                <div class="slide-item">
                    <div class="item-inner">
                        <div class="text">
                            <h4 style="color:#333;font-weight: bold;">Learn more - Earn more</h4>
                           <a href="javascript:openRegistrationPopup();">
                            <p style="color:#333;font-weight: bold;font-size: 18px;">
                            <!-- <img src="images/icon/start.png" style="height: 100px;"/> -->
                              <img src="images/profilepic.png" style="height: 100px;"/>
                          		  Start Core Java Test
                            </p>
                              </a>
                        </div>

                        <div class="img">
                            <img src="images/homeslider/main_bnr2.jpg" alt="">
                        </div>

                    </div>  
                </div>  
                <!-- SLIDE ITEM -->  
            	
            
                
                <!-- SLIDE ITEM -->     

                <!-- SLIDE ITEM -->
                <div class="slide-item">
                    <div class="item-inner">
                        <div class="text">
                        <!--     <h4 style="color:#333;font-weight: bold;">Training - Training</h4> -->
                          <a href="javascript:openRegistrationPopup();">
                                                      <p  style="color:#333;font-weight: bold;font-size: 18px;">
                           <!--  <img src="images/icon/start.png" style="height: 100px;"/> -->
                              <img src="images/profilepic.png" style="height: 100px;"/>
                          		  Start Core Java Test
                            </p>
                              </a>
                        </div>

                        <div class="img">
                            <img src="images/homeslider/main_bnr3.jpg" alt="">
                        </div>

                    </div>  
                </div>  
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
                <h4 class="title-box text-uppercase">Popular Java Interview Questions </h4>
                <a href="categories.html" class="all-course mc-btn btn-style-1">View all</a>
                <div class="row">
                    <div class="feature-slider">
                        <div class="mc-item mc-item-1">
                            <div class="image-heading">
                                <img src="images/feature/img-1.jpg" alt="">
                            </div>
                            <div class="meta-categories"><a href="${companyStudyMat}/core-java-quetions">Core Java</a></div>
                            <div class="content-item">
                                <div class="image-author">
                                    <img src="images/avatar-1.png" alt="">
                                </div>
                                <h4><a href="course-intro.html">Covered all the most frequently asked questions in the interview.</a></h4>
                                <div class="name-author">
                                    By <a href="${companyStudyMat}/java/core-java-quetions">JavaHunk</a>
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
                                <img src="images/feature/img-1.jpg" alt="">
                            </div>
                            <div class="meta-categories"><a href="${companyStudyMat}/jsp-interview-questions">JSP/Servlet</a></div>
                            <div class="content-item">
                                <div class="image-author">
                                    <img src="images/avatar-1.png" alt="">
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
                                <img src="images/feature/img-1.jpg" alt="">
                            </div>
                            <div class="meta-categories"><a href="${companyStudyMat}/hibernate-interview-questions">Hibernate 4.x</a></div>
                            <div class="content-item">
                                <div class="image-author">
                                    <img src="images/avatar-1.png" alt="">
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
                                <img src="images/feature/img-1.jpg" alt="">
                            </div>
                            <div class="meta-categories"><a href="${companyStudyMat}/spring-interview-questions">Spring 4.x</a></div>
                            <div class="content-item">
                                <div class="image-author">
                                    <img src="images/avatar-1.png" alt="">
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
                        </div>
    
                        <div class="mc-item mc-item-1">
                            <div class="image-heading">
                                <img src="images/feature/img-1.jpg" alt="">
                            </div>
                            <div class="meta-categories"><a href="${companyStudyMat}/webservice-interview-questions">Web Services</a></div>
                            <div class="content-item">
                                <div class="image-author">
                                    <img src="images/avatar-1.png" alt="">
                                </div>
                                <h4><a href="course-intro.html">Covered all the most frequently asked questions in the interview.</a></h4>
                                <div class="name-author">
                                    <span>By <a href="${companyStudyMat}/webservice-interview-questions">JavaHunk</a></span>
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
                        </div>
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
            	<div class="col-sm-4">
                    <img src="http://www.JavaHunk.com/wp-content/uploads/hm_pic1.jpg" alt="IT Training" class="img-responsive center-block">
                    <h2>IT Training</h2>
                    <div  style="font-family:'Source Sans Pro',sans-serif;color:#000;font-size:15px;font-weight:400;line-height:27px">Java is the # 1 programming language in the World. JavaHunk Focuses and Specializes in job oriented Java J2EE /Android/IOS training and Placement. We are always looking for candidates who want...</div>
                    <a href="?page_id=11">Read more <img src="http://www.JavaHunk.com/wp-content/uploads//arrow.jpg" alt="Arrow"></a>
                </div>
            	<div class="col-sm-4">
                    <img src="http://www.JavaHunk.com/wp-content/uploads/hm_pic2.jpg" alt="Staffing" class="img-responsive center-block">
                    <h2>Staffing</h2>
                    <div  style="font-family:'Source Sans Pro',sans-serif;color:#000;font-size:15px;font-weight:400;line-height:27px">JavaHunk is able to work quickly and thoroughly to efficiently address human capital augmentation needs. Through resource optimization, we combine flexible employment options of contract,…</div>
                    <a href="?page_id=149">Read more <img src="http://www.JavaHunk.com/wp-content/uploads//arrow.jpg" alt="Arrow"></a>
                </div>
            	<div class="col-sm-4">
                    <img src="http://www.JavaHunk.com/wp-content/uploads/hm_pic3.jpg" alt="Benefits" class="img-responsive center-block">
                    <h2>Benefits</h2>
                    <div style="font-family:'Source Sans Pro',sans-serif;color:#000;font-size:15px;font-weight:400;line-height:27px">JavaHunk is one of the most respectable firms in IT Staffing and Development. And that is because, we make decisions after considering all the possible consequences and aspects of our decision.</div>
                    <a href="?page_id=50">Read more <img src="http://www.JavaHunk.com/wp-content/uploads//arrow.jpg" alt="Arrow"></a>
                </div>
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
     <%@include file="ffooter.jsp" %>
<%--        <%@include file="ffooter.jsp" %>
 --%> 		<%@include file="sfooter.jsp" %>
    </footer>
    <!-- END / FOOTER -->

</div>
<!-- END / PAGE WRAP -->

<!-- Load jQuery -->
 <%@include file="js.jsp" %>
 
 <script type="text/javascript">
 
 	
 		 $(document).ready(function(){
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
        
        <script type="text/javascript">
  						function callback() {
  									$('#CaptchaMessage').html("");
   									alert(("Button was clicked");
  						}
</script>
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
</body>
</html>