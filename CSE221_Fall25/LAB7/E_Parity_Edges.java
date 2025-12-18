/**
 *    author:  kabir_singh
 *    created: 2025.12.16 20:49:14
 **/
import java.io.*;
import java.util.*;

public class E_Parity_Edges {

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
        int v, parity;
        long dist;
        Node(int v, int parity, long dist) {
            this.v = v;
            this.parity = parity;
            this.dist = dist;
        }
        public int compareTo(Node o) {
            return Long.compare(this.dist, o.dist);
        }
    }

    public static void main(String[] args) throws IOException {

        FastScanner fs = new FastScanner(System.in);

        int N = fs.nextInt();
        int M = fs.nextInt();

        int[] u = new int[M];
        int[] v = new int[M];
        int[] w = new int[M];

        for (int i = 0; i < M; i++) u[i] = fs.nextInt();
        for (int i = 0; i < M; i++) v[i] = fs.nextInt();
        for (int i = 0; i < M; i++) w[i] = fs.nextInt();
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            adj[u[i]].add(new Edge(v[i], w[i]));
        }

        long[][] dist = new long[N + 1][2];
        for (int i = 1; i <= N; i++) {
            dist[i][0] = dist[i][1] = Long.MAX_VALUE;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[1][0] = 0;
        dist[1][1] = 0;
        pq.add(new Node(1, 0, 0));
        pq.add(new Node(1, 1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int node = cur.v;
            int lastParity = cur.parity;

            if (cur.dist > dist[node][lastParity]) continue;

            for (Edge e : adj[node]) {
                int edgeParity = e.wt % 2;

                if (edgeParity != lastParity) {
                    long newDist = dist[node][lastParity] + e.wt;
                    if (newDist < dist[e.to][edgeParity]) {
                        dist[e.to][edgeParity] = newDist;
                        pq.add(new Node(e.to, edgeParity, newDist));
                    }
                }
            }
        }

        long ans = Math.min(dist[N][0], dist[N][1]);

        if (ans == Long.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
}
