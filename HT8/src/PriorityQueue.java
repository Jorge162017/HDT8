/*
    Interfaz para la prioridad
 */
public interface PriorityQueue <T> {

    public T getFirst();
    // pre: !isEmpty()
    // post: returns the minimum value in priority queue

    public T remove();
    // pre: !isEmpty()
    // post: returns and removes minimum value from queue

    public void add(T value);
    // pre: value is non-null comparable
    // post: value is added to priority queue

    public boolean isEmpty();
    // post: returns true iff no elements are in queue

    public int size();
    // post: returns number of elements within queue

    public void clear();
    // post: removes all elements from queue
}
