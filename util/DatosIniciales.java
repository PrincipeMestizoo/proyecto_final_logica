package util;

import java.time.LocalDate;
import admins.Administrador;
import enums.TipoEspecialidad;
import model.Entrenador;
import model.Instalacion;
import model.Socio;

public class DatosIniciales {

    public static void cargarDatos(Administrador admin) {

        cargarSocios(admin);
        cargarEntrenadores(admin);
        cargarInstalaciones(admin);
        cargarCuotas(admin);
    }

    // Socios
    private static void cargarSocios(Administrador admin) {

        Socio s1 = new Socio("1001", "Daniel", TipoEspecialidad.FUTBOL);
        Socio s2 = new Socio("1002", "Laura", TipoEspecialidad.NATACION);
        Socio s3 = new Socio("1003", "Carlos", TipoEspecialidad.GIMNASIO);
        Socio s4 = new Socio("1004", "Ana", TipoEspecialidad.BOXEO);

        admin.getAdminSocios().crearSocio(s1);
        admin.getAdminSocios().crearSocio(s2);
        admin.getAdminSocios().crearSocio(s3);
        admin.getAdminSocios().crearSocio(s4);
    }

    // Entrenadores
    private static void cargarEntrenadores(Administrador admin) {

        Entrenador e1 = new Entrenador("E01", "Miguel", TipoEspecialidad.FUTBOL);
        Entrenador e2 = new Entrenador("E02", "Sandra", TipoEspecialidad.NATACION);
        Entrenador e3 = new Entrenador("E03", "Ricardo", TipoEspecialidad.GIMNASIO);
        Entrenador e4 = new Entrenador("E04", "Paola", TipoEspecialidad.BOXEO);

        admin.getAdminEntrenadores().crearEntrenador(e1);
        admin.getAdminEntrenadores().crearEntrenador(e2);
        admin.getAdminEntrenadores().crearEntrenador(e3);
        admin.getAdminEntrenadores().crearEntrenador(e4);
    }

    // Instalaciones
    private static void cargarInstalaciones(Administrador admin) {

        Instalacion i1 = new Instalacion("I01", "Cancha Principal");
        Instalacion i2 = new Instalacion("I02", "Piscina Olímpica");

        admin.getAdminInstalaciones().agregarInstalacion(i1);
        admin.getAdminInstalaciones().agregarInstalacion(i2);
    }

    // Cuotas
    private static void cargarCuotas(Administrador admin) {

        Socio s1 = admin.getAdminSocios().buscarPorId("1001");
        Socio s2 = admin.getAdminSocios().buscarPorId("1002");
        Socio s3 = admin.getAdminSocios().buscarPorId("1003");

        // Cuotas vencidas
        admin.getAdminCuotas().generarCuota(
                s1, 120000, LocalDate.now().minusDays(10));

        admin.getAdminCuotas().generarCuota(
                s2, 150000, LocalDate.now().minusDays(5));

        // Cuota vigente
        admin.getAdminCuotas().generarCuota(
                s3, 100000, LocalDate.now().plusDays(15));
    }
}
