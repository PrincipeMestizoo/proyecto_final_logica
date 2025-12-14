package util;

import java.util.Scanner;

public class Util {
    Scanner scanner = new Scanner(System.in);

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public int ingresarEntero() {
        int entero = scanner.nextInt();
        return entero;
    }

    public double ingresarDouble() {
        double decimal = scanner.nextDouble();
        return decimal;
    }

    public String ingresarTexto() {
        String texto = scanner.nextLine();
        return texto;
    }

}