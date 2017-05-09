import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by karim møller(karmo15) and Mads Berggreen(madbe15) on 23-02-2017.
 */
public class Encode {

    /**
     * This main-method will take a file and encode it by reading the bits and
     * compress these with a HuffmanTree using the Huffman code.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        final int AMOUNT_OF_DIFFERENT_BYTES = 256;

        long startTime = System.nanoTime(); //start Time

//      For cmd line:
        FileInputStream inFile = new FileInputStream(args[0]);
        FileInputStream inputFile = new FileInputStream(args[0]);
        FileOutputStream outFile = new FileOutputStream(args[1]);

        BitOutputStream output = new BitOutputStream(outFile);
        Frequency frequencyTable = new Frequency(AMOUNT_OF_DIFFERENT_BYTES);
        HuffmanTree huffmanUtil = new HuffmanTree();

        //To Read every letter to make a frequencyTable table where A = 65 ++ and so on.
        int oneByte = inFile.read();
        while (oneByte != -1) {
            frequencyTable.increment(oneByte);
            oneByte = inFile.read();
        }
        inFile.close();
        //Here we make the huffman tree
        Element element = huffmanUtil.makeHuffmanTree(frequencyTable.getFrequencys());

        //casting the object in element to a Binarytree
        BinaryTree tree = (BinaryTree) element.getData();

        //Gets the huffman codes an place them in a string array where index 65 contains the bitcode for the byte integer value 65.
        String[] huffmanCodes = tree.orderedTraversal(frequencyTable.getLength());

        //Prints the frequency table to the top of the compressed file
        for (int bitFrequency : frequencyTable.getFrequencys()) {
            output.writeInt(bitFrequency);
        }

        //Here we read a byte from the input file and prints the bytes huffmancode to the compressed file.
        int aByte = inputFile.read();
        while (aByte != -1) {
            for (char ch : huffmanCodes[aByte].toCharArray()) {
                output.writeBit(Character.getNumericValue(ch));
            }
            aByte = inputFile.read();
        }
        inputFile.close();
        output.close();

        long endTime = System.nanoTime(); //End time
        System.out.println("Done! Time elapsed: " + TimeUnit.SECONDS.convert(endTime - startTime, TimeUnit.NANOSECONDS) + " seconds");

    }

}
