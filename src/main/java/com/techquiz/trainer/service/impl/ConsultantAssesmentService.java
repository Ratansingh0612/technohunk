package com.techquiz.trainer.service.impl;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.synergisitic.it.model.AssignedTestUser;
import com.synergisitic.it.model.TechnologyEntity;
import com.synergisitic.it.model.User;
import com.synergisitic.it.model.UserOnlineExamStatus;
import com.synergisitic.it.service.GuestUserService;
import com.synergisitic.it.service.TechnolgyCategoryService;
import com.synergisitic.it.service.Userervice;
import com.synergisitic.it.util.DateUtils;
import com.synergisitic.it.web.form.AssignedTestUserForm;
import com.synergisitic.it.web.form.GuestUserForm;
import com.synergisitic.it.web.form.Technology;
import com.synergisitic.it.web.form.UserForm;
import com.techquiz.programys.common.vo.TopicVO;
import com.techquiz.trainer.dao.IConsultantAssesmentDao;
import com.techquiz.trainer.dao.entity.ConsultantScreeningInterviewEntity;
import com.techquiz.trainer.dao.entity.ConsultantScreeningInterviewHistoryEntity;
import com.techquiz.trainer.dao.entity.ConsultantsEntity;
import com.techquiz.trainer.dao.entity.TrainingSessionsDetailEntity;
import com.techquiz.trainer.dao.entity.TrainingSessionsScheduleEntity;
import com.techquiz.trainer.service.IConsultantAssesmentService;
import com.techquiz.trainer.web.controller.vo.ConsultantAssignmentVO;
import com.techquiz.trainer.web.controller.vo.ConsultantQuestionAnswerVO;
import com.techquiz.trainer.web.controller.vo.ConsultantScreeningInterviewHistoryVO;
import com.techquiz.trainer.web.controller.vo.ConsultantScreeningInterviewVO;
import com.techquiz.trainer.web.controller.vo.ConsultantsVO;
import com.techquiz.trainer.web.controller.vo.ScreeningInterviewRatingStatusVO;
import com.techquiz.trainer.web.controller.vo.TrainingSessionsDetailVO;

@Service("ConsultantAssesmentService")
@Scope("singleton")
/**
 * 
 * @author xxx
 *
 */
public class ConsultantAssesmentService implements IConsultantAssesmentService{
	

	@Autowired
	@Qualifier("ConsultantAssesmentDao")
	private IConsultantAssesmentDao consultantAssesmentDao;
	
	@Autowired
	@Qualifier("TechnolgyCategoryServiceImpl")
	private TechnolgyCategoryService technolgyCategoryService;
	
	
	@Autowired
	@Qualifier("usererviceImpl")
	private Userervice userervice;
	
	@Autowired
	@Qualifier("GuestUserServiceImpl")
	private GuestUserService guestUserService;
	
	
	

	@Override
	public List<String> findActiveBatches() {
		return consultantAssesmentDao.findActiveBatches();
	}
	
	/*
	@Override
	public TechnologyEntity findTechNameByLoginId(String loginId) {
	return  consultantAssesmentDao.findTechNameByLoginId(loginId);
	}*/
	
	
	
	
	@Override
	public List<TrainingSessionsDetailVO> findAllSessionsSchedule() {
		List<TrainingSessionsScheduleEntity> trainingSessionsScheduleEntityList=consultantAssesmentDao.findAllSessionsSchedule();
		List<TrainingSessionsDetailVO> trainingSessionsList=new ArrayList<TrainingSessionsDetailVO>();
		for(TrainingSessionsScheduleEntity tsde:trainingSessionsScheduleEntityList){
			//User user=userervice.findUserByLoginId(tsde.getUserid());
			//ConsultantsEntity consultantsEntity=consultantAssesmentDao.findConsultantByUserid(tsde.getUserid());
			TrainingSessionsDetailVO trainingSessionsDetailVO=new TrainingSessionsDetailVO();
			 BeanUtils.copyProperties(tsde, trainingSessionsDetailVO);
			 //trainingSessionsDetailVO.setName(consultantsEntity.getName());
			 trainingSessionsList.add(trainingSessionsDetailVO);
		}
		return trainingSessionsList;
	}
	
	@Override
	public Map<String,String> findActiveBatchesAsMap(){
		return consultantAssesmentDao.findActiveBatchesAsMap();
	}

