package _11_stackAndQueue.practice.queueUsingArray;

public class MyQueue {
    private int capacity;
    private int queueArr[];
    private int head = 0;
    private int tail = -1;
    private int currentSize = 0;

    public MyQueue(int queueSize) {
        this.capacity = queueSize;
        queueArr = new int[capacity];
    }

    public boolean isQueueFull(){
        boolean status = false;
        if (currentSize == capacity){
            status = true;
        }
        return status;
    }

    public boolean isQueueEmpty(){
        boolean status = false;
        if (currentSize == 0){
            status = true;
        }
        return status;
    }

    public void enqueue(int item) {
        if (isQueueFull()) {
            System.out.println("Overflow ! Unable to add element: " + item);
        }
        if(isQueueEmpty()) {
            head = tail = item;
        }else {
            tail = item;
        }
        queueArr[currentSize] = item;
        currentSize++;
    }

    public void dequeue() {
        if(!isQueueEmpty()){
            int[] tmp= new int[currentSize-1];
            System.arraycopy(queueArr,1,tmp, 0, currentSize-1);
            queueArr= tmp;
            currentSize--;
            tail= queueArr[currentSize-1];
        }
    }

    public void read(){
        for (int i = 0; i < currentSize; i++) {
            System.out.println(queueArr[i]);
        }
    }
    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }

    public int getCurrentSize() {
        return currentSize;
    }

}
