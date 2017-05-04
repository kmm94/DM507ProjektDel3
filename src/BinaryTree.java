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

    public void insert(int key, int ascii) {
        size++;
        Node newNode = new Node(key);
        newNode.setAscii(ascii);
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



//    /**
//     * Traverses through the tree in inorder.
//     *
//     * @return A int Array that contains all the key.
//     */
//
//    public int[] orderedTraversal() {
//        int[] nodes = new int[size];
//        i = 0;
//        return inorderTreeWalk(root, nodes);
//    }

    public String[] orderedTraversal() {
        String[] nodes = new String[255];
        i = 0;
        return inorderTreeWalk(root,"", nodes);
    }

    public String[] inorderTreeWalk(Node x, String sBit, String[] arrayPass) {
        if (x != null) {
            inorderTreeWalk(x.getLeftChild(), sBit + "0", arrayPass);

            if (x.getAscii() != -1) {
                arrayPass[x.getAscii()] = sBit;
            }

            inorderTreeWalk(x.getRightChild(), sBit + "1", arrayPass);
        }
        return arrayPass;
    }


//    /**
//     * Private method that traverses the tree inorder hereby sorting it.
//     *
//     * @param x Parent node
//     * @param a The int array that the key will be placed ind.
//     * @return The int array with the key in.
//     */
//    private int[] inorderTreeWalk(Node x, int[] a) {
//
//        if (x != null) {
//            inorderTreeWalk(x.getLeftChild(), a);
//            a[i] = x.getKey();
//            i++;
//            inorderTreeWalk(x.getRightChild(), a);
//        }
//        return a;
//    }

    /**
     * Searches the tree for the nodes using the private method treeSearch().
     *
     * @param key The key that will be searched for.
     * @return True if the Key exists in the tree else false.
     */

    public boolean search(int key) {
        if (treeSearch(root, key) == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Private method that searches the tree for nodes.
     *
     * @param x   Parent key
     * @param key The key that will be searched for.
     * @return The node if it exists.
     */
    private Node treeSearch(Node x, int key) {

        if (x == null || key == x.getKey()) {
            return x;
        }
        if (key < x.getKey()) {

            return treeSearch(x.getLeftChild(), key);
        } else {
            return treeSearch(x.getRightChild(), key);

        }
    }

}