	@Override
	public List<ConsultantsVO> findConsultantsByBatch(String batchName) {
		List<ConsultantsVO> consultantsVoList=new ArrayList<ConsultantsVO>();
		List<ConsultantsEntity> consultantsEntityList=consultantAssesmentDao.findConsultantsByBatch(batchName);
		for(ConsultantsEntity consultantsEntity:consultantsEntityList){
			ConsultantsVO consultantsVO=new ConsultantsVO();
			BeanUtils.copyProperties(consultantsEntity, consultantsVO,new String[]{"image"});
			consultantsVoList.add(consultantsVO);
		}
		return consultantsVoList;
	}
	
	
	@Override
	public String deleteConsultantByEmailId(String userid) {
		return consultantAssesmentDao.deleteConsultantByEmailId(userid);
	}
	
	@Override
	public List<User> findAllTrainers() {
		return consultantAssesmentDao.findAllTrainers();
	}
	
	@Override
	public List<ConsultantsVO> findAllConsultants() {
		List<ConsultantsVO> consultantsVoList=new ArrayList<ConsultantsVO>();
		List<ConsultantsEntity> consultantsEntityList=consultantAssesmentDao.findAllConsultants();
		for(ConsultantsEntity consultantsEntity:consultantsEntityList) {
			ConsultantsVO consultantsVO=new ConsultantsVO();
			BeanUtils.copyProperties(consultantsEntity, consultantsVO,new String[]{"image"});
			consultantsVoList.add(consultantsVO);
		}
		return consultantsVoList;
	}
	
	@Override
	public byte[] findPhotoByUserId(String userid) {
		return consultantAssesmentDao.findPhotoByUserId(userid);
	}

	@Override
	public ConsultantsVO findConsultantByUserid(String userid) {
		ConsultantsEntity  consultantsEntity=consultantAssesmentDao.findConsultantByUserid(userid);
		ConsultantsVO consultantsVO=new ConsultantsVO();
		BeanUtils.copyProperties(consultantsEntity, consultantsVO);
		return consultantsVO;
	}
	
	@Override
	public ConsultantsVO findConsultantByEmail(String email) {
		ConsultantsEntity  consultantsEntity=consultantAssesmentDao.findConsultantByEmail(email);
		ConsultantsVO consultantsVO=new ConsultantsVO();
		BeanUtils.copyProperties(consultantsEntity, consultantsVO);
		return consultantsVO;
	}
	
	@Override
	public String updateConsultantPasswordByUserid(String userid, String npassword){
		return consultantAssesmentDao.updateConsultantPasswordByUserid(userid, npassword);
	}
	
	@Override
	public String updateConsultantByUserid(ConsultantsVO consultantsVO) {
		ConsultantsEntity consultantsEntity=new ConsultantsEntity();
		BeanUtils.copyProperties(consultantsVO, consultantsEntity);
		return consultantAssesmentDao.updateConsultantByUserid(consultantsEntity);
	}
	
	@Override
	public String persistConsultantScreeningInterview(ConsultantQuestionAnswerVO consultantQuestionAnswerVO) {
		ConsultantScreeningInterviewEntity consultantScreeningInterviewEntity=new ConsultantScreeningInterviewEntity();
		BeanUtils.copyProperties(consultantQuestionAnswerVO, consultantScreeningInterviewEntity);
		String result=consultantAssesmentDao.persistConsultantScreeningInterview(consultantScreeningInterviewEntity);
		return result;
	}
	
	@Override
	public String submitConsultantScreeningInterview(ConsultantQuestionAnswerVO consultantQuestionAnswerVO) {
		ConsultantScreeningInterviewEntity consultantScreeningInterviewEntity=new ConsultantScreeningInterviewEntity();
		BeanUtils.copyProperties(consultantQuestionAnswerVO, consultantScreeningInterviewEntity);
		String result=consultantAssesmentDao.submitConsultantScreeningInterview(consultantScreeningInterviewEntity);
		return result;
	}
	
	@Override
	public List<ConsultantScreeningInterviewVO> findScreeningInterviewsByConsultantUserid(String userid) {
		List<ConsultantScreeningInterviewHistoryEntity> consultantScreeningInterviewHistoryList= consultantAssesmentDao.findScreeningInterviewsByConsultantUserid(userid);
		List<ConsultantScreeningInterviewVO> screeningInteviewsCodes= new ArrayList<ConsultantScreeningInterviewVO>();
		for(ConsultantScreeningInterviewHistoryEntity consultantScreeningInterviewHistoryEntity:consultantScreeningInterviewHistoryList){
			ConsultantScreeningInterviewVO consultantScreeningInterviewVO=new ConsultantScreeningInterviewVO();
			consultantScreeningInterviewVO.setConsultantId(consultantScreeningInterviewHistoryEntity.getConsultantId());
			consultantScreeningInterviewVO.setInterviewId(consultantScreeningInterviewHistoryEntity.getInterviewId());
			consultantScreeningInterviewVO.setDateOfInterview(consultantScreeningInterviewHistoryEntity.getDoe());
			if(!screeningInteviewsCodes.contains(consultantScreeningInterviewVO))
				screeningInteviewsCodes.add(consultantScreeningInterviewVO);
		}
		return screeningInteviewsCodes;
	}

