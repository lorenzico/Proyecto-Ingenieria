package A5Menu_Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu_Admin {
    public static void main(String[] args) {
        // Crear y configurar la ventana principal
        JFrame frame = new JFrame("Menú del Administrador");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 350);
        frame.setLayout(new BorderLayout(10, 10));
        
        // Panel principal con márgenes
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Título
        JLabel titleLabel = new JLabel("MENÚ DEL ADMINISTRADOR", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        
        // Botones
        JButton carteleraButton = new JButton("Actualización Cartelera");
        JButton baneoButton = new JButton("Baneo Cliente");
        JButton salasButton = new JButton("Creación Salas");
        JButton salirButton = new JButton("Salir");
        
        // Estilo de los botones
        Font buttonFont = new Font("Arial", Font.PLAIN, 14);
        carteleraButton.setFont(buttonFont);
        baneoButton.setFont(buttonFont);
        salasButton.setFont(buttonFont);
        salirButton.setFont(buttonFont);
        
        // Acciones de los botones
        carteleraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                A6EscrituraLectura.EscrituraBuffer_Cartelera.main(null);
            }
        });
        
        baneoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                A6EscrituraLectura.BaneoUsuarios.main(null);
            }
        });
        
        salasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                A6EscrituraLectura.CrearSala.main(null);
            }
        });
        
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Cierra la ventana actual
                A1Menu.Menu_Identificacion.main(null);
            }
        });
        
        // Añadir componentes al panel principal
        mainPanel.add(titleLabel);
        mainPanel.add(carteleraButton);
        mainPanel.add(baneoButton);
        mainPanel.add(salasButton);
        mainPanel.add(salirButton);
        
        // Añadir panel principal al frame
        frame.add(mainPanel, BorderLayout.CENTER);
        
        // Centrar la ventana en la pantalla
        frame.setLocationRelativeTo(null);
        
        // Hacer visible la ventana
        frame.setVisible(true);
    }
}