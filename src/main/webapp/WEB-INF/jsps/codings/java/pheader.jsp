<section>
        		<p class="breadscrumscrollcoll"> 
        		<a href="${pageContext.request.contextPath}/action/codings/java/lists">
        		${sessionScope.techName}${item.techName} Coding Problem List</a>&nbsp;&nbsp;>&nbsp; ${item.title} ${sessionScope.problemTitle}
        		 <k:if test="${sessionScope.user_session_data.role=='admin'}">	
        		<a href="${item.icon}">
        		<img src="${pageContext.request.contextPath}/images/icon/solution.png"
                                         style="display: inline;height: 35px;float: right;" alt="Click to view solution"/>
                                         </a>
                  </k:if>                       
        		</p> 
        	 </section>
        	 <br/>	 <br/>
        	 <hr/>