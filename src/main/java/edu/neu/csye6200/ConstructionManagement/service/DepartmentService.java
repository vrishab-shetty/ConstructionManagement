package edu.neu.csye6200.ConstructionManagement.service;

import edu.neu.csye6200.ConstructionManagement.model.Department;
import edu.neu.csye6200.ConstructionManagement.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository repo;

    public Iterable<Department> getAll() {
        // This returns a JSON or XML with the users
        return repo.findAll();
    }

    public Department getById(Integer id) {
        return repo.findById(id).orElseThrow();
    }
}
