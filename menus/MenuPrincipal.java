package menus;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import admins.Administrador;
import util.DatosIniciales;
import util.Util;

public class MenuPrincipal {

    private Administrador admin;

    public MenuPrincipal() {
        admin = new Administrador();
        DatosIniciales.cargarDatos(admin);
    }

    public void mostrar() {
        int opcion;

        do {
            Util.mostrarMensaje("""
                    ===== ELITE GYM =====
                    1. Gestionar Socios
                    2. Gestionar Entrenadores
                    3. Gestionar Cuotas
                    4. Gestionar Instalaciones
                    5. Modelo de IA
                    0. Salir
                    """);

            opcion = Util.ingresarEntero();

            switch (opcion) {
                case 1 -> new MenuSocios(admin).mostrar();
                case 2 -> new MenuEntrenadores(admin).mostrar();
                case 3 -> new MenuCuotas(admin).mostrar();
                case 4 -> new MenuInstalaciones(admin).mostrar();
                case 5 -> modeloIa();
                case 0 -> Util.mostrarMensaje("Saliendo del sistema...");
                default -> Util.mostrarMensaje("Opción inválida");
            }

        } while (opcion != 0);
    }

    private static void modeloIa() {
        String apiKey = "AIzaSyA4GH4m80cK6fobqQvNDr031v-WqLKI6Zo"; // <--- Pega tu llave aquí
        String prompt = "Soy el administrador de un club deportivo. El socio tiene un riesgo de abandono Dame 3 estrategias cortas y motivadoras para evitar que se vaya del club.";

        // URL del modelo (Usamos gemini-2.5-flash por ser rápido y eficiente)
        String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key="
                + apiKey;

        // 2. Construir el JSON manualmente (Para no usar librerías externas)
        // Estructura: { "contents": [{ "parts": [{ "text": "PREGUNTA" }] }] }
        String jsonPayload = String.format(
                "{\"contents\": [{\"parts\": [{\"text\": \"%s\"}]}]}",
                prompt);

        // 3. Crear el Cliente HTTP y la Petición
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonPayload))
                .timeout(Duration.ofSeconds(10))
                .build();

        // 4. Enviar y recibir respuesta
        try {
            System.out.println("Enviando consulta a Gemini...");
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                System.out.println("--- Respuesta Exitosa ---");
                System.out.println(response.body()); // Imprime el JSON crudo
            } else {
                System.out.println("--- Error ---");
                System.out.println("Código: " + response.statusCode());
                System.out.println("Mensaje: " + response.body());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
