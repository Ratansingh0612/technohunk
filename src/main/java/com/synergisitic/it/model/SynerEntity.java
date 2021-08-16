package com.synergisitic.it.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Entity;

/**
 * 
 * @author nagendra.yadav
 *  This is base for all models which contains common
 *  information for all entity persisted into the database
 * 
 */
@Entity
abstract public class SynerEntity {

	private Date dateOfEntry;
	private Date lastModifyOn;
	private String description;
	private String lastModifyBy;
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLastModifyBy() {
		return lastModifyBy;
	}

	public void setLastModifyBy(String lastModifyBy) {
		this.lastModifyBy = lastModifyBy;
	}

}
