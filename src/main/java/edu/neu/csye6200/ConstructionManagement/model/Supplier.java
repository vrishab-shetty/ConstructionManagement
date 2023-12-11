package edu.neu.csye6200.ConstructionManagement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "supplier")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "Supplier_ID")),
        @AttributeOverride(name = "name", column = @Column(name = "Supplier_Name"))
})
public class Supplier extends Person {

    @Column(name = "Payment_Method", nullable = false)
    private String paymentMethod;

    @Column(name = "Account_Details", nullable = false)
    private String accountDetails;

    @Column(name = "Contact_Details", nullable = false)
    private int contactDetails;

    @OneToOne
    @JoinColumn(name = "Transction_ID", referencedColumnName = "Transction_ID")
    private Transaction transaction;

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getAccountDetails() {
        return accountDetails;
    }

    public void setAccountDetails(String accountDetails) {
        this.accountDetails = accountDetails;
    }

    public int getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(int contactDetails) {
        this.contactDetails = contactDetails;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}

