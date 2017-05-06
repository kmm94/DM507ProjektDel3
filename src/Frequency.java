import java.util.Arrays;

/**
 * Created by karim møller(karmo15) and Mads Berggreen(madbe15) on 23-02-2017.
 */
public class Frequency {

    private int[] LetterFrequency;

    public Frequency() {
        LetterFrequency = new int[256];
    }

    public int getLength() {
        return LetterFrequency.length;
    }

    public void set(int index, int add) {
        LetterFrequency[index] = add;
    }

    public void add(int i) {
        LetterFrequency[i]++;
    }

    public int[] getFrequency() {
        return LetterFrequency;
    }

    @Override
    public String toString() {
        return "Frequency{" + "LetterFrequency= " + Arrays.toString(LetterFrequency) + '}';
    }
}
