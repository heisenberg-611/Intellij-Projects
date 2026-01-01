/**
 *    author:  kabir_singh
 *    created: 2026.01.01 12:14:53
 **/
import java.io.*;
import java.util.*;

public class C_Again_MST{
    // ================= EDGE CLASS =================
    static class Edge implements Comparable<Edge> {
        int u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        public int compareTo(Edge other) {
            return Integer.compare(this.w, other.w);
        }
    }

    // ================= DSU =================
    static int[] parent, rank;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return false;

        if (rank[a] < rank[b]) parent[a] = b;
        else if (rank[a] > rank[b]) parent[b] = a;
        else {
            parent[b] = a;
            rank[a]++;
        }
        return true;
    }

    // ================= DFS HELP =================
    static final int NEG = -1000000000;

    // returns {largest, second largest edge on path}
    static int[] dfs(int u, int parentNode, int target, List<int[]>[] tree) {
        if (u == target) return new int[]{NEG, NEG};

        for (int[] edge : tree[u]) {
            int v = edge[0];
            int w = edge[1];

            if (v == parentNode) continue;

            int[] res = dfs(v, u, target, tree);
            if (res != null) {
                int max1 = w;
                int max2 = NEG;

                for (int x : res) {
                    if (x > max1) {
                        max2 = max1;
                        max1 = x;
                    } else if (x > max2) {
                        max2 = x;
                    }
                }
                return new int[]{max1, max2};
            }
        }
        return null;
    }

    // ================= MAIN =================
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int n = fs.nextInt();
        int m = fs.nextInt();

        Edge[] edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            edges[i] = new Edge(fs.nextInt(), fs.nextInt(), fs.nextInt());
        }

        Arrays.sort(edges);

        // DSU init
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        boolean[] used = new boolean[m];
        long mstCost = 0;
        int count = 0;

        // -------- BUILD MST --------
        for (int i = 0; i < m; i++) {
            if (union(edges[i].u, edges[i].v)) {
                used[i] = true;
                mstCost += edges[i].w;
                count++;
            }
        }

        if (count != n - 1) {
            System.out.println(-1);
            return;
        }

        // -------- BUILD MST TREE --------
        List<int[]>[] tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) tree[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            if (used[i]) {
                tree[edges[i].u].add(new int[]{edges[i].v, edges[i].w});
                tree[edges[i].v].add(new int[]{edges[i].u, edges[i].w});
            }
        }

        // -------- FIND SECOND MST --------
        long secondMST = Long.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            if (used[i]) continue;

            int[] pathMax = dfs(edges[i].u, -1, edges[i].v, tree);
            if (pathMax == null) continue;

            int max1 = pathMax[0];
            int max2 = pathMax[1];

            long candidate;
            if (edges[i].w == max1) {
                if (max2 == NEG) continue;
                candidate = mstCost + edges[i].w - max2;
            } else {
                candidate = mstCost + edges[i].w - max1;
            }

            if (candidate > mstCost) {
                secondMST = Math.min(secondMST, candidate);
            }
        }

        System.out.println(secondMST == Long.MAX_VALUE ? -1 : secondMST);
    }

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
    }
}