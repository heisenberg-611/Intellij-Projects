/**
 *    author:  kabir_singh
 *    created: 2026.01.01 12:54:08
 **/
import java.io.*;
import java.util.*;

public class F_Tasks_and_Deadlines{
    static class Task {
        long duration, deadline;

        Task(long duration, long deadline) {
            this.duration = duration;
            this.deadline = deadline;
        }
    }

    // ================= FAST SCANNER =================
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int n = fs.nextInt();
        Task[] tasks = new Task[n];

        for (int i = 0; i < n; i++) {
            long a = fs.nextLong();
            long d = fs.nextLong();
            tasks[i] = new Task(a, d);
        }

        // Sort by duration (SPT rule)
        Arrays.sort(tasks, Comparator.comparingLong(t -> t.duration));

        long time = 0;
        long reward = 0;

        for (Task t : tasks) {
            time += t.duration;
            reward += t.deadline - time;
        }

        System.out.println(reward);
    }
}