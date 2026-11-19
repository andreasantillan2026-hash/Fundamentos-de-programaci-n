
import java.util.Scanner;

class Nodo {
    int id;
    String descripcion;
    String prioridad;
    boolean completada;

    Nodo siguiente;
    Nodo anterior;

    public Nodo(int id, String descripcion, String prioridad) {
        this.id = id;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.completada = false;
        this.siguiente = null;
        this.anterior = null;
    }
}

public class SISTEMADEGESTION {

    static Scanner teclado = new Scanner(System.in);

    static Nodo inicio = null;
    static Nodo fin = null;

    public static Nodo buscarID(int id) {
        Nodo actual = inicio;

        while (actual != null) {
            if (actual.id == id) {
                return actual;
            }
            actual = actual.siguiente;
        }

        return null;
    }

    public static void agregarInicio() {
        System.out.print("Identificador: ");
        int id = teclado.nextInt();
        teclado.nextLine();

        if (buscarID(id) != null) {
            System.out.println("El identificador ya existe.");
            return;
        }

        System.out.print("Descripcion: ");
        String descripcion = teclado.nextLine();

        System.out.print("Prioridad: ");
        String prioridad = teclado.nextLine();

        Nodo nuevo = new Nodo(id, descripcion, prioridad);

        if (inicio == null) {
            inicio = fin = nuevo;
        } else {
            nuevo.siguiente = inicio;
            inicio.anterior = nuevo;
            inicio = nuevo;
        }

        System.out.println("Tarea agregada al inicio.");
    }

    public static void agregarFinal() {
        System.out.print("Identificador: ");
        int id = teclado.nextInt();
        teclado.nextLine();

        if (buscarID(id) != null) {
            System.out.println("El identificador ya existe.");
            return;
        }

        System.out.print("Descripcion: ");
        String descripcion = teclado.nextLine();

        System.out.print("Prioridad: ");
        String prioridad = teclado.nextLine();

        Nodo nuevo = new Nodo(id, descripcion, prioridad);

        if (fin == null) {
            inicio = fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            nuevo.anterior = fin;
            fin = nuevo;
        }

        System.out.println("Tarea agregada al final.");
    }

    public static void insertarPosicion() {
        System.out.print("Posicion donde insertar: ");
        int posicion = teclado.nextInt();
        teclado.nextLine();

        if (posicion < 1) {
            System.out.println("Posicion no valida.");
            return;
        }

        if (posicion == 1) {
            agregarInicio();
            return;
        }

        Nodo actual = inicio;
        int contador = 1;

        while (actual != null && contador < posicion) {
            actual = actual.siguiente;
            contador++;
        }

        if (actual == null) {
            if (contador == posicion) {
                agregarFinal();
            } else {
                System.out.println("Posicion fuera de la lista.");
            }
            return;
        }

        System.out.print("Identificador: ");
        int id = teclado.nextInt();
        teclado.nextLine();

        if (buscarID(id) != null) {
            System.out.println("El identificador ya existe.");
            return;
        }

        System.out.print("Descripcion: ");
        String descripcion = teclado.nextLine();

        System.out.print("Prioridad: ");
        String prioridad = teclado.nextLine();

        Nodo nuevo = new Nodo(id, descripcion, prioridad);

        Nodo anterior = actual.anterior;

        nuevo.siguiente = actual;
        nuevo.anterior = anterior;

        anterior.siguiente = nuevo;
        actual.anterior = nuevo;

        System.out.println("Tarea insertada correctamente.");
    }

    public static void eliminarTarea() {
        System.out.print("Identificador de la tarea: ");
        int id = teclado.nextInt();

        Nodo actual = buscarID(id);

        if (actual == null) {
            System.out.println("Tarea no encontrada.");
            return;
        }

        if (actual == inicio) {
            inicio = actual.siguiente;
        } else {
            actual.anterior.siguiente = actual.siguiente;
        }

        if (actual == fin) {
            fin = actual.anterior;
        } else {
            actual.siguiente.anterior = actual.anterior;
        }

        System.out.println("Tarea eliminada correctamente.");
    }

    public static void buscarDescripcion() {
        teclado.nextLine();

        System.out.print("Descripcion que deseas buscar: ");
        String descripcion = teclado.nextLine();

        Nodo actual = inicio;
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
            System.out.println("No se encontraron tareas.");
        }
    }

    public static void mostrarTarea(Nodo tarea) {
        System.out.println("ID: " + tarea.id);
        System.out.println("Descripcion: " + tarea.descripcion);
        System.out.println("Prioridad: " + tarea.prioridad);

        System.out.println("Estado: " +
            (tarea.completada ? "Completada" : "Pendiente"));
    }

    public static void mostrarTareas() {
        Nodo actual = inicio;
        boolean encontrado = false;

        System.out.println("\n TAREAS PENDIENTES ");

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

    public static void completarTarea() {
        System.out.print("Identificador de la tarea: ");
        int id = teclado.nextInt();

        Nodo actual = buscarID(id);

        if (actual == null) {
            System.out.println("Tarea no encontrada.");
        } else if (actual.completada) {
            System.out.println("La tarea ya estaba completada.");
        } else {
            actual.completada = true;
            System.out.println("Tarea marcada como completada.");
        }
    }

    public static void primeraUltima() {

        if (inicio == null) {
            System.out.println("La lista esta vacia.");
            return;
        }

        System.out.println("\n PRIMERA TAREA ");
        mostrarTarea(inicio);

        System.out.println("\n ULTIMA TAREA ");
        mostrarTarea(fin);
    }

    public static void mostrarInverso() {

        if (fin == null) {
            System.out.println("La lista esta vacia.");
            return;
        }

        Nodo actual = fin;

        System.out.println("\n TAREAS EN ORDEN INVERSO ");

        while (actual != null) {
            mostrarTarea(actual);
            actual = actual.anterior;
        }
    }

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n GESTION DE TAREAS ");
            System.out.println("1. Agregar tarea al inicio");
            System.out.println("2. Agregar tarea al final");
            System.out.println("3. Insertar tarea en una posicion");
            System.out.println("4. Eliminar tarea por identificador");
            System.out.println("5. Buscar tarea por descripcion");
            System.out.println("6. Mostrar tareas pendientes");
            System.out.println("7. Marcar tarea como completada");
            System.out.println("8. Mostrar primera y ultima tarea");
            System.out.println("9. Recorrer lista en orden inverso");

            System.out.print("Selecciona una opcion: ");
            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
                    agregarInicio();
                    break;

                case 2:
                    agregarFinal();
                    break;

                case 3:
                    insertarPosicion();
                    break;

                case 4:
                    eliminarTarea();
                    break;

                case 5:
                    buscarDescripcion();
                    break;

                case 6:
                    mostrarTareas();
                    break;

                case 7:
                    completarTarea();
                    break;

                case 8:
                    primeraUltima();
                    break;

                case 9:
                    mostrarInverso();
                    break;

                case 10:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 10);

        teclado.close();
    }
}
