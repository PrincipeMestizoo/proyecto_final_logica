package menus;

import admins.Administrador;
import util.Util;

public class MenuPrincipal {

    private Administrador admin;

    public MenuPrincipal() {
        admin = new Administrador();
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
                    0. Salir
                    """);

            opcion = Util.ingresarEntero();

            switch (opcion) {
                case 1 -> new MenuSocios(admin).mostrar();
                case 2 -> new MenuEntrenadores(admin).mostrar();
                case 3 -> new MenuCuotas(admin).mostrar();
                case 4 -> new MenuInstalaciones(admin).mostrar();
                case 0 -> Util.mostrarMensaje("Saliendo del sistema...");
                default -> Util.mostrarMensaje("Opción inválida");
            }

        } while (opcion != 0);
    }
}
