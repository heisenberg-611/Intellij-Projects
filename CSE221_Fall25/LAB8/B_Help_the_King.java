/**
 *    author:  kabir_singh
 *    created: 2026.01.01 12:07:50
 **/
import java.io.*;
import java.util.*;

public class B_Help_the_King{
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

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

    // -------- DSU --------
    static int[] parent, rank;

    static int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return false;

        if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;
        } else if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
        } else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }
        return true;
    }

    // -------- EDGE CLASS --------
    static class Edge {
        int u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int N = fs.nextInt();
        int M = fs.nextInt();

        Edge[] edges = new Edge[M];

        for (int i = 0; i < M; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            int w = fs.nextInt();
            edges[i] = new Edge(u, v, w);
        }

        // Sort edges by weight
        Arrays.sort(edges, Comparator.comparingInt(e -> e.w));

        parent = new int[N + 1];
        rank = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        long minCost = 0;
        int edgesUsed = 0;

        for (Edge e : edges) {
            if (union(e.u, e.v)) {
                minCost += e.w;
                edgesUsed++;
                if (edgesUsed == N - 1) break;
            }
        }

        System.out.println(minCost);
    }
}