/**
 *    author:  kabir_singh
 *    created: 2026.01.01 12:01:31
 **/
import java.io.*;
import java.util.*;

public class A_Friendship {
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

    // ---------- DSU ARRAYS ----------
    static int[] parent;
    static int[] size;

    // Find with path compression
    static int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    // Union by size
    static int union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            // attach smaller tree under larger tree
            if (size[rootA] < size[rootB]) {
                parent[rootA] = rootB;
                size[rootB] += size[rootA];
                return size[rootB];
            } else {
                parent[rootB] = rootA;
                size[rootA] += size[rootB];
                return size[rootA];
            }
        }
        // already in same friend circle
        return size[rootA];
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int N = fs.nextInt();
        int K = fs.nextInt();

        parent = new int[N + 1];
        size = new int[N + 1];

        // Initialize DSU
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        StringBuilder out = new StringBuilder();

        for (int i = 0; i < K; i++) {
            int a = fs.nextInt();
            int b = fs.nextInt();

            int resultSize = union(a, b);
            out.append(resultSize).append('\n');
        }

        System.out.print(out.toString());
    }
}
