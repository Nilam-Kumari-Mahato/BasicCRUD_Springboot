package com.Basics.CrudBasic.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;


import com.Basics.CrudBasic.Entity.Employee;
import com.Basics.CrudBasic.Service.EmployeeService;

@RestController  // it means that the below controller will handle the rest request
@RequestMapping("/api/Employee")  //mapping to the given field 
public class EmployeeController {
	
	EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	//Create Employee
	@PostMapping
	public ResponseEntity<Employee>  createEmployee(@RequestBody Employee employee) {
		Employee createdEmployee = employeeService.createdEmployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
		
	}
	
	//Read Employee
	@GetMapping("/get/{id}")
	public ResponseEntity<Employee> readEmployee(@PathVariable int id){
		Employee employeeResp = employeeService.getEmployee(id);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(employeeResp);
	}
	
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> readEmployee(){
		List<Employee> employeeList = employeeService.getAllEmployee();
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(employeeList);
	}
	
	//Update Employee
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id , @RequestBody Employee empReq){
		Employee updatedEmp = employeeService.updateEmp(id , empReq);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(updatedEmp);
	}
	
	
	//Delete Employee
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Employee> delEmployee(@PathVariable int id){
		Employee deletedEmp = employeeService.delEmp(id);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(deletedEmp);
	}
}
