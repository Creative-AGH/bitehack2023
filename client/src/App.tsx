import { createBrowserRouter, RouterProvider } from "react-router-dom";
import UserLayout from "./components/Layout/UserLayout";
import LandingPage from "./views/LandingPage/LandingPage";
import AddPlan from "./views/AddPlan/AddPlan";
import ViewPlans from "./views/ViewPlans/ViewPlans";
import Chat from "./views/Chat/Chat";
import { ChakraProvider } from "@chakra-ui/react";
import TaskList from "./views/TaskList/TaskList";

function App() {
  const router = createBrowserRouter([
    {
      path: "/",
      element: <UserLayout isInCenter={true} />,
      children: [
        { path: "/", element: <LandingPage /> },
        { path: "add", element: <AddPlan /> },
        { path: "plan/:id", element: <TaskList /> },
        { path: "chat", element: <Chat /> },
      ],
    },
    {
      path: "/",
      element: <UserLayout isInCenter={false} />,
      children: [{ path: "plans", element: <ViewPlans /> }],
    },
  ]);

  return (
    <ChakraProvider>
      <RouterProvider router={router} />
    </ChakraProvider>
  );
}

export default App;
