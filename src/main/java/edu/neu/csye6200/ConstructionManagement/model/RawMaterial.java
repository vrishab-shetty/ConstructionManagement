package edu.neu.csye6200.ConstructionManagement.model;

import jakarta.persistence.*;

@Entity(name = "raw_materials")
public class RawMaterial {

    @Id()
    @Column(name = "Material_ID")
    private int materialId;

    @Column(name = "Quantity")
    private int quantity;

    @Column(name = "Total_Cost")
    private int totalCost;

    @ManyToOne
    @JoinColumn(name = "Transction_ID", referencedColumnName = "Transction_ID")
    private Transaction transaction;

    // Constructors, getters, setters, etc.

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
