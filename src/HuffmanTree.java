/**
 * Created by karim møller on 10-04-2017.
 */
public class HuffmanTree {

    private PQHeap pq = null;


    public void makeHuffmanTree(int[] a) {
        pq = new PQHeap(256);
        for (int i = 0; i < a.length; i++) {
            DictBinTree db = new DictBinTree();
            db.insert(i);
            pq.insert(new Element(a[i], db));
            HuffmanTree(pq);
            System.out.println(pq.extractMin().getFrequency());
        }
    }

    private void HuffmanTree(PQHeap c) {
        for (int i = 1; i < 255; i++) {
            Element x = c.extractMin();
            Element y = c.extractMin();
            int zFreq = x.getFrequency() + y.getFrequency();

            DictBinTree xx = (DictBinTree) x.getData();
            DictBinTree yy = (DictBinTree) y.getData();
            DictBinTree z = new DictBinTree();

            for (int j : xx.orderedTraversal()) {
                z.insert(j);
            }

            for (int j : yy.orderedTraversal()) {
                z.insert(j);
            }

            pq.insert(new Element(zFreq, z));
        }
    }

    /**
     * Private method that traverses the tree inorder hereby sorting it.
     *
     * @param x Parent node
     * @param a The int array that the key will be placed ind.
     * @return The int array with the key in.
     */
//    private int[] inorderTreeWalk(Node x, int[] a) {
//
//        if (x != null) {
//            inorderTreeWalk(x.getLeftChild(), a);
//            a[i] = x.getKey();
//            i++;
//            inorderTreeWalk(x.getRightChild(), a);
//        }
//        return a;
//    }

}
