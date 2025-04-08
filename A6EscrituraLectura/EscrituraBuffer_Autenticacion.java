package A6EscrituraLectura;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EscrituraBuffer_Autenticacion{
    public static void escrituraAutenticacion() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n=== Email ===");
        System.out.print("Ingresa el Email: ");
        String email_user = scanner.nextLine();


        System.out.println("\n=== Contraseña ===");
        System.out.print("Ingresa la contraseña: ");
        String contraseña_user = scanner.nextLine();


        try (BufferedWriter writer = new BufferedWriter(new FileWriter("A0Ficheros/Autenticacion.txt", true))) {
            writer.write(email_user);
            writer.write(";");

            writer.write(contraseña_user);
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