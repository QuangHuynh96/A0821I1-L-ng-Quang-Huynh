package _13_search.exercise.o_e3;

import java.util.ArrayList;
import java.util.Scanner;

public class MaxStringSearch implements Comparable<String> {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> list = new ArrayList<String>();

        System.out.println("Nhập chuỗi:");
        String[] array = scanner.nextLine().split("");

        for(int i= 0; i < array.length; i++) {
            System.out.print(array[i]);
            list.add(array[i]);
            for( int j= i+1; j < array.length; j++) {
                //nếu array[j] > list.get(list.size()-1) thì trả về số âm.
                if(list.get(list.size()-1).compareTo(array[j]) < 0) {
                    list.add(array[j]);
                }
            }
            if( list.size() > result.size()) {
                result.clear();
                result.addAll(list);
            }
            list.clear();
        }
        System.out.println("---------");
        for(String i : result ) {
            System.out.print(i);
        }
    }

    @Override
    public int compareTo(String o) {
        return o.compareTo(o);
    }
}
