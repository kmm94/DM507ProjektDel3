/**
 * Created by karim møller(karmo15) and Mads Berggreen(madbe15) on 23-02-2017.
 */
public class HuffmanTree {
    /**
     * Makes the HuffmanTree used in the encoding and decoding.
     * @param a the int array that contains the frequencies for the different bytes.
     * @return the extracted minimum Element from the priority queue. The Element contains the frequencies and a binary tree.
     */
    public Element makeHuffmanTree(int[] a) {
        PQHeap pq = new PQHeap(a.length);
        for (int i = 0; i < a.length; i++) {
            BinaryTree db = new BinaryTree();
            db.insertRoot(i);
            pq.insert(new Element(a[i], db));
        }

        for (int i = 1; i < a.length; i++) {
            Element x = pq.extractMin();
            Element y = pq.extractMin();
            int zFreq = x.getFrequency() + y.getFrequency();

            BinaryTree min = (BinaryTree) x.getData();
            BinaryTree secondMin = (BinaryTree) y.getData();

            BinaryTree z = new BinaryTree();

            z.insertTree(new Node(), min.getRoot(), secondMin.getRoot());

            pq.insert(new Element(zFreq, z));
        }
        return pq.extractMin();
    }
}
