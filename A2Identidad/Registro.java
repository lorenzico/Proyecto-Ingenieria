package A2Identidad;

import javax.swing.*;
import java.awt.*;

public class Registro {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Seleccionar Tipo de Registro");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("SELECCIONA EL TIPO DE REGISTRO", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JButton adminButton = new JButton("Registro como Admin");
        JButton userButton = new JButton("Registro como Usuario");
        JButton dependienteButton = new JButton("Registro como Dependiente");

        adminButton.addActionListener(e -> {
            frame.dispose();
            new RegistroUnico().initializeUI(); // Removed the role parameter
        });

        userButton.addActionListener(e -> {
            frame.dispose();
            new RegistroUnico().initializeUI(); // Removed the role parameter
        });

        dependienteButton.addActionListener(e -> {
            frame.dispose();
            new RegistroUnico().initializeUI(); // Removed the role parameter
        });

        mainPanel.add(titleLabel);
        mainPanel.add(adminButton);
        mainPanel.add(userButton);
        mainPanel.add(dependienteButton);

        frame.add(mainPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}