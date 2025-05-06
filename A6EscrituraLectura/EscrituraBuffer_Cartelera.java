package A6EscrituraLectura;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.*;

public class EscrituraBuffer_Cartelera {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Actualización de Cartelera");
        frame.setSize(700, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        // Panel de limpieza
        JPanel cleanPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JCheckBox cleanCheck = new JCheckBox("Limpiar cartelera actual");
        cleanPanel.add(cleanCheck);
        
        // Panel de datos de película
        JPanel moviePanel = new JPanel(new GridLayout(8, 2, 10, 10));
        moviePanel.setBorder(BorderFactory.createTitledBorder("Datos de la Película"));
        
        JLabel nameLabel = new JLabel("Nombre:");
        JTextField nameField = new JTextField();
        
        JLabel roomLabel = new JLabel("Número de Sala:");
        JTextField roomField = new JTextField();
        
        JLabel dayLabel = new JLabel("Día de Proyección:");
        JTextField dayField = new JTextField();
        
        JLabel timeLabel = new JLabel("Hora de Proyección:");
        JTextField timeField = new JTextField();
        
        JLabel yearLabel = new JLabel("Año de Salida:");
        JTextField yearField = new JTextField();
        
        JLabel directorLabel = new JLabel("Director:");
        JTextField directorField = new JTextField();
        
        JLabel revenueLabel = new JLabel("Recaudación:");
        JTextField revenueField = new JTextField();
        
        JLabel synopsisLabel = new JLabel("Sinopsis:");
        JTextArea synopsisArea = new JTextArea(3, 20);
        JScrollPane synopsisScroll = new JScrollPane(synopsisArea);
        
        moviePanel.add(nameLabel);
        moviePanel.add(nameField);
        moviePanel.add(roomLabel);
        moviePanel.add(roomField);
        moviePanel.add(dayLabel);
        moviePanel.add(dayField);
        moviePanel.add(timeLabel);
        moviePanel.add(timeField);
        moviePanel.add(yearLabel);
        moviePanel.add(yearField);
        moviePanel.add(directorLabel);
        moviePanel.add(directorField);
        moviePanel.add(revenueLabel);
        moviePanel.add(revenueField);
        moviePanel.add(synopsisLabel);
        moviePanel.add(synopsisScroll);
        
        // Botón de guardar
        JButton saveBtn = new JButton("Guardar Película");
        saveBtn.setFont(new Font("Arial", Font.BOLD, 14));
        
        saveBtn.addActionListener(event -> {
            if (cleanCheck.isSelected()) {
                try {
                    Files.copy(Paths.get("Cartelera.txt"), Paths.get("Cartelera2.txt"), 
                        StandardCopyOption.REPLACE_EXISTING);
                    
                    FileWriter fw = new FileWriter("A0Ficheros/Cartelera.txt", false);
                    fw.write("");
                    fw.close();
                    
                    JOptionPane.showMessageDialog(frame, "Cartelera limpiada exitosamente");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Error al limpiar cartelera: " + ex.getMessage());
                }
            }
            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("A0Ficheros/Cartelera.txt", true))) {
                writer.write(nameField.getText() + ";");
                writer.write(roomField.getText() + ";");
                writer.write(dayField.getText() + ";");
                writer.write(timeField.getText() + ";");
                writer.write(yearField.getText() + ";");
                writer.write(directorField.getText() + ";");
                writer.write(revenueField.getText() + ";");
                writer.write(synopsisArea.getText() + ";");
                writer.newLine();
                
                JOptionPane.showMessageDialog(frame, "Película agregada a la cartelera");
                frame.dispose();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error al guardar: " + ex.getMessage());
            }
        });
        
        mainPanel.add(cleanPanel);
        mainPanel.add(Box.createVerticalStrut(15));
        mainPanel.add(moviePanel);
        mainPanel.add(Box.createVerticalStrut(15));
        mainPanel.add(saveBtn);
        
        frame.add(mainPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}