package A1Menu;
import java.util.Scanner;

public class Menu_Identificacion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n=== MENÚ DE IDENTIFICACIÓN ===");
            System.out.println("1. Iniciar sesión (Login)");
            System.out.println("2. Registrarse");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            switch (opcion) {
                case 1:
                    A2Identidad.Login.main(args);
                    break;
                case 2:
                A2Identidad.Registro.main(args);
                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
}