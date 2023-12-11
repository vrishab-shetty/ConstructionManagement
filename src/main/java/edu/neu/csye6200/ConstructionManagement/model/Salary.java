package edu.neu.csye6200.ConstructionManagement.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "salary")
public class Salary {

    @Id
    @Column(name = "Salary_ID")
    private int salaryId;

    @OneToOne
    @JoinColumn(name = "Transction_ID", referencedColumnName = "Transction_ID")
    private Transaction transaction;

    @Column(name ="Account_Details")
    private int accountDetails;

    // Constructors, getters, setters, etc.

    public int getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(int salaryId) {
        this.salaryId = salaryId;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public int getAccountDetails() {
        return accountDetails;
    }

    public void setAccountDetails(int accountDetails) {
        this.accountDetails = accountDetails;
    }
}
