import java.util.Scanner;

public class BecasEstudiantiles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int edad;
        double promedio;

        System.out.print("Ingrese la edad del alumno: ");
        edad = sc.nextInt();

        System.out.print("Ingrese el promedio del alumno: ");
        promedio = sc.nextDouble();

        if (edad > 18) {
            if (promedio >= 9.0) {
                System.out.println("Asignación: Beca de $10,000.00");
            } else {
                if (promedio >= 7.5) {
                    System.out.println("Asignación: Beca de $8,000.00");
                } else {
                    if (promedio >= 6.0) {
                        System.out.println("Asignación: Beca de $5,000.00");
                    } else {
                        System.out.println("Se le enviará una carta de invitación a estudiar más.");
                    }
                }
            }
        } else {
            // Edad es 18 o menor
            if (promedio >= 9.0) {
                System.out.println("Asignación: Beca de $8,000.00");
            } else {
                if (promedio >= 8.0) {
                    System.out.println("Asignación: Beca de $6,000.00");
                } else {
                    if (promedio >= 6.0) {
                        System.out.println("Asignación: Beca de $4,000.00");
                    } else {
                        System.out.println("Se le enviará una carta de invitación a estudiar más.");
                    }
                }
            }
        }

        sc.close();
    }
}
