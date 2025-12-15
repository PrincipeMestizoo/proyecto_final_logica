package model;

import java.time.LocalDate;

import enums.EstadoCuota;

public class Cuota {

    // Atributos.
    private String idCuota;
    private double monto;
    private LocalDate fechaVencimiento;
    private LocalDate fechaPago;
    private EstadoCuota estado;
    private Socio socio;

    // Constructor.
    public Cuota(String idCuota, double monto, LocalDate fechaVencimiento, Socio socio) {
        this.idCuota = idCuota;
        this.monto = monto;
        this.fechaVencimiento = fechaVencimiento;
        this.socio = socio;
        this.estado = EstadoCuota.IMPAGA;
    }

    // Getters and setter - "crud"
    public void registrarPago() {
        this.fechaPago = LocalDate.now();
        this.estado = EstadoCuota.PAGADA;
    }

    public EstadoCuota getEstado() {
        return estado;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public String getIdCuota() {
        return idCuota;
    }

    public void setIdCuota(String idCuota) {
        this.idCuota = idCuota;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setEstado(EstadoCuota estado) {
        this.estado = estado;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }
}
