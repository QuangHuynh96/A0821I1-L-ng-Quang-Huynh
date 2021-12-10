package _17_binaryFile_Serialization.exercise.copyFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CopyFileMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        List<String> list = new ArrayList<String>();
//        list.add("h");
//        list.add("hu");
//        list.add("huy");
//        list.add("huyn");
//        list.add("huynh");

        CopyFileByte<String> copyFileByte = new CopyFileByte<String>();
//        System.out.println("");
//        copyFileByte.writeFile("addData.txt", list);

        System.out.println("Chươg trình copyfile kiểu Byte.");
        System.out.println("Nhập đường dẫn file nguồn:");
        String pathIn = scanner.nextLine();
        System.out.println("Nhập tên file ra:");
        String pathOut = scanner.nextLine();
        copyFileByte.copy(pathIn,pathOut);
        //_17_binaryFile_Serialization/exercise/copyFile/addData.txt
        // newFile.txt
    }
}
