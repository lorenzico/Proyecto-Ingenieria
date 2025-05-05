package A6EscrituraLectura;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Metrica3 {
    public static void main(String[] args) {
        int contador = 1; // Cambiado a 1 para que coincida con nombres de archivo típicos

        while (contador < 10) {
            String archivo = "A7Salas/Sala_" + contador + ".txt";
            File archivo2 = new File(archivo);
            if (archivo2.exists()){

            } else {
                break;
            }


            boolean sino = false;

        try (BufferedReader reader = new BufferedReader(new FileReader("A7Salas/Sala_" + contador + ".txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("A9Descargas/SalasDiscapacitados.txt", true))) {
            String linea;
            int numeroLinea = 0;


            while ((linea = reader.readLine()) != null) {
                numeroLinea++;

                String[] partes = linea.split(" ");

                for (int i = 0; i < partes.length; i++) {
                    if (partes[i].equals("3")) { // Cambiado == por .equals() para comparación de strings
                        sino = true;
                    }
                }

            }

            if (sino) { // Corregido: if (sino == true) → if (sino)
                writer.write("La sala " + contador + " SI está adaptada para Discapacitados");
                writer.newLine();
            } else {
                writer.write("La sala " + contador + " NO está adaptada para Discapacitados");
                writer.newLine();
            }
            
            contador ++;





        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
            e.printStackTrace();
        }
    }
    
    }
}