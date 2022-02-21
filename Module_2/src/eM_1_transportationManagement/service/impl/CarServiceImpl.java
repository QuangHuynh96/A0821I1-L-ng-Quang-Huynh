package transportationManagement.service.impl;

import transportationManagement.models.Car;
import transportationManagement.service.CarService;
import transportationManagement.util.ConstantUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static transportationManagement.util.ConstantUtil.TypeCar.BUS;
import static transportationManagement.util.ConstantUtil.TypeCar.TUARINGCAR;

public class CarServiceImpl implements CarService {
    private static Scanner scanner = new Scanner(System.in);
    @Override
    public void add() {
        try {
            String licensePlates;
            do {
                System.out.println("Nhập biển kiểm soát: ");
                licensePlates = scanner.nextLine();
                if(!carValidate(licensePlates)) {
                    System.out.println("Nhập không đúng:");
                }
                if(checkLicensePlates(licensePlates) != -1) {
                    System.out.println("Biển kiểm soát đã tồn tại");
                }
            }while(!carValidate(licensePlates) || (checkLicensePlates(licensePlates) != -1));

            System.out.println("Nhập năm sản xuất: ");
            int year = Integer.parseInt(scanner.nextLine());
            //Nhập nhà sản xuất
            String manufacturer = setManufacturer();
            System.out.println("Nhập chủ sở hửu: ");
            String owner = scanner.nextLine();
            System.out.println("Nhập số chổ ngồi: ");
            int slot = Integer.parseInt(scanner.nextLine());
            // nhâp kiểu xe.
            ConstantUtil.TypeCar typeCar = setTypeCar(licensePlates);
            //tạo Car,ghi vào file lưu trữ.
            Car car = new Car(licensePlates, year, manufacturer, owner, slot, typeCar);
            writeFile("transportationManagement/data/car.csv", car);
            System.out.println("Thêm thành công.");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private String setManufacturer() {
        String manufacturer = "";
        List<String> manufacturerList = readFile("transportationManagement/data/manufacturer.csv");
        System.out.println("Danh sách nhà sản xuất:");
        for(int i = 1; i <=manufacturerList.size(); i++) {
            System.out.println(i +". "+ manufacturerList.get(i - 1));
        }
        System.out.println("Chọn nhà sản xuất:");
        int number = Integer.parseInt(scanner.nextLine());
        manufacturer = manufacturerList.get(number - 1);
        return manufacturer;
    }

    private ConstantUtil.TypeCar setTypeCar( String strings) {
        ConstantUtil.TypeCar typeCar = null;
        String a ="A";
        String b ="B";
        if(strings.charAt(2) == a.charAt(0))
            typeCar = TUARINGCAR;
        if(strings.charAt(2) == b.charAt(0))
            typeCar = BUS;
        return typeCar;
    }

    @Override
    public void display() {
        List<String> list = readFile("transportationManagement/data/car.csv");
        if(list.size() == 0) {
            System.out.println("Danh sách trống.");
        }else {
            list.forEach(s -> {
                System.out.println(s);
            });
        }
    }

    @Override
    public void delete() {
        String licensePlates = "";
        try {
            do {
                System.out.println("Nhập biển kiểm soát xe muốn xóa: ");
                licensePlates = scanner.nextLine();
                if (!carValidate(licensePlates)) {
                    throw new FileNotFoundException();
                }
            }while(!carValidate(licensePlates));
        } catch (FileNotFoundException e) {
            System.out.println("Biển kiểm soát không tồn tại.");;
        }
        int index =checkLicensePlates(licensePlates);// hàm tìm biển kiểm soát trả về index.
        List<String> list = readFile("transportationManagement/data/car.csv");
        if(index != -1) {
            list.remove(index);
            clearFile();
            // ghi lại file đã được xóa.
            for( String car : list) {
                writeFile("transportationManagement/data/car.csv",car);
            }
        }
    }
    public void clearFile() {
        try {
            FileWriter fw = new FileWriter("transportationManagement/data/car.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("");
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeFile(String filePath, Object car) {
        try {
            File file = new File(filePath);
            if(!file.exists()) {
                throw new FileNotFoundException();
            }
            FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(fw);

                bw.write(car.toString());
                bw.newLine();
            bw.close();
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> readFile( String filePath) {
        List<String> list = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                list.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean carValidate(String regex) {
        Pattern pattern =  Pattern.compile("^[1-9]{2}[AB][-][0-9]{3}[.][0-9]{2}$");
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public int checkLicensePlates(String licensePlates) {
        int result = -1;

        List<String> list = readFile("transportationManagement/data/car.csv");
        List<String> arraylist = new ArrayList<>();
        for( int i = 0; i < list.size(); i++) {
            String[] strings = list.get(i).split(",");
            arraylist.add(strings[0]);
        }
        // tìm index.
        for(int i = 0; i< arraylist.size(); i++) {
            if( arraylist.get(i).equals(licensePlates)) {
                result = i;
            }
        }
        return result;
    }
}
