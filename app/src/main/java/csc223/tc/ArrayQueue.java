package csc223.tc;

public class ArrayQueue implements Queue {

    private int[] data;
    private int capacity;
    private int rear;
    private int front;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity];
        this.rear = 0;
        this.front = 0;
    }

    @Override
    public void enqueue(int item) {
        // if (this.data.length >= this.capacity) {
        // throw new RuntimeException("Queue is full");
        // }
        this.data[this.rear] = item;
        this.rear += 1;
    }

    public int dequeue() {
        if (this.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        } else if (this.front >= this.rear) {
            throw new RuntimeException("Queue is empty");
        }
        this.front += 1;
        return this.data[this.front - 1];
    }

    public int peek() {
        return this.data[this.front];
    }

    public boolean isEmpty() {
        return this.data.length == 0;
    }

    public int size() {
        return (this.rear - this.front);
    }

    public static void main(String[] args) {

        ArrayQueue Que = new ArrayQueue(10);

        Que.enqueue(5);
        Que.enqueue(57);
        Que.enqueue(2);

        Boolean test = Que.isEmpty();
        System.out.println(test);

        int test2 = Que.peek();
        System.out.println(test2);

        int test11 = Que.size();
        System.out.println(test11);

        int test3 = Que.dequeue();
        System.out.println(test3);

        int test4 = Que.dequeue();
        System.out.println(test4);

        int test5 = Que.dequeue();
        System.out.println(test5);

        int test6 = Que.dequeue();
        System.out.println(test6);

        int test7 = Que.dequeue();
        System.out.println(test7);
    }
}