package _12_javaCollectionFramework.pratice.p1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MyMap {
    public static void main(String[] args) {
        HashMap<String, Integer> list = new HashMap<String, Integer>();
        list.put("Smith", 30);
        list.put("Anderson", 31);
        list.put("Lewis", 29);
        list.put("Cook", 29);

        System.out.println("Display entries in HashMap");
        System.out.println(list);
        System.out.println("===================");

        Map<String, Integer> treeMap = new TreeMap<String, Integer>();
        treeMap.putAll(list);
        System.out.println("Display entries in ascending order of key");
        System.out.println(treeMap);
        System.out.println("===================");

        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.putAll(treeMap);
        System.out.println(linkedHashMap);
    }
}
