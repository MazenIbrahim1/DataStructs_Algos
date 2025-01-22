package Data_Structures;

public class ArrayList<T> {
    private int size;    // Size of the ArrayList
    private T[] array; // Array to store the elements

    // Constructor for ArrayList
    @SuppressWarnings("unchecked")
    public ArrayList() {
        this.size = 0;
        this.array = (T[]) new Object[10];
    }
    
    // Method to add an element to the ArrayList
    // Insertion: -
    // Worst case time complexity: O(n)
    // Average case time complexity: O(1)
    @SuppressWarnings("unchecked")
    public void add(T element) {
        // Doubling the size of the array if it is full
        if(size == array.length) {
            T[] temp = (T[]) new Object[size*2];
            // Copy the elements to the new array
            for(int i = 0; i < size; i++) {
                temp[i] = array[i];
            }
            array = temp;
        }

        // Adding the element to the array and incrementing the size
        array[size++] = element;
    }

    // Method to access an element from the ArrayList
    // Access: O(1)
    public T get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return array[index];
    }

    // Method to remove an element from the ArrayList
    // Deletion: O(n)
    public void remove(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        // Fix array
        for(int i = index; i < size-1; i++) {
            array[i] = array[i+1];
        }
        array[--size] = null;
    }

    // Method to search for an element in the ArrayList
    // Search: O(n)
    public T search(T element) {
        if (element == null) {
            throw new IllegalArgumentException("Null values are not allowed in the array list.");
        }
        
        for(int i = 0; i < size; i++) {
            if(array[i].equals(element)) {
                return array[i];
            }
        }
        return null;
    }

    // Getter method for the size of the array
    public int size() {
        return size;
    }

    // Method to check if the Arraylist is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to clear the Arraylist = reset to initial values
    @SuppressWarnings("unchecked")
    public void clear() {
        size = 0;
        array = (T[]) new Object[10];
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        // Test isEmpty() and size()
        System.out.println("List is empty: " + list.isEmpty()); // true
        System.out.println("List size: " + list.size());        // 0

        // Add elements
        for (int i = 1; i <= 15; i++) {
            list.add(i);
        }
        System.out.println("List size after adding elements: " + list.size()); // 15
        System.out.println("List is empty: " + list.isEmpty()); // false

        // Access elements
        System.out.println("Element at index 0: " + list.get(0)); // 1
        System.out.println("Element at index 10: " + list.get(10)); // 11

        // Remove elements
        System.out.println("Removing element at index 5...");
        list.remove(5); // Removes the 6th element (value 6)
        System.out.println("Element at index 5 now: " + list.get(5)); // 7
        System.out.println("List size after removal: " + list.size()); // 14

        // Test clear()
        System.out.println("Clearing the list...");
        list.clear();
        System.out.println("List is empty: " + list.isEmpty()); // true
        System.out.println("List size: " + list.size());        // 0

        // Edge cases
        System.out.println("Testing edge cases...");
        try {
            list.get(0); // Should throw IndexOutOfBoundsException
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        try {
            list.remove(0); // Should throw IndexOutOfBoundsException
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        System.out.println("All tests completed successfully.");
    }
}
