package _11_stackAndQueue.exercise.demerging;

public class Person {
    private int age;
    private String name;
    private String gender;
    public Person(String name, String gender, int age) {
        this.age= age;
        this.gender= gender;
        this.name= name;
    }
    public void setName(String name) {
        this.name= name;
    }
    public void setAge( int age) {
        this.age= age;
    }
    public void setGender( String gender) {
        this.gender= gender;
    }

    public int getAge(){
        return this.age;
    }
    public String getName() {
        return this.name;
    }
    public String getGender() {
        return this.gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }

}
