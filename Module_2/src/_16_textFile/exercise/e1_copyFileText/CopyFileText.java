package _16_textFile.exercise.e1_copyFileText;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class CopyFileText {
    //hàm đọc file.
    List<String> readFile(String filePath) {
        List<String> list = new ArrayList<String>();
        try {
            File file = new File(filePath);
            if( !file.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            String line= "";
            while(true) {
                line = br.readLine();
                if( line == null) {
                    break;
                }
                list.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // hàm ghi file.
     String writeFile(String filePath, List<String> strings){
        int size= 0;
        try {
            File file = new File(filePath);
            if(file.exists()) {
                throw new FileNotFoundException();
            }
            FileWriter fw = new FileWriter(filePath);
            BufferedWriter bw = new BufferedWriter(fw);
            for(String i : strings) {
                bw.write(i);
                size += i.length();
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Lỗi nhập đường dẫn hoặc file đã tồn tại.");
        }
        return "số ký tự của file là: "+size;
    }

}
