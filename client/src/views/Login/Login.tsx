import styles from "./Login.module.scss";
import sideImg from "../../assets/images/login.svg";

const Login = () => {
  return (
    <div className={styles.wrapper}>
      <div className={styles.image}>
        <img src={sideImg} role="presentation" aria-hidden="true" />
      </div>
      <div className={styles.form}>
        <h1>Zaloguj się</h1>
      </div>
    </div>
  );
};

export default Login;
