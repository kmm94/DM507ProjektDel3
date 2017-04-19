package dm507projekt3;

import javax.management.Query;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by karim møller on 10-04-2017.
 */
public class Encode {
    public static void main(String[] args) throws IOException {
        FileInputStream inFile = new FileInputStream(args[0]);
//        FileOutputStream outFile = new FileOutputStream(args[1]);
        System.out.println(inFile.read());
    }

}
