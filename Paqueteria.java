import java.util.Scanner;

public class Paqueteria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int pesoG, zona;
        double costoG, costoTotal;

        System.out.print("Ingrese el peso del paquete en gramos (máximo 5000g): ");
        pesoG = sc.nextInt();

        if (pesoG > 5000) {
            System.out.println("RECHAZADO: El paquete supera los 5 kg (5000 gramos).");
        } else {
            System.out.println("Seleccione la zona de destino:");
            System.out.println("1. América del Norte");
            System.out.println("2. América Central");
            System.out.println("3. América del Sur");
            System.out.println("4. Europa");
            System.out.println("5. Asia");
            zona = sc.nextInt();

            switch (zona) {
                case 1:
                    costoG = 11;
                    break;
                case 2:
                    costoG = 10;
                    break;
                case 3:
                    costoG = 12;
                    break;
                case 4:
                    costoG = 25;
                    break;
                case 5:
                    costoG = 30;
                    break;
                default:
                    costoG = 0;
                    break;
            }

            if (costoG > 0) {
                costoTotal = pesoG * costoG;
                System.out.println("El costo de envío es: $" + costoTotal);
            } else {
                System.out.println("Zona no válida.");
            }
        }

        sc.close();
    }
}
