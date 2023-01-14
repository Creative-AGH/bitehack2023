import { createBrowserRouter, RouterProvider } from "react-router-dom";
import UserLayout from "./components/Layout/UserLayout";
import Login from "./views/Login/Login";
import LandingPage from "./views/LandingPage/LandingPage";
import AddResource from "./views/AddResource/AddResource";
import ViewPlan from "./views/ViewPlan/ViewPlan";
import Chat from "./views/Chat/Chat";

function App() {
  const router = createBrowserRouter([
    {
      path: "/",
      element: <UserLayout />,
      children: [
        { path: "/", element: <LandingPage /> },
        { path: "add", element: <AddResource /> },
        { path: "login", element: <Login /> },
        { path: "viewplan", element: <ViewPlan /> },
        { path: "chat", element: <Chat /> },
      ],
    },
  ]);

  return <RouterProvider router={router} />;
}

export default App;
