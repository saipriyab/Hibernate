package hibernateassignments3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee24")
public class Employee {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
@Column(name="designation")
private String designation;
@Column(name="salary")
private int salary;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}

	
	
}
