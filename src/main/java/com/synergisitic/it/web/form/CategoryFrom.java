/**
 * 
 */
package com.synergisitic.it.web.form;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Pranay
 *
 */
public class CategoryFrom implements Serializable{
	
	private int id;
	private String catName;
	private String shortName;
	private String description;
	private Date dateOfEntry;
	private Date lastModifyOn;
	private String lastModifyBy;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "CategoryFrom [id=" + id + ", catName=" + catName
				+ ", shortName=" + shortName + ", description=" + description
				+ ", dateOfEntry=" + dateOfEntry + ", lastModifyOn="
				+ lastModifyOn + ", lastModifyBy=" + lastModifyBy + "]";
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the catName
	 */
	public String getCatName() {
		return catName;
	}
	/**
	 * @param catName the catName to set
	 */
	public void setCatName(String catName) {
		this.catName = catName;
	}
	/**
	 * @return the shortName
	 */
	public String getShortName() {
		return shortName;
	}
	/**
	 * @param shortName the shortName to set
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the dateOfEntry
	 */
	public Date getDateOfEntry() {
		return dateOfEntry;
	}
	/**
	 * @param dateOfEntry the dateOfEntry to set
	 */
	public void setDateOfEntry(Date dateOfEntry) {
		this.dateOfEntry = dateOfEntry;
	}
	/**
	 * @return the lastModifyOn
	 */
	public Date getLastModifyOn() {
		return lastModifyOn;
	}
	/**
	 * @param lastModifyOn the lastModifyOn to set
	 */
	public void setLastModifyOn(Date lastModifyOn) {
		this.lastModifyOn = lastModifyOn;
	}
	/**
	 * @return the lastModifyBy
	 */
	public String getLastModifyBy() {
		return lastModifyBy;
	}
	/**
	 * @param lastModifyBy the lastModifyBy to set
	 */
	public void setLastModifyBy(String lastModifyBy) {
		this.lastModifyBy = lastModifyBy;
	}
	

}