	@Override
	public int findTotalQuestionsByConsultantId(String consultantId) {
		return consultantAssesmentDao.findTotalQuestionsByConsultantId(consultantId);
	}

	@Override
	public List<String> findAllStream() {
		return consultantAssesmentDao.findAllStream();
	}

	@Override
	public String registerConsultant(ConsultantsVO consultantsVO) {
		ConsultantsEntity consultantsEntity=new ConsultantsEntity();
		BeanUtils.copyProperties(consultantsVO,consultantsEntity );
		return consultantAssesmentDao.registerConsultant(consultantsEntity);
	}
	
	@Override
	public String addUserByAdmin(ConsultantsVO consultantsVO) {
		ConsultantsEntity consultantsEntity=new ConsultantsEntity();
		BeanUtils.copyProperties(consultantsVO,consultantsEntity );
		return consultantAssesmentDao.addUserByAdmin(consultantsEntity);
	}
	
	public int findTotalQuestionsFromHistoryByConsultantId(String consultantId,String interviewId){
		List<ConsultantScreeningInterviewHistoryEntity> consultantScreeningInterviewHistoryList=consultantAssesmentDao.findScreeningInterviewStatusDetail(consultantId, interviewId);
		return consultantScreeningInterviewHistoryList!=null?consultantScreeningInterviewHistoryList.size():0;
	}
	
	@Override
	public List<ScreeningInterviewRatingStatusVO>  findScreeningInterviewStatusDetail(
			String consultantId, String interviewId) {
		
		List<ScreeningInterviewRatingStatusVO> interviewRatingStatusVOs=new ArrayList<ScreeningInterviewRatingStatusVO>();
		List<ConsultantScreeningInterviewHistoryEntity> consultantScreeningInterviewHistoryList=consultantAssesmentDao.findScreeningInterviewStatusDetail(consultantId, interviewId);
		///////LOGIC////
	
		List<ConsultantScreeningInterviewHistoryVO> consultantScreeningInterviewHistoryVOs=new ArrayList<ConsultantScreeningInterviewHistoryVO>();
		String preTech="";
		String currentTech="";
		String interviewerUserid="";
		ScreeningInterviewRatingStatusVO interviewRatingStatusVO=null;
		int totalRating=0;  
		int countRecord=0;
		for(ConsultantScreeningInterviewHistoryEntity consultantEntity:consultantScreeningInterviewHistoryList) {
			currentTech=consultantEntity.getTechnology();
			interviewerUserid= consultantEntity.getInterviewerUserid();
			if(!currentTech.equalsIgnoreCase(preTech)) {
				 if(preTech.length()>0) {
					 interviewRatingStatusVO=new ScreeningInterviewRatingStatusVO();
					 Technology technology=technolgyCategoryService.findTechnologyByTid(preTech);
					 interviewRatingStatusVO.setTechnology(technology.getTname());
					 interviewRatingStatusVO.setTechlogo(technology.getShortName());
					 User user=userervice.findUserByLoginId(consultantEntity.getInterviewerUserid());
					 interviewRatingStatusVO.setInterviewerName(user.getFirstName()+" "+user.getLastName());
					 interviewRatingStatusVO.setTotalRating(10+"");
					 float crating=((float)totalRating)/countRecord;
					 setCommentAsPerRating(crating,interviewRatingStatusVO);
					 
					 DecimalFormat df = new DecimalFormat();
					 df.setMaximumFractionDigits(2);
					 interviewRatingStatusVO.setCrating(df.format(crating)+"");
					 interviewRatingStatusVO.setConsultantScreeningInterviewHistoryVOs(consultantScreeningInterviewHistoryVOs);
					 totalRating=0;
					 countRecord=0;
					 interviewRatingStatusVOs.add(interviewRatingStatusVO);
				 }
				 consultantScreeningInterviewHistoryVOs=new ArrayList<ConsultantScreeningInterviewHistoryVO>();
				 ConsultantScreeningInterviewHistoryVO consultantScreeningInterviewHistoryVO=new  ConsultantScreeningInterviewHistoryVO();
				 BeanUtils.copyProperties(consultantEntity, consultantScreeningInterviewHistoryVO);
				 consultantScreeningInterviewHistoryVOs.add(consultantScreeningInterviewHistoryVO);
				 totalRating=totalRating+Integer.parseInt(consultantEntity.getRating());
				 countRecord++;
			}else{
				 ConsultantScreeningInterviewHistoryVO consultantScreeningInterviewHistoryVO=new  ConsultantScreeningInterviewHistoryVO();
				 BeanUtils.copyProperties(consultantEntity, consultantScreeningInterviewHistoryVO);
				 consultantScreeningInterviewHistoryVOs.add(consultantScreeningInterviewHistoryVO);
				 totalRating=totalRating+Integer.parseInt(consultantEntity.getRating());
				 countRecord++;
			}
			preTech=consultantEntity.getTechnology();
		}
		//special case for last records
		 interviewRatingStatusVO=new ScreeningInterviewRatingStatusVO();
		 Technology technology=technolgyCategoryService.findTechnologyByTid(preTech);
		 interviewRatingStatusVO.setTechnology(technology.getTname());
		 interviewRatingStatusVO.setTechlogo(technology.getShortName());
		 User user=userervice.findUserByLoginId(interviewerUserid);
		 interviewRatingStatusVO.setInterviewerName(user.getFirstName()+" "+user.getLastName());
		 interviewRatingStatusVO.setTotalRating(10+"");
		 float crating=((float)totalRating)/countRecord;
		 setCommentAsPerRating(crating,interviewRatingStatusVO);
		 DecimalFormat df = new DecimalFormat();
		 df.setMaximumFractionDigits(2);
		 interviewRatingStatusVO.setCrating(df.format(crating)+"");
		 interviewRatingStatusVO.setConsultantScreeningInterviewHistoryVOs(consultantScreeningInterviewHistoryVOs);
		 interviewRatingStatusVOs.add(interviewRatingStatusVO);
		
		return interviewRatingStatusVOs;
	}
	
