package Data_Structures;

// Doubly LinkedList
public class LinkedList<T> {
    // Nested Node Class
    public class Node {
        private T data;
        private Node next;
        private Node prev;

        // Constructor
        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        // Getters 
        public T getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public Node getPrev() {
            return prev;
        }

        // Setters
        public void setData(T newData) {
            data = newData;
        }

        public void setNext(Node newNext) {
            next = newNext;
        }

        public void setPrev(Node newPrev) {
            prev = newPrev;
        }
    }

    private Node head;
    private Node tail;
    private Node cursor;
    private int size;

    // Constructor
    public LinkedList() {
        this.head = null;
        this.cursor = null;
        this.tail = null;
        this.size = 0;
    }

    // Getters
    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public Node getCursor() {
        return cursor;
    }

    public int getSize() {
        return size;
    }

    // Setters
    public void setHead(Node newHead) {
        head = newHead;
    }

    public void settail(Node newTail) {
        tail = newTail;
    }

    public void setCursor(Node newCursor) {
        cursor = newCursor;
    }

    // LinkedList Methods
    // Adding a node to end of the list
    // Average case: O(1)
    public void add(T data) {
        Node newNode = new Node(data);
        // If it is the first node in the list
        if(size == 0) {
            head = newNode;
            cursor = head;
            tail = head;
            size++;
            return;
        }

        // Adding the node and incrementing size
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    // Deleting a node by index
    // Deletion: O(n)
    public boolean delete(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        // Deleting head
        if (index == 0) { 
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
        } else {
            cursor = head;
            for (int i = 0; i < index; i++) {
                cursor = cursor.next;
            }
            if (cursor.next != null) {
                cursor.next.prev = cursor.prev;
            } else { // Deleting tail
                tail = cursor.prev;
            }
            if (cursor.prev != null) {
                cursor.prev.next = cursor.next;
            }
        }
        size--;
        cursor = head; // reset cursor
        return true;
    }

    // Searching/Accessing a node with a specific type of data
    // Search/Access: O(n)
    public Node get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        if(index == 0) {
            return head;
        }

        // Set cursor to head and start counter at 1
        int counter = 0;
        cursor = head;

        while(counter < index) {
            cursor = cursor.next;
            counter++;
        }

        return cursor;
    }

    // Method to check if the list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        // Add elements
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        // Print the list
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println("Element at index " + i + ": " + list.get(i).getData());
        }

        // Delete an element
        System.out.println("\nDeleting element at index 2...");
        list.delete(2);

        // Print the list again
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println("Element at index " + i + ": " + list.get(i).getData());
        }

        // Check if list is empty
        System.out.println("\nIs the list empty? " + list.isEmpty());

        // Test edge cases
        System.out.println("\nDeleting head...");
        list.delete(0);
        System.out.println("Deleting tail...");
        list.delete(list.getSize() - 1);

        // Print the final state of the list
        System.out.println("\nFinal list:");
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println("Element at index " + i + ": " + list.get(i).getData());
        }
    }
}
