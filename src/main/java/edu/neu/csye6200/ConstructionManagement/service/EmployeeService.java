package edu.neu.csye6200.ConstructionManagement.service;

import edu.neu.csye6200.ConstructionManagement.model.Employee;
import edu.neu.csye6200.ConstructionManagement.model.Role;
import edu.neu.csye6200.ConstructionManagement.model.Salary;
import edu.neu.csye6200.ConstructionManagement.repository.DepartmentRepository;
import edu.neu.csye6200.ConstructionManagement.repository.EmployeesRepository;
import edu.neu.csye6200.ConstructionManagement.repository.SalaryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeesRepository repo;

    @Autowired
    private DepartmentRepository deptRepo;

    @Autowired
    private SalaryRepository salaryRepository;

    public void add(Employee employee, int departmentId) {
        repo.addEmployee(
                employee.getId(),
                employee.getName(),
                employee.getLastName(),
                employee.getContactDetails(),
                employee.getEmailId(),
                employee.getAddress(),
                employee.getJoiningDate(),
                employee.getRole().getRoleId(),
                employee.getSalary().getSalaryId(),
                employee.getStatus());

        deptRepo.insertIntoEmployeeDept(employee.getId(), departmentId);

    }

    public void update(Employee employee) {
        // Assuming that employee's ID, role, and salary IDs are set and valid

        repo.updateEmployee(
                employee.getId(),
                employee.getName(),
                employee.getLastName(),
                employee.getContactDetails(),
                employee.getEmailId(),
                employee.getAddress(),
                employee.getJoiningDate(),
                employee.getRole().getRoleId(),
                employee.getStatus());
        salaryRepository.save(employee.getSalary());
    }



    // Method to get the role of an employee
    public Role getRoleByEmployeeId(int employeeId) {
        return repo.findById(employeeId)
                .map(Employee::getRole)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));
    }

    public void updateEmployeeSalary(Salary salary) {
        salaryRepository.save(salary);
    }

    public Salary createSalary(Salary salary) {
        return salaryRepository.save(salary);
    }

    public Iterable<Employee> getAll() {
        // This returns a JSON or XML with the users
        return repo.findAll();
    }

    public void delete(Integer id) {
        // This returns a JSON or XML with the users
        Optional<Employee> employee = repo.findById(id);
        if(employee.isPresent()) {
            Employee employeeObj = employee.get();
            deptRepo.deleteIntoEmployeeDept(employeeObj.getId());
            repo.deleteById(id);
            salaryRepository.deleteById(employeeObj.getSalary().getSalaryId());
            return;
        }

        throw new IllegalArgumentException("Employee doesn't exist with "+id);
    }


}
