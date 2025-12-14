package model;

import java.util.ArrayList;
import java.util.List;

public class Socio extends Usuario {

    // Atributo propio de la clase hija Socio
    private List<Cuota> registroCuotas;

    // Cosntructor
    public Socio(String nombre, String id) {
        super(nombre, id);
        this.registroCuotas = new ArrayList<>();
    }

    // Getters and setters
    public List<Cuota> getRegistroCuotas() {
        return registroCuotas;
    }

    public void setRegistroCuotas(List<Cuota> registroCuotas) {
        this.registroCuotas = registroCuotas;
    }

}
