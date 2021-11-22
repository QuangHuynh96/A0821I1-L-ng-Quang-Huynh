package _11_stackAndQueue.practice.queueUsingArray;

public class Test {
    public static void main(String[] args) {
        MyQueue test= new MyQueue(5);
        test.enqueue(1);
        test.enqueue(7);
        test.enqueue(5);
        test.enqueue(3);

        test.read();
        System.out.println("------");
        test.dequeue();
        test.read();

    }
}
