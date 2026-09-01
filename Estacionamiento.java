import java.util.Scanner;

public class Estacionamiento {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h;
        double c;

        System.out.print("Ingrese las horas que permaneció en el estacionamiento: ");
        h = sc.nextInt();

        if (h <= 2) {
            c = h * 30;
        } else {
            if (h <= 5) {
                c = (2 * 30) + ((h - 2) * 25);
            } else {
                if (h <= 10) {
                    c = (2 * 30) + (3 * 25) + ((h - 5) * 20);
                } else {
                    c = 380; // tarifa por día completo
                }
            }
        }

        System.out.println("El cobro total del estacionamiento es: $" + c);

        sc.close();
    }
}
