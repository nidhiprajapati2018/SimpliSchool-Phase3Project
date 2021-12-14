package com.school.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "teacher")
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "teacher_id")
	private long teacherid;

	@Column(name = "first_name")
	private String fname;

	@Column(name = "last_name")
	private String lname;
	
	@Column(name = "learning_expert_grade")
	private String let;
	
	@Column(name = "subject_expert")
	private String set;
	
	@Column(name = "phone_no")
	private String phone;

	@Column(name= "email")
	private String email;

	public long getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(long teacherid) {
		this.teacherid = teacherid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getLet() {
		return let;
	}

	public void setLet(String let) {
		this.let = let;
	}

	public String getSet() {
		return set;
	}

	public void setSet(String set) {
		this.set = set;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

}
