package A6EscrituraLectura;

import java.io.IOException;
import java.nio.file.*;

public class Metricas1 {
    public static void main(String[] args) {
        Path origenDir = Paths.get("A7Salas");
        Path destinoDir = Paths.get("A9Descargas");

        try {
            // 1. Verificar si existe y es un archivo (no directorio)
            if (Files.exists(destinoDir) && !Files.isDirectory(destinoDir)) {
                System.err.println("ERROR: Ya existe un ARCHIVO con ese nombre. Borrando...");
                Files.delete(destinoDir); // Elimina el archivo conflictivo
            }

            // 2. Crear directorio (con verificación adicional)
            if (!Files.exists(destinoDir)) {
                Files.createDirectories(destinoDir);
                System.out.println("Directorio creado: " + destinoDir);
            }

            // 3. Copiar archivos
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(origenDir, "Sala_*.txt")) {
                for (Path archivo : stream) {
                    Path destino = destinoDir.resolve(archivo.getFileName());
                    Files.copy(archivo, destino, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Copiado: " + archivo.getFileName());
                }
            }
            System.out.println("Proceso completado con éxito");

        } catch (IOException e) {
            System.err.println("Error crítico:");
            e.printStackTrace();
            
            // Sugerencias específicas para el usuario
            if (e instanceof FileAlreadyExistsException) {
                System.err.println("\nSOLUCIÓN: Borra manualmente el archivo 'A9Descargas'"
                    + " o cambia la ruta de destino");
            }
        }
    }
}