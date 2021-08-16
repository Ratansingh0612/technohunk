package com.techquiz.trainer.web.rest.api;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.synergisitic.it.email.service.IAttendanceEmailReminderService;
import com.synergisitic.it.model.TechnologyEntity;
import com.synergisitic.it.model.User;
import com.synergisitic.it.service.OnlineTechTestService;
import com.synergisitic.it.service.StreamService;
import com.synergisitic.it.service.UserAdminCommonService;
import com.synergisitic.it.service.impl.UsererviceImpl;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.util.DateUtils;
import com.synergisitic.it.web.form.AssignedTestUserForm;
import com.synergisitic.it.web.form.StreamForm;
import com.synergisitic.it.web.form.TestConfiguration;
import com.synergisitic.it.web.form.UserId;
import com.techquiz.programys.common.vo.ApplicationMessageResponse;
import com.techquiz.trainer.service.IConsultantAssesmentService;
import com.techquiz.trainer.web.controller.BatchVO;
import com.techquiz.trainer.web.controller.vo.ConsultantsVO;
import com.techquiz.trainer.web.controller.vo.TrainingSessionsDetailVO;
import com.techquiz.trainer.web.rest.api.vo.ApprovePendingUserVO;
import com.techquiz.trainer.web.rest.api.vo.TestNameTopicsVO;

/**
 * 
 * @author Nagendra
 * dddddddddddd	
 * @since 02-Sept-2017
 */
@Controller
public class TrainerRestApiController {
	
	private static final Log logger = LogFactory.getLog(TrainerRestApiController.class);
	
	
	 @Value("${company.name}")
	 private String companyName;
	
	@Autowired
	@Qualifier("StreamServiceImpl")
	private StreamService streamService;
	
	@Autowired
	@Qualifier("UserAdminCommonServiceImpl")
	private UserAdminCommonService userAdminCommonService;
	
	@Autowired
	@Qualifier("AttendanceEmailReminderService")
	private IAttendanceEmailReminderService attendanceEmailReminderService;
	
	
	@Autowired
	@Qualifier("OnlineTechTestServiceImpl")
	private OnlineTechTestService onlineTechTestServiceImpl;
	
	
	@Autowired
	@Qualifier("usererviceImpl")
	private UsererviceImpl userService;
	

	@Autowired
	@Qualifier("ConsultantAssesmentService")
	private IConsultantAssesmentService consultantAssesmentService;
	
	/**
	 * This method will expose all the configured tests as per techName
	 * @param techName
	 * @return
	 */
	@RequestMapping(value="validate-email",method=RequestMethod.GET)
	@ResponseBody public ApplicationMessageResponse validateEmail(@RequestParam("email") String email){
		ApplicationMessageResponse applicationMessageResponse=new ApplicationMessageResponse();
		User user=userService.findUserByEmailId(email);
		if(user.getEmail()!=null){
			applicationMessageResponse.setStatus("fail");
			applicationMessageResponse.setMessage("This email is already used by "+user.getFirstName()+"("+user.getBatch()+")  , Please user another email id");
		}else{
			applicationMessageResponse.setStatus("success");
			applicationMessageResponse.setMessage("This email is not in use");
		}
		return applicationMessageResponse;
	}
	
