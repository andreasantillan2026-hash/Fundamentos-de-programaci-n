
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SISTEMACLIENTES {

    static Queue<Cliente> cola = new LinkedList<>();
    static Scanner teclado = new Scanner(System.in);

    // Clase para almacenar los datos del cliente
    static class Cliente {
        int turno;
        String nombre;

        public Cliente(int turno, String nombre) {
            this.turno = turno;
            this.nombre = nombre;
        }

        @Override
        public String toString() {
            return "Turno: " + turno + " | Nombre: " + nombre;
        }
    }

    // 1 y 2. Registrar cliente al final de la cola
    public static void registrarCliente() {

        System.out.print("\nIngrese el número de turno: ");
        int turno = teclado.nextInt();
        teclado.nextLine();

        // Evitar turnos duplicados
        for (Cliente c : cola) {
            if (c.turno == turno) {
                System.out.println("Ese número de turno ya existe.");
                return;
            }
        }

        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = teclado.nextLine();

        cola.offer(new Cliente(turno, nombre));

        System.out.println("Cliente registrado correctamente.");
    }

    // 3. Atender al siguiente cliente
    public static void atenderCliente() {

        if (cola.isEmpty()) {
            System.out.println("\nNo hay clientes pendientes.");
        } else {
            Cliente atendido = cola.poll();

            System.out.println("\nCliente atendido:");
            System.out.println(atendido);
        }
    }

    // 4. Mostrar siguiente cliente sin eliminarlo
    public static void siguienteCliente() {

        if (cola.isEmpty()) {
            System.out.println("\nNo hay clientes pendientes.");
        } else {
            System.out.println("\nSiguiente cliente:");
            System.out.println(cola.peek());
        }
    }

    // 5. Mostrar todos los clientes pendientes
    public static void mostrarClientes() {

        if (cola.isEmpty()) {
            System.out.println("\nNo hay clientes pendientes.");
        } else {
            System.out.println("\n--- CLIENTES EN ESPERA ---");

            for (Cliente c : cola) {
                System.out.println(c);
            }
        }
    }

    // 6. Consultar cantidad de clientes
    public static void cantidadClientes() {

        System.out.println("\nClientes esperando: " + cola.size());
    }

    // 7. Cancelar un turno específico
    public static void cancelarTurno() {

        if (cola.isEmpty()) {
            System.out.println("\nNo hay clientes para cancelar.");
            return;
        }

        System.out.print("\nIngrese el número de turno que desea cancelar: ");
        int turno = teclado.nextInt();

        boolean encontrado = false;

        for (Cliente c : cola) {
            if (c.turno == turno) {
                cola.remove(c);
                encontrado = true;
                System.out.println("Turno cancelado correctamente.");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró el turno indicado.");
        }
    }

    // Menú principal
    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n===== SISTEMA DE ATENCIÓN DE CLIENTES =====");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Atender siguiente cliente");
            System.out.println("3. Mostrar siguiente cliente");
            System.out.println("4. Mostrar todos los clientes");
            System.out.println("5. Consultar cantidad de clientes");
            System.out.println("6. Cancelar turno específico");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
                    registrarCliente();
                    break;

                case 2:
                    atenderCliente();
                    break;

                case 3:
                    siguienteCliente();
                    break;

                case 4:
                    mostrarClientes();
                    break;

                case 5:
                    cantidadClientes();
                    break;

                case 6:
                    cancelarTurno();
                    break;

                case 7:
                    System.out.println("\nSaliendo del sistema...");
                    break;

                default:
                    System.out.println("\nOpción no válida.");
            }

        } while (opcion != 7);

        teclado.close();
    }
}
