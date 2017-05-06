/**
 * Created by karim møller(karmo15) and Mads Berggreen(madbe15) on 23-02-2017.
 */
public class HuffmanTree {


    public Element makeHuffmanTree(int[] a) {
        PQHeap pq = new PQHeap(256);
        for (int i = 0; i < a.length; i++) {
            BinaryTree db = new BinaryTree();
            db.insert(a[i], i);
            pq.insert(new Element(a[i], db));
        }

        for (int i = 1; i < 256; i++) {
            Element x = pq.extractMin();
            Element y = pq.extractMin();
            int zFreq = x.getFrequency() + y.getFrequency();

            BinaryTree min = (BinaryTree) x.getData();
            BinaryTree secondmin = (BinaryTree) y.getData();

            BinaryTree z = new BinaryTree();

            z.insertTree(new Node(zFreq), min.getRoot(),secondmin.getRoot());

            pq.insert(new Element(zFreq, z));
        }


        return pq.extractMin();
    }


}
