/**
 *    author:  kabir_singh
 *    created: 2026.01.01 12:26:43
 **/
import java.io.*;
import java.util.*;

public class D_Task_Selection_I{
    // ================= TASK =================
    static class Task {
        long start, end;
        int index;

        Task(long start, long end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
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

    // ================= MAIN =================
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int N = fs.nextInt();
        Task[] tasks = new Task[N];

        for (int i = 0; i < N; i++) {
            long s = fs.nextLong();
            long e = fs.nextLong();
            tasks[i] = new Task(s, e, i + 1);
        }

        // Sort tasks by ending time
        Arrays.sort(tasks, Comparator.comparingLong(t -> t.end));

        List<Task> selected = new ArrayList<>();
        long lastEnd = Long.MIN_VALUE;

        for (Task t : tasks) {
            if (t.start > lastEnd) {   // STRICT condition
                selected.add(t);
                lastEnd = t.end;
            }
        }

        // Output
        StringBuilder sb = new StringBuilder();
        sb.append(selected.size()).append('\n');
        for (Task t : selected) {
            sb.append(t.start).append(" ").append(t.end).append('\n');
        }

        System.out.print(sb.toString());
    }
}