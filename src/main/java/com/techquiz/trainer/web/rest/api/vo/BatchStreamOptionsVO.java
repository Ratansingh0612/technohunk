package com.techquiz.trainer.web.rest.api.vo;

import java.util.List;

/**
 * 
 * @author Nagendra
 *
 */
public class BatchStreamOptionsVO {

	private List<String> groups;
	private List<String> batches;

	/**
	 * @return the groups
	 */
	public List<String> getGroups() {
		return groups;
	}

	/**
	 * @param groups
	 *            the groups to set
	 */
	public void setGroups(List<String> groups) {
		this.groups = groups;
	}

	/**
	 * @return the batches
	 */
	public List<String> getBatches() {
		return batches;
	}

	/**
	 * @param batches
	 *            the batches to set
	 */
	public void setBatches(List<String> batches) {
		this.batches = batches;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "BatchStreamOptionsVO [groups=" + groups + ", batches=" + batches + "]";
	}

}
