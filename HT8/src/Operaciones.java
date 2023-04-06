import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
public class Operaciones {
    VectorHeap<Paciente> vector = new VectorHeap<Paciente>();
    PriorityQueue<Paciente> vector2 = new PriorityQueue<Paciente>();

    String [] listado;
    ArrayList<String> ordenado = new ArrayList<String>();
    ArrayList<String> ordenado2 = new ArrayList<String>();

    int contador = 0;

    public void leerarchivoalistaVectorHeap(String nombredearchivodetexto) throws IOException
    {
        FileReader leer = new FileReader(nombredearchivodetexto);
        BufferedReader bufferedReader = new BufferedReader(leer);
        String leerlinea = null;

        while ((leerlinea = bufferedReader.readLine()) != null) {

            listado = leerlinea.split(",");
            vector.add(new Paciente (listado[0], listado[1], listado [2]));
            contador ++;
        }
        bufferedReader.close();
    }

    public ArrayList<String> ordenadovectorHeap() {
        for(int i=0 ; i<contador; i++) {
            Paciente enfermo = vector.remove();
            ordenado.add(enfermo.getNombre()+" "+enfermo.getProblema()+" "+enfermo.getPrioridad());

        }
        return ordenado;

    }


    public void leerarchivoalistaPriorityQueue(String nombredearchivodetexto) throws IOException
    {
        FileReader leer = new FileReader(nombredearchivodetexto);
        BufferedReader bufferedReader = new BufferedReader(leer);
        String leerlinea = null;

        while ((leerlinea = bufferedReader.readLine()) != null) {

            listado = leerlinea.split(",");
            vector2.add(new Paciente (listado[0], listado[1], listado [2]));
            contador ++;
        }
        bufferedReader.close();
    }


    public ArrayList<String> ordenadoPriorityQueue() {
        for(int i=0 ; i<contador; i++) {
            Paciente enfermo = vector2.poll();
            ordenado2.add(enfermo.getNombre()+" "+enfermo.getProblema()+" "+enfermo.getPrioridad());

        }
        return ordenado2;

    }
}
