/*
Pruebas unitarias para el vector heap
 */
import static org.junit.Assert.*;
import org.junit.Test;
public class VectorHeapTest {
    VectorHeap<String> vector = new VectorHeap<String>();

    @Test
    public void testagregar() {
        vector.add("Maria Ramirez  apendicitis  A");
        assertEquals("Maria Ramirez  apendicitis  A",vector.remove());

    }


    @Test
    public void testremover() {
        vector.add("Maria Ramirez  apendicitis  A");
        vector.add("Carmen Sarmientos  dolores de parto  B ");
        String a = vector.remove() + vector.remove();
        assertEquals("Carmen Sarmientos  dolores de parto  B " + "Maria Ramirez  apendicitis  A" , a);


    }
}
