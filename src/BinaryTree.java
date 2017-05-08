import java.util.Arrays;

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
     * Inserts the root in the tree.
     *
     * @param key the note that will become the root.
     */
    public void insertRoot(int key) {
        size++;
        Node newNode = new Node(key);
        root = newNode;
    }

    public String[] orderedTraversal(int StringArraySize) {
        String[] nodes = new String[StringArraySize];
        i = 0;
        return inorderTreeWalk(root,"", nodes);
    }

    private String[] inorderTreeWalk(Node x, String ByteCode, String[] arrayPass) {
        if (x != null) {
            inorderTreeWalk(x.getLeftChild(), ByteCode + "0", arrayPass);

            if (x.getKey() != null) {
                arrayPass[x.getKey()] = ByteCode;
            }
            inorderTreeWalk(x.getRightChild(), ByteCode + "1", arrayPass);
        }
        return arrayPass;
    }

    @Override
    public String toString() {
        return "BinaryTree{" + " size= " + 256 + ", Huffman codes= " + Arrays.toString(orderedTraversal(256)) + '}';
    }
}
