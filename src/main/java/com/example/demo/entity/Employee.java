package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "EMP_TBL")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_generator")
    @Column(name="id", insertable=true, updatable=true, unique=true, nullable=false)
    private int id;
    private String name;
    private int salary;
    private String designation;
   
    public Employee() {
    	
    }

	public Employee(int id, String name, int salary, String designation) {
		
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.designation = designation;
	}
	
	public Employee( String name, int salary, String designation) {
		
		this.name = name;
		this.salary = salary;
		this.designation = designation;
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", designation=" + designation + "]";
	}

	
    
	
    
}

