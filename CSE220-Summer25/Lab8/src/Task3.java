public class Task3 {
    private static int minIdx(int[] arr) {
        int idx = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[idx]) {
                idx = i;
            }
        }
        return idx;
    }
    public static int[] method(int[] j, int m) {
        int[] arr = new int[m];
        for (int i = 0; i < j.length; i++) {
            int job = j[i];
            int minIdx = minIdx(arr);
            arr[minIdx] += job;
        }
        return arr;
    }
    public static void main(String[] args) {
        // Case 1: sample case
        int[] tasks1 = {2, 4, 7, 1, 6};
        int m1 = 4;
        printResult(tasks1, m1);

        // Case 2: more machines than tasks
        int[] tasks2 = {5, 9};
        int m2 = 5;
        printResult(tasks2, m2);

        // Case 3: one machine only
        int[] tasks3 = {3, 6, 2, 8};
        int m3 = 1;
        printResult(tasks3, m3);

        // Case 4: many tasks, few machines
        int[] tasks4 = {4, 2, 7, 6, 5, 9, 3, 8};
        int m4 = 3;
        printResult(tasks4, m4);

        // Case 5: equal distribution
        int[] tasks5 = {2, 2, 2, 2};
        int m5 = 2;
        printResult(tasks5, m5);
    }

    // helper to run test case
    private static void printResult(int[] tasks, int m) {
        int[] result = Task3.method(tasks, m);
        System.out.print("Tasks: ");
        for (int t : tasks) System.out.print(t + " ");
        System.out.println("\nMachines: " + m);

        System.out.print("Final loads: ");
        for (int r : result) System.out.print(r + " ");
        System.out.println("\n---");
    }

}
