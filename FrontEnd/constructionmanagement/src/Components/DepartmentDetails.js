// DepartmentDetails.js
import React from "react";
import moment from "moment";

const DepartmentDetails = ({ selectedDepartment }) => {
  return (
    <div>
      <h3>Details for {selectedDepartment.name}</h3>
      <table>
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
          {selectedDepartment.employees.map((employee) => (
            <tr key={employee.id}>
              <td>{employee.id}</td>
              <td>{employee.name}</td>
              <td>{employee.address}</td>
              <td>{employee.contactDetails}</td>
              <td>{employee.emailId}</td>
              <td>{moment(employee.joiningDate).format("YYYY-MM-DD")}</td>
              <td>{employee.lastName}</td>
              <td>{employee.role.designation}</td>
              <td>{employee.status}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default DepartmentDetails;
