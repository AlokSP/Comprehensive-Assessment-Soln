package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Employee;
import com.example.demo.exception.ResourceAlreadyFoundException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EmployeeRepository;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public ResponseEntity<Employee> saveEmployee(Employee employee) {
    	 if(repository.existsById(employee.getId())) {
    		 throw new ResourceAlreadyFoundException("Employee is already exists with = " + employee.getId());
    	 }
    	 else 
         return new ResponseEntity<>(repository.save(employee), HttpStatus.OK);
    	
    }

    public List<Employee> getEmployees() {
        return repository.findAll();
    }

    
    public ResponseEntity <Employee> getEmployeeById(int id) {
        Employee employee =repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found Employee with id = " + id));

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    
    
    public List <Employee> findEmpwithSorting(String field1, String field2){
    	
    	List <Employee> emplist=repository.findAll(Sort.by(field1).descending().and(Sort.by(field2).ascending()));
    	return emplist;
    }
   
    
    public ResponseEntity<Employee> updateSalary(int id, int salary) {
      Employee employee = repository.findById(id) .orElseThrow(() -> new ResourceNotFoundException("Not found Employee with id = " + id));
      employee.setSalary(salary);
      
      return new ResponseEntity<>(repository.save(employee), HttpStatus.OK);
    }

   
    public ResponseEntity<Employee> deleteEmployee(int id) {
      Employee employee = repository.findById(id) .orElseThrow(() -> new ResourceNotFoundException("Not found Employee with id = " + id));
      repository.deleteById(id);

      return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    
    
}