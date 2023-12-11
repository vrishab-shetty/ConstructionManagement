package edu.neu.csye6200.ConstructionManagement.repository;

import edu.neu.csye6200.ConstructionManagement.model.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface EmployeesRepository extends CrudRepository<Employee, Integer> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO employees (Employee_ID, First_Name, Last_Name, Contact_Details, Email_ID, Address, Joining_Date, Role_ID, Salary_ID, Status) VALUES (:id, :firstName, :lastName, :contactDetails, :emailId, :address, :joiningDate, :roleId, :salaryId, :status)", nativeQuery = true)
    void addEmployee(@Param("id") Integer id,
                     @Param("firstName") String firstName,
                     @Param("lastName") String lastName,
                     @Param("contactDetails") long contactDetails,
                     @Param("emailId") String emailId,
                     @Param("address") String address,
                     @Param("joiningDate") Date joiningDate,
                     @Param("roleId") int roleId,
                     @Param("salaryId") int salaryId,
                     @Param("status") String status);

    @Modifying
    @Transactional
    @Query(value = "UPDATE employees SET First_Name = :firstName, Last_Name = :lastName, Contact_Details = :contactDetails, Email_ID = :emailId, Address = :address, Joining_Date = :joiningDate, Role_ID = :roleId, Salary_ID = :salaryId, Status = :status WHERE Employee_ID = :employeeId", nativeQuery = true)
    void updateEmployee(@Param("employeeId") int employeeId,
                        @Param("firstName") String firstName,
                        @Param("lastName") String lastName,
                        @Param("contactDetails") long contactDetails,
                        @Param("emailId") String emailId,
                        @Param("address") String address,
                        @Param("joiningDate") Date joiningDate,
                        @Param("roleId") int roleId,
                        @Param("salaryId") int salaryId,
                        @Param("status") String status);
}
