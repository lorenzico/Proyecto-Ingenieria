package A6EscrituraLectura;

import java.util.Scanner;


public class MirarSala {
    
    public static void main(String [] args) {
        Scanner scann = new Scanner(System.in);



        while (true) {

            System.out.println("¿Quieres ver las salas y su tamaño?");
            String puede = scann.nextLine();

            switch (puede) {

                System.out.println("Cual es el número de la sala que quieres ver:");
                int num_sala = scann.nextInt();
    
                case si:
                    
                    System.out.println(sala_array + num_sala);

                    break;
            
                default:
                    break;
            }
        }

        

        

    }


}
