package com.techquiz.programys.common.vo;

import java.util.Arrays;

/**
 * 
 * @author nagendra.yadav
 *
 */
public class ExcelSheetData {

	private String techid;
	private String userid;
	private String questionBankName;
	private String mediaPath;
	private byte[] fileData;
	private String fileName;
	private String excelSheetType;
	private String assignedUrl;
	
	
	

	public String getAssignedUrl() {
		return assignedUrl;
	}

	public void setAssignedUrl(String assignedUrl) {
		this.assignedUrl = assignedUrl;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getTechid() {
		return techid;
	}

	public void setTechid(String techid) {
		this.techid = techid;
	}

	

	public String getQuestionBankName() {
		return questionBankName;
	}

	public void setQuestionBankName(String questionBankName) {
		this.questionBankName = questionBankName;
	}

	public String getExcelSheetType() {
		return excelSheetType;
	}

	public void setExcelSheetType(String excelSheetType) {
		this.excelSheetType = excelSheetType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getMediaPath() {
		return mediaPath;
	}

	public void setMediaPath(String mediaPath) {
		this.mediaPath = mediaPath;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	@Override
	public String toString() {
		return "ExcelSheetData [techid=" + techid + ", userid=" + userid + ", questionBankName=" + questionBankName
				+ ", mediaPath=" + mediaPath + ", fileData=" + Arrays.toString(fileData) + ", fileName=" + fileName
				+ ", excelSheetType=" + excelSheetType + ", assignedUrl=" + assignedUrl + "]";
	}

	
}
