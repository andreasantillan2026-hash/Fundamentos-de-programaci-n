import java.util.Scanner;

public class Multas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int velocidad, limite1, limite2, resultado;
        boolean esCumpleanos;
        String cumpleanos;

        System.out.print("Ingrese la velocidad (km): ");
        velocidad = sc.nextInt();

        System.out.print("¿Hoy es su cumpleaños? (SI/NO): ");
        cumpleanos = sc.next();

        esCumpleanos = cumpleanos.equalsIgnoreCase("SI");

        // Tolerancia de 5 km/h extra si es cumpleaños
        if (esCumpleanos) {
            limite1 = 65;
            limite2 = 85;
        } else {
            limite1 = 60;
            limite2 = 80;
        }

        if (velocidad <= limite1) {
            resultado = 0;
        } else {
            if (velocidad <= limite2) {
                resultado = 1;
            } else {
                resultado = 2;
            }
        }

        System.out.println("Resultado de la multa: " + resultado);

        sc.close();
    }
}
