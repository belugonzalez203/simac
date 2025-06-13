import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";
import { VitePWA } from "vite-plugin-pwa";

// @ts-expect-error process is a nodejs global
const host = process.env.TAURI_DEV_HOST;

// https://vitejs.dev/config/
export default defineConfig(async () => ({
    plugins: [
        react(),
        VitePWA({
            registerType: "autoUpdate",
            includeAssets: ["favicon.ico", "apple-touch-icon.png", "masked-icon.svg"],
            manifest: {
                name: "SIMAC",
                short_name: "SIMAC",
                description: "beluproject",
                theme_color: "#ffffff",
                icons: [
                    {
                        src: "/icons/logo-192.png",
                        sizes: "192x192",
                        type: "image/png",
                    },
                    {
                        src: "/icons/logo-512.png",
                        sizes: "512x512",
                        type: "image/png",
                    },
                ],
            },
            // pwa parwa etapa de desarrollo.
            devOptions: {
                enabled: true
            }
        }),
    ],

    // Vite options tailored for Tauri development
    clearScreen: false,

    server: {
        port: 1420,
        strictPort: true,
        host: host || false,
        hmr: host
            ? {
                protocol: "ws",
                host,
                port: 1421,
            }
            : undefined,
        watch: {
            ignored: ["*/src-tauri/*"],
        },
    },
}));