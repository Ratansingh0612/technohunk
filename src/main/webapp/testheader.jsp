 <header id="header" class="header">
        <div class="container">
            <!-- LOGO -->
               <span style="float: right;margin-top: 10px;">
            Userid &nbsp;:&nbsp;(${sessionScope.user_session_data.loginId})
            </span>
            <div class="logo"><a href="${pageContext.request.contextPath}/${sessionScope.user_session_data.homePage}" style="display: inline;"><img src="${pageContext.request.contextPath}/images/java-oracle.png" alt="" style="margin-top: 25px;height: 100px;"></a>
            <span style="color:white;display: inline;"> Userid &nbsp;:&nbsp;<b>(${sessionScope.user_session_data.loginId})</b></span>
            </div>
             <br/><br/>
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
                    <li><a href="${pageContext.request.contextPath}/${sessionScope.user_session_data.homePage}">Home</a></li>
                   
                    <li>
                        <a href="#">Study Materials</a>
                    </li>
                    
                    <li>
                        <a href="#">Course</a>
                    </li>
                    <%--  <li><a href="${pageContext.request.contextPath}/action/uchange-password">Change Password</a>
                    </li> --%>
                </ul>
                <!-- END / MENU -->

                <!-- SEARCH BOX -->
                <div class="search-box">
                    <i class="icon md-search"></i>
                    <div class="search-inner">
                        <form>
                            <input type="text" placeholder="key words">
                        </form>
                    </div>
                </div>
                <!-- END / SEARCH BOX -->

                <!-- LIST ACCOUNT INFO -->
                <ul class="list-account-info">
                      <!-- MESSAGE INFO -->
                    <li class="list-item messages">
                        <div class="message-info item-click">
                            <i class="icon md-email"></i>
                            <span class="itemnew"></span>
                        </div>
                        <div class="toggle-message toggle-list">
                            <div class="list-profile-title">
                                <h4>Inbox message</h4>
                                <span class="count-value">3</span>
                                <a href="#" class="new-message"><i class="icon md-pencil"></i></a>
                            </div>
                            <ul class="list-message">

                                <!-- LIST ITEM -->
                                <li class="ac-new">
                                    <a href="#">
                                        <div class="image">
                                            <img src="${pageContext.request.contextPath}/images/team-13.jpg" alt="">
                                        </div>
                                        <div class="list-body">
                                            <div class="author">
                                                <span>Megacourse</span>
                                                <div class="div-x"></div>
                                            </div>
                                            <p>We are waiting for test</p>
                                            <div class="time">
                                                <span>12:53</span>
                                            </div>
                                            <div class="indicator">
                                                <i class="icon md-paperclip"></i>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <!-- END / LIST ITEM -->

                                <!-- LIST ITEM -->
                                <li class="ac-new">
                                    <a href="#">
                                        <div class="image">
                                            <img src="${pageContext.request.contextPath}/images/icon/user-icon.png" alt="">
                                        </div>
                                        <div class="list-body">
                                            <div class="author">
                                                <span>Ashutosh Singh</span>
                                                <div class="div-x"></div>
                                            </div>
                                            <p>We are waiting for test</p>
                                            <div class="time">
                                                <span>5 days ago</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <!-- END / LIST ITEM -->

                                <!-- LIST ITEM -->
                                <li class="ac-new">
                                    <a href="#">
                                        <div class="image">
                                            <img src="${pageContext.request.contextPath}/images/team-13.jpg" alt="">
                                        </div>
                                        <div class="list-body">
                                            <div class="author">
                                                <span>Sasha Grey</span>
                                                <div class="div-x"></div>
                                            </div>
                                            <p>Yeah test was really fantastic...</p>
                                            <div class="time">
                                                <span>5 days ago</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <!-- END / LIST ITEM -->

                                <!-- LIST ITEM -->
                                <li>
                                    <a href="#">
                                        <div class="image">
                                           <img src="${pageContext.request.contextPath}/images/icon/user-icon.png" alt="">
                                        </div>
                                        <div class="list-body">
                                            <div class="author">
                                                <span>Neha Singh</span>
                                                <div class="div-x"></div>
                                            </div>
                                            <p>Message title</p>
                                            <div class="time">
                                                <span>5 days ago</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <!-- END / LIST ITEM -->

                                <!-- LIST ITEM -->
                                <li>
                                    <a href="#">
                                        <div class="image">
                                            <img src="${pageContext.request.contextPath}/images/team-13.jpg" alt="">
                                        </div>
                                        <div class="list-body">
                                            <div class="author">
                                                <span>Pawan Gulati</span>
                                                <div class="div-x"></div>
                                            </div>
                                            <p>Message title</p>
                                            <div class="time">
                                                <span>5 days ago</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <!-- END / LIST ITEM -->

                                <!-- LIST ITEM -->
                                <li>
                                    <a href="#">
                                        <div class="image">
                                             <img src="${pageContext.request.contextPath}/images/icon/user-icon.png" alt="">
                                        </div>
                                        <div class="list-body">
                                            <div class="author">
                                                <span>Amanda Gleam</span>
                                                <div class="div-x"></div>
                                            </div>
                                            <p>Message title</p>
                                            <div class="time">
                                                <span>5 days ago</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <!-- END / LIST ITEM -->

                            </ul>
                            <div class="viewall">
                                <a href="#">view all 80 messages</a>
                            </div>
                        </div>
                    </li>
                    <!-- END / MESSAGE INFO -->

                    <!-- NOTIFICATION -->
                    <li class="list-item notification">
                        <div class="notification-info item-click">
                            <i class="icon md-bell"></i>
                            <span class="itemnew"></span>
                        </div>
                        <div class="toggle-notification toggle-list">
                            <div class="list-profile-title">
                                <h4>Notification</h4>
                                <span class="count-value">2</span>
                            </div>

                            <ul class="list-notification">

                                <!-- LIST ITEM -->
                                <li class="ac-new">
                                    <a href="#">
                                        <div class="list-body">
                                            <div class="author">
                                                <span>C++</span>
                                                <div class="div-x"></div>
                                            </div>
                                                <p>online test is starting soon.</p>
                                            <div class="image">
                                                <img src="${pageContext.request.contextPath}/images/feature/img-1.jpg" alt="">
                                            </div>
                                            <div class="time">
                                                <span>5 minutes ago</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <!-- END / LIST ITEM -->

                                <!-- LIST ITEM -->
                                <li class="ac-new">
                                    <a href="#">
                                        <div class="list-body">
                                            <div class="author">
                                                <span>Python</span>
                                                <div class="div-x"></div>
                                            </div>
                                               <p>online test is starting soon.</p>
                                            <div class="image">
                                                  <img src="${pageContext.request.contextPath}/images/icon/user-icon.png" alt="">
                                            </div>
                                            <div class="time">
                                                <span>5 minutes ago</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <!-- END / LIST ITEM -->

                                <!-- LIST ITEM -->
                                <li>
                                    <a href="#">
                                        <div class="list-body">
                                            <div class="author">
                                                <span>PHP</span>
                                                <div class="div-x"></div>
                                            </div>
                                            <p>online test is starting soon.</p>
                                            <div class="image">
                                                <img src="${pageContext.request.contextPath}/images/feature/img-1.jpg" alt="">
                                            </div>
                                            <div class="time">
                                                <span>5 minutes ago</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <!-- END / LIST ITEM -->

                                <!-- LIST ITEM -->
                                <li>
                                    <a href="#">
                                        <div class="list-body">
                                            <div class="author">
                                                <span>Java</span>
                                                <div class="div-x"></div>
                                            </div>
                                              <p>online test is starting soon.</p>
                                            <div class="image">
                                                        <img src="${pageContext.request.contextPath}/images/icon/user-icon.png" alt="">
                                            </div>
                                            <div class="time">
                                                <span>5 minutes ago</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <!-- END / LIST ITEM -->

                                <!-- LIST ITEM -->
                                <li>
                                    <a href="#">
                                        <div class="list-body">
                                            <div class="author">
                                                <span>.NET</span>
                                                <div class="div-x"></div>
                                            </div>
                                            <p>online test is starting soon.</p>
                                            <div class="image">
                                                <img src="${pageContext.request.contextPath}/images/feature/img-1.jpg" alt="">
                                            </div>
                                            <div class="time">
                                                <span>5 minutes ago</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <!-- END / LIST ITEM -->

                                <!-- LIST ITEM -->
                                <li>
                                    <a href="#">
                                        <div class="list-body">
                                            <div class="author">
                                                <span>Data Structure</span>
                                                <div class="div-x"></div>
                                            </div>
                                             <p>online test is starting soon.</p>
                                            <div class="image">
                                                <img src="${pageContext.request.contextPath}/images/icon/user-icon.png" alt="">
                                            </div>
                                            <div class="time">
                                                <span>5 minutes ago</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <!-- END / LIST ITEM -->

                                

                            </ul>
                        </div>
                    </li>
                    <!-- END / NOTIFICATION -->

                    <li class="list-item account">
                        <div class="account-info item-click">
                            		<img src="${pageContext.request.contextPath}/action/imageByUserId?userid=${sessionScope.user_session_data.loginId}" alt="">
                        	</div>
                        <div class="toggle-account toggle-list">
                            <ul class="list-account">
                                <li><a href="#"><i class="icon md-config"></i>Setting</a></li>
                                <li><a href="${pageContext.request.contextPath}/action/leaveTest?testName=${utestName}&techName=${utechName}"><i class="icon md-arrow-right"></i>Leave Test</a></li>
                            </ul>
                        </div>
                    </li>


                </ul>
                <!-- END / LIST ACCOUNT INFO -->

            </nav>
            <!-- END / NAVIGATION -->

        </div>
    </header>
