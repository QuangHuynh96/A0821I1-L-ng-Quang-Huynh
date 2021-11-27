package _12_javaCollectionFramework.exercise.e1_ArrayLisst;

public class homeView {
    public static void main(String[] args) {

        ProductManager list = new ProductManager();
//        list.add();
//        list.add();
        list.display();
        System.out.println("--------");
        //sắp xếp.
        list.sortMoneyDown();
        list.display();
//        System.out.println("--------");
//       //sắp xếp .
//        list.sortMoneyUp();
//        list.display();
        System.out.println("--------");
//        Tìm sửa.
        list.set(2);
        list.display();
//        tiềm kiếm
        list.find("bb");

    }
}
