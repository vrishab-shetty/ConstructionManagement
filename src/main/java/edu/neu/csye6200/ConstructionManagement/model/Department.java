package edu.neu.csye6200.ConstructionManagement.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Dept_ID")
    private int id;

    @Column(name = "Dept_Name", nullable = false)
    private String name;

    @OneToMany()
    @JoinTable(
            name = "employee_dept",
            joinColumns = @JoinColumn(name = "Dept_ID"),
            inverseJoinColumns = @JoinColumn(name = "Employee_ID")
    )
    private List<Employee> employees;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

}
