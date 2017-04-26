/**
 * Created by karim møller on 10-04-2017.
 */
public class HuffmanTree {

    private PQHeap pq =null;
    private Element root = null;

    public void makeHuffmanTree(int[] a){
        pq = new PQHeap(256);
        for (int i =0; i < a.length; i++) {
            pq.insert(new Element(a[i], new Node(i)));
        }
        root = HuffmanTree(pq);
        System.out.println(root.frequency); //test
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
    /**
     * Private method that traverses the tree inorder hereby sorting it.
     *
     * @param x Parent node
     * @param a The int array that the key will be placed ind.
     * @return The int array with the key in.
     */
    private int[] inorderTreeWalk(Node x, int[] a) {

        if (x != null) {
            inorderTreeWalk(x.getLeftChild(), a);
            a[i] = x.getKey();
            i++;
            inorderTreeWalk(x.getRightChild(), a);
        }
        return a;
    }

}
