package _11_stackAndQueue.practice.stackUsingArray;

public class MyStack {
    private int[] array;
    private int size;// sức chứa
    private int index= 0; // số phần tử hiện có

    public MyStack (int size) {
    this.size= size;
    array = new int[size];
    }

    public int size() {
        return this.index;
    }

    public boolean isFull() {
        boolean check = false;
        if( size == index )
            check= true;
        return check;
    }

    public boolean isEmpty() {
        boolean check= false;
        if(index == 0)
            check = true;
        return check;
    }

    public void push(int e) {
        if( isFull()) {
            throw new StackOverflowError("Stack is full");
        }
        array[index]= e;
        index++;
    }

    public int pop() throws Exception {
        if(isEmpty()) {
            throw new Exception("Stack is null");
        }
        int result= array[--index];
        return result;
    }
}
