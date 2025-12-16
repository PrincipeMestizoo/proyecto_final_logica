package admins;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import enums.EstadoCuota;
import model.Cuota;
import model.Socio;
import util.Util;

public class AdministradorCuotas {

    private List<Cuota> cuotas;

    public AdministradorCuotas() {
        cuotas = new ArrayList<>();
    }

    public void generarCuota(Socio socio, double monto, LocalDate vencimiento) {
        Cuota cuota = new Cuota(
                "C" + (cuotas.size() + 1),
                monto,
                vencimiento,
                socio);
        cuotas.add(cuota);
        socio.agregarCuota(cuota);
    }

    public void registrarPago(Cuota cuota) {
        cuota.registrarPago();
    }

    public List<Socio> sociosConCuotasVencidas(List<Socio> socios) {
        List<Socio> resultado = new ArrayList<>();

        for (Socio s : socios) {
            for (Cuota c : s.getRegistroCuotas()) {
                if (c.getEstado() == EstadoCuota.VENCIDA) {
                    resultado.add(s);
                    break;
                }
            }
        }
        return resultado;
    }

    public void listarSociosConCuotas() {

        if (cuotas.isEmpty()) {
            Util.mostrarMensaje("No hay cuotas registradas.");
            return;
        }

        Util.mostrarMensaje("SOCIOS Y SUS CUOTAS");

        for (Cuota c : cuotas) {
            Util.mostrarMensaje(
                    "Socio: " + c.getSocio().getNombre() +
                            " | ID: " + c.getSocio().getId() +
                            " | Monto: " + c.getMonto() +
                            " | Estado: " + c.getEstado() +
                            " | Vence: " + c.getFechaVencimiento() +
                            " | Pagado: " + c.getFechaPago());
        }
    }

}
