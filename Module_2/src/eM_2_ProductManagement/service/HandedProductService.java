package exerciseMore.service;

import exerciseMore.models.GenuineProduct;
import exerciseMore.models.HandedProduct;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HandedProductService implements ProductService {
     public static List<HandedProduct> handedProductServiceList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public void readFileHanded() {
        try {
            File file = new File("exerciseMore/data/handedProductList.csv");
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fr = new FileReader("exerciseMore/data/handedProductList.csv");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                } else {
                    String[] strings = line.split(",");
                    HandedProduct product = new HandedProduct();
                    product.setId(Integer.parseInt(strings[0]));
                    product.setName(strings[1]);
                    product.setPrice(Integer.parseInt(strings[2]));
                    product.setProducer(strings[3]);
                    product.setCountry(strings[4]);
                    product.setStatus(Integer.parseInt(strings[5]));
                    handedProductServiceList.add(product);
                }
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void add() {
        int id = GenuineProductService.genuineProductList.size() + handedProductServiceList.size() +1;
        System.out.println("Nhập tên:");
        String name = scanner.nextLine();
        System.out.println("Nhập giá:");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập nhà sản xuất:");
        String producer = scanner.nextLine();
        System.out.println("Nhập quốc gia:");
        String country = scanner.nextLine();
        System.out.println("Nhập trạng thái sản phẩm");
        int status = Integer.parseInt(scanner.nextLine());
        HandedProduct product = new HandedProduct(id,name,price,producer,country,status);
        handedProductServiceList.add(product);
    }

    public void writeFile(String path) {
        try{
            File file = new File(path);
            if(!file.exists()) {
                throw new FileNotFoundException();
            }
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            for(HandedProduct product : handedProductServiceList ) {
                bw.write(product.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        boolean check = true;
            for(HandedProduct product : handedProductServiceList) {
                if(product.getId() == id) {
                    handedProductServiceList.remove(product);
                    check = false;
                    break;
                }
            }
            if(check) {
                System.out.println("không tìm thấy sản phẩm");
            }
    }

    @Override
    public void display() {
        if(handedProductServiceList.size() == 0) {
            System.out.println("chưa có sản phẩm xách tay nào:");
        }else {
            System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s%n", "ID", "NAME", "PRICE", "MANUFACTURE", "COUNTRY", "STATUS");
            for (HandedProduct product : handedProductServiceList) {
                System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s%n", product.getId(), product.getName(), product.getPrice(), product.getProducer(), product.getCountry(), product.getStatus());
            }
        }
    }

    @Override
    public void search(String name) {
        boolean check = true;
        for (HandedProduct product : handedProductServiceList) {
            if (product.getName().equals(name)) {
                System.out.println(product.toString());
                check = false;
            }
        }
        if (check) {
            System.out.println("Không tìm thấy sản phẩm.");
        }
    }
}
