package Data_Structures;

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
    private QueueNode last;

    public Queue() {
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    // Adding a node to the end as if it is a line at a register
    // Insertion: O(1)
    public void enqueue(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Null values are not allowed in the stack.");
        }

        QueueNode newNode = new QueueNode(data);
        if(last != null) {
            last.next = newNode;
        }
        last = newNode;
        if(first == null) {
            first = newNode;
        }
        size++;
    }

    // First node that was in the queue is removed
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
            throw new NoSuchElementException("Queue is empty");
        }
        return first.data;
    }

    // Method to search for a node with a specific data and returns its index
    // Search: O(n)
    public int search(T data) {
        if (data == null) {
            throw new NoSuchElementException("Cant search for null data");
        }
        QueueNode temp = first; 
        for(int i = 0; i < size; i++) {
            if(temp.data.equals(data)) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    // Method to check if the stack is empty
    // O(1)
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        
        // Test enqueue
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Test peek
        System.out.println("Peek: " + queue.peek()); // Output: 1
        System.out.println("Search: " + queue.search(3)); // Output: 2

        // Test dequeue
        System.out.println("Dequeue: " + queue.dequeue()); // Output: 1
        System.out.println("Dequeue: " + queue.dequeue()); // Output: 2

        // Test size
        System.out.println("Size: " + queue.size()); // Output: 1

        // Test isEmpty
        System.out.println("IsEmpty: " + queue.isEmpty()); // Output: false

        // Dequeue last element and test empty queue
        System.out.println("Dequeue: " + queue.dequeue()); // Output: 3
        System.out.println("IsEmpty: " + queue.isEmpty()); // Output: true
        // Edge Case: Dequeue or Peek from empty queue
        try {
            queue.dequeue();
        } catch (NoSuchElementException e) {
            System.out.println("Dequeue on empty queue: " + e.getMessage()); // Expected
        }

        try {
            queue.peek();
        } catch (NoSuchElementException e) {
            System.out.println("Peek on empty queue: " + e.getMessage()); // Expected
        }

        // Edge Case: Search for nonexistent element
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println("Search for 6: " + (queue.search(6))); // Output: -1
    }
}
