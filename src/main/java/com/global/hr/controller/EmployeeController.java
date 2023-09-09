package com.global.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.global.hr.entity.Employee;
import com.global.hr.repository.EmployeeRepo;
import com.global.hr.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	
	
	@Autowired 
	private EmployeeService employeeService;
	

//	@RequestMapping(method = RequestMethod.GET , path = "/count")
	@GetMapping("/count")
	public long countEmp() {
		return employeeService.count();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		return ResponseEntity.ok(employeeService.findById(id));
	}
	
	@GetMapping("")
	public Iterable<Employee> findAll(){
		return employeeService.findAll();
	}
	
	@PostMapping("")
	public Employee addEmp(@RequestBody Employee emp) {
		return employeeService.insert(emp);
	}
	
	@PutMapping("")
	public Employee updateEmp(@RequestBody Employee emp ) {
		return employeeService.update(emp);
	}
	
	@GetMapping("/filter/{name}")
	public List<Employee> filter(@PathVariable String name){
		return employeeService.findByName(name);
	}
	
	@GetMapping("/filter")
	public List<Employee> filterWithSalary(@RequestParam String name,@RequestParam double salary){
		return employeeService.findByNameAndSalary(name,salary);
	}
	
	@DeleteMapping("/{empId}")
	public void deleteEmp(@PathVariable("empId") Long id ) {
		 employeeService.deleteById(id);
	}
	
	@PutMapping("/salary")
	public int updateSalary(@RequestParam double salary,@RequestParam Long id) {
		return employeeService.updateSalary(salary,id);
	}
}
