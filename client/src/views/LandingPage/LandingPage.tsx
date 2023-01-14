import { useState, useEffect } from "react";
import styles from "./LandingPage.module.scss";
import Slide from "../../components/Slide/Slide";
import Button from "../../components/Button/Button";

const LandingPage = () => {
  const [page, setPage] = useState(1);

  useEffect(() => {
    const interval = setInterval(() => {
      setPage((page) => (page === 3 ? 1 : page + 1));
    }, 5000);
    return () => clearInterval(interval);
  }, []);

  return (
    <div className={styles.wrapper}>
      <Slide page={page} />
      <Button color="blue" type="link" path="/login" value="Zaczynajmy!" />
    </div>
  );
};

export default LandingPage;
