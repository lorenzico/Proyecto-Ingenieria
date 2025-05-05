package A3Menu_Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu_Usuario {
    public static void main(String[] args) {
        // Crear y configurar la ventana principal
        JFrame frame = new JFrame("Menú del Usuario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout(10, 10));
        
        // Panel principal con márgenes
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(6, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Título
        JLabel titleLabel = new JLabel("MENÚ DEL USUARIO", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        
        // Botones
        JButton reservaButton = new JButton("Reserva de Entradas");
        JButton carteleraButton = new JButton("Consulta de Cartelera");
        JButton perfilButton = new JButton("Perfil Usuario");
        JButton metricasButton = new JButton("Descarga Métricas");
        JButton salirButton = new JButton("Salir");
        
        // Estilo de los botones
        Font buttonFont = new Font("Arial", Font.PLAIN, 14);
        reservaButton.setFont(buttonFont);
        carteleraButton.setFont(buttonFont);
        perfilButton.setFont(buttonFont);
        metricasButton.setFont(buttonFont);
        salirButton.setFont(buttonFont);
        
        // Acciones de los botones
        reservaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                A6EscrituraLectura.ReservaVer.main(null);
            }
        });
        
        carteleraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                A6EscrituraLectura.LecturaArchivo_Cartelera.main(null);
            }
        });
        
        perfilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Opciones para el perfil de usuario
                Object[] options = {"Información Personal", "Ver Reservas"};
                int choice = JOptionPane.showOptionDialog(frame,
                    "¿Qué deseas consultar?",
                    "Perfil de Usuario",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
                
                if (choice == 0) {
                    A6EscrituraLectura.InfoUser.main(null);
                } else if (choice == 1) {
                    A6EscrituraLectura.ReservaVer2.main(null);
                }
            }
        });
        
        metricasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Opciones para métricas
                Object[] options = {"Salas", "Cartelera", "Salas para Discapacitados"};
                int choice = JOptionPane.showOptionDialog(frame,
                    "¿Qué métricas deseas descargar?",
                    "Descarga de Métricas",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
                
                if (choice == 0) {
                    A6EscrituraLectura.Metricas1.main(null);
                } else if (choice == 1) {
                    A6EscrituraLectura.Metricas2.main(null);
                } else if (choice == 2) {
                    A6EscrituraLectura.Metrica3.main(null);
                }
            }
        });
        
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                A1Menu.Menu_Identificacion.main(null);
            }
        });
        
        // Añadir componentes al panel principal
        mainPanel.add(titleLabel);
        mainPanel.add(reservaButton);
        mainPanel.add(carteleraButton);
        mainPanel.add(perfilButton);
        mainPanel.add(metricasButton);
        mainPanel.add(salirButton);
        
        // Añadir panel principal al frame
        frame.add(mainPanel, BorderLayout.CENTER);
        
        // Centrar la ventana en la pantalla
        frame.setLocationRelativeTo(null);
        
        // Hacer visible la ventana
        frame.setVisible(true);
    }
}