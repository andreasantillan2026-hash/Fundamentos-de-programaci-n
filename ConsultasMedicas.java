import java.util.Scanner;

public class ConsultasMedicas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numCita;
        double costo, total;

        System.out.print("Ingrese el número de cita del paciente: ");
        numCita = sc.nextInt();

        if (numCita <= 3) {
            costo = 900;
            total = numCita * 900;
        } else {
            if (numCita <= 5) {
                costo = 800;
                total = (3 * 900) + ((numCita - 3) * 800);
            } else {
                if (numCita <= 8) {
                    costo = 600;
                    total = (3 * 900) + (2 * 800) + ((numCita - 5) * 600);
                } else {
                    costo = 500;
                    total = (3 * 900) + (2 * 800) + (3 * 600) + ((numCita - 8) * 500);
                }
            }
        }

        System.out.println("El costo de esta cita (#" + numCita + ") es: $" + costo);
        System.out.println("El acumulado total pagado por el tratamiento es: $" + total);

        sc.close();
    }
}
