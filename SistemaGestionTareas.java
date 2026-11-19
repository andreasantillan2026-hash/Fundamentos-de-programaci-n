
import java.util.Scanner;

class Nodo {
    int identificador;
    String descripcion;
    String prioridad;
    boolean completada;
    Nodo siguiente;

    public Nodo(int identificador, String descripcion, String prioridad) {
        this.identificador = identificador;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.completada = false;
        this.siguiente = null;
    }
}

// Clase ListaEnlazada que administra las tareas
class ListaEnlazada {
    Nodo cabeza;

    // Registrar una tarea al final de la lista
    public void insertarFinal(int id, String descripcion, String prioridad) {
        Nodo nuevo = new Nodo(id, descripcion, prioridad);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;

            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }

            actual.siguiente = nuevo;
        }

        System.out.println("Tarea agregada al final.");
    }

    // Agregar una tarea al inicio de la lista
    public void insertarInicio(int id, String descripcion, String prioridad) {
        Nodo nuevo = new Nodo(id, descripcion, prioridad);

        nuevo.siguiente = cabeza;
        cabeza = nuevo;

        System.out.println("Tarea agregada al inicio.");
    }

    // Insertar una tarea en una posicion especifica
    public void insertarPosicion(int id, String descripcion,
                                 String prioridad, int posicion) {

        if (posicion < 1) {
            System.out.println("Posicion invalida.");
            return;
        }

        if (posicion == 1) {
            insertarInicio(id, descripcion, prioridad);
            return;
        }

        Nodo nuevo = new Nodo(id, descripcion, prioridad);
        Nodo actual = cabeza;

        for (int i = 1; i < posicion - 1 && actual != null; i++) {
            actual = actual.siguiente;
        }

        if (actual == null) {
            System.out.println("Posicion fuera de la lista.");
            return;
        }

        nuevo.siguiente = actual.siguiente;
        actual.siguiente = nuevo;

        System.out.println("Tarea insertada correctamente.");
    }

    // Eliminar una tarea por su identificador
    public void eliminar(int id) {

        if (cabeza == null) {
            System.out.println("La lista esta vacia.");
            return;
        }

        if (cabeza.identificador == id) {
            cabeza = cabeza.siguiente;
            System.out.println("Tarea eliminada.");
            return;
        }

        Nodo actual = cabeza;

        while (actual.siguiente != null &&
               actual.siguiente.identificador != id) {
            actual = actual.siguiente;
        }

        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
            System.out.println("Tarea eliminada.");
        } else {
            System.out.println("No se encontro la tarea.");
        }
    }

    // Buscar una tarea por su descripcion
    public void buscar(String descripcion) {
        Nodo actual = cabeza;
        boolean encontrado = false;

        while (actual != null) {

            if (actual.descripcion.toLowerCase()
                    .contains(descripcion.toLowerCase())) {

                mostrarTarea(actual);
                encontrado = true;
            }

            actual = actual.siguiente;
        }

        if (!encontrado) {
            System.out.println("No se encontro la tarea.");
        }
    }

    // Mostrar una tarea
    public void mostrarTarea(Nodo tarea) {
        System.out.println("--------------------------");
        System.out.println("ID: " + tarea.identificador);
        System.out.println("Descripcion: " + tarea.descripcion);
        System.out.println("Prioridad: " + tarea.prioridad);
        System.out.println("Estado: " +
                (tarea.completada ? "Completada" : "Pendiente"));
        System.out.println("--------------------------");
    }

    // Mostrar todas las tareas pendientes
    public void mostrarPendientes() {
        Nodo actual = cabeza;
        boolean encontrado = false;

        while (actual != null) {

            if (!actual.completada) {
                mostrarTarea(actual);
                encontrado = true;
            }

            actual = actual.siguiente;
        }

        if (!encontrado) {
            System.out.println("No hay tareas pendientes.");
        }
    }

    // Marcar una tarea como completada
    public void completarTarea(int id) {
        Nodo actual = cabeza;

        while (actual != null) {

            if (actual.identificador == id) {
                actual.completada = true;
                System.out.println("Tarea marcada como completada.");
                return;
            }

            actual = actual.siguiente;
        }

        System.out.println("No se encontro la tarea.");
    }

    // Mostrar la primera y ultima tarea registrada
    public void mostrarPrimeraUltima() {

        if (cabeza == null) {
            System.out.println("La lista esta vacia.");
            return;
        }

        System.out.println("PRIMERA TAREA:");
        mostrarTarea(cabeza);

        Nodo actual = cabeza;

        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }

        System.out.println("ULTIMA TAREA:");
        mostrarTarea(actual);
    }

    // Recorrer la lista en orden inverso
    public void mostrarInverso(Nodo actual) {

        if (actual == null) {
            return;
        }

        mostrarInverso(actual.siguiente);
        mostrarTarea(actual);
    }

    // Metodo para iniciar el recorrido inverso
    public void recorrerInverso() {

        if (cabeza == null) {
            System.out.println("La lista esta vacia.");
            return;
        }

        System.out.println("TAREAS EN ORDEN INVERSO:");
        mostrarInverso(cabeza);
    }

    // Mostrar todas las tareas registradas
    public void mostrarTodas() {
        Nodo actual = cabeza;

        if (actual == null) {
            System.out.println("No hay tareas registradas.");
            return;
        }

        while (actual != null) {
            mostrarTarea(actual);
            actual = actual.siguiente;
        }
    }

    // Buscar un identificador para evitar duplicados
    public boolean existeID(int id) {
        Nodo actual = cabeza;

        while (actual != null) {
            if (actual.identificador == id) {
                return true;
            }

            actual = actual.siguiente;
        }

        return false;
    }
}