	@Override
	public String saveTrainingSessionDetail(
			TrainingSessionsDetailVO trainingSessionsDetailVO){
		TrainingSessionsDetailEntity  trainingSessionsDetailEntity=new TrainingSessionsDetailEntity();
		BeanUtils.copyProperties(trainingSessionsDetailVO, trainingSessionsDetailEntity);
		String result=consultantAssesmentDao.saveTrainingSessionDetail(trainingSessionsDetailEntity);
		return result;
	}
	
	@Override
	public String saveTrainingSessionSchedule(
			TrainingSessionsDetailVO trainingSessionsDetailVO){
		TrainingSessionsScheduleEntity  trainingSessionsScheduleEntity=new TrainingSessionsScheduleEntity();
		BeanUtils.copyProperties(trainingSessionsDetailVO, trainingSessionsScheduleEntity);
		String result=consultantAssesmentDao.saveTrainingSessionSchedule(trainingSessionsScheduleEntity);
		return result;
	}
	
	private void setCommentAsPerRating(float crating,	ScreeningInterviewRatingStatusVO interviewRatingStatusVO){
		 if(crating<5){
			 interviewRatingStatusVO.setComment("Below Average");
		 }
		 else if(crating>=5 && crating<6){
			 interviewRatingStatusVO.setComment("Average");
		 }
		 else if(crating>=6 && crating<8){
			 interviewRatingStatusVO.setComment("Good");
		 }
		 else if(crating>=8){
			 interviewRatingStatusVO.setComment("Excellent");
		 }
	}

	@Override
	public List<TrainingSessionsDetailVO> findConsultantTechnologyStatusBy(String consultantId) {
		
		List<TrainingSessionsDetailEntity> TrainingSessionsDetailEntity=consultantAssesmentDao.findConsultantTechnologyStatusBy(consultantId);
		List<TrainingSessionsDetailVO> trainingSessionsList=new ArrayList<TrainingSessionsDetailVO>();
		for(TrainingSessionsDetailEntity tsde:TrainingSessionsDetailEntity){
			//User user=userervice.findUserByLoginId(tsde.getUserid());
			//ConsultantsEntity consultantsEntity=consultantAssesmentDao.findConsultantByUserid(tsde.getUserid());
			TrainingSessionsDetailVO trainingSessionsDetailVO=new TrainingSessionsDetailVO();
			 BeanUtils.copyProperties(tsde, trainingSessionsDetailVO);
			 //trainingSessionsDetailVO.setName(consultantsEntity.getName());
			 trainingSessionsList.add(trainingSessionsDetailVO);
		}
		
		return trainingSessionsList;
	}
	
	
	@Override
	public AssignedTestUserForm findConsultantTestInfoByUserId(String userId) {
		AssignedTestUser assignedTestUser= (AssignedTestUser) consultantAssesmentDao.findConsultantTestInfoByUserId(userId);
		if(assignedTestUser==null)
			return null;
		AssignedTestUserForm assignedTestUserForm=new AssignedTestUserForm();
		BeanUtils.copyProperties(assignedTestUser, assignedTestUserForm);
		return assignedTestUserForm;
	}
	
	
	
