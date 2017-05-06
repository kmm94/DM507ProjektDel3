import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static javafx.util.Duration.seconds;

/**
 * Created by karim møller on 06-05-2017.
 */
public class Decode {
    public static void main(String[] args) throws IOException {

        long startTime = System.nanoTime();
        Frequency fq = new Frequency();

        FileInputStream in = new FileInputStream("src/testCompressed.txt");
        FileOutputStream output = new FileOutputStream("src/testDecompressed.txt");

//        FileInputStream in = new FileInputStream(args[0]);
//        FileOutputStream output = new FileOutputStream(args[1]);


        BitInputStream input = new BitInputStream(in);
        HuffmanTree huff = new HuffmanTree();

        int letterCounter = 0;

        for (int i = 0; i < fq.getFrequency().length; i++) {
            int byteFrequency = input.readInt();
            if (byteFrequency >= 0) {
                fq.set(i, byteFrequency);
                letterCounter += byteFrequency;
            }
        }

        Element e = huff.makeHuffmanTree(fq.getFrequency());
        BinaryTree tree = (BinaryTree) e.getData();


        for (int j = 0; j < letterCounter; j++) {
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

        long endTime = System.nanoTime();
        System.out.println("Time elapsed: " + TimeUnit.SECONDS.convert(endTime - startTime, TimeUnit.NANOSECONDS) + " seconds");

    }
}
