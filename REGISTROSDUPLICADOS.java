
import java.util.Arrays;

public class REGISTROSDUPLICADOS {

    public static void main(String[] args) {

        int[] original = {105, 102, 105, 108, 102, 110, 108, 105};
        int[] copia = Arrays.copyOf(original, original.length);
        Arrays.sort(copia);

        int[] depuradoTemp = new int[original.length];
        int[] duplicadosTemp = new int[original.length];

        int cantidadDepurados = 0;
        int cantidadDuplicados = 0;

        for (int dato : original) {
            boolean existe = false;

            for (int i = 0; i < cantidadDepurados; i++) {
                if (depuradoTemp[i] == dato) {
                    existe = true;
                    break;
                }
            }

            if (!existe) {
                depuradoTemp[cantidadDepurados] = dato;
                cantidadDepurados++;
            }
        }

        for (int i = 0; i < copia.length - 1; i++) {
            if (copia[i] == copia[i + 1]) {

                boolean existe = false;

                for (int j = 0; j < cantidadDuplicados; j++) {
                    if (duplicadosTemp[j] == copia[i]) {
                        existe = true;
                        break;
                    }
                }

                if (!existe) {
                    duplicadosTemp[cantidadDuplicados] = copia[i];
                    cantidadDuplicados++;
                }
            }
        }

        int[] depurado = Arrays.copyOf(depuradoTemp, cantidadDepurados);
        int[] duplicados = Arrays.copyOf(duplicadosTemp, cantidadDuplicados);

        System.out.println("Arreglo original: " + Arrays.toString(original));
        System.out.println("Arreglo depurado: " + Arrays.toString(depurado));

        System.out.print("Identificadores duplicados: ");

        boolean primero = true;

        for (int dato : original) {
            for (int duplicado : duplicados) {
                if (dato == duplicado) {

                    boolean mostrado = false;

                    for (int i = 0; i < original.length; i++) {
                        if (i < original.length && original[i] == dato) {
                            if (i < original.length) {
                                boolean anterior = false;

                                for (int j = 0; j < i; j++) {
                                    if (original[j] == dato) {
                                        anterior = true;
                                        break;
                                    }
                                }

                                if (!anterior) {
                                    if (!primero) {
                                        System.out.print(", ");
                                    }

                                    System.out.print(dato);
                                    primero = false;
                                }
                            }
                            break;
                        }
                    }

                    break;
                }
            }
        }

        System.out.println();

        int eliminados = original.length - depurado.length;
        System.out.println("Registros eliminados: " + eliminados);
    }
}
