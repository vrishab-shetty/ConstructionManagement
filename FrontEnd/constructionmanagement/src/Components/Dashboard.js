import React, { useContext, useState, useEffect } from "react";
import EmployeeManagement from "./EmployeeManagement";
import SellersManagement from "./SellersManagement";
import DepartmentManagement from "./DepartmentManagement";
import "../Styles/Dashboard.css";

const Dashboard = () => {
  const [showPopup, setShowPopup] = useState(false);
  const [popupContent, setPopupContent] = useState("");

  // Dummy query data
  const dummyQueries = [
    { id: 1, user: "User1", query: "How do I update my profile?" },
    { id: 2, user: "User2", query: "What is the listing fee?" },
    // ... more queries
  ];

  const handleLogout = () => {};

  const handleBoxClick = (content) => {
    setShowPopup(true);
    setPopupContent(content);
  };

  const closePopup = () => {
    setShowPopup(false);
    setPopupContent("");
  };

  return (
    <div className="dashboard">
      <h1>
        {" "}
        Construction <br></br> Management
      </h1>
      <div className="box users" onClick={() => handleBoxClick("Manage Employees")}>
        <h2>Manage Employees</h2>
      </div>
      <div
        className="box listings"
        onClick={() => handleBoxClick("Manage Sellers")}
      >
        <h2>Manage Sellers</h2>
      </div>
      <div
        className="box queries"
        onClick={() => handleBoxClick("Manage Departments")}
      >
        <h2>Manage Departments</h2>
      </div>

      {/* Popup */}
      {showPopup && (
        <div className="popup-background">
          <div className="popup">
            <div className="popup-content">
            <button onClick={closePopup}>Close</button>
              {popupContent === "Manage Employees" && (
                <EmployeeManagement closePopup={closePopup} />
              )}
              {popupContent === "Manage Sellers" && (
                <SellersManagement closePopup={closePopup} />
              )}
              {popupContent === "Manage Departments" && (
                <DepartmentManagement
                  closePopup={closePopup}
                />
              )}
            </div>
          </div>
        </div>
      )}

      <button onClick={handleLogout}>Logout</button>
    </div>
  );
};

export default Dashboard;
