package A2Identidad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import A6EscrituraLectura.EscrituraBuffer_Autenticacion;

public class Registro {
    public static void main(String[] args) {
        // Crear y configurar la ventana
        JFrame frame = new JFrame("Registro de Usuario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 400);
        frame.setLayout(new BorderLayout(10, 10));
        
        // Panel principal con márgenes
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Título
        JLabel titleLabel = new JLabel("REGISTRO DE USUARIO", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        
        // Componentes para selección de tipo de usuario
        JLabel userTypeLabel = new JLabel("Seleccione el tipo de usuario:");
        ButtonGroup userTypeGroup = new ButtonGroup();
        JRadioButton userRadio = new JRadioButton("Usuario normal");
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
        
        // Panel para contraseña de autorización (aparecerá cuando sea necesario)
        JPanel authPanel = new JPanel(new GridLayout(2, 1));
        JLabel authLabel = new JLabel("Contraseña de autorización:");
        JPasswordField authField = new JPasswordField();
        authPanel.add(authLabel);
        authPanel.add(authField);
        authPanel.setVisible(false);
        
        // Botón de registro
        JButton registerButton = new JButton("Registrarse");
        registerButton.setFont(new Font("Arial", Font.BOLD, 14));
        
        // Acción de los radio buttons para mostrar/ocultar panel de autorización
        ActionListener radioListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authPanel.setVisible(dependRadio.isSelected() || adminRadio.isSelected());
                frame.pack();
            }
        };
        
        userRadio.addActionListener(radioListener);
        dependRadio.addActionListener(radioListener);
        adminRadio.addActionListener(radioListener);
        
        // Acción del botón de registro
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dependRadio.isSelected()) {
                    String contrasenaAuth = new String(authField.getPassword());
                    if (!"lorenzodependiente".equals(contrasenaAuth)) {
                        JOptionPane.showMessageDialog(frame, 
                            "Contraseña de autorización incorrecta.", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } else if (adminRadio.isSelected()) {
                    String contrasenaAuth = new String(authField.getPassword());
                    if (!"arturoadmin".equals(contrasenaAuth)) {
                        JOptionPane.showMessageDialog(frame, 
                            "Contraseña maestra incorrecta.", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                
                // Procesar registro
                EscrituraBuffer_Autenticacion objetoA = new EscrituraBuffer_Autenticacion();
                objetoA.escrituraAutenticacion();
                
                JOptionPane.showMessageDialog(frame, "Registro exitoso");
                frame.dispose();
            }
        });
        
        // Añadir componentes al panel principal
        mainPanel.add(titleLabel);
        mainPanel.add(userTypeLabel);
        mainPanel.add(radioPanel);
        mainPanel.add(authPanel);
        mainPanel.add(registerButton);
        
        // Añadir panel principal al frame
        frame.add(mainPanel, BorderLayout.CENTER);
        
        // Centrar la ventana en la pantalla
        frame.setLocationRelativeTo(null);
        
        // Hacer visible la ventana
        frame.setVisible(true);
    }
}