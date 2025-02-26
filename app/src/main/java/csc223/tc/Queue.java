package csc223.tc;

public interface Queue{

    public void enqueue(int item);
    public int dequeue();
    public int peek();
    public boolean isEmpty();
    public int size();
}