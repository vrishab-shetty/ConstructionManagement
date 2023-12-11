// DepartmentManagement.js
import React, { useState, useEffect } from "react";
import axios from "axios";
import moment from "moment";
import DepartmentDetails from "./DepartmentDetails"; // Import the new component

const DepartmentManagement = ({ closePopup }) => {
  const [departments, setDepartments] = useState([]);
  const [selectedDepartment, setSelectedDepartment] = useState(null);

  useEffect(() => {
    fetchDepartments();
  }, []);

  const fetchDepartments = async () => {
    try {
      const response = await axios.get("http://localhost:8080/dept/getAll", {
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
        },
      });

      console.log(response.data);
      setDepartments(response.data);
    } catch (error) {
      console.error("Error fetching departments:", error);
    }
  };

  const handleDepartmentClick = (department) => {
    setSelectedDepartment(department);
  };

  return (
    <div className="department-management">
      <h2>Manage Departments</h2>
      <table className="department-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Address</th>
            <th>Contact Details</th>
            <th>Email ID</th>
            <th>Joining Date</th>
            <th>Last Name</th>
            <th>Role</th>
            <th>Status</th>
          </tr>
        </thead>
        <tbody>
          {departments.map((department) => (
            <tr key={department.id} onClick={() => handleDepartmentClick(department)}>
              <td>{department.id}</td>
              <td>{department.name}</td>
              <td>{department.employees[0].address}</td>
              <td>{department.employees[0].contactDetails}</td>
              <td>{department.employees[0].emailId}</td>
              <td>{moment(department.employees[0].joiningDate).format("YYYY-MM-DD")}</td>
              <td>{department.employees[0].lastName}</td>
              <td>{department.employees[0].role.designation}</td>
              <td>{department.employees[0].status}</td>
            </tr>
          ))}
        </tbody>
      </table>

      {selectedDepartment && <DepartmentDetails selectedDepartment={selectedDepartment} />}
    </div>
  );
};

export default DepartmentManagement;
