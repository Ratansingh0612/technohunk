package com.synergisitic.it.model;

public class UpdateAllUserDetails {
private String ln;
private String email;
private String mobile;
public String getLn() {
	return ln;
}
public void setLn(String ln) {
	this.ln = ln;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
@Override
public String toString() {
	return "updateAllUserDetails [ln=" + ln + ", email=" + email + ", mobile="
			+ mobile + "]";
}


}
