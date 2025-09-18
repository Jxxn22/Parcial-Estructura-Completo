import domain.Ahorro;
import domain.Corriente;
import domain.Cuenta;
import java.util.Scanner;
import service.ServiceCuenta;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ServiceCuenta serviceCuenta = new ServiceCuenta();

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Listar todas las cuentas de ahorro");
            System.out.println("2. Listar todas las cuentas de corriente");
            System.out.println("3. Crear cuenta de ahorro");
            System.out.println("4. Crear cuenta de corriente");
            System.out.println("5. Obtener información de una cuenta por número");
            System.out.print("Opción: ");
            int opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    System.out.println("\n Cuentas de ahorro:");
                    for (Cuenta c : serviceCuenta.obtenerCuentas()) {
                        if (c instanceof Ahorro) {
                            System.out.println(c);
                        }
                    }
                    break;

                case 2:
                    System.out.println("\n Cuentas de corriente:");
                    for (Cuenta c : serviceCuenta.obtenerCuentas()) {
                        if (c instanceof Corriente) {
                            System.out.println(c);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Número de cuenta: ");
                    String numA = sc.nextLine();
                    System.out.print("DNI cliente: ");
                    long dniA = sc.nextLong();
                    System.out.print("Saldo inicial: ");
                    double saldoA = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Fecha de creación: ");
                    String fecha = sc.nextLine();
                    serviceCuenta.crearCuenta(new Ahorro(numA, dniA, saldoA, fecha));
                    System.out.println("Cuenta de ahorro creada.");
                    break;

                case 4:
                    System.out.print("Número de cuenta: ");
                    String numC = sc.nextLine();
                    System.out.print("DNI cliente: ");
                    long dniC = sc.nextLong();
                    System.out.print("Saldo inicial: ");
                    double saldoC = sc.nextDouble();
                    System.out.print("Impuesto: ");
                    double imp = sc.nextDouble();
                    serviceCuenta.crearCuenta(new Corriente(numC, dniC, saldoC, imp));
                    System.out.println("Cuenta de corriente creada.");
                    break;

                case 5:
                    System.out.print("Ingrese el número de cuenta: ");
                    String buscar = sc.nextLine();
                    Cuenta encontrada = serviceCuenta.obtenernumeroCuenta(buscar);
                    System.out.println(encontrada != null ? encontrada : "Cuenta no encontrada.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }
        sc.close();
    }
}