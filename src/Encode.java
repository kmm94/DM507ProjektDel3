



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by karim møller on 10-04-2017.
 */
public class Encode {
    public static void main(String[] args) throws IOException {

        Freqvenzy fq = new Freqvenzy();

        FileInputStream inFile = new FileInputStream(args[0]);
        FileOutputStream outFile = new FileOutputStream(args[1]);

        int i = inFile.read();

        while(i != -1){
            fq.add(i);
        }
        fq.toString();

    }

}
