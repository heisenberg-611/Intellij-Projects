/**
 *    author:  kabir_singh
 *    created: 2025.12.18 17:20:46
 **/
import java.io.*;
import java.util.*;

public class B_Where_to_Meet {

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
        long d;
        Node(int v, long d) {
            this.v = v;
            this.d = d;
        }
        public int compareTo(Node o) {
            return Long.compare(this.d, o.d);
        }
    }

    static long[] dijkstra(int start, ArrayList<Edge>[] adj) {

        int n = adj.length - 1;
        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int u = cur.v;

            if (cur.d > dist[u]) continue;

            for (Edge e : adj[u]) {
                int v = e.to;
                if (dist[v] > dist[u] + e.wt) {
                    dist[v] = dist[u] + e.wt;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws IOException {

        FastScanner fs = new FastScanner(System.in);

        int N = fs.nextInt();
        int M = fs.nextInt();
        int S = fs.nextInt();
        int T = fs.nextInt();
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            int w = fs.nextInt();
            adj[u].add(new Edge(v, w));
        }

        long[] distA = dijkstra(S, adj);
        long[] distB = dijkstra(T, adj);

        long ansTime = Long.MAX_VALUE;
        int ansNode = -1;

        for (int i = 1; i <= N; i++) {
            if (distA[i] != Long.MAX_VALUE && distB[i] != Long.MAX_VALUE) {
                long meetTime = Math.max(distA[i], distB[i]);
                if (meetTime < ansTime) {
                    ansTime = meetTime;
                    ansNode = i;
                } else if (meetTime == ansTime && i < ansNode) {
                    ansNode = i;
                }
            }
        }

        if (ansNode == -1) {
            System.out.println(-1);
        } else {
            System.out.println(ansTime + " " + ansNode);
        }
    }
}