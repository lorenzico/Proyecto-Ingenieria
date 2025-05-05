package A6EscrituraLectura;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Metrica3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Salas para Discapacitados");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        JButton generateBtn = new JButton("Generar Reporte");
        generateBtn.addActionListener(e -> {
            textArea.setText("");
            generateReport(textArea);
        });
        
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(generateBtn, BorderLayout.SOUTH);
        
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private static void generateReport(JTextArea textArea) {
        int contador = 1;
        while (contador < 10) {
            String archivo = "A7Salas/Sala_" + contador + ".txt";
            File archivo2 = new File(archivo);
            if (!archivo2.exists()) break;
            
            boolean tieneDiscapacitados = false;
            try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    String[] partes = linea.split(" ");
                    for (String parte : partes) {
                        if (parte.equals("3")) {
                            tieneDiscapacitados = true;
                            break;
                        }
                    }
                }
            } catch (IOException e) {
                textArea.append("Error al leer sala " + contador + ": " + e.getMessage() + "\n");
            }
            
            textArea.append("La sala " + contador + 
                (tieneDiscapacitados ? " SÍ" : " NO") + 
                " está adaptada para discapacitados\n");
            
            contador++;
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("A9Descargas/SalasDiscapacitados.txt"))) {
            writer.write(textArea.getText());
            textArea.append("\nReporte guardado en A9Descargas/SalasDiscapacitados.txt");
        } catch (IOException e) {
            textArea.append("\nError al guardar reporte: " + e.getMessage());
        }
    }
}