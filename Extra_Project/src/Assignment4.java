public class Assignment4 {
    public static int[] findTopKElements(int[] nums, int k) {
        // Initialize MaxHeap with nums.length capacity
        MaxHeap maxHeap = new MaxHeap(nums.length);

        // Insert all elements into the MaxHeap
        for (int num : nums) {
            maxHeap.insert(num);
        }

        // Create a result array to store the top k elements
        int[] result = new int[k];

        // Extract the maximum k times
        for (int i = 0; i < k; i++) {
            if (maxHeap.getSize() > 0) {
                result[i] = maxHeap.extractMax();
            }
        }

        return result;
    }

    public static void main ( String[] args ) {
        System.out.println("\n----- Task 4: Find Top K Elements -----");
        testTopK(new int[]{4, 10, 2, 8, 6, 7}, 3, "Sample Test");
        testTopK(new int[]{15, 7, 9, 4, 13, 6, 1}, 4, "Test Case 1");
        testTopK(new int[]{30, 10, 20}, 3, "Test Case 2 - All elements");
        testTopK(new int[]{5, 5, 5, 5}, 2, "Test Case 3 - Duplicate elements");
        testTopK(new int[]{100, 2, 56, 32, 1, 7, 77, 43}, 5, "Test Case 4 - Mixed values");
    }
    private static void testTopK(int[] nums, int k, String testName) {
        System.out.println("\n" + testName + ":");
        System.out.print("Array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println("\nk: " + k);

        int[] result = findTopKElements(nums, k);

        System.out.print("Top " + k + " elements: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
