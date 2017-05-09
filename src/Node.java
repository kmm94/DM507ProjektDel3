/**
 * Created by karim møller(karmo15) and Mads Berggreen(madbe15) on 23-02-2017.
 */
public class Node {

    private Node leftChild = null;
    private Node rightChild = null;
    private Integer key;

    /**
     * Is used to set the key value.
     * @param key the hey integer value.
     */
    public Node(int key) {
        this.key = key;
    }

    public Node() {

    }

    /**
     * Returns the leftmost child of a node.
     *
     * @return leftChild
     */
    public Node getLeftChild() {
        return leftChild;
    }

    /**
     * Sets the leftmost childe of a node.
     *
     * @param leftChild
     */
    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    /**
     * Returns the rightmost child of a node.
     *
     * @return rightChild
     */
    public Node getRightChild() {
        return rightChild;
    }

    /**
     * Sets the rightmost child of a node.
     *
     * @param rightChild
     */
    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    /**
     * Returns the frequency.
     *
     * @return frequency
     */
    public Integer getKey() {
        return key;
    }
}
