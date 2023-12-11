import "./App.css";
import { useState } from "react";
import AdminLogin from "./Components/AdminLogin";
import Dashboard from "./Components/Dashboard";

function App() {
  const [LoggedIn, setLoggedIn] = useState(true);
  return (
    <>
      {LoggedIn ? (
        <>
          {/* User is Logged In */}
          <Dashboard />
        </>
      ) : (
        <AdminLogin />
      )}
    </>
  );
}

export default App;
