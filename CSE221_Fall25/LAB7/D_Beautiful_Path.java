/**
 *    author:  kabir_singh
 *    created: 2025.12.15 20:15:10
 **/
import java.io.*;
import java.util.*;

public class D_Beautiful_Path {

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

    static class Node implements Comparable<Node> {
        int v;
        long cost;
        Node(int v, long cost) {
            this.v = v;
            this.cost = cost;
        }
        public int compareTo(Node o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {

        FastScanner fs = new FastScanner(System.in);

        int N = fs.nextInt();
        int M = fs.nextInt();
        int S = fs.nextInt();
        int D = fs.nextInt();

        int[] weight = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            weight[i] = fs.nextInt();
        }

        ArrayList<Integer>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            adj[u].add(v);
        }

        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[S] = weight[S];
        pq.add(new Node(S, dist[S]));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int u = cur.v;

            if (cur.cost > dist[u]) continue;

            for (int v : adj[u]) {
                long newCost = dist[u] + weight[v];
                if (newCost < dist[v]) {
                    dist[v] = newCost;
                    pq.add(new Node(v, newCost));
                }
            }
        }

        if (dist[D] == Long.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dist[D]);
        }
    }
}
