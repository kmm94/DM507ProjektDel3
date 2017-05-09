import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by karim møller(karmo15) and Mads Berggreen(madbe15) on 23-02-2017.
 */
public class Decode {

    /**
     * This main-method will decode a file.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        final int AMOUNT_OF_DIFFERENT_BYTES = 256;

        long startTime = System.nanoTime();

//      For CMD:
        FileInputStream in = new FileInputStream(args[0]);
        FileOutputStream output = new FileOutputStream(args[1]);

        Frequency frequencyTable = new Frequency(AMOUNT_OF_DIFFERENT_BYTES);
        BitInputStream input = new BitInputStream(in);
        HuffmanTree huffTree = new HuffmanTree();

        int byteCounter = 0;
        // For loop that will read the input and assign the ints from the input as the frequency of bytes.
        for (int index = 0; index < frequencyTable.getLength(); index++) {
            int byteFrequency = input.readInt();
            // If byteFrequency is greater than or equals 0 the byteFrequency is then set in a Frequency.
            // If byteFrequency is less than 0 then a exception will be thrown.

            if (byteFrequency >= 0) {
                frequencyTable.set(index, byteFrequency);
                byteCounter += byteFrequency;
            } else {
                throw new IllegalArgumentException("Read input was negative");
            }
        }

        Element element = huffTree.makeHuffmanTree(frequencyTable.getFrequencys());
        BinaryTree tree = (BinaryTree) element.getData();

        /*The for loop will make the current node equals to the root of the tree,
          and while the current node has a leftmost child then the bits of the
          input will be read. If the bit is equals to 0 then the current node
          is set to the leftmost child. If the bit is equals to 1 then the current
          node is set to the rightmost child. Lastly the key of the current node
          is written to the output.
         */
        for (int i = 0; i < byteCounter; i++) {
            Node currentNode = tree.getRoot();
            while (currentNode.getLeftChild() != null) {
                int bit = input.readBit();
                if (bit == 0) {
                    currentNode = currentNode.getLeftChild();
                } else {
                    currentNode = currentNode.getRightChild();
                }
            }
            output.write(currentNode.getKey());
        }
        //Both the input and the output streams are cloded.
        input.close();
        output.close();
        long endTime = System.nanoTime();
        System.out.println("Done! Time elapsed: " + TimeUnit.SECONDS.convert(endTime - startTime, TimeUnit.NANOSECONDS) + " seconds");
    }
}