package _12_javaCollectionFramework.pratice.p3;

 class Student implements Comparable<Student> {
    private String name;
    private int age;
    private String address;

     Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

     int getAge() {
        return age;
    }

     void setAge(int age) {
        this.age = age;
    }

     String getName() {
        return name;
    }

     void setName(String name) {
        this.name = name;
    }

     String getAddress() {
        return address;
    }

     void setAddress(String address) {
        this.address = address;
    }
public
    @Override
     String toString() {
        return "name= "+this.name +", age= "+ this.age +", address= "+ this.address;
    }

     @Override
     public int compareTo(Student o) {
         return this.getName().compareTo(o.getName());
     }
 }
