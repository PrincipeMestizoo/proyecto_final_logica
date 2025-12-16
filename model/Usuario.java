package model;

public class Usuario {
    // Atributos de la super clase
    private String id;
    private String nombre;

    // Constructor
    public Usuario(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // getters and setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
