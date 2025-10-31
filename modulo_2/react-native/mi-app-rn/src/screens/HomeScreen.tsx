import React from "react";
import { View, Text, Button, StyleSheet } from "react-native";

export default function HomeScreen({ navigation }: any) {
    return (
        <View style={styles.container}>
            <Text style={styles.title}>🏠 Home Screen</Text>
            <Button title="Ir a Caja" onPress={() => navigation.navigate("Box")} />
            <Button title="Ir a Saludo" onPress={() => navigation.navigate("Hello")} />
            <Button title="Ir a Perfil" onPress={() => navigation.navigate("Profile")} />
            <Button title="Ir a Detalles" onPress={() => navigation.navigate("Details")} />
            <Button title="Ir a Configuración" onPress={() => navigation.navigate("Settings")} />
            <Button title="Ir a Lista de Tareas" onPress={() => navigation.navigate("TaskList")} />
            <Button title="Ir a Detalle de Tareas" onPress={() => navigation.navigate("TaskDetail")} />
            <Button title="Ir a Usuarios" onPress={() => navigation.navigate("Users")} />
            <Button title="Ir a Detalle Usuario" onPress={() => navigation.navigate("UserDetail")} />
            <Button title="Ir a Herramientas" onPress={() => navigation.navigate("Tools")} />
            <Button title="Ir a Calculadora" onPress={() => navigation.navigate("Calculator")} />
            <Button title="Ir a Area del triangulo" onPress={() => navigation.navigate("TriangleArea")} />
            <Button title="Ir a Area del circulo" onPress={() => navigation.navigate("CircleArea")} />
            <Button title="Ir a Area del cuadrado" onPress={() => navigation.navigate("SquareArea")} />
            <Button title="Ir a Usuarios Api" onPress={() => navigation.navigate("UsersApi")} />
            <Button title="Ir a Usuarios Formulario" onPress={() => navigation.navigate("UserForm")} />
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: "center",
        alignItems: "center",
        backgroundColor: "#0d1117",
    },
    title: {
        fontSize: 24,
        color: "#58a6ff",
        marginBottom: 20,
    },
});