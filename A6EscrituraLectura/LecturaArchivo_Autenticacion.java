package A6EscrituraLectura;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LecturaArchivo_Autenticacion {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("A0Ficheros/Autenticacion.txt"))) {
            String linea;
            int numeroLinea = 0;

            while ((linea = reader.readLine()) != null) {
                numeroLinea ++;

                String[] partes = linea.split(";");


                for (int i = 0; i < partes.length; i++){
                    
                    if (i == 0) {
                        System.out.println("USUARIO: " + numeroLinea);
                        System.out.println( "EMAIL: " + partes[0]);
                    } else if ( i == 1) {
                        System.out.println( "CCONTRASEÑA: " + partes[1]);
                    } 

                }

                System.out.println("-----------------------------------------------------");

            }

            
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
            e.printStackTrace();
        }
    }
}