package model;

import java.util.ArrayList;
import java.util.List;

import enums.TipoEspecialidad;

import java.time.LocalDate;

public class Socio extends Usuario {

    private TipoEspecialidad disciplinaPrincipal;
    private LocalDate fechaIngreso;
    private int asistenciasMensuales;
    private List<Cuota> registroCuotas;

    public Socio(String id, String nombre, TipoEspecialidad disciplinaPrincipal) {
        super(id, nombre);
        this.disciplinaPrincipal = disciplinaPrincipal;
        this.fechaIngreso = LocalDate.now();
        this.asistenciasMensuales = 0;
        this.registroCuotas = new ArrayList<>();
    }

    public TipoEspecialidad getDisciplinaPrincipal() {
        return disciplinaPrincipal;
    }

    public List<Cuota> getRegistroCuotas() {
        return registroCuotas;
    }

    public void agregarCuota(Cuota cuota) {
        registroCuotas.add(cuota);
    }

    public int getAsistenciasMensuales() {
        return asistenciasMensuales;
    }

    public void setDisciplinaPrincipal(TipoEspecialidad disciplinaPrincipal) {
        this.disciplinaPrincipal = disciplinaPrincipal;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setAsistenciasMensuales(int asistenciasMensuales) {
        this.asistenciasMensuales = asistenciasMensuales;
    }

    public void setRegistroCuotas(List<Cuota> registroCuotas) {
        this.registroCuotas = registroCuotas;
    }

    public void registrarAsistencia() {
        asistenciasMensuales++;
    }
}
