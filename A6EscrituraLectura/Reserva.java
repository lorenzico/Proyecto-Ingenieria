package A6EscrituraLectura;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List; // Explicit import for List interface

public class Reserva {
    public static String[] realizarreserva() {
        JFrame frame = new JFrame("Reserva de Entradas");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        // Panel de selección de película
        JPanel moviePanel = new JPanel(new BorderLayout());
        moviePanel.setBorder(BorderFactory.createTitledBorder("Seleccione Película"));
        
        DefaultListModel<String> movieListModel = new DefaultListModel<>();
        JList<String> movieList = new JList<>(movieListModel);
        JScrollPane movieScroll = new JScrollPane(movieList);
        
        loadMovies(movieListModel);
        
        // Panel de visualización de sala
        JTextArea salaDisplay = new JTextArea();
        salaDisplay.setEditable(false);
        salaDisplay.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane salaScroll = new JScrollPane(salaDisplay);
        
        // Panel de selección de asiento
        JPanel seatPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        seatPanel.setBorder(BorderFactory.createTitledBorder("Selección de Asiento"));
        
        JLabel rowLabel = new JLabel("Fila:");
        JSpinner rowSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 20, 1));
        
        JLabel colLabel = new JLabel("Columna:");
        JSpinner colSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 20, 1));
        
        seatPanel.add(rowLabel);
        seatPanel.add(rowSpinner);
        seatPanel.add(colLabel);
        seatPanel.add(colSpinner);
        
        // Variables para almacenar datos
        String[] result = new String[4];
        JButton reserveBtn = new JButton("Reservar Asiento");
        reserveBtn.setEnabled(false);
        
        // Listeners
        movieList.addListSelectionListener(e -> {
            if (!movieList.isSelectionEmpty()) {
                String selected = movieList.getSelectedValue();
                String[] parts = selected.split(" - Sala: ");
                result[0] = parts[0]; // Nombre película
                result[1] = parts[1]; // Número sala
                
                // Mostrar sala
                try {
                    BufferedReader reader = new BufferedReader(
                        new FileReader("A7Salas/Sala_" + result[1] + ".txt"));
                    
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        sb.append(line.replace(";", " ")).append("\n");
                    }
                    reader.close();
                    
                    salaDisplay.setText(sb.toString());
                    reserveBtn.setEnabled(true);
                } catch (IOException ex) {
                    salaDisplay.setText("Error al cargar sala: " + ex.getMessage());
                }
            }
        });
        
        reserveBtn.addActionListener(event -> {
            int fila = (int) rowSpinner.getValue();
            int columna = (int) colSpinner.getValue();
            
            try {
                java.util.List<String> lines = new ArrayList<>(); // Fully qualified name
                BufferedReader reader = new BufferedReader(
                    new FileReader("A7Salas/Sala_" + result[1] + ".txt"));
                
                String line;
                int currentRow = 1;
                while ((line = reader.readLine()) != null) {
                    if (currentRow == fila) {
                        String[] seats = line.split(" ");
                        if (columna <= seats.length) {
                            seats[columna-1] = "0"; // Marcar como ocupado
                            line = String.join(" ", seats);
                        }
                    }
                    lines.add(line);
                    currentRow++;
                }
                reader.close();
                
                // Guardar cambios
                BufferedWriter writer = new BufferedWriter(
                    new FileWriter("A7Salas/Sala_" + result[1] + ".txt"));
                for (String l : lines) {
                    writer.write(l);
                    writer.newLine();
                }
                writer.close();
                
                // Obtener hora y día de la película
                getMovieTime(result[0], result);
                
                JOptionPane.showMessageDialog(frame, "Reserva realizada con éxito");
                frame.dispose();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error al reservar: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        // Organizar componentes
        JPanel topPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        topPanel.add(movieScroll);
        topPanel.add(salaScroll);
        
        mainPanel.add(topPanel, BorderLayout.CENTER);
        mainPanel.add(seatPanel, BorderLayout.NORTH);
        mainPanel.add(reserveBtn, BorderLayout.SOUTH);
        
        frame.add(mainPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        return result;
    }
    
    private static void loadMovies(DefaultListModel<String> model) {
        try (BufferedReader reader = new BufferedReader(new FileReader("A0Ficheros/Cartelera.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 2) {
                    model.addElement(parts[0] + " - Sala: " + parts[1]);
                }
            }
        } catch (IOException e) {
            model.addElement("Error al cargar películas: " + e.getMessage());
        }
    }
    
    private static void getMovieTime(String movieName, String[] result) {
        try (BufferedReader reader = new BufferedReader(new FileReader("A0Ficheros/Cartelera.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 4 && parts[0].equals(movieName)) {
                    result[2] = parts[2]; // Día
                    result[3] = parts[3]; // Hora
                    break;
                }
            }
        } catch (IOException e) {
            result[2] = "Desconocido";
            result[3] = "Desconocido";
        }
    }
}