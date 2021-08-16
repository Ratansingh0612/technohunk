package com.synergisitic.it.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.techquiz.trainer.dao.entity.TrainingSessionsDetailEntity;

@Entity
@Table(name = "consultant_topics_feedback_tbl")
public class TopicFeedbackEntity {
        private long tfid;
        private FeedbackEntity feedback;
        private String consultantid;
        private Timestamp doe;
       // private long sid;
       private TrainingSessionsDetailEntity sid;
	    private String comment;
		@Override
		public String toString() {
			return "TopicFeedbackEntity [tfid=" + tfid + ", feedback=" + feedback + ", consultantid=" + consultantid
					+ ", doe=" + doe + ", sid=" + sid + ", comment=" + comment + "]";
		}
		/**
		 * @return the tfid
		 */
		
		@Id
		@GeneratedValue
		public long getTfid() {
			return tfid;
		}
		/**
		 * @param tfid the tfid to set
		 */
		public void setTfid(long tfid) {
			this.tfid = tfid;
		}
		
	
		/**
		 * @return the feedback
		 */
		@OneToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "fid")
		public FeedbackEntity getFeedback() {
			return feedback;
		}
		/**
		 * @param feedback the feedback to set
		 */
		public void setFeedback(FeedbackEntity feedback) {
			this.feedback = feedback;
		}
		
		
		 @JoinColumn(name = "sid", unique = true)
		  @OneToOne(cascade = CascadeType.ALL)
		public TrainingSessionsDetailEntity getSid() {
			return sid;
		}
		
		public void setSid(TrainingSessionsDetailEntity sid) {
			this.sid = sid;
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
		 * @return the comment
		 */
		@Column(length=200)
		public String getComment() {
			return comment;
		}
		/**
		 * @param comment the comment to set
		 */
		public void setComment(String comment) {
			this.comment = comment;
		}
	    
	    
        
}
