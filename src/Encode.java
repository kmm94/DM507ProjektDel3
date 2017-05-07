import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by karim møller(karmo15) and Mads Berggreen(madbe15) on 23-02-2017.
 */
public class Encode {

    public static void main(String[] args) throws IOException {

        long startTime = System.nanoTime(); //start Time

        Frequency frequencyTable = new Frequency();
        HuffmanTree huffmanUtil = new HuffmanTree();
//      For cmd line:
//      FileInputStream inFile = new FileInputStream(args[0]);
//      FileInputStream inputFile = new FileInputStream(args[0]);
//      FileOutputStream outFile = new FileOutputStream(args[1]);

//      For IDE easy input:
        FileInputStream inFile = new FileInputStream("src/test.txt");
        FileInputStream inputFile = new FileInputStream("src/test.txt");
        FileOutputStream outFile = new FileOutputStream("src/testCompressed.txt");


        BitOutputStream output = new BitOutputStream(outFile);

        //To Read every letter to make a frequencyTable table where A = 65 ++ and so on.
        int oneByte = inFile.read();
        while (oneByte != -1) {
            frequencyTable.increment(oneByte);
            oneByte = inFile.read();
        }
        inFile.close();


        Element element = huffmanUtil.makeHuffmanTree(frequencyTable.getFrequency());
        BinaryTree tree = (BinaryTree) element.getData();
        String[] huffmanCodes = tree.orderedTraversal(frequencyTable.getLength());

        for (int bitFrequency : frequencyTable.getFrequency()) {
            output.writeInt(bitFrequency);
        }


        int aByte = inputFile.read();
        while (aByte != -1) {
            for (char ch : huffmanCodes[aByte].toCharArray()) {
                output.writeBit(Character.getNumericValue(ch));
            }
            aByte = inputFile.read();
        }
        inputFile.close();
        output.close();

        long endTime = System.nanoTime();
        System.out.println("Time elapsed: " + TimeUnit.SECONDS.convert(endTime - startTime, TimeUnit.NANOSECONDS) + " seconds");
    }

}
