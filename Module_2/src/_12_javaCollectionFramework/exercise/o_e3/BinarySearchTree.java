package _12_javaCollectionFramework.exercise.o_e3;

public class BinarySearchTree {
    class Node {
        int key;
        Node left, right;
        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
    Node root;
    BinarySearchTree() {
        root = null;
    }

    void inorderRec( Node root) {
        if( root != null) {
            inorderRec(root.left);
            System.out.println(root.key+", ");
            inorderRec(root.right);
        }
    }

}
