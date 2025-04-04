package A2Identidad;
import java.util.Scanner;

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
        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();
        
        // Aquí iría la lógica para guardar el usuario
        System.out.println("\nRegistro exitoso (simulado)");
        System.out.println("Bienvenido " + nombre + ", tu cuenta de usuario normal ha sido creada.");
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
        
        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();
        
        System.out.println("\nRegistro exitoso (simulado)");
        System.out.println("Bienvenido " + nombre + ", tu cuenta de dependiente ha sido creada.");
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
        
        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();
        
        System.out.println("\nRegistro exitoso (simulado)");
        System.out.println("Bienvenido " + nombre + ", tu cuenta de administrador ha sido creada.");
    }
}
