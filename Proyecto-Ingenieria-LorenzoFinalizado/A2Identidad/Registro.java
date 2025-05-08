package A2Identidad;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import A6EscrituraLectura.EscrituraBuffer_Autenticacion;

public class Registro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n=== REGISTRO DE USUARIO ===");
        System.out.println("Seleccione el tipo de usuario:");
        System.out.println("1. Usuario normal");
        System.out.println("2. Dependiente");
        System.out.println("3. Administrador");
        System.out.print("Opción: ");
        
        int tipoUsuario = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        
        switch (tipoUsuario) {
            case 1:
                registrarUsuarioNormal(scanner);
                break;
            case 2:
                registrarDependiente(scanner);
                break;
            case 3:
                registrarAdministrador(scanner);
                break;
            default:
                System.out.println("Opción no válida.");
        }

    }



    
    private static void registrarUsuarioNormal(Scanner scanner) {
        System.out.println("\nRegistro de usuario normal");

        
        System.out.println("\n=== Email ===");
        System.out.print("Ingresa el Email: ");
        String email_user = scanner.nextLine();


        System.out.println("\n=== Contraseña ===");
        System.out.print("Ingresa la contraseña: ");
        String contraseña_user = scanner.nextLine();




        try (BufferedReader reader = new BufferedReader(new FileReader("A0Ficheros/AutenticacionUser.txt"))) {
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


        try (BufferedWriter writer = new BufferedWriter(new FileWriter("A0Ficheros/AutenticacionUser.txt", true))) {
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
    




















        System.out.println("\nRegistro exitoso ");



    }


    
    private static void registrarDependiente(Scanner scanner) {
        System.out.println("\nRegistro de dependiente");
        System.out.print("Ingrese la contraseña de autorización: ");
        String contrasenaAuth = scanner.nextLine();
        
        // Contraseña de ejemplo para demostración
        if (!"lorenzodependiente".equals(contrasenaAuth)) {
            System.out.println("Contraseña de autorización incorrecta.");
            return;
        }



        System.out.println("\n=== Email ===");
        System.out.print("Ingresa el Email: ");
        String email_user = scanner.nextLine();


        System.out.println("\n=== Contraseña ===");
        System.out.print("Ingresa la contraseña: ");
        String contraseña_user = scanner.nextLine();




        try (BufferedReader reader = new BufferedReader(new FileReader("A0Ficheros/AutenticacionDependiente.txt"))) {
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


        try (BufferedWriter writer = new BufferedWriter(new FileWriter("A0Ficheros/AutenticacionDependiente.txt", true))) {
            writer.write(email_user);
            writer.write(";");

            writer.write(contraseña_user);
            writer.write(";");

            
            writer.newLine(); // Nueva línea

        } catch (IOException e) {
            e.printStackTrace();
        }















        
        System.out.println("\nRegistro exitoso (simulado)");
    }
    


    private static void registrarAdministrador(Scanner scanner) {
        System.out.println("\nRegistro de administrador");
        System.out.print("Ingrese la contraseña maestra: ");
        String contrasenaAuth = scanner.nextLine();
        
        // Contraseña de ejemplo para demostración
        if (!"arturoadmin".equals(contrasenaAuth)) {
            System.out.println("Contraseña maestra incorrecta.");
            return;
        }
        
        System.out.println("\n=== Email ===");
        System.out.print("Ingresa el Email: ");
        String email_user = scanner.nextLine();


        System.out.println("\n=== Contraseña ===");
        System.out.print("Ingresa la contraseña: ");
        String contraseña_user = scanner.nextLine();




        try (BufferedReader reader = new BufferedReader(new FileReader("A0Ficheros/AutenticacionAdmin.txt"))) {
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


        try (BufferedWriter writer = new BufferedWriter(new FileWriter("A0Ficheros/AutenticacionAdmin.txt", true))) {
            writer.write(email_user);
            writer.write(";");

            writer.write(contraseña_user);
            writer.write(";");

            
            writer.newLine(); // Nueva línea

        } catch (IOException e) {
            e.printStackTrace();
        }









        
        System.out.println("\nRegistro exitoso (simulado)");
    }
}
