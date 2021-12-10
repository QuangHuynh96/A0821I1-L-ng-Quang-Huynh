package _17_binaryFile_Serialization.exercise.product_Management;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class ProductManager {
     ArrayList<Product> list = new ArrayList<Product>();

    void add() {
        Scanner input = new Scanner(System.in);
        Product product = new Product();
        product.setId(list.size() + 1);
        System.out.println("Nhập tên sản phẩm:");
        product.setName(input.nextLine());
        System.out.println("Nhập hãng sản xuất:");
        product.setManufacturer(input.nextLine());
        System.out.println("Nhập giá sản phẩm:");
        product.setPrice(Double.parseDouble(input.nextLine()));
        //thêm mới tự chọn trạng thái 1 -> có hàng!
        product.setStatus(1);
        list.add(product);
        System.out.println("Thêm sản phẩm thành công!");
    }

    void search(int id) {
        boolean check = true;
        for( Product i : list) {
            if( id == i.getId()) {
                System.out.println(i.toString());
                check = false;
                break;
            }
        }
        if(check)
            System.out.println("không tìm thấy sản phẩm.");
    }

    void display() {
        if(list.size() > 0) {
            for (Product i : list) {
                System.out.println(i.toString());
            }
        }else {
            System.out.println("Chưa có sản phẩm nào!");
        }
    }

     void writeFile(String path) {
        try {
            FileOutputStream fos = new FileOutputStream("_17_binaryFile_Serialization/exercise/product_Management/"+ path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     void readFile(String Path) {
         ArrayList<Product> list2 = new ArrayList<Product>();
        try {
            FileInputStream fis = new FileInputStream(Path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list2 = (ArrayList<Product>) ois.readObject();
            list.addAll(list2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    void clear() {
        list.clear();
    }
 }
