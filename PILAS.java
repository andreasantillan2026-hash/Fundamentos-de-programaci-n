
import java.util.Scanner;

public class PILAS {

    static final int MAX = 5;
    static String[] pila = new String[MAX];
    static int TOPE = -1;

    static Scanner teclado = new Scanner(System.in);

    public static void PUSH(String dato) {
        if (TOPE == MAX - 1) {
            System.out.println("\n¡PILA LLENA!");
            System.out.println("Error OVERFLOW");
        } else {
            TOPE++;
            pila[TOPE] = dato;
            System.out.println("\nDato agregado: " + dato);
        }
    }

    // OPCIÓN 2: ELIMINACIÓN ORIGINAL
    public static void POP() {
        if (TOPE == -1) {
            System.out.println("\n¡PILA VACÍA!");
            System.out.println("Error UNDERFLOW");
            return;
        }

        System.out.println("\nSelecciona el número que deseas eliminar:");
        mostrarPila();

        System.out.print("\nIntroduce el dato: ");
        String dato = teclado.nextLine();

        int posicion = -1;

        for (int i = TOPE; i >= 0; i--) {
            if (pila[i].equals(dato)) {
                posicion = i;
                break;
            }
        }

        if (posicion == -1) {
            System.out.println("\nEl dato no existe en la pila.");
            return;
        }

        for (int i = TOPE; i >= posicion; i--) {
            System.out.println("Dato eliminado: " + pila[i]);
            pila[i] = null;
        }

        TOPE = posicion - 1;

        System.out.println("\nEliminación realizada correctamente.");
    }

    public static void eliminarDatoYArriba() {

        if (TOPE == -1) {
            System.out.println("\n¡PILA VACÍA!");
            System.out.println("Error UNDERFLOW");
            return;
        }

        System.out.println("\nSelecciona el dato que deseas eliminar junto con el de arriba:");
        mostrarPila();

        System.out.print("\nIntroduce el dato: ");
        String dato = teclado.nextLine();

        int posicion = -1;

        for (int i = TOPE; i >= 0; i--) {
            if (pila[i].equals(dato)) {
                posicion = i;
                break;
            }
        }

        if (posicion == -1) {
            System.out.println("\nEl dato no existe en la pila.");
            return;
        }

        System.out.println("Dato eliminado: " + pila[posicion]);
        pila[posicion] = null;

        if (posicion < TOPE) {
            System.out.println("Dato eliminado: " + pila[posicion + 1]);
            pila[posicion + 1] = null;
        }

        int cantidadEliminada = 1;

        if (posicion < TOPE) {
            cantidadEliminada = 2;
        }

        for (int i = posicion; i <= TOPE - cantidadEliminada; i++) {
            pila[i] = pila[i + cantidadEliminada];
            pila[i + cantidadEliminada] = null;
        }

        TOPE = TOPE - cantidadEliminada;

        System.out.println("\nEliminación realizada correctamente.");
    }

    public static void mostrarPila() {
        System.out.println("\n ESTADO DE LA PILA ");

        for (int i = MAX - 1; i >= 0; i--) {
            if (pila[i] == null) {
                System.out.println(" ");
            } else {
                System.out.println(" " + pila[i] + " ");
            }
        }

        System.out.println("TOPE = " + TOPE);
        System.out.println("MAX = " + MAX);

        if (TOPE == -1) {
            System.out.println("Estado: ¡PILA VACÍA!");
        } else if (TOPE == MAX - 1) {
            System.out.println("Estado: ¡PILA LLENA!");
        } else {
            System.out.println("Estado: PILA CON ESPACIO");
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n MENÚ DE PILA");
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
                    eliminarDatoYArriba();
                    mostrarPila();
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
