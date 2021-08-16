/**
 * 
 */
package com.techquiz.consultant.attendance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import org.springframework.stereotype.Repository;

import com.synergisitic.it.util.DateUtils;
import com.techquiz.constant.CMSApplicationConstant;
import com.techquiz.consultant.attendance.vo.AttendanceBean;
import com.techquiz.consultant.attendance.vo.AttendanceStatusVO;
import com.techquiz.consultant.attendance.vo.AttendanceStatusVOWrapper;
import com.techquiz.consultant.attendance.vo.StudentListVO;
import com.techquiz.consultant.attendance.vo.SubjectAssignmentVO;
import com.techquiz.consultant.attendance.vo.SubjectCodeBatchEntity;
import com.techquiz.utils.AttendanceJB;
import com.techquiz.utils.TechnohunkConnectionPool;

/**
 * This is concrete class for accessing information from the database for the
 * attendance of the students
 * 
 * @author nagendra.yadav
 * 
 */

@Repository
public class AttendanceDaoImpl implements AttendanceDao {
	
	@Override
	public boolean wasYesterdayHoliday() 	{
		String currentDate = DateUtils.getCurrentCalendarDate();
		String previousDate = DateUtils.previousDate(currentDate, 1);
		ResultSet rs = null;
		 PreparedStatement pstmt = null;
	     Connection connection = null;
	     try {
	    	 	connection = TechnohunkConnectionPool.getDbConnection();
	    	 	pstmt = connection.prepareStatement("select cdate from holiday_entry_tbl where cdate=? and weekend='no'");
	    	 	pstmt.setString(1, previousDate);
	    	 	rs = pstmt.executeQuery();
	    	 	if (rs.next())
	    	 			return true;
	     	}
	     	catch (SQLException exe) {
	     		exe.printStackTrace();
	     	} finally {
				       try {
				    	   if (connection != null)
				    		   			connection.close();
				    	   				if (rs != null)
				           rs.close();
				        if (pstmt != null)
				           pstmt.close();
				       }
				       catch (Exception localException2) {
				       }
    }
    return false;
  }
	
