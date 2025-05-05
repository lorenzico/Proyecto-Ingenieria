package A1Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu_Identificacion {

    public static void main(String[] args) {
        // Crear y configurar la ventana principal
        JFrame frame = new JFrame("Menú de Identificación");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout(10, 10));
        
        // Panel principal con márgenes
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Título
        JLabel titleLabel = new JLabel("MENÚ DE IDENTIFICACIÓN", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        
        // Botones
        JButton loginButton = new JButton("Iniciar sesión (Login)");
        JButton registerButton = new JButton("Registrarse");
        JButton exitButton = new JButton("Salir");
        
        // Estilo de los botones
        Font buttonFont = new Font("Arial", Font.PLAIN, 14);
        loginButton.setFont(buttonFont);
        registerButton.setFont(buttonFont);
        exitButton.setFont(buttonFont);
        
        // Acciones de los botones
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                A2Identidad.Login.main(args);
                frame.dispose(); // Cierra la ventana actual
            }
        });
        
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                A2Identidad.Registro.main(args);
                frame.dispose(); // Cierra la ventana actual
            }
        });
        
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Saliendo del sistema...");
                System.exit(0);
            }
        });
        
        // Añadir componentes al panel principal
        mainPanel.add(titleLabel);
        mainPanel.add(loginButton);
        mainPanel.add(registerButton);
        mainPanel.add(exitButton);
        
        // Añadir panel principal al frame
        frame.add(mainPanel, BorderLayout.CENTER);
        
        // Centrar la ventana en la pantalla
        frame.setLocationRelativeTo(null);
        
        // Hacer visible la ventana
        frame.setVisible(true);
    }
}