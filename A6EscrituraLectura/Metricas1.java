package A6EscrituraLectura;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.*;

public class Metricas1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Copiar Salas");
        frame.setSize(500, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        JTextArea statusArea = new JTextArea(5, 20);
        statusArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(statusArea);
        
        JButton copyBtn = new JButton("Copiar Salas a A9Descargas");
        copyBtn.addActionListener(event -> {
            Path origenDir = Paths.get("A7Salas");
            Path destinoDir = Paths.get("A9Descargas");
            
            try {
                if (Files.exists(destinoDir)) {
                    if (!Files.isDirectory(destinoDir)) {
                        statusArea.append("ERROR: Ya existe un ARCHIVO con ese nombre\n");
                        return;
                    }
                } else {
                    Files.createDirectories(destinoDir);
                    statusArea.append("Directorio creado: A9Descargas\n");
                }
                
                try (DirectoryStream<Path> stream = Files.newDirectoryStream(origenDir, "Sala_*.txt")) {
                    for (Path archivo : stream) {
                        Path destino = destinoDir.resolve(archivo.getFileName());
                        Files.copy(archivo, destino, StandardCopyOption.REPLACE_EXISTING);
                        statusArea.append("Copiado: " + archivo.getFileName() + "\n");
                    }
                }
                statusArea.append("Proceso completado con éxito\n");
            } catch (IOException ex) {
                statusArea.append("Error: " + ex.getMessage() + "\n");
            }
        });
        
        panel.add(new JLabel("Estado de la copia:"), BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(copyBtn, BorderLayout.SOUTH);
        
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}