package Data_Structures;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

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
    private QueueNode first;

    public Queue() {
        this.size = 0;
        this.first = null;
    }

    // Insertion: O(1)
    public void enqueue(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Null values are not allowed in the stack.");
        }

        QueueNode newNode = new QueueNode(data);
        if(size == 0) {
            first = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }
        size++;
    }

    // Deletion: O(1)
    public T dequeue() {
        if(first == null) {
            throw new NoSuchElementException("Nothing in the queue");
        }
        T temp = first.data;
        first = first.next;
        size--;
        return temp;
    }

    // Method to return the size of the queue
    public int size() {
        return size;
    }

    // Method that returns the data of the first node
    // Peek: O(1)
    public T peek() {
        if (first == null) {
            throw new EmptyStackException();
        }
        return first.data;
    }

    // Method to check if the stack is empty
    // O(1)
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {

    }
}
