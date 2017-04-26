/**
 * Created by karim møller on 10-04-2017.
 */
public class HuffmanTree {

    private PQHeap pq =null;

    public void makeHuffmanTree(int[] a){
        pq = new PQHeap(256);
        for (int i =0; i < a.length; i++) {
            pq.insert(new Element(a[i], new Node(i)));
        }
        System.out.println(HuffmanTree(pq).frequency);
    }

    private Element HuffmanTree(PQHeap c){
        for(int i = 1; i < 255; i++){
            Element x = c.extractMin();
            Element y = c.extractMin();
            int zFreq = x.frequency + y.frequency;
            Node z = new Node((Node) x.data,(Node) y.data, zFreq);
            pq.insert(new Element(zFreq,z));
        }
        return c.extractMin();
    }

}