// Clase principal
public class SistemaGestionTareas {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        ListaEnlazada lista = new ListaEnlazada();

        int opcion;

        do {

            System.out.println("\n================================");
            System.out.println(" SISTEMA DE GESTION DE TAREAS");
            System.out.println("================================");
            System.out.println("1. Registrar tarea al final");
            System.out.println("2. Registrar tarea al inicio");
            System.out.println("3. Insertar tarea en una posicion");
            System.out.println("4. Eliminar tarea por identificador");
            System.out.println("5. Buscar tarea por descripcion");
            System.out.println("6. Mostrar tareas pendientes");
            System.out.println("7. Marcar tarea como completada");
            System.out.println("8. Mostrar primera y ultima tarea");
            System.out.println("9. Recorrer lista en orden inverso");
            System.out.println("10. Mostrar todas las tareas");
            System.out.println("0. Salir");
            System.out.println("================================");
            System.out.print("Selecciona una opcion: ");

            opcion = entrada.nextInt();
            entrada.nextLine();

            int id;
            String descripcion;
            String prioridad;

            switch (opcion) {

                case 1:
                    System.out.print("Identificador: ");
                    id = entrada.nextInt();
                    entrada.nextLine();

                    if (lista.existeID(id)) {
                        System.out.println("El ID ya existe.");
                        break;
                    }

                    System.out.print("Descripcion: ");
                    descripcion = entrada.nextLine();

                    System.out.print("Prioridad (Alta, Media, Baja): ");
                    prioridad = entrada.nextLine();

                    lista.insertarFinal(id, descripcion, prioridad);
                    break;

                case 2:
                    System.out.print("Identificador: ");
                    id = entrada.nextInt();
                    entrada.nextLine();

                    if (lista.existeID(id)) {
                        System.out.println("El ID ya existe.");
                        break;
                    }

                    System.out.print("Descripcion: ");
                    descripcion = entrada.nextLine();

                    System.out.print("Prioridad (Alta, Media, Baja): ");
                    prioridad = entrada.nextLine();

                    lista.insertarInicio(id, descripcion, prioridad);
                    break;

                case 3:
                    System.out.print("Identificador: ");
                    id = entrada.nextInt();
                    entrada.nextLine();

                    if (lista.existeID(id)) {
                        System.out.println("El ID ya existe.");
                        break;
                    }

                    System.out.print("Descripcion: ");
                    descripcion = entrada.nextLine();

                    System.out.print("Prioridad (Alta, Media, Baja): ");
                    prioridad = entrada.nextLine();

                    System.out.print("Posicion donde insertar: ");
                    int posicion = entrada.nextInt();

                    lista.insertarPosicion(id, descripcion,
                                            prioridad, posicion);
                    break;

                case 4:
                    System.out.print("ID de la tarea a eliminar: ");
                    id = entrada.nextInt();

                    lista.eliminar(id);
                    break;

                case 5:
                    System.out.print("Descripcion a buscar: ");
                    descripcion = entrada.nextLine();

                    lista.buscar(descripcion);
                    break;

                case 6:
                    System.out.println("\nTAREAS PENDIENTES:");
                    lista.mostrarPendientes();
                    break;

                case 7:
                    System.out.print("ID de la tarea completada: ");
                    id = entrada.nextInt();

                    lista.completarTarea(id);
                    break;

                case 8:
                    lista.mostrarPrimeraUltima();
                    break;

                case 9:
                    lista.recorrerInverso();
                    break;

                case 10:
                    System.out.println("\nTODAS LAS TAREAS:");
                    lista.mostrarTodas();
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 0);

        entrada.close();
    }
}
