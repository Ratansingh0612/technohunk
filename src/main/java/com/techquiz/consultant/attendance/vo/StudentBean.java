package com.techquiz.consultant.attendance.vo;

import java.io.Serializable;

public class StudentBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String firstName;
	private String mName;
	private String lName;
	private String dob;
	private String doa;
	private String eMail;
	private String phone;
	private String address;
	private String fatherName;
	private String address1;
	private String address2;
	private String pin;
	private String datepicker;
	public StudentBean(){
		//System.out.println("+++++++++++++StudentBean+++++++++++++++++");
	}
	
	public StudentBean(int id, String firstName, String mName, String lName,
			String dob, String doa, String eMail, String phone, String address,
			String fatherName, String address1, String address2, String pin) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.mName = mName;
		this.lName = lName;
		this.dob = dob;
		this.doa = doa;
		this.eMail = eMail;
		this.phone = phone;
		this.address = address;
		this.fatherName = fatherName;
		this.address1 = address1;
		this.address2 = address2;
		this.pin = pin;
	}
	/*public StudentBean(String string, String string2, String string3) {
		
	}*/
	public String getDatepicker() {
		return datepicker;
	}
	public void setDatepicker(String datepicker) {
		this.datepicker = datepicker;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getDoa() {
		return doa;
	}
	public void setDoa(String doa) {
		this.doa = doa;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	
	

}
