import React from "react";
import { View, StyleSheet } from "react-native";
import Perfil from "../components/Perfil";

export default function PerfilScreen({ navigation }: any) {
    return (
        <View style={styles.container}>
            <Perfil />
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