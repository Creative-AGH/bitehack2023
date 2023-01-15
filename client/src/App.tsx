import { createBrowserRouter, RouterProvider } from "react-router-dom";
import UserLayout from "./components/Layout/UserLayout";
import Login from "./views/Login/Login";
import LandingPage from "./views/LandingPage/LandingPage";
import AddResource from "./views/AddResource/AddResource";
import ViewPlan from "./views/ViewPlan/ViewPlan";
import Chat from "./views/Chat/Chat";
import { ChakraProvider } from "@chakra-ui/react";

function App() {
  const router = createBrowserRouter([
    {
      path: "/",
      element: <UserLayout />,
      children: [
        { path: "/", element: <LandingPage /> },
        { path: "add", element: <AddResource /> },
        { path: "login", element: <Login /> },
        { path: "chat", element: <Chat /> },
        { path: "plan", element: <ViewPlan /> },
      ],
    },
  ]);

  return (
    <ChakraProvider>
      <RouterProvider router={router} />
    </ChakraProvider>
  );
}

export default App;
