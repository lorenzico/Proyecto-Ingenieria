package A6EscrituraLectura;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Metricas2 {
    
    public static void main(String[] args) {
        File origen = new File("A0Ficheros/Cartelera.txt");
        File destino = new File("A9Descargas/Cartelera.txt");

        try (InputStream in = new FileInputStream(origen);
             OutputStream out = new FileOutputStream(destino)) {
            
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            
            System.out.println("Archivo copiado exitosamente");
        } catch (IOException e) {
            System.err.println("Error al copiar el archivo:");
            e.printStackTrace();
        }


        File origenn = new File("A0Ficheros/Cartelera2.txt");
        File destinon = new File("A9Descargas/Cartelera2.txt");

        try (InputStream in = new FileInputStream(origenn);
             OutputStream out = new FileOutputStream(destinon)) {
            
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            
            System.out.println("Archivo copiado exitosamente");
        } catch (IOException e) {
            System.err.println("Error al copiar el archivo:");
            e.printStackTrace();
        }
    }
}
