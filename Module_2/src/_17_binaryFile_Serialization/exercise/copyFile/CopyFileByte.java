package _17_binaryFile_Serialization.exercise.copyFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyFileByte <T> implements Serializable {
    List<T> list = new ArrayList<T>();
     // Read file method.
      List<T> readFile(String filePath) {
          List<T> list = new ArrayList<T>();
         try {
             File file = new File(filePath);
             if( !file.exists()) {
                 throw new FileNotFoundException();
             }
             FileInputStream fis = new FileInputStream(filePath);
             ObjectInputStream ois = new ObjectInputStream(fis);
             list = (List<T>) ois.readObject();
             ois.close();
             fis.close();
         } catch (Exception e) {
             e.printStackTrace();
         }
         return list;
     }

     // Write file method.
    void writeFile(String path, List<T> list) {
         try {
             File file = new File(path);
             if(file.exists()) {
                 System.out.println("file đã tồn tại.");
             }else {
                 FileOutputStream fos = new FileOutputStream("_17_binaryFile_Serialization/exercise/copyFile/" + path);
                 ObjectOutputStream oos = new ObjectOutputStream(fos);
                 oos.writeObject(list);
                 oos.close();
                 fos.close();
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
    }

    // copy method.
    void copy(String pathIn, String pathOut) {
          try{
              list = readFile(pathIn);
              writeFile(pathOut, list);
          } catch (Exception e) {
              e.printStackTrace();
          }
    }
}