	@Override
	public List<UserForm> findConsultantTestStateByBatchTestTech(String batchName,String techName,String testName) {
		List<ConsultantsEntity> consultantsEntityList= consultantAssesmentDao.findConsultantsByBatch(batchName);
		List<UserForm> userList=new ArrayList<UserForm>(consultantsEntityList.size());
		for(ConsultantsEntity consultantsEntity:consultantsEntityList){
			  UserForm userForm=new UserForm();
			  userForm.setId(consultantsEntity.getCid());
			  userForm.setEmail(consultantsEntity.getEmail());
			  userForm.setFirstName(consultantsEntity.getName());
			  userForm.setLastName("");
			  userForm.setPassword(consultantsEntity.getPassword());
			  userForm.setLoginid(consultantsEntity.getUserid());
			  userForm.setMobile(consultantsEntity.getMobile());
			  userForm.setRole(consultantsEntity.getRole());
			  userList.add(userForm);
		}
		return userList;
	}
	
	@Override
	public List<UserForm> findConsultantByBatch(String batchName) {
		List<ConsultantsEntity> consultantsEntityList= consultantAssesmentDao.findConsultantsByBatch(batchName);
		List<UserForm> userList=new ArrayList<UserForm>(consultantsEntityList.size());
		for(ConsultantsEntity consultantsEntity:consultantsEntityList){
			 UserForm userForm=new UserForm();
			  userForm.setId(consultantsEntity.getCid());
			  userForm.setEmail(consultantsEntity.getEmail());
			  userForm.setFirstName(consultantsEntity.getName());
			  userForm.setLastName("");
			  userForm.setPassword(consultantsEntity.getPassword());
			  userForm.setLoginid(consultantsEntity.getUserid());
			  userForm.setMobile(consultantsEntity.getMobile());
			  userForm.setRole(consultantsEntity.getRole());
			  userForm.setEmpid(consultantsEntity.getEmpid());
			  try {
					//String doj = new SimpleDateFormat("dd-MM-yyyy").format(consultantsEntity.getDoj());
					userForm.setDoj(consultantsEntity.getDoj());
			  }catch(Exception ex){
			  }
			  userList.add(userForm);
		}
		return userList;
	}
	
