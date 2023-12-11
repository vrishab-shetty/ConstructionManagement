package edu.neu.csye6200.ConstructionManagement.service;

import edu.neu.csye6200.ConstructionManagement.model.RawMaterial;
import edu.neu.csye6200.ConstructionManagement.model.Transaction;
import edu.neu.csye6200.ConstructionManagement.repository.RawMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RawMaterialService {

    @Autowired
    private RawMaterialRepository repo;

    public void add(RawMaterial p) {
        repo.save(p);
    }

    public void update(RawMaterial p) {
        repo.save(p);
    }

    public Iterable<RawMaterial> getAll() {
        return repo.findAll();
    }

    public RawMaterial getById(Integer id) {
        return repo.findById(id).orElseThrow();
    }
}
