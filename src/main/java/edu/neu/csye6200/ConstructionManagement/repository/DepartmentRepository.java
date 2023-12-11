package edu.neu.csye6200.ConstructionManagement.repository;

import edu.neu.csye6200.ConstructionManagement.model.Department;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Transactional
    @Modifying(clearAutomatically= true)
    @Query(value = "INSERT INTO employee_dept (Employee_ID, Dept_ID) VALUES (:employeeId, :deptId)", nativeQuery = true)
    void insertIntoEmployeeDept(@Param("employeeId") int employeeId,@Param("deptId") int deptId);

    @Transactional
    @Modifying(clearAutomatically= true)
    @Query(value = "DELETE FROM employee_dept WHERE Employee_ID = :employeeId", nativeQuery = true)
    void deleteIntoEmployeeDept(@Param("employeeId") int employeeId);
}
