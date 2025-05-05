package A6EscrituraLectura;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LecturaArchivo_Cartelera {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("A0Ficheros/Cartelera.txt"))) {
            String linea;
            int numeroLinea = 0;

            while ((linea = reader.readLine()) != null) {
                numeroLinea ++;

                String[] partes = linea.split(";");


                for (int i = 0; i < partes.length; i++){
                    
                    if (i == 0) {
                        System.out.println("-----------------------------------------------------");

                        System.out.println("PELICULA: " + numeroLinea);
                        System.out.println( "NOMBRE PELICULA: " + partes[0]);
                        System.out.println( "NUMERO SALA: " + partes[1]);
                        System.out.println( "DÍA DE PROYECCIÓN: " + partes[2]);
                        System.out.println( "HORA DE PROYECCIÓN: " + partes[3]);
                        System.out.println( "FECHA DE LANZAMIENTO: " + partes[4]);
                        System.out.println( "DIRECTOR: " + partes[5]);

                        System.out.println( "RECAUDACIÓN: " + partes[6]);

                        System.out.println( "SINOPSIS: " + partes[7]);
                    }

                }




            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
            e.printStackTrace();
        }

        System.out.println("-----------------------------------------------------");

    }
}