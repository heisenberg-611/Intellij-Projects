/**
 *    author:  kabir_singh
 *    created: 2025.12.12 11:40:00
 **/
import java.io.*;
import java.util.*;

public class G_An_Ancient_Ordering {
    static class FastScanner {
        private final BufferedReader br;
        private StringTokenizer st;

        FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        final int size = 26;
        boolean[] present = new boolean[size];
        @SuppressWarnings("unchecked")
        List<Integer>[] graph = new ArrayList[size];
        for (int i = 0; i < size; i++) graph[i] = new ArrayList<>();
        int[] indegree = new int[size];
        boolean[][] added = new boolean[size][size];

        int n = Integer.parseInt(fs.next()); // number of words
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = fs.next();
            for (char c : words[i].toCharArray()) present[c - 'a'] = true;
        }

        boolean invalid = false;
        for (int i = 0; i < n - 1 && !invalid; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                invalid = true;
                break;
            }
            int len = Math.min(w1.length(), w2.length());
            for (int j = 0; j < len; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    int u = w1.charAt(j) - 'a';
                    int v = w2.charAt(j) - 'a';
                    if (!added[u][v]) {
                        graph[u].add(v);
                        indegree[v]++;
                        added[u][v] = true;
                    }
                    break;
                }
            }
        }

        if (invalid) {
            System.out.println("-1");
            return;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int presentCount = 0;
        for (int i = 0; i < size; i++) {
            if (present[i]) {
                presentCount++;
                if (indegree[i] == 0) pq.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int u = pq.poll();
            sb.append((char) (u + 'a'));
            for (int v : graph[u]) {
                indegree[v]--;
                if (indegree[v] == 0) pq.add(v);
            }
        }

        if (sb.length() == presentCount) {
            System.out.println(sb.toString());
        } else {
            System.out.println("-1");
        }
    }
}
