/**
 * 
 */
package com.techquiz.consultant.attendance;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.techquiz.consultant.attendance.vo.AttendanceBean;
import com.techquiz.consultant.attendance.vo.AttendanceStatusVOWrapper;
import com.techquiz.consultant.attendance.vo.StudentListVO;
import com.techquiz.consultant.attendance.vo.SubjectAssignmentVO;
import com.techquiz.utils.AttendanceJB;

/**
 * @author nagendra.yadav
 *
 */
public interface AttendanceDao {
	public boolean checkMarksFilled(String examId,String subjectCode,String section,String semester,String branch);
	public String checkAttendanceFilled(AttendanceBean attendanceBean,String doclass);
	public AttendanceJB getAttendanceData(int userId);
	public List<StudentListVO> getStudentList(AttendanceBean  form);
	public String saveAttendance(AttendanceBean  form,String dateOfClass,String periodNo,String empCode,String absentStudents,String absRoll,Timestamp sysdate,String status,String[] morePeriods);
	public String deleteAttendanceBySystemKey(String deleteString);
	public ArrayList showAttendanceStatus(AttendanceBean  form,String sysdate);
	public List findLastestTwoAttendance(int  empid);
	public List getStudentListForUpdate(AttendanceBean  form,String doc);
	public int getMaxMarkForTest(String subject,String ctType);
	public List<SubjectAssignmentVO> findAssignTaskByTeacherId(int teacherId);
	public List<AttendanceStatusVOWrapper> showAvgAttendanceStatusInClass(AttendanceBean  form,String sysdate);
	public boolean isUnlockFaculty(String empid);
	public int findLockedDaysByFaculty(String empid);
	public String updateLockPeriodForFaculty(String empid,int lockPeriod);
	public List<String> showAvailablePeriods(String systemKey, String doclass);
	public String checkAttendanceFilledForLab(AttendanceBean attendanceBean,
			String doclass);
	public List<StudentListVO> getStudentListForLab(AttendanceBean form);
	public boolean wasYesterdayHoliday();
	
}
