package A2Identidad;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== INICIO DE SESIÓN ===");
        System.out.print("Quieres Iniciar Sesión como: \n Usuario (1): \n Dependiente(2): \n Administrador (3): ");
        int numero = scanner.nextInt();

        String salto = scanner.nextLine();

        System.out.print("Ingrese su email: ");
        String email = scanner.nextLine();

        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();

        if (verificarCredenciales(email, contrasena)) {
            System.out.println("\n Inicio de sesión exitoso.");
            if (numero == 1) {
                A3Menu_Usuario.Menu_Usuario.main(args);
            } else if (numero == 2) {
                A4Menu_Dependiente.Menu_Dependiente.main(null);
            } else {
                A5Menu_Admin.Menu_Admin.main(null);
            }

        
        } else {
            System.out.println("\n Credenciales incorrectas o usuario no registrado.");
        }
    }

    

    private static boolean verificarCredenciales(String email, String contrasena) {
        String archivo = "A0Ficheros/Autenticacion.txt"; // Ruta relativa al archivo
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length >= 2 && partes[0].equals(email) && partes[1].equals(contrasena)) {
                    return true;


                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return false;
    }
}