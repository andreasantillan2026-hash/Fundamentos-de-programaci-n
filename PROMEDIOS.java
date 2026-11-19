
import java.util.Scanner;

public class PROMEDIOS {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        int N, M;

        System.out.print("Introduce la cantidad de estudiantes: ");
        N = teclado.nextInt();

        System.out.print("Introduce la cantidad de examenes: ");
        M = teclado.nextInt();

        double[][] calificaciones = new double[N][M];
        double[] promedios = new double[N];
        double[] promediosExamen = new double[M];

        System.out.println("\n REGISTRO DE CALIFICACIONES ");

        for (int i = 0; i < N; i++) {

            System.out.println("\nEstudiante " + (i + 1));

            for (int j = 0; j < M; j++) {

                System.out.print("Calificacion del examen "
                        + (j + 1) + ": ");

                calificaciones[i][j] = teclado.nextDouble();
            }
        }

        System.out.println("\n MATRIZ DE CALIFICACIONES ");

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < M; j++) {

                System.out.print(calificaciones[i][j] + "\t");
            }

            System.out.println();
        }

        double suma;

        System.out.println("\n PROMEDIO DE CADA ESTUDIANTE ");

        for (int i = 0; i < N; i++) {

            suma = 0;

            for (int j = 0; j < M; j++) {
                suma += calificaciones[i][j];
            }

            promedios[i] = suma / M;

            System.out.println("Estudiante " + (i + 1)
                    + ": " + promedios[i]);
        }

        double mejorPromedio = promedios[0];

        for (int i = 1; i < N; i++) {

            if (promedios[i] > mejorPromedio) {
                mejorPromedio = promedios[i];
            }
        }

        int contadorMejores = 0;

        for (int i = 0; i < N; i++) {

            if (promedios[i] >= 9 && promedios[i] <= 10) {
                contadorMejores++;
            }
        }

        double[][] mejores = new double[contadorMejores][2];

        int posicion = 0;

        for (int i = 0; i < N; i++) {

            if (promedios[i] >= 9 && promedios[i] <= 10) {

                mejores[posicion][0] = i + 1;
                mejores[posicion][1] = promedios[i];

                posicion++;
            }
        }

        System.out.println("\n ESTUDIANTES CON PROMEDIO ENTRE 9 Y 10 ");

        if (contadorMejores == 0) {

            System.out.println("No hay estudiantes en este rango.");

        } else {

            for (int i = 0; i < mejores.length; i++) {

                System.out.println("Estudiante "
                        + (int) mejores[i][0]
                        + " | Promedio: " + mejores[i][1]);
            }
        }

        int contadorBajos = 0;

        for (int i = 0; i < N; i++) {

            if (promedios[i] < 7) {
                contadorBajos++;
            }
        }

        double[][] bajos = new double[contadorBajos][2];

        posicion = 0;

        for (int i = 0; i < N; i++) {

            if (promedios[i] < 7) {

                bajos[posicion][0] = i + 1;
                bajos[posicion][1] = promedios[i];

                posicion++;
            }
        }

        System.out.println("\n ESTUDIANTES CON PROMEDIO MENOR A 7 ");

        if (contadorBajos == 0) {

            System.out.println("No hay estudiantes con promedio menor a 7.");

        } else {

            for (int i = 0; i < bajos.length; i++) {

                System.out.println("Estudiante "
                        + (int) bajos[i][0]
                        + " | Promedio: " + bajos[i][1]);
            }
        }

        System.out.println("\n PROMEDIO DE CADA EXAMEN ");

        for (int j = 0; j < M; j++) {

            suma = 0;

            for (int i = 0; i < N; i++) {
                suma += calificaciones[i][j];
            }

            promediosExamen[j] = suma / N;

            System.out.println("Examen " + (j + 1)
                    + ": " + promediosExamen[j]);
        }

        double mayor = promediosExamen[0];
        double menor = promediosExamen[0];

        for (int j = 1; j < M; j++) {

            if (promediosExamen[j] > mayor) {
                mayor = promediosExamen[j];
            }

            if (promediosExamen[j] < menor) {
                menor = promediosExamen[j];
            }
        }

        System.out.println("\n--- EXAMEN CON PROMEDIO MAS ALTO ---");

        for (int j = 0; j < M; j++) {

            if (promediosExamen[j] == mayor) {

                System.out.println("Examen " + (j + 1)
                        + " | Promedio: " + mayor);
            }
        }

        System.out.println("\n EXAMEN CON PROMEDIO MAS BAJO ");

        for (int j = 0; j < M; j++) {

            if (promediosExamen[j] == menor) {

                System.out.println("Examen " + (j + 1)
                        + " | Promedio: " + menor);
            }
        }
    }
}
