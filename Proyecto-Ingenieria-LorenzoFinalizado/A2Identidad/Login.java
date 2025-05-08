package A2Identidad;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Login {

    public static String email;

    public static String main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== INICIO DE SESIÓN ===");
        System.out.print("Quieres Iniciar Sesión como: \n Usuario (1): \n Dependiente(2): \n Administrador (3): ");
        int numero = scanner.nextInt();

        String salto = scanner.nextLine();

        String contrasena ;

        if (numero >= 1 && numero <= 3) {
            switch (numero) {
                case 1:
                System.out.print("Ingrese su email: ");
                email = scanner.nextLine();
       
               System.out.print("Ingrese su contraseña: ");
                contrasena = scanner.nextLine();


                    verificarCredenciales(email, contrasena);
                    break;
                case 2:
                System.out.print("Ingrese su email: ");
                email = scanner.nextLine();
       
               System.out.print("Ingrese su contraseña: ");
                contrasena = scanner.nextLine();



                    verificarCredenciales2(email, contrasena);
                    break;
                case 3:

                System.out.print("Ingrese su email: ");
                email = scanner.nextLine();
       
               System.out.print("Ingrese su contraseña: ");
                contrasena = scanner.nextLine();
                    verificarCredenciales3(email, contrasena);
                    break;
            }
        } else {
            System.out.println("\nHas introducido un valor inválido. Por favor, introduce un número entre 1 y 3.");
            // Volver a mostrar el menú de login sin reiniciar el programa
            A2Identidad.Login.main(null);
        }

        return email;
    }

    

    private static String verificarCredenciales(String email, String contrasena) {
        try (BufferedReader br = new BufferedReader(new FileReader("A0Ficheros/AutenticacionUser.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length >= 2 && partes[0].equals(email) && partes[1].equals(contrasena)) {
                    A3Menu_Usuario.Menu_Usuario.main(null);



                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return email;
    }





    private static String verificarCredenciales2(String email, String contrasena) {
        try (BufferedReader br = new BufferedReader(new FileReader("A0Ficheros/AutenticacionDependiente.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length >= 2 && partes[0].equals(email) && partes[1].equals(contrasena)) {
                A4Menu_Dependiente.Menu_Dependiente.main(null);


                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return email;
    }





    private static String verificarCredenciales3(String email, String contrasena) {
        try (BufferedReader br = new BufferedReader(new FileReader("A0Ficheros/AutenticacionAdmin.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length >= 2 && partes[0].equals(email) && partes[1].equals(contrasena)) {
                    A5Menu_Admin.Menu_Admin.main(null);


                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return email;
    }

}