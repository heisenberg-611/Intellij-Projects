import java.io.*;
import java.util.*;

public class E_Reverse_Sorting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // Check if already non-decreasing
        boolean alreadySorted = true;
        for (int i = 1; i < N; i++) {
            if (A[i] < A[i - 1]) {
                alreadySorted = false;
                break;
            }
        }
        if (alreadySorted) {
            System.out.println("YES");
            System.out.println(0);
            return;
        }

        if (N < 3) {
            System.out.println("NO");
            return;
        }

        // Create sorted version
        int[] sorted = A.clone();
        Arrays.sort(sorted);

        // Check parity condition: elements at even/odd indices must match
        int[] evenOrig = new int[(N + 1) / 2];
        int[] oddOrig = new int[N / 2];
        int[] evenSorted = new int[(N + 1) / 2];
        int[] oddSorted = new int[N / 2];

        int e = 0, o = 0;
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                evenOrig[e++] = A[i];
            } else {
                oddOrig[o++] = A[i];
            }
        }

        e = 0; o = 0;
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                evenSorted[e++] = sorted[i];
            } else {
                oddSorted[o++] = sorted[i];
            }
        }

        Arrays.sort(evenOrig);
        Arrays.sort(oddOrig);
        Arrays.sort(evenSorted);
        Arrays.sort(oddSorted);

        if (!Arrays.equals(evenOrig, evenSorted) || !Arrays.equals(oddOrig, oddSorted)) {
            System.out.println("NO");
            return;
        }

        // Now simulate sorting using 3-reverses
        List<int[]> ops = new ArrayList<>();
        int[] arr = A.clone();

        for (int i = 0; i < N - 1; i++) {
            // Find index of min element from i to end
            int minVal = arr[i];
            int minIdx = i;
            for (int j = i + 1; j < N; j++) {
                if (arr[j] < minVal) {
                    minVal = arr[j];
                    minIdx = j;
                }
            }

            // Bring element at minIdx to position i using 3-reverses
            int pos = minIdx;
            while (pos > i) {
                // We can only move left by 2
                if (pos - i >= 2) {
                    // Reverse [pos-2, pos]
                    reverse3(arr, pos - 2);
                    ops.add(new int[]{pos - 2, pos});
                    pos -= 2;
                } else {
                    // pos - i == 1 => need to move right first (only if possible)
                    // Since parity matches, this situation should not occur
                    // But if it does, we can do: move to pos+1 (if space), then back
                    // However, due to parity check, minIdx and i have same parity
                    // So (minIdx - i) is even → this case should never happen
                    // So we can assert pos - i is even
                    // So we break
                    // In practice, this won't occur
                    break;
                }
            }
        }

        // Final check (should be sorted)
        boolean ok = true;
        for (int i = 1; i < N; i++) {
            if (arr[i] < arr[i - 1]) {
                ok = false;
                break;
            }
        }

        if (!ok) {
            // Should not happen if parity condition passed
            System.out.println("NO");
        } else {
            System.out.println("YES");
            System.out.println(ops.size());
            for (int[] op : ops) {
                // op[0] is start index (0-based), so subarray is [op[0], op[0]+2]
                // Output 1-based indices: start+1 and start+3
                System.out.println((op[0] + 1) + " " + (op[0] + 3));
            }
        }
    }

    static void reverse3(int[] arr, int i) {
        // Reverse arr[i], arr[i+1], arr[i+2]
        int temp = arr[i];
        arr[i] = arr[i + 2];
        arr[i + 2] = temp;
        // middle element stays
    }
}