                        <div class="post" style="height: 100px;">
                            <!-- POST MEDIA -->
                            <div class="post-media">
                                <div class="image-thumb">
                                    <img src="${pageContext.request.contextPath}/images/codings/clean-code.png" alt="" style="width:120px;margin-top: -20px;">
                                </div>
                            </div>
                            <!-- END / POST MEDIA -->
                            <!-- POST BODY -->
                            <div class="post-body">
                                <div class="post-title">
                                    <h3 class="md"><a href="#">${item.title}</a></h3>
                                     Level : ${item.level}
                                     <span style="margin-left:50px; ">
                                     Total Duration : ${item.duration} Minutes
                                     </span>
                                     
                                </div>
                                <div class="post-meta" style="font-size: 16px;">
                                    by <a href="#">${item.author}</a> on <span style="color:black;"><fmt:formatDate type="date" value = "${item.doe}" />
                                </div>
                            </div>
                        	
        
                        </div>