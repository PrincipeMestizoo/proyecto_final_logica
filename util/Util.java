package util;

import java.util.Scanner;

public class Util {
    private static final Scanner scanner = new Scanner(System.in);

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static int ingresarEntero() {
        int entero = scanner.nextInt();
        scanner.nextLine();
        return entero;
    }

    public static double ingresarDouble() {
        double decimal = scanner.nextDouble();
        scanner.nextLine();
        return decimal;
    }

    public static String ingresarTexto() {
        return scanner.nextLine();
    }

}