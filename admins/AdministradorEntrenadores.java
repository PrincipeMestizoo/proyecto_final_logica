package admins;

import java.util.ArrayList;
import java.util.List;
import model.Entrenador;
import util.Util;

public class AdministradorEntrenadores {

    private List<Entrenador> entrenadores;

    public AdministradorEntrenadores() {
        entrenadores = new ArrayList<>();
    }

    public void crearEntrenador(Entrenador entrenador) {
        entrenadores.add(entrenador);
    }

    public Entrenador buscarPorId(String id) {
        for (Entrenador e : entrenadores) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }

    public List<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public void listarEntrenadores() {

        if (entrenadores.isEmpty()) {
            Util.mostrarMensaje("No hay entrenadores registrados.");
            return;
        }

        Util.mostrarMensaje("LISTA DE ENTRENADORES");

        for (Entrenador e : entrenadores) {
            Util.mostrarMensaje(
                    "ID: " + e.getId() +
                            " | Nombre: " + e.getNombre() +
                            " | Especialidad: " + e.getEspecialidad());
        }
    }

}
