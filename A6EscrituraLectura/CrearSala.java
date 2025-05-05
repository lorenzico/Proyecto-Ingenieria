package A6EscrituraLectura;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CrearSala {
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Dime el número de la sala: ");
        int num_sala = scanner.nextInt();
        String limp1 = scanner.nextLine();

        System.out.println("Dime cuántas filas y columnas tiene la sala:");
        System.out.println("Fila: ");
        int num_filas = scanner.nextInt();
        String limp5 = scanner.nextLine();

        System.out.println("Columna: ");
        int num_colum = scanner.nextInt();
        String limp2 = scanner.nextLine();

        int[][] sala_array = new int[num_filas][num_colum];

        for (int i = 0; i < num_filas; i++) {
            for (int j = 0; j < num_colum; j++) {
                sala_array[i][j] = 1;
            }
        }

        while (true) {
            System.out.println("¿Hay algún asiento que no esté disponible? SI/NO: ");
            String disp_asiento = scanner.nextLine();
            
            switch (disp_asiento) {
                case "Si":
                case "SI":
                case "si":
                    
                    System.out.println("Dime la localización que no está disponible: ");

                    System.out.println("Fila: ");
                    int camb_filas = scanner.nextInt();
                    String limp3 = scanner.nextLine();

                    System.out.println("Columna: ");
                    int camb_colum = scanner.nextInt();
                    String limp4 = scanner.nextLine();

                    if (camb_filas >= 0 && camb_filas < num_filas && camb_colum >= 0 && camb_colum < num_colum) {
                        sala_array[camb_filas][camb_colum] = 0;
                    } else {
                        System.out.println("Posición inválida. Inténtalo de nuevo.");
                    }

                    break;
                    
                case "No":
                case "NO":
                case "no":
                    // Guardar la sala en archivo
                    try {
                        PrintWriter pw = new PrintWriter(new FileWriter("A7Salas/Sala_" + num_sala + ".txt"));
                        for (int i = 0; i < sala_array.length; i++) {
                            for (int j = 0; j < sala_array[i].length; j++) {
                                pw.print(sala_array[i][j] + " ");
                            }
                            pw.println();
                        }
                        pw.close();
                        System.out.println("Sala guardada exitosamente.");
                    } catch (IOException e) {
                        System.out.println("Error al guardar la sala: " + e.getMessage());
                    }

                    A5Menu_Admin.Menu_Admin.main(args); // Ir al menú
                     // salir del programa después de guardar

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }

            // Mostrar el estado actual de la sala
            for (int i = 0; i < sala_array.length; i++) {
                for (int j = 0; j < sala_array[i].length; j++) {
                    System.out.print(sala_array[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