	/**
	 * This method will expose all the configured tests as per techName
	 * @param techName
	 * @return
	 */
	@RequestMapping(value="approve-pending-user",method=RequestMethod.POST)
	@ResponseBody public ApplicationMessageResponse findBatchStreamOptions(@ModelAttribute ApprovePendingUserVO approvePendingUserVO,HttpServletRequest request,HttpSession session) {
		logger.debug(approvePendingUserVO);
		ConsultantsVO consultantsVO=new ConsultantsVO();
		if(ApplicationContant.TRAINER_ROLE.equalsIgnoreCase(approvePendingUserVO.getRole())){
			userService.approveUserForApp(approvePendingUserVO);
		}else{
				UserId userSession = (UserId) session
						.getAttribute(ApplicationContant.USER_SESSION_DATA);
				User user=userService.findUserById(Integer.parseInt(approvePendingUserVO.getTcid()));
				consultantsVO.setDob(user.getDob());
				consultantsVO.setTuserid(approvePendingUserVO.getTcid());
				consultantsVO.setDoj(DateUtils.getCurrentTimeIntoTimestamp());
				consultantsVO.setEmail(user.getEmail());
				consultantsVO.setEmpid(approvePendingUserVO.getConsultantid());
				consultantsVO.setGender(user.getGender());
				consultantsVO.setImage(user.getPhoto());
				consultantsVO.setLockStatus(user.getLockStatus());
				consultantsVO.setMobile(user.getMobile());
				consultantsVO.setName(user.getFirstName()+" "+user.getLastName());
				consultantsVO.setOrg(companyName);
				consultantsVO.setBatch(approvePendingUserVO.getBatch());
				consultantsVO.setStream(approvePendingUserVO.getStream());
				consultantsVO.setAdminid(userSession.getLoginId());
				consultantsVO.setDoe(DateUtils.getCurrentTimeIntoTimestamp());
				consultantsVO.setDom(DateUtils.getCurrentTimeIntoTimestamp());
				consultantsVO.setActive(approvePendingUserVO.getActive());
				consultantsVO.setRole(ApplicationContant.CONSULTANT_ROLE);
				//If it does not start with E then it is not a consultant...
				if(consultantsVO.getEmpid().startsWith("E") || consultantsVO.getEmpid().startsWith("e")) {
					consultantsVO.setUserid(consultantsVO.getEmail());
				}else
				     {
					consultantsVO.setUserid(consultantsVO.getEmpid());
					try {
						ConsultantsVO consultantsVO2=consultantAssesmentService.findConsultantByUserid(consultantsVO.getEmpid());
						ApplicationMessageResponse applicationMessageResponse=new ApplicationMessageResponse();
						applicationMessageResponse.setStatus(ApplicationContant.FAIL);
						applicationMessageResponse.setMessage("This "+consultantsVO.getEmpid()+" already registered as an user with name "+consultantsVO2.getName()+" and batch "+consultantsVO.getBatch());
						return applicationMessageResponse;
					}catch(Exception ex){
						
					}
				}
				consultantsVO.setLockStatus("no");
				// generating the default password and encrypting it...
				//DESedeEncryption deSedeEncryption = new DESedeEncryption();
				// here we are setting password into user object after encrypting it
				/*consultantsVO.setPassword(deSedeEncryption
						.encrypt(ApplicationContant.DEFAULT_PASSWORD));*/
				if(user.getPassword()==null && user.getPassword().length()==0) {
					consultantsVO.setPassword(ApplicationContant.DEFAULT_PASSWORD);
				} 
				else {
					consultantsVO.setPassword(user.getPassword());
				}		
				String result=consultantAssesmentService.registerConsultant(consultantsVO);
				List<AssignedTestUserForm> assignedTestUserForms=onlineTechTestServiceImpl.findAssignedTestsToGroupName(consultantsVO.getBatch());
				for(AssignedTestUserForm assignedTestUserForm:assignedTestUserForms){
					assignedTestUserForm.getAssignedTestCompositeKey().setUserId(consultantsVO.getUserid());
					assignedTestUserForm.setUserId(consultantsVO.getUserid());
					assignedTestUserForm.setResetDate(new Timestamp(new Date().getTime()));
					assignedTestUserForm.setTestStatus(ApplicationContant.NOT_STARTED);
				}
				//Assigning all test to the users which is already assigned to the group
				onlineTechTestServiceImpl.assignedTestToUsers(assignedTestUserForms);
		}
		ApplicationMessageResponse applicationMessageResponse=new ApplicationMessageResponse();
		applicationMessageResponse.setStatus(ApplicationContant.SUCCESS);
		applicationMessageResponse.setMessage(consultantsVO.getName() +" is added as user into database for batch "+consultantsVO.getBatch());
		return applicationMessageResponse;
	}
	
	/**
	 * This method will expose all the configured tests as per techName
	 * @param techName
	 * @return
	 */
	@RequestMapping(value="findTestAndTopicsByTechName",method=RequestMethod.GET)
	@ResponseBody public TestNameTopicsVO findTestAndTopicsByTechName(@RequestParam("techName") String techName){
		List<String> qbankNameList=userAdminCommonService.findQuestionBankByTechName(techName);
		List<String> topics=userAdminCommonService.findTopicsByTechName(techName);
		TestNameTopicsVO testNameTopicsVO=new TestNameTopicsVO();
		testNameTopicsVO.setQbankNameList(qbankNameList);
		testNameTopicsVO.setTopics(topics);
		return testNameTopicsVO;
	}
	
