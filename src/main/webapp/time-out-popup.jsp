 <!-- Modal -->
<div id="testTimeoutModel" class="modal fade" role="dialog">
  <div class="modal-dialog" style="width: 800px;">
    <!-- Modal content-->
    <div class="modal-content" style="background-image: url('${pageContext.request.contextPath}/images/bg/backgrounds.jpg');">
      <div class="modal-header"  style="background-color: #37abf2;height: 40px; ">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <br/>
      <img src="${pageContext.request.contextPath}/images/bell.jpg" width="60px;"/>
            <p style="display: inline;margin-left: 20px;">   <span style="font-weight: bold;" id="name"></span></p>
      </div>
      <div class="bloading">
      <div class="modal-body">
       <span style="color:red;font-size: 15px;" id="ErrorMessage"></span>
      <div class="form-group">
      &nbsp;     &nbsp;     &nbsp;
        </div>
        
        <div class="form-group">
      	<label id="stream"><h5 style="color:#03141c;"><b>Sorry! your coding problem has been time out and redirecting to your dashboard, please wait.....<span id="secondsTimer" style="color:red;"></span></b></h5></label>
        </div>
      </div>
      </div>
      <div class="modal-footer">
        	<input type="button" value="OK"  class="mc-btn btn-style-1" id="OK"  data-dismiss="modal"/>
      </div>
    </div>

  </div>
</div>