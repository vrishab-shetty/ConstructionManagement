package edu.neu.csye6200.ConstructionManagement.controller;

import edu.neu.csye6200.ConstructionManagement.model.Supplier;
import edu.neu.csye6200.ConstructionManagement.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/supplier")
@CrossOrigin(origins = "http://localhost:3000")
public class SupplierController {

    @Autowired
    private SupplierService service;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Supplier> getAllSupplier() {
        // This returns a JSON or XML with the users
        return service.getAll();
    }
}
