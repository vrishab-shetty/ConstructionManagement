package edu.neu.csye6200.ConstructionManagement.repository;

import edu.neu.csye6200.ConstructionManagement.model.Department;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    @Query(value = "SELECT d FROM departments d JOIN FETCH finance_department fd WHERE d.Dept_ID = :id", nativeQuery = true)
    Department getDepartmentWithFinance(@Param("id") int id);

    @Transactional
    @Modifying(clearAutomatically= true)
    @Query(value = "INSERT INTO employee_dept (Employee_ID, Dept_ID) VALUES (:employeeId, :deptId)", nativeQuery = true)
    void insertIntoEmployeeDept(@Param("employeeId") int employeeId,@Param("deptId") int deptId);
}
