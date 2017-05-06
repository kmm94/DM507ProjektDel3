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

//        FileInputStream in = new FileInputStream("src/outCompressed.txt");
//        FileOutputStream output = new FileOutputStream("src/TestDecompressed.txt");

        FileInputStream in = new FileInputStream(args[0]);
        FileOutputStream output = new FileOutputStream(args[1]);


        BitInputStream input = new BitInputStream(in);

        HuffmanTree huff = new HuffmanTree();
        int[] freq = new int[255];

        int bitCount = 0;

        for (int i = 0; i < freq.length; i++) {
            int k = input.readInt();
            if (k >= 0) {
                freq[i] = k;
                bitCount += k;
            }
        }

        Element e = huff.makeHuffmanTree(freq);
        BinaryTree tree = (BinaryTree) e.getData();



        for (int j = 0; j < bitCount; j++) {
            Node currentNode = tree.getRoot();
            while (currentNode.getLeftChild() != null ) {
                int bit = input.readBit();
                if (bit == 0) {
                    currentNode = currentNode.getLeftChild();
                } else {
                    currentNode = currentNode.getRightChild();
                }
            }

            output.write(currentNode.getAscii());
        }
        input.close();
        output.close();
    }
}
