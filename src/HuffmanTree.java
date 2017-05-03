/**
 * Created by karim møller on 10-04-2017.
 */
public class HuffmanTree {

    private PQHeap pq = null;


    public Element makeHuffmanTree(int[] a) {
        pq = new PQHeap(255);
        for (int i = 0; i < a.length; i++) {
            DictBinTree db = new DictBinTree();
            db.insert(i);
            pq.insert(new Element(a[i], db));
        }
        HuffmanTree(pq);
        System.out.println(pq.extractMin().getFrequency());
        return pq.extractMin();
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


}
