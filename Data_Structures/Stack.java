package Data_Structures;

import java.util.EmptyStackException;

// LIFO --> Last In First Out
// Implemented using a linked list
public class Stack<T> {
    // Stack Node Class
    public class StackNode {
        private T data;
        private StackNode next;

        public StackNode(T data) {
            this.data = data;
            this.next = null;
        }

        // Getters
        public T getData() {
            return data;
        }

        public StackNode getNext() {
            return next;
        }

        // Setters
        public void setData(T newData) {
            data = newData;
        }

        public void setNext(StackNode newNext) {
            next = newNext;
        }
    }

    private int size;
    private StackNode top;

    public Stack() {
        this.size = 0;
        this.top = null;
    }

    // Method to check the size of the stack
    public int size() {
        return size;
    }

    // Method to push an item onto the stack
    // Addition: O(1)
    public void push(T item) {
        if(item == null) {
            return;
        }

        // Node reference of the item
        StackNode node = new StackNode(item);
        
        // If it is the first item
        if(size == 0) {
            top = node;
            size++;
            return;
        }

        // Adding the item onto the stack
        node.next = top;
        top = node;
        size++;
    }

    // Removing the top node in the stack
    // Deletion: O(1)
    public T pop() {
        if(top == null) {
            throw new EmptyStackException();
        }
        T temp = top.data;
        top = top.next;
        size--;
        return temp;
    }

    // Method that returns the data of the top node
    // Peek: O(1)
    public T peek() {
        return top.data;
    }

    // Method to check if the stack is empty
    // O(1)
    public boolean isEmpty() {
        return size == 0;
    }

    // Method that returns the index of the item being searched for
    // Search: O(n)
    public int search(T item) {
        StackNode cursor = top;
        for(int i = 0; i < size; i++) {
            if(cursor.data == item) {
                return i;
            }
            cursor = cursor.next;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
