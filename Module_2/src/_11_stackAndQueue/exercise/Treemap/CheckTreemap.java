package _11_stackAndQueue.exercise.Treemap;

import java.util.*;

public class CheckTreemap {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập chuổi từ");
        String string= input.nextLine().toLowerCase();
        int size= string.length();
        String[] arrayString= string.split("");

        TreeMap<String,Integer> map= new TreeMap<String,Integer>();
       // map.containsKey("123");
        for( int i= 0; i< size; i++) {
            if(map.containsKey(arrayString[i])) {
                int temp= map.get(arrayString[i]);
                map.put(arrayString[i],temp + 1);
            }else{
                map.put(arrayString[i], 1);
            }
        }
        for(Map.Entry<String, Integer> entry:map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
