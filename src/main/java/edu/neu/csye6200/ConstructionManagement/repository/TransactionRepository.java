package edu.neu.csye6200.ConstructionManagement.repository;

import edu.neu.csye6200.ConstructionManagement.model.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
}
