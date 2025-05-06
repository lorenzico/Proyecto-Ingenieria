package A6EscrituraLectura;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class CrearSala {
    private static JTextArea salaDisplay;
    private static int[][] salaArray;
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Crear Nueva Sala");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        // Panel de configuración
        JPanel configPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        
        JLabel numLabel = new JLabel("Número de Sala:");
        JTextField numField = new JTextField();
        
        JLabel filasLabel = new JLabel("Filas:");
        JSpinner filasSpinner = new JSpinner(new SpinnerNumberModel(5, 1, 20, 1));
        
        JLabel columnasLabel = new JLabel("Columnas:");
        JSpinner columnasSpinner = new JSpinner(new SpinnerNumberModel(8, 1, 20, 1));
        
        configPanel.add(numLabel);
        configPanel.add(numField);
        configPanel.add(filasLabel);
        configPanel.add(filasSpinner);
        configPanel.add(columnasLabel);
        configPanel.add(columnasSpinner);
        
        // Panel de visualización de sala
        salaDisplay = new JTextArea();
        salaDisplay.setEditable(false);
        salaDisplay.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(salaDisplay);
        
        // Panel de controles
        JPanel controlPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        JButton initBtn = new JButton("Inicializar Sala");
        JButton toggleBtn = new JButton("Cambiar Asiento");
        JButton saveBtn = new JButton("Guardar Sala");
        
        controlPanel.add(initBtn);
        controlPanel.add(toggleBtn);
        controlPanel.add(saveBtn);
        
        // Listeners
        initBtn.addActionListener(event -> {
            int numSala;
            try {
                numSala = Integer.parseInt(numField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Número de sala inválido");
                return;
            }
            
            int filas = (int) filasSpinner.getValue();
            int columnas = (int) columnasSpinner.getValue();
            
            salaArray = new int[filas][columnas];
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    salaArray[i][j] = 1; // 1 = disponible
                }
            }
            updateSalaDisplay();
        });
        
        toggleBtn.addActionListener(event -> {
            if (salaArray == null) {
                JOptionPane.showMessageDialog(frame, "Primero inicialice la sala");
                return;
            }
            
            String filaStr = JOptionPane.showInputDialog(frame, "Ingrese fila (1-" + salaArray.length + "):");
            String colStr = JOptionPane.showInputDialog(frame, "Ingrese columna (1-" + salaArray[0].length + "):");
            
            try {
                int fila = Integer.parseInt(filaStr) - 1;
                int col = Integer.parseInt(colStr) - 1;
                
                if (fila >= 0 && fila < salaArray.length && col >= 0 && col < salaArray[0].length) {
                    salaArray[fila][col] = (salaArray[fila][col] == 1) ? 0 : 1;
                    updateSalaDisplay();
                } else {
                    JOptionPane.showMessageDialog(frame, "Posición inválida");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Ingrese números válidos");
            }
        });
        
        saveBtn.addActionListener(event -> {
            if (salaArray == null) {
                JOptionPane.showMessageDialog(frame, "Primero inicialice la sala");
                return;
            }
            
            try {
                int numSala = Integer.parseInt(numField.getText());
                PrintWriter pw = new PrintWriter(new FileWriter("A7Salas/Sala_" + numSala + ".txt"));
                
                for (int[] fila : salaArray) {
                    for (int asiento : fila) {
                        pw.print(asiento + " ");
                    }
                    pw.println();
                }
                pw.close();
                
                JOptionPane.showMessageDialog(frame, "Sala guardada exitosamente");
                frame.dispose();
            } catch (IOException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Error al guardar: " + ex.getMessage());
            }
        });
        
        mainPanel.add(configPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(controlPanel, BorderLayout.SOUTH);
        
        frame.add(mainPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private static void updateSalaDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("   ");
        for (int j = 0; j < salaArray[0].length; j++) {
            sb.append(String.format("%-3d", j + 1));
        }
        sb.append("\n");
        
        for (int i = 0; i < salaArray.length; i++) {
            sb.append(String.format("%-3d", i + 1));
            for (int j = 0; j < salaArray[i].length; j++) {
                sb.append(String.format("%-3d", salaArray[i][j]));
            }
            sb.append("\n");
        }
        
        sb.append("\nLeyenda:\n1 - Disponible\n0 - Ocupado");
        salaDisplay.setText(sb.toString());
    }
}