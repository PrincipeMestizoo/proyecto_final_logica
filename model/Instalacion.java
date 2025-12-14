package model;

import java.util.ArrayList;
import java.util.List;

public class Instalacion {
    // Atributos
    private String idInstalacion;
    private String nombreInstalacion;
    private Entrenador entrenadorAsignado;
    private List<Socio> listaSociosInscritos;

    // Cosntructor
    public Instalacion(String idInstalacion, String nombreInstalacion, Entrenador entrenadorAsignado) {
        this.idInstalacion = idInstalacion;
        this.nombreInstalacion = nombreInstalacion;
        this.entrenadorAsignado = entrenadorAsignado;
        this.listaSociosInscritos = new ArrayList<>();
    }

    // Getters and setters
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

    public List<Socio> getListaSociosInscritos() {
        return listaSociosInscritos;
    }

    public void setListaSociosInscritos(List<Socio> listaSociosInscritos) {
        this.listaSociosInscritos = listaSociosInscritos;
    }

}
