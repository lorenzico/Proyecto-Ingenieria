package A4Menu_Dependiente;
import java.util.Scanner;

public class Menu_Dependiente {
    

    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
    
            while (true) {
                System.out.println("\n=== MENÚ DEL DEPENDIENTE ===");
                System.out.println("1. Reserva de Entradas");
                System.out.println("2. Consulta de Cartelera");
                System.out.print("Seleccione una opción: ");
    
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
    
                switch (opcion) {
                    case 1:
                        A2Identidad.Login.main(null);
                        break;
                    case 2:
                        A6EscrituraLectura.LecturaArchivo_Cartelera.main(null); 
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
