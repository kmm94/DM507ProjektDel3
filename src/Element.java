/**
 * Created by karim Møller(karmo15) and Mads Berggreen(madbe15).
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
