package edu.neu.csye6200.ConstructionManagement.service;

import edu.neu.csye6200.ConstructionManagement.model.Supplier;
import edu.neu.csye6200.ConstructionManagement.model.Transaction;
import edu.neu.csye6200.ConstructionManagement.repository.SupplierRepository;
import edu.neu.csye6200.ConstructionManagement.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository repo;

    public void add(Supplier p) {
        repo.save(p);
    }

    public void update(Supplier p) {
        repo.save(p);
    }

    public Iterable<Supplier> getAll() {
        // This returns a JSON or XML with the users
        return repo.findAll();
    }

    public void delete(Integer id) {
        // This returns a JSON or XML with the users
        repo.deleteById(id);

    }

    public Supplier getById(Integer id) {
        return repo.findById(id).orElseThrow();
    }

}
