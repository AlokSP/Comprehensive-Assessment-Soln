package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Employee;
import com.example.demo.exception.ResourceAlreadyFoundException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;
    
    @Autowired
    private EmployeeRepository repository;
    
    
    @GetMapping("/")
    public String home() {
        return "Welcome to Employee Management Project";
    }

    @PostMapping("/addEmployee")
    public ResponseEntity <Employee> addEmployee(@RequestBody Employee employee) {
    	
         return service.saveEmployee(employee);
    }


    @GetMapping("/employees")
    public List<Employee> findAllEmployees() {
        return service.getEmployees();
    }
    @GetMapping("/employees/sortBySalaryInDesc")
    public List<Employee> SortingwithSalaryInDesc(){
    	return service.findEmpwithSorting("salary", "name");
    }

    @GetMapping("/employeeById/{id}")
    public  ResponseEntity <Employee>  findEmployeeById(@PathVariable int id) {
        return service.getEmployeeById(id);
    }
    
    @PutMapping("/updateSalary/{id}/{salary}")
    public ResponseEntity<Employee> updateEmployeeSalary(@PathVariable int id, @PathVariable int salary) {
     
    	return service.updateSalary(id, salary);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable int id) {
     
      return service.deleteEmployee(id);
    }

   
}
