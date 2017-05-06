import java.util.Arrays;

/**
 * Created by karim møller(karmo15) and Mads Berggreen(madbe15) on 23-02-2017.
 */
public class Frequency {

    private int[] Letterfrequency;

    public Frequency() {
        Letterfrequency = new int[256];
    }

    public int getLength() {
        return Letterfrequency.length;
    }

    public void set(int index, int add) {
        Letterfrequency[index] = add;
    }

    public void add(int i) {
        Letterfrequency[i]++;
    }

    public int[] getFrequency() {
        return Letterfrequency;
    }

    @Override
    public String toString() {
        return "Frequency{" + "Letterfrequency= " + Arrays.toString(Letterfrequency) + '}';
    }
}
