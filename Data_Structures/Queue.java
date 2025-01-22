package Data_Structures;

import java.util.EmptyStackException;

// FIFO First In First Out
// Implemented using a linked list
public class Queue<T> {
    // Queue Node Class
    public class QueueNode {
        private T data;
        private QueueNode next;

        public QueueNode(T data) {
            this.data = data;
            this.next = null;
        }

        // Getters
        public T getData() {
            return data;
        }

        public QueueNode getNext() {
            return next;
        }

        // Setters
        public void setData(T newData) {
            data = newData;
        }

        public void setNext(QueueNode newNext) {
            next = newNext;
        }
    }

    private int size;
    private QueueNode top;

    public Queue() {
        this.size = 0;
        this.top = null;
    }

    // Insertion: O(1)
    public void enqueue(T data) {
        size++;
    }

    // Deletion: O(1)
    public T dequeue() {
        size--;
        return null;
    }

    // Method to return the size of the queue
    public int size() {
        return size;
    }

    // Method that returns the data of the top node
    // Peek: O(1)
    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    // Method to check if the stack is empty
    // O(1)
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {

    }
}
