import React from "react";
import { Outlet } from "react-router-dom";
import Navbar from "../Navbar/Navbar";
import styles from "./UserLayout.module.scss";

const isLogged = false;

const UserLayout = () => {
  return (
    <div className={styles.wrapper}>
      {isLogged ? <Navbar /> : null}
      <Outlet />
    </div>
  );
};

export default UserLayout;
