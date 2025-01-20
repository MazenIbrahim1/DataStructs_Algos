package Data_Structures;

public class ArrayList {
    private int size;    // Size of the ArrayList
    private int[] array; // Array to store the elements

    // Constructor for ArrayList
    public ArrayList() {
        this.size = 0;
        this.array = new int[10];
    }
    
    // Method to add an element to the ArrayList
    // Worst case time complexity: O(n)
    // Average case time complexity: O(1)
    public void add(int element) {
        // Doubling the size of the array if it is full
        if(size == array.length) {
            int[] temp = new int[size*2];
            // Copy the elements to the new array
            for(int i = 0; i < size; i++) {
                temp[i] = array[i];
            }
            array = temp;
        }

        // Adding the element to the array
        array[size++] = element;
    }

    // Method to access an element from the ArrayList
    public int get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return array[index];
    }

    // Method to remove an element from the ArrayList
    public void remove(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        for(int i = index; i < size-1; i++) {
            array[i] = array[i+1];
        }
        size--;
    }

    public static void main(String[] args) {
        
    }
}
