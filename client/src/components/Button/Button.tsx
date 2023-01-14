import React from "react";
import styles from "./Button.module.scss";
import clsx from "clsx";
import { Link } from "react-router-dom";

export interface IButton {
  color: "blue" | "white";
  type: "link" | "input";
  value: string;
  path?: string;
}

const Button = ({ color, type, value, path = "/#" }: IButton) => {
  if (type === "link") {
    return (
      <Link to={path} className={clsx(styles.button, styles[color])}>
        {value}
      </Link>
    );
  }
  return (
    <input
      className={clsx(styles.button, styles[color])}
      type="submit"
      value={value}
    />
  );
};

export default Button;
