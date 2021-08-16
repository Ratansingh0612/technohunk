package com.synergisitic.it.web.form;

import java.sql.Timestamp;

import javax.persistence.Column;

/**
 * 
 * @author Nagendra
 * @since 09-04-2018
 */
public class PendingTopicFeedbackForm {
        private long ptfid;
        private String consultantid;
        private Timestamp dos;
        private String technology;
        private String topics;
    	private long sid;
    	private long comment;
        private Timestamp doe;
        
		/**
		 * @return the ptfid
		 */
		public long getPtfid() {
			return ptfid;
		}
		/**
		 * @param ptfid the ptfid to set
		 */
		public void setPtfid(long ptfid) {
			this.ptfid = ptfid;
		}
		
		
		/**
		 * @return the sid
		 */
		public long getSid() {
			return sid;
		}
		/**
		 * @param sid the sid to set
		 */
		public void setSid(long sid) {
			this.sid = sid;
		}
		/**
		 * @return the comment
		 */
		public long getComment() {
			return comment;
		}
		/**
		 * @param comment the comment to set
		 */
		public void setComment(long comment) {
			this.comment = comment;
		}
		/**
		 * @return the consultantid
		 */
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
