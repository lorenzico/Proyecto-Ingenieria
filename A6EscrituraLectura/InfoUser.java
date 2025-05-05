package A6EscrituraLectura;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class InfoUser {
    public static void main(String[] args) {
        String email = A2Identidad.Login.email;
        
        JFrame frame = new JFrame("Información de Usuario");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel mainPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        try (BufferedReader reader = new BufferedReader(new FileReader("A8Usuarios/" + email))) {
            String linea = reader.readLine();
            if (linea != null) {
                String[] partes = linea.split(";");
                
                addInfoRow(mainPanel, "Género:", partes.length > 0 ? partes[0] : "");
                addInfoRow(mainPanel, "Edad:", partes.length > 1 ? partes[1] : "");
                addInfoRow(mainPanel, "Método de pago:", partes.length > 2 ? partes[2] : "");
                addInfoRow(mainPanel, "Situación:", partes.length > 3 ? partes[3] : "");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error al leer información del usuario", 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        frame.add(mainPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private static void addInfoRow(JPanel panel, String label, String value) {
        panel.add(new JLabel(label));
        panel.add(new JLabel(value));
    }
}