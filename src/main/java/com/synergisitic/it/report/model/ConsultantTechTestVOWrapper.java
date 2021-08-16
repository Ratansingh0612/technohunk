package com.synergisitic.it.report.model;

import com.synergisitic.it.web.form.UserForm;

/**
 * 
 * @author Nagendra
 *
 */
public class ConsultantTechTestVOWrapper  implements Comparable<ConsultantTechTestVOWrapper> {
	private int id;
	private String name;
	private String loginid;
	private String score;
	private String techTestStatus;
	private String mainHeading;
	private String groupName;
	private String trainerName;
	private String dot;
	private String consultantNo;
	private String techName;
	private String testName;
	private String avgScore;
	private String leftImage;
	private String rightImage;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the loginid
	 */
	public String getLoginid() {
		return loginid;
	}

	/**
	 * @param loginid
	 *            the loginid to set
	 */
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	/**
	 * @return the score
	 */
	public String getScore() {
		return score;
	}

	/**
	 * @param score
	 *            the score to set
	 */
	public void setScore(String score) {
		this.score = score;
	}

	/**
	 * @return the techTestStatus
	 */
	public String getTechTestStatus() {
		return techTestStatus;
	}

	/**
	 * @param techTestStatus
	 *            the techTestStatus to set
	 */
	public void setTechTestStatus(String techTestStatus) {
		this.techTestStatus = techTestStatus;
	}

	/**
	 * @return the mainHeading
	 */
	public String getMainHeading() {
		return mainHeading;
	}

	/**
	 * @param mainHeading
	 *            the mainHeading to set
	 */
	public void setMainHeading(String mainHeading) {
		this.mainHeading = mainHeading;
	}

	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param groupName
	 *            the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
	 * @return the trainerName
	 */
	public String getTrainerName() {
		return trainerName;
	}

	/**
	 * @param trainerName
	 *            the trainerName to set
	 */
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	/**
	 * @return the dot
	 */
	public String getDot() {
		return dot;
	}

	/**
	 * @param dot
	 *            the dot to set
	 */
	public void setDot(String dot) {
		this.dot = dot;
	}

	/**
	 * @return the consultantNo
	 */
	public String getConsultantNo() {
		return consultantNo;
	}

	/**
	 * @param consultantNo
	 *            the consultantNo to set
	 */
	public void setConsultantNo(String consultantNo) {
		this.consultantNo = consultantNo;
	}

	/**
	 * @return the techName
	 */
	public String getTechName() {
		return techName;
	}

	/**
	 * @param techName
	 *            the techName to set
	 */
	public void setTechName(String techName) {
		this.techName = techName;
	}

	/**
	 * @return the testName
	 */
	public String getTestName() {
		return testName;
	}

	/**
	 * @param testName
	 *            the testName to set
	 */
	public void setTestName(String testName) {
		this.testName = testName;
	}

	/**
	 * @return the avgScore
	 */
	public String getAvgScore() {
		return avgScore;
	}

	/**
	 * @param avgScore
	 *            the avgScore to set
	 */
	public void setAvgScore(String avgScore) {
		this.avgScore = avgScore;
	}

	/**
	 * @return the leftImage
	 */
	public String getLeftImage() {
		return leftImage;
	}

	/**
	 * @param leftImage
	 *            the leftImage to set
	 */
	public void setLeftImage(String leftImage) {
		this.leftImage = leftImage;
	}

	/**
	 * @return the rightImage
	 */
	public String getRightImage() {
		return rightImage;
	}

	/**
	 * @param rightImage
	 *            the rightImage to set
	 */
	public void setRightImage(String rightImage) {
		this.rightImage = rightImage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ConsultantTechTestVOWrapper [id=" + id + ", name=" + name + ", loginid=" + loginid + ", score=" + score
				+ ", techTestStatus=" + techTestStatus + ", mainHeading=" + mainHeading + ", groupName=" + groupName
				+ ", trainerName=" + trainerName + ", dot=" + dot + ", consultantNo=" + consultantNo + ", techName="
				+ techName + ", testName=" + testName + ", avgScore=" + avgScore + ", leftImage=" + leftImage
				+ ", rightImage=" + rightImage + "]";
	}

	@Override
	public int compareTo(ConsultantTechTestVOWrapper o) {
		int status=0;
		 if(this.getTechTestStatus()!=null && o.getTechTestStatus()!=null) {
			     status= this.getTechTestStatus().compareTo(o.getTechTestStatus());
			     if(status==0){
			    	 if(this.getScore()!=null && o.getScore()!=null) {
			    	  double fscore=Double.parseDouble(this.getScore()!=null?this.getScore():"0");
			    	  double sscore=Double.parseDouble(o.getScore()!=null?o.getScore():"0");
			    	  if(fscore>sscore){
			    		 status=-1; 
			    	  }else if(fscore<sscore){
			    		  status=1;
			    	  }else{
			    		  status=0;
			    	  }
			    	 }
			    	 return status;
			     }
		 }
		return status;
	}

}
