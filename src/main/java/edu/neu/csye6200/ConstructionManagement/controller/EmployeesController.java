package edu.neu.csye6200.ConstructionManagement.controller;

import edu.neu.csye6200.ConstructionManagement.model.Employee;
import edu.neu.csye6200.ConstructionManagement.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/employee")
public class EmployeesController {

    @Autowired
    private EmployeesRepository repo;

    @PostMapping(path = "/add")
    public @ResponseBody String add(@RequestBody Employee p) {
        repo.save(p);
        return "Saved";
    }

    @PutMapping(path = "/update")
    public @ResponseBody String update(@RequestBody Employee p) {
        repo.save(p);
        return "Updated";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Employee> getAll() {
        // This returns a JSON or XML with the users
        return repo.findAll();
    }

    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody String delete(@PathVariable("id") Integer id) {
        // This returns a JSON or XML with the users
        repo.deleteById(id);

        return "Deleted";
    }

    @GetMapping(path = "/1")
    public @ResponseBody Iterable<Employee> get1() {
        // This returns a JSON or XML with the users
        return repo.findUserId1();
    }
}
