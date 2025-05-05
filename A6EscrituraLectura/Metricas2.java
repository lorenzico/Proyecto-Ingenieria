package A6EscrituraLectura;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Metricas2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Copiar Cartelera");
        frame.setSize(500, 150);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        JButton copyBtn = new JButton("Copiar Cartelera");
        copyBtn.addActionListener(e -> {
            try {
                copyFile("A0Ficheros/Cartelera.txt", "A9Descargas/Cartelera.txt");
                copyFile("A0Ficheros/Cartelera2.txt", "A9Descargas/Cartelera2.txt");
                JOptionPane.showMessageDialog(frame, "Archivos copiados exitosamente");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error al copiar: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        panel.add(new JLabel("Haga clic para copiar los archivos de cartelera:"), BorderLayout.NORTH);
        panel.add(copyBtn, BorderLayout.CENTER);
        
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private static void copyFile(String origen, String destino) throws IOException {
        try (InputStream in = new FileInputStream(origen);
             OutputStream out = new FileOutputStream(destino)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        }
    }
}