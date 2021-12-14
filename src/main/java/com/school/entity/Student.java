package com.school.entity;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "student1")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private long student_id;

	@Column(name = "first_name")
	private String fname;

	@Column(name = "last_name")
	private String lname;
	
	@Column(name = "grade")
	private String grade;
	
	@Column(name = "status")
	private String status;


	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getStatus() {
		return status.toUpperCase();
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFname() {
		return fname;
	}

	public long getStudentId() {
		return student_id;
	}

	public void setStudentId(long student_id) {
		this.student_id = student_id;
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
}
