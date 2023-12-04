package edu.neu.csye6200.ConstructionManagement.repository;

import edu.neu.csye6200.ConstructionManagement.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface EmployeesRepository extends CrudRepository<Employee, Integer> {
    @Query(value = "SELECT * FROM employees",
            nativeQuery = true)
    Collection<Employee> findUserId1();
}
