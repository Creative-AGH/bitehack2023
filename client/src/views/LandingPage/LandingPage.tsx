import { useState, useEffect } from "react";
import styles from "./LandingPage.module.scss";
import Slide from "../../components/Slide/Slide";
import Button from "../../components/Button/Button";

import { Box } from "@chakra-ui/react";

const LandingPage = () => {
  const [page, setPage] = useState(1);

  useEffect(() => {
    const interval = setInterval(() => {
      setPage((page) => (page === 3 ? 1 : page + 1));
    }, 5000);
    return () => clearInterval(interval);
  }, []);

  return (
    <Box
      bg="var(--blue-bg-200)"
      w="100%"
      p={4}
      color="var(--blue-text-200)"
      justifyContent="center"
      alignItems="center"
      display="flex"
      flexDirection="column"
      textAlign="center"
    >
      <Slide page={page} />
      <Button color="blue" type="link" path="/login" value="Zaczynajmy!" />
    </Box>
  );
};

export default LandingPage;
