package com.anpfrnds.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address 
{
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="address_id")
     private int id;
	 
	 @Column(name="street")
     private String street;
	 
	 @OneToOne
	 @JoinColumn(name="emp_id")
     private Employee employee;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Address(int id, String street, Employee employee) {
		super();
		this.id = id;
		this.street = street;
		this.employee = employee;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}    
}
