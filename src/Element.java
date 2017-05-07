/**
 * Created by karim møller(karmo15) and Mads Berggreen(madbe15) on 23-02-2017.
 */
public class Element {
    private int frequency;
    private Object data;

    public Element(int i, Object o) {
        this.frequency = i;
        this.data = o;
    }

    public int getFrequency() {
        return frequency;
    }

    public Object getData() {
        return data;
    }

}
