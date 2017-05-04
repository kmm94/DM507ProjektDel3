/**
 * Created by karim møller on 10-04-2017.
 */
public class HuffmanTree {

    private PQHeap pq = null;


    public Element makeHuffmanTree(int[] a) {
        pq = new PQHeap(255);
        for (int i = 0; i < a.length; i++) {
            BinaryTree db = new BinaryTree();
            db.insert(i);
            pq.insert(new Element(a[i], db));
        }
        
        for (int i = 1; i < 255; i++) {
            Element x = pq.extractMin();
            Element y = pq.extractMin();
            int zFreq = x.getFrequency() + y.getFrequency();
            BinaryTree z = new BinaryTree();


            pq.insert(new Element(zFreq, z));
        }
        
        System.out.println(pq.extractMin().getFrequency());
        return pq.extractMin();
    }




}
