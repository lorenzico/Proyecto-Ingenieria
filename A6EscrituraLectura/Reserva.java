package A6EscrituraLectura;


import A6EscrituraLectura.ReservaVer;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Reserva {
    
    public static String pelicula_nombre;
    public static String numSalas;
    public static String hora_pel;
    public static String dia_pel;

    public static String[] realizarreserva(){

            System.out.print("Dime la pelicula que quieres reservar : "); 
            Scanner scann = new Scanner(System.in);
            String pelicula_nombre = scann.nextLine();
            String numSalas = "";
            String hora_pel = "";
            String dia_pel = "";


            try (BufferedReader reader = new BufferedReader(new FileReader("A0Ficheros/Cartelera.txt"))) {
            String linea;
            int numeroLinea = 0;
            

            while ((linea = reader.readLine()) != null) {
                numeroLinea ++;

                String[] partes = linea.split(";");


                for (int i = 0; i < partes.length; i++){
                    
                    if (i == 0 && partes[0].equals(pelicula_nombre)) {
                        System.out.println("-----------------------------------------------------");

                        System.out.println( "NOMBRE PELICULA: " + partes[0]);
                        System.out.println( "NUMERO SALA: " + partes[1]);
                        System.out.println( "DÍA DE PROYECCIÓN: " + partes[2]);
                        System.out.println( "HORA DE PROYECCIÓN: " + partes[3]);
                        numSalas = partes[1];
                        hora_pel = partes[2];
                        dia_pel = partes[3];

                    }

                }




            }
            

        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
            e.printStackTrace();
        }



        System.out.println("-----------------------------------------------------");


        
        System.out.println("Dime que asiento quieres reservar (1-Libre / 2-Reservado / 3-Minusválido): "); 

        System.out.println("--------------");
        System.out.println(" _________        ");
        System.out.println("|         |");
        System.out.println("| Screen  |");
        System.out.println("|_________|       ");

        try (BufferedReader reader = new BufferedReader(new FileReader("A7Salas/Sala_" + numSalas +".txt"))) {
            String linea;
            int numeroLinea = 0;

            while ((linea = reader.readLine()) != null) {
                numeroLinea ++;

                String[] partes = linea.split(";");


                for (int i = 0; i < partes.length; i++){
                    
                        System.out.println( partes[i]);

                }




            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
            e.printStackTrace();
        }

        System.out.println("--------------");



        System.out.println("Fila: ");
int fila = scann.nextInt();
scann.nextLine(); // Limpiar el buffer

System.out.println("Columna: ");
int columna = scann.nextInt();  // Si columna es un número, mejor leer como int
scann.nextLine(); // Limpiar el buffer

// Primero leer todo el archivo y almacenar las líneas
List<String> lineas = new ArrayList<>();
try (BufferedReader reader = new BufferedReader(new FileReader("A7Salas/Sala_" + numSalas + ".txt"))) {
    String linea;
    int numeroLinea = 0;
    
    while ((linea = reader.readLine()) != null) {
        numeroLinea++;
        String[] partes = linea.split(" ");
        
        // Solo modificar la fila deseada
        if (numeroLinea == fila) {
            // Verificar que la columna exista
            if (columna - 1 < partes.length) {  // -1 porque los arrays empiezan en 0
                partes[columna - 1] = "0";  // Cambiar solo esa posición
            } else {
                System.err.println("Error: La columna no existe en la fila seleccionada.");
                
            }
            linea = String.join(" ", partes);  // Reconstruir la línea
        }
        
        lineas.add(linea);  // Guardar la línea (modificada o no)
    }
} catch (IOException e) {
    System.err.println("Error al leer el archivo: " + e.getMessage());
    
}



// Reescribir el archivo completo con los cambios
try (BufferedWriter writer = new BufferedWriter(new FileWriter("A7Salas/Sala_" + numSalas + ".txt"))) {
    for (String linea : lineas) {
        writer.write(linea);
        writer.newLine();
    }
} catch (IOException e) {
    System.err.println("Error al escribir en el archivo: " + e.getMessage());
}


return new String[]{pelicula_nombre, numSalas, hora_pel, dia_pel};


        
 }



    }
        
        
    
