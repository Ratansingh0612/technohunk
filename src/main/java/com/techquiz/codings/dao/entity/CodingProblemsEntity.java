package com.techquiz.codings.dao.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * 
 * @author VC1
 * @Since 25-Jul-2018
 */

@Entity
@Table(name="coding_problems_tbl")
public class CodingProblemsEntity {
	private long cpid;
	private String title;
	private String techName;
	private String level;
	private int duration;
	private String icon;
	private String image;
	private String author;
	private String description;
	private String readMore;
	private Timestamp doe;
	private Timestamp dom;
	private String problemType;
	private String subMethodName;
	private String methodInputType;
	private String mainClassName;
	private String withtestcase;
	private CodingProblemCategoryEntity codingProblemCategoryEntity;
	private List<TestCasesEntity> testCases;

	@Id
	@GeneratedValue
	public long getCpid() {
		return cpid;
	}

	public void setCpid(long cpid) {
		this.cpid = cpid;
	}
	
	

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "codingProblems")
	public List<TestCasesEntity> getTestCases() {
		return testCases;
	}

	public void setTestCases(List<TestCasesEntity> testCases) {
		this.testCases = testCases;
	}

	@Column(length=150)
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(length=20)
	public String getTechName() {
		return techName;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	}

	@Column(length=10)
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
	
	
	@Column(length=100)
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Column(length=150)
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(length=150)
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	

	@Column(length=150)
	public String getReadMore() {
		return readMore;
	}

	public void setReadMore(String readMore) {
		this.readMore = readMore;
	}

	@Column(length=500)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	
	
	@Column(length=100)
	public String getSubMethodName() {
		return subMethodName;
	}

	public void setSubMethodName(String subMethodName) {
		this.subMethodName = subMethodName;
	}

	@Column(length=15)
	public String getMethodInputType() {
		return methodInputType;
	}

	public void setMethodInputType(String methodInputType) {
		this.methodInputType = methodInputType;
	}

	@Column(length=50)
	public String getMainClassName() {
		return mainClassName;
	}

	public void setMainClassName(String mainClassName) {
		this.mainClassName = mainClassName;
	}

	@Column(length=20)
	public String getProblemType() {
		return problemType;
	}

	public void setProblemType(String problemType) {
		this.problemType = problemType;
	}

	@Column(length=3)
	public String getWithtestcase() {
		return withtestcase;
	}

	public void setWithtestcase(String withtestcase) {
		this.withtestcase = withtestcase;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category", nullable = false)
	public CodingProblemCategoryEntity getCodingProblemCategoryEntity() {
		return codingProblemCategoryEntity;
	}

	public void setCodingProblemCategoryEntity(CodingProblemCategoryEntity codingProblemCategoryEntity) {
		this.codingProblemCategoryEntity = codingProblemCategoryEntity;
	}

	@Override
	public String toString() {
		return "CodingProblemsEntity [cpid=" + cpid + ", title=" + title + ", techName=" + techName + ", level=" + level
				+ ", duration=" + duration + ", image=" + image + ", author=" + author + ", description=" + description
				+ ", readMore=" + readMore + ", doe=" + doe + ", dom=" + dom + ", problemType=" + problemType
				+ ", subMethodName=" + subMethodName + ", methodInputType=" + methodInputType + ", mainClassName="
				+ mainClassName + ", withtestcase=" + withtestcase + "]";
	}


}
