package A2Identidad;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n=== INICIO DE SESIÓN ===");
        System.out.print("Ingrese su email: ");
        String email = scanner.nextLine();
        
        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();
        
        // Aquí iría la lógica para verificar las credenciales
        System.out.println("\nInicio de sesión exitoso (simulado)");

    }
}