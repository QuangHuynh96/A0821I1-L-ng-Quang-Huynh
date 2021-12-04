package _13_search.exercise.e1;

import java.util.ArrayList;
import java.util.Scanner;

public class StringASCII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> result = new ArrayList<Character>();
        ArrayList<Character> list = new ArrayList<Character>();
        System.out.println("Nhập chuổi cần sắp xếp!");
        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            System.out.print(input.charAt(i));
            list.add(input.charAt(i));
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(j) > list.get(list.size()-1) ) {
                    list.add(input.charAt(j));
                }
            }
            //so cánh chuỗi tăng dần mới tìm được với chuỗi tăng dần trước đó.
            if(list.size() > result.size()) {
                result.clear();
                result.addAll(list);
            }
            //clear lại list để tìm cà thêm vào chuỗi tăng dần tiếp theo tiếp theo.
            list.clear();
        }
        System.out.println("--------");
        for(Character r : result) {
            System.out.print(r);
        }
    }
}
