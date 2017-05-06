

import java.util.Arrays;

/**
 * Created by karim mÃ¸ller on 10-04-2017.
 */
public class Frequency {

    private int[] feq;

    public Frequency() {
        feq = new int[256];
    }

    public void add(int i){
        feq[i] ++;
    }

    public int[] getFrequency(){
        return feq;
    }

    @Override
    public String toString() {
        return "Frequency{" + "feq=" + Arrays.toString(feq) + '}';
    }
}
