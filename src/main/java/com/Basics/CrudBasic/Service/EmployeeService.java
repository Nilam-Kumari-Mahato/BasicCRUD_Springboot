package com.Basics.CrudBasic.Service;


import java.util.Optional;
import java.util.List;

import org.springframework.stereotype.Component;

import com.Basics.CrudBasic.Entity.Employee;
import com.Basics.CrudBasic.Repository.EmployeeRepository; 

@Component
public class EmployeeService {
	
	EmployeeRepository employeeRepository;
	
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public Employee createdEmployee(Employee employeeReq) {
		Employee employeeResp = employeeRepository.save(employeeReq);
		return employeeResp;
	}
	
	public Employee getEmployee(int id) {
		Optional<Employee> employeeResp = employeeRepository.findById(id);
		
		if(employeeResp.isPresent()) {
			return employeeResp.get();
		}
		return null;
	}
	
	
	public List<Employee> getAllEmployee(){
		List<Employee> employeeList = employeeRepository.findAll();
		
		return employeeList;
	}
	
	public Employee updateEmp(int id , Employee empReq) {
		Optional<Employee> Existemployee = employeeRepository.findById(id);
		
		if(Existemployee.isEmpty()) {
			return null ;
		}
		
		Employee employeetoSave = Existemployee.get();
		employeetoSave.setName(empReq.getName());
		employeetoSave.setAge(empReq.getAge());
		employeetoSave.setDept(empReq.getDept());
		employeetoSave.setSal(empReq.getSal());
		
		return employeeRepository.save(employeetoSave);
	}
	
	public Employee delEmp(int id) {
		Optional<Employee> deletedEmp = employeeRepository.findById(id);
		
		if(deletedEmp.isEmpty()) {
			return null;
		}
		employeeRepository.deleteById(id);
		return deletedEmp.get();
	}
}



