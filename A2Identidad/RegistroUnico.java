package A2Identidad;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.regex.Pattern;

public class RegistroUnico {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Registro de Usuario Único");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel titleLabel = new JLabel("REGISTRO DE USUARIO ÚNICO", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel nameLabel = new JLabel("Nombre:");
        JTextField nameField = new JTextField();

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();

        JLabel passwordLabel = new JLabel("Contraseña:");
        JPasswordField passwordField = new JPasswordField();

        JLabel genderLabel = new JLabel("Género:");
        JComboBox<String> genderCombo = new JComboBox<>(new String[]{"Masculino", "Femenino", "Otros"});

        JLabel ageLabel = new JLabel("Edad:");
        JSpinner ageSpinner = new JSpinner(new SpinnerNumberModel(16, 16, 100, 1));

        JButton registerButton = new JButton("Registrarse");
        registerButton.setFont(new Font("Arial", Font.BOLD, 14));
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        registerButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String email = emailField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();
            String gender = (String) genderCombo.getSelectedItem();
            int age = (int) ageSpinner.getValue();

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "El campo 'Nombre' no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (email.isEmpty() || !isValidEmail(email)) {
                JOptionPane.showMessageDialog(frame, "El email no es válido. Debe contener un '@' y un dominio como '@gmail.com'.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (password.isEmpty() || !isValidPassword(password)) {
                JOptionPane.showMessageDialog(frame, "La contraseña debe tener al menos 8 caracteres, incluyendo una letra mayúscula, una minúscula, un número y un carácter especial.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (isEmailTaken(email)) {
                JOptionPane.showMessageDialog(frame, "El email ya está registrado. Por favor, elige otro.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (isNameTaken(name)) {
                JOptionPane.showMessageDialog(frame, "El nombre ya está registrado. Por favor, elige otro.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (age < 16 || age > 100) {
                JOptionPane.showMessageDialog(frame, "La edad debe estar entre 16 y 100 años.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("A0Ficheros/Autenticacion.txt", true))) {
                writer.write(name + ";" + email + ";" + password + ";" + gender + ";" + age + ";");
                writer.newLine();
                JOptionPane.showMessageDialog(frame, "Registro exitoso.");
                frame.dispose();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error al registrar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        mainPanel.add(titleLabel);
        mainPanel.add(Box.createVerticalStrut(15));
        mainPanel.add(nameLabel);
        mainPanel.add(nameField);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(emailLabel);
        mainPanel.add(emailField);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordField);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(genderLabel);
        mainPanel.add(genderCombo);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(ageLabel);
        mainPanel.add(ageSpinner);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(registerButton);

        frame.add(mainPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static boolean isValidEmail(String email) {
        String emailRegex = "^[\\w-\\.]+@[\\w-]+\\.[a-z]{2,}$"; // Updated regex to correctly validate emails
        return Pattern.matches(emailRegex, email);
    }

    private static boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return Pattern.matches(passwordRegex, password);
    }

    private static boolean isEmailTaken(String email) {
        try (BufferedReader reader = new BufferedReader(new FileReader("A0Ficheros/Autenticacion.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length > 1 && parts[1].equalsIgnoreCase(email)) {
                    return true;
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al verificar el email: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    private static boolean isNameTaken(String name) {
        try (BufferedReader reader = new BufferedReader(new FileReader("A0Ficheros/Autenticacion.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length > 0 && parts[0].equalsIgnoreCase(name)) {
                    return true;
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al verificar el nombre: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}
