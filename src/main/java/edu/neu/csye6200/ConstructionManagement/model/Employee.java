package edu.neu.csye6200.ConstructionManagement.model;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Employee_ID")
    private int employeeId;

    @Column(name = "First_Name", nullable = false)
    private String firstName;

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

    @Column(name = "Role_ID", nullable = false)
    private int roleId;

    @Column(name = "Salary_ID", nullable = false)
    private int salaryId;

    @Column(name = "Status", nullable = false)
    private String status;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

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

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(int salaryId) {
        this.salaryId = salaryId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
