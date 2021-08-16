package com.techquiz.codings.web.controller.vo;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
/**
 * 
 * @author VC1
 * @Since 25-Jul-2018
 */
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(value=Include.NON_NULL)
@XmlRootElement

public class CodingProblemsVO implements Comparable<CodingProblemsVO> {
	private long cpid;
	private String title;
	private String defaultCode;
	private String techName;
	private String level;
	private int duration;
	private String icon;
	private String image;
	private String author;
	private String description;
	private String readMore;
	private String subMethodName;
	private String methodInputType;
	private String mainClassName;
	private String problemType;
	private String withtestcase;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy hh:mm:ss")
	private Timestamp doe;
	private Timestamp dom;
	private String userid;
	private String category;
	
	public String getIcon() {
		return icon;
	}

	
	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProblemType() {
		return problemType;
	}

	public void setProblemType(String problemType) {
		this.problemType = problemType;
	}

	public String getWithtestcase() {
		return withtestcase;
	}

	public void setWithtestcase(String withtestcase) {
		this.withtestcase = withtestcase;
	}

	public String getSubMethodName() {
		return subMethodName;
	}

	public void setSubMethodName(String subMethodName) {
		this.subMethodName = subMethodName;
	}

	public String getMethodInputType() {
		return methodInputType;
	}

	public void setMethodInputType(String methodInputType) {
		this.methodInputType = methodInputType;
	}

	public String getMainClassName() {
		return mainClassName;
	}

	public void setMainClassName(String mainClassName) {
		this.mainClassName = mainClassName;
	}

	public String getDefaultCode() {
		return defaultCode;
	}

	public void setDefaultCode(String defaultCode) {
		this.defaultCode = defaultCode;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	private List<TestCasesVO> testCasesVOs;
	

	public List<TestCasesVO> getTestCasesVOs() {
		return testCasesVOs;
	}

	public void setTestCasesVOs(List<TestCasesVO> testCasesVOs) {
		this.testCasesVOs = testCasesVOs;
	}

	public long getCpid() {
		return cpid;
	}

	public void setCpid(long cpid) {
		this.cpid = cpid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public String getTechName() {
		return techName;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	@Column(length=500)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

	public String getReadMore() {
		return readMore;
	}

	public void setReadMore(String readMore) {
		this.readMore = readMore;
	}

	public Timestamp getDoe() {
		return doe;
	}

	public void setDoe(Timestamp doe) {
		this.doe = doe;
	}

	public Timestamp getDom() {
		return dom;
	}

	public void setDom(Timestamp dom) {
		this.dom = dom;
	}

	

	@Override
	public String toString() {
		return "CodingProblemsVO [cpid=" + cpid + ", title=" + title + ", defaultCode=" + defaultCode + ", techName="
				+ techName + ", level=" + level + ", duration=" + duration + ", image=" + image + ", author=" + author
				+ ", description=" + description + ", readMore=" + readMore + ", doe=" + doe + ", dom=" + dom
				+ ", userid=" + userid + ", testCasesVOs=" + testCasesVOs + "]";
	}

	@Override
	public int compareTo(CodingProblemsVO o) {
		return 0;
	}

	

}
