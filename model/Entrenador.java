package model;

import enums.TipoEspecialidad;

public class Entrenador extends Usuario {

    private TipoEspecialidad especialidad;

    public Entrenador(String id, String nombre, TipoEspecialidad especialidad) {
        super(id, nombre);
        this.especialidad = especialidad;
    }

    public TipoEspecialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(TipoEspecialidad especialidad) {
        this.especialidad = especialidad;
    }
}
