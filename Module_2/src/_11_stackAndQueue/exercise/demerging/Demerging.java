package _11_stackAndQueue.exercise.demerging;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Demerging {
    public static void main(String[] args) {
        Person o1 = new Person("a", "nu", 10);
        Person o2 = new Person("b", "nam", 11);
        Person o3 = new Person("c", "nu", 12);
        Person o4 = new Person("d", "nam", 13);
        Person o5 = new Person("e", "nam", 14);
        Person o6 = new Person("f", "nu", 15);
        ArrayList<Person> personList = new ArrayList<>();
        personList.add(o1);
        personList.add(o2);
        personList.add(o3);
        personList.add(o4);
        personList.add(o5);
        personList.add(o6);

        Queue<Person> qFemale = new LinkedList<>();
        Queue<Person> qMale = new LinkedList<>();
        personList.forEach(o -> {
                    if (o.getGender() == "nu") qFemale.add(o);
                    else qMale.add(o);
                }
        );
        personList.clear();
        while(!qFemale.isEmpty()){
            personList.add(qFemale.remove());
        }
        while(!qMale.isEmpty()) {
            personList.add(qMale.remove());
        }
        personList.forEach(System.out::println);
    }
}
