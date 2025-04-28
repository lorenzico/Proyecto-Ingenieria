
package A4Metricas;

import java.util.Scanner;

public class MenuMetricas {

    public static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== MENÚ DE MÉTRICAS ===");
            System.out.println("1. Descargar cartelera");
            System.out.println("2. Descargar salas");
            System.out.println("3. Descargar salas adaptadas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Metricas.descargarCartelera();
                    break;
                case 2:
                    Metricas.descargarSalas();
                    break;
                case 3:
                    Metricas.descargarSalasAdaptadas();
                    break;
                case 0:
                    System.out.println("Saliendo del menú de métricas...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 0);
    }
}
