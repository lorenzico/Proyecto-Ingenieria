package A6EscrituraLectura;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import A2Identidad.*;


public class EscrituraBuffer_Autenticacion{
    public static void escrituraAutenticacion() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n=== Email ===");
        System.out.print("Ingresa el Email: ");
        String email_user = scanner.nextLine();


        System.out.println("\n=== Contraseña ===");
        System.out.print("Ingresa la contraseña: ");
        String contraseña_user = scanner.nextLine();


        try (BufferedReader reader = new BufferedReader(new FileReader("A0Ficheros/Autenticacion.txt"))) {
            String linea;
            int numeroLinea = 0;

            while ((linea = reader.readLine()) != null) {
                numeroLinea ++;

                String[] partes = linea.split(";");


                for (int i = 0; i < partes.length; i++){
                    
                    if (email_user.equals(partes[0])){
                        System.out.println("Ese usuario ya existe, prueba con otro.");
                        A2Identidad.Login.main(null);
                    }
                }

            }

            
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
            e.printStackTrace();
        }










        try (BufferedWriter writer = new BufferedWriter(new FileWriter("A0Ficheros/Autenticacion.txt", true))) {
            writer.write(email_user);
            writer.write(";");

            writer.write(contraseña_user);
            writer.write(";");

            
            writer.newLine(); // Nueva línea

        } catch (IOException e) {
            e.printStackTrace();
        }

        

        System.out.println("\n=== Información del Perfil ===");

        System.out.print("Genéro (M/F): ");
        String genero = scanner.nextLine();

        System.out.print("Dime tu edad: ");
        String edad = scanner.nextLine();

        System.out.print("Formato de pago: ");
        String pago = scanner.nextLine();

        System.out.print("Cual es tu situacion (Estudiante/Trabajador/Parado): ");
        String tippo = scanner.nextLine();


        try (BufferedWriter writer = new BufferedWriter(new FileWriter("A8Usuarios/" + email_user, true))) {
            writer.write(genero);
            writer.write(";");

            writer.write(edad);
            writer.write(";");

            writer.write(pago);
            writer.write(";");

            writer.write(tippo);
            writer.write(";");
            
            writer.newLine(); // Nueva línea

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}


/*
 * Cuando 
 */