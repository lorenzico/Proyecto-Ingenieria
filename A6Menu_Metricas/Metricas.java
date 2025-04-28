
package A4Metricas;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Metricas {

    private static final String METRICAS_PATH = "Proyecto-Ingenieria-main/Métricas/";

    public static void descargarCartelera() {
        try {
            File file = new File(METRICAS_PATH + "cartelera.txt");
            FileWriter writer = new FileWriter(file);
            writer.write("Película: Matrix Resurrections\nFecha: 2025-04-20\n\n");
            writer.write("Película: Dune 2\nFecha: 2025-04-13\n\n");
            writer.write("Película: Godzilla x Kong\nFecha: 2025-04-06\n\n");
            writer.close();
            System.out.println("Cartelera descargada correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar la cartelera: " + e.getMessage());
        }
    }

    public static void descargarSalas() {
        try {
            File file = new File(METRICAS_PATH + "salas.txt");
            FileWriter writer = new FileWriter(file);
            writer.write("Sala 1 - 100 asientos\n");
            writer.write("Sala 2 - 80 asientos\n");
            writer.write("Sala 3 - 120 asientos\n");
            writer.close();
            System.out.println("Información de salas descargada correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar las salas: " + e.getMessage());
        }
    }

    public static void descargarSalasAdaptadas() {
        try {
            File file = new File(METRICAS_PATH + "salas_adaptadas.txt");
            FileWriter writer = new FileWriter(file);
            writer.write("Sala 2 - Adaptada para movilidad reducida\n");
            writer.write("Sala 3 - Adaptada para movilidad reducida\n");
            writer.close();
            System.out.println("Salas adaptadas descargadas correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar las salas adaptadas: " + e.getMessage());
        }
    }
}
