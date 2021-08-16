package com.synergisitic.it.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.techquiz.trainer.dao.entity.TrainingSessionsDetailEntity;

@Entity
@Table(name = "pending_topics_feedback_tbl")
public class PendingTopicFeedbackEntity {
        private long ptfid;
        private String consultantid;
    	private String comment;
        private Timestamp dos;
        private String technology;
        private String topics;
        private Timestamp doe;
        private TrainingSessionsDetailEntity trainingSession;
        
		/**
		 * @return the ptfid
		 */
        
        @Id
        @GeneratedValue
		public long getPtfid() {
			return ptfid;
		}
		/**
		 * @param ptfid the ptfid to set
		 */
		public void setPtfid(long ptfid) {
			this.ptfid = ptfid;
		}
		
		@ManyToOne(fetch = FetchType.EAGER,  cascade = CascadeType.ALL)
	    @JoinColumn(name = "sid")
		public TrainingSessionsDetailEntity getTrainingSession() {
			return trainingSession;
		}
		public void setTrainingSession(TrainingSessionsDetailEntity trainingSession) {
			this.trainingSession = trainingSession;
		}
		/**
		 * @return the comment
		 */
		@Column(length=300)
		public String getComment() {
			return comment;
		}
		/**
		 * @param comment the comment to set
		 */
		public void setComment(String comment) {
			this.comment = comment;
		}
		/**
		 * @return the consultantid
		 */
		@Column(length=100)
		public String getConsultantid() {
			return consultantid;
		}
		/**
		 * @param consultantid the consultantid to set
		 */
		public void setConsultantid(String consultantid) {
			this.consultantid = consultantid;
		}
		/**
		 * @return the dos
		 */
		public Timestamp getDos() {
			return dos;
		}
		/**
		 * @param dos the dos to set
		 */
		public void setDos(Timestamp dos) {
			this.dos = dos;
		}
		/**
		 * @return the technology
		 */
		@Column(length=50)
		public String getTechnology() {
			return technology;
		}
		/**
		 * @param technology the technology to set
		 */
		public void setTechnology(String technology) {
			this.technology = technology;
		}
		/**
		 * @return the topics
		 */
		@Column(length=300)
		public String getTopics() {
			return topics;
		}
		/**
		 * @param topics the topics to set
		 */
		public void setTopics(String topics) {
			this.topics = topics;
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
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "PendingTopicFeedbackEntity [ptfid=" + ptfid + ", consultantid=" + consultantid + ", dos=" + dos
					+ ", technology=" + technology + ", topics=" + topics + ", doe=" + doe + "]";
		}
        
}
