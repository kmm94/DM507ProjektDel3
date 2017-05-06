import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Created by karim møller on 10-04-2017.
 */
public class Encode {

    public static void main(String[] args) throws IOException {

        long startTime = System.nanoTime(); //start Time

        Frequency fq = new Frequency();

        HuffmanTree huff = new HuffmanTree();

//      FileInputStream inFile = new FileInputStream(args[0]);
//      FileInputStream inputFile = new FileInputStream(args[0]);
//      FileOutputStream outFile = new FileOutputStream(args[1]);
        FileInputStream inFile = new FileInputStream("src/test.txt");
        FileInputStream inputFile = new FileInputStream("src/test.txt");
        FileOutputStream outFile = new FileOutputStream("src/testCompressed.txt");


        BitOutputStream output = new BitOutputStream(outFile);

        //To Read every letter and make a frequency table where A = 65 and so on.
        int i = inFile.read();
        while (i > -1) {
            fq.add(i);
            i = inFile.read();
        }
        inFile.close();


        Element huffTree = huff.makeHuffmanTree(fq.getFrequency());

        BinaryTree tree = (BinaryTree) huffTree.getData();

        String[] huffmanCodes = tree.orderedTraversal();

        for (int bitFrequency : fq.getFrequency()) {
            output.writeInt(bitFrequency);
        }


        int bytes = inputFile.read();
        while (bytes != -1) {
            for (char ch : huffmanCodes[bytes].toCharArray()) {
                output.writeBit(Character.getNumericValue(ch));
            }
            bytes = inputFile.read();
        }
        inputFile.close();
        output.close();
        outFile.close();

        long endTime = System.nanoTime();

        System.out.println("Time elapsed: " + TimeUnit.SECONDS.convert(endTime - startTime, TimeUnit.NANOSECONDS) + " seconds");


    }

}
