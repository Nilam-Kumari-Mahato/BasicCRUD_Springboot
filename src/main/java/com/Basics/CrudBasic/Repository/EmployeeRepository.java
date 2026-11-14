package com.Basics.CrudBasic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.Basics.CrudBasic.Entity.Employee;

//@Repository
public interface EmployeeRepository  extends JpaRepository<Employee , Integer>{
	
	
}
