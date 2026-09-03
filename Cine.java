import java.util.Scanner;

public class Cine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Días de la semana ===");
        System.out.println("1. Lunes");
        System.out.println("2. Martes");
        System.out.println("3. Miércoles");
        System.out.println("4. Jueves");
        System.out.println("5. Viernes");
        System.out.println("6. Sábado");
        System.out.println("7. Domingo");
        System.out.print("Elige el día: ");
        int dia = sc.nextInt();

        System.out.print("Introduce el número de personas: ");
        int personas = sc.nextInt();

        System.out.print("¿Cuentan con membresía? (s/n): ");
        char membresia = sc.next().charAt(0);

        double total;

        if (dia == 3) {
            // Miércoles: promoción $30 por persona
            total = personas * 30;
        } else if (dia == 4) {
            // Jueves: pareja $75, individual $50
            int parejas = personas / 2;
            int individuales = personas % 2;
            total = (parejas * 75) + (individuales * 50);
        } else {
            // Resto de días: precio base $50
            total = personas * 50;
        }

        // Membresía: 10% de descuento todos los días
        if (membresia == 's' || membresia == 'S') {
            total = total * 0.9;
        }

        System.out.println("El precio total a pagar es: $" + total + " pesos");
        sc.close();
    }
}
