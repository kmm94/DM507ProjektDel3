/**
 * Created by karim møller(karmo15) and Mads Berggreen(madbe15) on 23-02-2017.
 */
public class BinaryTree {

    private Node root;
    private int size = 0;
    private int i = 0;


    public BinaryTree() {
        root = null;
    }


    public void insertTree(Node root, Node leftChild, Node rightChild) {
        this.root = root;
        root.setLeftChild(leftChild);
        root.setRightChild(rightChild);
    }

    public Node getRoot() {
        return root;
    }

    /**
     * Inserts the nodes in the tree.
     *
     * @param key the note that will be inserted.
     */

    public void insert(int key, int bytevalue) {
        size++;
        Node newNode = new Node(key);
        newNode.setByteIntValue(bytevalue);
        Node y = null;
        Node x = root;
        while (x != null) { //is seraching for a place for the new node
            y = x;
            if (newNode.getKey() < x.getKey()) {
                x = x.getLeftChild();
            } else {
                x = x.getRightChild();
            }
        }
        if (y == null) { // if root is empty
            root = newNode;
        } else if (newNode.getKey() < y.getKey()) { //inserting the new note
            y.setLeftChild(newNode);
        } else {
            y.setRightChild(newNode);
        }
    }


    public String[] orderedTraversal(int StringArraySize) {
        String[] nodes = new String[StringArraySize];
        i = 0;
        return inorderTreeWalk(root,"", nodes);
    }

    private String[] inorderTreeWalk(Node x, String sBit, String[] arrayPass) {
        if (x != null) {
            inorderTreeWalk(x.getLeftChild(), sBit + "0", arrayPass);

            if (x.getByteIntValue() != -1) {
                arrayPass[x.getByteIntValue()] = sBit;
            }
            inorderTreeWalk(x.getRightChild(), sBit + "1", arrayPass);
        }
        return arrayPass;
    }
}
