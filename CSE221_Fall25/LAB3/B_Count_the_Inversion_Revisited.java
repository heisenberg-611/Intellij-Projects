/**
 *    author:  kabir_singh
 *    created: 2025.11.04 20:30:27
 **/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_Count_the_Inversion_Revisited {
    public static void main(String[] args) throws IOException {
        // Fast input setup
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        // Fenwick tree (Binary Indexed Tree) setup
        // We use an offset to handle negative numbers by shifting them to positive indices
        final int OFFSET = 1_000_000; // Shift negative values to positive range
        final int SIZE = 2_000_001;   // Size to cover range [-1e6, 1e6]
        int[] fenw = new int[SIZE + 1]; // Fenwick tree array (1-indexed internally)

        long ans = 0;    // Stores the final answer (total count of special inversions)
        int total = 0;   // Count of numbers processed so far

        // Process each number in the input sequence
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken()); // Read current number
            long sq = (long) a * a; // Compute square of current number

            // Check if square is within our special range (less than 1e6)
            // If yes, count how many previous numbers are greater than this square
            if (sq < 1_000_000L) {
                int idx = (int) sq + OFFSET; // Convert square to fenwick tree index

                // Query fenwick tree: get count of numbers added so far that are <= square
                // We query for range [1, idx+1) = [1, idx], which means values <= (idx - OFFSET)
                long sum = 0;
                for (int k = idx + 1; k > 0; k -= k & -k) { // Standard fenwick query
                    sum += fenw[k];
                }

                // Add the count of numbers greater than 'sq' to our answer
                // total = total numbers processed so far
                // sum = numbers <= 'sq'
                // So, (total - sum) = numbers > 'sq'
                ans += total - sum;
            }

            // Add current number 'a' to the fenwick tree
            int pos = a + OFFSET; // Convert current number to fenwick tree index
            // Standard fenwick tree update: increment count at 'pos'
            for (int k = pos + 1; k <= SIZE; k += k & -k) {
                fenw[k]++;
            }
            total++; // Increment total count of numbers processed
        }

        // Output the final result
        System.out.println(ans);
    }
}