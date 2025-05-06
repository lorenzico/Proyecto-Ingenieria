package A6EscrituraLectura;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BaneoUsuarios {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Baneo de Usuarios");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        // Panel de lista de usuarios
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> userList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(userList);
        
        // Panel de controles
        JPanel controlPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        JButton refreshBtn = new JButton("Actualizar Lista");
        JButton banBtn = new JButton("Banear Seleccionado");
        banBtn.setEnabled(false);
        
        controlPanel.add(refreshBtn);
        controlPanel.add(banBtn);
        
        // Cargar usuarios al iniciar
        loadUsers(listModel, "A0Ficheros/Autenticacion.txt");
        
        // Listeners
        userList.addListSelectionListener(e -> banBtn.setEnabled(userList.getSelectedIndex() != -1));
        
        refreshBtn.addActionListener(event -> loadUsers(listModel, "A0Ficheros/Autenticacion.txt")); // Removed unused parameter
        
        banBtn.addActionListener(event -> { // Removed unused parameter
            String selected = userList.getSelectedValue();
            if (selected != null) {
                String email = selected.split(" - ")[0];
                int confirm = JOptionPane.showConfirmDialog(frame, 
                    "¿Está seguro que desea banear a: " + email + "?",
                    "Confirmar Baneo",
                    JOptionPane.YES_NO_OPTION);
                
                if (confirm == JOptionPane.YES_OPTION) {
                    banUser(email, "A0Ficheros/Autenticacion.txt");
                    loadUsers(listModel, "A0Ficheros/Autenticacion.txt");
                }
            }
        });
        
        mainPanel.add(new JLabel("Lista de Usuarios:"), BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(controlPanel, BorderLayout.SOUTH);
        
        frame.add(mainPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private static void loadUsers(DefaultListModel<String> model, String filePath) {
        model.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int count = 1;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length > 0) {
                    model.addElement(parts[0] + " - Usuario " + count);
                    count++;
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer usuarios: " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private static void banUser(String email, String filePath) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith(email + ";")) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer archivo: " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            JOptionPane.showMessageDialog(null, "Usuario baneado exitosamente");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar cambios: " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}