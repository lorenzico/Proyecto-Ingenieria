package A2Identidad;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.ActionEvent;

public class Login {
    public static String email; // Store the logged-in user's email
    public static String role; // Store the logged-in user's role (Admin/User)

    private JTextField emailField; // Declarar como atributo
    private JPasswordField passwordField; // Declarar como atributo
    private JComboBox<String> roleCombo; // Declarar como atributo
    private JFrame frame; // Declarar como atributo

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login().initializeUI());
    }

    private void initializeUI() {
        frame = new JFrame("Login"); // Inicializar frame
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel titleLabel = new JLabel("LOGIN", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField(); // Inicializar emailField

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordField = new JPasswordField(); // Inicializar passwordField

        JLabel roleLabel = new JLabel("Rol:");
        roleCombo = new JComboBox<>(new String[]{"Usuario", "Admin", "Dependiente"}); // Inicializar roleCombo

        JButton loginButton = new JButton("Iniciar Sesión");
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        loginButton.addActionListener(this::handleLoginButtonClick); // Reemplazado lambda con referencia a método

        mainPanel.add(titleLabel);
        mainPanel.add(Box.createVerticalStrut(15));
        mainPanel.add(emailLabel);
        mainPanel.add(emailField);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordField);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(roleLabel);
        mainPanel.add(roleCombo);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(loginButton);

        frame.add(mainPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void handleLoginButtonClick(ActionEvent e) {
        // Mover lógica del botón aquí
        String enteredEmail = emailField.getText().trim();
        String enteredPassword = new String(passwordField.getPassword()).trim();
        String selectedRole = (String) roleCombo.getSelectedItem();

        if (enteredEmail.isEmpty() || enteredPassword.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (authenticate(enteredEmail, enteredPassword, selectedRole)) {
            email = enteredEmail;
            role = selectedRole;

            JOptionPane.showMessageDialog(frame, "Inicio de sesión exitoso.");
            frame.dispose();

            if ("Admin".equals(role)) {
                A4Menu_Dependiente.Menu_Dependiente.main(null); // Admin menu
            } else if ("Dependiente".equals(role)) {
                A4Menu_Dependiente.Menu_Dependiente.main(null); // Dependiente menu
            } else {
                A3Menu_Usuario.Menu_Usuario.main(null); // User menu
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Credenciales incorrectas o rol no autorizado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static boolean authenticate(String email, String password, String role) {
        try (BufferedReader reader = new BufferedReader(new FileReader("A0Ficheros/Autenticacion.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 3 && parts[1].equalsIgnoreCase(email) && parts[2].equals(password)) {
                    if ("Admin".equals(role) && "Admin".equalsIgnoreCase(parts[3])) {
                        return true; // Admin authentication
                    } else if ("Usuario".equals(role) && "Usuario".equalsIgnoreCase(parts[3])) {
                        return true; // User authentication
                    } else if ("Dependiente".equals(role) && "Dependiente".equalsIgnoreCase(parts[3])) {
                        return true; // Dependiente authentication
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al autenticar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}