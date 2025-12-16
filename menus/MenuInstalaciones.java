package menus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import admins.Administrador;
import model.Entrenador;
import model.Instalacion;
import model.Socio;
import util.Util;

public class MenuInstalaciones {

    private Administrador admin;

    public MenuInstalaciones(Administrador admin) {
        this.admin = admin;
    }

    public void mostrar() {
        int opcion;

        do {
            Util.mostrarMensaje("""
                    --- Gestión de Instalaciones ---
                    1. Crear instalación
                    2. Asignar instalación
                    3. Ver instalaciones
                    4. Eliminar instalaciones
                    0. Volver
                    """);

            opcion = Util.ingresarEntero();

            switch (opcion) {
                case 1 -> crearInstalacion();
                case 2 -> asignarInstalacion();
                case 3 -> verInstalaciones();
                case 4 -> eliminarInstalacion();
                case 0 -> Util.mostrarMensaje("Volviendo...");
                default -> Util.mostrarMensaje("Opción inválida");
            }

        } while (opcion != 0);
    }

    private void crearInstalacion() {
        Util.mostrarMensaje("ID instalación:");
        String id = Util.ingresarTexto();

        Util.mostrarMensaje("Nombre:");
        String nombre = Util.ingresarTexto();

        Instalacion instalacion = new Instalacion(id, nombre);
        admin.getAdminInstalaciones().agregarInstalacion(instalacion);

        Util.mostrarMensaje("Instalación creada.");
    }

    private void asignarInstalacion() {
        Util.mostrarMensaje("ID instalación:");
        String idInst = Util.ingresarTexto();

        Instalacion inst = admin.getAdminInstalaciones()
                .getInstalaciones()
                .stream()
                .filter(i -> i.getIdInstalacion().equals(idInst))
                .findFirst()
                .orElse(null);

        if (inst == null) {
            Util.mostrarMensaje("Instalación no encontrada.");
            return;
        }

        Util.mostrarMensaje("ID entrenador:");
        Entrenador entrenador = admin.getAdminEntrenadores()
                .buscarPorId(Util.ingresarTexto());

        if (entrenador == null) {
            Util.mostrarMensaje("Entrenador no encontrado.");
            return;
        }

        List<Socio> socios = new ArrayList<>();
        Util.mostrarMensaje("Ingrese ID de socio (0 para terminar):");

        while (true) {
            String id = Util.ingresarTexto();
            if (id.equals("0"))
                break;

            Socio s = admin.getAdminSocios().buscarPorId(id);
            if (s != null)
                socios.add(s);
        }

        Util.mostrarMensaje("Fecha y hora (YYYY-MM-DDTHH:MM):");
        LocalDateTime fechaHora = LocalDateTime.parse(Util.ingresarTexto());

        admin.getAdminInstalaciones()
                .asignarInstalacion(inst, entrenador, socios, fechaHora);

        Util.mostrarMensaje("Instalación asignada correctamente.");
    }

    private void verInstalaciones() {
        admin.getAdminInstalaciones().listarInstalaciones();
    }

    private void eliminarInstalacion() {
        Util.mostrarMensaje("ID de la instalacion: ");
        String id = Util.ingresarTexto();

        Instalacion instalacion = admin.getAdminInstalaciones().buscarInstalacion(id);

        if (instalacion == null) {
            Util.mostrarMensaje("Instalacion no encontrada.");
        } else {
            admin.getAdminInstalaciones().eliminarInstalacion(instalacion);
            Util.mostrarMensaje("Instalacion eliminada");
        }

    }
}
