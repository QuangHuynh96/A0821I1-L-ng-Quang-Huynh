package _16_textFile.exercise.e2_readFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

 class DisplayFile {

     List<String> readFile(String filePath) {
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
                 String[] strings = line.split(",");
                 list.add(strings[2]);
             }

         } catch (Exception e) {
             e.printStackTrace();
         }
         return list;
     }

     void Display(List<String> string) {
         string.forEach( s -> {
             System.out.println(s);
         });
     }

}
