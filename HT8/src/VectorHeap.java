import java.util.Vector;
public class VectorHeap extends Icomparator<T> implements PriorityQueue<T> {
    protected Vector<T> data;

    public VectorHeap(){
        data = new Vector<T>();
    }

    public VectorHeap(Vector<T> v)
    // post: constructs a new priority queue from an unordered vector
    {
        int i;
        data = new Vector<T>(v.size()); // we know ultimate size
        for (i = 0; i < v.size(); i++)
        { // add elements to heap
            add(v.get(i));
        }
    }
    protected static int parent(int i)
    {
        return (i-1)/2;
    }
    protected static int left(int i)
    // pre: 0 <= i < size
    // post: returns index of left child of node at location i
    {
        return 2*i+1;
    }
    protected static int right(int i)
    {
        return (2*i+1) + 1;
    }
    protected void percolateUp(int leaf)
    {
        int parent = parent(leaf);
        T value = data.get(leaf);
        while (leaf > 0 &&
                (value.compareTo(data.get(parent)) < 0))
        {
            data.set(leaf,data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf,value);
    }
    public void add(T value)
    {
        data.add(value);
        percolateUp(data.size()-1);
    }
    protected void pushDownRoot(int root)
    // pre: 0 <= root < size
    // post: moves node at index root down
    // to appropriate position in subtree
    {
        int heapSize = data.size();
        T value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize)
            {
                if ((right(root) < heapSize) &&
                        ((data.get(childpos+1)).compareTo
                                (data.get(childpos)) < 0))
                {
                    childpos++;
                }
                // Assert: childpos indexes smaller of two children
                if ((data.get(childpos)).compareTo
                        (value) < 0)
                {
                    data.set(root,data.get(childpos));
                    root = childpos; // keep moving down
                } else { // found right location
                    data.set(root,value);
                    return;
                }
            } else { // at a leaf! insert and halt
                data.set(root,value);
                return;
            }
        }
    }

    @Override
    public T getFirst() {
        return data.get(0);
    }
    @Override
    public T remove() {
        if (!isEmpty()){
            T minVal = getFirst();
            data.set(0,data.get(data.size()-1));
            data.setSize(data.size()-1);
            if (data.size() > 1)
                pushDownRoot(0);
            return minVal;
        }else
            return null;
    }
    @Override
    public boolean isEmpty() {
        if(data.size()>=0) {
            return false;
        }
        else {
            return true;
        }
    }
    @Override
    public int size() {
        return data.size()-1;
    }
    @Override
    public void clear() {
        for(int i = 0; i<data.size(); i++) {
            remove();
        }

    }
}
//codigo obtenido y editado de http://dept.cs.williams.edu/~bailey/JavaStructures/Book_files/JavaStructures.pdf