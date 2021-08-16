<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
      <%@include file="resources.jsp" %>
    <title>${companyName} - Home</title>
</head>
<body  style="background-image: url('images/bg/background.png')">

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
    <section class="slide" style="background-image: url(images/homeslider/bg.jpg)">
        <div class="container">
            <div class="slide-cn" id="slide-home">
            
              <!-- SLIDE ITEM -->
                <div class="slide-item">
                    <div class="item-inner">
                        <div class="text">
                            <h2>Java - Hunk</h2>
                            <a href="javascript:openRegistrationPopup();">
                            <img src="images/icon/start.png" style="height: 100px;"/>
                               <p style="color:black;font-weight: bold;font-size: 18px;">
                          		  Start Core Java Test
                            	</p>
                              </a>
                        </div>

                        <div class="img">
                            <img src="images/homeslider/img-thumb-3.png" alt="">
                        </div>
                    </div>

                </div>  
            	<!-- SLIDE ITEM -->
                <div class="slide-item">
                    <div class="item-inner">
                        <div class="text">
                            <h2>Learn more - Earn more</h2>
                           <a href="javascript:openRegistrationPopup();">
                            <p style="color:black;font-weight: bold;font-size: 18px;">
                            <img src="images/icon/start.png" style="height: 100px;"/>
                          		  Start Core Java Test
                            </p>
                              </a>
                        </div>

                        <div class="img">
                            <img src="images/homeslider/img-thumb-5.png" alt="">
                        </div>

                    </div>  
                </div>  
                <!-- SLIDE ITEM -->  
            	
            
                
                <!-- SLIDE ITEM -->     

                <!-- SLIDE ITEM -->
                <div class="slide-item">
                    <div class="item-inner">
                        <div class="text">
                            <h2>Engineering - Engineering</h2>
                          <a href="javascript:openRegistrationPopup();">
                                                      <p  style="color:black;font-weight: bold;font-size: 18px;">
                            <img src="images/icon/start.png" style="height: 100px;"/>
                          		  Start Core Java Test
                            </p>
                              </a>
                        </div>

                        <div class="img">
                            <img src="images/homeslider/img-thumb-4.png" alt="">
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
        <div class="awe-color bg-color-1"></div>
        <div class="after-slider-bg-2"></div>
        <div class="container">
    
            <div class="after-slider-content tb">
                <div class="inner tb-cell">
                    <h4>Test Result !</h4>
                     <form method="POST" action="${pageContext.request.contextPath}/action/test-result-summary">
                    <div class="course-keyword">
                        <input type="text" placeholder="Enter your email/consultant id" name="email" id="semail" required="required"/>
                    </div>
                        <input type="submit" value="     Go     " class="mc-btn btn-style-1" style="background-color: #10538c" >
                </form>
                </div>
                <div class="tb-cell text-right">
                    <div class="form-actions">
                        <input type="submit" value="Find Test" class="mc-btn btn-style-1">
                       <a href="${pageContext.request.contextPath}/action/oauth">
                        <input type="button" value="     Login     " class="mc-btn btn-style-1" ></a>
                    </div>
                </div>
            </div>
    
        </div>
    </section>
    <!-- END / AFTER SLIDER -->
    
    <!-- SECTION 1 -->

    <!-- BEFORE FOOTER -->
<%--     <section id="mc-section-1" class="mc-section-1 section">
        <div class="container">
            <div class="row">
                
                <div class="col-md-5">
                    <div class="mc-section-1-content-1"> 
                      <div class="row">
                       <h2 style="font-size:16px;color:black;font-weight: bold;">Consultant Online Test Flow :-</h2>
                         <br/>
                                <img src="${pageContext.request.contextPath}/images/flow/test-flow1.png"/>
    				 			
                    </div>
                    </div>
                </div>
    
                <div class="col-md-6 col-lg-offset-1">
                    <div class="row">
                      <h2 style="font-size:16px;color:black;font-weight: bold;">Create a new test flow for trainer :-</h2>
                         <br/>
                                <img src="${pageContext.request.contextPath}/images/flow/create-test-flow.png"/>
    				 			
                    </div>
                </div>
    
            </div>
        </div>
    </section> --%>
    <!-- END / SECTION 1 -->
    
    
    <!-- SECTION 2 -->
   <!--  <section id="mc-section-2" class="mc-section-2 section">
        <div class="awe-parallax bg-section1-demo"></div>
        <div class="overlay-color-1"></div>
        <div class="container">
            <div class="section-2-content">
                <div class="row">
                    
                    <div class="col-md-5">
                        <div class="ct">
                            <h2 class="big">Learning online is easier than ever before</h2>
                            <p class="mc-text">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                            <a href="#" class="mc-btn btn-style-3">See how it work</a>
                        </div>
                    </div>
    
                    <div class="col-md-7">
                        <div class="image">
                            <img src="images/image.png" alt="">
                        </div>
                    </div>
                    
                </div>
            </div>
        </div>
    </section> -->
    <!-- END / SECTION 2 -->
    
    
    <!-- SECTION 3 -->
    <section id="mc-section-3" class="mc-section-3 section" style="margin-top: 0px;">
        <div class="container">
            <!-- FEATURE -->
            <div class="feature-course">
                <h4 class="title-box text-uppercase">Test Result Summary </h4>
                <br/>
             <!--    <a href="categories.html" class="all-course mc-btn btn-style-1">View all</a> -->
                <table class="table table-bordered" style="margin-left: 10px;margin-right: 40px;">
    <thead>
      <tr>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Email</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>John</td>
        <td>Doe</td>
        <td>john@example.com</td>
      </tr>
      <tr>
        <td>Mary</td>
        <td>Moe</td>
        <td>mary@example.com</td>
      </tr>
      <tr>
        <td>July</td>
        <td>Dooley</td>
        <td>july@example.com</td>
      </tr>
    </tbody>
  </table>
                </div>
            <!-- END / FEATURE -->
        </div>
    </section>
    <!-- END / SECTION 3 -->
    
    <!-- BEFORE FOOTER -->
    <section id="before-footer" class="before-footer">
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
    </section>
    <!-- END / BEFORE FOOTER -->

    
    <!-- FOOTER -->
    <footer id="footer" class="footer">
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
								var contextPath="${pageContext.request.contextPath}";
								$.ajax({url:contextPath+"/action/add-guest-user", type: 'POST',data:$("#approveTrainerModelForm").serialize(),success:function(jsonData) {  //data= this.responseText
									//data is JavaScript object against JSON response coming fromm the server
										console.log(jsonData);
										if(jsonData.status=='success') {
											setTimeout(function() {
												 $("#approveTrainerModel").modal("show");
											  window.location.href = contextPath+"/successStatus.jsp?name="+username+"&email="+email;
											}, 3000);
										}else{
											 $("#ErrorMessage").html(jsonData.message);
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
<form  id="approveTrainerModelForm">
<div id="approveTrainerModel" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content" style="background-image: url('${pageContext.request.contextPath}/images/bg/backgrounds.jpg');">
      <div class="modal-header"  style="background-color: #37abf2;height: 35px; ">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      <img src="${pageContext.request.contextPath}/images/icon/user-icon.png" width="30px;"/>
            <p style="display: inline;margin-left: 20px;">   <span style="font-weight: bold;" id="name"></span></p>
      </div>
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