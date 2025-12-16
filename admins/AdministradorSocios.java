package admins;

import java.util.ArrayList;
import java.util.List;
import enums.TipoEspecialidad;
import model.Socio;
import util.Util;

public class AdministradorSocios {

    private List<Socio> socios;

    public AdministradorSocios() {
        socios = new ArrayList<>();
    }

    public void crearSocio(Socio socio) {
        socios.add(socio);
    }

    public void eliminarSocio(Socio socio) {
        socios.remove(socio);
    }

    public Socio buscarPorId(String id) {
        for (Socio s : socios) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    public List<Socio> buscarPorDisciplina(TipoEspecialidad disciplina) {
        List<Socio> resultado = new ArrayList<>();
        for (Socio s : socios) {
            if (s.getDisciplinaPrincipal() == disciplina) {
                resultado.add(s);
            }
        }
        return resultado;
    }

    public List<Socio> getSocios() {
        return socios;
    }

    public void listarSocios() {

        if (socios.isEmpty()) {
            Util.mostrarMensaje("No hay socios registrados.");
            return;
        }

        Util.mostrarMensaje("=== LISTA DE SOCIOS ===");

        for (Socio s : socios) {
            Util.mostrarMensaje(
                    "ID: " + s.getId() +
                            " | Nombre: " + s.getNombre() +
                            " | Disciplina: " + s.getDisciplinaPrincipal());
        }
    }

}
