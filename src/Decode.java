import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


/**
 * Created by karim møller(karmo15) and Mads Berggreen(madbe15) on 23-02-2017.
 */
public class Decode {
    public static void main(String[] args) throws IOException {

        long startTime = System.nanoTime();

        Frequency frequencyTable = new Frequency();

        FileInputStream in = new FileInputStream("src/testCompressed.txt");
        FileOutputStream output = new FileOutputStream("src/testDecompressed.txt");

//        FileInputStream in = new FileInputStream(args[0]);
//        FileOutputStream output = new FileOutputStream(args[1]);


        BitInputStream input = new BitInputStream(in);
        HuffmanTree huffUtil = new HuffmanTree();

        int byteCounter = 0;

        for (int i = 0; i < frequencyTable.getLength(); i++) {
            int byteFrequency = input.readInt();

            if (byteFrequency >= 0) {
                frequencyTable.set(i, byteFrequency);
                byteCounter += byteFrequency;
            }
        }

        Element element = huffUtil.makeHuffmanTree(frequencyTable.getFrequency());
        BinaryTree tree = (BinaryTree) element.getData();


        for (int j = 0; j < byteCounter; j++) {
            Node currentNode = tree.getRoot();
            while (currentNode.getLeftChild() != null) {
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
