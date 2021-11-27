package _12_javaCollectionFramework.exercise.e1_LinkedList;

import _12_javaCollectionFramework.exercise.e1_ArrayLisst.Product;
import _12_javaCollectionFramework.exercise.e1_ArrayLisst.SorfMoneyProductUp;
import _12_javaCollectionFramework.exercise.e1_ArrayLisst.SortMoneyProductDown;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class ProductManagerLinkedList {
    LinkedList<Product> linkedList;

    public ProductManagerLinkedList() {
        linkedList = new LinkedList<Product>();
    }
//  thêm sản phẩm.
    public void add() {// tạo inpt scanner.
        Product product= new Product();
        System.out.println("Nhập tên sản phẩm:");
        product.setName(new Scanner(System.in).nextLine());
        System.out.println("Nhập id sản phẩm: ");
        product.setId(new Scanner(System.in).nextInt());
        System.out.println("Nhập năm sản xuất:");
        product.setDuration(new Scanner(System.in).nextInt());
        System.out.println("Nhập giá sản phẩm: ");
        product.setPrice(new Scanner(System.in).nextInt());
        linkedList.add(product);
    }
//  sửa sản phẩm.
    public void set(int id) {
        boolean check= true;
        for(Product product : linkedList) {
            if(product.getId()== id) {
                int input;
                check= false;
                do {
                    System.out.println("1. sửa tên");
                    System.out.println("2. sửa id");
                    System.out.println("3. sửa năm");
                    System.out.println("4. sửa giá");
                    System.out.println("5. thoát");
                    input = new Scanner(System.in).nextInt();
                    if (input == 1) {
                        System.out.println("Nhập tên mới: ");
                        product.setName(new Scanner(System.in).nextLine());
                    }
                    if (input == 2) {
                        System.out.println("Nhập tên id mới: ");
                        product.setId(new Scanner(System.in).nextInt());
                    }
                    if (input == 3) {
                        System.out.println("Nhập năm sản xuất: ");
                        product.setDuration(new Scanner(System.in).nextInt());
                    }
                    if(input == 4) {
                        System.out.println("Nhập giá: ");
                        product.setPrice(new Scanner(System.in).nextInt());
                    }
                }while(input != 5);
            }
        }if(check)
            System.out.println("Id not found.");
    }
//  xóa sản phẩm.
    public void remove(int id) {
        for(Product product : linkedList) {
            if(product.getId()== id) {
                linkedList.remove(product);
                break;
            }
        }
    }
//  check rỗng.
    public boolean isEmpty() {
        boolean check = false;
        if(linkedList.size() == 0)
            check = true;
        return check;
    }
//  tìm sản phẩm.
    public Product find(String name) {
        for(Product product : linkedList) {
            if(product.getName().equals(name)) {
                return product;
            }
        }return null;
    }
//  hiển thị danh sách sản phẩm.
    public void display() {
        linkedList.forEach(e -> {
            System.out.println("product: name= "+e.getName()+
                    ", id= "+e.getId()+", year= "+e.getDuration()+", money= "+e.getPrice());
        });
    }
//  sắp xếp theo giá tăng dần.
    public void sortMoneyUp() {
        Collections.sort(linkedList, new SorfMoneyProductUp());
    }
//  sắp xếp theo giá giảm dần.
    public void sortMoneyDown() {
        Collections.sort(linkedList,new SortMoneyProductDown());
    }
}
