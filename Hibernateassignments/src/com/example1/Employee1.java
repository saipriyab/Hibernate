package com.example1;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="updateLogTab1")
public class Employee1 {
@Id
@Column(name="mid")
private long modification_id;
@Column(name="d")
private Date date_of_modification;
@Column(name="des")
private String designation;
@Column(name="basic")
private float basicpay;
public long getModification_id() {
	return modification_id;
}
public void setModification_id(long modification_id) {
	this.modification_id = modification_id;
}
public Date getDate_of_modification() {
	return new java.sql.Date(date_of_modification.getTime());
}
public void setDate_of_modification(Date date_of_modification) {
	this.date_of_modification = date_of_modification;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public float getBasicpay() {
	return basicpay;
}
public void setBasicpay(float basicpay) {
	this.basicpay = basicpay;
}
@Override
public String toString() {
	return "Employee1 [modification_id=" + modification_id + ", date_of_modification=" + date_of_modification
			+ ", designation=" + designation + ", basicpay=" + basicpay + "]";
}

}
