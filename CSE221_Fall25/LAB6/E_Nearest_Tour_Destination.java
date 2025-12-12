/**
 *    author:  kabir_singh
 *    created: 2025.12.12 12:54:04
 **/
import java.io.*;
import java.util.*;

public class E_Nearest_Tour_Destination {
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

        int N = fs.nextInt();
        int M = fs.nextInt();
        int S = fs.nextInt();
        int Q = fs.nextInt();

        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; ++i) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; ++i) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        int[] sources = new int[S];
        for (int i = 0; i < S; ++i) sources[i] = fs.nextInt();

        int[] dests = new int[Q];
        for (int i = 0; i < Q; ++i) dests[i] = fs.nextInt();

        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);

        ArrayDeque<Integer> dq = new ArrayDeque<>();

        for (int s : sources) {
            if (dist[s] == -1) {
                dist[s] = 0;
                dq.addLast(s);
            }
        }

        while (!dq.isEmpty()) {
            int u = dq.removeFirst();
            for (int v : graph[u]) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    dq.addLast(v);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; ++i) {
            if (i > 0) sb.append(' ');
            sb.append(dist[dests[i]]);
        }
        sb.append('\n');

        System.out.print(sb.toString());
    }
}
