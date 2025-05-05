package A2Identidad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Login {
    public static String email;

    public static void main(String[] args) {
        // Crear y configurar la ventana
        JFrame frame = new JFrame("Inicio de Sesión");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350);
        frame.setLayout(new BorderLayout(10, 10));
        
        // Panel principal con márgenes
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(6, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Título
        JLabel titleLabel = new JLabel("INICIO DE SESIÓN", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        
        // Componentes para selección de tipo de usuario
        JLabel userTypeLabel = new JLabel("Seleccione tipo de usuario:");
        ButtonGroup userTypeGroup = new ButtonGroup();
        JRadioButton userRadio = new JRadioButton("Usuario");
        JRadioButton dependRadio = new JRadioButton("Dependiente");
        JRadioButton adminRadio = new JRadioButton("Administrador");
        userTypeGroup.add(userRadio);
        userTypeGroup.add(dependRadio);
        userTypeGroup.add(adminRadio);
        
        // Panel para los radio buttons
        JPanel radioPanel = new JPanel(new GridLayout(1, 3));
        radioPanel.add(userRadio);
        radioPanel.add(dependRadio);
        radioPanel.add(adminRadio);
        
        // Campos de texto
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        JLabel passLabel = new JLabel("Contraseña:");
        JPasswordField passField = new JPasswordField();
        
        // Botón de login
        JButton loginButton = new JButton("Iniciar Sesión");
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        
        // Acción del botón de login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                email = emailField.getText();
                String contrasena = new String(passField.getPassword());
                int tipoUsuario = 1; // Por defecto usuario normal
                
                if (dependRadio.isSelected()) tipoUsuario = 2;
                else if (adminRadio.isSelected()) tipoUsuario = 3;
                
                if (verificarCredenciales(email, contrasena)) {
                    JOptionPane.showMessageDialog(frame, "Inicio de sesión exitoso.");
                    frame.dispose();
                    
                    if (tipoUsuario == 1) {
                        A3Menu_Usuario.Menu_Usuario.main(args);
                    } else if (tipoUsuario == 2) {
                        A4Menu_Dependiente.Menu_Dependiente.main(null);
                    } else {
                        A5Menu_Admin.Menu_Admin.main(null);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, 
                        "Credenciales incorrectas o usuario no registrado.", 
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        // Añadir componentes al panel principal
        mainPanel.add(titleLabel);
        mainPanel.add(userTypeLabel);
        mainPanel.add(radioPanel);
        mainPanel.add(emailLabel);
        mainPanel.add(emailField);
        mainPanel.add(passLabel);
        mainPanel.add(passField);
        mainPanel.add(loginButton);
        
        // Añadir panel principal al frame
        frame.add(mainPanel, BorderLayout.CENTER);
        
        // Centrar la ventana en la pantalla
        frame.setLocationRelativeTo(null);
        
        // Hacer visible la ventana
        frame.setVisible(true);
    }

    private static boolean verificarCredenciales(String email, String contrasena) {
        String archivo = "A0Ficheros/Autenticacion.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length >= 2 && partes[0].equals(email) && partes[1].equals(contrasena)) {
                    return true;
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, 
                "Error al leer el archivo: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}