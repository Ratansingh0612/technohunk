/**
 * 
 */
package com.techquiz.consultant.attendance.vo;

/**
 * @author nagendra.yadav
 * 
 */
public class AttendanceStatusVO implements Comparable<AttendanceStatusVO> {
	private String dateOfClass;
	private String period;
	private String absentRolls;
	private String totalAbsentStudent;
	private float percentageAttInClass;
	private int totalStudent;
	private String unit;
	private String topicDescription;
	private String systemKey;
	private String show="no";

	public int getTotalStudent() {
		return totalStudent;
	}

	public void setTotalStudent(int totalStudent) {
		this.totalStudent = totalStudent;
	}

	public float getPercentageAttInClass() {
		return percentageAttInClass;
	}

	public void setPercentageAttInClass(float percentageAttInClass) {
		this.percentageAttInClass = percentageAttInClass;
	}

	public String getShow() {
		return show;
	}

	public void setShow(String show) {
		this.show = show;
	}

	public AttendanceStatusVO( String systemKey,String dateOfClass, String period,
			 String totalAbsentStudent, String unit,
			String topicDescription) {
		this.dateOfClass = dateOfClass;
		this.period = period;
		this.totalAbsentStudent = totalAbsentStudent;
		this.unit = unit;
		this.topicDescription = topicDescription;
		this.systemKey = systemKey;
	}
	
	public AttendanceStatusVO( String systemKey,String dateOfClass, String period,String absentRolls,
			 String totalAbsentStudent, String unit,
			String topicDescription) {
		this.dateOfClass = dateOfClass;
		this.period = period;
		this.totalAbsentStudent = totalAbsentStudent;
		this.unit = unit;
		this.topicDescription = topicDescription;
		this.systemKey = systemKey;
		this.absentRolls=absentRolls;
	}

	public String getUnit() {
		return unit;
	}

	public String getTopicDescription() {
		return topicDescription;
	}

	public String getSystemKey() {
		return systemKey;
	}

	public AttendanceStatusVO(String dateOfClass, String period,
			String absentRolls, String totalAbsentStudent) {
		this.dateOfClass = dateOfClass;
		this.period = period;
		this.absentRolls = absentRolls;
		this.totalAbsentStudent = totalAbsentStudent;

	}

	/**
	 * @return the absentRolls
	 */
	public String getAbsentRolls() {
		return absentRolls;
	}

	/**
	 * @return the dateOfClass
	 */
	public String getDateOfClass() {
		return dateOfClass;
	}

	/**
	 * @return the period
	 */
	public String getPeriod() {
		return period;
	}

	/**
	 * @return the totalAbsentStudent
	 */
	public String getTotalAbsentStudent() {
		return totalAbsentStudent;
	}

	@Override
	public int compareTo(AttendanceStatusVO o) {
		return period.compareTo(o.getPeriod());
	}

}
