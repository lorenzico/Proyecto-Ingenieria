package A6EscrituraLectura;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EscrituraBuffer_Cartelera {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== Deseas eliminar toda la cartelera actual ===");
        System.out.print("Si / No: ");
        String limpiar = scanner.nextLine();


        if (limpiar.equalsIgnoreCase("Si")) {
            try (FileWriter fw = new FileWriter("A0Ficheros/Cartelera.txt", false)) {
                fw.write(""); // Limpia el archivo
                System.out.println(" Cartelera borrada. Comienza una nueva.");
            } catch (IOException e) {
                System.err.println("nError al limpiar el archivo: " + e.getMessage());
            }
        }

        
        System.out.println("\n=== Nombre Película ===");
        System.out.print("Ingresa el nombre: ");
        String nombre_pelicula = scanner.nextLine();


        System.out.println("\n=== Año de Salida ===");
        System.out.print("Ingrese el año que salió: ");
        String año_pelicula = scanner.nextLine();


        System.out.println("\n=== Sinopsis ===");
        System.out.print("Ingresa la sinopsis de la pelicula: ");
        String sinopsis_pelicula = scanner.nextLine();


        System.out.println("\n=== Cantiad de Recaudación ===");
        System.out.print("Ingresa la recaudación que ha hecho: ");
        String recaudacion_pelicula = scanner.nextLine();


        System.out.println("\n=== Director ===");
        System.out.print("Ingresa el director: ");
        String director_pelicula = scanner.nextLine();

        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("A0Ficheros/Cartelera.txt", true))) {
            writer.write(nombre_pelicula);
            writer.write(";");

            writer.write(año_pelicula);
            writer.write(";");
            
            writer.write(director_pelicula);
            writer.write(";");
            
            writer.write(recaudacion_pelicula);
            writer.write(";");
            
            writer.write(sinopsis_pelicula);
            writer.write(";");
            
            writer.newLine(); // Nueva línea

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

