 <header id="header" class="header">
        <div class="container">

            <!-- LOGO -->
             <span style="float: right;margin-top: 10px;">
            Userid &nbsp;:&nbsp;(${sessionScope.user_session_data.loginId})
            </span>
           <div class="logo"><a href="${pageContext.request.contextPath}/${sessionScope.user_session_data.homePage}" style="display: inline;"><img src="${pageContext.request.contextPath}/images/logo.png" alt="" style="margin-top: 25px;"></a>
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
                        <a href="#">Test</a>
                        <ul class="sub-menu">
                              <li><a href="${pageContext.request.contextPath}/action/available-tests">Available Tests</a></li>
                            <li><a href="${pageContext.request.contextPath}/action/configure-test">Configure Test</a></li>
                                <li><a href="${pageContext.request.contextPath}/action/consultant-test-reset">Assign Test</a></li>
                             <li><a href="${pageContext.request.contextPath}/action/assign-test-to-user">Assign Test Group</a></li>
                             <li><a href="${pageContext.request.contextPath}/action/consultant-test-reset">Reset Consultant Test</a></li>
                            <li><a href="${pageContext.request.contextPath}/action/consultant-test-status-details">Test History Details</a></li>
                           <%--     <li><a href="${pageContext.request.contextPath}/action/search-assign-test-to-user">Search & Assign Test</a></li> --%>
                          <%--   <li><a href="${pageContext.request.contextPath}/action/consultant-test-reset">Delete Test</a></li>
                            <li><a href="${pageContext.request.contextPath}/action/delete-consultant-test">Delete Users Test</a></li>
                             --%>
                        	<%-- <li> <a href="${pageContext.request.contextPath}/action/send-exam-link">Send Test Link</a></li> --%>
                        	<li> <a href="${pageContext.request.contextPath}/action/available-tests">Send Test Link</a></li>
                        	 <li><a href="${pageContext.request.contextPath}/action/lock-consultant-account">Lock/Unlock Users</a></li>
                          <li><a href="${pageContext.request.contextPath}/action/manage-guest-user">Managed Guests</a></li>
                        </ul>
                    </li>
                    
                       <li class="menu-item-has-children">
                        <a href="#">Questions</a>
                        <ul class="sub-menu">
                        	<li> <a href="${pageContext.request.contextPath}/action/upload-questions-answers">Upload Questions</a></li>
                        	<li> <a href="${pageContext.request.contextPath}/action/show-question-and-answer">Add Question</a></li>
                        	<li> <a href="${pageContext.request.contextPath}/action/questions-bank">Questions Bank</a></li>
                        	<li> <a href="${pageContext.request.contextPath}/action/add-question-bank">Add Questions Bank</a></li>
                        </ul>
                    </li>
                    
                        <li class="menu-item-has-children">
                        <a href="#">Interview</a>
                        <ul class="sub-menu">
                            <li><a href="${pageContext.request.contextPath}/action/consultant-screening-interview">Screening Interview</a></li>
                            <li><a href="${pageContext.request.contextPath}/action/select-interview-status">Interview Status</a></li>
                              <li><a href="${pageContext.request.contextPath}/action/tech-questions-answer">Interview Questions</a></li>
                        </ul>
                    </li>
                    
                    
                    
                    <li class="menu-item-has-children">
                        <a href="#">Action</a>
                  <ul class="sub-menu">
                  <li><a href="${pageContext.request.contextPath}/action/trainer-session-schedule">Session Schedule</a></li>
                    <li><a href="${pageContext.request.contextPath}/action/add-session-batch">Add Session</a></li>
                                 <li><a href="${pageContext.request.contextPath}/action/add-question-answer">Add Question Answer</a></li>
                                    <li><a href="${pageContext.request.contextPath}/action/add-topic">Add Topic</a></li>
                                    <li><a href="${pageContext.request.contextPath}/action/add-edit-technology">Technology</a></li>
                             <li><a href="${pageContext.request.contextPath}/action/add-batch">Add Batch</a></li>
                                <li><a href="${pageContext.request.contextPath}/action/add-consultant">Add Consultant</a></li>
                                    <li><a href="${pageContext.request.contextPath}/action/show-all-consultants">Consultants</a></li>
                                     <li><a href="${pageContext.request.contextPath}/action/lock-consultant-account">Lock Consultants</a></li>
                               <%-- 
                            <li><a href="${pageContext.request.contextPath}/action/add-contents-course-details">Add Course</a></li>
                            <li><a href="${pageContext.request.contextPath}/action/add-consultant">Add Consultant</a></li>
                            <li><a href="${pageContext.request.contextPath}/action/show-technology-progress">Tech Progress</a></li>
                            <li><a href="${pageContext.request.contextPath}/action/show-all-consultants">Lock/Unlock</a></li>
                            <li><a href="${pageContext.request.contextPath}/action/consultant-course-coverd-status">Course Covered %</a></li>
                            <li><a href="${pageContext.request.contextPath}/action/show-session-schedule">Show Session Schedule</a></li>
                            <li><a href="${pageContext.request.contextPath}/action/get-batch-for-assignment-trainer">Set Consultant Assignment</a></li>
                            
                            <li><a href="#">Session Details</a></li>
                            <li><a href="#">Upload Assignments</a></li>--%>
                        </ul> 
                    </li>
                    
                    
                    
                    <li class="menu-item-has-children">
                        <a href="#">Report</a>
                         <ul class="sub-menu">
                           <li><a href="${pageContext.request.contextPath}/action/consultant-test-status">Test Result</a></li>
                            <li><a href="${pageContext.request.contextPath}/action/guest-test-status">Guest Test Status</a></li>
                                <li><a href="${pageContext.request.contextPath}/action/manage-registered-user">Managed Users</a></li>
                               <li><a href="${pageContext.request.contextPath}/action/manage-guest-user">Manage Guest User</a></li>
                        <!--     <li><a href="blog-single.html">Android</a></li>
                             <li><a href="blog-single.html">Hadoop</a></li>
                        	-->
                        </ul> 
                    </li>
                 
                </ul>
                <!-- END / MENU -->

                <!-- SEARCH BOX -->
                <div class="search-box">
                    <i class="icon md-search"></i>
                    <div class="search-inner">
                        <form id="searchConsulatTestForm" action="search-consultant-test-status-details" method="POST">
                            <input type="text" name="searchConsultantId" placeholder="Consultant Id" id="searchConsultantId">
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
                            <%-- <img src="${pageContext.request.contextPath}/images/team-13.jpg" alt=""> --%>
                            <img src="${pageContext.request.contextPath}/action/imageByUserId?userid=${sessionScope.user_session_data.loginId}" alt="">
                        </div>
                        <div class="toggle-account toggle-list">
                            <ul class="list-account">
                                <li><a href="setting.html"><i class="icon md-config"></i>Setting</a></li>
                                <li><a href="${pageContext.request.contextPath}/action/logout"><i class="icon md-arrow-right"></i>Sign Out</a></li>
                                <li><a href="${pageContext.request.contextPath}/action/user-profile"><i class="icon md-arrow-right"></i>Profile</a></li>
                                  <li><a href="${pageContext.request.contextPath}/action/uchange-password"><i class="icon md-arrow-right"></i>Password</a></li>
                            </ul>
                        </div>
                    </li>
                </ul>
                <!-- END / LIST ACCOUNT INFO -->

            </nav>
            <!-- END / NAVIGATION -->

        </div>
    </header>
