package model;

import enums.TipoEspecialidad;

public class Entrenador extends Usuario {

    // Atributo propio de la clase hija Entrenador
    private TipoEspecialidad especialidad;

    // Superconstructor
    public Entrenador(String nombre, String id, TipoEspecialidad especialidad) {
        super(nombre, id);
        this.especialidad = especialidad;
    }

    // Getters and setters
    public TipoEspecialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(TipoEspecialidad especialidad) {
        this.especialidad = especialidad;
    }

}
