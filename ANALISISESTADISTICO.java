
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ANALISISESTADISTICO {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        final int SUCURSALES = 5;
        final int MESES = 12;

        String[] meses = {
            "Enero", "Febrero", "Marzo", "Abril",
            "Mayo", "Junio", "Julio", "Agosto",
            "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };

        double[][] ventas = new double[SUCURSALES][MESES];
        double[] totales = new double[SUCURSALES];
        double[] promedios = new double[SUCURSALES];
        int[] mejorMes = new int[SUCURSALES];

        System.out.println("REGISTRO DE VENTAS ");

        for (int i = 0; i < SUCURSALES; i++) {

            System.out.println("\n  SUCURSAL " + (i + 1) + " ");

            for (int j = 0; j < MESES; j++) {

                System.out.print("Ventas de " + meses[j] + ": $");

                ventas[i][j] = teclado.nextDouble();

                while (ventas[i][j] < 0) {
                    System.out.print(
                        "La venta no puede ser negativa. Intenta de nuevo: $"
                    );
                    ventas[i][j] = teclado.nextDouble();
                }
            }
        }

        double sumaGlobal = 0;

        for (int i = 0; i < SUCURSALES; i++) {

            double mayor = ventas[i][0];
            mejorMes[i] = 0;

            for (int j = 0; j < MESES; j++) {

                totales[i] += ventas[i][j];

                if (ventas[i][j] > mayor) {
                    mayor = ventas[i][j];
                    mejorMes[i] = j;
                }
            }

            promedios[i] = totales[i] / MESES;
            sumaGlobal += totales[i];
        }

        double promedioGlobal = sumaGlobal / SUCURSALES;

        System.out.println("\n REPORTE DE VENTAS ");

        for (int i = 0; i < SUCURSALES; i++) {

            System.out.println("\nSucursal " + (i + 1));
            System.out.println("Ventas mensuales: "
                    + Arrays.toString(ventas[i]));

            System.out.printf("Total anual: $%.2f%n",
                    totales[i]);

            System.out.printf("Promedio mensual: $%.2f%n",
                    promedios[i]);

            System.out.println("Mes con mayores ventas: "
                    + meses[mejorMes[i]]);

            System.out.printf("Ventas del mejor mes: $%.2f%n",
                    ventas[i][mejorMes[i]]);
        }

        System.out.printf("%nPromedio anual global: $%.2f%n",
                promedioGlobal);

        System.out.println(
                "\n SUCURSALES SOBRE EL PROMEDIO GLOBAL ");

        for (int i = 0; i < SUCURSALES; i++) {

            if (totales[i] > promedioGlobal) {
                System.out.printf("Sucursal %d: $%.2f%n",
                        i + 1, totales[i]);
            }
        }

        Integer[] indices = new Integer[SUCURSALES];

        for (int i = 0; i < SUCURSALES; i++) {
            indices[i] = i;
        }

        Integer[] ranking = Arrays.copyOf(indices, indices.length);

        Arrays.sort(ranking,
                Comparator.comparingDouble(
                        (Integer i) -> totales[i]
                ).reversed());

        System.out.println("\n RANKING DE SUCURSALES ");

        for (int i = 0; i < ranking.length; i++) {

            int posicion = ranking[i];

            System.out.printf("%d. Sucursal %d - $%.2f%n",
                    i + 1,
                    posicion + 1,
                    totales[posicion]);
        }

        teclado.close();
    }
}
