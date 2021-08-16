package com.synergisitic.it.web.form;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * 
 * @author nagendra.yadav
 * 
 *
 */
public class UserId implements HttpSessionBindingListener, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Set<UserId> currentLoggedUsers=new LinkedHashSet<UserId>();
	

	public static Set<UserId> getCurrentLoggedUsers() {
		return currentLoggedUsers;
	}

	public UserId(){
		System.out.println(")#)#HttpSessionBindingListener@)#)#");
	}
	//This is id of object store in db
	private int id;
	//this is loginid of the logged user into the application
	private String loginId;
	private String email;
	private String batch;
	private String name;
	private String address;
	private String salutation;
	private String password;
	private String role;
	private String homePage;
	private boolean deleteAllow;
	private String consultantid;
	private Date loggedInTime;
	private String problemId;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProblemId() {
		return problemId;
	}

	public void setProblemId(String problemId) {
		this.problemId = problemId;
	}

	public Date getLoggedInTime() {
		return loggedInTime;
	}

	public void setLoggedInTime(Date loggedInTime) {
		this.loggedInTime = loggedInTime;
	}

	public String getConsultantid() {
		return consultantid;
	}

	public void setConsultantid(String consultantid) {
		this.consultantid = consultantid;
	}

	/**
	 * @return the deleteAllow
	 */
	public boolean isDeleteAllow() {
		return deleteAllow;
	}

	/**
	 * @param deleteAllow the deleteAllow to set
	 */
	public void setDeleteAllow(boolean deleteAllow) {
		this.deleteAllow = deleteAllow;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getHomePage() {
		return homePage;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	
	

	@Override
	public String toString() {
		return "UserId [id=" + id + ", loginId=" + loginId + ", batch=" + batch + ", name=" + name + ", address="
				+ address + ", salutation=" + salutation + ", role=" + role + ", homePage=" + homePage
				+ ", consultantid=" + consultantid + ", problemId=" + problemId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((loginId == null) ? 0 : loginId.hashCode());
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
		UserId other = (UserId) obj;
		if (loginId == null) {
			if (other.loginId != null)
				return false;
		} else if (!loginId.equals(other.loginId))
			return false;
		return true;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("___________valueBound__________ = "+this);
		currentLoggedUsers.add(this);
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("___________valueUnbound__________ = "+this);
		currentLoggedUsers.remove(this);
	}
	

}
