package com.techquiz.codings.dao.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Nagendra
 * @since 29-Aug-2018
 *
 */
@Entity
@Table(name="coding_problem_category_tbl")
public class CodingProblemCategoryEntity {
	private int cpcid;
	private String name;
	private String description;
	private Timestamp doe;
	private Timestamp dom;
	private String userid;

	@Id
	@GeneratedValue
	public int getCpcid() {
		return cpcid;
	}

	public void setCpcid(int cpcid) {
		this.cpcid = cpcid;
	}

	@Column(length=50)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length=50)
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
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "CodingProblemCategoryEntity [cpcid=" + cpcid + ", name=" + name + ", description=" + description
				+ ", doe=" + doe + ", dom=" + dom + ", userid=" + userid + "]";
	}

}
