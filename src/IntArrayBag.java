public class IntArrayBag implements Cloneable { // Implement 'Cloneable' to implement the 'clone()' method
    private int[] data; // Name of the array
    private int manyItems; // Used to keep track the number of elements
    private static int index;

    public IntArrayBag() {
        final int DEFAULT_CAPACITY = 10;
        data = new int[DEFAULT_CAPACITY]; // Default capacity of 10
    }

    public IntArrayBag(int initialCapacity) {
        // Validate that the capacity is not less than 0
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Initial capacity is negative: " + initialCapacity);
        }
        manyItems = 0; // Indicates that the array does not have any elements
        data = new int[initialCapacity]; // Allocates memory for an array with a specified capacity value
    }

    public void add(int element) {
        if (manyItems == data.length) {
            // Double the capacity and add 1; This works even if manyItems is 0
            // TODO: Future Method Insertion - ensureCapacity(...);
        }
        data[manyItems] = element; // data[manyItems] represents the next available location in the array
        manyItems++;
    }

    // This method will add all the elements from one array to another array
    public void addAll(IntArrayBag addend) {
        if (addend == null) {
            throw new NullPointerException("There are no elements in the array");
        }
        // TODO: Future Method Insertion - ensureCapacity(...);
        System.arraycopy(addend.data, 0, data, manyItems, addend.manyItems);
        manyItems += addend.manyItems;
    }

    public static boolean search(int[] data, int target) {
        assert (data[index] > 0) : "There are no elements in the array"; // Assertion Statement
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return true;
            }
        }
        return false;
    }

    // This method returns the largest value in an array
    public static int maxOfArray(int[] array) {
        int answer;
        // Set the answer to the largest value in the array
        answer = array[0]; // Set answer to the first element of the array.
        for (int i = 0; i < array.length; i++) {
            if (array[i] > answer) {
                answer = array[i];
            }
        }
        // Validate the computation using Assertion Statements
        assert contains(array, answer) : "maxOfArray answer is not contained within the array";
        return answer;
    }

    // This method returns true if the array contains the specified value
    private static boolean contains(int[] a, int value) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == value) {
                return true;
            }
        }
        return false; // Returns false if value was not found
    }

    // This method will fill every element of the array with the given specified value
    public static void fill(int[] a, int value) {
        for (int i = 0; i < a.length; i++) {
            a[i] = value;
        }
    }
}
