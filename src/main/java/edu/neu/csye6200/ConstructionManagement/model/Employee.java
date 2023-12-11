package edu.neu.csye6200.ConstructionManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "employees")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "Employee_ID",nullable = false)),
        @AttributeOverride(name = "name", column = @Column(name = "First_Name", nullable = false))
})
public class Employee extends Person {

    @Column(name = "Last_Name", nullable = false)
    private String lastName;

    @Column(name = "Contact_Details", nullable = false)
    private long contactDetails;

    @Column(name = "Email_ID", nullable = false, length = 320)
    private String emailId;

    @Column(name = "Address", nullable = false)
    private String address;

    @Column(name = "Joining_Date", nullable = false)
    private Date joiningDate;

    @OneToOne()
    @JoinColumn(name = "Role_ID", referencedColumnName = "Role_ID")
    private Role role;

    @OneToOne
    @JoinColumn(name = "Salary_ID", referencedColumnName = "Salary_ID")
    private Salary salary;

    @Column(name = "Status", nullable = false)
    private String status;


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(long contactDetails) {
        this.contactDetails = contactDetails;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Role getRole() {
        return role;
    }

    public void setRoleId(Role role) {
        this.role = role;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalaryId(Salary salary) {
        this.salary = salary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
