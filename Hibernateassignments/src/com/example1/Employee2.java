package com.example1;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employeelogtab")
public class Employee2 {
@Id
@Column(name="ecode")
private long ecode;
@Column(name="ename")
private String ename;
@Column(name="des")
private String designation;
@Column(name="s")
private float salary;
@Column(name="d1")
private Date mdate;
public long getEcode() {
	return ecode;
}
public void setEcode(long ecode) {
	this.ecode = ecode;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public float getSalary() {
	return salary;
}
public void setSalary(float salary) {
	this.salary = salary;
}
public Date getMdate() {
	return new java.sql.Date(mdate.getTime());
}
public void setMdate(Date mdate) {
	this.mdate = mdate;
}

}
