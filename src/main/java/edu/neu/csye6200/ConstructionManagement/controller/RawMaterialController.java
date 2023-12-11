package edu.neu.csye6200.ConstructionManagement.controller;

import edu.neu.csye6200.ConstructionManagement.model.RawMaterial;
import edu.neu.csye6200.ConstructionManagement.service.RawMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/raw material")
@CrossOrigin(origins = "http://localhost:3000")
public class RawMaterialController {

    @Autowired
    private RawMaterialService service;

    @GetMapping("all")
    public @ResponseBody Iterable<RawMaterial> getAllRawMaterial() {
        return service.getAll();
    }

}
