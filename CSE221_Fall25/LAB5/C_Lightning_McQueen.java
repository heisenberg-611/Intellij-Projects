/**
 *    author:  kabir_singh
 *    created: 2025.12.05 11:02:12
 **/
import java.io.*;
import java.util.*;
public class C_Lightning_McQueen {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        // Read first line
        String firstLine = br.readLine();
        if (firstLine == null) {
            pw.println(-1);
            pw.close();
            return;
        }
        StringTokenizer st = new StringTokenizer(firstLine);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        // Only read & parse edge lines if M > 0
        if (M > 0) {
            String lineU = br.readLine();
            String lineV = br.readLine();

            // Safety: should not be null per problem, but defend anyway
            if (lineU == null) lineU = "";
            if (lineV == null) lineV = "";

            st = new StringTokenizer(lineU);
            int[] uArr = new int[M];
            for (int i = 0; i < M; i++) {
                uArr[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(lineV);
            int[] vArr = new int[M];
            for (int i = 0; i < M; i++) {
                vArr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < M; i++) {
                int u = uArr[i], v = vArr[i];
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
        }
        // If M == 0, skip reading entirely — no edges to process

        // Sort neighbors for lexicographic BFS
        for (int i = 1; i <= N; i++) {
            Collections.sort(adj.get(i));
        }

        // BFS for shortest + lexicographically smallest path
        int[] dist = new int[N + 1];
        int[] parent = new int[N + 1];
        Arrays.fill(dist, -1);
        Arrays.fill(parent, -1);

        Queue<Integer> q = new ArrayDeque<>();
        dist[S] = 0;
        parent[S] = -1;
        q.offer(S);

        while (!q.isEmpty()) {
            int u = q.poll();
            if (u == D) break;
            for (int v : adj.get(u)) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    parent[v] = u;
                    q.offer(v);
                }
            }
        }

        if (dist[D] == -1) {
            pw.println(-1);
        } else {
            // Reconstruct path
            ArrayList<Integer> path = new ArrayList<>();
            for (int cur = D; cur != -1; cur = parent[cur]) {
                path.add(cur);
            }
            Collections.reverse(path);

            pw.println(dist[D]);
            for (int i = 0; i < path.size(); i++) {
                if (i > 0) pw.print(" ");
                pw.print(path.get(i));
            }
            pw.println();
        }

        pw.flush();
        br.close();
        pw.close();
    }
}