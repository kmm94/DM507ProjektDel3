import java.util.Arrays;

/**
 * Created by karim møller(karmo15) and Mads Berggreen(madbe15) on 23-02-2017.
 */
public class Frequency {

    private int[] ByteFrequencys;
    private int numberOfDifferentBytes = 256;

    public Frequency() {
        ByteFrequencys = new int[numberOfDifferentBytes];
    }

    public int getLength() {
        return ByteFrequencys.length;
    }

    /**
     * Is used set the frequency of a specific byte with a specific amount.
     *
     * @param index The byte value.
     * @param value The value for the byte's frequency.
     */
    public void set(int index, int value) {
        ByteFrequencys[index] = value;
    }

    /**
     * Is used to increment a byte's frequency
     * @param i The byte that will be incremented
     */
    public void add(int i) {
        ByteFrequencys[i]++;
    }

    /**
     * Gets the frequency array.
     * @return The int array with the frequency for each byte variable.
     */
    public int[] getFrequency() {
        return ByteFrequencys;
    }

    @Override
    public String toString() {
        return "Frequency{" + "ByteFrequencys= " + Arrays.toString(ByteFrequencys) + '}';
    }
}
