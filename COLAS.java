
import java.util.Scanner;

public class COLAS {

    static final int MAX = 5;
    static String[] pila = new String[MAX];
    static int TOPE = -1;

    static Scanner teclado = new Scanner(System.in);

    public static void PUSH(String dato) {
        if (TOPE == MAX - 1) {
            System.out.println("\n¡COLA LLENA!");
            System.out.println("Error OVERFLOW");
            return;
        }

        pila[++TOPE] = dato;
        System.out.println("\nDato agregado: " + dato);
    }

    public static void POP() {
        if (TOPE == -1) {
            System.out.println("\nLa cola está vacía.");
            return;
        }

        System.out.print("Introduce el dato que deseas eliminar: ");
        String dato = teclado.nextLine();

        int posicion = -1;

        for (int i = 0; i <= TOPE; i++) {
            if (pila[i] != null && pila[i].equals(dato)) {
                posicion = i;
                break;
            }
        }

        if (posicion == -1) {
            System.out.println("El dato no existe en la cola.");
            return;
        }

        int inicio = posicion;

        if (posicion > 0) {
            inicio = posicion - 1;
        }

        System.out.println("\nElemento eliminado: " + pila[posicion]);

        if (inicio != posicion) {
            System.out.println("Elemento de abajo eliminado: " + pila[inicio]);
        }

        int cantidadEliminar = posicion - inicio + 1;

        for (int i = inicio; i <= TOPE - cantidadEliminar; i++) {
            pila[i] = pila[i + cantidadEliminar];
        }

        for (int i = TOPE - cantidadEliminar + 1; i <= TOPE; i++) {
            pila[i] = null;
        }

        TOPE -= cantidadEliminar;
    }

    public static void eliminarDatoYAbajo() {

        if (TOPE == -1) {
            System.out.println("\nLa cola está vacía.");
            return;
        }

        System.out.println("\nIntroduce el dato que deseas eliminar junto con el de abajo:");

        mostrarPila();

        System.out.print("\nIntroduce el dato: ");
        String dato = teclado.nextLine();

        int posicion = -1;

        for (int i = 0; i <= TOPE; i++) {
            if (pila[i] != null && pila[i].equals(dato)) {
                posicion = i;
                break;
            }
        }

        if (posicion == -1) {
            System.out.println("El dato no existe en la cola.");
            return;
        }

        System.out.println("\nElemento eliminado: " + pila[posicion]);

        int cantidadEliminar = 1;

        if (posicion > 0) {
            System.out.println("Elemento de abajo eliminado: " + pila[posicion - 1]);
            cantidadEliminar = 2;
        }

        int inicio = posicion - (cantidadEliminar - 1);

        for (int i = inicio; i <= TOPE - cantidadEliminar; i++) {
            pila[i] = pila[i + cantidadEliminar];
        }

        for (int i = TOPE - cantidadEliminar + 1; i <= TOPE; i++) {
            pila[i] = null;
        }

        TOPE -= cantidadEliminar;

        System.out.println("\nEliminación realizada correctamente.");
    }

    public static void mostrarPila() {
        System.out.println("\n--- ESTADO DE LA COLA ---");

        for (int i = MAX - 1; i >= 0; i--) {
            if (pila[i] == null) {
                System.out.println("");
            } else {
                System.out.println("" + pila[i] + "");
            }
        }

        System.out.println("TOPE = " + TOPE);
        System.out.println("MAX = " + MAX);

        if (TOPE == MAX - 1) {
            System.out.println("Estado: COLA LLENA");
        } else if (TOPE >= 0) {
            System.out.println("Estado: COLA CON ESPACIO");
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n MENÚ DE COLA ");
            System.out.println("1. PUSH - Introducir dato");
            System.out.println("2. POP - Eliminar ");
            System.out.println("3. Eliminar dato ");
            System.out.print("Selecciona una opción: ");

            if (!teclado.hasNextInt()) {
                System.out.println("Ingresa un número válido.");
                teclado.nextLine();
                continue;
            }

            int opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Introduce un dato: ");
                    String dato = teclado.nextLine();

                    if (dato.trim().isEmpty()) {
                        System.out.println("El dato no puede estar vacío.");
                    } else {
                        PUSH(dato);
                        mostrarPila();
                    }
                    break;

                case 2:
                    POP();
                    mostrarPila();
                    break;

                case 3:
                    eliminarDatoYAbajo();
                    mostrarPila();
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
