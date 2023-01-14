import React from "react";
import { Link } from "react-router-dom";

const Navbar = () => {
  return (
    <div>
      <nav className="navbar navbar-expand-lg navbar-light bg-light">
        <ul>
          <li>
            <Link to="/">Landing Page</Link>
          </li>
          <li>
            <Link to="/add">Add Resource</Link>
          </li>
          <li>
            <Link to="/chat">Chat</Link>
          </li>

          <li>
            <Link to="/login">Login</Link>
          </li>
          <li>
            <Link to="/viewplan">View Plan</Link>
          </li>
        </ul>
      </nav>
    </div>
  );
};

export default Navbar;
