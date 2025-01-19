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
    public void add(int element) {
        // Worst case time complexity: O(n)
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
    
    public static void main(String[] args) {
        
    }
}
