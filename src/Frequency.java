

import java.util.Arrays;

/**
 * Created by karim møller on 10-04-2017.
 */
public class Frequency {

    private int[] feq = new int[255];

    public void add(int i){
        feq[i] ++;
    }

    @Override
    public String toString() {
        return "Frequency{" + "feq=" + Arrays.toString(feq) + '}';
    }
}
