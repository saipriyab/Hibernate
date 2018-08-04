package com.example2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flower2")
public class Flower1 {
@Id
@Column(name="flowerid")
private String fid;
@Column(name="flowername")
private String fname;
@Column(name="price")
private int p;
@Column(name="color")
private String c;

public Flower1() {
	super();
	// TODO Auto-generated constructor stub
}
public String getFid() {
	return fid;
}
public void setFid(String fid) {
	this.fid = fid;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public int getP() {
	return p;
}
public void setP(int p) {
	this.p = p;
}
public String getC() {
	return c;
}

public void setC(String c2) {
	// TODO Auto-generated method stub
	this.c = c2;
}


}
