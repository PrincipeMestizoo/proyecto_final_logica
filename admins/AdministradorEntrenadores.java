package admins;

import java.util.ArrayList;
import java.util.List;
import model.Entrenador;

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
}
