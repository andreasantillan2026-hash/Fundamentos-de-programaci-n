import java.util.Scanner;

public class Pasteleria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Sabores disponibles ===");
        System.out.println("1. Manzana ($200)");
        System.out.println("2. Fresa ($250)");
        System.out.println("3. Chocolate");
        System.out.print("Elige el sabor: ");
        int sabor = sc.nextInt();

        double precio = 0;
        String descripcion = "";
        boolean valido = true;

        switch (sabor) {
            case 1:
                precio = 200;
                descripcion = "Manzana";
                break;
            case 2:
                precio = 250;
                descripcion = "Fresa";
                break;
            case 3:
                System.out.println("Tipo de chocolate:");
                System.out.println("1. Negro ($280)");
                System.out.println("2. Blanco ($300)");
                System.out.print("Elige el tipo: ");
                int tipoChoco = sc.nextInt();
                if (tipoChoco == 1) {
                    precio = 280;
                    descripcion = "Chocolate negro";
                } else if (tipoChoco == 2) {
                    precio = 300;
                    descripcion = "Chocolate blanco";
                } else {
                    System.out.println("Opción de chocolate no válida.");
                    valido = false;
                }
                break;
            default:
                System.out.println("Sabor no válido.");
                valido = false;
        }

        if (valido) {
            System.out.print("¿Deseas añadir snacks (fresa, galleta, durazno, etc.)? (s/n): ");
            char addSnack = sc.next().charAt(0);
            int numSnacks = 0;
            if (addSnack == 's' || addSnack == 'S') {
                System.out.print("¿Cuántos snacks deseas añadir?: ");
                numSnacks = sc.nextInt();
                precio += numSnacks * 25;
            }

            System.out.print("¿Deseas personalizar con un nombre? (s/n): ");
            char addNombre = sc.next().charAt(0);
            String nombre = "";
            if (addNombre == 's' || addNombre == 'S') {
                precio += 30;
                System.out.print("Introduce el nombre a escribir: ");
                sc.nextLine(); // limpiar buffer
                nombre = sc.nextLine();
            }

            System.out.println("\n--- Presupuesto ---");
            System.out.println("Tarta: " + descripcion);
            if (numSnacks > 0) {
                System.out.println("Snacks añadidos: " + numSnacks + " ($" + (numSnacks * 25) + ")");
            }
            if (!nombre.isEmpty()) {
                System.out.println("Nombre personalizado: " + nombre + " ($30)");
            }
            System.out.println("Precio total: $" + precio + " pesos");
        }

        sc.close();
    }
}
