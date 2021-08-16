package com.synergisitic.it.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tfeedback_tbl")
public class FeedbackEntity {
    private int fid;
    private String description;
    private Timestamp doe;
    private Timestamp dom;
    private String userid;
    private TopicFeedbackEntity topicFeedback;
    
	/**
	 * @return the fid
	 */
	@Id
	@GeneratedValue
    public int getFid() {
		return fid;
	}
	/**
	 * @param fid the fid to set
	 */
	public void setFid(int fid) {
		this.fid = fid;
	}
	
	
	/**
	 * @return the topicFeedback
	 */
	 @OneToOne(mappedBy = "feedback", cascade = CascadeType.ALL, 
             fetch = FetchType.LAZY, optional = false)
	public TopicFeedbackEntity getTopicFeedback() {
		return topicFeedback;
	}
	/**
	 * @param topicFeedback the topicFeedback to set
	 */
	public void setTopicFeedback(TopicFeedbackEntity topicFeedback) {
		this.topicFeedback = topicFeedback;
	}
	/**
	 * @return the description
	 */
	
	@Column(length=100)
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
	 * @return the doe
	 */
	public Timestamp getDoe() {
		return doe;
	}
	/**
	 * @param doe the doe to set
	 */
	public void setDoe(Timestamp doe) {
		this.doe = doe;
	}
	/**
	 * @return the dom
	 */
	public Timestamp getDom() {
		return dom;
	}
	/**
	 * @param dom the dom to set
	 */
	public void setDom(Timestamp dom) {
		this.dom = dom;
	}
	/**
	 * @return the userid
	 */
	@Column(length=100)
	public String getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FeedbackEntity [fid=" + fid + ", description=" + description + ", doe=" + doe + ", dom=" + dom
				+ ", userid=" + userid + "]";
	}
    
}