	@RequestMapping(value="deleteTestByTechName",method=RequestMethod.GET)
	@ResponseBody public ApplicationMessageResponse  deleteTestByTechName(@RequestParam("techName") String techName,@RequestParam("testName") String testName,HttpServletRequest request){
		HttpSession session=request.getSession();
		UserId userSession = (UserId) session
				.getAttribute(ApplicationContant.USER_SESSION_DATA);
		
		String status=userAdminCommonService.deleteTestByTechName(techName,testName);
		ApplicationMessageResponse appMsg=new ApplicationMessageResponse();
		appMsg.setStatus(status);
		String imageContextPath=DateUtils.getImageContextPath(request);
		String message="You have delete the test "+testName+" of technology "+techName+" successfully from the database";
		attendanceEmailReminderService.sendConfirmationEmail(message, userSession.getSalutation()+" "+userSession.getName(), userSession.getLoginId(), imageContextPath);
		return appMsg;
	}
	
	
	/**
	 * This method will expose all the configured tests as per techName
	 * @param techName
	 * @return
	 */
	@RequestMapping(value="find-streams",method=RequestMethod.GET)
	@ResponseBody public Map<Integer,String> findStream(){
		List<StreamForm> streamList=streamService.findStreams();
		Map<Integer,String> maps=new  LinkedHashMap<Integer,String>();
		for(StreamForm streamForm : streamList){
			maps.put(streamForm.getSid(), streamForm.getStream());
		}
		return maps;
	}
	
	/**
	 * This method will expose all the configured tests as per techName
	 * @param techName
	 * @return
	 */
	@RequestMapping(value="find-batches",method=RequestMethod.GET)
	@ResponseBody public Map<Integer,String>  findBatches(){
		 List<BatchVO> batchList=userAdminCommonService.findBatches();
		 Map<Integer,String> maps=new  LinkedHashMap<Integer,String>();
			for(BatchVO batchVO : batchList){
				maps.put(batchVO.getBid(), batchVO.getBatch());
			}
			return maps;
	}
	
	
	/**
	 * This method will expose all the configured tests as per techName
	 * @param techName
	 * @return
	 */
	@RequestMapping(value="findConfigureTestsByTechName",method=RequestMethod.GET)
	@ResponseBody public List<String> findConfigureTestsByTechName(@RequestParam("techName") String techName){
		List<String> testsList=userAdminCommonService.findAvailableTestByTechName(techName);
		return testsList;
	}
	
	/**
	 * This method will expose all the configured tests as per techName
	 * @param techName
	 * @return
	 */
	@RequestMapping(value="findConfigureTestDetailsByTechName",method=RequestMethod.GET)
	@ResponseBody public List<TestConfiguration> findConfigureTestDetailsByTechName(@RequestParam("techName") String techName,HttpSession session){
		UserId userId = (UserId) session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		String loginid=userId.getLoginId();
		String role=userId.getRole();
		List<TestConfiguration>  testConfigurationsList=new ArrayList<TestConfiguration>();
		if(ApplicationContant.ADMIN_ROLE.equalsIgnoreCase(role)) {
			if("All".equalsIgnoreCase(techName)) {
				 testConfigurationsList=onlineTechTestServiceImpl.findAllAvailableTest();
				 return testConfigurationsList;
			}else{
				testConfigurationsList=onlineTechTestServiceImpl.findAllAvailableTestByTechName(techName);
				return testConfigurationsList;
			}
		} else  {
			if("All".equalsIgnoreCase(techName)) {
				 testConfigurationsList=onlineTechTestServiceImpl.findAllAvailableTestByUserId(loginid);
				return testConfigurationsList;
			}else{
				testConfigurationsList=onlineTechTestServiceImpl.findAllAvailableTestByUserIdAndTechName(loginid,techName);
				return testConfigurationsList;
			}
		}
		
	}
	
