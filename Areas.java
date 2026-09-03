import java.util.Scanner;

public class Areas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Cálculo de áreas ===");
        System.out.println("1. Cuadrado");
        System.out.println("2. Rectángulo");
        System.out.println("3. Triángulo");
        System.out.println("4. Círculo");
        System.out.print("Elige una opción: ");
        int opcion = sc.nextInt();

        double area;
        switch (opcion) {
            case 1:
                System.out.print("Introduce el lado: ");
                double lado = sc.nextDouble();
                area = lado * lado;
                System.out.println("El área del cuadrado es: " + area);
                break;
            case 2:
                System.out.print("Introduce la base: ");
                double base = sc.nextDouble();
                System.out.print("Introduce la altura: ");
                double altura = sc.nextDouble();
                area = base * altura;
                System.out.println("El área del rectángulo es: " + area);
                break;
            case 3:
                System.out.print("Introduce la base: ");
                double baseT = sc.nextDouble();
                System.out.print("Introduce la altura: ");
                double alturaT = sc.nextDouble();
                area = (baseT * alturaT) / 2;
                System.out.println("El área del triángulo es: " + area);
                break;
            case 4:
                System.out.print("Introduce el radio: ");
                double radio = sc.nextDouble();
                area = Math.PI * radio * radio;
                System.out.println("El área del círculo es: " + area);
                break;
            default:
                System.out.println("Opción no válida.");
        }
        sc.close();
    }
}
