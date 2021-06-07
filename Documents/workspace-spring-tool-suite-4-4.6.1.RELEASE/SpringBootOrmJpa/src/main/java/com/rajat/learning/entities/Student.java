package com.rajat.learning.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.mysql.cj.protocol.ColumnDefinition;

@Entity(name="Student")
@Table(name="Student",
		uniqueConstraints = {@UniqueConstraint(columnNames = {"Roll_No"})})
public class Student {
	
	public Student() {
		super();
	}

	@Id
	@SequenceGenerator(
			name="student_sequence",
			sequenceName="student_sequence",
			allocationSize = 1)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator="student_sequence")
	
	@Column(
			name = "Id",
			updatable = false
			)
	private int id;
	@Column(
			name = "Name",
			nullable = false,
			columnDefinition = "text"
			
			)
	private String name;
	@Column(
			name = "Roll_No",
			nullable = false
			)
	private int roll;
	@Column(
			name = "Address",
			nullable = false,
			columnDefinition = "text"
			
			)
	private String address;
	
	public Student(int id, String name, int roll, String address) {
		super();
		this.id = id;
		this.name = name;
		this.roll = roll;
		this.address = address;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", roll=" + roll + ", address=" + address + "]";
	}

}
