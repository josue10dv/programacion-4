import React from "react";
import { View, StyleSheet } from "react-native";
import Saludo from "../components/Saludo";

export default function SaludoScreen() {
    return (
        <View style={styles.container}>
            <Saludo nombre="Erick" />
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: "center",
        alignItems: "center",
        backgroundColor: "#161b22",
    },
    title: {
        fontSize: 22,
        color: "#58a6ff",
        marginBottom: 20,
    },
});