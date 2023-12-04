package edu.neu.csye6200.ConstructionManagement.controller;

import edu.neu.csye6200.ConstructionManagement.Department;
import edu.neu.csye6200.ConstructionManagement.model.Employee;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

import java.util.List;


public class EmployeeDepartment extends Department {

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees;

}
