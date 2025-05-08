package A6EscrituraLectura;


import A6EscrituraLectura.ReservaVer;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Reserva {
    
    public static String pelicula_nombre;
    public static String numSalas;
    public static String hora_pel;
    public static String dia_pel;

    public static String[] realizarreserva() {
        Scanner scann = new Scanner(System.in);
        String pelicula_nombre = "";
        String numSalas = "";
        String hora_pel = "";
        String dia_pel = "";
        String filaString = "";
        String columnaString = "";
        boolean peliculaEncontrada = false;
        boolean asientoValido = false;
    
        // Selección de película
        while (!peliculaEncontrada) {
            System.out.print("Dime la película que quieres reservar: ");
            pelicula_nombre = scann.nextLine();
    
            try (BufferedReader reader = new BufferedReader(new FileReader("A0Ficheros/Cartelera.txt"))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    String[] partes = linea.split(";");
                    if (partes[0].equalsIgnoreCase(pelicula_nombre)) {
                        System.out.println("-----------------------------------------------------");
                        System.out.println("NOMBRE PELICULA: " + partes[0]);
                        System.out.println("NUMERO SALA: " + partes[1]);
                        System.out.println("DÍA DE PROYECCIÓN: " + partes[2]);
                        System.out.println("HORA DE PROYECCIÓN: " + partes[3]);
                        numSalas = partes[1];
                        hora_pel = partes[2];
                        dia_pel = partes[3];
                        peliculaEncontrada = true;
                        break;
                    }
                }
    
                if (!peliculaEncontrada) {
                    System.out.println("Película no encontrada. Inténtalo de nuevo.");
                }
            } catch (IOException e) {
                System.out.println("Error al leer el archivo Cartelera.txt");
                e.printStackTrace();
                return null;
            }
        }
    
        System.out.println("-----------------------------------------------------");
    
        // Bucle para selección de asiento
        while (!asientoValido) {
            // Mostrar sala
            System.out.println("Dime qué asiento quieres reservar (0-Ocupado / 1-Libre / 2-Reservado / 3-Minusválido): ");
            System.out.println("--------------");
            System.out.println(" _________        ");
            System.out.println("|         |");
            System.out.println("| Screen  |");
            System.out.println("|_________|       ");
    
            // Leer y mostrar la sala
            List<String> lineasSala = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader("A7Salas/Sala_" + numSalas + ".txt"))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    System.out.println(linea);
                    lineasSala.add(linea);
                }
            } catch (IOException e) {
                System.out.println("Error al leer el archivo de la sala.");
                e.printStackTrace();
                return null;
            }
    
            System.out.println("--------------");
    
            // Validación de fila y columna
            int fila = -1;
            int columna = -1;
            boolean entradaValida = false;
    
            while (!entradaValida) {
                try {
                    System.out.println("Fila (1-" + lineasSala.size() + "): ");
                    fila = scann.nextInt();
                    if (fila < 1 || fila > lineasSala.size()) {
                        System.out.println("Fila inválida. Debe estar entre 1 y " + lineasSala.size());
                        continue;
                    }
    
                    String[] asientosFila = lineasSala.get(fila - 1).split(" ");
                    System.out.println("Columna (1-" + asientosFila.length + "): ");
                    columna = scann.nextInt();
                    if (columna < 1 || columna > asientosFila.length) {
                        System.out.println("Columna inválida. Debe estar entre 1 y " + asientosFila.length);
                        continue;
                    }
    
                    entradaValida = true;
                } catch (Exception e) {
                    System.out.println("Por favor, introduce un número válido.");
                    scann.nextLine(); // Limpiar buffer
                }
            }
            scann.nextLine(); // Limpiar buffer
    
            // Verificar disponibilidad del asiento
            String[] asientosFila = lineasSala.get(fila - 1).split(" ");
            if (asientosFila[columna - 1].equals("0")) {
                System.out.println("Este asiento ya está ocupado. Por favor, elija otro.");
                continue;
            }
    
            // Confirmar reserva
            System.out.println("¿Confirmar reserva del asiento Fila " + fila + ", Columna " + columna + "? (S/N)");
            String confirmacion = scann.nextLine();
    
            if (confirmacion.equalsIgnoreCase("S")) {
                // Actualizar estado del asiento
                asientosFila[columna - 1] = "0";
                lineasSala.set(fila - 1, String.join(" ", asientosFila));
    
                // Escribir los cambios en el archivo
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("A7Salas/Sala_" + numSalas + ".txt"))) {
                    for (String linea : lineasSala) {
                        writer.write(linea);
                        writer.newLine();
                    }
                    System.out.println("Reserva realizada con éxito!");
                    asientoValido = true;
                    filaString = Integer.toString(fila);
                    columnaString = Integer.toString(columna);
                } catch (IOException e) {
                    System.out.println("Error al guardar la reserva.");
                    e.printStackTrace();
                    return null;
                }
            } else {
                System.out.println("Reserva cancelada. Puede elegir otro asiento.");
            }
        }
    
        return new String[]{pelicula_nombre, numSalas, hora_pel, dia_pel, filaString, columnaString};
    }
            
        
}
