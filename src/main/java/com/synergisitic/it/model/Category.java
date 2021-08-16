/**
 * 
 */
package com.synergisitic.it.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Pranay
 *
 */

@Entity
@Table(name="Category_tbl")
public class Category {
	
	private int id;
	private String catName;
	private String shortName;
	private String description;
	private Date dateOfEntry;
	private Date lastModifyOn;
	private String lastModifyBy;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(length=50)
	public String getCatName() {
		return catName;
	}
	
	public void setCatName(String catName) {
		this.catName = catName;
	}
	
	@Column(length=20)
	public String getShortName() {
		return shortName;
	}
	
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
	@Column(length=100)
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getDateOfEntry() {
		return dateOfEntry;
	}
	
	public void setDateOfEntry(Date dateOfEntry) {
		this.dateOfEntry = dateOfEntry;
	}
	
	public Date getLastModifyOn() {
		return lastModifyOn;
	}
	
	public void setLastModifyOn(Date lastModifyOn) {
		this.lastModifyOn = lastModifyOn;
	}
	
	@Column(length=20)
	public String getLastModifyBy() {
		return lastModifyBy;
	}
	
	public void setLastModifyBy(String lastModifyBy) {
		this.lastModifyBy = lastModifyBy;
	}
	
	

}
