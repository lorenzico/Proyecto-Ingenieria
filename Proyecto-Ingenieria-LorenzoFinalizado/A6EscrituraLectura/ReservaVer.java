package A6EscrituraLectura;

import A2Identidad.Login;
import A6EscrituraLectura.Reserva;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;



public class ReservaVer {
    

    public static void main(String[] args) {
        
        String email = Login.email;

        String[] reserva = Reserva.realizarreserva();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("A8Usuarios/" + email, true))) {

            
            writer.write(reserva[0]);
            writer.write(";");
            
            writer.write(reserva[1]);
            writer.write(";");

            writer.write(reserva[2]);
            writer.write(";");

            writer.write(reserva[3]);
            writer.write(";");

            writer.write(reserva[4]);
            writer.write(";");

            writer.write(reserva[5]);
            writer.write(";");

            writer.newLine();
            

        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
            e.printStackTrace();
        }
        
        A3Menu_Usuario.Menu_Usuario.main(null);
        

    }


}
