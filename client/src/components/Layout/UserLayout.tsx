import { Outlet } from "react-router-dom";
import { ReactNode } from "react";
import {
  Box,
  Flex,
  Avatar,
  HStack,
  Link,
  IconButton,
  Button,
  Menu,
  MenuButton,
  MenuList,
  MenuItem,
  MenuDivider,
  useDisclosure,
  useColorModeValue,
  Stack,
} from "@chakra-ui/react";
import { HamburgerIcon, CloseIcon } from "@chakra-ui/icons";
import logo from "../../assets/logo.png";

const LinksWithUser = [
  {
    name: "Moje plany",
    path: "/plans",
  },
  {
    name: "Forum",
    path: "#",
  },
  {
    name: "Promuj się",
    path: "#",
  },
  {
    name: "Dotychczasowe zadania",
    path: "/chat",
  },
];

export interface INavLink {
  name: string;
  path: string;
}

const NavLink = ({ name, path }: INavLink) => (
  <Link
    px={2}
    py={1}
    rounded={"md"}
    _hover={{
      textDecoration: "none",
      bg: useColorModeValue("gray.200", "gray.700"),
    }}
    href={path}
  >
    {name}
  </Link>
);

export interface IContent {
  children: ReactNode;
  isInCenter: boolean;
}

const Content = ({ children, isInCenter }: IContent) => {
  const { isOpen, onOpen, onClose } = useDisclosure();

  return (
    <>
      <Box bg={useColorModeValue("gray.100", "gray.900")} px={4}>
        <Flex h={16} alignItems={"center"} justifyContent={"space-between"}>
          <IconButton
            size={"md"}
            icon={isOpen ? <CloseIcon /> : <HamburgerIcon />}
            aria-label={"Open Menu"}
            display={{ md: "none" }}
            onClick={isOpen ? onClose : onOpen}
          />
          <HStack spacing={8} alignItems={"center"}>
            <Box>
              <Link href={"/"}>
                <img src={logo} width="30px" aria-label="Strona główna" />
              </Link>
            </Box>
            <HStack
              as={"nav"}
              spacing={4}
              display={{ base: "none", md: "flex" }}
            >
              {LinksWithUser.map(({ name, path }) => (
                <NavLink key={name} name={name} path={path} />
              ))}
            </HStack>
          </HStack>
          <Flex alignItems={"center"}>
            <Menu>
              <MenuButton
                as={Button}
                rounded={"full"}
                variant={"link"}
                cursor={"pointer"}
                minW={0}
              >
                <Avatar
                  size={"sm"}
                  src={
                    "https://images.unsplash.com/photo-1493666438817-866a91353ca9?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&fit=crop&h=200&w=200&s=b616b2c5b373a80ffc9636ba24f7a4a9"
                  }
                />
              </MenuButton>
              <MenuList>
                <MenuItem>Ustawienia</MenuItem>
                <MenuItem>Pomoc</MenuItem>
                <MenuItem>Regulami</MenuItem>
                <MenuDivider />
                <MenuItem color="red">Wyloguj</MenuItem>
              </MenuList>
            </Menu>
          </Flex>
        </Flex>

        {isOpen ? (
          <Box pb={4} display={{ md: "none" }}>
            <Stack as={"nav"} spacing={4}>
              {LinksWithUser.map(({ name, path }) => (
                <NavLink key={name} name={name} path={path} />
              ))}
            </Stack>
          </Box>
        ) : null}
      </Box>
      <Box
        display="grid"
        placeItems={isInCenter ? "center" : "flex-start"}
        minHeight="calc(100vh - 64px)"
      >
        {children}
      </Box>
    </>
  );
};

export interface IUserLayout {
  isInCenter?: boolean;
}

const UserLayout = ({ isInCenter }: IUserLayout) => {
  return (
    <Content isInCenter={isInCenter || false}>
      <Outlet />
    </Content>
  );
};

export default UserLayout;
