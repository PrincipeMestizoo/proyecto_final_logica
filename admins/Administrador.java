package admins;

public class Administrador {

    // Atributos para la clase administrador dependiendo las opciones del usuario.
    private AdministradorSocios adminSocios;
    private AdministradorEntrenadores adminEntrenadores;
    private AdministradorCuotas adminCuotas;
    private AdministradorInstalaciones adminInstalaciones;

    // Constructor
    public Administrador() {
        adminSocios = new AdministradorSocios();
        adminEntrenadores = new AdministradorEntrenadores();
        adminCuotas = new AdministradorCuotas();
        adminInstalaciones = new AdministradorInstalaciones();
    }

    // Getters and Setters.
    public AdministradorSocios getAdminSocios() {
        return adminSocios;
    }

    public AdministradorEntrenadores getAdminEntrenadores() {
        return adminEntrenadores;
    }

    public AdministradorCuotas getAdminCuotas() {
        return adminCuotas;
    }

    public AdministradorInstalaciones getAdminInstalaciones() {
        return adminInstalaciones;
    }
}
