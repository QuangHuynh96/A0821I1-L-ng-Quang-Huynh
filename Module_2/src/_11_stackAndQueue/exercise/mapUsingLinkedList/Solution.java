package _11_stackAndQueue.exercise.mapUsingLinkedList;

public class Solution {
    static class Node {
         int data;
        Node next;
    }

    static class Queue {
        Node front;
        Node rear;
    }
//add method
    static void enQueue( Queue q, int data) {
        Node temp = new Node();
        temp.data= data;
        if( q.front == null) {
            q.front =  temp;
        }else {
            q.rear.next= temp;
        }
        q .rear = temp;
        q.rear.next = q.front;
    }
//delete method
     static int deQueue( Queue q) {
        if( q.front== null ){
            return -1;
        }
        int value;
        if( q.front== q.rear) {
            value = q.front.data;
            q.rear = q.front = null;
        }else {
            value= q.front.data;
            q.front= q.front.next;
            q.rear.next= q.front;
        }
        return value;
    }
//display queue
    static void displayQueue(Queue q) {
        Node temp= q.front;
        while( temp.next != q.front){
            System.out.println(temp.data);
            temp= temp.next;
        }
        System.out.println(temp.data);
    }
//run method
    public static void main(String[] args) {
        Queue  q = new Queue();
        q .front = q .rear =  null;
        enQueue(q, 3);
        enQueue(q, 5);
        enQueue(q, 7);
        displayQueue(q);

        System.out.println("Deleted value = "+ deQueue(q));
        System.out.println("Deleted value = "+ deQueue(q));
        displayQueue(q);
    }
}
