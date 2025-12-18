/**
 *    author:  kabir_singh
 *    created: 2025.12.17 23:10:49
 **/
import java.io.*;
import java.util.*;

public class F_Shortest_Path_Revisited {

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
        long dist;
        Node(int v, long dist) {
            this.v = v;
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
        int S = fs.nextInt();
        int D = fs.nextInt();
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            int w = fs.nextInt();
            adj[u].add(new Edge(v, w));
            adj[v].add(new Edge(u, w));
        }

        long[] dist1 = new long[N + 1];
        long[] dist2 = new long[N + 1];

        Arrays.fill(dist1, Long.MAX_VALUE);
        Arrays.fill(dist2, Long.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist1[S] = 0;
        pq.add(new Node(S, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int u = cur.v;
            long d = cur.dist;

            for (Edge e : adj[u]) {
                long newDist = d + e.wt;

                if (newDist < dist1[e.to]) {
                    dist2[e.to] = dist1[e.to];
                    dist1[e.to] = newDist;
                    pq.add(new Node(e.to, newDist));
                }
                else if (newDist > dist1[e.to] && newDist < dist2[e.to]) {
                    dist2[e.to] = newDist;
                    pq.add(new Node(e.to, newDist));
                }
            }
        }

        if (dist2[D] == Long.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dist2[D]);
        }
    }
}
