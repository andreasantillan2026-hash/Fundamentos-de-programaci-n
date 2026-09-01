import java.util.Scanner;

public class IdentificadorDeNumeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num;

        System.out.print("Ingrese un número entero: ");
        num = sc.nextInt();

        if (num == 0) {
            System.out.println("El número es NEUTRO (0).");
        } else {
            if (num % 2 == 0) {
                System.out.println("El número es PAR.");
            } else {
                System.out.println("El número es IMPAR.");
            }
        }

        sc.close();
    }
}
