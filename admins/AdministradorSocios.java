package admins;

import java.util.ArrayList;
import java.util.List;
import enums.TipoEspecialidad;
import model.Socio;

public class AdministradorSocios {

    private List<Socio> socios;

    public AdministradorSocios() {
        socios = new ArrayList<>();
    }

    public void crearSocio(Socio socio) {
        socios.add(socio);
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
}
