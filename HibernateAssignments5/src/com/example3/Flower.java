package com.example3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flower9")
public class Flower {
@Id
@Column(name="flowerid")
private int flowerid;
@Column(name="flowername")
private String flowername;
@Column(name="color")
private String color;
@Column(name="price")
private int price;
public int getFlowerid() {
	return flowerid;
}
public void setFlowerid(int flowerid) {
	this.flowerid = flowerid;
}
public String getFlowername() {
	return flowername;
}
public void setFlowername(String flowername) {
	this.flowername = flowername;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}

}
