/**
 *    author:  kabir_singh
 *    created: 2026.01.01 12:39:08
 **/
import java.io.*;
import java.util.*;
public class E_Task_Selection_II{
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
        int T = fs.nextInt();

        while (T-- > 0) {
            int N = fs.nextInt();
            int M = fs.nextInt();

            long[][] tasks = new long[N][2];
            for (int i = 0; i < N; i++) {
                tasks[i][0] = fs.nextLong();
                tasks[i][1] = fs.nextLong();
            }

            // Sort by end time
            Arrays.sort(tasks, Comparator.comparingLong(a -> a[1]));

            // endTime -> count of people ending there
            TreeMap<Long, Integer> busy = new TreeMap<>();
            int busyPeople = 0;
            int completed = 0;

            for (int i = 0; i < N; i++) {
                long start = tasks[i][0];
                long end = tasks[i][1];

                // Find a person who finishes STRICTLY before start
                Long freeTime = busy.lowerKey(start);

                if (freeTime != null) {
                    // reuse person
                    decrement(busy, freeTime);
                    busy.merge(end, 1, Integer::sum);
                    completed++;
                } else if (busyPeople < M) {
                    // assign new person
                    busy.merge(end, 1, Integer::sum);
                    busyPeople++;
                    completed++;
                }
            }

            System.out.println(completed);
        }
    }

    static void decrement(TreeMap<Long, Integer> map, long key) {
        int c = map.get(key);
        if (c == 1) map.remove(key);
        else map.put(key, c - 1);
    }
}