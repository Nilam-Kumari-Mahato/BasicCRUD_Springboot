package com.Basics.CrudBasic.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity  //it tell spring jpa that this is a entity which will be stored in db
public class Employee {  //POJO class
	
	@Id
	private int id;
	
	private String name;
	private int age ;
	private String dept;
	private int sal ;
	
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
}
