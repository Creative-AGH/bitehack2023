import styles from "./Login.module.scss";
import sideImg from "../../assets/images/login.svg";
import { useForm } from "react-hook-form";
import { Link } from "react-router-dom";

import {
  FormErrorMessage,
  FormLabel,
  FormControl,
  Input,
  Button,
  Heading,
  Text,
  Box,
} from "@chakra-ui/react";

const Login = () => {
  const {
    register,
    handleSubmit,
    formState: { errors, isSubmitting },
  } = useForm();

  function onSubmit(values: any) {
    return new Promise((resolve) => {
      setTimeout(() => {
        alert(JSON.stringify(values, null, 2));
        resolve(true);
      }, 3000);
    });
  }

  return (
    <Box
      background="var(--blue-bg-200)"
      color="var(--blue-text-200)"
      display="grid"
      paddingBlock="40px"
      paddingInline="20px"
      gridTemplateColumns="minmax(clamp(250px, 50vw, 400px), 1fr)"
      maxWidth={500}
    >
      <img
        className={styles.image}
        src={sideImg}
        role="presentation"
        aria-hidden="true"
      />

      <Heading
        mt={4}
        as="h1"
        size="xl"
        textAlign="center"
        color={"var(--blue-text-200)"}
      >
        Zaloguj się
      </Heading>
      <Text as="p" textAlign="center" color={"var(--blue-text-200)"}>
        do swojego konta{" "}
      </Text>
      <form onSubmit={handleSubmit(onSubmit)}>
        <FormControl isInvalid={errors.name ? true : false}>
          <FormLabel htmlFor="email">Email</FormLabel>
          <Input
            id="email"
            placeholder="email"
            type="email"
            {...register("email", {
              required: "This is required",
              pattern: {
                value: /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i,
                message: "invalid email address",
              },
            })}
          />
          <FormErrorMessage>
            {errors.email && String(errors.email.message)}
          </FormErrorMessage>
          <FormLabel htmlFor="password">Password</FormLabel>
          <Input
            id="email"
            placeholder="email"
            type="password"
            {...register("password", {
              required: "This is required",
            })}
          />
          <FormErrorMessage>
            {errors.password && String(errors.password.message)}
          </FormErrorMessage>
        </FormControl>
        <Button
          mt={4}
          mb={4}
          color="var(--blue-text-btn)"
          bg={"var(--blue-bg-btn)"}
          isLoading={isSubmitting}
          type="submit"
          _hover={{ bg: "var(--blue-bg-btn-hover)" }}
          w="100%"
        >
          Submit
        </Button>
        <hr />
        <Text as="p" textAlign="center" mt={4}>
          Nie masz konta?{" "}
          <Link
            to="/#"
            style={{
              color: "#3182CE",
              fontWeight: "bold",
            }}
          >
            Zarejestruj się
          </Link>
        </Text>
      </form>
    </Box>
  );
};

export default Login;
