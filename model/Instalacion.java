package model;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class Instalacion {

    private String idInstalacion;
    private String nombreInstalacion;
    private Entrenador entrenadorAsignado;
    private List<Socio> sociosAsignados;
    private LocalDateTime fechaHora;

    public Instalacion(String idInstalacion, String nombreInstalacion) {
        this.idInstalacion = idInstalacion;
        this.nombreInstalacion = nombreInstalacion;
        this.sociosAsignados = new ArrayList<>();
    }

    public void asignarUso(Entrenador entrenador, List<Socio> socios, LocalDateTime fechaHora) {
        this.entrenadorAsignado = entrenador;
        this.sociosAsignados = socios;
        this.fechaHora = fechaHora;
    }

    public String getIdInstalacion() {
        return idInstalacion;
    }

    public void setIdInstalacion(String idInstalacion) {
        this.idInstalacion = idInstalacion;
    }

    public String getNombreInstalacion() {
        return nombreInstalacion;
    }

    public void setNombreInstalacion(String nombreInstalacion) {
        this.nombreInstalacion = nombreInstalacion;
    }

    public Entrenador getEntrenadorAsignado() {
        return entrenadorAsignado;
    }

    public void setEntrenadorAsignado(Entrenador entrenadorAsignado) {
        this.entrenadorAsignado = entrenadorAsignado;
    }

    public List<Socio> getSociosAsignados() {
        return sociosAsignados;
    }

    public void setSociosAsignados(List<Socio> sociosAsignados) {
        this.sociosAsignados = sociosAsignados;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

}
