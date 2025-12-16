package menus;

import admins.Administrador;
import enums.TipoEspecialidad;
import model.Entrenador;
import util.Util;

public class MenuEntrenadores {

    private Administrador admin;

    public MenuEntrenadores(Administrador admin) {
        this.admin = admin;
    }

    public void mostrar() {
        int opcion;

        do {
            Util.mostrarMensaje("""
                --- Gestión de Entrenadores ---
                1. Crear entrenador
                2. Buscar entrenador por ID
                0. Volver
                """);

            opcion = Util.ingresarEntero();

            switch (opcion) {
                case 1 -> crearEntrenador();
                case 2 -> buscarEntrenador();
                case 0 -> Util.mostrarMensaje("Volviendo...");
                default -> Util.mostrarMensaje("Opción inválida");
            }

        } while (opcion != 0);
    }

    private void crearEntrenador() {
        Util.mostrarMensaje("ID:");
        String id = Util.ingresarTexto();

        Util.mostrarMensaje("Nombre:");
        String nombre = Util.ingresarTexto();

        Util.mostrarMensaje("Especialidad (FUTBOL, NATACION, BOXEO, ATLETISMO, GIMNASIO):");
        TipoEspecialidad especialidad =
                TipoEspecialidad.valueOf(Util.ingresarTexto().toUpperCase());

        Entrenador entrenador = new Entrenador(id, nombre, especialidad);
        admin.getAdminEntrenadores().crearEntrenador(entrenador);

        Util.mostrarMensaje("Entrenador creado correctamente.");
    }

    private void buscarEntrenador() {
        Util.mostrarMensaje("Ingrese ID:");
        String id = Util.ingresarTexto();

        Entrenador e = admin.getAdminEntrenadores().buscarPorId(id);

        if (e == null) {
            Util.mostrarMensaje("Entrenador no encontrado.");
        } else {
            Util.mostrarMensaje("Entrenador: " + e.getNombre());
        }
    }
}