	/**
	 * 
	 * @param batchName
	 * @param withTestStatus
	 * @return
	 */
	@Override
	public List<UserForm> findConsultantByBatchWithTechTestStatus(String techName,String testName,String batchName,boolean withTestStatus) {
		List<ConsultantsEntity> consultantsEntityList= consultantAssesmentDao.findConsultantsByBatch(batchName);
		List<UserForm> userList=new ArrayList<UserForm>(consultantsEntityList.size());
		for(ConsultantsEntity consultantsEntity:consultantsEntityList){
			  UserForm userForm=new UserForm();
			  if(withTestStatus){
				  UserOnlineExamStatus userOnlineExamStatus=consultantAssesmentDao.findConsultantTestTechtStatus(consultantsEntity.getUserid(), testName, techName, batchName); 
				  userForm.setTechTestStatus(userOnlineExamStatus.getExamStatus());	
				  if(userOnlineExamStatus.getUserId()!=null){
					  double secureMarks=userOnlineExamStatus.getSecureMarks();
					  double marksPer=(secureMarks/userOnlineExamStatus.getTotalMarks())*100;
					  String finalmarksPer= String.format( "%.2f", marksPer);
					  userForm.setScore(finalmarksPer);
					  userForm.setDot(DateUtils.convertDateIntoString(userOnlineExamStatus.getDateOfTest()));
					  userForm.setUserSessionId(userOnlineExamStatus.getUserSessionId());
				  }else{
					  userForm.setScore("0.00");
					  userForm.setDot("NA");
				  }
			  }
			  userForm.setId(consultantsEntity.getCid());
			  userForm.setEmail(consultantsEntity.getEmail());
			  userForm.setFirstName(consultantsEntity.getName());
			  userForm.setLastName("");
			  userForm.setEmpid(consultantsEntity.getEmpid());
			  userForm.setPassword(consultantsEntity.getPassword());
			  userForm.setLoginid(consultantsEntity.getUserid());
			  userForm.setMobile(consultantsEntity.getMobile());
			  userForm.setRole(consultantsEntity.getRole());
			  userList.add(userForm);
		}
		return userList;
	}
	
	
	/**
	 * 
	 * @param batchName
	 * @param withTestStatus
	 * @return
	 */
	@Override
	public List<UserForm> findGuestResetTestHistoryWithNameEmail(String searchString,boolean withTestStatus) {
		List<GuestUserForm>  guestUsersList= guestUserService.findGuestUserWithSearchString(searchString);
		List<UserForm> userList=new ArrayList<UserForm>(guestUsersList.size());
		for(GuestUserForm guestUserForm:guestUsersList){
			  UserForm userForm=new UserForm();
			  if(withTestStatus){
				  UserOnlineExamStatus userOnlineExamStatus=guestUserService.findGuestTestTechtStatus(guestUserForm.getEmail(),guestUserForm.getUserSessionId(), "All", "All"); 
				  if(userOnlineExamStatus.getId()==0){
					  continue; //means test is not present inside UserOnlineExamStatus table
				  }
				  userForm.setTechTestStatus(guestUserForm.getTestStatus());	
				  if(userOnlineExamStatus.getUserId()!=null){
					  double secureMarks=userOnlineExamStatus.getSecureMarks();
					  double marksPer=(secureMarks/userOnlineExamStatus.getTotalMarks())*100;
					  String finalmarksPer= String.format( "%.2f", marksPer);
					  userForm.setScore(finalmarksPer);
					  userForm.setDot(DateUtils.convertDateIntoString(userOnlineExamStatus.getDateOfTest()));
					  userForm.setUserSessionId(userOnlineExamStatus.getUserSessionId());
					  userForm.setTechName(userOnlineExamStatus.getTechName());
					  userForm.setTestName(userOnlineExamStatus.getTestName());
				  }else{
					  userForm.setScore("0.00");
					  userForm.setDot("NA");
					  userForm.setTechName("NA");
					  userForm.setTestName("NA");
				  }
			  }
			  userForm.setId((int)guestUserForm.getGid());
			  userForm.setEmail(guestUserForm.getEmail());
			  userForm.setFirstName(guestUserForm.getName());
			  userForm.setLastName("");
			  userForm.setPassword("test");
			  userForm.setLoginid(guestUserForm.getEmail());
			  userForm.setMobile(guestUserForm.getMobile());
			  userForm.setRole("guest");
			  userList.add(userForm);
		}
		return userList;
	}
	
	
	/**
	 * 
	 * @param batchName
	 * @param withTestStatus
	 * @return
	 */
	@Override
	public List<UserForm> findGuestTestHistoryByEmail(String email,boolean withTestStatus) {
		GuestUserForm  guestUserForm= guestUserService.findGuestByEmailId(email);
		List<GuestUserForm>  guestUsersList=new ArrayList<GuestUserForm>();
		if(guestUserForm.getGid()!=0) {
			guestUsersList.add(guestUserForm);
		}
		return processTestResult(guestUsersList,withTestStatus);
	}
	
	
	/**
	 * 
	 * @param batchName
	 * @param withTestStatus
	 * @return
	 */
	@Override
	public List<UserForm> findGuestTestHistoryWithNameEmail(String searchString,boolean withTestStatus) {
		List<GuestUserForm>  guestUsersList= guestUserService.findGuestUserWithSearchString(searchString);
		return processTestResult(guestUsersList,withTestStatus);
	}
	
