package A6EscrituraLectura;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaneoUsuarios {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 1. Mostrar todos los usuarios
        System.out.println("\n=== LISTA DE USUARIOS ===");
        List<String> lineas = mostrarUsuarios("A0Ficheros/AutenticacionUser.txt");
        
        if (lineas.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }

        // 2. Pedir email a eliminar
        System.out.print("\n Ingresa el email / nombre del usuario a banear: ");
        String emailABanear = scanner.nextLine().trim();

        // 3. Eliminar la línea y guardar cambios
        eliminarUsuarioPorEmail("A0Ficheros/AutenticacionUser.txt", emailABanear, lineas);
    }

    // Muestra usuarios y devuelve todas las líneas
    private static List<String> mostrarUsuarios(String rutaArchivo) {
        List<String> lineas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            int numeroLinea = 0;
            while ((linea = reader.readLine()) != null) {
                lineas.add(linea);
                numeroLinea++;
                String[] partes = linea.split(";");
                if (partes.length > 0) {
                    System.out.println("USUARIO " + numeroLinea + ": " + partes[0]);
                }
                System.out.println("-----------------------------------------------------");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
            e.printStackTrace();
        }
        return lineas;
    }

    // Elimina un usuario por email
    private static void eliminarUsuarioPorEmail(String rutaArchivo, String emailABanear, List<String> lineas) {
        List<String> lineasActualizadas = new ArrayList<>();
        boolean encontrado = false;

        for (String linea : lineas) {
            String[] partes = linea.split(";");
            if (partes.length > 0 && !partes[0].equalsIgnoreCase(emailABanear)) {
                lineasActualizadas.add(linea);
            } else if (partes.length > 0 && partes[0].equalsIgnoreCase(emailABanear)) {
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println(" No se encontró el email / nombre: " + emailABanear);
            return;
        }

        // Reescribir el archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (String linea : lineasActualizadas) {
                writer.write(linea);
                writer.newLine();
            }
            System.out.println(" Usuario con email / nombre '" + emailABanear + "' eliminado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
            e.printStackTrace();
        }
    }
}