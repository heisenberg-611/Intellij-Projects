public class Task4 {
    public static int[] findTopK(int[] nums, int k) {
        MaxHeap heap = new MaxHeap(nums.length);
        for (int i = 0; i < nums.length; i++) {
            heap.insert(nums[i]);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.extractMax();
        }
        return result;
    }
    public static void main(String[] args) {
        // Case 1: sample input
        int[] nums1 = {4, 10, 2, 8, 6, 7};
        int k1 = 3;
        printResult(nums1, k1);

        // Case 2: k = 1 (just largest element)
        int[] nums2 = {12, 5, 9, 3, 15};
        int k2 = 1;
        printResult(nums2, k2);

        // Case 3: k = array length (should return sorted descending)
        int[] nums3 = {3, 1, 4, 2};
        int k3 = nums3.length;
        printResult(nums3, k3);

        // Case 4: duplicates
        int[] nums4 = {5, 7, 7, 7, 3};
        int k4 = 2;
        printResult(nums4, k4);

        // Case 5: larger array
        int[] nums5 = {20, 15, 30, 10, 25, 40};
        int k5 = 4;
        printResult(nums5, k5);
    }

    private static void printResult(int[] nums, int k) {
        int[] arr = Task4.findTopK(nums, k);
        System.out.print("Top " + k + " elements from { ");
        for (int n : nums) System.out.print(n + " ");
        System.out.print("} => ");
        for (int val : arr) System.out.print(val + " ");
        System.out.println();
    }

}
