package menus;

import java.time.LocalDate;
import java.util.List;

import admins.Administrador;
import model.Cuota;
import model.Socio;
import util.Util;

public class MenuCuotas {

    private Administrador admin;

    public MenuCuotas(Administrador admin) {
        this.admin = admin;
    }

    public void mostrar() {
        int opcion;

        do {
            Util.mostrarMensaje("""
                    --- Gestión de Cuotas ---
                    1. Generar cuota a socio
                    2. Registrar pago de cuota
                    3. Listar socios con cuotas vencidas
                    0. Volver
                    """);

            opcion = Util.ingresarEntero();

            switch (opcion) {
                case 1 -> generarCuota();
                case 2 -> registrarPago();
                case 3 -> listarMorosos();
                case 0 -> Util.mostrarMensaje("Volviendo...");
                default -> Util.mostrarMensaje("Opción inválida");
            }

        } while (opcion != 0);
    }

    private void generarCuota() {
        Util.mostrarMensaje("ID del socio:");
        String idSocio = Util.ingresarTexto();

        Socio socio = admin.getAdminSocios().buscarPorId(idSocio);

        if (socio == null) {
            Util.mostrarMensaje("Socio no encontrado.");
            return;
        }

        Util.mostrarMensaje("Monto:");
        double monto = Util.ingresarDouble();

        Util.mostrarMensaje("Fecha vencimiento (YYYY-MM-DD):");
        LocalDate vencimiento = LocalDate.parse(Util.ingresarTexto());

        admin.getAdminCuotas().generarCuota(socio, monto, vencimiento);
        Util.mostrarMensaje("Cuota generada correctamente.");
    }

    private void registrarPago() {
        Util.mostrarMensaje("ID del socio:");
        String idSocio = Util.ingresarTexto();

        Socio socio = admin.getAdminSocios().buscarPorId(idSocio);

        if (socio == null) {
            Util.mostrarMensaje("Socio no encontrado.");
            return;
        }

        if (socio.getRegistroCuotas().isEmpty()) {
            Util.mostrarMensaje("El socio no tiene cuotas.");
            return;
        }

        Cuota cuota = socio.getRegistroCuotas().get(0); // simplificado
        admin.getAdminCuotas().registrarPago(cuota);

        Util.mostrarMensaje("Pago registrado.");
    }

    private void listarMorosos() {
        List<Socio> morosos = admin.getAdminCuotas()
                .sociosConCuotasVencidas(admin.getAdminSocios().getSocios());

        if (morosos.isEmpty()) {
            Util.mostrarMensaje("No hay socios con cuotas vencidas.");
            return;
        }

        morosos.forEach(s -> Util.mostrarMensaje("Socio: " + s.getNombre()));
    }
}
