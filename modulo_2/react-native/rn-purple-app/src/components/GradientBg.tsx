import React from "react";
import { View } from "react-native";
import { LinearGradient } from "expo-linear-gradient";
import WaveSvg from "./WaveSvg";
import { StyleSheet } from "react-native";
import { gradientPurple } from "../themes/gradients";

export default function GradientBg({ children }: { children: React.ReactNode }) {
    return (
        <View style={{ flex: 1, backgroundColor: "#0b0620" }}>
            <LinearGradient
                colors={gradientPurple.colors}
                start={gradientPurple.start}
                end={gradientPurple.end}
                style={{ ...StyleSheet.absoluteFillObject }}
            />
            <WaveSvg opacity={0.35} />
            {children}
        </View>
    );
}

