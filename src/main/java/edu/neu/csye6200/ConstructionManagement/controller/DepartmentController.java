package edu.neu.csye6200.ConstructionManagement.controller;

import edu.neu.csye6200.ConstructionManagement.model.Department;
import org.springframework.stereotype.Controller;

import edu.neu.csye6200.ConstructionManagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/dept")
@CrossOrigin(origins = "http://localhost:3000")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @GetMapping(path = "/getAll")
    public @ResponseBody  Iterable<Department> getAllDepartment() {
        return service.getAll();
    }


    @GetMapping(path = "/get/{id}")
    public @ResponseBody Department getAll(@PathVariable("id") Integer id) {
        return service.getById(id);
    }
}
