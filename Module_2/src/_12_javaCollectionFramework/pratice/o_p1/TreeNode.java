package _12_javaCollectionFramework.pratice.o_p1;

public class TreeNode<E> {
    protected E element;
    protected  TreeNode<E> left;
    protected  TreeNode<E> right;

    public TreeNode(E element) {
        this.element = element;
    }
}
