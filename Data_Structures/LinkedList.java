package Data_Structures;

// Doubly LinkedList
public class LinkedList<T> {
    // Nested Node Class
    public class Node {
        private T data;
        private Node next;
        private Node prev;

        // Constructor
        public Node() {
            this.data = null;
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

    
}
