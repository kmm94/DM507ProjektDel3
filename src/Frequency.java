/**
 * Created by karim Møller(karmo15) and Mads Berggreen(madbe15).
 */
public class Frequency {

    private int[] byteFrequencys;


    public Frequency(int size) {
        byteFrequencys = new int[size];
    }

    /**
     * The length of the array.
     *
     * @return The length of the array.
     */
    public int getLength() {
        return byteFrequencys.length;
    }

    /**
     * Is used set the frequency of a specific byte with a specific amount.
     *
     * @param index The byte value.
     * @param value The value for the byte's frequency.
     */
    public void set(int index, int value) {
        byteFrequencys[index] = value;
    }

    /**
     * Is used to increment a byte's frequency
     *
     * @param i The byte that will be incremented
     */
    public void increment(int i) {
        byteFrequencys[i]++;
    }

    /**
     * Gets the frequency array.
     *
     * @return The int array with the frequency for each byte variable.
     */
    public int[] getFrequencys() {
        return byteFrequencys;
    }
}
