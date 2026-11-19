
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ADMINISTRACIÓNDEESTUDIANTES {

    static Scanner teclado = new Scanner(System.in);

    static ArrayList<String> matriculas = new ArrayList<>();
    static ArrayList<String> nombres = new ArrayList<>();
    static ArrayList<Double> calificaciones = new ArrayList<>();

    public static void registrar() {

        System.out.print("\nIntroduce la matricula: ");
        String matricula = teclado.nextLine();

        if (matriculas.contains(matricula)) {
            System.out.println("Error: La matricula ya existe.");
            return;
        }

        System.out.print("Introduce el nombre: ");
        String nombre = teclado.nextLine();

        System.out.print("Introduce la calificacion: ");
        double calificacion = teclado.nextDouble();
        teclado.nextLine();

        if (calificacion < 0 || calificacion > 10) {
            System.out.println("Calificacion no valida.");
            return;
        }

        matriculas.add(matricula);
        nombres.add(nombre);
        calificaciones.add(calificacion);

        System.out.println("Estudiante registrado correctamente.");
    }

    public static void mostrar() {

        if (matriculas.isEmpty()) {
            System.out.println("\nNo hay estudiantes registrados.");
            return;
        }

        ArrayList<Integer> orden = new ArrayList<>();

        for (int i = 0; i < nombres.size(); i++) {
            orden.add(i);
        }

        Collections.sort(orden, (a, b) ->
            nombres.get(a).compareToIgnoreCase(nombres.get(b))
        );

        System.out.println("\n--- LISTA DE ESTUDIANTES ---");

        for (int i : orden) {
            System.out.println("\nMatricula: " + matriculas.get(i));
            System.out.println("Nombre: " + nombres.get(i));
            System.out.println("Calificacion: " + calificaciones.get(i));
        }
    }

    public static int buscar() {

        System.out.print("\nIntroduce la matricula a buscar: ");
        String matricula = teclado.nextLine();

        int posicion = matriculas.indexOf(matricula);

        if (posicion != -1) {
            System.out.println("\nEstudiante encontrado:");
            System.out.println("Matricula: " + matriculas.get(posicion));
            System.out.println("Nombre: " + nombres.get(posicion));
            System.out.println("Calificacion: " + calificaciones.get(posicion));
        } else {
            System.out.println("Estudiante no encontrado.");
        }

        return posicion;
    }

    public static void modificar() {

        int posicion = buscar();

        if (posicion != -1) {

            System.out.print("\nIntroduce la nueva calificacion: ");
            double nueva = teclado.nextDouble();
            teclado.nextLine();

            if (nueva < 0 || nueva > 10) {
                System.out.println("Calificacion no valida.");
                return;
            }

            calificaciones.set(posicion, nueva);

            System.out.println("Calificacion modificada correctamente.");
        }
    }

    public static void eliminar() {

        int posicion = buscar();

        if (posicion != -1) {

            matriculas.remove(posicion);
            nombres.remove(posicion);
            calificaciones.remove(posicion);

            System.out.println("Estudiante eliminado correctamente.");
        }
    }

    public static void promedio() {

        if (calificaciones.isEmpty()) {
            System.out.println("\nNo hay calificaciones registradas.");
            return;
        }

        double suma = 0;

        for (double calificacion : calificaciones) {
            suma += calificacion;
        }

        double promedio = suma / calificaciones.size();

        System.out.printf("\nPromedio general del grupo: %.2f%n", promedio);
    }

    public static void mayorYMenor() {

        if (calificaciones.isEmpty()) {
            System.out.println("\nNo hay estudiantes registrados.");
            return;
        }

        double mayor = Collections.max(calificaciones);
        double menor = Collections.min(calificaciones);

        System.out.println("\n--- CALIFICACION MAS ALTA ---");

        for (int i = 0; i < calificaciones.size(); i++) {
            if (calificaciones.get(i) == mayor) {
                System.out.println(nombres.get(i) + " - " + mayor);
            }
        }

        System.out.println("\n--- CALIFICACION MAS BAJA ---");

        for (int i = 0; i < calificaciones.size(); i++) {
            if (calificaciones.get(i) == menor) {
                System.out.println(nombres.get(i) + " - " + menor);
            }
        }
    }

    public static void sobresalientes() {

        boolean encontrado = false;

        System.out.println("\n--- ESTUDIANTES CON CALIFICACION MAYOR A 9 ---");

        for (int i = 0; i < calificaciones.size(); i++) {

            if (calificaciones.get(i) > 9) {

                System.out.println("\nMatricula: " + matriculas.get(i));
                System.out.println("Nombre: " + nombres.get(i));
                System.out.println("Calificacion: " + calificaciones.get(i));

                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No hay estudiantes con calificacion mayor a 9.");
        }
    }

    public static void main(String[] args) {

        int opcion;

        do {

            System.out.println("\n MENU PRINCIPAL ");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Mostrar todos los estudiantes");
            System.out.println("3. Buscar estudiante por matricula");
            System.out.println("4. Modificar calificacion");
            System.out.println("5. Eliminar estudiante");
            System.out.println("6. Mostrar promedio general");
            System.out.println("7. Mostrar calificacion mayor y menor");
            System.out.println("8. Mostrar estudiantes con calificacion mayor a 9");
            System.out.println("9. Salir");
            System.out.print("\nSelecciona una opcion: ");

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                case 1:
                    registrar();
                    break;

                case 2:
                    mostrar();
                    break;

                case 3:
                    buscar();
                    break;

                case 4:
                    modificar();
                    break;

                case 5:
                    eliminar();
                    break;

                case 6:
                    promedio();
                    break;

                case 7:
                    mayorYMenor();
                    break;

                case 8:
                    sobresalientes();
                    break;

                case 9:
                    System.out.println("\nPrograma finalizado.");
                    break;

                default:
                    System.out.println("\nOpcion no valida.");
            }

        } while (opcion != 9);
    }
}
