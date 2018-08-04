package com.example1;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="employee12")
public class Employee {
@Id
@SequenceGenerator(name = "MySequence", sequenceName = "my_seq", allocationSize=1)
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MySequence")
private long empcode;
@Column(name="Empname")
private String empname;
@Column(name="EmpDesignation")
private String empdesignation;
@Column(name="EmpDOB")
private Date empdob;
@Column(name="EmpJOB")
private Date empjod;
@Column(name="Empage")
private int empage;
@Column(name="EmpBasic_pay")
private float empbasic_pay;
public long getEmpcode() {
	return empcode;
}
public void setEmpcode(long empcode) {
	this.empcode = empcode;
}
public String getEmpname() {
	return empname;
}
public void setEmpname(String empname) {
	this.empname = empname;
}
public String getEmpdesignation() {
	return empdesignation;
}
public void setEmpdesignation(String empdesignation) {
	this.empdesignation = empdesignation;
}
public java.sql.Date getEmpdob() {
	return new java.sql.Date(empdob.getTime());
}
public void setEmpdob(Date empdob) {
	this.empdob=empdob;
}
public java.sql.Date getEmpjod() {
	return new java.sql.Date(empjod.getTime());
}
public void setEmpjod(Date empjod) {
	this.empjod = empjod;
}
public int getEmpage() {
	return empage;
}
public void setEmpage(int empage) {
	this.empage = empage;
}
public float getEmpbasic_pay() {
	return empbasic_pay;
}
public void setEmpbasic_pay(float empbasic_pay) {
	this.empbasic_pay = empbasic_pay;
}
@Override
public String toString() {
	return "Employee [empcode=" + empcode + ", empname=" + empname + ", empdesignation=" + empdesignation + ", empdob="
			+ empdob + ", empjod=" + empjod + ", empage=" + empage + ", empbasic_pay=" + empbasic_pay + "]";
}


 }
