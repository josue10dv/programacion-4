import React from "react";
import AppNavigator from "./src/navigation/AppNavigator";
import { UsersProvider } from "./src/contexts/UsersContext";

export default function App() {
  return (
    <UsersProvider>
      <AppNavigator />
    </UsersProvider>
  );
}