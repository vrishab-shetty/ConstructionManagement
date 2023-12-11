package edu.neu.csye6200.ConstructionManagement.service;

import edu.neu.csye6200.ConstructionManagement.model.Employee;
import edu.neu.csye6200.ConstructionManagement.model.Transaction;
import edu.neu.csye6200.ConstructionManagement.repository.EmployeesRepository;
import edu.neu.csye6200.ConstructionManagement.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repo;

    public void add(Transaction p) {
        repo.save(p);
    }

    public void update(Transaction p) {
        repo.save(p);
    }

    public Iterable<Transaction> getAll() {
        // This returns a JSON or XML with the users
        return repo.findAll();
    }

    public void delete(Integer id) {
        // This returns a JSON or XML with the users
        repo.deleteById(id);

    }

    public Transaction getById(Integer id) {
        return repo.findById(id).orElseThrow();
    }

}
