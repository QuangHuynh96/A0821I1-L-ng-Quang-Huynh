package _5_accessModifierStatic.exercise.student;

public class Test {
    private String Name;
    private String Class;

    public Test() {
        this.Name= "John";
        this.Class= "CO2";
    }

    public void setName(String Name) {
        this.Name= Name;
    }

    public void setClass(String Class) {
        this.Class= Class;
    }

    public String toString() {
        return this.Name +", "+ this.Class;
    }
}
