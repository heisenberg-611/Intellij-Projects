public class Task1_Set_A {
    /**
     * To find elements between xth and yth lowest positions, we need to:
     * 1. Use a MinHeap to establish the sorted order of elements
     * 2. Extract elements from position x to y
     * 
     * Since we can't use direct sorting, we use a MinHeap to achieve this
     * ordering implicitly through repeated extractMin operations.
     */
    
    // MinHeap implementation for finding lowest elements
    private static class MinHeap {
        private final int[] heap;
        private int size;
        
        public MinHeap(int capacity) {
            heap = new int[capacity + 1]; // 1-indexed heap
            size = 0;
        }
        
        public int getSize() {
            return size;
        }
        
        // Insert function is mentioned as already implemented in the problem
        public void insert(int val) {
            if (size == heap.length - 1) {
                return; // Heap is full
            }
            heap[++size] = val;
            swim(size);
        }
        
        // Swim function is mentioned as already implemented in the problem
        public void swim(int k) {
            while (k > 1 && heap[k] < heap[k / 2]) {
                swap(k, k / 2);
                k = k / 2;
            }
        }
        
        // Implementation for extracting minimum element
        public int extractMin() {
            if (size == 0) {
                throw new RuntimeException("Heap is empty");
            }
            int min = heap[1];
            heap[1] = heap[size--];
            if (size > 0) {
                sink(1);
            }
            return min;
        }
        
        // Implementation for sink operation (restore heap property)
        public void sink(int k) {
            while (2 * k <= size) {
                int j = 2 * k;
                if (j < size && heap[j + 1] < heap[j]) j++;
                if (heap[k] <= heap[j]) break;
                swap(k, j);
                k = j;
            }
        }
        
        private void swap(int a, int b) {
            int temp = heap[a];
            heap[a] = heap[b];
            heap[b] = temp;
        }
    }
    
    /**
     * Creates a heap with values between xth and yth lowest positions from the array.
     * 
     * @param array The input array of integers
     * @param x The lower bound position (inclusive)
     * @param y The upper bound position (inclusive)
     * @return A new heap with values between xth and yth positions
     */
    public static int[] createHeapWithValuesInRange(int[] array, int x, int y) {
        if (array == null || array.length == 0 || x < 1 || y > array.length || x > y) {
            return new int[0]; // Return empty array for invalid inputs
        }
        
        int n = array.length;
        
        // Step 1: Use a MinHeap to identify all elements in sorted order
        MinHeap allElementsHeap = new MinHeap(n);
        
        // Insert all elements into the heap
        for (int i = 0; i < n; i++) {
            allElementsHeap.insert(array[i]);
        }
        
        // Step 2: Extract elements one by one to identify positions
        int[] sortedArray = new int[n];
        for (int i = 0; i < n; i++) {
            sortedArray[i] = allElementsHeap.extractMin();
        }
        
        // Step 3: Create result array with elements from xth to yth position
        int resultSize = y - x + 1;
        int[] result = new int[resultSize];
        
        for (int i = 0; i < resultSize; i++) {
            result[i] = sortedArray[x - 1 + i];
        }
        
        return result;
    }
    
    /**
     * Main method to test the implementation with the sample input.
     */
    public static void main(String[] args) {
        int[] array = {11, 15, 8, 2, 31, 23};
        int x = 2;
        int y = 5;
        
        int[] result = createHeapWithValuesInRange(array, x, y);
        
        System.out.print("Result: [");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}