
/**
 *    author:  kabir_singh
 *    created: 2025.12.15 20:15:10
 **/
import java.io.*;
import java.util.*;

public class A_Shortest_Path {
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                String line = br.readLine();
                if (line == null)
                    return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    static class Edge {
        int to;
        long wt;

        Edge(int to, long wt) {
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

        int[] u = new int[M];
        int[] v = new int[M];
        int[] w = new int[M];

        for (int i = 0; i < M; i++)
            u[i] = fs.nextInt();
        for (int i = 0; i < M; i++)
            v[i] = fs.nextInt();
        for (int i = 0; i < M; i++)
            w[i] = fs.nextInt();
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            adj[u[i]].add(new Edge(v[i], w[i]));
        }

        long[] dist = new long[N + 1];
        int[] parent = new int[N + 1];

        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(parent, -1);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[S] = 0;
        pq.add(new Node(S, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int node = cur.v;
            long d = cur.dist;

            if (d > dist[node])
                continue;

            for (Edge e : adj[node]) {
                if (dist[node] + e.wt < dist[e.to]) {
                    dist[e.to] = dist[node] + e.wt;
                    parent[e.to] = node;
                    pq.add(new Node(e.to, dist[e.to]));
                }
            }
        }

        if (dist[D] == Long.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(dist[D]);

        ArrayList<Integer> path = new ArrayList<>();
        int cur = D;
        while (cur != -1) {
            path.add(cur);
            cur = parent[cur];
        }
        Collections.reverse(path);

        for (int x : path) {
            System.out.print(x + " ");
        }
    }

}