	private List<UserForm> processTestResult(List<GuestUserForm>  guestUsersList,boolean withTestStatus){
		//filtering as per email
	    Set<GuestUserForm> guestUniqueUserLists=new LinkedHashSet<GuestUserForm>(guestUsersList);
		List<UserForm> userList=new ArrayList<UserForm>(guestUniqueUserLists.size());
		for(GuestUserForm guestUserForm:guestUniqueUserLists){
			  if(withTestStatus) {
				  List<UserOnlineExamStatus> userOnlineExamStatusList=guestUserService.findGuestTestTechtStatus(guestUserForm.getEmail()) ;
				  for(UserOnlineExamStatus userOnlineExamStatus:userOnlineExamStatusList) {
					  UserForm userForm=new UserForm();
					  double secureMarks=userOnlineExamStatus.getSecureMarks();
					  double marksPer=(secureMarks/userOnlineExamStatus.getTotalMarks())*100;
					  String finalmarksPer= String.format( "%.2f", marksPer);
					  userForm.setScore(finalmarksPer);
					  userForm.setDot(DateUtils.convertDateIntoString(userOnlineExamStatus.getDateOfTest()));
					  userForm.setUserSessionId(userOnlineExamStatus.getUserSessionId());
					  userForm.setTechName(userOnlineExamStatus.getTechName());
					  userForm.setTestName(userOnlineExamStatus.getTestName());	  
					  userForm.setTechTestStatus(userOnlineExamStatus.getExamStatus());
					  userForm.setId((int)guestUserForm.getGid());
					  userForm.setEmail(guestUserForm.getEmail());
					  userForm.setFirstName(guestUserForm.getName());
					  userForm.setLastName("");
					  userForm.setPassword("test");
					  userForm.setLoginid(guestUserForm.getEmail());
					  userForm.setMobile(guestUserForm.getMobile());
					  userForm.setRole("guest");
					  userList.add(userForm);
				  }	  
			  }else{
				  UserForm userForm=new UserForm();				  
				  userForm.setTechName("NA");
				  userForm.setTestName("NA");	  
				  userForm.setId((int)guestUserForm.getGid());
				  userForm.setEmail(guestUserForm.getEmail());
				  userForm.setFirstName(guestUserForm.getName());
				  userForm.setLastName("");
				  userForm.setPassword("test");
				  userForm.setLoginid(guestUserForm.getEmail());
				  userForm.setMobile(guestUserForm.getMobile());
				  userForm.setRole("guest");
				  userList.add(userForm);
			  }
		}	  
			  return userList;
	}
	
	/**
	 * 
	 * @param batchName
	 * @param withTestStatus
	 * @return
	 */
	@Override
	public List<UserForm> findConsultantWithTechTestStatus(String techName,String testName,boolean withTestStatus) {
		List<GuestUserForm>  guestUsersList= guestUserService.findGuestUser();
		List<UserForm> userList=new ArrayList<UserForm>(guestUsersList.size());
		for(GuestUserForm guestUserForm:guestUsersList){
			  UserForm userForm=new UserForm();
			  if(withTestStatus){
				  UserOnlineExamStatus userOnlineExamStatus=guestUserService.findGuestTestTechtStatus(guestUserForm.getEmail(),guestUserForm.getUserSessionId(), testName, techName); 
				  userForm.setTechTestStatus(userOnlineExamStatus.getExamStatus());	
				  if(userOnlineExamStatus.getUserId()!=null){
					  double secureMarks=userOnlineExamStatus.getSecureMarks();
					  double marksPer=(secureMarks/userOnlineExamStatus.getTotalMarks())*100;
					  String finalmarksPer= String.format( "%.2f", marksPer);
					  userForm.setScore(finalmarksPer);
					  userForm.setDot(DateUtils.convertDateIntoString(userOnlineExamStatus.getDateOfTest()));
					  userForm.setUserSessionId(userOnlineExamStatus.getUserSessionId());
					  userForm.setTechName(userOnlineExamStatus.getTechName());
					  userForm.setTestName(userOnlineExamStatus.getTestName());
				  }else{
					  userForm.setScore("0.00");
					  userForm.setDot("NA");
					  userForm.setTechName("NA");
					  userForm.setTestName("NA");
				  }
			  }
			  userForm.setId((int)guestUserForm.getGid());
			  userForm.setEmail(guestUserForm.getEmail());
			  userForm.setFirstName(guestUserForm.getName());
			  userForm.setLastName("");
			  userForm.setPassword("test");
			  userForm.setLoginid(guestUserForm.getEmail());
			  userForm.setMobile(guestUserForm.getMobile());
			  userForm.setRole("guest");
			  userList.add(userForm);
		}
		return userList;
	}
	
	@Override
	public UserOnlineExamStatus findConsultantTestTechtStatus(String userid,String testName,String techName,String groupName) {
		return consultantAssesmentDao.findConsultantTestTechtStatus(userid, testName, techName, groupName);
	}	

