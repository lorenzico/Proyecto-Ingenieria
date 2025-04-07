package A5Menu_Admin;

import java.util.*;
public class Menu_Admin {

    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, Boolean> usuarios = new HashMap<>();
    private static boolean loggedIn = false;

    public static void main(String[] args) {
        iniciarUsuarios();
        mostrarLogin();
    }

    private static void iniciarUsuarios() {
        usuarios.put("cliente1", true);
        usuarios.put("cliente2", true);
        usuarios.put("cliente3", true);
    }

    private static void mostrarLogin() {
        System.out.println("=== Login del Sistema ===");
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();  // No se valida realmente por simplicidad

        if (usuario.equals("admin") && contrasena.equals("admin123")) {
            loggedIn = true;
            System.out.println("Inicio de sesión exitoso.");
            mostrarMenuSistema();
        } else {
            System.out.println("Credenciales incorrectas.");
        }
    }

    private static void mostrarMenuSistema() {
        while (loggedIn) {
            System.out.println("\n=== Sistema del Administrador ===");
            System.out.println("1. Ver Perfil Cliente");
            System.out.println("2. Banear Usuario");
            System.out.println("3. Actualizar Cartelera y Proyecciones");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> verPerfilCliente();
                case 2 -> banearUsuario();
                case 3 -> actualizarCartelera();
                case 4 -> {
                    loggedIn = false;
                    System.out.println("Sesión finalizada.");
                }
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private static void verPerfilCliente() {
        System.out.println("=== Perfiles de Clientes ===");
        for (Map.Entry<String, Boolean> entry : usuarios.entrySet()) {
            System.out.println("Usuario: " + entry.getKey() + " | Activo: " + entry.getValue());
        }
    }

    private static void banearUsuario() {
        System.out.print("Ingrese el nombre del usuario a banear: ");
        String nombre = scanner.nextLine();
        if (usuarios.containsKey(nombre)) {
            usuarios.put(nombre, false);
            System.out.println("Usuario " + nombre + " ha sido baneado.");
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    private static void actualizarCartelera() {
        System.out.println("Actualización de cartelera y proyecciones...");
        System.out.print("Ingrese la nueva película: ");
        String pelicula = scanner.nextLine();
        System.out.print("Ingrese hora de proyección: ");
        String hora = scanner.nextLine();
        System.out.print("Ingrese día de proyección: ");
        String dia = scanner.nextLine();

        System.out.println("Película: " + pelicula + " | Hora: " + hora + " | Día: " + dia);
        System.out.println("Cartelera actualizada correctamente.");
    }
}
