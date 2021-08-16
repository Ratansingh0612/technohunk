 <header id="header" class="header">
        <div class="container">
            <!-- LOGO -->
            <div class="logo"><a href="${pageContext.request.contextPath}/${sessionScope.user_session_data.homePage}" style="display: inline;"><img src="${pageContext.request.contextPath}/images/logo.png" alt=""></a>
            <span style="color:white;display: inline;"> Userid &nbsp;:&nbsp;<b>(${param.email})</b></span>
            </div>
            <!-- END / LOGO -->
   <br/><br/>
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
                                <li><a href="javascript:"><i class="icon md-config"></i>Setting</a></li>
                                <li><a href="javascript:"><i class="icon md-arrow-right"></i>Config</a></li>
                            </ul>
                        </div>
                    </li>


                </ul>
                <!-- END / LIST ACCOUNT INFO -->

            </nav>
            <!-- END / NAVIGATION -->

        </div>
    </header>