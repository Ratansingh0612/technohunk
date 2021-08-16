package com.synergisitic.it.report.model;

public class CourseCoveredStatusKey {
	private String consultantId;
	private String cids;
	private String name;
	private float totalCoursePer;

	public float getTotalCoursePer() {
		return totalCoursePer;
	}

	public void setTotalCoursePer(float totalCoursePer) {
		this.totalCoursePer = totalCoursePer;
	}

	public String getConsultantId() {
		return consultantId;
	}

	public void setConsultantId(String consultantId) {
		this.consultantId = consultantId;
	}

	public String getCids() {
		return cids;
	}

	public void setCids(String cids) {
		this.cids = cids;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CourseCoveredStatusKey [consultantId=" + consultantId
				+ ", cids=" + cids + ", name=" + name + ", totalCoursePer="
				+ totalCoursePer + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((consultantId == null) ? 0 : consultantId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourseCoveredStatusKey other = (CourseCoveredStatusKey) obj;
		if (consultantId == null) {
			if (other.consultantId != null)
				return false;
		} else if (!consultantId.equals(other.consultantId))
			return false;
		return true;
	}
	
	

}
