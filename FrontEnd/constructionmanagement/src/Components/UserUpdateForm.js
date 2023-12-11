import React, { useState } from "react";

const UserUpdateForm = ({ user, closeModal, updateUserDetails }) => {
  const [updatedUser, setUpdatedUser] = useState(user);

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setUpdatedUser({
      ...updatedUser,
      [name]: value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    updateUserDetails(updatedUser);
  };

  return (
    <div className="modal">
      <div className="modal-content">
        <h2>Update User</h2>
        <form onSubmit={handleSubmit}>
          <label>Email:</label>
          <input
            type="text"
            name="email"
            value={updatedUser.email}
            onChange={handleInputChange}
            readOnly // Keep the email field read-only
          />

          <label>First Name:</label>
          <input
            type="text"
            name="fname"
            value={updatedUser.fname}
            onChange={handleInputChange}
          />

          <label>Last Name:</label>
          <input
            type="text"
            name="lname"
            value={updatedUser.lname}
            onChange={handleInputChange}
          />

          <button type="submit">Update</button>
          <button onClick={closeModal}>Close</button>
        </form>
      </div>
    </div>
  );
};

export default UserUpdateForm;
