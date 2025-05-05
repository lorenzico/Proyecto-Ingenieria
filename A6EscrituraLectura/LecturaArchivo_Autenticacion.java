package A6EscrituraLectura;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class LecturaArchivo_Autenticacion {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Lista de Usuarios Registrados");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        try (BufferedReader reader = new BufferedReader(new FileReader("A0Ficheros/Autenticacion.txt"))) {
            String linea;
            int count = 1;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(";");
                textArea.append("USUARIO " + count + "\n");
                textArea.append("Email: " + (partes.length > 0 ? partes[0] : "") + "\n");
                textArea.append("----------------------------------------\n");
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