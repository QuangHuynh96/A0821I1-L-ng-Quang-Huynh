package _4_classAndObject.exercise.fan;

public class Main {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setSpeed(fan1.fast);
        fan1.setDarius(10);
        fan1.setColor("yelow");
        fan1.setStatus(true);

        Fan fan2 = new Fan();
        fan1.setSpeed(fan1.medium);
        fan1.setDarius(5);
        fan1.setColor("blue");
        fan1.setStatus(false);

        System.out.println(fan1.toString());
        System.out.println(fan1.getStatus());
        System.out.println(fan2.toString());
    }

}
