import React from "react";
import { NavigationContainer } from "@react-navigation/native";
import { createNativeStackNavigator } from "@react-navigation/native-stack";
import HomeScreen from "../screens/HomeScreen";
import SettingsScreen from "../screens/SettingsScreen";
import DetailsScreen from "../screens/DetailScreen";
import CajaScreen from "../screens/CajaScreen";
import SaludoScreen from "../screens/SaludoScreen";
import PerfilScreen from "../screens/PerfilScreen";
import TaskDetailScreen from "../screens/TaskDetailScreen";
import colors from "../themes/Color";
import TaskListScreen from "../screens/TaskListScreen";
import UsersListScreen from "../screens/UsersListScreen";
import UserDetailScreen from "../screens/UserDetailScreen";
import ToolsMenuScreen from "../screens/ToolsMenuScreen";
import CalculatorScreen from "../screens/CalculatorScreen";
import TriangleAreaScreen from "../screens/TriangleAreaScreen";
import CircleAreaScreen from "../screens/CircleAreaScreen";
import SquareAreaScreen from "../screens/SquareAreaScreen";
import UsersListApiScreen from "../screens/UsersListApiScreen";
import UserFormScreen from "../screens/UserFormScreen";

const Stack = createNativeStackNavigator();

export default function AppNavigator() {
    return (
        <NavigationContainer>
            <Stack.Navigator
                screenOptions={{
                    headerStyle: { backgroundColor: "#161b22" },
                    headerTintColor: colors.primary,
                    contentStyle: { backgroundColor: colors.background },
                }}
            >
                <Stack.Screen name="Home" component={HomeScreen} options={{ title: "Inicio" }} />
                <Stack.Screen name="Box" component={CajaScreen} options={{ title: "Caja con estilos" }} />
                <Stack.Screen name="Hello" component={SaludoScreen} options={{ title: "Saludo" }} />
                <Stack.Screen name="Profile" component={PerfilScreen} options={{ title: "Perfil" }} />
                <Stack.Screen name="Details" component={DetailsScreen} options={{ title: "Detalles" }} />
                <Stack.Screen name="Settings" component={SettingsScreen} options={{ title: "Configuración" }} />
                <Stack.Screen name="TaskList" component={TaskListScreen} options={{ title: "Tareas" }} />
                <Stack.Screen name="TaskDetail" component={DetailScreenProps} options={{ title: "Detalle Tareas" }} />
                <Stack.Screen name="Users" component={UsersListScreen} options={{ title: "Usuarios" }} />
                <Stack.Screen name="UserDetail" component={UserDetailScreenProps} options={{ title: "Detalle" }} />
                <Stack.Screen name="Tools" component={ToolsMenuScreen} options={{ title: "Tools" }} />
                <Stack.Screen name="Calculator" component={CalculatorScreen} options={{ title: "Calculadora" }} />
                <Stack.Screen name="TriangleArea" component={TriangleAreaScreen} options={{ title: "Área triángulo" }} />
                <Stack.Screen name="CircleArea" component={CircleAreaScreen} options={{ title: "Área círculo" }} />
                <Stack.Screen name="SquareArea" component={SquareAreaScreen} options={{ title: "Área cuadrado" }} />
                <Stack.Screen name="UsersApi" component={UsersListApiScreen} options={{ title: "Usuarios con API" }} />
                <Stack.Screen name="UserForm" component={UserFormScreen} options={{ title: "Formulario" }} />
            </Stack.Navigator>
        </NavigationContainer>
    );
}

function DetailScreenProps() {
    return <TaskDetailScreen route={{ params: { id: "identificador" } }} />;
}

function UserDetailScreenProps() {
    return <UserDetailScreen route={{ params: { id: 1 } }} />
}