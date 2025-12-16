package menus;

import admins.Administrador;
import enums.TipoEspecialidad;
import model.Socio;
import util.Util;

public class MenuSocios {

    private Administrador admin;

    public MenuSocios(Administrador admin) {
        this.admin = admin;
    }

    public void mostrar() {
        int opcion;

        do {
            Util.mostrarMensaje("""
                    --- Gestión de Socios ---
                    1. Crear socio
                    2. Buscar socio por ID
                    3. Buscar socios por disciplina
                    4- Listar socios
                    0. Volver
                    """);

            opcion = Util.ingresarEntero();

            switch (opcion) {
                case 1 -> crearSocio();
                case 2 -> buscarPorId();
                case 3 -> buscarPorDisciplina();
                case 4 -> verSocios();
                case 5 -> eliminarSocios();
                case 0 -> Util.mostrarMensaje("Volviendo...");
                default -> Util.mostrarMensaje("Opción inválida");
            }

        } while (opcion != 0);
    }

    private void crearSocio() {
        Util.mostrarMensaje("ID:");
        String id = Util.ingresarTexto();

        Util.mostrarMensaje("Nombre:");
        String nombre = Util.ingresarTexto();

        Util.mostrarMensaje("Disciplina (FUTBOL, NATACION, BOXEO, ATLETISMO, GIMNASIO):");
        TipoEspecialidad disciplina = TipoEspecialidad.valueOf(Util.ingresarTexto().toUpperCase());

        Socio socio = new Socio(id, nombre, disciplina);
        admin.getAdminSocios().crearSocio(socio);

        Util.mostrarMensaje("Socio creado correctamente.");
        Util.mostrarMensaje("ID guardado: [" + socio.getId() + "]");

    }

    private void buscarPorId() {
        Util.mostrarMensaje("Ingrese ID:");
        String id = Util.ingresarTexto();

        Socio socio = admin.getAdminSocios().buscarPorId(id);

        if (socio == null) {
            Util.mostrarMensaje("Socio no encontrado.");
        } else {
            Util.mostrarMensaje("Socio: " + socio.getNombre());
        }
    }

    private void buscarPorDisciplina() {
        Util.mostrarMensaje("Disciplina:");
        TipoEspecialidad d = TipoEspecialidad.valueOf(Util.ingresarTexto().toUpperCase());

        admin.getAdminSocios()
                .buscarPorDisciplina(d)
                .forEach(s -> Util.mostrarMensaje(s.getNombre()));
    }

    private void verSocios() {
        admin.getAdminSocios().listarSocios();
    }

    private void eliminarSocios() {
        Util.mostrarMensaje("Ingrese ID:");
        String id = Util.ingresarTexto();

        Socio socio = admin.getAdminSocios().buscarPorId(id);

        if (socio == null) {
            Util.mostrarMensaje("Socio no encontrado.");
        } else {
            admin.getAdminSocios().eliminarSocio(socio);
            Util.mostrarMensaje("Socio eliminado correctamente");
        }
    }
}
