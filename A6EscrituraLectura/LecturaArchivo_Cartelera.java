package A6EscrituraLectura;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class LecturaArchivo_Cartelera {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Cartelera Actual");
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        try (BufferedReader reader = new BufferedReader(new FileReader("A0Ficheros/Cartelera.txt"))) {
            String linea;
            int count = 1;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(";");
                textArea.append("----------------------------------------\n");
                textArea.append("PELÍCULA " + count + "\n");
                textArea.append("Nombre: " + (partes.length > 0 ? partes[0] : "") + "\n");
                textArea.append("Sala: " + (partes.length > 1 ? partes[1] : "") + "\n");
                textArea.append("Día: " + (partes.length > 2 ? partes[2] : "") + "\n");
                textArea.append("Hora: " + (partes.length > 3 ? partes[3] : "") + "\n");
                textArea.append("Año: " + (partes.length > 4 ? partes[4] : "") + "\n");
                textArea.append("Director: " + (partes.length > 5 ? partes[5] : "") + "\n");
                textArea.append("Recaudación: " + (partes.length > 6 ? partes[6] : "") + "\n");
                textArea.append("Sinopsis: " + (partes.length > 7 ? partes[7] : "") + "\n");
                count++;
            }
        } catch (IOException e) {
            textArea.append("Error al leer el archivo: " + e.getMessage());
        }
        
        frame.add(scrollPane);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}