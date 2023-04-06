/*
Esta sera la clase donde se ejecute el programa
 */
import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args)throws IOException {
        Scanner input = new Scanner(System.in);
        Operaciones controlador = new Operaciones();


        System.out.println("Como quiere ordenar a los pacientes? Porfavor seleccione una opcion.");
        System.out.println("1. PriorityQueue");
        System.out.println("2. VectorHeap");
        int valor = input.nextInt();

        if (valor == 1) {
            controlador.leerarchivoalistaVectorHeap("pacientes.txt");
            System.out.println(controlador.ordenadovectorHeap());
        }
        else if (valor == 2) {
            controlador.leerarchivoalistaPriorityQueue("pacientes.txt");
            System.out.println(controlador.ordenadoPriorityQueue());
        }

        else {
            System.out.println("Numero Incorrecto");

        }

    }

}