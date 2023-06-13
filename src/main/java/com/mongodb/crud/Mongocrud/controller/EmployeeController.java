package com.mongodb.crud.Mongocrud.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.crud.Mongocrud.entity.Employee;
import com.mongodb.crud.Mongocrud.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ObjectMapper mapper;

    /**
     * Get All Employees
     */
    @GetMapping("/getEmployees")
    public ResponseEntity<?> getAllEmployees() throws Exception {

        List<Employee> employeeList = employeeRepository.findAll();

        logger.info("List of employees are {}", mapper.writeValueAsString(employeeList));

        return new ResponseEntity<>(employeeList , HttpStatus.OK);
    }

    /**
     * Get Employee By Email Id
     */

    @GetMapping("/getEmployeeByEmail")
    public ResponseEntity<?> getEmployeeByEmail(@RequestParam("emailId") String emailId) throws Exception {

        List<Employee> employeeList = employeeRepository.findAllByEmailId(emailId);

        logger.info("List of Employee by Email id is {}", mapper.writeValueAsString(employeeList));

        return new ResponseEntity<>(employeeList, HttpStatus.OK);

    }

    /**
     *
     * Save Employee Entity
     */
    @PostMapping("/saveEmployee")
    public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) throws Exception{

        employee.setId(UUID.randomUUID().toString());

        Employee savedEmployee = employeeRepository.save(employee);

        logger.info("Saved Employee is {}", mapper.writeValueAsString(savedEmployee));

        return new ResponseEntity<>(savedEmployee, HttpStatus.OK);
    }
}
