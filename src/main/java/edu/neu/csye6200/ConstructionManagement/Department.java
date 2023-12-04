package edu.neu.csye6200.ConstructionManagement;

import jakarta.persistence.*;

@MappedSuperclass
public class Department {

    @Column(name = "Dept_ID")
    private Long id;

    @Column(name = "Dept_Name", nullable = false)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
