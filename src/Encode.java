import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by karim møller on 10-04-2017.
 */
public class Encode {

    public static final int ARRAY_LENGTH = 255;

    public static void main(String[] args) throws IOException {

        Frequency fq = new Frequency();

        HuffmanTree huff = new HuffmanTree();

//      FileInputStream inFile = new FileInputStream(args[0]);
//      FileInputStream inFile2 = new FileInputStream(args[0]);
//      FileOutputStream outFile = new FileOutputStream(args[1]);
        FileInputStream inFile = new FileInputStream("src/test2.docx");
        FileInputStream inFile2 = new FileInputStream("src/test2.docx");
        FileOutputStream outFile = new FileOutputStream("src/Compressed.docx");


        BitOutputStream output = new BitOutputStream(outFile);

        //To Read every letter and make a frequency table where A = 65 and so on.
        int i = inFile.read();
        while (i != -1) {
            fq.add(i);
            i = inFile.read();
        }
        inFile.close();


        Element huffTree = huff.makeHuffmanTree(fq.getFrequency());

        BinaryTree b = (BinaryTree) huffTree.getData();

        String[] huffmanCodes = b.orderedTraversal();

        for (int j : fq.getFrequency()) {
            output.writeInt(j);
        }


        int k = inFile2.read();
        while (k != -1) {
            for (char ch : huffmanCodes[k].toCharArray()) {
                output.writeBit(Character.getNumericValue(ch));
            }
            k = inFile2.read();
        }
        inFile2.close();
        output.close();
        outFile.close();
    }

}
