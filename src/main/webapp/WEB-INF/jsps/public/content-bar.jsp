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
<!--                 <li> -->
				   <c:if test = "${sessionScope.user_session_data.role=='consultant'}">
                <li><a href="${pageContext.request.contextPath}/${sessionScope.user_session_data.homePage}"><i class="icon md-user-minus"></i>Profile</a></li>
                </c:if>
<%--                     <a href=""${pageContext.request.contextPath}/action/user-profile"> --%>
<!--                         <i class="icon md-user-minus"></i> -->
<!--                         Profile -->
<!--                     </a> -->
                    
<!--                 </li> -->
            </ul>
        </div>
    </section>