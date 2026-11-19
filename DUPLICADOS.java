
import java.util.Arrays;
import java.util.Scanner;

public class DUPLICADOS {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.print("¿Cuántos identificadores deseas ingresar? ");
        int n = teclado.nextInt();

        int[] identificadores = new int[n];

        System.out.println("\n REGISTRO DE TRANSACCIONES ");

        for (int i = 0; i < n; i++) {
            System.out.print("Identificador " + (i + 1) + ": ");
            identificadores[i] = teclado.nextInt();
        }

        System.out.println("\nArreglo original:");
        System.out.println(Arrays.toString(identificadores));

        int[] copia = Arrays.copyOf(identificadores, n);

        Arrays.sort(copia);


        System.out.println("\n IDENTIFICADORES DUPLICADOS ");

        int duplicados = 0;

        for (int i = 0; i < n; i++) {

            if (i == 0 || copia[i] != copia[i - 1]) {

                int frecuencia = 0;

                for (int j = 0; j < n; j++) {
                    if (copia[j] == copia[i]) {
                        frecuencia++;
                    }
                }

                if (frecuencia > 1) {
                    System.out.println(
                        "Identificador " + copia[i] +
                        " aparece " + frecuencia + " veces."
                    );

                    duplicados += frecuencia - 1;
                }
            }
        }

        if (duplicados == 0) {
            System.out.println("No se encontraron identificadores duplicados.");
        }

        int[] depurado = new int[n];
        int contador = 0;

        for (int i = 0; i < n; i++) {

            boolean existe = false;

            for (int j = 0; j < contador; j++) {
                if (depurado[j] == identificadores[i]) {
                    existe = true;
                    break;
                }
            }

            if (!existe) {
                depurado[contador] = identificadores[i];
                contador++;
            }
        }

        depurado = Arrays.copyOf(depurado, contador);

        System.out.println("\n RESULTADOS ");

        System.out.println("Arreglo depurado:");
        System.out.println(Arrays.toString(depurado));

        System.out.println("Apariciones eliminadas: " + duplicados);

        teclado.close();
    }
}
