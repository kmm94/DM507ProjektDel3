/**
 *
 * @author Mads
 */
public class Element {
    private int frequency;
    private Object data;

    public Element(int i, Object o){
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
