package A5Menu_Admin;
import java.util.Scanner;

public class Menu_Admin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MENÚ DEL ADMINISTRADOR ===");
            System.out.println("1. Actualización Cartelera");
            System.out.println("2. Baneo Cliente");
            System.out.println("3. Creación Salas");
            System.out.println("4. Salir");

            System.out.print("Seleccione una opción: ");


            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {

                case 1:
                    A6EscrituraLectura.EscrituraBuffer_Cartelera.main(null);
                    break;

                case 2:
                    A6EscrituraLectura.BaneoUsuarios.main(null); 
                    break;

                case 3:
                    A6EscrituraLectura.CrearSala.main(null); 
                break;

                case 4:
                    A1Menu.Menu_Identificacion.main(null);
                break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
        


        
    }
}
