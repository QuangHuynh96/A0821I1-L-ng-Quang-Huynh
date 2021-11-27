package _12_javaCollectionFramework.exercise.o_e1;

public class BinarySearchTree {
    Node root;
    class Node {
        int key;
        BinarySearchTree.Node left;
        BinarySearchTree.Node right;
        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
    // Constructor
    BinarySearchTree() {
        root = null;
    }
    void inorder() {
        inorderRec(root);
        System.out.println(root.key);
    }

    void inorderRec( Node root) {
        if( root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

}
