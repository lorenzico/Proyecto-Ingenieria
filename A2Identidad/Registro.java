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

        EscrituraBuffer_Autenticacion objetoA = new EscrituraBuffer_Autenticacion();
        objetoA.escrituraAutenticacion();

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

        
        EscrituraBuffer_Autenticacion objetoA = new EscrituraBuffer_Autenticacion();
        objetoA.escrituraAutenticacion();
        
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
        
        
        EscrituraBuffer_Autenticacion objetoA = new EscrituraBuffer_Autenticacion();
        objetoA.escrituraAutenticacion();
        
        System.out.println("\nRegistro exitoso (simulado)");
    }
}
