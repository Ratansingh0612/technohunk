package com.techquiz.trainer.dao.entity;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.synergisitic.it.model.PendingTopicFeedbackEntity;
import com.synergisitic.it.model.TopicFeedbackEntity;

@Entity
@Table(name="training_sessions_detail_tbl")
public class TrainingSessionsDetailEntity {
	private long sid;
	private String technology;
	private String topics;
	private Time starttime;
	private Time endtime;
	private Date sessiondate;
	private String timeduration;
	private String batch;
	private String pempids;
	private Timestamp doe;
	private Timestamp dom;
	private String userid;
	private String comments;
	private String name;
	private String techName;
	private int totalDuration;
//   private TopicFeedbackEntity topicFeedback;
   
   private List<PendingTopicFeedbackEntity> pendingTopicEntityList = new ArrayList<PendingTopicFeedbackEntity>();

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getSid() {
		return sid;
	}

	public void setSid(long sid) {
		this.sid = sid;
	}

	public Date getSessiondate() {
		return sessiondate;
	}

	public void setSessiondate(Date sessiondate) {
		this.sessiondate = sessiondate;
	}
	
	@OneToMany(mappedBy = "trainingSession",
	        cascade = CascadeType.ALL, 
	        orphanRemoval = true
	    )
	public List<PendingTopicFeedbackEntity> getPendingTopicEntityList() {
		return pendingTopicEntityList;
	}

	public void setPendingTopicEntityList(List<PendingTopicFeedbackEntity> pendingTopicEntityList) {
		this.pendingTopicEntityList = pendingTopicEntityList;
	}

	/**
	 * @return the topicFeedback
	 */
	/* @OneToOne(cascade = CascadeType.ALL, 
             fetch = FetchType.LAZY, optional = true)
	public TopicFeedbackEntity getTopicFeedback() {
		return topicFeedback;
	}
*/
	/**
	 * @param topicFeedback the topicFeedback to set
	 */
	/*public void setTopicFeedback(TopicFeedbackEntity topicFeedback) {
		this.topicFeedback = topicFeedback;
	}*/

	@Column(length=50)
	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	@Column(length=200)
	public String getTopics() {
		return topics;
	}

	public void setTopics(String topics) {
		this.topics = topics;
	}

	public Time getStarttime() {
		return starttime;
	}

	public void setStarttime(Time starttime) {
		this.starttime = starttime;
	}

	public Time getEndtime() {
		return endtime;
	}

	public void setEndtime(Time endtime) {
		this.endtime = endtime;
	}

	@Column(length=50)
	public String getTimeduration() {
		return timeduration;
	}

	public void setTimeduration(String timeduration) {
		this.timeduration = timeduration;
	}

	@Column(length=15)
	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}


	@Column(length=200)
	public String getPempids() {
		return pempids;
	}

	public void setPempids(String pempids) {
		this.pempids = pempids;
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

	@Column(length=50)
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}


	@Column(length=100)
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	@Transient
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Transient
	public String getTechName() {
		return techName;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	}
	
	@Transient
	public int getTotalDuration() {
		return totalDuration;
	}

	public void setTotalDuration(int totalDuration) {
		this.totalDuration = totalDuration;
	}

	@Override
	public String toString() {
		return "TrainingSessionsDetailEntity [sid=" + sid + ", technology=" + technology + ", topics=" + topics
				+ ", starttime=" + starttime + ", endtime=" + endtime + ", sessiondate=" + sessiondate
				+ ", timeduration=" + timeduration + ", batch=" + batch + ", pempids=" + pempids + ", doe=" + doe
				+ ", dom=" + dom + ", userid=" + userid + ", comments=" + comments + ", name=" + name + ", techName="
				+ techName + ", totalDuration=" + totalDuration + "]";
	}
	
	

}
