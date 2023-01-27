package search;

public class BinarySearchTreeNLR {
    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    BinarySearchTreeNLR() {
        root = null;
    }

    Node insertRecursive(Node root, int key) {
        if (root == null)
            return new Node(key);
        else if (key < root.key)
            root.left = insertRecursive(root.left, key);
        else if (key > root.key)
            root.right = insertRecursive(root.right, key);
        return root;
    }

    public void inorder() {
        inorderRecursive(root);
    }

    public void insert(int key) {
        root = insertRecursive(root, key);
    }

    private void inorderRecursive(Node root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.println(root.key);
            inorderRecursive(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTreeNLR tree = new BinarySearchTreeNLR();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // print inorder traversal of the BST
        tree.inorder();
    }


}
