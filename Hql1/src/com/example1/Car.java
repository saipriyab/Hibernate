package com.example1;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {
	@Id
private String RegNo;
private String Model;
private String Color;
private String Manfacturer;
private int price;
public String getRegNo() {
	return RegNo;
}
public void setRegNo(String regNo) {
	RegNo = regNo;
}
public String getModel() {
	return Model;
}
public void setModel(String model) {
	Model = model;
}
public String getColor() {
	return Color;
}
public void setColor(String color) {
	Color = color;
}
public String getManfacturer() {
	return Manfacturer;
}
public void setManfacturer(String manfacturer) {
	Manfacturer = manfacturer;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}

}
