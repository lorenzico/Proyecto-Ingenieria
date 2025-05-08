
package A6EscrituraLectura;

import A2Identidad.Login;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class InfoUser {
    
    public static void main(String[] args) {

        String email = Login.email;


        try (BufferedReader reader = new BufferedReader(new FileReader("A8Usuarios/" + email ))) {
            String linea;
            int numeroLinea = 0;

            while ((linea = reader.readLine()) != null && numeroLinea == 0) {
                numeroLinea ++;

                String[] partes = linea.split(";");

                        System.out.println( "Género: " + partes[0]);

                        System.out.println( "Edad: " + partes[1]);

                        System.out.println( "Método de pago: " + partes[2]);

                        System.out.println( "Situación: " + partes[3]);


                System.out.println("-----------------------------------------------------");

            }

            
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
            e.printStackTrace();
        }
    }
}