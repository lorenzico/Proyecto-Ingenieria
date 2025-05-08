package A3Menu_Usuario;

import java.util.Scanner;

public class Menu_Usuario {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MENÚ DEL USUARIO ===");
            System.out.println("1. Reserva de Entradas");
            System.out.println("2. Consulta de Cartelera");
            System.out.println("3. Pefil Usuario");
            System.out.println("4. Descarga Métricas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    A6EscrituraLectura.ReservaVer.main(null);
                break;
                case 2:
                    A6EscrituraLectura.LecturaArchivo_Cartelera.main(null); 
                    break;

                case 3:

                    System.out.println("Quieres mirar la información 1-Personal o 2-Reservas: ");
                    int resp = scanner.nextInt();
                    if (resp == 1 ){
                        A6EscrituraLectura.InfoUser.main(null); 
                    } else {
                        A6EscrituraLectura.ReservaVer2.main(null);
                    }

                break;   

                case 4:
                    System.out.println("¿Que metricas quieres descargas? 1-Salas/2-Cartelera/3-SalasParaDiscpacitados: ");

                    int resp2 = scanner.nextInt();
                    if (resp2 == 1 ){
                        A6EscrituraLectura.Metricas1.main(null); 
                    } else if(resp2 == 2) {
                        A6EscrituraLectura.Metricas2.main(null);
                    } else {
                        A6EscrituraLectura.Metrica3.main(null);
                    }

                break;          

                case 5:
                    System.out.println("Saliendo del sistema...");
                    A1Menu.Menu_Identificacion.main(null);
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
}
