package exerciseMore.service;

import exerciseMore.models.GenuineProduct;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenuineProductService implements ProductService {
    public static List<GenuineProduct> genuineProductList  = new ArrayList<>();
   private static Scanner scanner = new Scanner(System.in);

   public void readFileGenuine() {
       try {
           File file = new File("exerciseMore/data/genuineProductList.csv");
           if (!file.exists()) {
               throw new FileNotFoundException();
           }
           FileReader fr = new FileReader("exerciseMore/data/genuineProductList.csv");
           BufferedReader br = new BufferedReader(fr);
           String line = "";
           while (true) {
               line = br.readLine();
               if (line == null) {
                   break;
               } else {
                   String[] strings = line.split(",");
                   GenuineProduct product = new GenuineProduct();
                   product.setId(Integer.parseInt(strings[0]));
                   product.setName(strings[1]);
                   product.setPrice(Integer.parseInt(strings[2]));
                   product.setProducer(strings[3]);
                   product.setInsurance(Integer.parseInt(strings[4]));
                   genuineProductList.add(product);
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
        int id =HandedProductService.handedProductServiceList.size() + genuineProductList.size() +1;
        System.out.println("Nhập tên:");
        String name = scanner.nextLine();
        System.out.println("Nhập giá:");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập nhà sản xuất:");
        String producer = scanner.nextLine();
        System.out.println("Nhập thời gian bảo hành (tháng):");
        int insurance = Integer.parseInt(scanner.nextLine());
        GenuineProduct product = new GenuineProduct(id,name,price,producer,insurance);
        genuineProductList.add(product);
        writeFile("exerciseMore/data/genuineProductList.csv");
    }

    public void writeFile(String path) {
        try{
            File file = new File(path);
            if(!file.exists()) {
                throw new FileNotFoundException();
            }
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            for(GenuineProduct product : genuineProductList ) {
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
       for(GenuineProduct product : genuineProductList) {
           if(product.getId() == id) {
               genuineProductList.remove(product);
               check = false;
               System.out.println("đã xóa!");
               break;
           }
       }
       if(check) {
           System.out.println("ko tìm thấy sản phẩm.");
       }
    }

    @Override
    public void display() {
        if(genuineProductList.size() == 0) {
            System.out.println("chưa có sản phẩm chính hãng nào:");
        }else {
            System.out.printf("%-10s %-20s %-20s %-20s %-25s%n", "ID", "NAME", "PRICE", "MANUFACTURE", "GUARANTEE PERIOD YEAR");
            System.out.println("------------------------------------------------------------------------------------------------------");
            for (GenuineProduct a : genuineProductList) {
                System.out.printf("%-10d %-20s %-20.2f %-20s %-25s%n", a.getId(), a.getName(), a.getPrice(), a.getProducer(), a.getInsurance());
            }
        }
    }

    @Override
    public void search(String name) {
        boolean check = true;
        for(GenuineProduct product : genuineProductList ){
            if(name.equals(product.getName())) {
                System.out.println(product.toString());
                check = false;
            }
        }
        if( check) {
            System.out.println("không tìm thấy sản phẩm.");
        }
    }
}
