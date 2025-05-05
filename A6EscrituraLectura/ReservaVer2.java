package A6EscrituraLectura;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ReservaVer2 {
    public static void main(String[] args) {
        String email = A2Identidad.Login.email;
        
        JFrame frame = new JFrame("Mis Reservas");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        try (BufferedReader reader = new BufferedReader(new FileReader("A8Usuarios/" + email))) {
            String linea;
            int count = 0;
            while ((linea = reader.readLine()) != null) {
                count++;
                if (count == 1) continue; // Saltar primera línea (info personal)
                
                String[] partes = linea.split(";");
                textArea.append("Película: " + (partes.length > 0 ? partes[0] : "") + "\n");
                textArea.append("Sala: " + (partes.length > 1 ? partes[1] : "") + "\n");
                textArea.append("Día: " + (partes.length > 2 ? partes[2] : "") + "\n");
                textArea.append("Hora: " + (partes.length > 3 ? partes[3] : "") + "\n");
                textArea.append("----------------------------------------\n");
            }
        } catch (IOException e) {
            textArea.append("Error al leer reservas: " + e.getMessage());
        }
        
        frame.add(scrollPane);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}