import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by karim møller on 10-04-2017.
 */
public class Encode {
    public static void main(String[] args) throws IOException {

        Frequency fq = new Frequency();

        HuffmanTree huff = new HuffmanTree();

//        FileInputStream inFile = new FileInputStream(args[0]);
//        FileOutputStream outFile = new FileOutputStream(args[1]);
        FileInputStream inFile = new FileInputStream("src/test.txt");
        FileInputStream inFile2 = new FileInputStream("src/test.txt");
        FileOutputStream outFile = new FileOutputStream("src/out.txt");
//        FileOutputStream outFile = new FileOutputStream(args[1]);

        BitOutputStream output = new BitOutputStream(outFile);

        //To Read every letter and make a frequency table where A = 65 and so on.
        int i = inFile.read();
        while (i != -1) {
            fq.add(i);
            i = inFile.read();
        }
        inFile.close();


        System.out.println(fq.toString());
        Element huffTree = huff.makeHuffmanTree(fq.getFrequency());
        BinaryTree b = (BinaryTree) huffTree.getData();
        String[] s = b.orderedTraversal();
        System.out.println(Arrays.toString(s));


        int k = inFile2.read();
        while (k != -1) {
            System.out.println("kodeord: " + s[k] + " input nr: " + k);
            k = inFile2.read();
        }
        inFile2.close();
    }

}