	@Override
	public String checkAttendanceFilledForLab(AttendanceBean attendanceBean,
			String doclass) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection connection = null;
		String systemKey = attendanceBean.getBranch() + "-"
				+ attendanceBean.getSemester() + "-"
				+ attendanceBean.getSection() + "-"
				+ attendanceBean.getSubCode();
		String likeSystemKey = attendanceBean.getBranch() + "-"
				+ attendanceBean.getSemester() + "-"
				+ attendanceBean.getSection() + "-";
		final String checkPeriodQuery = "SELECT SYSTEM_KEY from attendances as att where  att.SYSTEM_KEY  LIKE '"
				+ likeSystemKey + "%'  and att.DOCLASS=? and att.PERIOD_NO=?  and CLASS_NAME=?";
		final String query = "SELECT SYSTEM_KEY from attendances as att where  att.SYSTEM_KEY=? and att.DOCLASS=? and att.PERIOD_NO=? and CLASS_NAME=?";
		String reason = "goahead";
		try {
			connection = TechnohunkConnectionPool.getDbConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, systemKey);
			pstmt.setString(2, doclass);
			pstmt.setString(3, attendanceBean.getPeriod());
			pstmt.setString(4, attendanceBean.getLabName());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				reason = "youfilled";
			} else {
				if(pstmt!=null){
					pstmt.close();
				}
				pstmt = connection.prepareStatement(checkPeriodQuery);
				pstmt.setString(1, doclass);
				pstmt.setString(2, attendanceBean.getPeriod());
				pstmt.setString(3, attendanceBean.getLabName());
				if(rs!=null){
					rs.close();
				}
				rs = pstmt.executeQuery();
				int findName = 0;
				if (rs.next()) {
					findName = 1;
					reason = rs.getString(1);

				}
				if (findName == 1) {
					String facultyDetailQuery = "select CONCAT(f.FIRST_NAME,' (',f.EMP_ID,')') as Name from faculty_members as f,subject_assignment as s where s.BR_SEM_SEC=?  and s.SUB_CODE=? and f.EMP_ID=s.USER_ID";
					String brsem = attendanceBean.getBranch() + "-"
							+ attendanceBean.getSemester() + "-"
							+ attendanceBean.getSection();
					String tokens[] = reason.split("-");
					String subjectCode = tokens[3] + "-" + tokens[4];
					pstmt = connection.prepareStatement(facultyDetailQuery);
					pstmt.setString(1, brsem);
					pstmt.setString(2, subjectCode);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						reason = reason + " (" + rs.getString(1) + ")";
					}
				}

			}
		} catch (SQLException exe) {
			exe.printStackTrace();
		} finally {
			try {
				if (connection != null)
					if (pstmt != null)
						pstmt.close();
				if (rs != null)
					rs.close();

				connection.close();
			} catch (Exception exe) {
			}
		}
		return reason;
	}


	@Override
	public String checkAttendanceFilled(AttendanceBean attendanceBean,
			String doclass) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection connection = null;
		String systemKey = attendanceBean.getBranch() + "-"
				+ attendanceBean.getSemester() + "-"
				+ attendanceBean.getSection() + "-"
				+ attendanceBean.getSubCode();
		String likeSystemKey = attendanceBean.getBranch() + "-"
				+ attendanceBean.getSemester() + "-"
				+ attendanceBean.getSection() + "-";
		final String checkPeriodQuery = "SELECT SYSTEM_KEY from attendances as att where  att.SYSTEM_KEY  LIKE '"
				+ likeSystemKey + "%'  and att.DOCLASS=? and att.PERIOD_NO=?";
		final String query = "SELECT SYSTEM_KEY from attendances as att where  att.SYSTEM_KEY=? and att.DOCLASS=? and att.PERIOD_NO=?";
		String reason = "goahead";
		try {
			connection = TechnohunkConnectionPool.getDbConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, systemKey);
			pstmt.setString(2, doclass);
			pstmt.setString(3, attendanceBean.getPeriod());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				reason = "youfilled";
			} else {
				pstmt = connection.prepareStatement(checkPeriodQuery);
				pstmt.setString(1, doclass);
				pstmt.setString(2, attendanceBean.getPeriod());
				rs = pstmt.executeQuery();
				int findName = 0;
				if (rs.next()) {
					findName = 1;
					reason = rs.getString(1);

				}
				if (findName == 1) {
					String facultyDetailQuery = "select CONCAT(f.FIRST_NAME,' (',f.EMP_ID,')') as Name from faculty_members as f,subject_assignment as s where s.BR_SEM_SEC=?  and s.SUB_CODE=? and f.EMP_ID=s.USER_ID";
					String brsem = attendanceBean.getBranch() + "-"
							+ attendanceBean.getSemester() + "-"
							+ attendanceBean.getSection();
					String tokens[] = reason.split("-");
					String subjectCode = tokens[3] + "-" + tokens[4];
					pstmt = connection.prepareStatement(facultyDetailQuery);
					pstmt.setString(1, brsem);
					pstmt.setString(2, subjectCode);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						reason = reason + " (" + rs.getString(1) + ")";
					}
				}

			}
		} catch (SQLException exe) {
			exe.printStackTrace();
		} finally {
			try {
				if (connection != null)
					if (pstmt != null)
						pstmt.close();
				if (rs != null)
					rs.close();

				connection.close();
			} catch (Exception exe) {
			}
		}
		return reason;
	}

	/**
	 * Fetching all the list of student for particular branch section changes;
	 */
	@Override
	public boolean isUnlockFaculty(String empid) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection connection = null;
		final String query = "select locked from  login_info where USER_ID='"
				+ empid + "'";
		;
		try {
			connection = TechnohunkConnectionPool.getDbConnection();
			pstmt = connection.prepareStatement(query);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String status = rs.getString(1);
				if ("n".equalsIgnoreCase(status)) {
					return true;
				}
			}
		} catch (SQLException exe) {
			exe.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception exe) {
			}
		}
		return false;
	}

	/**
	 * Fetching all the list of student for particular branch section changes;
	 */
	@Override
	public boolean checkMarksFilled(String examId, String subjectCode,
			String section, String semester, String branch) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection connection = null;
		final String query = "SELECT F_LIB_ID from marks as m where  m.EXAM_ID=? and m.F_SUBJECT_CODE=? and m.SECTION=? and m.SEMESTER=? and m.BRANCH=?";
		try {
			connection = TechnohunkConnectionPool.getDbConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, examId);
			pstmt.setString(2, subjectCode);
			pstmt.setString(3, section);
			pstmt.setString(4, semester);
			pstmt.setString(5, branch);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException exe) {
			exe.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception exe) {
			}
		}
		return false;
	}
	
	
	/**
	 * Fetching all the list of student for particular branch section changes;
	 */
	@Override
	public List<StudentListVO> getStudentListForLab(AttendanceBean form) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection connection = null;
		// SELECT CONCAT(v.first_name ,' ',v.middle_name,' ',v.last_name) FROM
		// students v;
		// Here I have changed the query because of ordering of student list on
		// attendance mark page.
		// new ordercol is introduced here.
		final String query = "SELECT b.f_lib_id,CONCAT(v.first_name ,' ',v.middle_name,' ',v.last_name),b.ROLL,b.ordercol  FROM branch_section_changes b, students v,students_lab_tbl  s WHERE b.branch =? AND b.semester =?  AND b.section=? AND b.f_lib_id = v.lib_id"
				+ " AND s.subjectCode=? AND s.student_id=v.lib_id AND s.labName=? order by b.f_lib_id  asc";
		List<StudentListVO> studentList = new ArrayList<StudentListVO>();
		int roll = 1;
		try {
			connection = TechnohunkConnectionPool.getDbConnection();
			Statement stmt = connection.createStatement();
			// System.out.println("hello this is record"+form.getSubject());

			// rs=stmt.executeQuery("select subject_code from subjects where subject_name='"+form.getSubject()+"'");

			// String subCode=null;
			// if(rs.next())
			// {
			// subCode=rs.getString(1);
			// //System.out.println("inside the if"+subCode);
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, form.getBranch());
			pstmt.setString(2, form.getSemester());
			pstmt.setString(3, form.getSection());
			pstmt.setString(4, form.getSubCode());
			pstmt.setString(5,form.getLabName());
			rs = pstmt.executeQuery();
			System.out.println(("______  = "+pstmt.toString()));
			while (rs.next()) {
				studentList.add(new StudentListVO(rs.getString(1), rs
						.getString(2), rs.getString(3), rs.getInt(4)));
				roll++;
				// }//end of while

			}
		} catch (SQLException exe) {
			// System.out.println("This is exception.."+exe.getMessage());
			exe.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception exe) {
			}
		}
		if (roll == 1)
			studentList = null;
		return studentList;
	}


	/**
	 * Fetching all the list of student for particular branch section changes;
	 */
	@Override
	public List<StudentListVO> getStudentList(AttendanceBean form) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection connection = null;
		// SELECT CONCAT(v.first_name ,' ',v.middle_name,' ',v.last_name) FROM
		// students v;
		// Here I have changed the query because of ordering of student list on
		// attendance mark page.
		// new ordercol is introduced here.
		final String query = "SELECT b.f_lib_id,CONCAT(v.first_name ,' ',v.middle_name,' ',v.last_name),b.ROLL,b.ordercol  FROM branch_section_changes b, students v,std_subjects  s WHERE b.branch =? AND b.semester =?  AND b.section=? AND b.f_lib_id = v.lib_id"
				+ " AND s.f_subject_code=? AND s.f_lib_id=v.lib_id order by b.f_lib_id  asc";
		List<StudentListVO> studentList = new ArrayList<StudentListVO>();
		int roll = 1;
		try {
			connection = TechnohunkConnectionPool.getDbConnection();
			Statement stmt = connection.createStatement();
			// System.out.println("hello this is record"+form.getSubject());

			// rs=stmt.executeQuery("select subject_code from subjects where subject_name='"+form.getSubject()+"'");

			// String subCode=null;
			// if(rs.next())
			// {
			// subCode=rs.getString(1);
			// //System.out.println("inside the if"+subCode);
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, form.getBranch());
			pstmt.setString(2, form.getSemester());
			pstmt.setString(3, form.getSection());
			pstmt.setString(4, form.getSubCode());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				studentList.add(new StudentListVO(rs.getString(1), rs
						.getString(2), rs.getString(3), rs.getInt(4)));
				roll++;
				// }//end of while

			}
		} catch (SQLException exe) {
			// System.out.println("This is exception.."+exe.getMessage());
			exe.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception exe) {
			}
		}
		if (roll == 1)
			studentList = null;
		return studentList;
	}

	public AttendanceJB getAttendanceData(int userId) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection connection = null;
		final String query = "select subject_name,br_sem_sec from subject_assignment where user_id=5990";
		Set subjectSet = new HashSet(4);
		Set branchSet = new HashSet(4);
		Set semesterSet = new HashSet(4);
		Set sectionSet = new HashSet(4);
		AttendanceJB attendanceJB = null;

		int status = 0;
		try {
			connection = TechnohunkConnectionPool.getDbConnection();
			pstmt = connection.prepareStatement(query);
			// System.out.println(userId);
			// pstmt.setInt(1,userId);
			rs = pstmt.executeQuery();
			StringTokenizer token = null;

			while (rs.next()) {

				subjectSet.add(rs.getString(1));
				token = new StringTokenizer(rs.getString(2), "-");
				if (token.hasMoreTokens()) {
					branchSet.add((token.nextToken()).trim());
				}
				if (token.hasMoreTokens()) {
					semesterSet.add((token.nextToken()).trim());
				}
				if (token.hasMoreTokens()) {
					sectionSet.add((token.nextToken()).trim());
					// System.out.println("sectionset"+sectionSet);
				}

				status = 1;
				// System.out.println("hello");

			}// end of while
		} catch (SQLException exe) {
			// System.out.println("This is exception.."+exe.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception exe) {
			}
		}
		if (status == 1) {

			return attendanceJB = new AttendanceJB(subjectSet, branchSet,
					semesterSet, sectionSet);
		} else
			return attendanceJB;

	}

	public String saveAttendance(AttendanceBean form, String dateOfClass,
			String periodNo, String empCode, String absentStudents,
			String absRoll, Timestamp sysdate, String status,String[] morePeriods) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection connection = null;

		boolean flag = false;
		Statement stmt = null;

		final String query = "insert into attendances(SYSTEM_KEY,DOCLASS,AB_ROLLS,PERIOD_NO,EMP_CODE,NO_ABSENT,DOENTRY,UNIT,TOPIC_DESCRIPTION,DAY_PERIOD,CLASS_NAME) values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			connection = TechnohunkConnectionPool.getDbConnection();
			connection.setAutoCommit(false);
			stmt = connection.createStatement();
			
			String dayOfClass=DateUtils.findDayAsPerDate(dateOfClass);
			StringBuilder periodsTokensForDay=new StringBuilder(dayOfClass);
			 
			String systemKey = form.getBranch() + "-" + form.getSemester()
					+ "-" + form.getSection() + "-" + form.getSubCode();

			if (!status.equals("update")) {
				pstmt = connection.prepareStatement(query);
				pstmt.setString(1, systemKey);
				pstmt.setString(2, dateOfClass);
				pstmt.setString(3, absRoll);
				pstmt.setString(4, periodNo);
				pstmt.setString(5, empCode);
				pstmt.setString(6, absentStudents);
				//pstmt.setDate(7, sysdate);
				pstmt.setTimestamp(7, sysdate);
				pstmt.setString(8, form.getUnit());
				pstmt.setString(9, form.getTopicDescription());
				pstmt.setString(10, periodsTokensForDay.toString());
				pstmt.setString(11,form.getLabName());
				flag = pstmt.execute();
				if(morePeriods!=null && morePeriods.length>0){
					for(String cperiod:morePeriods){
						pstmt.clearParameters();
						pstmt.setString(1, systemKey);
						pstmt.setString(2, dateOfClass);
						pstmt.setString(3, absRoll);
						pstmt.setString(4, cperiod);
						pstmt.setString(5, empCode);
						pstmt.setString(6, absentStudents);
						//pstmt.setDate(7, sysdate);
						pstmt.setTimestamp(7, sysdate);
						pstmt.setString(8, form.getUnit());
						pstmt.setString(9, form.getTopicDescription());
						pstmt.setString(10, periodsTokensForDay.toString());
						pstmt.setString(11,form.getLabName());
						flag = pstmt.execute();
					}
				}
			} else {
				stmt.executeUpdate("update attendances set ab_rolls='"
						+ absRoll + "' ,doclass='" + form.getDatepicker()
						+ "',PERIOD_NO='" + form.getPeriod() + "', NO_ABSENT='"
						+ absentStudents + "' , UNIT='" + form.getUnit()
						+ "', TOPIC_DESCRIPTION='" + form.getTopicDescription()
						+ " ' " + "where system_key='" + systemKey
						+ "' and doclass='" + dateOfClass + "' and period_no="
						+ periodNo);
				// //System.out.println("UPDATING THE ATTENDANCE");
				flag = false;
			}

		} catch (Exception exe) {
			System.out.println("This is exception.." + exe.getMessage());
			exe.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return "aexist";
		} finally {
			try {
				if (connection != null){
					connection.commit();
					connection.close();
					
				}	
				if (rs != null)
					rs.close();
				if (pstmt != null) {
					pstmt.close();
					stmt.close();
				}
			} catch (Exception exe) {
				exe.printStackTrace();
			}
		}
		if (!flag)
			return "success";
		else
			return "failure";
	}

	/**
	 * This method is used to show the attendance status of a particular class
	 * 
	 * @see com.crescendo.dao.AttendanceDao#showAttendanceStatus(com.crescendo.attendance.formbean.AttendanceBean,
	 *      java.lang.String)
	 */
	public ArrayList<AttendanceStatusVO> showAttendanceStatus(
			AttendanceBean form, String sysdate) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection connection = null;
		ArrayList<AttendanceStatusVO> attendanceStatusList = new ArrayList<AttendanceStatusVO>();
		// final String
		// query="select TO_CHAR(doclass,'DD-MON-YY'),ab_rolls,period_no,no_absent,system_key,unit,topic_description from attendances where system_key=? and doclass<=?  order by doclass";
		 final String query = "select  DATE_FORMAT(doclass, '%d-%b-%y'),ab_rolls,period_no,no_absent,system_key,unit,topic_description from attendances where system_key=? and doclass<=?  and CLASS_NAME=? order by doclass";
		// stmt.executeUpdate("insert into attendances values('"+systemkey+"','"+toSend1[5]+"','"+absentRollNumber+"','"+toSend1[4]+"',"+Integer.parseInt(emp_code.trim())+",'"+no_of_absent+"','"+sysdate+"')");
		try {
			connection = TechnohunkConnectionPool.getDbConnection();
			Statement stmt = connection.createStatement();
			/*
			 * rs=stmt.executeQuery(
			 * "select subject_code from subjects where subject_name='"
			 * +form.getSubject()+"'"); String subCode=null; if(rs.next())
			 * subCode=rs.getString(1);
			 */
			String subCode = form.getSubCode();
			String uptech[][] = new String[200][2];
			/*
			 * rs = stmt .executeQuery(
			 * "SELECT f_lib_id,roll FROM branch_section_changes  WHERE branch = '"
			 * + form.getBranch() + "'" + " AND semester = '" +
			 * form.getSemester() + "'" + " AND section='" + form.getSection() +
			 * "'" + " ORDER BY  (0 + ROLL)  asc");
			 */
			
			
			// New Query for Elective
			 String dquery=null;
			if(form.isSubjectLab()) {
			   dquery = "SELECT b.f_lib_id,b.roll FROM branch_section_changes b, students v,students_lab_tbl  s WHERE b.branch ='"
					+ form.getBranch()
					+ "' AND b.semester ='"
					+ form.getSemester()
					+ "' AND b.section='"
					+ form.getSection()
					+ "' AND b.f_lib_id = v.lib_id"
					+ " AND s.subjectCode='"
					+ form.getSubCode()
					+ "' AND s.student_id=v.lib_id order by b.f_lib_id  asc";
			}else{
				 dquery = "SELECT b.f_lib_id,b.roll FROM branch_section_changes b, students v,std_subjects  s WHERE b.branch ='"
							+ form.getBranch()
							+ "' AND b.semester ='"
							+ form.getSemester()
							+ "' AND b.section='"
							+ form.getSection()
							+ "' AND b.f_lib_id = v.lib_id"
							+ " AND s.f_subject_code='"
							+ form.getSubCode()
							+ "' AND s.f_lib_id=v.lib_id order by b.f_lib_id  asc";
			}

			rs = stmt.executeQuery(dquery);

			int i = 0; // this is for counting number of student in that class
			while (rs.next()) {
				uptech[i][0] = "" + rs.getLong(1);
				uptech[i][1] = "" + rs.getString(2);
				i++;
			}

			String systemKey = form.getBranch() + "-" + form.getSemester()
					+ "-" + form.getSection() + "-" + subCode;
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, systemKey);
			pstmt.setString(2, sysdate);
			//New Code to fill attendance for lab@18th July 2015
			pstmt.setString(3,form.getLabName());
			rs = pstmt.executeQuery();
			String tempRollNum;
			StringTokenizer st;
			StringBuilder absroll;
			int absentStudentCount = 0;
			while (rs.next()) // /////////Number of class held........
			{
				absroll = new StringBuilder();
				absentStudentCount = 0;
				String doc = rs.getString(1);
				st = new StringTokenizer(rs.getString(2), "-");
				while (st.hasMoreTokens()) {
					tempRollNum = st.nextToken();
					for (int p = 0; p < i; p++) {
						if (tempRollNum.equals(uptech[p][0])) {
							absroll.append(uptech[p][0]);
							// I have changed it since student id is not
							// assigned
							// absroll.append(uptech[p][1]);
							absroll.append(",");
							absentStudentCount = absentStudentCount + 1;
							break;
						}// /end of if
					}// end of for loop
				}
				String period_no = rs.getString(3);
				// String no_absent = rs.getString(4);
				String no_absent = absentStudentCount + "";
				AttendanceStatusVO attendanceStatusVO = new AttendanceStatusVO(
						rs.getString(5), doc, period_no, absroll.toString(),
						no_absent, rs.getString(6), rs.getString(7));
				float percentageAttInClass = (((float) i - Integer
						.parseInt(no_absent)) / i) * 100;
				attendanceStatusVO
						.setPercentageAttInClass(percentageAttInClass);
				attendanceStatusVO.setTotalStudent(i);
				attendanceStatusList.add(attendanceStatusVO);
			}// /end of while loop
		} catch (SQLException exe) {
			// System.out.println("This is exception.."+exe.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception exe) {
			}
		}
		return attendanceStatusList;
	}

	public List getStudentListForUpdate(AttendanceBean form, String doc) {
		// final String
		// query="select subject_name,br_sem_sec from subject_assignment where user_id=5990";
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection connection = null;
		ArrayList<String> abs = new ArrayList<String>();
		final String query = "select ab_rolls from attendances where system_key=? and doclass=? and period_no=?";
		try {
			connection = TechnohunkConnectionPool.getDbConnection();
			String systemkey = form.getBranch() + "-" + form.getSemester()
					+ "-" + form.getSection() + "-" + form.getSubCode();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, systemkey);
			pstmt.setString(2, doc);
			pstmt.setString(3, form.getPeriod());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String absRolls = rs.getString(1);
				String[] tempList = absRolls.split("-");
				for (int i = 0; i < tempList.length; i++) {
					abs.add(tempList[i]);
					// System.out.println(tempList[i]);
				}
			}

		} catch (SQLException exe) {
			// System.out.println("This is exceptionTTTTTTTTTTTTTTTTT.."+exe.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception exe) {
			}
		}
		return abs;
	}

	public int getMaxMarkForTest(String subject, String ctType) {
		int maxMarks = 0;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection connection = null;

		try {
			connection = TechnohunkConnectionPool.getDbConnection();
			// System.out.println("connection made "+ctType);
			Statement stmt = connection.createStatement();
			// System.out.println("before execution"+subject);
			rs = stmt.executeQuery("SELECT " + ctType.trim()
					+ " FROM subjects WHERE subject_name='" + subject.trim()
					+ "'");
			// System.out.println("after execution");
			if (rs.next()) {
				maxMarks = rs.getInt(1);
				// System.out.println("the marks is "+maxMarks);
			}
		} catch (SQLException exe) {
			// System.out.println("This is exception.."+exe.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (rs != null)
					rs.close();
			} catch (Exception exe) {
			}
		}
		// System.out.println("the marks is "+maxMarks);
		return maxMarks;
	}

	@Override
	public List<SubjectAssignmentVO> findAssignTaskByTeacherId(int teacherId) {
		List<SubjectAssignmentVO> assignmentVOs = new ArrayList<SubjectAssignmentVO>();
		int maxMarks = 0;
		ResultSet rs = null;
		Connection connection = null;
		try {
			connection = TechnohunkConnectionPool.getDbConnection();
			// System.out.println("connection made "+teacherId);
			Statement stmt = connection.createStatement();
			rs = stmt
					.executeQuery("SELECT USER_ID ,SUB_CODE,BR_SEM_SEC,SUBJECT_NAME,SUB_TYPE,F_SHORT_SUBJECT_NAME,LAB_NAME FROM SUBJECT_ASSIGNMENT WHERE USER_ID="
							+ teacherId);
			// System.out.println("after execution");
			while (rs.next()) {
				SubjectAssignmentVO subjectAssignmentVO=new SubjectAssignmentVO(rs.getInt(1), rs
						.getString(2), rs.getString(3), rs.getString(4), rs
						.getString(5), rs.getString(6));
				subjectAssignmentVO.setLabName(rs.getString(7));
				assignmentVOs.add(subjectAssignmentVO);
			}

			//THIS IS SPECIAL CODE WHERE ONCE SUBJECT CAN BE TAUGHT BY MORE THAN ONE FACULITY SPECIALY TRAINING AND ALL
			rs = stmt
					.executeQuery("SELECT USER_ID ,SUB_CODE,BR_SEM_SEC,SUBJECT_NAME,SUB_TYPE,F_SHORT_SUBJECT_NAME,LAB_NAME FROM SP_SUBJECT_ASSIGNMENT WHERE USER_ID="
							+ teacherId);
			// System.out.println("after execution");
			while (rs.next()) {
				SubjectAssignmentVO subjectAssignmentVO=new SubjectAssignmentVO(rs.getInt(1), rs
						.getString(2), rs.getString(3), rs.getString(4), rs
						.getString(5), rs.getString(6));
				subjectAssignmentVO.setLabName(rs.getString(7));
				assignmentVOs.add(subjectAssignmentVO);
			}
			//THIS INTRODUCED BECAUSE OF COMPUTER SCIENCE TRAINING ETC.

		} catch (SQLException exe) {
			 System.out.println("This is exception.."+exe.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (rs != null)
					rs.close();
			} catch (Exception exe) {
			}
		}
		return assignmentVOs;
	}

	/**
	 * Method which return lasted two entries filled by the teacher
	 */
	@Override
	public List<AttendanceStatusVO> findLastestTwoAttendance(int userId) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection connection = null;
		List<AttendanceStatusVO> attendanceStatusList = new ArrayList<AttendanceStatusVO>();
		// final String
		// query="select SYSTEM_KEY,TO_CHAR(doclass,'DD-MON-YY'),period_no,no_absent,UNIT,TOPIC_DESCRIPTION from attendances where EMP_CODE=? order by doclass desc";
		final String query = "select SYSTEM_KEY,DATE_FORMAT(doclass, '%d-%b-%y'),period_no,no_absent,UNIT,TOPIC_DESCRIPTION from attendances where EMP_CODE=? order by doclass desc LIMIT 5";
		try {
			connection = TechnohunkConnectionPool.getDbConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			// int count = 0;
			while (rs.next()) {
				attendanceStatusList
						.add(new AttendanceStatusVO(rs.getString(1), rs
								.getString(2), rs.getString(3),
								rs.getString(4), rs.getString(5), rs
										.getString(6)));
				/*
				 * if (++count == 2) { break; }
				 */
			}
		} catch (SQLException exe) {
			// System.out.println("This is exception.."+exe.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception exe) {
			}
		}
		return attendanceStatusList;
	}

	@Override
	public String deleteAttendanceBySystemKey(String deleteString) {
		// CS-VIII-A-TCS-300@16-Apr-14@4
		// final String
		// query="select subject_name,br_sem_sec from subject_assignment where user_id=5990";
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection connection = null;
		ArrayList<String> abs = new ArrayList<String>();
		final String query = "delete  from attendances where system_key=? and doclass=? and period_no=?";
		try {
			connection = TechnohunkConnectionPool.getDbConnection();
			String tokens[] = deleteString.split("@");
			String systemkey = tokens[0];
			String doclass = tokens[1];
			// convert this doclass into the SQL format
			doclass = DateUtils.getDateOfClass(doclass);
			String periodNo = tokens[2];
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, systemkey);
			pstmt.setString(2, doclass);
			pstmt.setString(3, periodNo);
			int p = pstmt.executeUpdate();
			if (p == 1)
				return "success";
		} catch (SQLException exe) {
			exe.printStackTrace();
			// System.out.println("This is exceptionTTTTTTTTTTTTTTTTT.."+exe.getMessage());
			return "fail";
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception exe) {
			}
		}
		return "fail";
	}

	@Override
	public List<AttendanceStatusVOWrapper> showAvgAttendanceStatusInClass(
			AttendanceBean form, String sysdate) {
		String includeLabAtt=form.getLabName();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection connection = null;
		// final String
		// query="select TO_CHAR(doclass,'DD-MON-YY'),ab_rolls,period_no,no_absent,system_key,unit,topic_description from attendances where system_key=? and doclass<=?  order by doclass";
		final String query;
		if ("attendanceOn".equalsIgnoreCase(form.getReportType())) {
			query = "select  DATE_FORMAT(doclass, '%d-%b-%y'),ab_rolls,period_no,no_absent,system_key,unit,topic_description,DAY_PERIOD,CLASS_NAME from attendances where system_key=? and doclass=?  order by doclass asc,period_no";
		} else if ("attendanceTillDate".equalsIgnoreCase(form.getReportType())) {
			query = "select  DATE_FORMAT(doclass, '%d-%b-%y'),ab_rolls,period_no,no_absent,system_key,unit,topic_description,DAY_PERIOD,CLASS_NAME from attendances where system_key=? and doclass<=?  order by doclass asc,period_no";
		} else if ("today".equalsIgnoreCase(form.getReportType())) {
			query = "select  DATE_FORMAT(doclass, '%d-%b-%y'),ab_rolls,period_no,no_absent,system_key,unit,topic_description,DAY_PERIOD,CLASS_NAME from attendances where system_key=? and doclass=?  order by doclass asc,period_no";
		} else if ("yesterday".equalsIgnoreCase(form.getReportType())) {
			query = "select  DATE_FORMAT(doclass, '%d-%b-%y'),ab_rolls,period_no,no_absent,system_key,unit,topic_description,DAY_PERIOD,CLASS_NAME from attendances where system_key=? and doclass=?  order by doclass asc,period_no";
		} else if ("daybeforeyesterday".equalsIgnoreCase(form.getReportType())) {
			query = "select  DATE_FORMAT(doclass, '%d-%b-%y'),ab_rolls,period_no,no_absent,system_key,unit,topic_description,DAY_PERIOD,CLASS_NAME from attendances where system_key=? and doclass=?  order by doclass asc,period_no";
		} else if ("lasttwodays".equalsIgnoreCase(form.getReportType())) {
			query = "select  DATE_FORMAT(doclass, '%d-%b-%y'),ab_rolls,period_no,no_absent,system_key,unit,topic_description,DAY_PERIOD,CLASS_NAME from attendances where system_key=? and doclass<=?  order by doclass desc,period_no desc LIMIT 2";
		} else if ("lastthreedays".equalsIgnoreCase(form.getReportType())) {
			query = "select  DATE_FORMAT(doclass, '%d-%b-%y'),ab_rolls,period_no,no_absent,system_key,unit,topic_description,DAY_PERIOD,CLASS_NAME from attendances where system_key=? and doclass<=?  order by doclass desc,period_no desc LIMIT 3";
		} else if ("lastoneweek".equalsIgnoreCase(form.getReportType())) {
			query = "select  DATE_FORMAT(doclass, '%d-%b-%y'),ab_rolls,period_no,no_absent,system_key,unit,topic_description,DAY_PERIOD,CLASS_NAME from attendances where system_key=? and doclass<=?  order by doclass desc,period_no desc LIMIT 7";
		} else if ("lasttendays".equalsIgnoreCase(form.getReportType())) {
			query = "select  DATE_FORMAT(doclass, '%d-%b-%y'),ab_rolls,period_no,no_absent,system_key,unit,topic_description,DAY_PERIOD,CLASS_NAME from attendances where system_key=? and doclass<=?  order by doclass desc,period_no desc LIMIT 10";
		} else if ("lastonemonth".equalsIgnoreCase(form.getReportType())) {
			query = "select  DATE_FORMAT(doclass, '%d-%b-%y'),ab_rolls,period_no,no_absent,system_key,unit,topic_description,DAY_PERIOD,CLASS_NAME from attendances where system_key=? and doclass<=?  order by doclass desc,period_no desc LIMIT 30";
		} else {
			query = "select  DATE_FORMAT(doclass, '%d-%b-%y'),ab_rolls,period_no,no_absent,system_key,unit,topic_description,DAY_PERIOD,CLASS_NAME from attendances where system_key=? and doclass<=?  order by doclass asc,period_no";
		}
		// stmt.executeUpdate("insert into attendances values('"+systemkey+"','"+toSend1[5]+"','"+absentRollNumber+"','"+toSend1[4]+"',"+Integer.parseInt(emp_code.trim())+",'"+no_of_absent+"','"+sysdate+"')");
		List<AttendanceStatusVOWrapper> attendanceStatusVOWrapperList = new ArrayList<AttendanceStatusVOWrapper>();
		try {

			connection = TechnohunkConnectionPool.getDbConnection();
			Statement stmt = connection.createStatement();
			StringBuilder branchSemSec = new StringBuilder();
			branchSemSec.append(form.getBranch() + "-" + form.getSemester()
					+ "-" + form.getSection());
			
			String includeSubjects="";
			if(includeLabAtt!=null && CMSApplicationConstant.SUBJECT_TYPE_BOTH.equalsIgnoreCase(includeLabAtt)){
				includeSubjects=" IN ('L','P')";
			}else if(includeLabAtt!=null && CMSApplicationConstant.SUBJECT_TYPE_LAB.equalsIgnoreCase(includeLabAtt)){
				includeSubjects=" IN ('P')";
			}else{
				includeSubjects=" IN ('L')";
			}
				
			rs = stmt
					.executeQuery("select sub_code,SUB_TYPE,LAB_NAME,F_SHORT_SUBJECT_NAME from subject_assignment where BR_SEM_SEC='"
							+ branchSemSec.toString() + "' and SUB_TYPE"+includeSubjects);
			List<SubjectCodeBatchEntity> subCodeList = new ArrayList<SubjectCodeBatchEntity>();
			while (rs.next()) {
				SubjectCodeBatchEntity subjectCodeBatch=new SubjectCodeBatchEntity();
				subjectCodeBatch.setSubjectCode(rs.getString(1));
				subjectCodeBatch.setSubjectType(rs.getString(2));
				subjectCodeBatch.setLabName(rs.getString(3));
				subjectCodeBatch.setShortSubjectName(rs.getString(4));
				subCodeList.add(subjectCodeBatch);
			}

			rs = stmt
					.executeQuery("SELECT count(*) FROM branch_section_changes  WHERE branch = '"
							+ form.getBranch()
							+ "'"
							+ " AND semester = '"
							+ form.getSemester()
							+ "'"
							+ " AND section='"
							+ form.getSection()
							+ "'"
							+ " ORDER BY  (0 + ROLL)  asc");
			// computing total number of student.
			int i = 0; // this is for counting number of student in that class
			if (rs.next()) {
				i = rs.getInt(1);
			}
			int toalStudents=i;
			// creating two D array to store lib id and student id
			String uptech[][] = new String[i][2];

			rs = stmt
					.executeQuery("SELECT f_lib_id,roll FROM branch_section_changes  WHERE branch = '"
							+ form.getBranch()
							+ "'"
							+ " AND semester = '"
							+ form.getSemester()
							+ "'"
							+ " AND section='"
							+ form.getSection()
							+ "'"
							+ " ORDER BY  (0 + ROLL)  asc");
			int pindex = 0;
			while (rs.next()) {
				uptech[pindex][0] = "" + rs.getLong(1);
				uptech[pindex][1] = "" + rs.getString(2);
				pindex++;
			}
			
			for (SubjectCodeBatchEntity subjectCodeBatch : subCodeList) {
				String subjectName = "";
				String facultyName = "";
				String empCode = "";
				String subShortName = "";
				String labName="";
				String subjectType="";
				String gperiod = "0";
				String periodsAsPerDay="";
				int gnoabsent = 0;
				rs = stmt
						.executeQuery("select USER_ID,SUBJECT_NAME,F_SHORT_SUBJECT_NAME,SUB_TYPE,LAB_NAME  from subject_assignment where BR_SEM_SEC='"
								+ branchSemSec.toString()
								+ "' and SUB_TYPE"+includeSubjects+" and SUB_CODE='"
								+ subjectCodeBatch.getSubjectCode()
								+ "' and LAB_NAME='"+subjectCodeBatch.getLabName()+"'");
				if (rs.next()) {
					empCode = rs.getString(1);
					subjectName = rs.getString(2);
					subShortName = rs.getString(3);
					subjectType=rs.getString(4);
					labName=rs.getString(5);
				}
				rs = stmt
						.executeQuery("select CONCAT(FIRST_NAME,' ',LAST_NAME) from FACULTY_MEMBERS where EMP_ID="
								+ Integer.parseInt(empCode));
				if (rs.next()) {
					facultyName = rs.getString(1);
				}
				if(subjectCodeBatch.getLabName()!=null && !subjectCodeBatch.getLabName().equalsIgnoreCase(CMSApplicationConstant.SUBJECT_TYPE_LECTURE)){
					i=findNumberOfStudentsLabBatch(form.getBranch(),form.getSemester(),form.getSection(),subjectCodeBatch.getSubjectCode(),subjectCodeBatch.getLabName());
				}else{
					if(form.getBranch()!=null && "MBA".equalsIgnoreCase(form.getBranch())){
										         String countStudent="SELECT count(*)  FROM branch_section_changes b, students v,std_subjects  s WHERE b.branch ='MBA' AND b.semester ='"+form.getSemester()+"'  AND b.section='"+form.getSection()+"' AND b.f_lib_id = v.lib_id AND s.f_subject_code='"+subjectCodeBatch.getSubjectCode()+"' AND s.f_lib_id=v.lib_id order by b.f_lib_id  asc";	
											         Statement cstmt = connection.createStatement();
											         ResultSet  crs=cstmt.executeQuery(countStudent);
										         if(crs.next()) {
											        	 i=crs.getInt(1);
											         }
											         if(crs!=null){
										        		 crs.close();
										        	 }
											         if(cstmt!=null){
											        	 cstmt.close();
											         }
									}else {
												//Add a comment to this line
												i=toalStudents;
									}	
				}
				ArrayList<AttendanceStatusVO> attendanceStatusList = new ArrayList<AttendanceStatusVO>();
				String systemKey = form.getBranch() + "-" + form.getSemester()
						+ "-" + form.getSection() + "-" + subjectCodeBatch.getSubjectCode();
				pstmt = connection.prepareStatement(query);
				pstmt.setString(1, systemKey);
				pstmt.setString(2, sysdate);
				ResultSet prs = pstmt.executeQuery();
				String tempRollNum;
				StringTokenizer st;
				StringBuilder absroll;
				int absentStudentCount = 0;
				float totalAvgStudentInClass = 0.0F;
				while (prs.next()) // /////////Number of class held........
				{
					String className = prs.getString(9);
					if(className!=null && !className.equalsIgnoreCase(subjectCodeBatch.getLabName())){
							continue;
					}
					absroll = new StringBuilder();
					absentStudentCount = 0;
					String doc = prs.getString(1);
					st = new StringTokenizer(prs.getString(2), "-");
					while (st.hasMoreTokens()) {
						tempRollNum = st.nextToken();
						for (int p = 0; p < toalStudents; p++) {
							if (tempRollNum.equals(uptech[p][0])) {
								// Code change to display UPTU Roll instead of
								// studentid
								absroll.append(uptech[p][0]);
								absroll.append(",");
								absentStudentCount++;
								break;
							}// /end of if
						}// end of for loop
					}
					String period_no = prs.getString(3);
					gperiod = period_no;
					String no_absent = absentStudentCount + "";
					// String no_absent = prs.getString(4);
					// BUGFIX when students are deleted still attendance is
					// present inside
					// the attendances table
					if (no_absent != null) {
						gnoabsent = Integer.parseInt(no_absent);
					}
					AttendanceStatusVO attendanceStatusVO = new AttendanceStatusVO(
							prs.getString(5), doc, period_no,
							absroll.toString(), no_absent, prs.getString(6),
							prs.getString(7));
					//New code to fetch the periods
					try {
					periodsAsPerDay=prs.getString(8);
					}catch (Exception e) {
						e.printStackTrace();	
					}
					if(periodsAsPerDay==null){
						periodsAsPerDay="";
					}
					float percentageAttInClass = (((float) i - Integer
							.parseInt(no_absent)) / i) * 100;
					attendanceStatusVO
							.setPercentageAttInClass(percentageAttInClass);
					// calculating avg student attendance in a class
					totalAvgStudentInClass = totalAvgStudentInClass
							+ percentageAttInClass;
					attendanceStatusVO.setTotalStudent(i);
					attendanceStatusList.add(attendanceStatusVO);
				}// /end of while loop
				pstmt.clearParameters();

				// setting all the values for avg attendance for a faculty
				AttendanceStatusVOWrapper attendanceStatusVOWrapper = new AttendanceStatusVOWrapper();
				// sorting as per period number
				// This is FIXED against bug reported in average attendance in
				// class where date is not
				// coming in sorted order.
				if (form.getOperationType() != null
						&& "avgStudentAttInClass".equals(form
								.getOperationType())) {
					// getOperationType is avgStudentAttInClass ,please do not
					// sort as per period
				} else {
					Collections.sort(attendanceStatusList);
				}
				attendanceStatusVOWrapper
						.setAttendanceStatusVOs(attendanceStatusList);
				
				attendanceStatusVOWrapper.setTotalStudent(i);
				attendanceStatusVOWrapper.setSubjectCode(subjectCodeBatch.getSubjectCode());
				attendanceStatusVOWrapper.setSubjectName(subjectName);
				attendanceStatusVOWrapper.setGperiod(gperiod);
				attendanceStatusVOWrapper.setTotalPresentStudent(i - gnoabsent);
				attendanceStatusVOWrapper.setSubShortName(subjectCodeBatch.getShortSubjectName());
				attendanceStatusVOWrapper.setEmpCode(empCode);
				attendanceStatusVOWrapper.setFacultyName(facultyName);
				attendanceStatusVOWrapper.setLabName(subjectCodeBatch.getLabName());
				attendanceStatusVOWrapper.setSubjectType(subjectType);
				List<String> periodList=new ArrayList<String>();
				if(periodsAsPerDay!=null && periodsAsPerDay.length()>0){
					String tokens[]=periodsAsPerDay.split("-");
					if(tokens!=null && tokens.length>0){
						for(String period:tokens) {
							periodList.add(period);
						}
					}
				}
				attendanceStatusVOWrapper.setDayPeriods(periodList);
				
				if (attendanceStatusList.size() > 0) {
					attendanceStatusVOWrapper
							.setTotalAvgStudentInClass(totalAvgStudentInClass
									/ attendanceStatusList.size());
				} else {
					// one is just dummy value to show the appearance of the
					// status bar
					attendanceStatusVOWrapper.setTotalAvgStudentInClass(0);
					attendanceStatusVOWrapper.setGperiod("NF");
				}
				attendanceStatusVOWrapperList.add(attendanceStatusVOWrapper);
			}// end of loop of subject code
		} catch (SQLException exe) {
			exe.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception exe) {
				exe.printStackTrace();
			}
		}
		return attendanceStatusVOWrapperList;
	}
	
	private int findNumberOfStudentsLabBatch(String branch,String semester,String section,String subjectCode,String batchName){
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection connection = null;
		final String query = "select count(*) from students_lab_tbl where branch_sem_sec=? and subjectCode=? and labName=?";
		int nos=0;
		try {
			connection = TechnohunkConnectionPool.getDbConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, branch+"-"+semester+"-"+section);
			pstmt.setString(2, subjectCode);
			pstmt.setString(3, batchName);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				 nos = rs.getInt(1);
			}
		} catch (SQLException exe) {
			exe.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception exe) {
				exe.printStackTrace();
			}
		}
		return nos;
	}

	@Override
	public List<String> showAvailablePeriods(String systemKey, String doclass) {
		List<String> periodList = new ArrayList<String>();
		periodList.add(1 + "");
		periodList.add(2 + "");
		periodList.add(3 + "");
		periodList.add(4 + "");
		periodList.add(5 + "");
		periodList.add(6 + "");
		periodList.add(7 + "");
		periodList.add(8 + "");
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection connection = null;
		final String query = "select PERIOD_NO from attendances where SYSTEM_KEY like '"
				+ systemKey + "%' and DOCLASS=?";
		try {
			connection = TechnohunkConnectionPool.getDbConnection();
			pstmt = connection.prepareStatement(query);
			// pstmt.setString(1,systemKey);
			pstmt.setString(1, doclass);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String period = rs.getString(1);
				periodList.remove(period);
			}
		} catch (SQLException exe) {
			exe.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception exe) {
				exe.printStackTrace();
			}
		}
		return periodList;
	}

	@Override
	public int findLockedDaysByFaculty(String empid) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection connection = null;
		final String query = "select lockperiod from  login_info where USER_ID='"
				+ empid + "'";
		;
		try {
			connection = TechnohunkConnectionPool.getDbConnection();
			pstmt = connection.prepareStatement(query);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int noOfdays = rs.getInt(1);
				return noOfdays;
			}
		} catch (SQLException exe) {
			exe.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception exe) {
				exe.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public String updateLockPeriodForFaculty(String empid, int lockPeriod) {
		// CS-VIII-A-TCS-300@16-Apr-14@4
		// final String
		// query="select subject_name,br_sem_sec from subject_assignment where user_id=5990";
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection connection = null;
		ArrayList<String> abs = new ArrayList<String>();
		final String query = "update  login_info set lockperiod=" + lockPeriod
				+ " where USER_ID='" + empid + "'";
		try {
			connection = TechnohunkConnectionPool.getDbConnection();
			pstmt = connection.prepareStatement(query);
			int p = pstmt.executeUpdate();
			if (p == 1)
				return "success";
		} catch (SQLException exe) {
			exe.printStackTrace();
			// System.out.println("This is exceptionTTTTTTTTTTTTTTTTT.."+exe.getMessage());
			return "fail";
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception exe) {
			}
		}
		return "fail";

	}
}
