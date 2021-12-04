package _16_textFile.practice.p2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

 class ReadAndWriteFile {
//hàm đọc file.
     List<Integer> readFile(String filePath) {
        List<Integer> numbers = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";

            while ((line = br.readLine()) != null) {
                String[] strings = line.split(" ");
//                numbers.add(Integer.parseInt(line));
                for( int i = 0; i < strings.length; i++) {
                    numbers.add(Integer.parseInt(strings[i]));
                }
           }
            br.close();
        } catch (Exception e) {
            System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }
        return numbers;
    }

    // hàm ghi file.
     void writeFile(String filePath, int max){
        try {
            FileWriter writer = new FileWriter(filePath, true);

            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("Giá trị lớn nhất là: " + max);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
