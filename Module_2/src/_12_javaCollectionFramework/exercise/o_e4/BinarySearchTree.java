package _12_javaCollectionFramework.exercise.o_e4;

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

//    cách 1 dùng đệ qui.
//    void Search(int key) {
//        root = Searchder(root,key);
//        if(root != null) {
//            System.out.println(root.key);
//        }else {
//            System.out.println("Find is not key");
//        }
//    }
//
//    public Node Searchder(Node root, int key){
//        if(root == null || root.key == key ){
//            return root;
//        }
//        if(key < root.key) {
//            return Searchder(root.left, key);
//        }else {
//            return Searchder(root.right, key);
//        }
//    }
// cách 2
    public boolean Find( Node root, int key){
        Node current= root;
        while(current != null) {
            if( current.key == key) {
                return true;
            }
            if( key < current.key) {
                current= current.left;
            }else {
                current= current.right;
            }
        }
        return false;
    }
}