	@Override
	public List<AssignedTestUserForm> findConsultantByTrainerIdTestName(String tid,String testName){
			List<AssignedTestUser> consultantListDao=consultantAssesmentDao.findConsultantByTrainerIdTestName(tid,testName);
			List<AssignedTestUserForm> consultantListCtrl=new ArrayList<AssignedTestUserForm>();
			for(AssignedTestUser consultantDao:consultantListDao){
				AssignedTestUserForm consultantCtrl=new AssignedTestUserForm();
				consultantCtrl.setAssignedTestCompositeKey(consultantDao.getAssignedTestCompositeKey());
				consultantCtrl.setTechName(consultantDao.getAssignedTestCompositeKey().getTechName());
				consultantCtrl.setUserId(consultantDao.getAssignedTestCompositeKey().getUserId());
				consultantCtrl.setAssignDate(consultantDao.getAssignDate());
				consultantCtrl.setTestExpireOn(consultantDao.getTestExpireOn());
				consultantCtrl.setTestExpireTimeInHrs(consultantDao.getTestExpireTimeInHrs());
				consultantCtrl.setModifyBy(consultantDao.getModifyBy());
				consultantCtrl.setTestStatus(consultantDao.getTestStatus());
				consultantCtrl.setLink(consultantDao.getLink());
				consultantCtrl.setAttamptLimit(consultantDao.getAttamptLimit());
				consultantCtrl.setNumberOfQuestions(consultantDao.getNumberOfQuestions());
				consultantCtrl.setDurationInMin(consultantDao.getDurationInMin());
				consultantCtrl.setGroupName(consultantDao.getGroupName());
				consultantCtrl.setResetDate(consultantDao.getResetDate());
				consultantListCtrl.add(consultantCtrl);
			}
			
			return consultantListCtrl;
		}

	   @Override
		
	public Map<Integer,String> findAllLanguages() {
		   List<com.synergisitic.it.model.TechnologyEntity> languageList=consultantAssesmentDao.findAllLanguages();
		Map<Integer,String> llist=new LinkedHashMap<Integer,String>();
		for(TechnologyEntity t:languageList){
			llist.put(t.getId(),t.getTname());
			
		}
		return llist;
	}

	@Override
	public List<String> findAvailableCourses() {
		return consultantAssesmentDao.findAvailableCourses();
	}


	@Override
	public Map<String, String> fetchAllTopics() {
		List<TopicVO> topicList=consultantAssesmentDao.fetchAllTopics();
		Map<String,String>ttlist=new LinkedHashMap<String, String>();
		for(TopicVO topvo:topicList){
			ttlist.put(topvo.getTid(),topvo.getTopic());
		}
		return ttlist;
	}

	@Override
	public String addAssignmentToConsultant(ConsultantAssignmentVO assignmentVO) {
		return null;
	}

//	@Override
//	public List<CourseContentsDetailVO> findAllCoverdTopics(String topicid, String courseId) {
//		List<CourseContentsEntity> courseContentsEntityList=consultantAssesmentDao .findAllCoverdTopics(topicid, courseId);
//		List<CourseContentsDetailVO> courseContentsDetailVO=new ArrayList<CourseContentsDetailVO>();
//		for(CourseContentsEntity ccEntity:courseContentsEntityList)
//		{
//			CourseContentsDetailVO courseContentsDetailvo=new CourseContentsDetailVO();
//			BeanUtils.copyProperties(ccEntity, courseContentsDetailvo);
//			courseContentsDetailVO.add(courseContentsDetailvo);
//			
//		}
//		return courseContentsDetailVO;
//	}

	@Override
	public List<UserForm> findAllConsultantsWithSearchString(String key) {
		List<ConsultantsEntity> consultantsEntityList= consultantAssesmentDao.findAllConsultantsWithSearchString(key);
		List<UserForm> userList=new ArrayList<UserForm>(consultantsEntityList.size());
		for(ConsultantsEntity consultantsEntity:consultantsEntityList){
			 UserForm userForm=new UserForm();
			  userForm.setId(consultantsEntity.getCid());
			  userForm.setEmpid(consultantsEntity.getEmpid());
			  userForm.setBatch(consultantsEntity.getBatch());
			  userForm.setEmail(consultantsEntity.getEmail());
			  userForm.setFirstName(consultantsEntity.getName());
			  userForm.setLastName("");
			  userForm.setPassword(consultantsEntity.getPassword());
			  userForm.setLoginid(consultantsEntity.getUserid());
			  userForm.setMobile(consultantsEntity.getMobile());
			  userForm.setRole(consultantsEntity.getRole());
			  userList.add(userForm);
		}
		return userList;
	}
	
	

	
}
