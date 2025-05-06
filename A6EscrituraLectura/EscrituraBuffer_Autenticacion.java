package A6EscrituraLectura;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class EscrituraBuffer_Autenticacion {
    public static void escrituraAutenticacion() {
        JFrame frame = new JFrame("Registro de Usuario");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        // Panel de credenciales
        JPanel credPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        credPanel.setBorder(BorderFactory.createTitledBorder("Credenciales"));
        
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        
        JLabel passLabel = new JLabel("Contraseña:");
        JPasswordField passField = new JPasswordField();
        
        credPanel.add(emailLabel);
        credPanel.add(emailField);
        credPanel.add(passLabel);
        credPanel.add(passField);
        
        // Panel de perfil
        JPanel profilePanel = new JPanel(new GridLayout(4, 2, 10, 10));
        profilePanel.setBorder(BorderFactory.createTitledBorder("Información de Perfil"));
        
        JLabel genderLabel = new JLabel("Género (M/F):");
        JTextField genderField = new JTextField();
        
        JLabel ageLabel = new JLabel("Edad:");
        JTextField ageField = new JTextField();
        
        JLabel paymentLabel = new JLabel("Forma de pago:");
        JTextField paymentField = new JTextField();
        
        JLabel statusLabel = new JLabel("Situación:");
        JComboBox<String> statusCombo = new JComboBox<>(new String[]{"Estudiante", "Trabajador", "Parado"});
        
        profilePanel.add(genderLabel);
        profilePanel.add(genderField);
        profilePanel.add(ageLabel);
        profilePanel.add(ageField);
        profilePanel.add(paymentLabel);
        profilePanel.add(paymentField);
        profilePanel.add(statusLabel);
        profilePanel.add(statusCombo);
        
        // Botón de registro
        JButton registerBtn = new JButton("Registrarse");
        registerBtn.setFont(new Font("Arial", Font.BOLD, 14));
        
        registerBtn.addActionListener(event -> {
            String email = emailField.getText();
            String password = new String(passField.getPassword());
            String gender = genderField.getText();
            String age = ageField.getText();
            String payment = paymentField.getText();
            String status = (String) statusCombo.getSelectedItem();
            
            if (email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Email y contraseña son obligatorios");
                return;
            }
            
            try {
                // Guardar credenciales
                BufferedWriter authWriter = new BufferedWriter(new FileWriter("A0Ficheros/Autenticacion.txt", true));
                authWriter.write(email + ";" + password + ";");
                authWriter.newLine();
                authWriter.close();
                
                // Guardar perfil
                BufferedWriter profileWriter = new BufferedWriter(new FileWriter("A8Usuarios/" + email, true));
                profileWriter.write(gender + ";" + age + ";" + payment + ";" + status + ";");
                profileWriter.newLine();
                profileWriter.close();
                
                JOptionPane.showMessageDialog(frame, "Registro exitoso!");
                frame.dispose();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error al registrar: " + ex.getMessage());
            }
        });
        
        mainPanel.add(credPanel);
        mainPanel.add(Box.createVerticalStrut(15));
        mainPanel.add(profilePanel);
        mainPanel.add(Box.createVerticalStrut(15));
        mainPanel.add(registerBtn);
        
        frame.add(mainPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}