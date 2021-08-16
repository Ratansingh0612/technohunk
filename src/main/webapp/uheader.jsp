 <header id="header" class="header">
        <div class="container">
            <!-- LOGO -->
               <span style="float: right;margin-top: 10px;">
            Userid &nbsp;:&nbsp;(${sessionScope.user_session_data.loginId})
            </span>
            <div class="logo"><a href="${pageContext.request.contextPath}/${sessionScope.user_session_data.homePage}" style="display: inline;"><img src="${pageContext.request.contextPath}/images/logo.png" alt=""  style="margin-top: 25px;"></a>
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
                    <li class="menu-item-has-children">
                        <a href="#">Online Test</a>
                        <ul class="sub-menu">
                            <li><a href="${pageContext.request.contextPath}/action/user-available-test">Available Test</a></li>
                            <li><a href="${pageContext.request.contextPath}/action/user-test-history">Test History</a></li>
                               <li><a href="${pageContext.request.contextPath}/action/consultant-topic-feedback">Topic Feedback</a></li>
                        </ul>
                    </li>
                   
                    
                    <li>
                        <a href="${companyStudyMat}">Study Materials</a>
                    </li>
                    
                    <li>
                        <a href="${pageContext.request.contextPath}/action/course-contents">Course</a>
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
                       	   <%@include file="/messages.jsp" %>
                    <!-- END / MESSAGE INFO -->

                    <!-- NOTIFICATION -->
                      	   <%@include file="/notifications.jsp" %>
                    <!-- END / NOTIFICATION -->

                    <li class="list-item account">
                        <div class="account-info item-click">
                            		<img src="${pageContext.request.contextPath}/action/imageByUserId?userid=${sessionScope.user_session_data.loginId}" alt="">
                        	</div>
                        <div class="toggle-account toggle-list">
                            <ul class="list-account">
                                <li><a href="#"><i class="icon md-config"></i>Setting</a></li>
                                <li><a href="${pageContext.request.contextPath}/action/logout"><i class="icon md-arrow-right"></i>Sign Out</a></li>
                                 <k:if test = "${sessionScope.user_session_data.role eq 'consultant'}">
			              				  <li><a href="${pageContext.request.contextPath}/action/consultant-profile"><i class="icon md-user-minus"></i>Profile</a></li>
	                			    </k:if>
	                			       <k:if test = "${sessionScope.user_session_data.role eq 'trainer'}">
                                  <li><a href="${pageContext.request.contextPath}/action/user-profile"><i class="icon md-arrow-right"></i>Profile</a></li>
                                 	</k:if>
                                 <li>
                                 <a href="${pageContext.request.contextPath}/action/uchange-password"><i class="icon md-arrow-right"></i>Password</a></li>
                            </ul>
                        </div>
                    </li>


                </ul>
                <!-- END / LIST ACCOUNT INFO -->

            </nav>
            <!-- END / NAVIGATION -->

        </div>
    </header>