	/**
	 * This method will expose all the configured tests as per techName
	 * @param techName
	 * @return
	 */
	@RequestMapping(value="check-tech-test",method=RequestMethod.GET)
	@ResponseBody ApplicationMessageResponse checkTechTestForTrainer(@RequestParam("techName") String techName,@RequestParam("testName") String testName,HttpSession session){
		UserId userId = (UserId) session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		String loginid=userId.getLoginId();
		String result=onlineTechTestServiceImpl.findTestByUseridTechTestName(loginid,techName,testName);
		ApplicationMessageResponse appMsg=new ApplicationMessageResponse();
		appMsg.setStatus(result);
		return appMsg;
	}
	
	
	@RequestMapping(value="filterConsultantSessionDetailsByTechName",method=RequestMethod.GET)
	@ResponseBody public List<TrainingSessionsDetailVO> filterConsultantSessionDetailsByTechName(@RequestParam("techName") String techName,@RequestParam("loginId") String loginId){
	
		if(logger.isDebugEnabled()) {
			logger.debug("Inside the method filterConsultantSessionDetailsByTechName.");
		}
		
		TechnologyEntity technologyEntity = onlineTechTestServiceImpl.findTechnologyEntityByTechName(techName);
		String techId =Integer.toString(technologyEntity.getId());
		
		List<TrainingSessionsDetailVO> trainingSessionsDetailVOList = onlineTechTestServiceImpl.findTrainingSessionDetailsByUserId(loginId,techId);
		
		for(TrainingSessionsDetailVO trainingSessionsVo : trainingSessionsDetailVOList) {
			trainingSessionsVo.setTechName(techName);
		}
		return trainingSessionsDetailVOList;
	}
	
	
	
	/**
	 * This method will expose all the configured tests as per techName
	 * @param techName
	 * @return
	 */
	@RequestMapping(value="findQuestionBankNameByTechName",method=RequestMethod.GET)
	@ResponseBody public ApplicationMessageResponse findQuestionBankNameByTechName(@RequestParam("techName") String techName,@RequestParam("qbankName") String qbankName){
		List<String> testsList=userAdminCommonService.findQuestionBankByTechName(techName);
		ApplicationMessageResponse appMsg=new ApplicationMessageResponse();
		if(testsList!=null && testsList.contains(qbankName)){
			appMsg.setStatus("yes");
		}else{
				appMsg.setStatus("no");
		}
		return appMsg;
	}
	
	
	/**
	 * This method will expose all the configured tests as per techName
	 * @param techName
	 * @return
	 */
	@RequestMapping(value="check-assign-test-group",method=RequestMethod.GET)
	@ResponseBody public ApplicationMessageResponse checkAssignedTechTestGroup(@RequestParam("groupName") String groupName,@RequestParam("testName") String testName,@RequestParam("techName") String techName){
		boolean status=userAdminCommonService.isTechTestAssignedToGroup(techName,testName,groupName);
		ApplicationMessageResponse appMsg=new ApplicationMessageResponse();
		if(status)
			appMsg.setStatus("yes");
		else
			appMsg.setStatus("no");
		return appMsg;
	}
	
	/**
	 * This method will expose all the configured tests as per techName
	 * @param techName
	 * @return
	 */
	@RequestMapping(value="check-assign-test-consultant",method=RequestMethod.GET)
	@ResponseBody public ApplicationMessageResponse checkAssignedTechTestConsultant(@RequestParam("userid") String userid,@RequestParam("testName") String testName,@RequestParam("techName") String techName){
		boolean status=userAdminCommonService.isTechTestAssignedToConsultant(techName,testName,userid);
		ApplicationMessageResponse appMsg=new ApplicationMessageResponse();
		if(status)
			appMsg.setStatus("yes");
		else
			appMsg.setStatus("no");
		return appMsg;
	}
	
	/**
	 * This method will expose all the configured tests as per techName
	 * @param techName
	 * @return
	 */
	@RequestMapping(value="check-consultantid",method=RequestMethod.GET)
	@ResponseBody public ApplicationMessageResponse checkConsultantId(@RequestParam("consultantId") String consultantId){
		String status=userAdminCommonService.checkConsultantId(consultantId);
		ApplicationMessageResponse appMsg=new ApplicationMessageResponse();
		if(ApplicationContant.SUCCESS.equalsIgnoreCase(status))
			appMsg.setStatus("yes");
		else
			appMsg.setStatus("no");
		return appMsg;
	}
	
	/**
	 * This method will expose all the configured tests as per techName
	 * @param techName
	 * @return
	 */
	@RequestMapping(value="check-batch",method=RequestMethod.GET)
	@ResponseBody public ApplicationMessageResponse checkBatchName(@RequestParam("batch") String batch){
		String status=userAdminCommonService.checkBatchName(batch);
		ApplicationMessageResponse appMsg=new ApplicationMessageResponse();
		if(ApplicationContant.SUCCESS.equalsIgnoreCase(status))
			appMsg.setStatus("yes");
		else
			appMsg.setStatus("no");
		return appMsg;
	}

}
