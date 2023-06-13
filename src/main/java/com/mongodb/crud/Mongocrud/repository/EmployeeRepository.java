package com.mongodb.crud.Mongocrud.repository;

import com.mongodb.crud.Mongocrud.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

    List<Employee> findAllByEmailId(String emailId);
}
