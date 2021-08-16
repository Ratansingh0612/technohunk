 <section class="content-bar">
        <div class="container">
            <ul>
                <li class="current">
                    <a href="${pageContext.request.contextPath}/${sessionScope.user_session_data.homePage}">
                        <i class="icon md-book-1"></i>
                        Learning
                    </a>
                </li>
                <!-- <li>
                    <a href="account-teaching.html">
                        <i class="icon md-people"></i>
                        Teaching
                    </a>
                </li> -->
                 <k:if test = "${sessionScope.user_session_data.role eq  'consultant'}">	
                <li>
                    <a href="javascript:">
                        <i class="icon md-shopping"></i>
                        Assignment
                    </a>
                </li>
                </k:if>
<!--                 <li> -->
							<k:if test = "${sessionScope.user_session_data.role eq 'consultant'}">
	              				  <li><a href="${pageContext.request.contextPath}/action/consultant-profile"><i class="icon md-user-minus"></i>Profile</a></li>
	                    </k:if>
	             	   <k:if test = "${sessionScope.user_session_data.role eq  'trainer'}">	
	                    <li><a href="${pageContext.request.contextPath}/action/user-profile"><i class="icon md-user-minus"></i>Profile</a></li>
					 </k:if>
<%--                     <a href=""${pageContext.request.contextPath}/action/user-profile"> --%>
<!--                         <i class="icon md-user-minus"></i> -->
<!--                         Profile -->
<!--                     </a> -->
                    
<!--                 </li> -->
                <li>
                    <a href="javascript:">
                        <i class="icon md-email"></i>
                        Inbox
                    </a>
                </li>
            </ul>
        </div>
    </section>