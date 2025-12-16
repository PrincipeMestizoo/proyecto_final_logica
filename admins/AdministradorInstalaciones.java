package admins;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.Entrenador;
import model.Instalacion;
import model.Socio;

public class AdministradorInstalaciones {

    private List<Instalacion> instalaciones;

    public AdministradorInstalaciones() {
        instalaciones = new ArrayList<>();
    }

    public void agregarInstalacion(Instalacion instalacion) {
        instalaciones.add(instalacion);
    }

    public void asignarInstalacion(Instalacion instalacion, Entrenador entrenador, List<Socio> socios,
            LocalDateTime fechaHora) {
        instalacion.asignarUso(entrenador, socios, fechaHora);
    }

    public List<Instalacion> getInstalaciones() {
        return instalaciones;
    }

    public void setInstalaciones(List<Instalacion> instalaciones) {
        this.instalaciones = instalaciones;
    }
}
