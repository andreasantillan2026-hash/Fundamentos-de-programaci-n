import java.util.Scanner;

public class PrecioDeLaUva {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String tipo;
        int tamano;
        double cantidad, precioInicial, ganancia, precioFinal, total;

        System.out.print("Ingrese el precio inicial por cantidad ($): ");
        precioInicial = sc.nextDouble();

        System.out.print("Ingrese cantidad de uva entregada: ");
        cantidad = sc.nextDouble();

        System.out.print("Ingrese el tipo de uva (A o B): ");
        tipo = sc.next();

        System.out.print("Ingrese el tamaño de la uva (1 o 2): ");
        tamano = sc.nextInt();

        if (tipo.equalsIgnoreCase("A")) {
            if (tamano == 1) {
                precioFinal = precioInicial + 0.20;
            } else {
                precioFinal = precioInicial + 0.30;
            }
        } else {
            if (tamano == 1) {
                precioFinal = precioInicial - 0.30;
            } else {
                precioFinal = precioInicial - 0.50;
            }
        }

        ganancia = cantidad * precioFinal;
        total = precioFinal * cantidad;

        System.out.println("Total: " + total);

        sc.close();
    }
}
