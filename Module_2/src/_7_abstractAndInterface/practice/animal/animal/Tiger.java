package _7_abstractAndInterface.practice.animal.animal;

public class Tiger extends Animal implements Edible{
    @Override
    public String makeSound() {
        return "Tiger: roarrrr!";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }
}
