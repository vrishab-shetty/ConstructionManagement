import React, { useState, useEffect } from "react";
import axios from "axios";
import "../Styles/EmployeeManagement.css";
import { redirect } from "react-router-dom";

const EmployeeManagement = ({ closePopup }) => {
  const closeModal = () => {
    setShowModal(false);
    setSelectedUser(null);
  };

  const updateUser = (user) => {
    setSelectedUser(user);
    setShowModal(true);
  };
  const [users, setUsers] = useState([]);
  const [selectedUser, setSelectedUser] = useState(null);
  const [showModal, setShowModal] = useState(false);

  useEffect(() => {
    fetchUsers();
  }, []);

  const fetchUsers = async () => {
    try {
      const response = await axios.get("http://localhost:8080/employee/all", {
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
        },
      });
  
      console.log(response.data);
      setUsers(response.data);
    } catch (error) {
      console.error("Error fetching users:", error);
    }
  };

  const deleteUser = async (userId) => {
    // try {
    //   await axios.delete(`http://localhost:5001/api/user/${userId}`);
    //   const updatedUsers = users.filter((user) => user._id !== userId);
    //   setUsers(updatedUsers);
    // } catch (error) {
    //   console.error("Error deleting user:", error);
    // }
  };

  // const updateUserDetails = async (updatedUser) => {
  //     try {
  //         const response = await axios.put(`http://localhost:5001/api/user/${updatedUser._id}`, updatedUser);
  //         console.log('Updated user details:', response.data);
  //         setShowModal(false);
  //         fetchUsers(); // Refresh the user list
  //     } catch (error) {
  //         console.error('Error updating user:', error);
  //     }
  // };

  return (
    <div className="user-management">
      <h2>Manage Employees</h2>
      <table className="user-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>role</th>
            <th>Email</th>
            <th>salary ID</th>
            <th>account ID</th>
            <th>status</th>
            <th>Address</th>
          </tr>
        </thead>
        <tbody>
          {users.map((user) => (
            <tr key={user.id}>
              <td>{user.id}</td>
              <td>{user.name}</td>
              <td>{user.lastName}</td>
              <td>{user.role.designation}</td>
              <td>{user.emailId}</td>
              <td>{user.salary.salaryId}</td>
              <td>{user.salary.accountDetails}</td>
              <td>{user.status}</td>
              <td>{user.address}</td>
              <td>
                <button
                  className="delete-btn"
                  onClick={() => deleteUser(user._id)}>
                  Delete
                </button>
                {/* <button className="update-btn" onClick={() => updateUserDetails(user)}>
                                    Update
                                </button> */}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      {/* {selectedUser && showModal && (
                // <UserUpdateForm
                //     user={selectedUser}
                //     closeModal={closeModal}
                //     updateUserDetails={updateUserDetails}
                // />
            )} */}
    </div>
  );
};

export default EmployeeManagement;
