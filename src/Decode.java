import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by karim møller on 06-05-2017.
 */
public class Decode {
    public static void main(String[] args) throws IOException {
        Frequency fq = new Frequency();
        FileInputStream in = new FileInputStream("src/outCompressed.txt");
        FileOutputStream output = new FileOutputStream("src/TestDecompressed");
        BitInputStream input = new BitInputStream(in);

        HuffmanTree huff = new HuffmanTree();
        int[] freq = new int[256];

        int bitcount

        for(int i =0; i <256; i++){
            int k = input.readInt();
            if(k <fq.getFrequency().length) {
                freq[i] = k;
            }
        }
        input.close();

        Element e = huff.makeHuffmanTree(freq);
        BinaryTree tree = (BinaryTree) e.getData();

        int bit;

        for (int j = 0; j < byteCount; j++) {
            Node currentNode = tree.getRoot();
            while (currentNode.getLeftChild() != null) {
                bit = input.readBit();
                if (bit == 0) {
                    currentNode = currentNode.getLeftChild();
                } else {
                    currentNode = currentNode.getRightChild();
                }
            }
            output.write(currentNode.getAscii());
        }
    }
}
