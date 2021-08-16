package com.techquiz.trainer.web.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.synergisitic.it.navigation.ConsultantNavigationPage;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.util.DateUtils;
import com.synergisitic.it.web.form.UserId;
import com.techquiz.constant.CMSApplicationConstant;
import com.techquiz.consultant.attendance.AttendanceDao;
import com.techquiz.consultant.attendance.vo.AttendanceBean;
import com.techquiz.consultant.attendance.vo.UserApplicationMessage;
import com.techquiz.trainer.service.IConsultantAssesmentService;
import com.techquiz.trainer.web.controller.vo.ConsultantsVO;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {

	@Autowired
	private AttendanceDao attendanceDao;

	@Autowired
	@Qualifier("ConsultantAssesmentService")
	private IConsultantAssesmentService consultantAssesmentService;

	@RequestMapping(value = "consultant-list", method = RequestMethod.GET)
	public String showActiveBatch(Model model) {
		List<String> batchList = consultantAssesmentService.findActiveBatches();
		model.addAttribute("batchList", batchList);
		model.addAttribute("nextAction", "startConsultantInterview");
		model.addAttribute("pageTitle", "Consultant Attendance Page");
		model.addAttribute("nextTitle", "Start");
		return ConsultantNavigationPage.TRAINER_BASE + "attendance-consultant-list";
	}
	
	
	@RequestMapping(value = "/save/success", method = RequestMethod.POST)
	public String saveSuccess(Model model) {
		model.addAttribute(UserApplicationMessage.APPLICATION_MESSAGE,
				"Your Attendance is marked into database successfully.");
		return ConsultantNavigationPage.TRAINER_BASE + "success";
	}
	
	@RequestMapping(value = "/save/success", method = RequestMethod.GET)
	public String saveGetSuccess(Model model) {
		model.addAttribute(UserApplicationMessage.APPLICATION_MESSAGE,
				"Your Attendance is marked into database successfully.");
		return ConsultantNavigationPage.TRAINER_BASE + "success";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String saveAttendance(@RequestParam("cname") String cname, @RequestParam("batchName") String batch,
			@RequestParam("status") String[] status,
			@RequestParam("topicDescription") String topicDescription, @RequestParam(value="doclass",required = false) String calenderDate,
			@RequestParam("operation") String operationName, HttpSession session, Model model) throws ParseException {
		// Setting the unit name and description
		String unit = "VI";
		String period = "4";
		
		List<ConsultantsVO> consultantsVOList = consultantAssesmentService
				.findConsultantsByBatch(batch);
		
		String[] allRolls=new String[consultantsVOList.size()];
		int index=0;
		for(ConsultantsVO consultantsVO:consultantsVOList) {
			allRolls[index]=consultantsVO.getEmpid();
			index++;
		}
		
		AttendanceBean attendanceBean = new AttendanceBean();
		attendanceBean.setUnit(unit);
		attendanceBean.setTopicDescription(topicDescription);
		// G-KUEBIKO-JAN-2012-FS
		attendanceBean.setBranch("Q");
		attendanceBean.setSemester("Java");
		attendanceBean.setSection(batch);
		attendanceBean.setSubCode("TH");
		// 14-05-12
		/*
		 * String doclass = attendanceBean.getDd() + "-" + attendanceBean.getMm() + "-"
		 * + attendanceBean.getYy();
		 */
		String doclass = DateUtils.getJavaCurrentDateYYMMDDFormat();

		// fetching period number from session which one is old
		String speriodNo = attendanceBean.getPeriod();
		// updating new period into the session.
		if (period != null)
			attendanceBean.setPeriod(period);

		UserId userId = (UserId) session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		String empCode = userId.getLoginId();

		// String sysdate =DateUtils.getCurrentDate();
		// String sysdate =DateUtils.getCurrentDateSQLDB();
		// java.sql.Date sysdate = new java.sql.Date(System.currentTimeMillis());
		java.util.Date date = new Date();
		Timestamp sysdate = new Timestamp(date.getTime());

		// stmnt.setDate(1, date);
		if (status == null) {
			status = new String[] {};
		}
		List<String> statusRollList = Arrays.asList(status);
		StringBuilder absRolls = new StringBuilder();

		int noOfAbsentStudent = 0;
		for (int i = 0; i < allRolls.length; i++) {
			if (!statusRollList.contains(allRolls[i])) {
				absRolls.append(allRolls[i] + "-");
				noOfAbsentStudent++;
			}
		}

		String absentStudents = noOfAbsentStudent + "";
		// //System.out.println("THIS IS TYPE OF
		// OPERATION"+request.getParameter("operation"));
		// AttendanceDao attendanceDao = new AttendanceDaoImpl();
		// This is updated because of doclass should be also update
		
		if(status!=null && status.length==0) {
			model.addAttribute(UserApplicationMessage.APPLICATION_MESSAGE,
					"Sorry , you cannot submit blank attendance!!");
			return "redirect:/attendance/consultant-list";
		}
		
		if ("update".equals(operationName)) {
			// String calenderDate=request.getParameter("doclass");
			boolean isDateCorrect = DateUtils.validateCurrentDate(calenderDate);
			if (!isDateCorrect) {
				model.addAttribute(UserApplicationMessage.APPLICATION_MESSAGE,
						"Sorry , you cannot update doclass for future date (" + calenderDate + "), please check it.");
				return "redirect:/attendance/consultant-list";
			}
			calenderDate = DateUtils.convertMMDDYYYYInToYYYYMMDD(calenderDate);
			attendanceBean.setDatepicker(calenderDate);
		}

		/*
		 * if("NEC-101".equalsIgnoreCase(attendanceBean.getSubCode()) && 1085==empCode){
		 * empCode=1234; }
		 */

		// Default lecture type will be Theory class
		if (attendanceBean != null && attendanceBean.getTemp() != null) {
			// MCA-IV-A@.NET TRAINING@MCAT-002@LECTURE
			String tempTokens[] = attendanceBean.getTemp().split("@");
			String labName = tempTokens[3];
			attendanceBean.setLabName(labName);
		} else {
			if (attendanceBean.getLabName() == null) {
				attendanceBean.setLabName(CMSApplicationConstant.SUBJECT_TYPE_LECTURE);
			}
		}

		String[] morePeriods = {};
		String result = attendanceDao.saveAttendance(attendanceBean, doclass, period, empCode, absentStudents,
				absRolls.toString(), sysdate, operationName, morePeriods);
		// String operationName=request.getParameter("operation");
		if ("aexist".equalsIgnoreCase(result)) {
			model.addAttribute(UserApplicationMessage.APPLICATION_MESSAGE,
					"You have already filled this attendance, please check it.");
			return "redirect:/action/attendance/consultant-list";
		}
		if (operationName != null && "update".equals(operationName)) {
			model.addAttribute(UserApplicationMessage.APPLICATION_MESSAGE,
					"Your Attendance is updated into database successfully.");
			return "redirect:/attendance" + ConsultantNavigationPage.TRAINER_BASE + "attendance-consultant-list";
		} else {
			model.addAttribute(UserApplicationMessage.APPLICATION_MESSAGE,
					"Your Attendance is marked into database successfully.");
			return "redirect:/action/attendance/save/success";
		}
		// return mapping.findForward(result);
	}

}
