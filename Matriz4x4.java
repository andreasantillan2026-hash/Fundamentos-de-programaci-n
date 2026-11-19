import java.util.Scanner;

public class Matriz4x4 {

    static Scanner teclado = new Scanner(System.in);

    static int[][] matriz = new int[4][4];
    static boolean llena = false;

    public static void mostrarMatriz() {
        System.out.println("\n MATRIZ ORIGINAL ");

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static boolean existe(int numero) {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                if (matriz[i][j] == numero) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void rellenarMatriz() {

        System.out.println("\n RELLENAR MATRIZ ");

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                while (true) {

                    System.out.print("Introduce un numero para [" +
                            (i + 1) + "][" + (j + 1) + "]: ");

                    int numero = teclado.nextInt();

                    if (existe(numero)) {
                        System.out.println("El numero ya existe. Introduce otro.");
                    } else {
                        matriz[i][j] = numero;
                        break;
                    }
                }
            }
        }

        llena = true;

        System.out.println("\n¡Matriz rellenada correctamente!");
    }

    public static void sumaFilasColumnas() {

        System.out.println("\n SUMA DE FILAS ");

        for (int i = 0; i < 4; i++) {

            long suma = 0;

            for (int j = 0; j < 4; j++) {
                suma += matriz[i][j];
            }

            System.out.println("Fila " + (i + 1) + ": " + suma);
        }

        System.out.println("\n SUMA DE COLUMNAS ");

        for (int j = 0; j < 4; j++) {

            long suma = 0;

            for (int i = 0; i < 4; i++) {
                suma += matriz[i][j];
            }

            System.out.println("Columna " + (j + 1) + ": " + suma);
        }
    }

    public static void sumarFila() {

        System.out.print("\nIntroduce el numero de fila (1-4): ");
        int fila = teclado.nextInt();

        if (fila < 1 || fila > 4) {
            System.out.println("Fila incorrecta. Debes elegir entre 1 y 4.");
            return;
        }

        long suma = 0;

        for (int j = 0; j < 4; j++) {
            suma += matriz[fila - 1][j];
        }

        System.out.println("La suma de la fila " + fila + " es: " + suma);
    }

    public static void sumarColumna() {

        System.out.print("\nIntroduce el numero de columna (1-4): ");
        int columna = teclado.nextInt();

        if (columna < 1 || columna > 4) {
            System.out.println("Columna incorrecta. Debes elegir entre 1 y 4.");
            return;
        }

        long suma = 0;

        for (int i = 0; i < 4; i++) {
            suma += matriz[i][columna - 1];
        }

        System.out.println("La suma de la columna " + columna + " es: " + suma);
    }

    public static void mayorMenor() {

        int mayor = matriz[0][0];
        int menor = matriz[0][0];

        int filaMayor = 0, columnaMayor = 0;
        int filaMenor = 0, columnaMenor = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                if (matriz[i][j] > mayor) {
                    mayor = matriz[i][j];
                    filaMayor = i;
                    columnaMayor = j;
                }

                if (matriz[i][j] < menor) {
                    menor = matriz[i][j];
                    filaMenor = i;
                    columnaMenor = j;
                }
            }
        }

        System.out.println("\nEl numero mayor es: " + mayor);
        System.out.println("Posicion: Fila " + (filaMayor + 1) +
                ", Columna " + (columnaMayor + 1));

        System.out.println("\nEl numero menor es: " + menor);
        System.out.println("Posicion: Fila " + (filaMenor + 1) +
                ", Columna " + (columnaMenor + 1));
    }

    public static void contarPares() {

        int pares = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                if (matriz[i][j] % 2 == 0) {
                    pares++;
                }
            }
        }

        System.out.println("\nCantidad de numeros pares: " + pares);
    }

    public static void contarImpares() {

        int impares = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                if (matriz[i][j] % 2 != 0) {
                    impares++;
                }
            }
        }

        System.out.println("\nCantidad de numeros impares: " + impares);
    }

    public static void matrizCuadrados() {

        long[][] cuadrados = new long[4][4];

        System.out.println("\n MATRIZ DE CUADRADOS ");

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                cuadrados[i][j] = (long) matriz[i][j] * matriz[i][j];

                System.out.print(cuadrados[i][j] + "\t");
            }

            System.out.println();
        }
    }

    public static void diagonalPrincipal() {

        long suma = 0;

        for (int i = 0; i < 4; i++) {
            suma += matriz[i][i];
        }

        System.out.println("\nLa suma de la diagonal principal es: " + suma);
    }

    public static void diagonalInversa() {

        long suma = 0;

        for (int i = 0; i < 4; i++) {
            suma += matriz[i][3 - i];
        }

        System.out.println("\nLa suma de la diagonal inversa es: " + suma);
    }

    public static void calcularMedia() {

        long suma = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                suma += matriz[i][j];
            }
        }

        double media = suma / 16.0;

        System.out.println("\nLa media de todos los valores es: " + media);
    }

    public static void main(String[] args) {

        int opcion;

        do {

            System.out.println("\n MENU PRINCIPAL ");
            System.out.println("1. Rellenar toda la matriz");
            System.out.println("2. Suma de cada fila y columna");
            System.out.println("3. Suma de una fila");
            System.out.println("4. Suma de una columna");
            System.out.println("5. Mostrar numero mayor y menor y su posicion");
            System.out.println("6. Contar numeros pares");
            System.out.println("7. Contar numeros impares");
            System.out.println("8. Crear matriz con los cuadrados");
            System.out.println("9. Sumar diagonal principal");
            System.out.println("10. Sumar diagonal inversa");
            System.out.println("11. Calcular la media");

            System.out.print("Selecciona una opcion: ");
            opcion = teclado.nextInt();
            if (!llena && opcion != 1 && opcion != 0) {

                System.out.println("\nPrimero debes rellenar la matriz.");
            } else {

                switch (opcion) {

                    case 1:
                        if (!llena) {
                            rellenarMatriz();
                        } else {
                            System.out.println("\nLa matriz ya fue rellenada.");
                        }
                        break;

                    case 2:
                        sumaFilasColumnas();
                        break;

                    case 3:
                        sumarFila();
                        break;

                    case 4:
                        sumarColumna();
                        break;

                    case 5:
                        mayorMenor();
                        break;

                    case 6:
                        contarPares();
                        break;

                    case 7:
                        contarImpares();
                        break;

                    case 8:
                        matrizCuadrados();
                        break;

                    case 9:
                        diagonalPrincipal();
                        break;

                    case 10:
                        diagonalInversa();
                        break;

                    case 11:
                        calcularMedia();
                        break;

                    case 0:
                        System.out.println("\nPrograma finalizado.");
                        break;

                    default:
                        System.out.println("\nOpcion no valida.");
                }

                if (llena && opcion != 0) {
                    mostrarMatriz();
                }
            }

        } while (opcion != 0);

        teclado.close();
    }
}
