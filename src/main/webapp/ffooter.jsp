  <div class="first-footer" style="background-color: #00192e">
            <div class="container">
                <div class="row">
                    
                    <div class="col-md-3 text-uppercase">
                        <div class="widget megacourse">
                      		<h3 style="font-family:'Neuton',serif; font-weight:200;font-size:18px; line-height:18px; color:#0087fe; letter-spacing:2px; margin:0 0 20px; text-transform:uppercase;">get in touch with us</h3>
                    <div style="font-size: 13px;"><span class="text-info">Phone</span><span style="color:#a5a5a5;"> +919873003702</span><br>
                    <span class="text-info">Fax</span> <span style="color:#a5a5a5;">+919873003702</span><br>
                    <span class="text-info">Email</span><span style="color:#a5a5a5;margin-left: 10px;">javahunk2020@gmail.com</span></div>
                     
                     <br/><br/>
                	<h3 style="font-family:'Neuton',serif; font-weight:200;font-size:18px; line-height:18px; color:#0087fe; letter-spacing:2px; margin:0 0 20px; text-transform:uppercase;">connect with us</h3>
                    <ul class="list-inline">
                    	<li><a href="#" class="fa fa-twitter"></a></li>
                    	<li><a href="#" class="fa fa-facebook"></a></li>
                    	<li><a href="#" class="fa fa-google-plus"></a></li>
                    	<li><a href="#" class="fa fa-youtube"></a></li>
                    	<li><a href="#" class="fa fa-instagram"></a></li>
                    </ul>
                      
                        </div>
                        
                        
                    </div>

                    <div class="col-md-3">
                        <div class="widget widget_latest_new">
                            <h3 style="font-family:'Neuton',serif; font-weight:200;font-size:18px; line-height:18px; color:#0087fe; letter-spacing:2px; margin:0 0 20px; text-transform:uppercase;">Latest Articles&nbsp;...</h3>
                            <ul>
                                <li>
                                    <a href="#">
                                        <div class="image-thumb">
                                            <img src="${pageContext.request.contextPath}/images/icon/java8.png" alt="">
                                        </div>
                                        <span>What is new features in java8?</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <div class="image-thumb">
                                            <img src="${pageContext.request.contextPath}/images/icon/java8.png" alt="">
                                        </div>
                                        <span>How String works in java8?</span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>

                    <div class="col-md-2">
                        <div class="widget quick_link">
                            <h3 style="font-family:'Neuton',serif; font-weight:200;font-size:18px; line-height:18px; color:#0087fe; letter-spacing:2px; margin:0 0 20px; text-transform:uppercase;">Quick Links&nbsp;...</h3>
                            <ul class="list-style-block">
                                <li><a href="#">About us</a></li>
                                <li><a href="#">Terms of use</a></li>
                                <li><a href="#">FAQ</a></li>
                                <li><a href="${pageContext.request.contextPath}/register.jsp">Register</a></li>
                                <li><a href="${pageContext.request.contextPath}/action/oauth">Login</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="widget news_letter">
                            <div class="awe-static bg-news_letter"></div>
                            <div class="overlay-color-3"></div>
                            <div class="inner">
                                <div class="letter-heading">
                                    <h3 class="md">News letter</h3>
                                    <p>Please register with us to get notification about new articles etc!</p>
                                    <span id="eemessage" style="color:white;">
                                    </span>
                                </div>
                                <div class="letter">
                                    <form>
                                        <input class="input-text" type="text" name="nemail" id="nemail" onkeyup="clearText();">
                                        <span class="no-spam">* No spam guaranteed</span>
                                        <input type="button" value="Submit Now" class="mc-btn btn-style-2" onclick="submitNow();">
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <script>
        		function clearText(){
        			 $("#eemessage").html("");
        		}
        
        		function submitNow(){
        			var nemail=$("#nemail").val();		
        			if(nemail.length==0){
        				 $("#eemessage").html("Sorry , email id cannot be blank!");
        				 $("#nemail").focus();
        				 return;
        			}
        			 var promise=fetch("${pageContext.request.contextPath}/action/register-news-letter?email="+nemail); 
        			 promise.then(response=>{
        				 var json=response.json();
        				 console.log(json);
        				 return json;
        				 //return JSON.parse(json); 	 			
        			 }).then(data=>{
        				 console.log(data);
        				 $("#eemessage").html(data.message);
        			 });
        			 console.log(")#(#(# ))nemail = "+nemail); 
        		}
        
        </script>
        