package _12_javaCollectionFramework.exercise.e1_LinkedList;

public class MainLinkedList {
    public static void main(String[] args) {

        ProductManagerLinkedList list = new ProductManagerLinkedList();
        list.add();
        list.add();
        list.display();
        System.out.println("--------");
        list.sortMoneyDown();
        list.display();
        System.out.println("--------");
        list.sortMoneyUp();
        list.display();
        System.out.println("--------");

        list.remove(2);
        list.display();

    }
}
