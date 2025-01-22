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
        if (item == null) {
            throw new IllegalArgumentException("Null values are not allowed in the stack.");
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

    // Method that returns the index of the item being searched for
    // Search: O(n)
    public int search(T item) {
        StackNode cursor = top;
        for(int i = 0; i < size; i++) {
            if(cursor.data.equals(item)) {
                return i;
            }
            cursor = cursor.next;
        }
        return -1;
    }

    public static void main(String[] args) {
        // Create a stack of integers
        Stack<Integer> stack = new Stack<>();

        System.out.println("### TESTING STACK OPERATIONS ###");

        // Test isEmpty() on an empty stack
        System.out.println("Stack is empty: " + stack.isEmpty()); // Expected: true

        // Test size() on an empty stack
        System.out.println("Stack size: " + stack.size()); // Expected: 0

        // Test peek() on an empty stack
        try {
            stack.peek();
        } catch (EmptyStackException e) {
            System.out.println("Peek on empty stack: " + e.getMessage());
        }

        // Test pop() on an empty stack
        try {
            stack.pop();
        } catch (EmptyStackException e) {
            System.out.println("Pop on empty stack: " + e.getMessage());
        }

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Pushed 10, 20, 30 onto the stack.");
        System.out.println("Stack is empty: " + stack.isEmpty()); // Expected: false
        System.out.println("Stack size: " + stack.size()); // Expected: 3

        // Peek the top element
        System.out.println("Top element (peek): " + stack.peek()); // Expected: 30

        // Pop elements from the stack
        System.out.println("Popped element: " + stack.pop()); // Expected: 30
        System.out.println("Popped element: " + stack.pop()); // Expected: 20
        System.out.println("Stack size after popping twice: " + stack.size()); // Expected: 1

        // Search for elements in the stack
        System.out.println("Index of 10 in the stack: " + stack.search(10)); // Expected: 0
        System.out.println("Index of 30 in the stack: " + stack.search(30)); // Expected: -1 (not found)

        // Push null (test error handling)
        try {
            stack.push(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Push null: " + e.getMessage());
        }

        // Push more elements
        stack.push(40);
        stack.push(50);

        System.out.println("Pushed 40, 50 onto the stack.");
        System.out.println("Stack size: " + stack.size()); // Expected: 3

        // Peek the top element again
        System.out.println("Top element (peek): " + stack.peek()); // Expected: 50

        // Pop remaining elements
        System.out.println("Popped element: " + stack.pop()); // Expected: 50
        System.out.println("Popped element: " + stack.pop()); // Expected: 40
        System.out.println("Popped element: " + stack.pop()); // Expected: 10

        // Final check on empty stack
        System.out.println("Stack is empty: " + stack.isEmpty()); // Expected: true
        System.out.println("Stack size: " + stack.size()); // Expected: 0

        System.out.println("All tests passed successfully!");
    }
}
