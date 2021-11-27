package _12_javaCollectionFramework.pratice.p2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Student student1 = new Student("huynh", 26, "DN");
        Student student2 = new Student("Dũng", 25, "DN");
        Student student3 = new Student("Toàn", 24, "DN");

        Map<Integer, Student> hashMap = new HashMap<Integer, Student>();
        hashMap.put(1, student1);
        hashMap.put(2, student2);
        hashMap.put(3, student3);
        hashMap.forEach((k, std) -> {
            System.out.println(k + ": " + std);
        });
        System.out.println("------------------");
        Set<Student> hashSet = new HashSet<Student>();
        hashSet.add(student1);
        hashSet.add(student2);
        hashSet.add(student3);
        hashSet.forEach((std) -> {
            System.out.println(std);
        });
    }
}

// kết quả set sắp xếp theo