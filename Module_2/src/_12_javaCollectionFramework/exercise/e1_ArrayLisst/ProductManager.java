package _12_javaCollectionFramework.exercise.e1_ArrayLisst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductManager {
    ArrayList<Product> listProduct;
    Scanner input = new Scanner(System.in);

    public ProductManager() {
        listProduct = new ArrayList<Product>();
        listProduct.add(new Product(1, "ip",2020,5000));
        listProduct.add(new Product(2, "asam",2020,3000));
        listProduct.add(new Product(3, "cnokia",2020,3000));
        listProduct.add(new Product(4, "vetu",2020,10000));
        listProduct.add(new Product(5, "bbphone",2020,3000));
        listProduct.add(new Product(6, "bbVìnfast",2020,3000));
        listProduct.add(new Product(7, "bbVinamilk",2020,3000));
    }

//  thêm sản phẩm.
    public void add() {
        Product product = new Product();

        System.out.println("Nhập tên sản phẩm:");
        product.setName(input.nextLine());

        product.setId(listProduct.size()+1);

        System.out.println("Nhập năm sản xuất:");
        product.setDuration(Integer.parseInt(input.nextLine()));

        System.out.println("Nhập giá sản phẩm: ");
        product.setPrice(Integer.parseInt(input.nextLine()));

        listProduct.add(product);
    }
//  sửa sản phẩm.
    public void set(int id) {
        boolean check = true;
        for(Product product : listProduct) {
            if(product.getId()== id) {
                int checkInput= 0;
                check= false;
                do {
                    System.out.println("1. sửa tên");
                    System.out.println("2. sửa id");
                    System.out.println("3. sửa niên hạn");
                    System.out.println("4. sửa giá");
                    System.out.println("5. thoát");
                    checkInput = new Scanner(System.in).nextInt();
                    if (checkInput == 1) {
                        System.out.println("Nhập tên mới: ");
                        product.setName(input.nextLine());
                    }
                    if (checkInput == 2) {
                        System.out.println("Nhập tên id mới: ");
                        product.setId(input.nextInt());
                    }
                    if (checkInput == 3) {
                        System.out.println("Nhập năm sản xuất: ");
                        product.setDuration(input.nextInt());
                    }
                    if(checkInput == 4) {
                        System.out.println("Nhập giá: ");
                        product.setPrice(input.nextInt());
                    }
                }while(checkInput != 5);
                if( checkInput == 5)
                    break;
            }
        }if(check)
            System.out.println("không tìm thấy sản phẩm.");
    }
//  xóa sản phẩm.
    public void remove(int id) {
        for(Product product : listProduct) {
            if(product.getId()== id) {
                listProduct.remove(product);
                break;
            }
        }
    }
//  check rỗng.
    public boolean isEmpty() {
        boolean check = false;
        if(listProduct.size() == 0)
            check = true;
        return check;
    }
//  tìm sản phẩm.
    public void find(String name) {
        for(Product product : listProduct) {
            if(product.getName().contains(name)) {// đổi thành contains trả danh sách.
                System.out.println(product.toString());
            }
        };
    }
//  hiển thị danh sách sản phẩm.
    public void display() {
        listProduct.forEach(e -> {//lambda
            System.out.println("product: name= "+e.getName()+"," +
                    " id= "+e.getId()+", year= "+e.getDuration()+", money= "+e.getPrice());
        });
    }
//  sắp xếp theo giá tăng dần( giá bằng nhau thì sort theo Name).
    public void sortMoneyUp() {
        Collections.sort(listProduct, new SorfMoneyProductUp());
    }
//  sắp xếp theo giá giảm dần( giá bằng nhau thì sort theo Name).
    public void sortMoneyDown() {
        Collections.sort(listProduct,new SortMoneyProductDown());
    }

}
