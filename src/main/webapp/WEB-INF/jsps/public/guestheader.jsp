 <header id="header" class="header">
        <div class="container">
            <!-- LOGO -->
            <div class="logo"><a href="${pageContext.request.contextPath}/${sessionScope.user_session_data.homePage}" style="display: inline;"><img src="${pageContext.request.contextPath}/images/logo.png" alt=""></a>
           <span style="color:yellow;font-size: 16px;font-weight: bold;"></span>
            </div>
            <!-- END / LOGO -->

            <!-- NAVIGATION -->
            <nav class="navigation">

                <div class="open-menu">
                    <span class="item item-1"></span>
                    <span class="item item-2"></span>
                    <span class="item item-3"></span>
                </div>

                <!-- MENU -->
                <ul class="menu">
                    <li><a href="${pageContext.request.contextPath}/assessment/welcome-test">Home</a></li>
                   
                    <li>
                        <a href="#">Buy Career Card</a>
                    </li>
                    
                    <li>
                        <a href="https://www.payumoney.com/paybypayumoney/#/EEAE8A2A16AFBB2BEB36099AE2231B03">Support JSPR</a>
                    </li>
                    
                      <li>
                        <a href="#">Contact Us</a>
                    </li>
                    <%--  <li><a href="${pageContext.request.contextPath}/action/uchange-password">Change Password</a>
                    </li> --%>
                </ul>
                <!-- END / MENU -->

                <!-- END / SEARCH BOX -->

                <!-- LIST ACCOUNT INFO -->
                <ul class="list-account-info">
                      <!-- MESSAGE INFO -->
                    <li class="list-item messages">
                        <div class="message-info item-click">
                          <a href="#">  <i class="icon md-email"></i></a>
                            <span class="itemnew"></span>
                        </div>
                    
                    </li>
                    <!-- END / MESSAGE INFO -->

                    <!-- NOTIFICATION -->
                    <li class="list-item notification">
                        <div class="notification-info item-click">
                            <i class="icon md-bell"></i>
                            <span class="itemnew"></span>
                        </div>
              
                    </li>
                    <!-- END / NOTIFICATION -->

                    <li class="list-item account">
                        <div class="account-info item-click">
                            		<a href="${pageContext.request.contextPath}/assessment/login-auth"><img src="${pageContext.request.contextPath}/action/imageByUserId?userid=${sessionScope.user_session_data.loginId}" alt=""></a>
                        	</div>
                        <div class="toggle-account toggle-list">
                        </div>
                    </li>


                </ul>
                <!-- END / LIST ACCOUNT INFO -->

            </nav>
            <!-- END / NAVIGATION -->

        </div>
    </header>
