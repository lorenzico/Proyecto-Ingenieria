package A4Menu_Dependiente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu_Dependiente {
    public static void main(String[] args) {
        // Crear y configurar la ventana principal
        JFrame frame = new JFrame("Menú del Dependiente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 300);
        frame.setLayout(new BorderLayout(10, 10));
        
        // Panel principal con márgenes
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Título
        JLabel titleLabel = new JLabel("MENÚ DEL DEPENDIENTE", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        
        // Botones
        JButton reservaButton = new JButton("Reserva de Entradas");
        JButton carteleraButton = new JButton("Consulta de Cartelera");
        JButton salirButton = new JButton("Salir");
        
        // Estilo de los botones
        Font buttonFont = new Font("Arial", Font.PLAIN, 14);
        reservaButton.setFont(buttonFont);
        carteleraButton.setFont(buttonFont);
        salirButton.setFont(buttonFont);
        
        // Acciones de los botones
        reservaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Cierra la ventana actual
                A2Identidad.Login.main(args);
            }
        });
        
        carteleraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                A6EscrituraLectura.LecturaArchivo_Cartelera.main(null);
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
        mainPanel.add(reservaButton);
        mainPanel.add(carteleraButton);
        mainPanel.add(salirButton);
        
        // Añadir panel principal al frame
        frame.add(mainPanel, BorderLayout.CENTER);
        
        // Centrar la ventana en la pantalla
        frame.setLocationRelativeTo(null);
        
        // Hacer visible la ventana
        frame.setVisible(true);
    }
}