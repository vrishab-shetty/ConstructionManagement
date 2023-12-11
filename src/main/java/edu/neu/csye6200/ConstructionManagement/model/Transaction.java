package edu.neu.csye6200.ConstructionManagement.model;

import jakarta.persistence.*;
import org.springframework.context.annotation.Lazy;

import java.util.Date;

@Entity(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Transction_ID")
    private int id;

    @Column(name = "Date_Of_Transaction")
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
