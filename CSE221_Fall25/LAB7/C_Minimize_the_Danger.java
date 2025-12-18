/**
 *    author:  kabir_singh
 *    created: 2025.12.18 17:24:07
 **/
import java.io.*;
import java.util.*;

public class C_Minimize_the_Danger {

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    static class Edge {
        int to, wt;
        Edge(int to, int wt) {
            this.to = to;
            this.wt = wt;
        }
    }

    static class Node implements Comparable<Node> {
        int v;
        int danger;
        Node(int v, int danger) {
            this.v = v;
            this.danger = danger;
        }
        public int compareTo(Node o) {
            return Integer.compare(this.danger, o.danger);
        }
    }

    public static void main(String[] args) throws IOException {

        FastScanner fs = new FastScanner(System.in);

        int N = fs.nextInt();
        int M = fs.nextInt();

        ArrayList<Edge>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            int w = fs.nextInt();
            adj[u].add(new Edge(v, w));
            adj[v].add(new Edge(u, w));
        }

        int[] danger = new int[N + 1];
        Arrays.fill(danger, Integer.MAX_VALUE);
        danger[1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int u = cur.v;

            if (cur.danger > danger[u]) continue;

            for (Edge e : adj[u]) {
                int v = e.to;
                int newDanger = Math.max(danger[u], e.wt);

                if (newDanger < danger[v]) {
                    danger[v] = newDanger;
                    pq.add(new Node(v, newDanger));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (danger[i] == Integer.MAX_VALUE)
                sb.append(-1).append(" ");
            else
                sb.append(danger[i]).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
