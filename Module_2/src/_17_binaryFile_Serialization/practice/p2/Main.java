package _17_binaryFile_Serialization.practice.p2;

import java.util.ArrayList;
import java.util.List;

import static _17_binaryFile_Serialization.practice.p2.ReadAndWriteFile.readDataFromFile;
import static _17_binaryFile_Serialization.practice.p2.ReadAndWriteFile.writeToFile;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Vũ Kiều Anh", "Hà Nội"));
        students.add(new Student(2, "Nguyễn Minh Quân", "Hà Nội"));
        students.add(new Student(3, "Đặng Huy Hoà", "Đà Nẵng"));
        students.add(new Student(4, "Nguyễn Khánh Tùng", "Hà Nội"));
        students.add(new Student(5, "Nguyễn Khắc Nhật", "Hà Nội"));
        writeToFile("_17_binaryFile_Serialization/practice/p2/student.txt", students);
        List<Student> studentDataFromFile = readDataFromFile("_17_binaryFile_Serialization/practice/p2/student.txt");
        for (Student student : studentDataFromFile){
            System.out.println(student);
        }
    }
}
