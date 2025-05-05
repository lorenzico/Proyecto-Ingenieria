package A6EscrituraLectura;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ReservaVer {
    public static void main(String[] args) {
        String email = A2Identidad.Login.email;
        String[] reserva = Reserva.realizarreserva();
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("A8Usuarios/" + email, true))) {
            writer.write(reserva[0] + ";");
            writer.write(reserva[1] + ";");
            writer.write(reserva[2] + ";");
            writer.write(reserva[3] + ";");
            writer.newLine();
            
            JOptionPane.showMessageDialog(null, "Reserva guardada exitosamente");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar reserva: " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        A3Menu_Usuario.Menu_Usuario.main(null);
    }
}