 <header id="header" class="header">
        <div class="container">

            <!-- LOGO -->
               <span style="float: right;margin-top: 10px;">
            Userid &nbsp;:&nbsp;(${sessionScope.user_session_data.loginId})
            </span>
            <div class="logo"><a href="${pageContext.request.contextPath}/${sessionScope.user_session_data.homePage}"><img src="${pageContext.request.contextPath}/images/logo.png" alt="" style="margin-top: 25px;"></a></div>
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
                  <%--   <li class="menu-item-has-children">
                        <a href="#">Test</a>
                         <ul class="sub-menu">
                         		<li><a href="${pageContext.request.contextPath}/action/search-assign-test-to-user">Search Assign Test</a></li>
                        		<li> <a href="${pageContext.request.contextPath}/action/send-exam-link">Send Test Link</a></li>
								<li><a href="${pageContext.request.contextPath}/action/consultant-test-reset">Assign/Reset Test</a></li>
								 <li><a href="${pageContext.request.contextPath}/action/search-consultant-test-history">Search Test History</a></li>
                        		<li><a href="${pageContext.request.contextPath}/action/consultant-test-status-details">Test History Details</a></li>
                              <li><a href="${pageContext.request.contextPath}/action/configure-test">Configure Test</a></li>
                            <li><a href="${pageContext.request.contextPath}/action/consultant-test-reset">Delete Test</a></li>
                            <li><a href="${pageContext.request.contextPath}/action/delete-consultant-test">Delete Users Test</a></li>
                            
                        	<li> <a href="${pageContext.request.contextPath}/action/send-exam-link">Send Test Link</a></li>
                        	   <li><a href="${pageContext.request.contextPath}/action/online-available-tests">Review Config Tests</a></li>
                        </ul>
                    </li> --%>
                    
                     <li class="menu-item-has-children">
                        <a href="#">Guest Test</a>
                         <ul class="sub-menu">
                             <li> <a href="${pageContext.request.contextPath}/action/available-tests">Send Guest Test Link</a></li>
                                <li> <a href="${pageContext.request.contextPath}/action/guest-test-search-history">Search Test History</a></li>
                                <li> <a href="${pageContext.request.contextPath}/action/pending-test-guest-user">Pending Guest Test</a></li>
                                
                                     <li> <a href="${pageContext.request.contextPath}/action/guest-test-performance-report">Guest Performance</a></li>
                                   <li> <a href="${pageContext.request.contextPath}/action/guest-test-search-reset-history">Search Reset History</a></li>
                                   
                                   <li><a href="${pageContext.request.contextPath}/action/guest-test-status">Guest Test Status</a></li>
                             <%--   <li><a href="${pageContext.request.contextPath}/action/manage-guest-user">Reset Guest Test</a></li> --%>
                              <li><a href="${pageContext.request.contextPath}/action/configure-test">Configure Test</a></li>
                        	   <li><a href="${pageContext.request.contextPath}/action/online-available-tests">Review Config Tests</a></li>
                        	        <li><a href="${pageContext.request.contextPath}/action/logged-in-users">Logged User(s)</a></li>
                        </ul>
                    </li>
                    
                     <li class="menu-item-has-children">
                        <a href="#">Challenges</a>
                        <ul class="sub-menu">
                        <li> <a href="${pageContext.request.contextPath}/action/codings/java/lists?problemCategory=All">All Coding Problems</a></li>
                          <li> <a href="${pageContext.request.contextPath}/action/codings/java/pagelists?page=1">Coding Problems</a></li>
                        	<li> <a href="${pageContext.request.contextPath}/action/codings/add-coding-problem">Add Problems</a></li>
                        	  	<li> <a href="${pageContext.request.contextPath}/action/codings/coding-problem-guest-result">Coding Result</a></li>
                        	  	<li> <a href="${pageContext.request.contextPath}/action/codings/pending-coding-problem-guest">Pending Problems</a></li>
                        </ul>
                    </li>
                    
                       <li class="menu-item-has-children">
                        <a href="#">Questions</a>
                        <ul class="sub-menu">
                        	<li> <a href="${pageContext.request.contextPath}/action/upload-questions-answers">Upload Questions</a></li>
                        	<li> <a href="${pageContext.request.contextPath}/action/show-question-and-answer">Add Question</a></li>
                        	<li> <a href="${pageContext.request.contextPath}/action/questions-bank">Questions Bank</a></li>
                        	<li> <a href="${pageContext.request.contextPath}/action/add-question-bank">Add Questions Bank</a></li>
                        	<li> <a href="#">Technology Images</a></li>
                        </ul>
                    </li>
                    
                       <%--  <li class="menu-item-has-children">
                        <a href="#">Interview</a>
                        <ul class="sub-menu">
                            <li><a href="${pageContext.request.contextPath}/action/consultant-screening-interview">Screening Interview</a></li>
                            <li><a href="${pageContext.request.contextPath}/action/select-interview-status">Interview Status</a></li>
                        </ul>
                    </li> --%>
                    
                    <%-- <li class="menu-item-has-children">
                        <a href="#">Misc</a>
                        <ul class="sub-menu">
                         <li><a href="${pageContext.request.contextPath}/action/consultant-screening-interview">Screening Interview</a></li>
                            <li><a href="${pageContext.request.contextPath}/action/select-interview-status">Interview Status</a></li>
                        <li><a href="${pageContext.request.contextPath}/action/consultant-test-reset">Reset Consultant Test</a></li>
                        	 <li><a href="${pageContext.request.contextPath}/action/consultant-test-status">Test Result</a></li>
                              <li><a href="${pageContext.request.contextPath}/action/assign-test-to-user">Assign Test Group</a></li>
                                <li><a href="${pageContext.request.contextPath}/action/consultant-group-test-reset">Reset Group Test</a></li>
                                 <li><a href="${pageContext.request.contextPath}/action/consultant-test-reset">Reset Consultant Test</a></li>
                                      <li><a href="${pageContext.request.contextPath}/action/available-tests">Available Tests</a></li>
                         <li><a href="${pageContext.request.contextPath}/action/consultant-screening-interview">Screening Interview</a></li>
                            <li><a href="${pageContext.request.contextPath}/action/select-interview-status">Interview Status</a></li>
                        <li><a href="${pageContext.request.contextPath}/action/lock-consultant-account">Lock/Unlock Users</a></li>
                                         <li><a href="${pageContext.request.contextPath}/action/manage-registered-user">Managed Users</a></li>
                               <li><a href="${pageContext.request.contextPath}/action/manage-guest-user">Manage Guest User</a></li>
                        </ul>
                    </li> --%>
                    
                    <li class="menu-item-has-children">
                        <a href="#">Action</a>
                        <ul class="sub-menu">
                          <li><a href="${pageContext.request.contextPath}/action/map-consultant-batch">Associate Batch</a></li> 
                                 <li><a href="${pageContext.request.contextPath}/action/show-hide-tests">Show Hide Tests</a></li>
                            <li><a href="${pageContext.request.contextPath}/action/pending-users-accounts">Pending Users</a></li> 
                             <li><a href="${pageContext.request.contextPath}/action/trainer-daily-report">Trainer Daily Report</a></li> 
                            <li><a href="${pageContext.request.contextPath}/action/add-session-batch">Add Session</a></li>
                            <li><a href="${pageContext.request.contextPath}/action/add-contents-course-details">Add Course</a></li>
                            <li><a href="${pageContext.request.contextPath}/action/add-consultant">Add Consultant</a></li>
                            <li><a href="${pageContext.request.contextPath}/action/show-technology-progress">Tech Progress</a></li>
                            <li><a href="${pageContext.request.contextPath}/action/show-all-consultants">Lock/Unlock</a></li>
                            <li><a href="${pageContext.request.contextPath}/action/add-topic">Add Topic</a></li>
                            <li><a href="${pageContext.request.contextPath}/action/add-edit-technology">Add/Edit Technology</a></li>
                            <li><a href="${pageContext.request.contextPath}/action/admin-available-questions-bank-test">Available Questions Bank</a></li>
                            <li><a href="${pageContext.request.contextPath}/action/all-users">App Users</a></li> 
                           <li><a href="#">Session Details</a></li>
                            <li><a href="#">Upload Assignments</a></li>
                            <li><a href="${pageContext.request.contextPath}/action/map-consultant-batch">Associate Batch</a></li> --%>
                        </ul>
                    </li>
                    
                    
                <!--     <li class="menu-item-has-children current-menu-item megamenu col-4">
                        <a href="#">Pages</a>
                        <ul class="sub-menu">
                            <li class="menu-item-has-children">
                                <a href="#">Account 1</a>
                                <ul class="sub-menu">
                                    <li><a href="account-assignment.html">Account Assignment</a></li>
                                    <li><a href="account-inbox.html">Account Inbox</a></li>
                                    <li class="current-menu-item"><a href="account-learning.html">Account Learning</a></li>
                                    <li><a href="account-profile-owner-view.html">Account Profile Owner</a></li>
                                    <li><a href="account-profile-guest-view.html">Account Profile Guest</a></li>
                                    <li><a href="account-teaching.html">Account Teaching</a></li>
                                    <li><a href="setting.html">Setting</a></li>
                                </ul>
                            </li>

                            <li class="menu-item-has-children">
                                <a href="#">Asignment 2</a>
                                <ul class="sub-menu">
                                    <li><a href="asignment-after-submit.html">Asignment After Submit</a></li>
                                    <li><a href="asignment-list.html">Asignment List</a></li>
                                    <li><a href="asignment-marking.html">Asignment Marking</a></li>
                                    <li><a href="asignment-received.html">Asignment Received</a></li>
                                    <li><a href="asignment-submit.html">Asignment Submit</a></li>
                                    <li><a href="become-teacher.html">Become Teacher</a></li>
                                    <li><a href="categories.html">Categories</a></li>
                                </ul>
                            </li>
                            <li class="menu-item-has-children">
                                <a href="#">Course 3</a>
                                <ul class="sub-menu">
                                    <li><a href="course-intro.html">Course Intro</a></li>
                                    <li><a href="course-learn.html">Course Learn</a></li>
                                    <li><a href="create-basic-information.html">Create Basic Information</a></li>
                                    <li><a href="create-design-course.html">Create Design Course</a></li>
                                    <li><a href="create-publish-course.html">Create Publish Course</a></li>
                                    <li><a href="request-teacher.html">Request Teacher</a></li>
                                    <li><a href="search-result-found.html">Search Result Found</a></li>
                                    <li><a href="search-result-not-found.html">Search Result Found</a></li>
                                </ul>
                            </li>
                            <li class="menu-item-has-children">
                                <a href="#">Learn 3</a>
                                <ul class="sub-menu">
                                    <li><a href="learning.html">Learning</a></li>
                                    <li><a href="quizz-1.html">Quizz 1</a></li>
                                    <li><a href="quizz-2.html">Quizz 2</a></li>
                                    <li><a href="quizz-3.html">Quizz 3</a></li>
                                    <li><a href="quizz-5.html">Quizz 5</a></li>
                                    <li><a href="quizz-20.html">Quizz 20</a></li>
                                    <li><a href="quizz-finish.html">Quizz Finish</a></li>
                                    <li><a href="quizz-intro.html">Quizz Intro</a></li>
                                </ul>
                            </li>
                        </ul>
                    </li> -->
                  <!--   <li class="menu-item-has-children">
                        <a href="blog-list.html">Blog</a>
                        <ul class="sub-menu">
                            <li><a href="blog-list.html">Blog list</a></li>
                            <li><a href="blog-single.html">Blog single</a></li>
                        </ul>
                    </li> -->
                   
            <!--         <li class="menu-item-has-children">
                        <a href="#">Login</a>
                        <ul class="sub-menu">
                            <li><a href="login.html">Login</a></li>
                            <li><a href="register.html">Register</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="categories.html">Course</a>
                    </li> -->
                    <li class="menu-item-has-children">
                        <a href="#">CPanel</a>
                        <ul class="sub-menu">
                            <li><a href="${pageContext.request.contextPath}/action/edit-landing-page">Edit Main Page</a></li>
                            <li><a href="${pageContext.request.contextPath}/action/edit-login-page">Edit Login Page</a></li>
                         <!--     <li><a href="#">Edit Admin Home</a></li>
                              <li><a href="#">Edit Trainer Home</a></li>
                               <li><a href="#">Edit Consultant Home</a></li> -->
                        </ul>
                    </li>
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
                                            <p>Welcome message</p>
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
                                            <img src="${pageContext.request.contextPath}/images/team-13.jpg" alt="">
                                        </div>
                                        <div class="list-body">
                                            <div class="author">
                                                <span>Name of sender</span>
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
                                            <p>Maecenas sodales, nisl eget dign...</p>
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

                                <!-- LIST ITEM -->
                                <li>
                                    <a href="#">
                                        <div class="image">
                                            <img src="${pageContext.request.contextPath}/images/team-13.jpg" alt="">
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

                                <!-- LIST ITEM -->
                                <li>
                                    <a href="#">
                                        <div class="image">
                                            <img src="${pageContext.request.contextPath}/images/team-13.jpg" alt="">
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
                                                <span>Megacourse</span>
                                                <div class="div-x"></div>
                                            </div>
                                            <p>attend Salary for newbie course</p>
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
                                                <span>Megacourse</span>
                                                <div class="div-x"></div>
                                            </div>
                                            <p>attend Salary for newbie course</p>
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
                                                <span>Megacourse</span>
                                                <div class="div-x"></div>
                                            </div>
                                            <p>attend Salary for newbie course</p>
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
                                                <span>Megacourse</span>
                                                <div class="div-x"></div>
                                            </div>
                                            <p>attend Salary for newbie course</p>
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
                                                <span>Megacourse</span>
                                                <div class="div-x"></div>
                                            </div>
                                            <p>attend Salary for newbie course</p>
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
                                                <span>Megacourse</span>
                                                <div class="div-x"></div>
                                            </div>
                                            <p>attend Salary for newbie course</p>
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

                                

                            </ul>
                        </div>
                    </li>
                    <!-- END / NOTIFICATION -->

                    <li class="list-item account">
                        <div class="account-info item-click">
                           <%--  <img src="${pageContext.request.contextPath}/images/team-13.jpg" alt="">
                            --%>  <img src="${pageContext.request.contextPath}/action/imageByUserId?userid=${sessionScope.user_session_data.loginId}" alt="">
                        </div>
                        <div class="toggle-account toggle-list">
                            <ul class="list-account">
                                <li><a href="#"><i class="icon md-config"></i>Setting</a></li>
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
