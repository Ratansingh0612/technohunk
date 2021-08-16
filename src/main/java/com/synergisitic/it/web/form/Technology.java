package com.synergisitic.it.web.form;

import java.io.Serializable;
import java.util.Date;

public class Technology implements Serializable {

	private int id;
	private String tname;
	private String shortName;
	private String description;
	private Date dateOfEntry;
	private Date lastModifyOn;
	private String lastModifyBy;
	private String image;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
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


	public String getLastModifyBy() {
		return lastModifyBy;
	}

	public void setLastModifyBy(String lastModifyBy) {
		this.lastModifyBy = lastModifyBy;
	}
	
	

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Technology [id=" + id + ", tname=" + tname + ", shortName="
				+ shortName + ", description=" + description + ", dateOfEntry="
				+ dateOfEntry + ", lastModifyOn=" + lastModifyOn
				+ ", lastModifyBy=" + lastModifyBy + "]";
	}

}
