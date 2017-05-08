/**
 * Created by karim møller(karmo15) and Mads Berggreen(madbe15) on 23-02-2017.
 */
public class PQHeap implements PQ {

    private final int one = 1; // adding to one Index the array
    private Element[] heap;
    private int counter = 0; // keeps track the amount of elemens in the heap


    /**
     * Constructor.
     *
     * @param maxElements The amount of elements that there is room for in the queue.
     */
    public PQHeap(int maxElements) {
        heap = new Element[maxElements + one];
        heap[0] = new Element(0, null); // one Index
    }

    /**
     * Returns the element on the 1 place in the array, and then heapifys the remaining
     *
     * @return Element With the lowest frequency
     */
    @Override
    public Element extractMin() {
        Element min = heap[1];
        heap[1] = heap[counter];
        counter--;
        MinHeapify(1);
        return min;
    }

    /**
     * inserts the Element on the last place in the array and then bubbels it up to the right place.
     *
     * @param e The element that will be insertRoot.
     */
    @Override
    public void insert(Element e) {
        heap[++counter] = e; // insertRoot on last availa
        // ble place
        int current = counter; // the index where the element has bin inserted

        //decrease-frequency
        while (current > 1 && heap[Parent(current)].getFrequency() > heap[current].getFrequency()) { //if the heap is the first element it will just paste it and skip the while
            swap(current, Parent(current)); //swaps the two elements
            current = Parent(current); // sets heapsize to the half
        }
    }

    /**
     * Method that heapifies the positions into a mininum heap.
     *
     * @param pos
     */
    private void MinHeapify(int pos) {
        int left = leftChild(pos);
        int right = rightChild(pos);
        int Smallest;
        if (left <= counter && heap[left].getFrequency() < heap[pos].getFrequency()) {

            Smallest = left;
        } else {
            Smallest = pos;
        }
        if (right <= counter && heap[right].getFrequency() < heap[Smallest].getFrequency()) {
            Smallest = right;
        }
        if (Smallest != pos) {
            swap(pos, Smallest);
            MinHeapify(Smallest);
        }
    }

    /**
     * Method for swapping two elements making them change places.
     *
     * @param i
     * @param k
     */
    private void swap(int i, int k) {
        Element temp;
        temp = heap[i];
        heap[i] = heap[k];
        heap[k] = temp;
    }

    /**
     * Method for determining the parent of a node.
     *
     * @param i
     */
    private int Parent(int i) {
        return i / 2;
    }

    /**
     * Method for determining the left child of a node.
     *
     * @param i
     */
    private int leftChild(int i) {
        return i * 2;
    }

    /**
     * Method for determining the right child of a node.
     *
     * @param i
     */
    private int rightChild(int i) {
        return i * 2 + 1;
    }
}
