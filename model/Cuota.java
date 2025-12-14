package model;

public class Cuota {
    // Atributos
    private String idCuota;
    private double monto;
    private Socio socio;

    // Constructor
    public Cuota(String idCuota, double monto, Socio socio) {
        this.idCuota = idCuota;
        this.socio = socio;
    }

    // Getters and setters
    public String getIdCuota() {
        return idCuota;
    }

    public void setIdCuota(String idCuota) {
        this.idCuota = idCuota;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

}
