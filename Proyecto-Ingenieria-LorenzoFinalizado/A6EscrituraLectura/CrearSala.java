package A6EscrituraLectura;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CrearSala {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Configuración inicial de la sala
        System.out.println("Dime el número de la sala: ");
        int num_sala = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        System.out.println("Dime cuántas filas y columnas tiene la sala:");
        System.out.println("Fila: ");
        int num_filas = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Columna: ");
        int num_colum = scanner.nextInt();
        scanner.nextLine();

        int[][] sala_array = new int[num_filas][num_colum];

        // Inicializar todos los asientos como disponibles (1)
        for (int i = 0; i < num_filas; i++) {
            for (int j = 0; j < num_colum; j++) {
                sala_array[i][j] = 1;
            }
        }

        // Proceso para marcar asientos no disponibles
        boolean continuar = true;
        while (continuar) {
            System.out.println("¿Hay algún asiento que no esté disponible? (SI/NO): ");
            String disp_asiento = scanner.nextLine().toUpperCase();

            switch (disp_asiento) {
                case "SI":
                    boolean otroAsiento = true;
                    while (otroAsiento) {
                        mostrarSala(sala_array);
                        
                        System.out.println("Dime la localización que no está disponible: ");
                        int camb_filas = obtenerEntero("Fila (0-" + (num_filas-1) + "): ", 0, num_filas-1, scanner);
                        int camb_colum = obtenerEntero("Columna (0-" + (num_colum-1) + "): ", 0, num_colum-1, scanner);

                        if (sala_array[camb_filas][camb_colum] == 0) {
                            System.out.println("Este asiento ya está marcado como no disponible.");
                        } else {
                            sala_array[camb_filas][camb_colum] = 0;
                            System.out.println("Asiento marcado como no disponible.");
                        }

                        System.out.println("¿Hay más asientos no disponibles? (SI/NO): ");
                        otroAsiento = scanner.nextLine().toUpperCase().equals("SI");
                    }
                    break;
                    
                case "NO":
                    continuar = false;
                    break;
                    
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }

        // Proceso para marcar asientos para minusválidos
        continuar = true;
        while (continuar) {
            System.out.println("¿Hay algún asiento para minusválidos? (SI/NO): ");
            String disps_asiento = scanner.nextLine().toUpperCase();
            
            switch (disps_asiento) {
                case "SI":
                    boolean otroAsiento = true;
                    while (otroAsiento) {
                        mostrarSala(sala_array);
                        
                        System.out.println("Dime la localización del asiento para minusválidos: ");
                        int camb_filas = obtenerEntero("Fila (0-" + (num_filas-1) + "): ", 0, num_filas-1, scanner);
                        int camb_colum = obtenerEntero("Columna (0-" + (num_colum-1) + "): ", 0, num_colum-1, scanner);

                        if (sala_array[camb_filas][camb_colum] == 3) {
                            System.out.println("Este asiento ya está marcado para minusválidos.");
                        } else {
                            sala_array[camb_filas][camb_colum] = 3;
                            System.out.println("Asiento marcado para minusválidos.");
                        }

                        System.out.println("¿Hay más asientos para minusválidos? (SI/NO): ");
                        otroAsiento = scanner.nextLine().toUpperCase().equals("SI");
                    }
                    break;
                    
                case "NO":
                    continuar = false;
                    break;
                    
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }

        // Guardar la sala en archivo
        guardarSala(num_sala, sala_array);
        
        // Volver al menú
        A5Menu_Admin.Menu_Admin.main(null);
    }

    // Método auxiliar para mostrar la sala
    private static void mostrarSala(int[][] sala) {
        System.out.println("\nEstado actual de la sala:");
        for (int[] fila : sala) {
            for (int asiento : fila) {
                System.out.print(asiento + " ");
            }
            System.out.println();
        }
    }

    // Método auxiliar para obtener un número entero válido
    private static int obtenerEntero(String mensaje, int min, int max, Scanner scanner) {
        while (true) {
            try {
                System.out.print(mensaje);
                int valor = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                if (valor >= min && valor <= max) {
                    return valor;
                }
                System.out.println("Error: El valor debe estar entre " + min + " y " + max);
            } catch (Exception e) {
                System.out.println("Error: Debe ingresar un número válido.");
                scanner.nextLine(); // Limpiar buffer
            }
        }
    }

    // Método auxiliar para guardar la sala
    private static void guardarSala(int num_sala, int[][] sala) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("A7Salas/Sala_" + num_sala + ".txt"))) {
            for (int[] fila : sala) {
                for (int asiento : fila) {
                    pw.print(asiento + " ");
                }
                pw.println();
            }
            System.out.println("Sala guardada exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar la sala: " + e.getMessage());
        }
    }
}