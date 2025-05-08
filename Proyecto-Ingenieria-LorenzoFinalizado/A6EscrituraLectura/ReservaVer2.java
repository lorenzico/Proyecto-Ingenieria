package A6EscrituraLectura;

import A2Identidad.Login;

import A6EscrituraLectura.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReservaVer2 {
    
    public static void main(String[] args) {

        String email = Login.email;


        try (BufferedReader reader = new BufferedReader(new FileReader("A8Usuarios/" + email ))) {
            String linea;
            int numeroLinea = 0;

            while ((linea = reader.readLine()) != null ) {
                numeroLinea ++;


                if (numeroLinea == 1 ){

                } else {

                        String[] partes = linea.split(";");

                        System.out.println( "Pelicula: " + partes[0]);

                        System.out.println( "Numero de la Sala: " + partes[1]);

                        System.out.println( "Día: " + partes[2]);

                        System.out.println( "Hora: " + partes[3]);

                        System.out.println( "Fila " + partes[4]);

                        System.out.println( "Columna: " + partes[5]);

                        System.out.println("-----------------------------------------------------");

                    }


            }

            
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
            e.printStackTrace();
        }
    }
}
