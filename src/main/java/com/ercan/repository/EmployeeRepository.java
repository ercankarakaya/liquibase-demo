package com.ercan.repository;

import com.ercan.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Query("SELECT e.name FROM Employee e WHERE e.name LIKE %:employeeName% ")
    String findByName(String employeeName);
}
