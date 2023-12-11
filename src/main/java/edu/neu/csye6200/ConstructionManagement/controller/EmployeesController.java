package edu.neu.csye6200.ConstructionManagement.controller;

import edu.neu.csye6200.ConstructionManagement.model.Department;
import edu.neu.csye6200.ConstructionManagement.model.Employee;
import edu.neu.csye6200.ConstructionManagement.model.Role;
import edu.neu.csye6200.ConstructionManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping(path = "/employee")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeesController {

    @Autowired
    private EmployeeService service;

    @PostMapping(path = "/add/{deptId}")
    public @ResponseBody String addEmployee(@RequestBody Employee p, @PathVariable("deptId") Integer deptId) {
        service.createSalary(p.getSalary());
        service.add(p, deptId);
        return "Saved";
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable("id") int employeeId, @RequestBody Employee employee) {
        employee.setId(employeeId);
        service.update(employee);
        service.updateEmployeeSalary(employee.getSalary());
        return ResponseEntity.ok("Employee updated successfully");
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Employee> getAllEmployee() {
        // This returns a JSON or XML with the users
        return service.getAll();
    }

    @GetMapping(path = "/allByName")
    public @ResponseBody Iterable<Employee> getAllEmployeeByJoiningDate() {
        // This returns a JSON or XML with the users
        Iterable<Employee> employees = service.getAll();
        return StreamSupport.stream(employees.spliterator(), false)
                .sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
    }

    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody String deleteEmployee(@PathVariable("id") Integer id) {
        // This returns a JSON or XML with the users
        service.delete(id);

        return "Deleted";
    }


}
