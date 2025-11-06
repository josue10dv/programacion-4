import React from "react";
import "react-native-gesture-handler";
import { StatusBar } from "expo-status-bar";
import RootNavigator from "./src/navigations/RootNavigator";

export default function App() {
  return (
    <>
      <StatusBar style="light" />
      <RootNavigator />
    </>
  );
}