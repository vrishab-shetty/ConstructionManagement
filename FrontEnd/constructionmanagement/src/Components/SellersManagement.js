import React, { useState, useEffect } from "react";
import axios from "axios";
import "../Styles/EmployeeManagement.css";
import { redirect } from "react-router-dom";
import moment from "moment";

const SellersManagement = ({ closePopup }) => {
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
      const response = await axios.get("http://localhost:8080/supplier/all", {
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
      <h2>Manage Sellers</h2>
      <table className="user-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Account Details</th>
            <th>Payment method</th>
            <th>Transaction Date</th>
            <th>Transaction ID</th>
          </tr>
        </thead>
        <tbody>
          {users.map((user) => (
            <tr key={user.id}>
              <td>{user.id}</td>
              <td>{user.name}</td>
              <td>{user.accountDetails}</td>
              <td>{user.paymentMethod}</td>
              <td>{moment(user.transaction.date).utc().format('YYYY-MM-DD HH:mm:ss')}</td>
              <td>{user.transaction.id}</td>
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

export default SellersManagement;
